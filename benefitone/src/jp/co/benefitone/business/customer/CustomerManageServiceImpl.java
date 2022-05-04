/* ======================================================================
 *  $Id: CustomerManageServiceImpl.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 *    tkakeda
 *      2005/04/05
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/05
 * ======================================================================
 */
package jp.co.benefitone.business.customer;

import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import jp.co.benefitone.integration.customer.CustomerDAO;
import jp.co.benefitone.model.customer.CompanyVO;
import jp.co.benefitone.model.customer.CustomerVO;
import jp.co.benefitone.model.customer.DepartmentVO;

/**
 * �ڋq���Ǘ��T�[�r�X�����N���X�B
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CustomerManageServiceImpl implements CustomerManageService {
    /** �ڋqDAO */
    private CustomerDAO customerDAO;

    /** �ڋq�����T�[�r�X */
    private CustomerFindService customerFindService;

    /**
     * �f�t�H�X�g�R���X�g���N�^�B
     */
    public CustomerManageServiceImpl() {
    }

    /**
     * �ڋq�����폜���܂��B
     * �폜��Ɍ������ʂ�Ԃ��܂��B
     * @param id �ڋqID
     * @param criteria ��������
     * @param session �Z�b�V�������
     * @return ��������
     * @see jp.co.benefitone.business.customer.CustomerManageService#deleteCustomer(java.lang.Integer, jp.co.benefitone.business.customer.FindCustomerCriteria, jp.co.benefitone.common.fw.interceptor.session.BusinessSession)
     */
    public FindCustomerResult deleteCustomer(
                                  Integer id,
                                  FindCustomerCriteria criteria,
                                  BusinessSession session) {
        customerDAO.delete(id);
        return customerFindService.findCustomer(criteria, session);
    }

    /**
     * �ڋq����ۑ����܂��B
     * �ۑ��O�ɕ����Ɖ�Ђ̊֌W���������܂��B
     * @param customer �ڋq���
     * @param session �Z�b�V�������
     * @return �ۑ����O�̌��������ɂ�錟������
     */
    public FindCustomerResult saveCustomer(
                                  CustomerVO customer,
                                  BusinessSession session) {
        customer.getDepartment().setCompany(customer.getCompany());
        customerDAO.save(customer);

        FindCustomerCriteria criteria = getCurrentCriteria(session);
        return customerFindService.findCustomer(criteria, session);
    }

    /**
     * ���݂̌����������擾���܂��B
     * �Z�b�V�������ɂȂ���ΐV�K�ɍ쐬���܂��B
     * @param session �Z�b�V����
     * @return ��������
     */
    private FindCustomerCriteria getCurrentCriteria(BusinessSession session) {
        Object criteria = session.getAttribute("criteria");
        if (criteria == null) {
            return new FindCustomerCriteria();
        }
        else {
            return (FindCustomerCriteria) criteria;
        }
    }

    /**
     * �ڋqDAO��ݒ肵�܂��B
     * @param dao �ڋqDAO
     */
    public void setCustomerDAO(CustomerDAO dao) {
        this.customerDAO = dao;
    }

    /**
     * �ڋq�����T�[�r�X��Ԃ��܂��B
     * @return �ڋq�����T�[�r�X
     */
    public CustomerFindService getCustomerFindService() {
        return customerFindService;
    }

    /**
     * �ڋq�����T�[�r�X��ݒ肵�܂��B
     * @param service �ڋq�����T�[�r�X
     */
    public void setCustomerFindService(CustomerFindService service) {
        this.customerFindService = service;
    }

    /*
     * @see jp.co.benefitone.business.customer.CustomerManageService#sanitizeCustomer(jp.co.benefitone.model.customer.CustomerVO)
     */
    public CustomerVO sanitizeCustomer(CustomerVO customer) {
        CompanyVO enteredCompany = customer.getCompany();
        if (enteredCompany == null) {
            // NULLObject �̐ݒ�
            customer.setCompany(new CompanyVO());
        }
        DepartmentVO enteredDepartment = customer.getDepartment();
        if (enteredDepartment == null) {
            // NULLObject �̐ݒ�
            customer.setDepartment(new DepartmentVO());
        }

        CompanyVO existingCompanyVO =
            customerDAO.selectCompanyByName(customer.getCompany().getName());
        if (existingCompanyVO != null) {
            customer.setCompany(existingCompanyVO);
        }
        else {
            customer.getCompany().setId(null);
        }

        if (customer.getCompany().getId() != null) {
            DepartmentVO existingDepartmentVO =
                customerDAO.selectDepartmentByNameAndCompanyId(
                        customer.getDepartment().getName(),
                        customer.getCompany().getId());
            if (existingDepartmentVO != null) {
                String address = customer.getDepartment().getAddress();
                customer.setDepartment(existingDepartmentVO);
                if (!isEmpty(address)) {
                    customer.getDepartment().setAddress(address);
                }
            }
            else {
                customer.getDepartment().setId(null);
            }
        }
        else {
            customer.getDepartment().setId(null);
        }

        return customer;
    }

    /**
     * �����񂪋󕶎����邢��null���𔻒肵�܂��B
     * @param string ������
     * @return true:�󕶎� or null�Afalse:not �󕶎�/null
     */
    private boolean isEmpty(String string) {
        return (string == null) || (string.length() == 0);
    }
}
