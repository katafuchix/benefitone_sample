/* ======================================================================
 *  $Id: CustomerManageServiceTest.java,v 1.1.1.1 2006/01/29 13:03:26 gon Exp $
 *    tkakeda
 *      2005/04/05
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/05
 * ======================================================================
 */
package jp.co.benefitone.common.sample.business;

import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import jp.co.benefitone.common.sample.integration.MockCustomerDAO;
import jp.co.benefitone.common.sample.model.CompanyVO;
import jp.co.benefitone.common.sample.model.CustomerNameVO;
import jp.co.benefitone.common.sample.model.CustomerVO;
import jp.co.benefitone.common.sample.model.DepartmentVO;
import junit.framework.TestCase;
import net.sf.hibernate.SessionFactory;

/**
 * 顧客管理サービスクラステストケース。
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:26 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CustomerManageServiceTest extends TestCase {
    private MockCustomerManageService service;
    private MockCustomerDAO dao;

    protected void setUp() {
        service = new MockCustomerManageService();
        dao = new MockCustomerDAO();
        MockCustomerFindService findService = new MockCustomerFindService();
        findService.setCustomerDAO(dao);
        service.setCustomerDAO(dao);
        service.setCustomerFindService(findService);
    }

    /**
     * 顧客情報を1件削除した場合のテストです。
     */
    public void testDeleteCustomerUsingMockDAO() {

        BusinessSession session = new BusinessSession();
        FindCustomerCriteria criteria = createFindCustomerCriteria(null, "JAVA", "Sun");
        dao.verifyDeleteResult(5);

        // 1件の顧客情報を削除する
        FindCustomerResult deleteResult = service.deleteCustomer(new Integer("101"), 
                                                                 criteria,
                                                                 session);
        dao.verifyDeleteResult(4);
    }
    

    /**
     * 顧客情報のサニタイズテスト。
     * 会社名と顧客情報が入力されているが、部署の情報が
     * 入力されていない場合。
     * 通常はこのようなオブジェクトは渡されない。
     */
    public void testSanitizeCustomerWithCompanyName() {
        CustomerVO customer = createDummyCustomer(
                                new Integer(3001),
                                "FIRST1",
                                "LAST1",
                                "first1@sun.com",
                                "03-5999-2121",
                                "03-5999-2123",
                                createDummyCompany(
                                    null,
                                    "SUN"),
                                null);
        CustomerVO sanitizedCustomer = service.sanitizeCustomer(customer);

        assertEquals("顧客ID:3001のはず", new Integer(3001), customer.getId());
        assertEquals("顧客名:FIRST1のはず", "FIRST1", customer.getName().getFirstName());
        assertEquals("顧客名:LAST1のはず", "LAST1", customer.getName().getLastName());
        assertEquals("EMAIL:first1@sun.comのはず", "first1@sun.com", customer.getEmail());
        assertEquals("電話番号:03-5999-2121のはず", "03-5999-2121", customer.getPhone());
        assertEquals("FAX:03-5999-2123のはず", "03-5999-2123", customer.getFax());
        assertEquals("会社ID:1001のはず", new Integer(1001), customer.getCompany().getId());
        assertEquals("会社名:SUNのはず", "SUN", customer.getCompany().getName());
        assertEquals("部署ID:2001のはず", new Integer(2001), customer.getDepartment().getId());
        assertEquals("部署名:JAVAのはず", "JAVA", customer.getDepartment().getName());
        assertEquals("部署の住所:YOUGAのはず", "YOUGA", customer.getDepartment().getAddress());
    }

    /**
     * 顧客情報のサニタイズテスト。
     * 新規登録の場合、会社IDと部署ID、そして顧客ID は null で
     * オブジェクトが渡される
     */
    public void testSanitizeCustomerNewRegist() {
        CustomerVO customer = createDummyCustomer(
                                null,
                                "FIRST1",
                                "LAST1",
                                "first1@sun.com",
                                "03-5999-2121",
                                "03-5999-2123",
                                createDummyCompany(
                                    null,
                                    "SUN"),
                                createDummyDepartment(
                                    null,
                                    "JAVA",
                                    "SANNO"));
        CustomerVO sanitizedCustomer = service.sanitizeCustomer(customer);
        assertTrue("顧客ID:nullのはず", null ==  customer.getId());
        assertEquals("顧客名:FIRST1のはず", "FIRST1", customer.getName().getFirstName());
        assertEquals("顧客名:LAST1のはず", "LAST1", customer.getName().getLastName());
        assertEquals("EMAIL:first1@sun.comのはず", "first1@sun.com", customer.getEmail());
        assertEquals("電話番号:03-5999-2121のはず", "03-5999-2121", customer.getPhone());
        assertEquals("FAX:03-5999-2123のはず", "03-5999-2123", customer.getFax());
        assertEquals("会社ID:1001のはず", new Integer(1001), customer.getCompany().getId());
        assertEquals("会社名:SUNのはず", "SUN", customer.getCompany().getName());
        assertEquals("部署ID:2001のはず", new Integer(2001), customer.getDepartment().getId());
        assertEquals("部署名:JAVAのはず", "JAVA", customer.getDepartment().getName());
        assertEquals("部署の住所:SANNOのはず", "SANNO", customer.getDepartment().getAddress());
    }

    /**
     * 顧客の保存テストケース(Mockオブジェクトを使用)。
     */
    public void testSaveCustomerInsertedCase() {
        MockSession session = new MockSession(); 
        SessionFactory sessionFactory = new MockSessionFactory(session);
        dao.setSessionFactory(sessionFactory);
        service.setCustomerDAO(dao);
        CustomerVO customer = new CustomerVO(null,
                                             new CustomerNameVO("宏一","佐藤"),
                                             "sato@sato.com",
                                             "03-9999-1234","03-9999-1235",
                                             new DepartmentVO(new Integer(1),"Dummpy","東京都世田谷区用賀"),
                                             new CompanyVO(new Integer(2),"Sun Mircosystems"));
        BusinessSession bsession = new BusinessSession();
        String customerName = "dummyCustomer";
        String deptName = "dummyDept";
        String companyName = "dummyCompany";
        FindCustomerCriteria criteria =
            createCriteria(customerName, deptName, companyName);
        bsession.setAttribute("criteria", criteria);
        service.saveCustomer(customer, bsession);

        MockCustomerFindService findService =
            (MockCustomerFindService) service.getCustomerFindService();
        findService.verifyFindCustomerResult(customerName,
                                             deptName,
                                             companyName);
        session.verifyInserted();
        dao.verifyAssignedId();
    }
    
    /**
     * @param customerName
     * @param deptName
     * @param companyName
     */
    private FindCustomerCriteria createCriteria(String customerName, String deptName, String companyName) {
        FindCustomerCriteria criteria = new FindCustomerCriteria();
        criteria.setCustomerName(customerName);
        criteria.setDepartmentName(deptName);
        criteria.setCompanyName(companyName);
        return criteria;
    }

    /**
     * 顧客の更新テストケース(MockObjectを使用)。
     *
     */
    public void testSaveCustomerUpdatedCase() {
        MockSession session = new MockSession(); 
        SessionFactory sessionFactory = new MockSessionFactory(session);
        dao.setSessionFactory(sessionFactory);
        service.setCustomerDAO(dao);
        CustomerVO customer = new CustomerVO(new Integer(10),
                                             new CustomerNameVO("宏一","佐藤"),
                                             "sato@sato.com",
                                             "03-9999-1234","03-9999-1235",
                                             new DepartmentVO(new Integer(1),"Dummpy","東京都世田谷区用賀"),
                                             new CompanyVO(new Integer(2),"Sun Mircosystems"));
        BusinessSession bsession = new BusinessSession();
        String customerName = "dummyCustomer";
        String deptName = "dummyDept";
        String companyName = "dummyCompany";
        FindCustomerCriteria criteria =
            createCriteria(customerName, deptName, companyName);
        bsession.setAttribute("criteria", criteria);

        service.saveCustomer(customer, bsession);

        MockCustomerFindService findService =
            (MockCustomerFindService) service.getCustomerFindService();
        findService.verifyFindCustomerResult(customerName,
                                             deptName,
                                             companyName);
        session.verifyUpdated();
        dao.verifyAssignedId();
    }

    public void testSaveCustomerCriteriaNotSet() {
        MockSession session = new MockSession(); 
        SessionFactory sessionFactory = new MockSessionFactory(session);
        dao.setSessionFactory(sessionFactory);
        service.setCustomerDAO(dao);
        CustomerVO customer = new CustomerVO(new Integer(10),
                                             new CustomerNameVO("宏一","佐藤"),
                                             "sato@sato.com",
                                             "03-9999-1234","03-9999-1235",
                                             new DepartmentVO(new Integer(1),"Dummpy","東京都世田谷区用賀"),
                                             new CompanyVO(new Integer(2),"Sun Mircosystems"));
        BusinessSession bsession = new BusinessSession();
        service.saveCustomer(customer, bsession);

        MockCustomerFindService findService =
            (MockCustomerFindService) service.getCustomerFindService();
        findService.verifyFindCustomerResult(null,
                                             null,
                                             null);
        session.verifyUpdated();
        dao.verifyAssignedId();
    }
    
    private FindCustomerCriteria createFindCustomerCriteria(
            String customerName, String departmentName, String companyName) {
        FindCustomerCriteria findCustomerCriteria = new FindCustomerCriteria();
        findCustomerCriteria.setCustomerName(customerName);
        findCustomerCriteria.setDepartmentName(departmentName);
        findCustomerCriteria.setCompanyName(companyName);
        return findCustomerCriteria;
    }

    private CompanyVO createDummyCompany(Integer id, String name) {
        return new CompanyVO(id,name);
    }

    private DepartmentVO createDummyDepartment(Integer id,
                                               String name,
                                               String address) {
        return new DepartmentVO(id, name, address);
    }

    private CustomerVO createDummyCustomer(Integer id,
                                           String firstName,
                                           String lastName,
                                           String email,
                                           String phone,
                                           String fax,
                                           CompanyVO company,
                                           DepartmentVO dept) {
        return new CustomerVO(id, 
                              new CustomerNameVO(firstName,lastName),
                              email,
                              phone,
                              fax,
                              dept,
                              company);
    }
}
