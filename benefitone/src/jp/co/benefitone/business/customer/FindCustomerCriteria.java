/* ======================================================================
 *  $Id: FindCustomerCriteria.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 *    tkakeda
 *      2005/04/05
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/05
 * ======================================================================
 */
package jp.co.benefitone.business.customer;

import java.io.Serializable;

/**
 * 顧客検索条件オブジェクト。
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class FindCustomerCriteria implements Serializable {
    /** 顧客名 */
    private String customerName;
    /** 会社名 */
    private String companyName;
    /** 部署名 */
    private String departmentName;

    /**
     * デフォルトコンストラクタ。
     */
    public FindCustomerCriteria() {
    }

    /**
     * 顧客名を返します。
     * @return 顧客名
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 顧客名を設定します。
     * @param customerName 顧客名
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 会社名を返します。
     * @return 会社名
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 会社名を設定します。
     * @param companyName 会社名
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 部署名を返します。
     * @return 部署名
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * 部署名を設定します。
     * @param departmentName 部署名
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    /**
     * 全てのプロパティ値をクリアします．
     */
    public void clear() {
        this.companyName = null;
        this.customerName = null;
        this.departmentName = null;
    }
}
