/* ======================================================================
 *  $Id: CustomerVO.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 *    tkakeda
 *      2005/04/05
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/05
 * ======================================================================
 */
package jp.co.benefitone.model.customer;

import java.io.Serializable;

/**
 * 顧客情報のValueObjectクラス。
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CustomerVO implements Serializable {
    /** ID */
    private Integer id;
    /** 名前 */
    private CustomerNameVO name;
    /** メールアドレス */
    private String email;
    /** 電話番号 */
    private String phone;
    /** FAX番号 */
    private String fax;
    /** 部署 */
    private DepartmentVO department;
    /** 会社 */
    private CompanyVO company;

    /**
     * デフォルトコンストラクタ。
     * 全てnullで初期化します。
     */
    public CustomerVO() {
    }

    /**
     * 属性を受け取るコンストラクタ。
     * @param id ID
     * @param name 名前
     * @param email メールアドレス
     * @param phone 電話番号
     * @param fax FAX
     * @param deparment 部署
     * @param company 会社
     */
    public CustomerVO(Integer id,
                      CustomerNameVO name,
                      String email,
                      String phone,
                      String fax,
                      DepartmentVO deparment,
                      CompanyVO company) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.fax = fax;
        setDepartment(deparment);
        setCompany(company);
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
     * 名前を返します。
     * @return 名前
     */
    public CustomerNameVO getName() {
        return name;
    }

    /**
     * 名前を設定します。
     * @param customerName 名前(CustomerNameVO)
     */
    public void setName(CustomerNameVO customerName) {
        this.name = customerName;
    }

    /**
     * メールアドレスを返します。
     * @return メールアドレス
     */
    public String getEmail() {
        return email;
    }

    /**
     * メールアドレスを設定します。
     * @param email メールアドレス
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 電話番号を返します。
     * @return 電話番号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 電話番号を設定します。
     * @param phone 電話番号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * FAX番号を返します。
     * @return FAX番号
     */
    public String getFax() {
        return fax;
    }

    /**
     * FAX番号を設定します。
     * @param fax FAX番号
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 会社を返します。
     * @return 会社オブジェクト
     */
    public CompanyVO getCompany() {
        return company;
    }
    /**
     * 会社を設定します。
     * 会社に対して自身を追加します。
     * @param company 会社オブジェクト
     */
    public void setCompany(CompanyVO company) {
        this.company = company;
        if (this.company != null) {
            this.company.addCustomer(this);
        }
    }

    /**
     * 部署を返します。
     * @return 部署
     */
    public DepartmentVO getDepartment() {
        return department;
    }

    /**
     * 部署を設定します。
     * 部署に自身を追加します。
     * @param department 部署
     */
    public void setDepartment(DepartmentVO department) {
        this.department = department;
        if (this.department != null) {
            this.department.addCustomer(this);
        }
    }

    /**
     * オブジェクトの同値性を判定します。
     * キー項目のIDのみで判定します。
     * @param obj 比較対象
     * @return true:同値, false:同値でない
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof CustomerVO)) {
            return false;
        }

        CustomerVO vo = (CustomerVO) obj;
        return equalsValue(vo.getId(), this.id);
    }

    /**
     * オブジェクトが等しいかを判定します。
     * null時の判定も行います。
     * @param target 比較対象
     * @param actual 現在のオブジェクト
     * @return 等しい場合:true, 異なる場合:false
     */
    private boolean equalsValue(Object target, Object actual) {
        if (target == null) {
            return (actual == null);
        }
        return target.equals(actual);
    }

    /**
     * オブジェクトのhashCodeを返します。
     * IDのhashCodeを返します。
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        if (id == null) {
            return 0;
        }
        return id.hashCode();
    }

    /**
     * 文字列表現を返します。
     * 全ての属性を表示します。
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return this.getClass().getName() + ":["
                + "id=" + id + ",\n"
                + "firstName=" + getName().getFirstName() + ",\n"
                + "lastName=" + getName().getLastName() + ",\n"
                + "email=" + email + ",\n"
                + "phone=" + phone + ",\n"
                + "fax=" + fax + "\n"
                + "department=" + department + "\n"
                + "company=" + company + "]";
    }
}
