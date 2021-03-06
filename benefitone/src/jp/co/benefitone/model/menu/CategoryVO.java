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
 * llmOPPFJeSValueObject
 *
 * @version $Revision: 1.1 $
 * @author VOΆ¬c[
 * @hibernate.class table="M_CAT"
 *                  optimistic-lock="version"
 *                  lazy="true"
 */
public class CategoryVO implements Serializable {

    /** Serializepo[WΤ */
    private static final long serialVersionUID = 1L;

    /** JeS_jdx */
    private Long key;

    /** eJeS */
    private CategoryVO parentCategory;

    /** JeSR[h */
    private String code;

    /** JeSΌΜ */
    private String name;

    /** JeSx */
    private Long level;

    /** ΰOζͺ */
    private String insideAndTheOutsideType;

    /** T[rXͺή */
//    private ServiceTypeVO serviceType;

    /** €ΚΪνtO */
    private String deleteFlag;

    /** €ΚΪo[WΤ */
    private Long versionNumber;

    /** €ΚΪo^ϊ */
    private Date entryDate;

    /** €ΚΪo^[UΤ */
    private String entryUserNumber;

    /** €ΚΪΕIXVϊ */
    private Date lastUpdateDate;

    /** €ΚΪΕIXV[UΤ */
    private String lastUpdateUserNumber;

    /** lbeOPOFJtFj[W */
    private Set cafeMenusByCategoryKey = new HashSet();

    /** llmOPPFJeSW */
    private Set categorysByParentCategoryKey = new HashSet();

    /** llmOPSFj[ξρΪζͺW */
    private Set menuInformationItemTypesByCategoryKey = new HashSet();

    /** llmOPTFj[ξρΪW */
    private Set menuInformationItemsByCategoryKey = new HashSet();

    /** llmOQSFGAW */
    private Set areasByCategoryKey = new HashSet();

    /** qlmOOTFj[­ΤΗW */
    private Set menuCountNumberControlsByCategoryKey = new HashSet();

    /** qlmOOUFj[W */
    private Set menusByCategoryKey = new HashSet();

    /** qlmOQPFpΒ\JeSW */
    private Set enableCategorysByCategoryKey = new HashSet();

    /**
     * ftHgRXgN^B
     */
    public CategoryVO() {
    }    

    /**
     * JeS_jdxπΤ΅ά·B
     * @return JeS_jdx
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
     * eJeSπΤ΅ά·B
     * @return eJeS
     * @hibernate.many-to-one column="PRNT_CAT_KEY"
     *                        class="jp.co.benefitone.model.menu.CategoryVO"
     */
    public CategoryVO getParentCategory() {

        return parentCategory;
    }

    /**
     * JeSR[hπΤ΅ά·B
     * @return JeSR[h
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
     * JeSΌΜπΤ΅ά·B
     * @return JeSΌΜ
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
     * JeSxπΤ΅ά·B
     * @return JeSx
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
     * ΰOζͺπΤ΅ά·B
     * @return ΰOζͺ
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
     * T[rXͺήπΤ΅ά·B
     * @return T[rXͺή
     * @hibernate.many-to-one column="SERVICE_TYPE_KEY"
     *                        class="jp.co.benefitone.model.menu.ServiceTypeVO"
     */
//    public ServiceTypeVO getServiceType() {
//
//        return serviceType;
//    }

    /**
     * €ΚΪνtOπΤ΅ά·B
     * @return €ΚΪνtO
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
     * €ΚΪo[WΤπΤ΅ά·B
     * @return €ΚΪo[WΤ
     * @hibernate.version  column="SCA_VER_NO"
     *                     type="long"
     */
    public Long getVersionNumber() {

        return versionNumber;
    }

    /**
     * €ΚΪo^ϊπΤ΅ά·B
     * @return €ΚΪo^ϊ
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
     * €ΚΪo^[UΤπΤ΅ά·B
     * @return €ΚΪo^[UΤ
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
     * €ΚΪΕIXVϊπΤ΅ά·B
     * @return €ΚΪΕIXVϊ
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
     * €ΚΪΕIXV[UΤπΤ΅ά·B
     * @return €ΚΪΕIXV[UΤ
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
     * lbeOPOFJtFj[WπΤ΅ά·B
     * @return lbeOPOFJtFj[W
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
     * llmOPPFJeSWπΤ΅ά·B
     * @return llmOPPFJeSW
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
     * llmOPSFj[ξρΪζͺWπΤ΅ά·B
     * @return llmOPSFj[ξρΪζͺW
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
     * llmOPTFj[ξρΪWπΤ΅ά·B
     * @return llmOPTFj[ξρΪW
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
     * llmOQSFGAWπΤ΅ά·B
     * @return llmOQSFGAW
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
     * qlmOOTFj[­ΤΗWπΤ΅ά·B
     * @return qlmOOTFj[­ΤΗW
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
     * qlmOOUFj[WπΤ΅ά·B
     * @return qlmOOUFj[W
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
     * qlmOQPFpΒ\JeSWπΤ΅ά·B
     * @return qlmOQPFpΒ\JeSW
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
     * JeS_jdxπέθ΅ά·B
     * @param key JeS_jdx
     */
    public void setKey(Long key) {

        this.key = key;
    }

    /**
     * eJeSπέθ΅ά·B
     * @param parentCategory eJeS
     */
    public void setParentCategory(CategoryVO parentCategory) {

        this.parentCategory = parentCategory;
    }

    /**
     * JeSR[hπέθ΅ά·B
     * @param code JeSR[h
     */
    public void setCode(String code) {

        this.code = code;
    }

    /**
     * JeSΌΜπέθ΅ά·B
     * @param name JeSΌΜ
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * JeSxπέθ΅ά·B
     * @param level JeSx
     */
    public void setLevel(Long level) {

        this.level = level;
    }

    /**
     * ΰOζͺπέθ΅ά·B
     * @param insideAndTheOutsideType ΰOζͺ
     */
    public void setInsideAndTheOutsideType(String insideAndTheOutsideType) {

        this.insideAndTheOutsideType = insideAndTheOutsideType;
    }

    /**
     * T[rXͺήπέθ΅ά·B
     * @param serviceType T[rXͺή
     */
//    public void setServiceType(ServiceTypeVO serviceType) {
//
//        this.serviceType = serviceType;
//    }

    /**
     * €ΚΪνtOπέθ΅ά·B
     * @param deleteFlag €ΚΪνtO
     */
    public void setDeleteFlag(String deleteFlag) {

        this.deleteFlag = deleteFlag;
    }

    /**
     * €ΚΪo[WΤπέθ΅ά·B
     * @param versionNumber €ΚΪo[WΤ
     */
    public void setVersionNumber(Long versionNumber) {

        this.versionNumber = versionNumber;
    }

    /**
     * €ΚΪo^ϊπέθ΅ά·B
     * @param entryDate €ΚΪo^ϊ
     */
    public void setEntryDate(Date entryDate) {

        this.entryDate = entryDate;
    }

    /**
     * €ΚΪo^[UΤπέθ΅ά·B
     * @param entryUserNumber €ΚΪo^[UΤ
     */
    public void setEntryUserNumber(String entryUserNumber) {

        this.entryUserNumber = entryUserNumber;
    }

    /**
     * €ΚΪΕIXVϊπέθ΅ά·B
     * @param lastUpdateDate €ΚΪΕIXVϊ
     */
    public void setLastUpdateDate(Date lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * €ΚΪΕIXV[UΤπέθ΅ά·B
     * @param lastUpdateUserNumber €ΚΪΕIXV[UΤ
     */
    public void setLastUpdateUserNumber(String lastUpdateUserNumber) {

        this.lastUpdateUserNumber = lastUpdateUserNumber;
    }

    /**
     * lbeOPOFJtFj[Wπέθ΅ά·B
     * @param cafeMenusByCategoryKey lbeOPOFJtFj[W
     */
    public void setCafeMenusByCategoryKey(Set cafeMenusByCategoryKey) {

        this.cafeMenusByCategoryKey = cafeMenusByCategoryKey;
    }

    /**
     * llmOPPFJeSWπέθ΅ά·B
     * @param categorysByParentCategoryKey llmOPPFJeSW
     */
    public void setCategorysByParentCategoryKey(Set categorysByParentCategoryKey) {

        this.categorysByParentCategoryKey = categorysByParentCategoryKey;
    }

    /**
     * llmOPSFj[ξρΪζͺWπέθ΅ά·B
     * @param menuInformationItemTypesByCategoryKey llmOPSFj[ξρΪζͺW
     */
    public void setMenuInformationItemTypesByCategoryKey(Set menuInformationItemTypesByCategoryKey) {

        this.menuInformationItemTypesByCategoryKey = menuInformationItemTypesByCategoryKey;
    }

    /**
     * llmOPTFj[ξρΪWπέθ΅ά·B
     * @param menuInformationItemsByCategoryKey llmOPTFj[ξρΪW
     */
    public void setMenuInformationItemsByCategoryKey(Set menuInformationItemsByCategoryKey) {

        this.menuInformationItemsByCategoryKey = menuInformationItemsByCategoryKey;
    }

    /**
     * llmOQSFGAWπέθ΅ά·B
     * @param areasByCategoryKey llmOQSFGAW
     */
    public void setAreasByCategoryKey(Set areasByCategoryKey) {

        this.areasByCategoryKey = areasByCategoryKey;
    }

    /**
     * qlmOOTFj[­ΤΗWπέθ΅ά·B
     * @param menuCountNumberControlsByCategoryKey qlmOOTFj[­ΤΗW
     */
    public void setMenuCountNumberControlsByCategoryKey(Set menuCountNumberControlsByCategoryKey) {

        this.menuCountNumberControlsByCategoryKey = menuCountNumberControlsByCategoryKey;
    }

    /**
     * qlmOOUFj[Wπέθ΅ά·B
     * @param menusByCategoryKey qlmOOUFj[W
     */
    public void setMenusByCategoryKey(Set menusByCategoryKey) {

        this.menusByCategoryKey = menusByCategoryKey;
    }

    /**
     * qlmOQPFpΒ\JeSWπέθ΅ά·B
     * @param enableCategorysByCategoryKey qlmOQPFpΒ\JeSW
     */
    public void setEnableCategorysByCategoryKey(Set enableCategorysByCategoryKey) {

        this.enableCategorysByCategoryKey = enableCategorysByCategoryKey;
    }
    /**
     * <p>IuWFNgΜnbVR[hπΤ΅ά·B</p>
     * nbVR[hΝvC}L[ΜlζθΆ¬³κά·B
     * @return IuWFNgΜnbVR[h
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
        	.append(key)
        	.hashCode();
    }
    /**
     * <p>IuWFNg―mΜδrπsΘνκά·B</p>
     * δrΝIuWFNgΜvC}L[ΜlΙζθsΘνκά·B
     * @return IuWFNgΜδrΚ
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
     * <p>IuWFNgΜΆρ»πΤ΅ά·B</p>
     * Άρ»ΝANXΌAIuWFNgnbVR[hA
     * vC}L[ΜtB[hΌ¨ζΡ»ΜlΕ¬³κά·B
     * @return IuWFNgΜΆρ»
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this).
            append("key", key).
            toString();
    }

}
