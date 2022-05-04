/* ======================================================================
 *  $Id: CustomerDAO.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 *    tkakeda
 *      2005/04/05
 * Originator: first.last@Sun.COM
 * OriginDate: 2005/MM/dd
 * ======================================================================
 */
package jp.co.benefitone.integration.customer;

import java.util.List;

import jp.co.benefitone.model.customer.CompanyVO;
import jp.co.benefitone.model.customer.CustomerVO;
import jp.co.benefitone.model.customer.DepartmentVO;

/**
 * �ڋqDAO�C���^�[�t�F�[�X�B
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author first last, Sun Microsystems K.K.
 */
public interface CustomerDAO {

    /**
     * �ڋq�����������܂��B
     * @param customerName �ڋq��
     * @param departmentName ������
     * @param companyName ��Ж�
     * @return CustomerVO�I�u�W�F�N�g�̃��X�g
     */
    List find(String customerName,
              String departmentName,
              String companyName);

    /**
     * �ڋqID�Ŏw�肳���ڋq����1���폜���܂��B
     *
     * @param id �ڋqID
     */
    void delete(Integer id);

    /**
     * �ڋqID�ɂ��ڋq�����������܂��B
     *
     * @param id �ڋqID
     * @return �w�肳�ꂽ ID �����ڋq����Ԃ��܂��B
     *         ���t����Ȃ��ꍇ�́A<code>null</code>��Ԃ��܂��B
     */
    CustomerVO select(Integer id);

    /**
     * ��Џ�����Ж��̊��S��v�Ō������܂��B
     *
     * @param name ��Ж�
     * @return ��Џ�񂪌��t����Ȃ��ꍇ�́A<code>null</code>��Ԃ��܂��B
     */
    CompanyVO selectCompanyByName(String name);

    /**
     * �������𕔏����̊��S��v�Ō������܂��B
     *
     * @param name ������
     * @param companyId ���ID
     * @return ������񂪌��t����Ȃ��ꍇ�́A<code>null</code>��Ԃ��܂��B
     */
    DepartmentVO selectDepartmentByNameAndCompanyId(String name,
                                                    Integer companyId);

    /**
     * �ڋq����1���ۑ����܂��B
     * �V�K�̏ꍇ�͒ǉ��A�����̏ꍇ�͍X�V�ŕۑ����܂��B
     * @param customer �ڋq���
     */
    void save(CustomerVO customer);
}
