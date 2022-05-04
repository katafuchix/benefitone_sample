/* ======================================================================
 *  $Id: CustomerManageService.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 *    tkakeda
 *      2005/04/05
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/05
 * ======================================================================
 */
package jp.co.benefitone.business.customer;

import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import jp.co.benefitone.model.customer.CustomerVO;

/**
 * 顧客情報管理サービスインターフェース。
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author first last, Sun Microsystems K.K.
 */
public interface CustomerManageService {

    /**
     * 顧客情報を削除します。
     * @param id 顧客ID
     * @param criteria 検索条件
     * @param session セッション情報
     * @return 検索結果オブジェクト
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="manager"
     */
    FindCustomerResult deleteCustomer(Integer id, FindCustomerCriteria criteria, BusinessSession session);

    /**
     * 顧客を保存します。
     * @param customer 顧客VO
     * @param session セッション情報
     * @return 保存後の顧客検索結果
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="manager"
     */
    FindCustomerResult saveCustomer(CustomerVO customer, BusinessSession session);

    /**
     * 顧客情報のサニタイズを行います。
     *
     * @param customer 入力された顧客情報
     * @return サニタイズされた顧客情報
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="manager"
     */
    CustomerVO sanitizeCustomer(CustomerVO customer);
}
