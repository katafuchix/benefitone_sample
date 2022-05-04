/* ======================================================================
 *  $Id: FindCustomerCriteria.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 *    tkakeda
 *      2005/04/05
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/05
 * ======================================================================
 */
package jp.co.benefitone.business.customer;

import java.io.Serializable;

/**
 * �ڋq���������I�u�W�F�N�g�B
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class FindCustomerCriteria implements Serializable {
    /** �ڋq�� */
    private String customerName;
    /** ��Ж� */
    private String companyName;
    /** ������ */
    private String departmentName;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public FindCustomerCriteria() {
    }

    /**
     * �ڋq����Ԃ��܂��B
     * @return �ڋq��
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * �ڋq����ݒ肵�܂��B
     * @param customerName �ڋq��
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * ��Ж���Ԃ��܂��B
     * @return ��Ж�
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * ��Ж���ݒ肵�܂��B
     * @param companyName ��Ж�
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * ��������Ԃ��܂��B
     * @return ������
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * ��������ݒ肵�܂��B
     * @param departmentName ������
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    /**
     * �S�Ẵv���p�e�B�l���N���A���܂��D
     */
    public void clear() {
        this.companyName = null;
        this.customerName = null;
        this.departmentName = null;
    }
}
