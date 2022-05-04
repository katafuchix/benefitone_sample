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
 * ��Ђ�ValueObject.
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CompanyVO implements Serializable {
    /** ID */
    private Integer id;

    /** ��Ж� */
    private String name;

    /** �����ꗗ */
    private Set departments = new HashSet();

    /** �ڋq�ꗗ */
    private Set customers = new HashSet();

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public CompanyVO() {
    }

    /**
     * ID�Ɩ��O���󂯂Ƃ�R���X�g���N�^�ł��B
     * �����ƌڋq�̈ꗗ�ɋ��Set���쐬���܂��B
     * @param id ID
     * @param name ��Ж�
     */
    public CompanyVO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * ID��Ԃ��܂��B
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * ID��ݒ肵�܂��B
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * ��Ж���Ԃ��܂��B
     * @return ��Ж�
     */
    public String getName() {
        return name;
    }

    /**
     * ��Ж���ݒ肵�܂��B
     * @param name ��Ж�
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * �֘A���镔���̏W����Ԃ��܂��B
     * Hibernate��one-to-many�̊֘A�͐ݒ肵�Ă��܂���B
     * @return �����W��
     */
    public Set getDepartments() {
        return departments;
    }

    /**
     * �����W����ݒ肵�܂��B
     * @param departments �����W��
     */
    public void setDepartments(Set departments) {
        this.departments = departments;
    }

    /**
     * �ڋq�W����Ԃ��܂��B
     * @return �ڋq�W��
     */
    public Set getCustomers() {
        return customers;
    }

    /**
     * �ڋq�W����ݒ肵�܂��B
     * @param customers �ڋq�W��
     */
    public void setCustomers(Set customers) {
        this.customers = customers;
    }

    /**
     * ������\����Ԃ��܂��B
     * Commons��ToStringBuilder���g�p����ƍX�ɕ֗��ł��B
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return getClass().getName() + ":[id="
                + getId() + ",\n" + "name="
                + getName() + "]";
    }

    /**
     * �I�u�W�F�N�g�̓��ꐫ�𔻒肵�܂��B
     * �L�[�ł���ID�ƁAUNIQUE�w�肳��Ă��閼�O�Ŕ��肵�܂��B
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
     * �I�u�W�F�N�g��hashcode��Ԃ��܂��B ID�Ɩ��O��hashCode���g�p���܂��B
     * @return �n�b�V���R�[�h
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        if (id == null) {
            return 0;
        }
        return (id.hashCode() * 29) + getName().hashCode();
    }

    /**
     * ���l��r�������Ȃ��܂��B null�̃P�[�X�𔻒肵�܂��B
     *
     * @param target �ΏۃI�u�W�F�N�g
     * @param actual ��r�I�u�W�F�N�g
     * @return true:���l�Afalse:���l�łȂ�
     */
    private boolean equalsValue(Object target, Object actual) {
        if (target == null) {
            return (actual == null);
        }
        return target.equals(actual);
    }

    /**
     * �����W���ɕ�����ǉ����܂��B
     *
     * @param dept ����
     */
    public void addDepartment(DepartmentVO dept) {
        departments.add(dept);
    }

    /**
     * �ڋq�W���Ɍڋq��ǉ����܂��B
     *
     * @param customer �ڋq
     */
    public void addCustomer(CustomerVO customer) {
        customers.add(customer);
    }
}
