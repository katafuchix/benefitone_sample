/* ======================================================================
 * $Id: CustomerFindService.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 * tkakeda
 * 2005/04/05
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/MM/dd
 * ======================================================================
 */
package jp.co.benefitone.business.customer;

import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import jp.co.benefitone.model.customer.CustomerVO;

/**
 * �ڋq�����T�[�r�X�C���^�[�t�F�[�X�B
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public interface CustomerFindService {
    /**
     * �ڋq��ID�ɂ�茟�����܂��B
     * �ꌏ�����B
     * @param id �ڋqID
     * @return CustomerVO�I�u�W�F�N�g
     * @ejb.transaction type="Required"
     * @ejb.permission unchecked="true"
     */
    CustomerVO selectCustomer(Integer id);

    /**
     * �Z�b�V������񂩂�ڋq�����������܂��B
     * @param criteria ��������
     * @param session �r�W�l�X�Z�b�V����
     * @return ���������Ɉ�v�����ڋq���̈ꗗ��Ԃ��܂��B
     * @ejb.transaction type="Required"
     * @ejb.permission unchecked="true"
     */
    FindCustomerResult findCustomer(FindCustomerCriteria criteria,
                                    BusinessSession session);
}
