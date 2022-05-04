/* ======================================================================
 * $Id: CustomerFindServiceImpl.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 * tkakeda
 * 2005/04/05
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/05
 * ======================================================================
 */
package jp.co.benefitone.business.customer;

import java.util.List;

import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import jp.co.benefitone.integration.customer.CustomerDAO;
import jp.co.benefitone.model.customer.CustomerVO;


/**
 * �ڋq�����T�[�r�X�̎����N���X�B
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CustomerFindServiceImpl implements CustomerFindService {

    /** �������v�����Z�b�V�����Ɋi�[����ۂ̃L�[������ */
    public static final String STATISTICS = "findStatistics";
    /** �����������Z�b�V�����Ɋi�[����ۂ̃L�[������*/
    public static final String CRITERIA = "criteria";

    /** �ڋqDAO */
    private CustomerDAO dao = null;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public CustomerFindServiceImpl() {
    }

    /**
     * @see jp.co.benefitone.business.customer.CustomerFindService#findCustomer(jp.co.benefitone.business.customer.FindCustomerCriteria)
     */
    List findCustomer(FindCustomerCriteria criteria) {
        return dao.find(
                        criteria.getCustomerName(),
                        criteria.getDepartmentName(),
                        criteria.getCompanyName());
    }

    /**
     * �ڋqID���󂯂Ƃ�ꌏ�̌ڋqVO���擾���܂��B
     * @param id �ڋqID
     * @return �ڋq���
     * @see jp.co.benefitone.business.customer.CustomerFindService#selectCustomer(java.lang.Integer)
     */
    public CustomerVO selectCustomer(Integer id) {
        return dao.select(id);
    }

    /**
     * �ڋq�����������������ɃZ�b�V�����������Ɍ������܂��B
     * <p>���������ɂ́A�ڋq���A�������A��Ж����ݒ肳��Ă���A������
     * ���������Ɍڋq���̈ꗗ���擾���܂��B</p>
     * <p>�ڋq���̖���̌������ԁA���ς̌������ԁA�����񐔂��v�����Z�b�V����
     * ���Ɋi�[���܂��B</p>
     * @param criteria ��������
     * @param session �r�W�l�X�Z�b�V����
     * @return �ڋq��������
     * @see jp.co.benefitone.business.customer.CustomerFindService#findCustomer(jp.co.benefitone.business.customer.FindCustomerCriteria, jp.co.benefitone.common.fw.interceptor.session.BusinessSession)
     */
    public FindCustomerResult findCustomer(FindCustomerCriteria criteria,
                                           BusinessSession session) {
        FindCustomerResult result = new FindCustomerResult();
        setupCriteria(criteria);

        long start = System.currentTimeMillis();
        result.setResult(findCustomer(criteria));
        long end = System.currentTimeMillis();

        FindStatistics statistics = getFindStatistics(session, start, end);
        session.setAttribute(STATISTICS, statistics);
        session.setAttribute(CRITERIA, criteria);
        result.setBusinessSession(session);
        return result;
    }

    /**
     * ���v�����Z�b�V���������擾���܂��B
     * �Z�b�V�����ɂȂ���ΐV�K�ŁA����΂�������g���č���̌������Ԃ�
     * �v�Z���Ċi�[���܂��B
     * @param session �Z�b�V�������
     * @param start �J�n����
     * @param end �I������
     * @return �������v���
     */
    private FindStatistics getFindStatistics(
                               BusinessSession session,
                               long start,
                               long end) {

        FindStatistics statistics = null;
        if (session.getAttribute(STATISTICS) == null) {
            statistics = new FindStatistics();
        }
        else {
            statistics =
                (FindStatistics) session.getAttribute(STATISTICS);
        }
        statistics.calculate(start, end);
        return statistics;
    }

    /**
     * ���������̐ݒ�����܂��B
     * �󕶎��̏�����null�ɕϊ����Ċi�[���Ȃ����܂��B
     * @param criteria ��������
     */
    private void setupCriteria(FindCustomerCriteria criteria) {
        criteria.setCustomerName(empty2null(criteria.getCustomerName()));
        criteria.setDepartmentName(empty2null(criteria.getDepartmentName()));
        criteria.setCompanyName(empty2null(criteria.getCompanyName()));
    }

    /**
     * �󕶎����null�ɕϊ����܂��B null�ł��󕶎��ł��Ȃ��ꍇ�͂��̂܂ܕԂ��B
     *
     * @param attribute �����I�u�W�F�N�g
     * @return �ϊ��㕶����
     */
    private String empty2null(Object attribute) {
        if (attribute == null) {
            return null;
        }
        if (attribute.equals("")) {
            return null;
        }
        return String.valueOf(attribute);
    }

    /**
     * CustomerDAO��ݒ肵�܂��B
     * SpringFramework�ɂ��ˑ��֌W�̉����Ɏg�p���܂��B
     * @param dao �ڋq���DAO�I�u�W�F�N�g
     */
    public void setCustomerDAO(CustomerDAO dao) {
        this.dao = dao;
    }
}
