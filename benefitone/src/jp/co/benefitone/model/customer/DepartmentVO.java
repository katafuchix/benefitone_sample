/* ======================================================================
 *  $Id: DepartmentVO.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 *    tkakeda
 *      2005/04/07
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/07
 * ======================================================================
 */
package jp.co.benefitone.model.customer;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 部署のValueObject.
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class DepartmentVO implements Serializable {
    /** ID */
    private Integer id;

    /** name */
    private String name;

    /** 住所 */
    private String address;

    /** 顧客集合 */
    private Set customers = new HashSet();

    /** 会社 */
    private CompanyVO company;

    /**
     * デフォルトコンストラクタ。
     */
    public DepartmentVO() {
    }

    /**
     * 引数付きコンストラクタ。
     * 値を初期化します。
     * @param id ID
     * @param name 部署名
     * @param address 住所
     */
    public DepartmentVO(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    /**
     * 住所を返します。
     * @return 住所
     */
    public String getAddress() {
        return address;
    }
    /**
     * 住所を設定します。
     * @param address 住所
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * IDを返します。
     * @return ID
     */
    public Integer getId() {
        return id;
    }
    /**
     * IDを設定します。
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * 部署名を返します。
     * @return 部署名
     */
    public String getName() {
        return name;
    }
    /**
     * 部署名を設定します。
     * @param name 部署名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 顧客集合を返します。
     * @return 顧客集合
     */
    public Set getCustomers() {
        return customers;
    }

    /**
     * 顧客集合を設定します。
     * @param customers 顧客集合
     */
    public void setCustomers(Set customers) {
        this.customers = customers;
    }

    /**
     * 会社を返します。
     * @return 会社
     */
    public CompanyVO getCompany() {
        return company;
    }

    /**
     * 会社を設定します。
     * 会社に自分自身を追加します。
     * @param company 会社
     */
    public void setCompany(CompanyVO company) {
        this.company = company;
        if (this.company != null) {
            this.company.addDepartment(this);
        }
    }

    /**
     * 文字列表現を返します。
     * 全属性値を表示します。
     * @return 文字列表現
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return getClass().getName()
            + ":[id=" + getId() + ",\n"
            + "address=" + getAddress() + ",\n"
            + "name=" + getName() + "]";
    }

    /**
     * オブジェクトの同値判定をします。
     * キーとなるIDと、UNIQUEとなる部署名で判定します。
     * @param obj 比較オブジェクト
     * @return true:同値, false:異なる
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DepartmentVO)) {
            return false;
        }
        DepartmentVO vo = (DepartmentVO) obj;
        return
            equalsValue(vo.getId(), this.id)
            &&  equalsValue(vo.getName(), this.name);
    }

    /**
     * hashCodeを返します。
     * キーとなるIDとUNIQUEとなる部署名のhashCodeを返します。
     * @return ハッシュ値
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        if (id == null) {
            return 0;
        }
        return (id.hashCode() * 29) + getName().hashCode();
    }

    /**
     * オブジェクトの同値を比較します。
     * nullの対応を含みます。
     * @param target 対象オブジェクト
     * @param actual 比較オブジェクト
     * @return true:同値、false：異なる
     */
    private boolean equalsValue(Object target, Object actual) {
        if (target == null) {
            return (actual == null);
        }
        return target.equals(actual);
    }

    /**
     * 顧客を追加します。
     * @param customer 顧客
     */
    public void addCustomer(CustomerVO customer) {
        customers.add(customer);
    }
}
