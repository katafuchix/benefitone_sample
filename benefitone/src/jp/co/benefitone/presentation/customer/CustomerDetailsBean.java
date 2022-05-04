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
 * �ڋq���ڍו\���̂��߂� BackingBean �ł��B
 * @author Hiroshi Kajisha
 * @version $Revision: 1.1.1.1 $
 */
public class CustomerDetailsBean extends BaseBean {
    /**
     * �ڋq��񌟍��T�[�r�X
     */
    private CustomerFindService customerFindService;

    /**
     * �ڍו\�����Ă���ڋq���
     */
    private CustomerVO selectedCustomer;

    /**
     * @return selectedCustomer ��Ԃ��܂��B
     */
    public CustomerVO getSelectedCustomer() {
        return selectedCustomer;
    }

    /**
     * @param customer selectedCustomer ��ݒ肵�܂��B
     */
    public void setSelectedCustomer(CustomerVO customer) {
        this.selectedCustomer = customer;
    }

    /**
     * @return service ��Ԃ��܂��B
     */
    public CustomerFindService getCustomerFindService() {
        return customerFindService;
    }

    /**
     * @param service service ��ݒ肵�܂��B
     */
    public void setCustomerFindService(CustomerFindService service) {
        this.customerFindService = service;
    }

    /**
     * �ڍו\�����Ă���ڋqID����A�ŐV�̏����f�[�^�x�[�X����
     * �擾���܂��B�擾�����ڋq���́A�ҏW���邽�߂ɃZ�b�V����
     * �ŊǗ����܂��B
     * @return <code>success</code> �ҏW��ʂ̑J�ځB
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
