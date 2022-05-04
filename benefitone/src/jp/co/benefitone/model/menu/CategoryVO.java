/*
 * $Id: CategoryVO.java,v 1.1 2006/01/31 09:26:40 gon Exp $
 * Copyright (C) 2005 Benefit One Inc. All rights reserved.
 */
package jp.co.benefitone.model.menu;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import jp.co.benefitone.model.menu.CategoryVO;
import jp.co.benefitone.model.menu.ServiceTypeVO;

/**
 * ＭＭＮ０１１：カテゴリValueObject
 *
 * @version $Revision: 1.1 $
 * @author VO生成ツール
 * @hibernate.class table="M_CAT"
 *                  optimistic-lock="version"
 *                  lazy="true"
 */
public class CategoryVO implements Serializable {

    /** Serialize用バージョン番号 */
    private static final long serialVersionUID = 1L;

    /** カテゴリ_ＫＥＹ */
    private Long key;

    /** 親カテゴリ */
    private CategoryVO parentCategory;

    /** カテゴリコード */
    private String code;

    /** カテゴリ名称 */
    private String name;

    /** カテゴリレベル */
    private Long level;

    /** 内外区分 */
    private String insideAndTheOutsideType;

    /** サービス分類 */
//    private ServiceTypeVO serviceType;

    /** 共通項目削除フラグ */
    private String deleteFlag;

    /** 共通項目バージョン番号 */
    private Long versionNumber;

    /** 共通項目登録日時 */
    private Date entryDate;

    /** 共通項目登録ユーザ番号 */
    private String entryUserNumber;

    /** 共通項目最終更新日時 */
    private Date lastUpdateDate;

    /** 共通項目最終更新ユーザ番号 */
    private String lastUpdateUserNumber;

    /** ＭＣＦ０１０：カフェメニュー集合 */
    private Set cafeMenusByCategoryKey = new HashSet();

    /** ＭＭＮ０１１：カテゴリ集合 */
    private Set categorysByParentCategoryKey = new HashSet();

    /** ＭＭＮ０１４：メニュー情報項目区分集合 */
    private Set menuInformationItemTypesByCategoryKey = new HashSet();

    /** ＭＭＮ０１５：メニュー情報項目集合 */
    private Set menuInformationItemsByCategoryKey = new HashSet();

    /** ＭＭＮ０２４：エリア集合 */
    private Set areasByCategoryKey = new HashSet();

    /** ＲＭＮ００５：メニュー発番管理集合 */
    private Set menuCountNumberControlsByCategoryKey = new HashSet();

    /** ＲＭＮ００６：メニュー集合 */
    private Set menusByCategoryKey = new HashSet();

    /** ＲＭＮ０２１：利用可能カテゴリ集合 */
    private Set enableCategorysByCategoryKey = new HashSet();

    /**
     * デフォルトコンストラクタ。
     */
    public CategoryVO() {
    }    

    /**
     * カテゴリ_ＫＥＹを返します。
     * @return カテゴリ_ＫＥＹ
     * @hibernate.id       column="CAT_KEY"
     *                     generator-class="sequence"
     *                     type="long"
     *                     not-null="true"
     * @hibernate.generator-param name="sequence"
     *                            value="S_CAT"
     */
    public Long getKey() {

        return key;
    }

    /**
     * 親カテゴリを返します。
     * @return 親カテゴリ
     * @hibernate.many-to-one column="PRNT_CAT_KEY"
     *                        class="jp.co.benefitone.model.menu.CategoryVO"
     */
    public CategoryVO getParentCategory() {

        return parentCategory;
    }

    /**
     * カテゴリコードを返します。
     * @return カテゴリコード
     * @hibernate.property column="CAT_CD"
     *                     type="string"
     *                     not-null="true"
     *                     insert="true"
     *                     update="true"
     *                     access="property"
     */
    public String getCode() {

        return code;
    }

    /**
     * カテゴリ名称を返します。
     * @return カテゴリ名称
     * @hibernate.property column="CAT_NM"
     *                     type="string"
     *                     insert="true"
     *                     update="true"
     *                     access="property"
     */
    public String getName() {

        return name;
    }

    /**
     * カテゴリレベルを返します。
     * @return カテゴリレベル
     * @hibernate.property column="CAT_LVL"
     *                     type="long"
     *                     insert="true"
     *                     update="true"
     *                     access="property"
     */
    public Long getLevel() {

        return level;
    }

    /**
     * 内外区分を返します。
     * @return 内外区分
     * @hibernate.property column="IO_TYPE"
     *                     type="string"
     *                     insert="true"
     *                     update="true"
     *                     access="property"
     */
    public String getInsideAndTheOutsideType() {

        return insideAndTheOutsideType;
    }

    /**
     * サービス分類を返します。
     * @return サービス分類
     * @hibernate.many-to-one column="SERVICE_TYPE_KEY"
     *                        class="jp.co.benefitone.model.menu.ServiceTypeVO"
     */
//    public ServiceTypeVO getServiceType() {
//
//        return serviceType;
//    }

    /**
     * 共通項目削除フラグを返します。
     * @return 共通項目削除フラグ
     * @hibernate.property column="SCA_DEL_FLG"
     *                     type="string"
     *                     not-null="true"
     *                     insert="true"
     *                     update="true"
     *                     access="property"
     */
    public String getDeleteFlag() {

        return deleteFlag;
    }

    /**
     * 共通項目バージョン番号を返します。
     * @return 共通項目バージョン番号
     * @hibernate.version  column="SCA_VER_NO"
     *                     type="long"
     */
    public Long getVersionNumber() {

        return versionNumber;
    }

    /**
     * 共通項目登録日時を返します。
     * @return 共通項目登録日時
     * @hibernate.property column="SCA_ENT_DT"
     *                     type="timestamp"
     *                     not-null="true"
     *                     insert="true"
     *                     update="true"
     *                     access="property"
     */
    public Date getEntryDate() {

        return entryDate;
    }

    /**
     * 共通項目登録ユーザ番号を返します。
     * @return 共通項目登録ユーザ番号
     * @hibernate.property column="SCA_ENT_USR_NO"
     *                     type="string"
     *                     not-null="true"
     *                     insert="true"
     *                     update="true"
     *                     access="property"
     */
    public String getEntryUserNumber() {

        return entryUserNumber;
    }

    /**
     * 共通項目最終更新日時を返します。
     * @return 共通項目最終更新日時
     * @hibernate.property column="SCA_LAT_UPD_DT"
     *                     type="timestamp"
     *                     not-null="true"
     *                     insert="true"
     *                     update="true"
     *                     access="property"
     */
    public Date getLastUpdateDate() {

        return lastUpdateDate;
    }

    /**
     * 共通項目最終更新ユーザ番号を返します。
     * @return 共通項目最終更新ユーザ番号
     * @hibernate.property column="SCA_LAT_UPD_USR_NO"
     *                     type="string"
     *                     not-null="true"
     *                     insert="true"
     *                     update="true"
     *                     access="property"
     */
    public String getLastUpdateUserNumber() {

        return lastUpdateUserNumber;
    }
    /**
     * ＭＣＦ０１０：カフェメニュー集合を返します。
     * @return ＭＣＦ０１０：カフェメニュー集合
     * @hibernate.set lazy="true"
     *                inverse="true"
     *                where="SCA_DEL_FLG = '0'"
     * @hibernate.collection-key
     *                column="CAT_KEY"
     * @hibernate.collection-one-to-many 
     *                class="jp.co.benefitone.model.point.CafeMenuVO"
     */
    public Set getCafeMenusByCategoryKey() {

        return cafeMenusByCategoryKey;
    }
    /**
     * ＭＭＮ０１１：カテゴリ集合を返します。
     * @return ＭＭＮ０１１：カテゴリ集合
     * @hibernate.set lazy="true"
     *                inverse="true"
     *                where="SCA_DEL_FLG = '0'"
     * @hibernate.collection-key
     *                column="PRNT_CAT_KEY"
     * @hibernate.collection-one-to-many 
     *                class="jp.co.benefitone.model.menu.CategoryVO"
     */
    public Set getCategorysByParentCategoryKey() {

        return categorysByParentCategoryKey;
    }
    /**
     * ＭＭＮ０１４：メニュー情報項目区分集合を返します。
     * @return ＭＭＮ０１４：メニュー情報項目区分集合
     * @hibernate.set lazy="true"
     *                inverse="true"
     *                where="SCA_DEL_FLG = '0'"
     * @hibernate.collection-key
     *                column="CAT_KEY"
     * @hibernate.collection-one-to-many 
     *                class="jp.co.benefitone.model.menu.MenuInformationItemTypeVO"
     */
    public Set getMenuInformationItemTypesByCategoryKey() {

        return menuInformationItemTypesByCategoryKey;
    }
    /**
     * ＭＭＮ０１５：メニュー情報項目集合を返します。
     * @return ＭＭＮ０１５：メニュー情報項目集合
     * @hibernate.set lazy="true"
     *                inverse="true"
     *                where="SCA_DEL_FLG = '0'"
     * @hibernate.collection-key
     *                column="CAT_KEY"
     * @hibernate.collection-one-to-many 
     *                class="jp.co.benefitone.model.menu.MenuInformationItemVO"
     */
    public Set getMenuInformationItemsByCategoryKey() {

        return menuInformationItemsByCategoryKey;
    }
    /**
     * ＭＭＮ０２４：エリア集合を返します。
     * @return ＭＭＮ０２４：エリア集合
     * @hibernate.set lazy="true"
     *                inverse="true"
     *                where="SCA_DEL_FLG = '0'"
     * @hibernate.collection-key
     *                column="CAT_KEY"
     * @hibernate.collection-one-to-many 
     *                class="jp.co.benefitone.model.menu.AreaVO"
     */
    public Set getAreasByCategoryKey() {

        return areasByCategoryKey;
    }
    /**
     * ＲＭＮ００５：メニュー発番管理集合を返します。
     * @return ＲＭＮ００５：メニュー発番管理集合
     * @hibernate.set lazy="true"
     *                inverse="true"
     *                where="SCA_DEL_FLG = '0'"
     * @hibernate.collection-key
     *                column="CAT_KEY"
     * @hibernate.collection-one-to-many 
     *                class="jp.co.benefitone.model.menu.MenuCountNumberControlVO"
     */
    public Set getMenuCountNumberControlsByCategoryKey() {

        return menuCountNumberControlsByCategoryKey;
    }
    /**
     * ＲＭＮ００６：メニュー集合を返します。
     * @return ＲＭＮ００６：メニュー集合
     * @hibernate.set lazy="true"
     *                inverse="true"
     *                where="SCA_DEL_FLG = '0'"
     * @hibernate.collection-key
     *                column="CAT_KEY"
     * @hibernate.collection-one-to-many 
     *                class="jp.co.benefitone.model.menu.MenuVO"
     */
    public Set getMenusByCategoryKey() {

        return menusByCategoryKey;
    }
    /**
     * ＲＭＮ０２１：利用可能カテゴリ集合を返します。
     * @return ＲＭＮ０２１：利用可能カテゴリ集合
     * @hibernate.set lazy="true"
     *                inverse="true"
     *                where="SCA_DEL_FLG = '0'"
     * @hibernate.collection-key
     *                column="CAT_KEY"
     * @hibernate.collection-one-to-many 
     *                class="jp.co.benefitone.model.menu.EnableCategoryVO"
     */
    public Set getEnableCategorysByCategoryKey() {

        return enableCategorysByCategoryKey;
    }

    /**
     * カテゴリ_ＫＥＹを設定します。
     * @param key カテゴリ_ＫＥＹ
     */
    public void setKey(Long key) {

        this.key = key;
    }

    /**
     * 親カテゴリを設定します。
     * @param parentCategory 親カテゴリ
     */
    public void setParentCategory(CategoryVO parentCategory) {

        this.parentCategory = parentCategory;
    }

    /**
     * カテゴリコードを設定します。
     * @param code カテゴリコード
     */
    public void setCode(String code) {

        this.code = code;
    }

    /**
     * カテゴリ名称を設定します。
     * @param name カテゴリ名称
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * カテゴリレベルを設定します。
     * @param level カテゴリレベル
     */
    public void setLevel(Long level) {

        this.level = level;
    }

    /**
     * 内外区分を設定します。
     * @param insideAndTheOutsideType 内外区分
     */
    public void setInsideAndTheOutsideType(String insideAndTheOutsideType) {

        this.insideAndTheOutsideType = insideAndTheOutsideType;
    }

    /**
     * サービス分類を設定します。
     * @param serviceType サービス分類
     */
//    public void setServiceType(ServiceTypeVO serviceType) {
//
//        this.serviceType = serviceType;
//    }

    /**
     * 共通項目削除フラグを設定します。
     * @param deleteFlag 共通項目削除フラグ
     */
    public void setDeleteFlag(String deleteFlag) {

        this.deleteFlag = deleteFlag;
    }

    /**
     * 共通項目バージョン番号を設定します。
     * @param versionNumber 共通項目バージョン番号
     */
    public void setVersionNumber(Long versionNumber) {

        this.versionNumber = versionNumber;
    }

    /**
     * 共通項目登録日時を設定します。
     * @param entryDate 共通項目登録日時
     */
    public void setEntryDate(Date entryDate) {

        this.entryDate = entryDate;
    }

    /**
     * 共通項目登録ユーザ番号を設定します。
     * @param entryUserNumber 共通項目登録ユーザ番号
     */
    public void setEntryUserNumber(String entryUserNumber) {

        this.entryUserNumber = entryUserNumber;
    }

    /**
     * 共通項目最終更新日時を設定します。
     * @param lastUpdateDate 共通項目最終更新日時
     */
    public void setLastUpdateDate(Date lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * 共通項目最終更新ユーザ番号を設定します。
     * @param lastUpdateUserNumber 共通項目最終更新ユーザ番号
     */
    public void setLastUpdateUserNumber(String lastUpdateUserNumber) {

        this.lastUpdateUserNumber = lastUpdateUserNumber;
    }

    /**
     * ＭＣＦ０１０：カフェメニュー集合を設定します。
     * @param cafeMenusByCategoryKey ＭＣＦ０１０：カフェメニュー集合
     */
    public void setCafeMenusByCategoryKey(Set cafeMenusByCategoryKey) {

        this.cafeMenusByCategoryKey = cafeMenusByCategoryKey;
    }

    /**
     * ＭＭＮ０１１：カテゴリ集合を設定します。
     * @param categorysByParentCategoryKey ＭＭＮ０１１：カテゴリ集合
     */
    public void setCategorysByParentCategoryKey(Set categorysByParentCategoryKey) {

        this.categorysByParentCategoryKey = categorysByParentCategoryKey;
    }

    /**
     * ＭＭＮ０１４：メニュー情報項目区分集合を設定します。
     * @param menuInformationItemTypesByCategoryKey ＭＭＮ０１４：メニュー情報項目区分集合
     */
    public void setMenuInformationItemTypesByCategoryKey(Set menuInformationItemTypesByCategoryKey) {

        this.menuInformationItemTypesByCategoryKey = menuInformationItemTypesByCategoryKey;
    }

    /**
     * ＭＭＮ０１５：メニュー情報項目集合を設定します。
     * @param menuInformationItemsByCategoryKey ＭＭＮ０１５：メニュー情報項目集合
     */
    public void setMenuInformationItemsByCategoryKey(Set menuInformationItemsByCategoryKey) {

        this.menuInformationItemsByCategoryKey = menuInformationItemsByCategoryKey;
    }

    /**
     * ＭＭＮ０２４：エリア集合を設定します。
     * @param areasByCategoryKey ＭＭＮ０２４：エリア集合
     */
    public void setAreasByCategoryKey(Set areasByCategoryKey) {

        this.areasByCategoryKey = areasByCategoryKey;
    }

    /**
     * ＲＭＮ００５：メニュー発番管理集合を設定します。
     * @param menuCountNumberControlsByCategoryKey ＲＭＮ００５：メニュー発番管理集合
     */
    public void setMenuCountNumberControlsByCategoryKey(Set menuCountNumberControlsByCategoryKey) {

        this.menuCountNumberControlsByCategoryKey = menuCountNumberControlsByCategoryKey;
    }

    /**
     * ＲＭＮ００６：メニュー集合を設定します。
     * @param menusByCategoryKey ＲＭＮ００６：メニュー集合
     */
    public void setMenusByCategoryKey(Set menusByCategoryKey) {

        this.menusByCategoryKey = menusByCategoryKey;
    }

    /**
     * ＲＭＮ０２１：利用可能カテゴリ集合を設定します。
     * @param enableCategorysByCategoryKey ＲＭＮ０２１：利用可能カテゴリ集合
     */
    public void setEnableCategorysByCategoryKey(Set enableCategorysByCategoryKey) {

        this.enableCategorysByCategoryKey = enableCategorysByCategoryKey;
    }
    /**
     * <p>オブジェクトのハッシュコードを返します。</p>
     * ハッシュコードはプライマリキーの値より生成されます。
     * @return オブジェクトのハッシュコード
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
        	.append(key)
        	.hashCode();
    }
    /**
     * <p>オブジェクト同士の比較を行なわれます。</p>
     * 比較はオブジェクトのプライマリキーの値により行なわれます。
     * @return オブジェクトの比較結果
     */
    @Override
    public boolean equals(Object obj) {
    	if (!(obj instanceof CategoryVO)) {
    		return false;
    	}
		CategoryVO rhs = (CategoryVO) obj;
        return new EqualsBuilder()
        	.append(key, rhs.key)
        	.isEquals();
    }
    /**
     * <p>オブジェクトの文字列阜ｻを返します。</p>
     * 文字列阜ｻは、クラス名、オブジェクトハッシュコード、
     * プライマリキーのフィールド名およびその値で告ｬされます。
     * @return オブジェクトの文字列阜ｻ
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this).
            append("key", key).
            toString();
    }

}
