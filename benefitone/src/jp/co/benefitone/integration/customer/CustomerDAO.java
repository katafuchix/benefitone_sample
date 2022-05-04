/* ======================================================================
 *  $Id: CustomerDAO.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 *    tkakeda
 *      2005/04/05
 * Originator: first.last@Sun.COM
 * OriginDate: 2005/MM/dd
 * ======================================================================
 */
package jp.co.benefitone.integration.customer;

import java.util.List;

import jp.co.benefitone.model.customer.CompanyVO;
import jp.co.benefitone.model.customer.CustomerVO;
import jp.co.benefitone.model.customer.DepartmentVO;

/**
 * 顧客DAOインターフェース。
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author first last, Sun Microsystems K.K.
 */
public interface CustomerDAO {

    /**
     * 顧客情報を検索します。
     * @param customerName 顧客名
     * @param departmentName 部署名
     * @param companyName 会社名
     * @return CustomerVOオブジェクトのリスト
     */
    List find(String customerName,
              String departmentName,
              String companyName);

    /**
     * 顧客IDで指定される顧客情報を1件削除します。
     *
     * @param id 顧客ID
     */
    void delete(Integer id);

    /**
     * 顧客IDにより顧客情報を検索します。
     *
     * @param id 顧客ID
     * @return 指定された ID を持つ顧客情報を返します。
     *         見付からない場合は、<code>null</code>を返します。
     */
    CustomerVO select(Integer id);

    /**
     * 会社情報を会社名の完全一致で検索します。
     *
     * @param name 会社名
     * @return 会社情報が見付からない場合は、<code>null</code>を返します。
     */
    CompanyVO selectCompanyByName(String name);

    /**
     * 部署情報を部署名の完全一致で検索します。
     *
     * @param name 部署名
     * @param companyId 会社ID
     * @return 部署情報が見付からない場合は、<code>null</code>を返します。
     */
    DepartmentVO selectDepartmentByNameAndCompanyId(String name,
                                                    Integer companyId);

    /**
     * 顧客情報を1件保存します。
     * 新規の場合は追加、既存の場合は更新で保存します。
     * @param customer 顧客情報
     */
    void save(CustomerVO customer);
}
