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
 * �ڋqDAO�����N���X�ł��B
 * �����Hibernate��HQL�ł͂Ȃ��ACriteria�Ō������������܂����B
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CustomerDAOImpl implements CustomerDAO {

    /** �Z�b�V�����t�@�N�g���I�u�W�F�N�g */
    private SessionFactory sessionFactory;

    /**
     * SessionFactory��ݒ肵�܂��B
     * �e�X�g�ł͎蓮�A���s���ł�SpringFramework�ɂ��Wiring����܂��B
     *
     * @param sessionFactory �Z�b�V�����t�@�N�g���I�u�W�F�N�g
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * �Z�b�V�����t�@�N�g����Ԃ��܂��B
     * @return �Z�b�V�����t�@�N�g��
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * �ڋq������������CustomerVO�̃��X�g��Ԃ��܂��B
     * ���������͈����ȉ��̂R�ɂȂ�܂��B�����͂��ꂼ��AND����
     * �ƂȂ�A������v�ɂőΏۏ����f�[�^�x�[�X���擾���܂��B
     *
     * @param customerName �ڋq���̈ꕔ
     * @param departmentName �������̈ꕔ
     * @param companyName ��Ж��̈ꕔ
     * @return CustomerVO�I�u�W�F�N�g�̃��X�g��Ԃ�
     *         �������ʂ�0���̏ꍇ�͋�̃��X�g��Ԃ�
     * @throws DatabaseRuntimeException �f�[�^�x�[�X��O
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
     * �����������쐬���܂��B
     * @param session �Z�b�V�����I�u�W�F�N�g
     * @return ���������I�u�W�F�N�g
     */
    protected Criteria createCriteria(Session session) {
        return session.createCriteria(CustomerVO.class);
    }

    /**
     * �w�肳�ꂽ�ڋqID�̌ڋq�����폜���܂��B
     * @param id �ڋqID
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
     * �ڋq���P����ǂݍ��݂܂��B
     * ���݂��Ȃ��ꍇ��null��Ԃ��܂��B
     *
     * @param id �ڋqID
     * @return CustomerVO�I�u�W�F�N�g�i���݂��Ȃ��ꍇ��null)
     * @exception DatabaseRuntimeException �f�[�^�x�[�X��O��
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
     * ��Џ�����Ж��̊��S��v�Ō������܂��B
     *
     * @param name ��Ж�
     * @return ��Џ�񂪌��t����Ȃ��ꍇ�́A<code>null</code>��Ԃ��܂��B
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
     * �������𕔏����̊��S��v�Ō������܂��B
     *
     * @param name ������
     * @param companyId ���ID
     * @return ������񂪌��t����Ȃ��ꍇ�́A<code>null</code>��Ԃ��܂��B
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
     * �ڋq����1���ۑ����܂��B
     * �V�K�̏ꍇ�͒ǉ��A�����̏ꍇ�͍X�V�ŕۑ����܂��B
     * @param customer �ڋq���
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
