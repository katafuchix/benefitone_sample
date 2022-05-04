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
 * �l�l�m�O�P�P�F�J�e�S��ValueObject
 *
 * @version $Revision: 1.1 $
 * @author VO�����c�[��
 * @hibernate.class table="M_CAT"
 *                  optimistic-lock="version"
 *                  lazy="true"
 */
public class CategoryVO implements Serializable {

    /** Serialize�p�o�[�W�����ԍ� */
    private static final long serialVersionUID = 1L;

    /** �J�e�S��_�j�d�x */
    private Long key;

    /** �e�J�e�S�� */
    private CategoryVO parentCategory;

    /** �J�e�S���R�[�h */
    private String code;

    /** �J�e�S������ */
    private String name;

    /** �J�e�S�����x�� */
    private Long level;

    /** ���O�敪 */
    private String insideAndTheOutsideType;

    /** �T�[�r�X���� */
//    private ServiceTypeVO serviceType;

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

    /** �l�b�e�O�P�O�F�J�t�F���j���[�W�� */
    private Set cafeMenusByCategoryKey = new HashSet();

    /** �l�l�m�O�P�P�F�J�e�S���W�� */
    private Set categorysByParentCategoryKey = new HashSet();

    /** �l�l�m�O�P�S�F���j���[��񍀖ڋ敪�W�� */
    private Set menuInformationItemTypesByCategoryKey = new HashSet();

    /** �l�l�m�O�P�T�F���j���[��񍀖ڏW�� */
    private Set menuInformationItemsByCategoryKey = new HashSet();

    /** �l�l�m�O�Q�S�F�G���A�W�� */
    private Set areasByCategoryKey = new HashSet();

    /** �q�l�m�O�O�T�F���j���[���ԊǗ��W�� */
    private Set menuCountNumberControlsByCategoryKey = new HashSet();

    /** �q�l�m�O�O�U�F���j���[�W�� */
    private Set menusByCategoryKey = new HashSet();

    /** �q�l�m�O�Q�P�F���p�\�J�e�S���W�� */
    private Set enableCategorysByCategoryKey = new HashSet();

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public CategoryVO() {
    }    

    /**
     * �J�e�S��_�j�d�x��Ԃ��܂��B
     * @return �J�e�S��_�j�d�x
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
     * �e�J�e�S����Ԃ��܂��B
     * @return �e�J�e�S��
     * @hibernate.many-to-one column="PRNT_CAT_KEY"
     *                        class="jp.co.benefitone.model.menu.CategoryVO"
     */
    public CategoryVO getParentCategory() {

        return parentCategory;
    }

    /**
     * �J�e�S���R�[�h��Ԃ��܂��B
     * @return �J�e�S���R�[�h
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
     * �J�e�S�����̂�Ԃ��܂��B
     * @return �J�e�S������
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
     * �J�e�S�����x����Ԃ��܂��B
     * @return �J�e�S�����x��
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
     * ���O�敪��Ԃ��܂��B
     * @return ���O�敪
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
     * �T�[�r�X���ނ�Ԃ��܂��B
     * @return �T�[�r�X����
     * @hibernate.many-to-one column="SERVICE_TYPE_KEY"
     *                        class="jp.co.benefitone.model.menu.ServiceTypeVO"
     */
//    public ServiceTypeVO getServiceType() {
//
//        return serviceType;
//    }

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
     * �l�b�e�O�P�O�F�J�t�F���j���[�W����Ԃ��܂��B
     * @return �l�b�e�O�P�O�F�J�t�F���j���[�W��
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
     * �l�l�m�O�P�P�F�J�e�S���W����Ԃ��܂��B
     * @return �l�l�m�O�P�P�F�J�e�S���W��
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
     * �l�l�m�O�P�S�F���j���[��񍀖ڋ敪�W����Ԃ��܂��B
     * @return �l�l�m�O�P�S�F���j���[��񍀖ڋ敪�W��
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
     * �l�l�m�O�P�T�F���j���[��񍀖ڏW����Ԃ��܂��B
     * @return �l�l�m�O�P�T�F���j���[��񍀖ڏW��
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
     * �l�l�m�O�Q�S�F�G���A�W����Ԃ��܂��B
     * @return �l�l�m�O�Q�S�F�G���A�W��
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
     * �q�l�m�O�O�T�F���j���[���ԊǗ��W����Ԃ��܂��B
     * @return �q�l�m�O�O�T�F���j���[���ԊǗ��W��
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
     * �q�l�m�O�O�U�F���j���[�W����Ԃ��܂��B
     * @return �q�l�m�O�O�U�F���j���[�W��
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
     * �q�l�m�O�Q�P�F���p�\�J�e�S���W����Ԃ��܂��B
     * @return �q�l�m�O�Q�P�F���p�\�J�e�S���W��
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
     * �J�e�S��_�j�d�x��ݒ肵�܂��B
     * @param key �J�e�S��_�j�d�x
     */
    public void setKey(Long key) {

        this.key = key;
    }

    /**
     * �e�J�e�S����ݒ肵�܂��B
     * @param parentCategory �e�J�e�S��
     */
    public void setParentCategory(CategoryVO parentCategory) {

        this.parentCategory = parentCategory;
    }

    /**
     * �J�e�S���R�[�h��ݒ肵�܂��B
     * @param code �J�e�S���R�[�h
     */
    public void setCode(String code) {

        this.code = code;
    }

    /**
     * �J�e�S�����̂�ݒ肵�܂��B
     * @param name �J�e�S������
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * �J�e�S�����x����ݒ肵�܂��B
     * @param level �J�e�S�����x��
     */
    public void setLevel(Long level) {

        this.level = level;
    }

    /**
     * ���O�敪��ݒ肵�܂��B
     * @param insideAndTheOutsideType ���O�敪
     */
    public void setInsideAndTheOutsideType(String insideAndTheOutsideType) {

        this.insideAndTheOutsideType = insideAndTheOutsideType;
    }

    /**
     * �T�[�r�X���ނ�ݒ肵�܂��B
     * @param serviceType �T�[�r�X����
     */
//    public void setServiceType(ServiceTypeVO serviceType) {
//
//        this.serviceType = serviceType;
//    }

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
     * �l�b�e�O�P�O�F�J�t�F���j���[�W����ݒ肵�܂��B
     * @param cafeMenusByCategoryKey �l�b�e�O�P�O�F�J�t�F���j���[�W��
     */
    public void setCafeMenusByCategoryKey(Set cafeMenusByCategoryKey) {

        this.cafeMenusByCategoryKey = cafeMenusByCategoryKey;
    }

    /**
     * �l�l�m�O�P�P�F�J�e�S���W����ݒ肵�܂��B
     * @param categorysByParentCategoryKey �l�l�m�O�P�P�F�J�e�S���W��
     */
    public void setCategorysByParentCategoryKey(Set categorysByParentCategoryKey) {

        this.categorysByParentCategoryKey = categorysByParentCategoryKey;
    }

    /**
     * �l�l�m�O�P�S�F���j���[��񍀖ڋ敪�W����ݒ肵�܂��B
     * @param menuInformationItemTypesByCategoryKey �l�l�m�O�P�S�F���j���[��񍀖ڋ敪�W��
     */
    public void setMenuInformationItemTypesByCategoryKey(Set menuInformationItemTypesByCategoryKey) {

        this.menuInformationItemTypesByCategoryKey = menuInformationItemTypesByCategoryKey;
    }

    /**
     * �l�l�m�O�P�T�F���j���[��񍀖ڏW����ݒ肵�܂��B
     * @param menuInformationItemsByCategoryKey �l�l�m�O�P�T�F���j���[��񍀖ڏW��
     */
    public void setMenuInformationItemsByCategoryKey(Set menuInformationItemsByCategoryKey) {

        this.menuInformationItemsByCategoryKey = menuInformationItemsByCategoryKey;
    }

    /**
     * �l�l�m�O�Q�S�F�G���A�W����ݒ肵�܂��B
     * @param areasByCategoryKey �l�l�m�O�Q�S�F�G���A�W��
     */
    public void setAreasByCategoryKey(Set areasByCategoryKey) {

        this.areasByCategoryKey = areasByCategoryKey;
    }

    /**
     * �q�l�m�O�O�T�F���j���[���ԊǗ��W����ݒ肵�܂��B
     * @param menuCountNumberControlsByCategoryKey �q�l�m�O�O�T�F���j���[���ԊǗ��W��
     */
    public void setMenuCountNumberControlsByCategoryKey(Set menuCountNumberControlsByCategoryKey) {

        this.menuCountNumberControlsByCategoryKey = menuCountNumberControlsByCategoryKey;
    }

    /**
     * �q�l�m�O�O�U�F���j���[�W����ݒ肵�܂��B
     * @param menusByCategoryKey �q�l�m�O�O�U�F���j���[�W��
     */
    public void setMenusByCategoryKey(Set menusByCategoryKey) {

        this.menusByCategoryKey = menusByCategoryKey;
    }

    /**
     * �q�l�m�O�Q�P�F���p�\�J�e�S���W����ݒ肵�܂��B
     * @param enableCategorysByCategoryKey �q�l�m�O�Q�P�F���p�\�J�e�S���W��
     */
    public void setEnableCategorysByCategoryKey(Set enableCategorysByCategoryKey) {

        this.enableCategorysByCategoryKey = enableCategorysByCategoryKey;
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
    	if (!(obj instanceof CategoryVO)) {
    		return false;
    	}
		CategoryVO rhs = (CategoryVO) obj;
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
