/*
 * $Id: ServiceTypeVO.java,v 1.1 2006/01/31 09:26:40 gon Exp $
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


/**
 * ＭＭＮ０１０：サービス分類ValueObject
 *
 * @version $Revision: 1.1 $
 * @author VO生成ツール
 * @hibernate.class table="M_SERVICE_TYPE"
 *                  optimistic-lock="version"
 *                  lazy="true"
 */
public class ServiceTypeVO implements Serializable {

    /** Serialize用バージョン番号 */
    private static final long serialVersionUID = 1L;

    /** サービス分類_ＫＥＹ */
    private Long key;

    /** サービス分類コード */
    private String code;

    /** サービス分類名称 */
    private String name;

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

    /** ＭＭＮ０１１：カテゴリ集合 */
    private Set categorysByServiceTypeKey = new HashSet();
    
    private Set transactionsCompanysByServiceTypeKey = new HashSet();

    /**
     * デフォルトコンストラクタ。
     */
    public ServiceTypeVO() {
    }    

    /**
     * サービス分類_ＫＥＹを返します。
     * @return サービス分類_ＫＥＹ
     * @hibernate.id       column="SERVICE_TYPE_KEY"
     *                     generator-class="sequence"
     *                     type="long"
     *                     not-null="true"
     * @hibernate.generator-param name="sequence"
     *                            value="S_SERVICE_TYPE"
     */
    public Long getKey() {

        return key;
    }

    /**
     * サービス分類コードを返します。
     * @return サービス分類コード
     * @hibernate.property column="SERVICE_TYPE_CD"
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
     * サービス分類名称を返します。
     * @return サービス分類名称
     * @hibernate.property column="SERVICE_TYPE_NM"
     *                     type="string"
     *                     insert="true"
     *                     update="true"
     *                     access="property"
     */
    public String getName() {

        return name;
    }

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
     * ＭＭＮ０１１：カテゴリ集合を返します。
     * @return ＭＭＮ０１１：カテゴリ集合
     * @hibernate.set lazy="true"
     *                inverse="true"
     *                where="SCA_DEL_FLG = '0'"
     * @hibernate.collection-key
     *                column="SERVICE_TYPE_KEY"
     * @hibernate.collection-one-to-many 
     *                class="jp.co.benefitone.model.menu.CategoryVO"
     */
    public Set getCategorysByServiceTypeKey() {

        return categorysByServiceTypeKey;
    }
    
    /**
     * @hibernate.set lazy="true"
     *                inverse="true"
     *                table="M_TRSCT_CPNY_SERVICE_TYPE"
     *                cascade="save-update"
     *                where="SCA_DEL_FLG = '0'"
     * @hibernate.collection-key
     *                column="SERVICE_TYPE_KEY"
     * @hibernate.collection-many-to-many 
     *                class="jp.co.benefitone.model.partner.TransactionsCompanyVO"
     *                column="TRSCT_CPNY_KEY"
     */
    public Set getTransactionsCompanysByServiceTypeKey() {

        return transactionsCompanysByServiceTypeKey;
    }

    /**
     * サービス分類_ＫＥＹを設定します。
     * @param key サービス分類_ＫＥＹ
     */
    public void setKey(Long key) {

        this.key = key;
    }

    /**
     * サービス分類コードを設定します。
     * @param code サービス分類コード
     */
    public void setCode(String code) {

        this.code = code;
    }

    /**
     * サービス分類名称を設定します。
     * @param name サービス分類名称
     */
    public void setName(String name) {

        this.name = name;
    }

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
     * ＭＭＮ０１１：カテゴリ集合を設定します。
     * @param categorysByServiceTypeKey ＭＭＮ０１１：カテゴリ集合
     */
    public void setCategorysByServiceTypeKey(Set categorysByServiceTypeKey) {

        this.categorysByServiceTypeKey = categorysByServiceTypeKey;
    }
    
    public void setTransactionsCompanysByServiceTypeKey(Set transactionsCompanysByServiceTypeKey) {

        this.transactionsCompanysByServiceTypeKey = transactionsCompanysByServiceTypeKey;
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
    	if (!(obj instanceof ServiceTypeVO)) {
    		return false;
    	}
		ServiceTypeVO rhs = (ServiceTypeVO) obj;
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
