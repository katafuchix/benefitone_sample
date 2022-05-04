/* ======================================================================
 * $Id: CustomerListBean.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 * Hiroshi Kajisha
 * 2005/04/11
 * Originator: Hiroshi.Kajisha@Sun.COM
 * OriginDate: 2005/04/11
 * ======================================================================
 */
package jp.co.benefitone.presentation.customer;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import jp.co.benefitone.business.customer.CustomerFindService;
import jp.co.benefitone.business.customer.CustomerManageService;
import jp.co.benefitone.business.customer.FindCustomerCriteria;
import jp.co.benefitone.business.customer.FindCustomerResult;
import jp.co.benefitone.model.customer.CustomerVO;
import jp.co.benefitone.model.customer.CustomerNameVO;
import jp.co.benefitone.model.customer.CompanyVO;
import jp.co.benefitone.model.customer.DepartmentVO;
import jp.co.benefitone.common.fw.web.WebBusinessSessionFactoryBean;


/**
 * �ڋq���̈ꗗ���擾���邽�߂� BackingBean �ł��B
 * @author Hiroshi Kajisha
 * @version $Revision: 1.1.1.1 $
 */
public class CustomerListBean extends BaseBean {
    /**
     * �ڋq��񌟍��T�[�r�X�B
     */
    private CustomerFindService customerFindService;

    /**
     * �ڋq���Ǘ��T�[�r�X�B
     */
    private CustomerManageService customerManageService;

    /**
     * �ڋq���̈ꗗ�B
     */
    private List customerList;

    /**
     * �f�[�^���f��
     */
    private DataModel customerModel = new ListDataModel();

    /**
     * ��������
     */
    private FindCustomerCriteria findCustomerCriteria;

    /**
     * <code>BusinessSession</code>�̃t�@�N�g��
     */
    private WebBusinessSessionFactoryBean businessSessionFactoryBean;

    /**
     * @return findCustomerCriteria ��Ԃ��܂��B
     */
    public FindCustomerCriteria getFindCustomerCriteria() {
        return findCustomerCriteria;
    }

    /**
     * @param findCustomerCriteria findCustomerCriteria ��ݒ肵�܂��B
     */
    public void setFindCustomerCriteria(
            FindCustomerCriteria findCustomerCriteria) {
        this.findCustomerCriteria = findCustomerCriteria;
    }

    /**
     * @return sessionFactory ��Ԃ��܂��B
     */
    public WebBusinessSessionFactoryBean getBusinessSessionFactoryBean() {
        return businessSessionFactoryBean;
    }

    /**
     * @param sessionFactory sessionFactory ��ݒ肵�܂��B
     */
    public void setBusinessSessionFactoryBean(
            WebBusinessSessionFactoryBean sessionFactory) {
        this.businessSessionFactoryBean = sessionFactory;
    }

    /**
     * �f�[�^���f����Ԃ��܂��B
     * @return customerModel ��Ԃ��܂��B
     */
    public DataModel getCustomerModel() {
        customerModel.setWrappedData(getCustomerList());
        return customerModel;
    }

    /**
     * @return customerList ��Ԃ��܂��B
     */
    public List getCustomerList() {
        return customerList;
    }

    /**
     * @param customerList customerList ��ݒ肵�܂��B
     */
    public void setCustomerList(List customerList) {
        this.customerList = customerList;
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
     * �����{�^�����������ꂽ�ꍇ�̃A�N�V�������L�q���܂��B
     *
     * @return <code>success</code> ���������������ꍇ�A�Ăяo�����̉�ʂ�
     *                              �J�ڂ��܂��B
     */
    public String find() {
        try {
            BusinessSession session = businessSessionFactoryBean.create();
            FindCustomerResult result = customerFindService.findCustomer(
                                                findCustomerCriteria,
                                                session);
            this.customerList = result.getResult();
            return "success";
        }
        catch (Exception e) {
            return getErrorHandlerBean().forward(e);
        }
    }

    /**
     * �I�𒆂̌ڋq�����������܂��B
     * @return <code>success</code> �ďo�����̉�ʂɑJ�ڂ��܂��B
     */
    public String select() {
        try {
            CustomerVO rowCustomer =
                (CustomerVO) customerModel.getRowData();

            CustomerVO customer = customerFindService.selectCustomer(
                                        rowCustomer.getId());
            getSessionMap().put("selectedCustomer", customer);
            return "success";
        }
        catch (Exception e) {
            return getErrorHandlerBean().forward(e);
        }
    }

    /**
     * �w�肳�ꂽ�ڋq�����폜���A�O��̌��������ōēx�������܂��B
     * @return <code>success</code> �폜�����������ꍇ�A�ďo�����̉�ʂ�
     *                              �J�ڂ��܂��B
     */
    public String delete() {
        try {
            CustomerVO selectedCustomer =
                (CustomerVO) customerModel.getRowData();
            BusinessSession businessSession =
                businessSessionFactoryBean.create();
            FindCustomerResult result =
                customerManageService.deleteCustomer(selectedCustomer.getId(),
                                                     findCustomerCriteria,
                                                     businessSession);
            this.customerList = result.getResult();
            return "success";
        }
        catch (Exception e) {
            return getErrorHandlerBean().forward(e);
        }
    }

    /**
     * �V�K�ڋq�����͂̂��߂ɁA�Z�b�V�������ɓo�^����Ă���
     * <code>tmpCustomer</code> �����Z�b�g���܂��B
     * �����A���[�U���Ǘ��Ҍ����������Ȃ��ꍇ�́A�Z�L�����e�B�G���[
     * �y�[�W�ɑJ�ڂ��܂��B
     *
     * @return <code>success</code> �ڋq���ҏW��ʂɑJ�ڂ��܂��B
     */
    public String create() {
        try {
            // ���ӁF�ʏ�A�ȉ��̂悤�Ƀ��[���E�`�F�b�N�̃R�[�h���A�N�V�����E
            // ���\�b�h���ɖ��ߍ��ނ��Ƃ͍D�܂�������܂���B�A�N�Z�X������
            // �K�v�ŁAWeb�w�Ŋ��������A�N�V�����E���\�b�h����������ꍇ�ɂ́A
            // ���[���`�F�b�N���s���C���^�[�Z�v�^�[�̓������������Ă��������B
            if (!isManager()) {
                return "error.security";
            }

            CustomerVO customer = new CustomerVO();
            customer.setName(new CustomerNameVO());
            customer.setCompany(new CompanyVO());
            customer.setDepartment(new DepartmentVO());
            getSessionMap().put("tmpCustomer", customer);
            return "success";
        }
        catch (Exception e) {
            return getErrorHandlerBean().forward(e);
        }
    }
    
    /**
     * ��������FindCustomerCriteria���N���A���܂��B
     *
     * @param event JSF�A�N�V�����C�x���g
     */
    public void clear(ActionEvent ev) {
        findCustomerCriteria.clear();
    }
}
