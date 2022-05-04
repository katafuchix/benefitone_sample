/* ======================================================================
 *  $Id: CustomerDAOImpl.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 *    tkakeda
 *      2005/04/05
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/05
 * ======================================================================
 */
package jp.co.benefitone.integration.customer;

import java.util.List;

import jp.co.benefitone.common.fw.integration.DatabaseRuntimeException;
import jp.co.benefitone.common.fw.integration.HibernateUtil;
import jp.co.benefitone.model.customer.CompanyVO;
import jp.co.benefitone.model.customer.CustomerVO;
import jp.co.benefitone.model.customer.DepartmentVO;
import net.sf.hibernate.Criteria;
import net.sf.hibernate.FetchMode;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.MatchMode;
import net.sf.hibernate.expression.Order;

/**
 * 顧客DAO実装クラスです。
 * 今回はHibernateのHQLではなく、Criteriaで検索を実装しました。
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CustomerDAOImpl implements CustomerDAO {

    /** セッションファクトリオブジェクト */
    private SessionFactory sessionFactory;

    /**
     * SessionFactoryを設定します。
     * テストでは手動、実行時ではSpringFrameworkによりWiringされます。
     *
     * @param sessionFactory セッションファクトリオブジェクト
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * セッションファクトリを返します。
     * @return セッションファクトリ
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * 顧客情報を検索してCustomerVOのリストを返します。
     * 検索条件は引数以下の３つになります。条件はそれぞれAND検索
     * となり、部分一致にで対象情報をデータベースより取得します。
     *
     * @param customerName 顧客名の一部
     * @param departmentName 部署名の一部
     * @param companyName 会社名の一部
     * @return CustomerVOオブジェクトのリストを返す
     *         検索結果が0件の場合は空のリストを返す
     * @throws DatabaseRuntimeException データベース例外
     */
    public List find(String customerName,
                     String departmentName,
                     String companyName) {
        Session session = null;
        try {
            session = HibernateUtil.getSession(sessionFactory);
            Criteria criteria = createCriteria(session)
                                .setFetchMode("department", FetchMode.EAGER)
                                .setFetchMode("company", FetchMode.EAGER);

            boolean hasCustomerName = customerName != null && !customerName.equals("");
            boolean hasDeptName = departmentName != null && !departmentName.equals("");
            boolean hasCompanyName = companyName != null && !companyName.equals("");

            if (hasCustomerName) {
                criteria.add(Expression.or(
                        Expression.ilike("name.firstName", customerName,
                            MatchMode.ANYWHERE),
                        Expression.ilike("name.lastName", customerName,
                            MatchMode.ANYWHERE)));
            }

            if (hasDeptName) {
                criteria.createAlias("department", "department")
                    .add(Expression.ilike("department.name", departmentName,
                        MatchMode.ANYWHERE));
            }

            if (hasCompanyName) {
                criteria.createAlias("company", "company")
                    .add(Expression.ilike("company.name", companyName,
                        MatchMode.ANYWHERE));
            }

            criteria.addOrder(Order.asc("id"));
            return criteria.list();
        }
        catch (HibernateException e) {
            throw new DatabaseRuntimeException(e);
        }
        finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 検索条件を作成します。
     * @param session セッションオブジェクト
     * @return 検索条件オブジェクト
     */
    protected Criteria createCriteria(Session session) {
        return session.createCriteria(CustomerVO.class);
    }

    /**
     * 指定された顧客IDの顧客情報を削除します。
     * @param id 顧客ID
     */
    public void delete(Integer id) {
        Session session = null;
        try {
            session = HibernateUtil.getSession(this.sessionFactory);
            session.delete("from CustomerVO where id = ?",
                           id,
                           Hibernate.INTEGER);
            session.flush();
        }
        catch (HibernateException e) {
            throw new DatabaseRuntimeException(e);
        }
        finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 顧客情報１件を読み込みます。
     * 存在しない場合はnullを返します。
     *
     * @param id 顧客ID
     * @return CustomerVOオブジェクト（存在しない場合はnull)
     * @exception DatabaseRuntimeException データベース例外時
     */
    public CustomerVO select(final Integer id) {
        Session session = null;
        try {
            session = HibernateUtil.getSession(this.sessionFactory);
            return (CustomerVO) session.get(CustomerVO.class, id);
        }
        catch (HibernateException e) {
            throw new DatabaseRuntimeException(e);
        }
        finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 会社情報を会社名の完全一致で検索します。
     *
     * @param name 会社名
     * @return 会社情報が見付からない場合は、<code>null</code>を返します。
     */
    public CompanyVO selectCompanyByName(String name) {
        Session session = null;
        try {
            session = HibernateUtil.getSession(this.sessionFactory);
            return (CompanyVO) session.createCriteria(CompanyVO.class)
                                    .add(Expression.eq("name", name))
                                    .uniqueResult();
        }
        catch (HibernateException e) {
            throw new DatabaseRuntimeException(e);
        }
        finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 部署情報を部署名の完全一致で検索します。
     *
     * @param name 部署名
     * @param companyId 会社ID
     * @return 部署情報が見付からない場合は、<code>null</code>を返します。
     */
    public DepartmentVO selectDepartmentByNameAndCompanyId(String name,
                                                           Integer companyId) {
        Session session = null;
        try {
            session = HibernateUtil.getSession(this.sessionFactory);
            return (DepartmentVO) session.createCriteria(DepartmentVO.class)
                                    .createAlias("company", "company")
                                    .add(Expression.eq("name", name))
                                    .add(Expression.eq("company.id", companyId))
                                    .uniqueResult();
        }
        catch (HibernateException e) {
            throw new DatabaseRuntimeException(e);
        }
        finally {
            HibernateUtil.closeSession(session);
        }
    }

    /**
     * 顧客情報を1件保存します。
     * 新規の場合は追加、既存の場合は更新で保存します。
     * @param customer 顧客情報
     */
    public void save(CustomerVO customer) {
        Session session = HibernateUtil.getSession(this.sessionFactory);
        try {
            session.saveOrUpdate(customer);
            session.flush();
        }
        catch (HibernateException e) {
            throw new DatabaseRuntimeException(e);
        }
        finally {
            HibernateUtil.closeSession(session);
        }
    }
}
