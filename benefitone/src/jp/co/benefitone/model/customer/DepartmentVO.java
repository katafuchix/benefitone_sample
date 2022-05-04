/* ======================================================================
 *  $Id: DepartmentVO.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 *    tkakeda
 *      2005/04/07
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/07
 * ======================================================================
 */
package jp.co.benefitone.model.customer;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * ������ValueObject.
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class DepartmentVO implements Serializable {
    /** ID */
    private Integer id;

    /** name */
    private String name;

    /** �Z�� */
    private String address;

    /** �ڋq�W�� */
    private Set customers = new HashSet();

    /** ��� */
    private CompanyVO company;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public DepartmentVO() {
    }

    /**
     * �����t���R���X�g���N�^�B
     * �l�����������܂��B
     * @param id ID
     * @param name ������
     * @param address �Z��
     */
    public DepartmentVO(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    /**
     * �Z����Ԃ��܂��B
     * @return �Z��
     */
    public String getAddress() {
        return address;
    }
    /**
     * �Z����ݒ肵�܂��B
     * @param address �Z��
     */
    public void setAddress(String address) {
        this.address = address;
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
     * ��������Ԃ��܂��B
     * @return ������
     */
    public String getName() {
        return name;
    }
    /**
     * ��������ݒ肵�܂��B
     * @param name ������
     */
    public void setName(String name) {
        this.name = name;
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
     * ��Ђ�Ԃ��܂��B
     * @return ���
     */
    public CompanyVO getCompany() {
        return company;
    }

    /**
     * ��Ђ�ݒ肵�܂��B
     * ��ЂɎ������g��ǉ����܂��B
     * @param company ���
     */
    public void setCompany(CompanyVO company) {
        this.company = company;
        if (this.company != null) {
            this.company.addDepartment(this);
        }
    }

    /**
     * ������\����Ԃ��܂��B
     * �S�����l��\�����܂��B
     * @return ������\��
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return getClass().getName()
            + ":[id=" + getId() + ",\n"
            + "address=" + getAddress() + ",\n"
            + "name=" + getName() + "]";
    }

    /**
     * �I�u�W�F�N�g�̓��l��������܂��B
     * �L�[�ƂȂ�ID�ƁAUNIQUE�ƂȂ镔�����Ŕ��肵�܂��B
     * @param obj ��r�I�u�W�F�N�g
     * @return true:���l, false:�قȂ�
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DepartmentVO)) {
            return false;
        }
        DepartmentVO vo = (DepartmentVO) obj;
        return
            equalsValue(vo.getId(), this.id)
            &&  equalsValue(vo.getName(), this.name);
    }

    /**
     * hashCode��Ԃ��܂��B
     * �L�[�ƂȂ�ID��UNIQUE�ƂȂ镔������hashCode��Ԃ��܂��B
     * @return �n�b�V���l
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        if (id == null) {
            return 0;
        }
        return (id.hashCode() * 29) + getName().hashCode();
    }

    /**
     * �I�u�W�F�N�g�̓��l���r���܂��B
     * null�̑Ή����܂݂܂��B
     * @param target �ΏۃI�u�W�F�N�g
     * @param actual ��r�I�u�W�F�N�g
     * @return true:���l�Afalse�F�قȂ�
     */
    private boolean equalsValue(Object target, Object actual) {
        if (target == null) {
            return (actual == null);
        }
        return target.equals(actual);
    }

    /**
     * �ڋq��ǉ����܂��B
     * @param customer �ڋq
     */
    public void addCustomer(CustomerVO customer) {
        customers.add(customer);
    }
}
