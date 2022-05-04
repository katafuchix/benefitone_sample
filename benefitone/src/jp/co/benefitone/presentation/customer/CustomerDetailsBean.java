/* ======================================================================
 * $Id: CustomerDetailsBean.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 * Hiroshi Kajisha
 * 2005/04/12
 * Originator: Hiroshi.Kajisha@Sun.COM
 * OriginDate: 2005/04/12
 * ======================================================================
 */
package jp.co.benefitone.presentation.customer;

import jp.co.benefitone.business.customer.CustomerFindService;
import jp.co.benefitone.model.customer.CustomerVO;

/**
 * 顧客情報詳細表示のための BackingBean です。
 * @author Hiroshi Kajisha
 * @version $Revision: 1.1.1.1 $
 */
public class CustomerDetailsBean extends BaseBean {
    /**
     * 顧客情報検索サービス
     */
    private CustomerFindService customerFindService;

    /**
     * 詳細表示している顧客情報
     */
    private CustomerVO selectedCustomer;

    /**
     * @return selectedCustomer を返します。
     */
    public CustomerVO getSelectedCustomer() {
        return selectedCustomer;
    }

    /**
     * @param customer selectedCustomer を設定します。
     */
    public void setSelectedCustomer(CustomerVO customer) {
        this.selectedCustomer = customer;
    }

    /**
     * @return service を返します。
     */
    public CustomerFindService getCustomerFindService() {
        return customerFindService;
    }

    /**
     * @param service service を設定します。
     */
    public void setCustomerFindService(CustomerFindService service) {
        this.customerFindService = service;
    }

    /**
     * 詳細表示している顧客IDから、最新の情報をデータベースから
     * 取得します。取得した顧客情報は、編集するためにセッション
     * で管理します。
     * @return <code>success</code> 編集画面の遷移。
     */
    public String modify() {
        try {
            Integer id = selectedCustomer.getId();
            CustomerVO customer = customerFindService.selectCustomer(id);
            getSessionMap().put("tmpCustomer", customer);
            return "success";
        }
        catch (Exception e) {
            return getErrorHandlerBean().forward(e);
        }
    }
}
