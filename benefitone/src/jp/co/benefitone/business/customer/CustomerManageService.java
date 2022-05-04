/* ======================================================================
 *  $Id: CustomerManageService.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 *    tkakeda
 *      2005/04/05
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/05
 * ======================================================================
 */
package jp.co.benefitone.business.customer;

import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import jp.co.benefitone.model.customer.CustomerVO;

/**
 * �ڋq���Ǘ��T�[�r�X�C���^�[�t�F�[�X�B
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author first last, Sun Microsystems K.K.
 */
public interface CustomerManageService {

    /**
     * �ڋq�����폜���܂��B
     * @param id �ڋqID
     * @param criteria ��������
     * @param session �Z�b�V�������
     * @return �������ʃI�u�W�F�N�g
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="manager"
     */
    FindCustomerResult deleteCustomer(Integer id, FindCustomerCriteria criteria, BusinessSession session);

    /**
     * �ڋq��ۑ����܂��B
     * @param customer �ڋqVO
     * @param session �Z�b�V�������
     * @return �ۑ���̌ڋq��������
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="manager"
     */
    FindCustomerResult saveCustomer(CustomerVO customer, BusinessSession session);

    /**
     * �ڋq���̃T�j�^�C�Y���s���܂��B
     *
     * @param customer ���͂��ꂽ�ڋq���
     * @return �T�j�^�C�Y���ꂽ�ڋq���
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="manager"
     */
    CustomerVO sanitizeCustomer(CustomerVO customer);
}
