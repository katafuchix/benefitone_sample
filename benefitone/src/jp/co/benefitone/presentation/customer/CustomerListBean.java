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
 * 顧客情報の一覧を取得するための BackingBean です。
 * @author Hiroshi Kajisha
 * @version $Revision: 1.1.1.1 $
 */
public class CustomerListBean extends BaseBean {
    /**
     * 顧客情報検索サービス。
     */
    private CustomerFindService customerFindService;

    /**
     * 顧客情報管理サービス。
     */
    private CustomerManageService customerManageService;

    /**
     * 顧客情報の一覧。
     */
    private List customerList;

    /**
     * データモデル
     */
    private DataModel customerModel = new ListDataModel();

    /**
     * 検索条件
     */
    private FindCustomerCriteria findCustomerCriteria;

    /**
     * <code>BusinessSession</code>のファクトリ
     */
    private WebBusinessSessionFactoryBean businessSessionFactoryBean;

    /**
     * @return findCustomerCriteria を返します。
     */
    public FindCustomerCriteria getFindCustomerCriteria() {
        return findCustomerCriteria;
    }

    /**
     * @param findCustomerCriteria findCustomerCriteria を設定します。
     */
    public void setFindCustomerCriteria(
            FindCustomerCriteria findCustomerCriteria) {
        this.findCustomerCriteria = findCustomerCriteria;
    }

    /**
     * @return sessionFactory を返します。
     */
    public WebBusinessSessionFactoryBean getBusinessSessionFactoryBean() {
        return businessSessionFactoryBean;
    }

    /**
     * @param sessionFactory sessionFactory を設定します。
     */
    public void setBusinessSessionFactoryBean(
            WebBusinessSessionFactoryBean sessionFactory) {
        this.businessSessionFactoryBean = sessionFactory;
    }

    /**
     * データモデルを返します。
     * @return customerModel を返します。
     */
    public DataModel getCustomerModel() {
        customerModel.setWrappedData(getCustomerList());
        return customerModel;
    }

    /**
     * @return customerList を返します。
     */
    public List getCustomerList() {
        return customerList;
    }

    /**
     * @param customerList customerList を設定します。
     */
    public void setCustomerList(List customerList) {
        this.customerList = customerList;
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
     * 検索ボタンが押下された場合のアクションを記述します。
     *
     * @return <code>success</code> 検索が成功した場合、呼び出し元の画面に
     *                              遷移します。
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
     * 選択中の顧客情報を検索します。
     * @return <code>success</code> 呼出し元の画面に遷移します。
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
     * 指定された顧客情報を削除し、前回の検索条件で再度検索します。
     * @return <code>success</code> 削除が成功した場合、呼出し元の画面に
     *                              遷移します。
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
     * 新規顧客情報入力のために、セッション情報に登録されている
     * <code>tmpCustomer</code> をリセットします。
     * もし、ユーザが管理者権限を持たない場合は、セキュリティエラー
     * ページに遷移します。
     *
     * @return <code>success</code> 顧客情報編集画面に遷移します。
     */
    public String create() {
        try {
            // 注意：通常、以下のようにロール・チェックのコードをアクション・
            // メソッド内に埋め込むことは好ましくありません。アクセス制限が
            // 必要で、Web層で完結したアクション・メソッドが多数ある場合には、
            // ロールチェックを行うインターセプターの導入を検討してください。
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
     * 検索条件FindCustomerCriteriaをクリアします。
     *
     * @param event JSFアクションイベント
     */
    public void clear(ActionEvent ev) {
        findCustomerCriteria.clear();
    }
}
