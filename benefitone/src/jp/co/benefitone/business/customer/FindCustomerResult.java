/* ======================================================================
 *  $Id: FindCustomerResult.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 *    tkakeda
 *      2005/04/05
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/05
 * ======================================================================
 */
package jp.co.benefitone.business.customer;

import java.util.List;

import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import jp.co.benefitone.common.fw.interceptor.session.BusinessSessionComposite;

/**
 * �ڋq�������ʃI�u�W�F�N�g�B
 * <code>BusinessSessionComposite</code>���������A�r�W�l�X�w�����
 * ����Web�w�ɓn���܂��B
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author first last, Sun Microsystems K.K.
 */
public class FindCustomerResult implements BusinessSessionComposite {
    /** �������ʃ��X�g */
    private List result;

    /** �r�W�l�X�Z�b�V�����I�u�W�F�N�g */
    private BusinessSession businessSession;

    /**
     * �������ʃ��X�g��Ԃ��܂��B
     * @return �������ʃ��X�g
     */
    public List getResult() {
        return result;
    }

    /**
     * �������ʃ��X�g��ݒ肵�܂��B
     * @param result �������ʃ��X�g
     */
    public void setResult(List result) {
        this.result = result;
    }

    /**
     * �r�W�l�X�Z�b�V������ݒ肵�܂��B
     * @param session �r�W�l�X�Z�b�V����
     */
    public void setBusinessSession(BusinessSession session) {
        this.businessSession = session;
    }

    /**
     * �r�W�l�X�Z�b�V������Ԃ��܂��B
     * @return �r�W�l�X�Z�b�V����
     * @see jp.co.benefitone.common.fw.interceptor.session.BusinessSessionComposite#getBusinessSession()
     */
    public BusinessSession getBusinessSession() {
        return this.businessSession;
    }
}
