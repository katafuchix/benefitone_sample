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
 * �ڋq����ValueObject�N���X�B
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CustomerVO implements Serializable {
    /** ID */
    private Integer id;
    /** ���O */
    private CustomerNameVO name;
    /** ���[���A�h���X */
    private String email;
    /** �d�b�ԍ� */
    private String phone;
    /** FAX�ԍ� */
    private String fax;
    /** ���� */
    private DepartmentVO department;
    /** ��� */
    private CompanyVO company;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     * �S��null�ŏ��������܂��B
     */
    public CustomerVO() {
    }

    /**
     * �������󂯎��R���X�g���N�^�B
     * @param id ID
     * @param name ���O
     * @param email ���[���A�h���X
     * @param phone �d�b�ԍ�
     * @param fax FAX
     * @param deparment ����
     * @param company ���
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
     * ���O��Ԃ��܂��B
     * @return ���O
     */
    public CustomerNameVO getName() {
        return name;
    }

    /**
     * ���O��ݒ肵�܂��B
     * @param customerName ���O(CustomerNameVO)
     */
    public void setName(CustomerNameVO customerName) {
        this.name = customerName;
    }

    /**
     * ���[���A�h���X��Ԃ��܂��B
     * @return ���[���A�h���X
     */
    public String getEmail() {
        return email;
    }

    /**
     * ���[���A�h���X��ݒ肵�܂��B
     * @param email ���[���A�h���X
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * �d�b�ԍ���Ԃ��܂��B
     * @return �d�b�ԍ�
     */
    public String getPhone() {
        return phone;
    }

    /**
     * �d�b�ԍ���ݒ肵�܂��B
     * @param phone �d�b�ԍ�
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * FAX�ԍ���Ԃ��܂��B
     * @return FAX�ԍ�
     */
    public String getFax() {
        return fax;
    }

    /**
     * FAX�ԍ���ݒ肵�܂��B
     * @param fax FAX�ԍ�
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * ��Ђ�Ԃ��܂��B
     * @return ��ЃI�u�W�F�N�g
     */
    public CompanyVO getCompany() {
        return company;
    }
    /**
     * ��Ђ�ݒ肵�܂��B
     * ��Ђɑ΂��Ď��g��ǉ����܂��B
     * @param company ��ЃI�u�W�F�N�g
     */
    public void setCompany(CompanyVO company) {
        this.company = company;
        if (this.company != null) {
            this.company.addCustomer(this);
        }
    }

    /**
     * ������Ԃ��܂��B
     * @return ����
     */
    public DepartmentVO getDepartment() {
        return department;
    }

    /**
     * ������ݒ肵�܂��B
     * �����Ɏ��g��ǉ����܂��B
     * @param department ����
     */
    public void setDepartment(DepartmentVO department) {
        this.department = department;
        if (this.department != null) {
            this.department.addCustomer(this);
        }
    }

    /**
     * �I�u�W�F�N�g�̓��l���𔻒肵�܂��B
     * �L�[���ڂ�ID�݂̂Ŕ��肵�܂��B
     * @param obj ��r�Ώ�
     * @return true:���l, false:���l�łȂ�
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
     * �I�u�W�F�N�g�����������𔻒肵�܂��B
     * null���̔�����s���܂��B
     * @param target ��r�Ώ�
     * @param actual ���݂̃I�u�W�F�N�g
     * @return �������ꍇ:true, �قȂ�ꍇ:false
     */
    private boolean equalsValue(Object target, Object actual) {
        if (target == null) {
            return (actual == null);
        }
        return target.equals(actual);
    }

    /**
     * �I�u�W�F�N�g��hashCode��Ԃ��܂��B
     * ID��hashCode��Ԃ��܂��B
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        if (id == null) {
            return 0;
        }
        return id.hashCode();
    }

    /**
     * ������\����Ԃ��܂��B
     * �S�Ă̑�����\�����܂��B
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
