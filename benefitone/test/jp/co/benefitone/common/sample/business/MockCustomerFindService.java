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
     * 検索条件を保持する疑似メソッド。 
     */
    public List findCustomer(FindCustomerCriteria criteria) {
        this.criteria = criteria;
        return super.findCustomer(criteria);
    }
    
    /**
     * 検索条件を保持する。 
     */
    public FindCustomerResult findCustomer(
                    FindCustomerCriteria criteria,
                    BusinessSession session) {
        this.criteria = criteria;
        return super.findCustomer(criteria, session);
    }
    
    /**
     * 検索条件の検証を行います。
     * @param customer 顧客名
     * @param department 部署名
     * @param company 会社名
     */
    public void verifyFindCustomerResult(
                    String customer,
                    String department,
                    String company) {
        Assert.assertEquals(
                            "顧客名が異なる！",
                            customer,
                            criteria.getCustomerName());
        Assert.assertEquals("部署名が異なる！",
                            department,
                            criteria.getDepartmentName());
        Assert.assertEquals("会社名が異なる！",
                            company,
                            criteria.getCompanyName());
    }
    
    

}
