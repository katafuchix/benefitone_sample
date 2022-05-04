/* ======================================================================
 *  $Id: CustomerFindServiceTest.java,v 1.1.1.1 2006/01/29 13:03:26 gon Exp $
 *    tkakeda
 *      2005/04/05
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/05
 * ======================================================================
 */
package jp.co.benefitone.common.sample.business;

import java.util.ArrayList;
import java.util.List;

import jp.co.benefitone.common.fw.integration.DatabaseRuntimeException;
import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import jp.co.benefitone.common.sample.AssertUtil;
import jp.co.benefitone.common.sample.integration.CustomerDAO;
import jp.co.benefitone.common.sample.integration.CustomerDAOImpl;
import jp.co.benefitone.common.sample.integration.MockCustomerDAO;
import jp.co.benefitone.common.sample.model.CustomerNameVO;
import jp.co.benefitone.common.sample.model.CustomerVO;
import junit.framework.TestCase;
import net.sf.hibernate.HibernateException;

/**
 * 顧客検索サービスクラステストケース。
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:26 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CustomerFindServiceTest extends TestCase {
    
    /**
     * BusinessSessinの統計情報オブジェクトの取得設定のテスト。
     * Sessionに既に存在すればそちらを使い、存在しないならインス
     * タンスを生成して格納する。
     * 検索条件もビジネスセッションに格納されているはず。
     */
    public void testFindStatisticsInBusinessSession() {
        MockCustomerFindService service = new MockCustomerFindService();
        MockCustomerDAO dao = new MockCustomerDAO(); 
        service.setCustomerDAO(dao);

        FindCustomerCriteria findCustomerCriteria =
            this.createFindCriteria(null, "Sun", "JAVA");

        BusinessSession beforeSession = new BusinessSession();
        FindCustomerResult findResult =
            service.findCustomer(findCustomerCriteria, beforeSession);

        service.verifyFindCustomerResult(null, "JAVA", "Sun");

        int actual = findResult.getResult().size();
        BusinessSession afterSession = findResult.getBusinessSession();
        FindStatistics statistics =
            (FindStatistics) afterSession.getAttribute("findStatistics");
        FindCustomerCriteria criteria =
            (FindCustomerCriteria) afterSession.getAttribute("criteria");
        
        assertEquals("検索条件が格納されているはず:顧客名=null",
                     null, criteria.getCustomerName());
        assertEquals("検索条件が格納されているはず:部署名=JAVA",
                     "JAVA", criteria.getDepartmentName());
        assertEquals("検索条件が格納されているはず:会社名=Sun",
                     "Sun", criteria.getCompanyName());

        FindCustomerResult resultSecond =
            service.findCustomer(findCustomerCriteria, beforeSession);
        BusinessSession session2 = resultSecond.getBusinessSession();
        FindStatistics statSecond=
            (FindStatistics) session2.getAttribute("findStatistics");
        
        assertSame("同じFindCustomerResultオブジェクトのはず",
                   statistics, statSecond);
        FindCustomerCriteria criteria2 =
            (FindCustomerCriteria) session2.getAttribute("criteria");
        assertSame("同じ検索条件が格納されているはず",
                   criteria, criteria2);

        afterSession.setAttribute("findStatistics", null);
        afterSession.setAttribute("criteria", null);
        FindCustomerResult resultThird =
            service.findCustomer(findCustomerCriteria, afterSession);
        
        BusinessSession session3 = resultThird.getBusinessSession();
        FindStatistics statThird =
            (FindStatistics) session3.getAttribute("findStatistics");

        assertNotSame("違うFindCustomerResultオブジェクトのはず",statistics, statThird);
        FindCustomerCriteria criteria3 =
            (FindCustomerCriteria) session3.getAttribute("criteria");
        assertSame("違う検索条件が格納されているはず",
                   criteria, criteria3);
    }

    /**
     * MockCustomerDAOを使用した統計情報付きの検索テスト。
     *
     */
    public void testFindCustomerWithStatistics() {
        MockCustomerFindService service = new MockCustomerFindService(); 
        service.setCustomerDAO(new MockCustomerDAO()); 
        BusinessSession session = new BusinessSession();
        FindCustomerCriteria findCustomerCriteria =
            this.createFindCriteria(null, "Sun", "JAVA");
        FindCustomerResult findResult =
            service.findCustomer(findCustomerCriteria, session);

        service.verifyFindCustomerResult(null, "JAVA", "Sun");
        int actual = findResult.getResult().size();
        BusinessSession businessSession = findResult.getBusinessSession();
        FindStatistics statistics =
            (FindStatistics) businessSession.getAttribute("findStatistics");
        assertEquals("顧客情報は3件のはず", 3, actual);
        
        assertTrue("1秒以内のはず", statistics.getTime() < 1000);
        assertTrue("1秒以内のはず", statistics.getAverageTime() < 1000);

        //3秒の場合
        FindCustomerCriteria secondCriteria = this.createFindCriteria(null, null, null);
        service.setCustomerDAO(new MockCustomerDAO() {
            public List find(String customerName, String departmentName,
                            String companyName) {
                try {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return createResultByNoCriteria();
                
            }
        });
        //3秒待つはず
        FindCustomerResult resultAll = service.findCustomer(secondCriteria, businessSession);
        System.out.println(statistics.getTime());
        
        assertTrue("2秒から4秒内のはず",
                   (2000 < statistics.getTime() && statistics.getTime() < 4000) );

        System.out.println(statistics.getAverageTime());
        assertTrue("(1以下*1+3)/2=1秒以上3秒以内のはず",
                   1000 < statistics.getAverageTime() && statistics.getAverageTime() < 3000);
    }

    /**
     * MockCustomerDAOを使用した統計情報（1秒を越えた想定)付きの検索テスト。
     *
     */
    public void testFindCustomerWithStatisticsOverOneSecond() {
        MockCustomerFindService service = new MockCustomerFindService(); 
        service.setCustomerDAO(new MockCustomerDAO() {
            public List find(String customerName, String departmentName,
                            String companyName) {
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ArrayList list = new ArrayList();
                list.add(new CustomerVO(new Integer(101),
                                        new CustomerNameVO("Sur1", "Given1"),
                                        "foo@foo.bar",
                                        "03-3333-1111",
                                        "03-3333-1112", null, null));
                return list;
            }
        });

        BusinessSession session = new BusinessSession();
        //検索時に1秒待つようにしている。
        FindCustomerCriteria findCustomerCriteria =
            this.createFindCriteria("Sur1", "Sun", "JAVA");
        FindCustomerResult findResult =
            service.findCustomer(findCustomerCriteria, session);

        service.verifyFindCustomerResult("Sur1", "JAVA", "Sun");
        int actual = findResult.getResult().size();
        assertEquals("顧客情報は1件のはず", 1, actual);
        
        BusinessSession businessSession = findResult.getBusinessSession();
        FindStatistics statistics =
            (FindStatistics) businessSession.getAttribute("findStatistics");
        assertTrue("1秒以上2秒以内のはず",
                   1000 < statistics.getTime() && statistics.getTime() < 2000);
    }

    /**
     * 検索時にDBエラーが発生した場合のテスト。
     * DatabaseRuntimeExceptionがcatchできるはず。
     */
    public void testFindCustomerWhenDatabaseError() {
        CustomerDAO dao = new CustomerDAOImpl() {
            public List find(String customerName,
                            String departmentName,
                            String companyName) {
                try {
                    throw new HibernateException("Error");
                }
                catch (HibernateException e) {
                    throw new DatabaseRuntimeException(e.getMessage());
                }
            }
        };
        CustomerFindServiceImpl service = getCustomerFindService();
        service.setCustomerDAO(dao);
        
        //TODO 例外については未決定。要変更
        try {
            FindCustomerCriteria criteria = createFindCriteria(null, "Sun", null);
            service.findCustomer(criteria);
            fail("DatabaseRuntimeExceptionが送出されるべき！");
        } catch (DatabaseRuntimeException e) {
            assertEquals("例外メッセージが異なる", "Error", e.getMessage());
        }
    }
    /**
     * 全件検索のテスト。
     *
     */
    public void testFindCustomerWithoutCondition() {
        FindCustomerCriteria criteria =
            createFindCriteria(null, null, null);
        CustomerFindServiceImpl service = getCustomerFindService();
        List results = service.findCustomer(criteria);
        assertEquals("全件顧客情報が検索されるはす", 12, results.size());
    }
    
    /**
     * 顧客情報検索テスト。
     * 顧客名のみ。
     */
    public void testFindCustomerByName() {
        FindCustomerCriteria criteria =
            createFindCriteria("Given", null, null);

        CustomerFindServiceImpl service = getCustomerFindService();

        List results = service.findCustomer(criteria);
        int actual = results.size();
        assertEquals("顧客情報は5件のはず", 5, actual);
        
        List expected = new ArrayList();
        expected.add(createCustomerVO(101, "Sur1", "Given1",
                                      "foo@foo.bar", "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(102, "Sur2", "Given2",
                                      "foo@foo.bar", "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(103, "Sur3", "Given3",
                                      "foo@foo.bar", "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(104, "Sur4", "Given4",
                                      "foo@foo.bar", "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(105, "Sur5", "Given5",
                                      "foo@foo.bar", "03-3333-1111", "03-3333-1112"));
        AssertUtil.assertListEquals(expected, results);
    }
    
    /**
     * MockCustomerDAOを使用した会社名のみの検索テスト。
     *
     */
    public void testFindCustomerByCompanyName() {
        FindCustomerCriteria criteria =
            createFindCriteria(null, "Sun Micro", null);

        CustomerFindServiceImpl service = getCustomerFindService();

        List results = service.findCustomer(criteria);
        int actual = results.size();
        assertEquals("顧客情報は10件のはず", 10, actual);
        
        List expected = new ArrayList();
        expected.add(createCustomerVO(101, "Sur1", "Given1",
                                      "foo@foo.bar", "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(102, "Sur2", "Given2",
                                      "foo@foo.bar", "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(103, "Sur3", "Given3",
                                      "foo@foo.bar", "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(104, "Sur4", "Given4",
                                      "foo@foo.bar", "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(105, "Sur5", "Given5",
                                      "foo@foo.bar", "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(106, "Sur6", "Given6",
                                      "foo@foo.bar", "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(107, "Sur7", "Given7",
                                      "foo@foo.bar", "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(108, "Sur8", "Given8",
                                      "foo@foo.bar", "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(109, "Sur9", "Given9",
                                      "foo@foo.bar", "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(110, "Sur10", "Given10",
                                      "foo@foo.bar", "03-3333-1111", "03-3333-1112"));
        AssertUtil.assertListEquals(expected, results);
    }
    
    /**
     * MockCustomerDAOを使用した部署名のみの検索テスト。
     *
     */
    public void testFindCustomerByDepartment() {
        FindCustomerCriteria criteria =
            createFindCriteria(null, null, "JAVA");
        CustomerFindServiceImpl service = getCustomerFindService();

        List results = service.findCustomer(criteria);
        int actual = results.size();
        assertEquals("顧客情報は2件のはず", 2, actual);

        List expected = new ArrayList();
        expected.add(createCustomerVO(101, "Sur1", "Given1", "foo@foo.bar",
                                      "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(102, "Sur2", "Given2", "foo@foo.bar",
                                      "03-3333-1111", "03-3333-1112"));
        AssertUtil.assertListEquals(expected, results);

    }
    
    /**
     * MockCustomerDAOを使用した全条件検索テスト。
     *
     */
    public void testFindCustomerByAll() {
        FindCustomerCriteria criteria =
            createFindCriteria("Kake", "Sun", "JAVA");
        CustomerFindServiceImpl service = getCustomerFindService();
        
        List results = service.findCustomer(criteria);
        int actual = results.size();
        assertEquals("顧客情報は1件のはず", 1, actual);
        
        List expected = new ArrayList();
        expected.add(createCustomerVO(101, "Sur1", "Given1", "foo@foo.bar",
                                      "03-3333-1111", "03-3333-1112"));
        AssertUtil.assertListEquals(expected, results);
    }

    /**
     * MockCustomerDAOを使用した部署名、会社名での検索テスト。
     *
     */
    public void testFIndCustomerByCompanyAndDepartment() {
        FindCustomerCriteria criteria =
            createFindCriteria(null, "Sun", "JAVA");
        CustomerFindServiceImpl service = getCustomerFindService();

        List results = service.findCustomer(criteria);
        int actual = results.size();
        assertEquals("顧客情報は3件のはず", 3, actual);

        List expected = new ArrayList();
        expected.add(createCustomerVO(102, "Sur2", "Given2", "foo@foo.bar",
                                      "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(103, "Sur3", "Given3", "foo@foo.bar",
                                      "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(104, "Sur4", "Given4", "foo@foo.bar",
                                      "03-3333-1111", "03-3333-1112"));
        AssertUtil.assertListEquals(expected, results);
    }
    
    /**
     * MockCustomerDAOを使用した顧客名、会社名による検索テスト。
     *
     */
    public void testFindCustomerByCustomerAndCompany() {
        FindCustomerCriteria criteria =
            createFindCriteria("Takeshi", "Sun", null);
        CustomerFindServiceImpl service = getCustomerFindService();
        
        List results = service.findCustomer(criteria);
        assertEquals("顧客情報は2件のはず", 2, results.size());
        
        List expected = new ArrayList();
        expected.add(createCustomerVO(103, "Sur3", "Takeshi", "foo@foo.bar",
                                      "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(104, "Sur4", "Takeshi", "foo@foo.bar",
                                      "03-3333-1111", "03-3333-1112"));
        AssertUtil.assertListEquals(expected, results);
    }
    
    /**
     * MockCustomerDAOによる顧客名、部署名での検索テスト。
     *
     */
    public void testFindCustomerByCustomerAndDepartment() {
        FindCustomerCriteria criteria =
            createFindCriteria("Takeshi", null, "JAVA");
        
        CustomerFindServiceImpl service = getCustomerFindService();
        List results = service.findCustomer(criteria);
        assertEquals("顧客情報は1件のはず", 1, results.size());
        List expected = new ArrayList();
        expected.add(createCustomerVO(103, "Sur3", "Takeshi", "foo@foo.bar",
                                      "03-3333-1111", "03-3333-1112"));
        AssertUtil.assertListEquals(expected, results);
    }

    /**
     * MockCustomerDAOを用いた顧客の1件取得テスト。
     *
     */
    public void testSelectCustomerUsingMockDAO() {
        CustomerFindServiceImpl service = getCustomerFindService();
        CustomerVO actual = service.selectCustomer(new Integer(3001));
        assertNotNull("顧客情報は1件取得できているはず", actual);
        
        CustomerVO expected =
            createCustomerVO(3001,
                             "Sato",
                             "Eriko",
                             "satoeri@sample.com",
                             "090-9898-1212","090-9898-1212");
        assertEquals("同じ顧客情報のはず", actual, expected);
    }
//    public void testFindCustomerServiceWired() {
//        Configuration config = new Configuration();
//        try {
//            config.addClass(CustomerVO.class);
//            config.addClass(DepartmentVO.class);
//            config.addClass(CompanyVO.class);
//            sessionFactory = config.buildSessionFactory();
//        }
//        catch (MappingException e) {
//            throw new RuntimeException(e);
//        }
//        catch (HibernateException e) {
//            throw new RuntimeException(e);
//        }
//        
//    }

    /**
     * MockCustomerDAOを使用してCustomerFindServiceの生成を行います。
     * @return CustomerFindServiceオブジェクト
     */
    private CustomerFindServiceImpl getCustomerFindService() {
        CustomerFindServiceImpl service = new CustomerFindServiceImpl();
        MockCustomerDAO dao = new MockCustomerDAO();
        service.setCustomerDAO(dao);
        return service;
    }

    /**
     * 条件オブジェクトを作成します。
     * @param customer 顧客名
     * @param company 会社名
     * @param department 部署名
     * @return 検索条件オブジェクト
     */
    private FindCustomerCriteria createFindCriteria(String customer, String company, String department) {
        FindCustomerCriteria criteria = new FindCustomerCriteria();
        criteria.setCustomerName(customer);
        criteria.setCompanyName(company);
        criteria.setDepartmentName(department);
        return criteria;
    }


     /**
     * @param id
     * @param lastName
     * @param firstName
     * @param email
     * @param phone
     * @param fax
     * @return
     */
    private CustomerVO createCustomerVO(
                           int id,
                           String lastName,
                           String firstName,
                           String email,
                           String phone,
                           String fax) {
        CustomerVO expected = new CustomerVO();
        expected.setId(new Integer(id));
        expected.setName(new CustomerNameVO());
        expected.getName().setLastName(lastName);
        expected.getName().setFirstName(firstName);
        expected.setEmail(email);
        expected.setPhone(phone);
        expected.setFax(fax);
        return expected;
    }

    /**
     * @return
     */
    private ArrayList createResultByAll() {
        ArrayList list = new ArrayList();
        list.add(new CustomerVO(new Integer(101),
                                 new CustomerNameVO("Sur1", "Given1"),
                                 "foo@foo.bar",
                                 "03-3333-1111",
                                 "03-3333-1112",null, null));
        list.add(new CustomerVO(new Integer(102),
                                 new CustomerNameVO("Sur2", "Given2"),
                                 "foo@foo.bar",
                                 "03-3333-1111",
                                 "03-3333-1112",
                                 null,null));
        list.add(new CustomerVO(new Integer(103),
                                new CustomerNameVO("Sur3", "Given3"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
        list.add(new CustomerVO(new Integer(104),
                                new CustomerNameVO("Sur4", "Given4"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
        list.add(new CustomerVO(new Integer(104),
                                new CustomerNameVO("Sur4", "Given4"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
        list.add(new CustomerVO(new Integer(105),
                                new CustomerNameVO("Sur5", "Given5"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
        list.add(new CustomerVO(new Integer(106),
                                new CustomerNameVO("Sur6", "Given6"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
        list.add(new CustomerVO(new Integer(107),
                                new CustomerNameVO("Sur7", "Given7"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
        list.add(new CustomerVO(new Integer(108),
                                new CustomerNameVO("Sur8", "Given8"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
        list.add(new CustomerVO(new Integer(109),
                                new CustomerNameVO("Sur9", "Given9"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
        list.add(new CustomerVO(new Integer(110),
                                new CustomerNameVO("Sur10", "Given10"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
        list.add(new CustomerVO(new Integer(111),
                                new CustomerNameVO("Sur11", "Given11"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
        return list;
    }
}
