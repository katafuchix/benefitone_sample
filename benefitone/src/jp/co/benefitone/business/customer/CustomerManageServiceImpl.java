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
 * 顧客情報管理サービス実装クラス。
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CustomerManageServiceImpl implements CustomerManageService {
    /** 顧客DAO */
    private CustomerDAO customerDAO;

    /** 顧客検索サービス */
    private CustomerFindService customerFindService;

    /**
     * デフォストコンストラクタ。
     */
    public CustomerManageServiceImpl() {
    }

    /**
     * 顧客情報を削除します。
     * 削除後に検索結果を返します。
     * @param id 顧客ID
     * @param criteria 検索条件
     * @param session セッション情報
     * @return 検索結果
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
     * 顧客情報を保存します。
     * 保存前に部署と会社の関係を解決します。
     * @param customer 顧客情報
     * @param session セッション情報
     * @return 保存直前の検索条件による検索結果
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
     * 現在の検索条件を取得します。
     * セッション内になければ新規に作成します。
     * @param session セッション
     * @return 検索条件
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
     * 顧客DAOを設定します。
     * @param dao 顧客DAO
     */
    public void setCustomerDAO(CustomerDAO dao) {
        this.customerDAO = dao;
    }

    /**
     * 顧客検索サービスを返します。
     * @return 顧客検索サービス
     */
    public CustomerFindService getCustomerFindService() {
        return customerFindService;
    }

    /**
     * 顧客検索サービスを設定します。
     * @param service 顧客検索サービス
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
            // NULLObject の設定
            customer.setCompany(new CompanyVO());
        }
        DepartmentVO enteredDepartment = customer.getDepartment();
        if (enteredDepartment == null) {
            // NULLObject の設定
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
     * 文字列が空文字あるいはnullかを判定します。
     * @param string 文字列
     * @return true:空文字 or null、false:not 空文字/null
     */
    private boolean isEmpty(String string) {
        return (string == null) || (string.length() == 0);
    }
}
