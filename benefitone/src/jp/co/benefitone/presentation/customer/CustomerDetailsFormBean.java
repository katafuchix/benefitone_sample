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
 * �ڋq���̕ҏW��ʗp�̃o�b�L���O�r�[���ł��B
 * @author Hiroshi Kajisha
 * @version $Revision: 1.1.1.1 $
 */
public class CustomerDetailsFormBean extends BaseBean {
    /**
     * �ҏW���̌ڋq���
     */
    private CustomerVO tmpCustomer;

    /**
     * �ڋq�ꗗ��Bean.
     */
    private CustomerListBean customerListBean;

    /**
     * <code>BusinessSession</code> �t�@�N�g��
     */
    private WebBusinessSessionFactoryBean businessSessionFactoryBean;

    /**
     * �ڋq�Ǘ��T�[�r�X
     */
    private CustomerManageService customerManageService;

    /**
     * @return customerManageService ��Ԃ��܂��B
     */
    public CustomerManageService getCustomerManageService() {
        return customerManageService;
    }

    /**
     * @param customerManageService customerManageService ��ݒ肵�܂��B
     */
    public void setCustomerManageService(
            CustomerManageService customerManageService) {
        this.customerManageService = customerManageService;
    }

    /**
     * @param customerListBean customerListBean ��ݒ肵�܂��B
     */
    public void setCustomerListBean(
            CustomerListBean customerListBean) {
        this.customerListBean = customerListBean;
    }

    /**
     * @return tmpCustomer ��Ԃ��܂��B
     */
    public CustomerVO getTmpCustomer() {
        return tmpCustomer;
    }

    /**
     * @param tmpCustomer tmpCustomer ��ݒ肵�܂��B
     */
    public void setTmpCustomer(CustomerVO tmpCustomer) {
        this.tmpCustomer = tmpCustomer;
    }

    /**
     * @return businessSessionFactoryBean ��Ԃ��܂��B
     */
    public WebBusinessSessionFactoryBean getBusinessSessionFactoryBean() {
        return businessSessionFactoryBean;
    }

    /**
     * @param businessSessionFactoryBean businessSessionFactoryBean ��ݒ肵�܂�
     */
    public void setBusinessSessionFactoryBean(
            WebBusinessSessionFactoryBean businessSessionFactoryBean) {
        this.businessSessionFactoryBean = businessSessionFactoryBean;
    }

    /**
     * �ҏW��ʂ���m�F��ʂɑJ�ڂ��܂��B
     * @return <code>success</code> �m�F��ʂɑJ�ڂ��܂��B
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
     * �ҏW���ꂽ�ڋq����ۑ����܂��B
     * @return <code>success</code> ������ʂɑJ�ڂ��܂��B
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
     * @return <code>BusinessSession</code> �I�u�W�F�N�g��Ԃ��܂��B
     */
    private BusinessSession createBusinessSession() {
        BusinessSession businessSession =
            businessSessionFactoryBean.create();
        return businessSession;
    }
}
