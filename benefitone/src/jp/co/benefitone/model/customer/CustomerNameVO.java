/* ======================================================================
 * $Id:
 * CustomerNameVO.java,v 1.6 2005/04/21 08:54:04 tk158799 Exp $
 * tkakeda
 * 2005/04/07
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/07
 * ======================================================================
 */
package jp.co.benefitone.model.customer;

import java.io.Serializable;

/**
 * �ڋq�̖��OValueObject.
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CustomerNameVO implements Serializable {
    /** �t�@�[�X�g�l�[�� */
    private String firstName;

    /** ���X�g�l�[�� */
    private String lastName;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public CustomerNameVO() {
        this(null, null);
    }

    /**
     * ���O���󂯂Ƃ�R���X�g���N�^�B ���O��ݒ肵�܂��B
     * @param firstName �t�@�[�X�g�l�[��
     * @param lastName ���X�g�l�[��
     */
    public CustomerNameVO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * �t�@�[�X�g�l�[����Ԃ��܂��B
     * @return �t�@�[�X�g�l�[��
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * �t�@�[�X�g�l�[����ݒ肵�܂��B
     * @param firstName �t�@�[�X�g�l�[��
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * ���X�g�l�[����Ԃ��܂��B
     * @return ���X�g�l�[��
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * �t�@�[�X�g�l�[����ݒ肵�܂��B
     * @param lastName ���X�g�l�[��
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * ������\����Ԃ��܂��B�S������\�����܂��B
     * Commons��ToStirngBuilder���g�p����ƕ֗��ł��B
     * @return ������\��
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return this.getClass().getName()
                + ":[" + "firstName=" + getFirstName()
                + ",\n" + "lastName=" + getLastName()
                + ",\n" + "]";
    }

    /**
     * �I�u�W�F�N�g�̓��l���𔻒肵�܂��B
     * ���O�Ŕ�r���܂��B
     * @param obj ��r�I�u�W�F�N�g
     * @return true:���l�Afalse:���l�łȂ�
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CustomerNameVO)) {
            return false;
        }
        CustomerNameVO vo = (CustomerNameVO) obj;
        return equalsValue(vo.getFirstName(), this.firstName)
               && equalsValue(vo.getLastName(), this.lastName);
    }

    /**
     * �I�u�W�F�N�g��hashcode��Ԃ��܂��B
     * toString().hashCode()��Ԃ��܂��B
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * �l�����������𔻒肵�܂��B ����I�u�W�F�N�g�̔���͂��܂���B
     * @param target �Ώۂ̒l
     * @param actual ���݂̒l
     * @return true:���l, false:���l�łȂ�
     */
    private boolean equalsValue(String target, String actual) {
        if (target == null) {
            return (actual == null);
        }
        return target.equals(actual);
    }
}
