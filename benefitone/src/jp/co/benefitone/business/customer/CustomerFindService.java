/* ======================================================================
 * $Id: CustomerFindService.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 * tkakeda
 * 2005/04/05
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/MM/dd
 * ======================================================================
 */
package jp.co.benefitone.business.customer;

import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import jp.co.benefitone.model.customer.CustomerVO;

/**
 * 顧客検索サービスインターフェース。
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public interface CustomerFindService {
    /**
     * 顧客をIDにより検索します。
     * 一件検索。
     * @param id 顧客ID
     * @return CustomerVOオブジェクト
     * @ejb.transaction type="Required"
     * @ejb.permission unchecked="true"
     */
    CustomerVO selectCustomer(Integer id);

    /**
     * セッション情報から顧客情報を検索します。
     * @param criteria 検索条件
     * @param session ビジネスセッション
     * @return 検索条件に一致した顧客情報の一覧を返します。
     * @ejb.transaction type="Required"
     * @ejb.permission unchecked="true"
     */
    FindCustomerResult findCustomer(FindCustomerCriteria criteria,
                                    BusinessSession session);
}
