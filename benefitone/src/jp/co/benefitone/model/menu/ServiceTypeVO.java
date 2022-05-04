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
 * �l�l�m�O�P�O�F�T�[�r�X����ValueObject
 *
 * @version $Revision: 1.1 $
 * @author VO�����c�[��
 * @hibernate.class table="M_SERVICE_TYPE"
 *                  optimistic-lock="version"
 *                  lazy="true"
 */
public class ServiceTypeVO implements Serializable {

    /** Serialize�p�o�[�W�����ԍ� */
    private static final long serialVersionUID = 1L;

    /** �T�[�r�X����_�j�d�x */
    private Long key;

    /** �T�[�r�X���ރR�[�h */
    private String code;

    /** �T�[�r�X���ޖ��� */
    private String name;

    /** ���ʍ��ڍ폜�t���O */
    private String deleteFlag;

    /** ���ʍ��ڃo�[�W�����ԍ� */
    private Long versionNumber;

    /** ���ʍ��ړo�^���� */
    private Date entryDate;

    /** ���ʍ��ړo�^���[�U�ԍ� */
    private String entryUserNumber;

    /** ���ʍ��ڍŏI�X�V���� */
    private Date lastUpdateDate;

    /** ���ʍ��ڍŏI�X�V���[�U�ԍ� */
    private String lastUpdateUserNumber;

    /** �l�l�m�O�P�P�F�J�e�S���W�� */
    private Set categorysByServiceTypeKey = new HashSet();
    
    private Set transactionsCompanysByServiceTypeKey = new HashSet();

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public ServiceTypeVO() {
    }    

    /**
     * �T�[�r�X����_�j�d�x��Ԃ��܂��B
     * @return �T�[�r�X����_�j�d�x
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
     * �T�[�r�X���ރR�[�h��Ԃ��܂��B
     * @return �T�[�r�X���ރR�[�h
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
     * �T�[�r�X���ޖ��̂�Ԃ��܂��B
     * @return �T�[�r�X���ޖ���
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
     * ���ʍ��ڍ폜�t���O��Ԃ��܂��B
     * @return ���ʍ��ڍ폜�t���O
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
     * ���ʍ��ڃo�[�W�����ԍ���Ԃ��܂��B
     * @return ���ʍ��ڃo�[�W�����ԍ�
     * @hibernate.version  column="SCA_VER_NO"
     *                     type="long"
     */
    public Long getVersionNumber() {

        return versionNumber;
    }

    /**
     * ���ʍ��ړo�^������Ԃ��܂��B
     * @return ���ʍ��ړo�^����
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
     * ���ʍ��ړo�^���[�U�ԍ���Ԃ��܂��B
     * @return ���ʍ��ړo�^���[�U�ԍ�
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
     * ���ʍ��ڍŏI�X�V������Ԃ��܂��B
     * @return ���ʍ��ڍŏI�X�V����
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
     * ���ʍ��ڍŏI�X�V���[�U�ԍ���Ԃ��܂��B
     * @return ���ʍ��ڍŏI�X�V���[�U�ԍ�
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
     * �l�l�m�O�P�P�F�J�e�S���W����Ԃ��܂��B
     * @return �l�l�m�O�P�P�F�J�e�S���W��
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
     * �T�[�r�X����_�j�d�x��ݒ肵�܂��B
     * @param key �T�[�r�X����_�j�d�x
     */
    public void setKey(Long key) {

        this.key = key;
    }

    /**
     * �T�[�r�X���ރR�[�h��ݒ肵�܂��B
     * @param code �T�[�r�X���ރR�[�h
     */
    public void setCode(String code) {

        this.code = code;
    }

    /**
     * �T�[�r�X���ޖ��̂�ݒ肵�܂��B
     * @param name �T�[�r�X���ޖ���
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * ���ʍ��ڍ폜�t���O��ݒ肵�܂��B
     * @param deleteFlag ���ʍ��ڍ폜�t���O
     */
    public void setDeleteFlag(String deleteFlag) {

        this.deleteFlag = deleteFlag;
    }

    /**
     * ���ʍ��ڃo�[�W�����ԍ���ݒ肵�܂��B
     * @param versionNumber ���ʍ��ڃo�[�W�����ԍ�
     */
    public void setVersionNumber(Long versionNumber) {

        this.versionNumber = versionNumber;
    }

    /**
     * ���ʍ��ړo�^������ݒ肵�܂��B
     * @param entryDate ���ʍ��ړo�^����
     */
    public void setEntryDate(Date entryDate) {

        this.entryDate = entryDate;
    }

    /**
     * ���ʍ��ړo�^���[�U�ԍ���ݒ肵�܂��B
     * @param entryUserNumber ���ʍ��ړo�^���[�U�ԍ�
     */
    public void setEntryUserNumber(String entryUserNumber) {

        this.entryUserNumber = entryUserNumber;
    }

    /**
     * ���ʍ��ڍŏI�X�V������ݒ肵�܂��B
     * @param lastUpdateDate ���ʍ��ڍŏI�X�V����
     */
    public void setLastUpdateDate(Date lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * ���ʍ��ڍŏI�X�V���[�U�ԍ���ݒ肵�܂��B
     * @param lastUpdateUserNumber ���ʍ��ڍŏI�X�V���[�U�ԍ�
     */
    public void setLastUpdateUserNumber(String lastUpdateUserNumber) {

        this.lastUpdateUserNumber = lastUpdateUserNumber;
    }

    /**
     * �l�l�m�O�P�P�F�J�e�S���W����ݒ肵�܂��B
     * @param categorysByServiceTypeKey �l�l�m�O�P�P�F�J�e�S���W��
     */
    public void setCategorysByServiceTypeKey(Set categorysByServiceTypeKey) {

        this.categorysByServiceTypeKey = categorysByServiceTypeKey;
    }
    
    public void setTransactionsCompanysByServiceTypeKey(Set transactionsCompanysByServiceTypeKey) {

        this.transactionsCompanysByServiceTypeKey = transactionsCompanysByServiceTypeKey;
    }
    
    /**
     * <p>�I�u�W�F�N�g�̃n�b�V���R�[�h��Ԃ��܂��B</p>
     * �n�b�V���R�[�h�̓v���C�}���L�[�̒l��萶������܂��B
     * @return �I�u�W�F�N�g�̃n�b�V���R�[�h
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
        	.append(key)
        	.hashCode();
    }
    /**
     * <p>�I�u�W�F�N�g���m�̔�r���s�Ȃ��܂��B</p>
     * ��r�̓I�u�W�F�N�g�̃v���C�}���L�[�̒l�ɂ��s�Ȃ��܂��B
     * @return �I�u�W�F�N�g�̔�r����
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
     * <p>�I�u�W�F�N�g�̕����񕌻��Ԃ��܂��B</p>
     * �����񕌻�́A�N���X���A�I�u�W�F�N�g�n�b�V���R�[�h�A
     * �v���C�}���L�[�̃t�B�[���h������т��̒l�ō������܂��B
     * @return �I�u�W�F�N�g�̕����񕌻
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this).
            append("key", key).
            toString();
    }

}
