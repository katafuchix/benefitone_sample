/*
 * ====================================================================== 
 * $Id:
 * CompanyVO.java,v 1.7 2005/04/26 05:26:24 tk158799 Exp $ tkakeda 2005/04/07
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/07
 * ======================================================================
 */
package jp.co.benefitone.model.customer;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 会社のValueObject.
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CompanyVO implements Serializable {
    /** ID */
    private Integer id;

    /** 会社名 */
    private String name;

    /** 部署一覧 */
    private Set departments = new HashSet();

    /** 顧客一覧 */
    private Set customers = new HashSet();

    /**
     * デフォルトコンストラクタ。
     */
    public CompanyVO() {
    }

    /**
     * IDと名前を受けとるコンストラクタです。
     * 部署と顧客の一覧に空のSetを作成します。
     * @param id ID
     * @param name 会社名
     */
    public CompanyVO(Integer id, String name) {
        this.id = id;
        this.name = name;
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
     * 会社名を返します。
     * @return 会社名
     */
    public String getName() {
        return name;
    }

    /**
     * 会社名を設定します。
     * @param name 会社名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 関連する部署の集合を返します。
     * Hibernateのone-to-manyの関連は設定していません。
     * @return 部署集合
     */
    public Set getDepartments() {
        return departments;
    }

    /**
     * 部署集合を設定します。
     * @param departments 部署集合
     */
    public void setDepartments(Set departments) {
        this.departments = departments;
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
     * 文字列表現を返します。
     * CommonsのToStringBuilderを使用すると更に便利です。
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return getClass().getName() + ":[id="
                + getId() + ",\n" + "name="
                + getName() + "]";
    }

    /**
     * オブジェクトの同一性を判定します。
     * キーであるIDと、UNIQUE指定されている名前で判定します。
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CompanyVO)) {
            return false;
        }
        CompanyVO vo = (CompanyVO) obj;
        return equalsValue(vo.getId(), this.id)
               && equalsValue(vo.getName(), this.name);
    }

    /**
     * オブジェクトのhashcodeを返します。 IDと名前のhashCodeを使用します。
     * @return ハッシュコード
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        if (id == null) {
            return 0;
        }
        return (id.hashCode() * 29) + getName().hashCode();
    }

    /**
     * 同値比較をおこないます。 nullのケースを判定します。
     *
     * @param target 対象オブジェクト
     * @param actual 比較オブジェクト
     * @return true:同値、false:同値でない
     */
    private boolean equalsValue(Object target, Object actual) {
        if (target == null) {
            return (actual == null);
        }
        return target.equals(actual);
    }

    /**
     * 部署集合に部署を追加します。
     *
     * @param dept 部署
     */
    public void addDepartment(DepartmentVO dept) {
        departments.add(dept);
    }

    /**
     * 顧客集合に顧客を追加します。
     *
     * @param customer 顧客
     */
    public void addCustomer(CustomerVO customer) {
        customers.add(customer);
    }
}
