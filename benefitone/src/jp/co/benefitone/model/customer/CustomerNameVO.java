/* ======================================================================
 * $Id:
 * CustomerNameVO.java,v 1.6 2005/04/21 08:54:04 tk158799 Exp $
 * tkakeda
 * 2005/04/07
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/07
 * ======================================================================
 */
package jp.co.benefitone.model.customer;

import java.io.Serializable;

/**
 * 顧客の名前ValueObject.
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CustomerNameVO implements Serializable {
    /** ファーストネーム */
    private String firstName;

    /** ラストネーム */
    private String lastName;

    /**
     * デフォルトコンストラクタ。
     */
    public CustomerNameVO() {
        this(null, null);
    }

    /**
     * 名前を受けとるコンストラクタ。 名前を設定します。
     * @param firstName ファーストネーム
     * @param lastName ラストネーム
     */
    public CustomerNameVO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * ファーストネームを返します。
     * @return ファーストネーム
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * ファーストネームを設定します。
     * @param firstName ファーストネーム
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * ラストネームを返します。
     * @return ラストネーム
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * ファーストネームを設定します。
     * @param lastName ラストネーム
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 文字列表現を返します。全属性を表示します。
     * CommonsのToStirngBuilderを使用すると便利です。
     * @return 文字列表現
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return this.getClass().getName()
                + ":[" + "firstName=" + getFirstName()
                + ",\n" + "lastName=" + getLastName()
                + ",\n" + "]";
    }

    /**
     * オブジェクトの同値性を判定します。
     * 名前で比較します。
     * @param obj 比較オブジェクト
     * @return true:同値、false:同値でない
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CustomerNameVO)) {
            return false;
        }
        CustomerNameVO vo = (CustomerNameVO) obj;
        return equalsValue(vo.getFirstName(), this.firstName)
               && equalsValue(vo.getLastName(), this.lastName);
    }

    /**
     * オブジェクトのhashcodeを返します。
     * toString().hashCode()を返します。
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * 値が等しいかを判定します。 同一オブジェクトの判定はしません。
     * @param target 対象の値
     * @param actual 現在の値
     * @return true:同値, false:同値でない
     */
    private boolean equalsValue(String target, String actual) {
        if (target == null) {
            return (actual == null);
        }
        return target.equals(actual);
    }
}
