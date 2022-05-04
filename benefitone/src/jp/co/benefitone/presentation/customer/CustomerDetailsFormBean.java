/* ======================================================================
 * $Id: CustomerDetailsFormBean.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 * Hiroshi Kajisha
 * 2005/04/14
 * Originator: Hiroshi.Kajisha@Sun.COM
 * OriginDate: 2005/04/14
 * ======================================================================
 */
package jp.co.benefitone.presentation.customer;

import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import jp.co.benefitone.common.fw.web.WebBusinessSessionFactoryBean;

import jp.co.benefitone.business.customer.CustomerManageService;
import jp.co.benefitone.business.customer.FindCustomerResult;
import jp.co.benefitone.model.customer.CustomerVO;

/**
 * 顧客情報の編集画面用のバッキングビーンです。
 * @author Hiroshi Kajisha
 * @version $Revision: 1.1.1.1 $
 */
public class CustomerDetailsFormBean extends BaseBean {
    /**
     * 編集中の顧客情報
     */
    private CustomerVO tmpCustomer;

    /**
     * 顧客一覧のBean.
     */
    private CustomerListBean customerListBean;

    /**
     * <code>BusinessSession</code> ファクトリ
     */
    private WebBusinessSessionFactoryBean businessSessionFactoryBean;

    /**
     * 顧客管理サービス
     */
    private CustomerManageService customerManageService;

    /**
     * @return customerManageService を返します。
     */
    public CustomerManageService getCustomerManageService() {
        return customerManageService;
    }

    /**
     * @param customerManageService customerManageService を設定します。
     */
    public void setCustomerManageService(
            CustomerManageService customerManageService) {
        this.customerManageService = customerManageService;
    }

    /**
     * @param customerListBean customerListBean を設定します。
     */
    public void setCustomerListBean(
            CustomerListBean customerListBean) {
        this.customerListBean = customerListBean;
    }

    /**
     * @return tmpCustomer を返します。
     */
    public CustomerVO getTmpCustomer() {
        return tmpCustomer;
    }

    /**
     * @param tmpCustomer tmpCustomer を設定します。
     */
    public void setTmpCustomer(CustomerVO tmpCustomer) {
        this.tmpCustomer = tmpCustomer;
    }

    /**
     * @return businessSessionFactoryBean を返します。
     */
    public WebBusinessSessionFactoryBean getBusinessSessionFactoryBean() {
        return businessSessionFactoryBean;
    }

    /**
     * @param businessSessionFactoryBean businessSessionFactoryBean を設定します
     */
    public void setBusinessSessionFactoryBean(
            WebBusinessSessionFactoryBean businessSessionFactoryBean) {
        this.businessSessionFactoryBean = businessSessionFactoryBean;
    }

    /**
     * 編集画面から確認画面に遷移します。
     * @return <code>success</code> 確認画面に遷移します。
     */
    public String confirm() {
        try {
            CustomerVO customer =
                customerManageService.sanitizeCustomer(tmpCustomer);
            getSessionMap().put("tmpCustomer", customer);
            return "success";
        }
        catch (Exception e) {
            return getErrorHandlerBean().forward(e);
        }
    }

    /**
     * 編集された顧客情報を保存します。
     * @return <code>success</code> 検索画面に遷移します。
     */
    public String save() {
        try {
            FindCustomerResult result =
                customerManageService.saveCustomer(
                        tmpCustomer, createBusinessSession());

            customerListBean.setCustomerList(result.getResult());
            return "success";
        }
        catch (Exception e) {
            return getErrorHandlerBean().forward(e);
        }
    }

    /**
     * @return <code>BusinessSession</code> オブジェクトを返します。
     */
    private BusinessSession createBusinessSession() {
        BusinessSession businessSession =
            businessSessionFactoryBean.create();
        return businessSession;
    }
}
