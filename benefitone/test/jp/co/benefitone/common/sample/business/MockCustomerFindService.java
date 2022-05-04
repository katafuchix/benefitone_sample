/* ======================================================================
 *  $Id: MockCustomerFindService.java,v 1.1.1.1 2006/01/29 13:03:26 gon Exp $
 *    tkakeda
 *      2005/04/06
 * Originator: first.last@Sun.COM
 * OriginDate: 2005/MM/dd
 * ======================================================================
 */
package jp.co.benefitone.common.sample.business;

import java.util.List;

import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import junit.framework.Assert;

/**
 * |> Class Description <|
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:26 $
 * @author first last, Sun Microsystems K.K.
 */
public class MockCustomerFindService extends CustomerFindServiceImpl {

    private FindCustomerCriteria criteria = null;

    /**
     * ����������ێ�����^�����\�b�h�B 
     */
    public List findCustomer(FindCustomerCriteria criteria) {
        this.criteria = criteria;
        return super.findCustomer(criteria);
    }
    
    /**
     * ����������ێ�����B 
     */
    public FindCustomerResult findCustomer(
                    FindCustomerCriteria criteria,
                    BusinessSession session) {
        this.criteria = criteria;
        return super.findCustomer(criteria, session);
    }
    
    /**
     * ���������̌��؂��s���܂��B
     * @param customer �ڋq��
     * @param department ������
     * @param company ��Ж�
     */
    public void verifyFindCustomerResult(
                    String customer,
                    String department,
                    String company) {
        Assert.assertEquals(
                            "�ڋq�����قȂ�I",
                            customer,
                            criteria.getCustomerName());
        Assert.assertEquals("���������قȂ�I",
                            department,
                            criteria.getDepartmentName());
        Assert.assertEquals("��Ж����قȂ�I",
                            company,
                            criteria.getCompanyName());
    }
    
    

}
