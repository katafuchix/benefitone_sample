/*
 * ====================================================================== 
 * $Id:
 * MenuStractureTypeVO.java,v 1.7 2005/04/26 05:26:24 tk158799 Exp $ tkakeda 2005/04/07
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/07
 * ======================================================================
 */
package jp.co.benefitone.model.menu;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 会社のValueObject.
 *
 * @version $Revision: 1.1 $, $Date: 2006/01/31 09:26:40 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class MenuStractureTypeVO implements Serializable {
    /** ID */
    private Integer id;

    /** CD */
    private String cd;

    /** NAME */
    private String name;

    /**
     * デフォルトコンストラクタ。
     */
    public MenuStractureTypeVO() {
    }

    /**
     * IDと名前を受けとるコンストラクタです。
     * 部署と顧客の一覧に空のSetを作成します。
     * @param id ID
     * @param name 会社名
     */
    public MenuStractureTypeVO(Integer id, String cd, String name) {
        this.id = id;
        this.cd = cd;
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
    public String getCd() {
        return cd;
    }

    /**
     * 会社名を設定します。
     * @param name 会社名
     */
    public void setCd(String cd) {
        this.cd = cd;
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
        if (!(obj instanceof MenuStractureTypeVO)) {
            return false;
        }
        MenuStractureTypeVO vo = (MenuStractureTypeVO) obj;
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
}
