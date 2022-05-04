/*
 * ====================================================================== $Id:
 * CustomerDAOImplTest.java,v 1.1 2005/04/07 14:11:38 tk158799 Exp $ tkakeda
 * 2005/04/07 Originator: first.last@Sun.COM OriginDate: 2005/MM/dd
 * ======================================================================
 */
package jp.co.benefitone.common.sample.integration;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import jp.co.benefitone.common.fw.integration.HibernateUtil;
import jp.co.benefitone.common.sample.AssertUtil;
import jp.co.benefitone.common.sample.TestSupport;
import jp.co.benefitone.common.sample.model.CompanyVO;
import jp.co.benefitone.common.sample.model.CustomerNameVO;
import jp.co.benefitone.common.sample.model.CustomerVO;
import jp.co.benefitone.common.sample.model.DepartmentVO;
import junit.framework.TestCase;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 顧客DAO実装クラスのテストケース。 SessionFactoryはsetterでDAOに渡す。
 * 
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:26 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CustomerDAOImplTest extends TestCase {

    private SessionFactory sessionFactory;

    private CustomerDAOImpl dao;

    private Connection con;

    private static ClassPathXmlApplicationContext context;
    private Session session;

    /**
     * 
     */
    public CustomerDAOImplTest(String name) {
        super(name);
        context = new ClassPathXmlApplicationContext("test-datasource-context.xml");
        sessionFactory = (SessionFactory) context.getBean("b1SessionFactory");
    }

    /*
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        Session session = null;
        try {
            session = HibernateUtil.getSession(sessionFactory);
//            Transaction tran = session.beginTransaction();
            con = session.connection();
            TestSupport.executeSQLFromFile("test/testdata/customerdao-delete.sql",
                                           con);
            TestSupport.executeSQLFromFile("test/testdata/customerdao-data.sql",
                                           con);
            con.commit();
//            session.flush();
//            tran.commit();
            HibernateUtil.closeSession(session);
            dao = (CustomerDAOImpl) context.getBean("customerDAO");
        }
        catch (Exception e) {
            if (session != null ) {
                session.close();
            }
            throw e;
        } 
    }

    /*
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
//        session = HibernateUtil.getSession(sessionFactory);
//        session.flush();
//        HibernateUtil.closeSession(session);
        dao = null;
    }

    /**
     * 顧客情報全件検索のテスト。
     */
    public void testCustomerFindAll() {
        List results = dao.find(null, null, null);
        assertEquals("15件のデータが取得できるはず", 15, results.size());
        
        CompanyVO sun = new CompanyVO(new Integer(1001), "SUN");
        CompanyVO ibm = new CompanyVO(new Integer(1002), "IBM");
        CompanyVO ms = new CompanyVO(new Integer(1003), "MS");
        
        DepartmentVO java = new DepartmentVO(new Integer(2001),"JAVA","YOUGA");
        DepartmentVO solaris = new DepartmentVO(new Integer(2002),"SOLARIS","YOUGA");
        DepartmentVO sparc = new DepartmentVO(new Integer(2003),"SPARC","YOUGA");
        DepartmentVO dotnet= new DepartmentVO(new Integer(2006),"DOTNET","SHINJUKU");

        List expected = new ArrayList();
        expected.add(new CustomerVO(new Integer(3001),
                                    new CustomerNameVO("FIRST1","LAST1"),
                                    "first1@sun.com",
                                    "03-5999-2121",
                                    "03-5999-2123",
                                    java, sun));
        expected.add(new CustomerVO(new Integer(3002),
                                     new CustomerNameVO("FIRST2","LAST2"), 
                                     "first2@sun.com",
                                     "03-5999-2121",
                                     "03-5999-2123",
                                     solaris, sun));
        expected.add(new CustomerVO(new Integer(3003),
                                    new CustomerNameVO("FIRST3","LAST3"),
                                    "first3@sun.com",
                                    "03-5999-2121",
                                    "03-5999-2123",java,sun));
        expected.add(new CustomerVO(new Integer(3004),
                                    new CustomerNameVO("FIRST4","LAST4"),
                                    "first4@sun.com",
                                    "03-5999-2121",
                                    "03-5999-2123",solaris, sun));
        expected.add(new CustomerVO(new Integer(3005),
                                    new CustomerNameVO("FIRST5","LAST5"),
                                    "first5@sun.com",
                                    "03-5999-2121",
                                    "03-5999-2123",java,sun));
        expected.add(new CustomerVO(new Integer(3006),
                                    new CustomerNameVO("FIRST6","LAST6"),
                                    "first6@sun.com",
                                    "03-5999-2121",
                                    "03-5999-2123",sparc, sun));
        expected.add(new CustomerVO(new Integer(3007),
                                    new CustomerNameVO("FIRST7","LAST7"),
                                    "first7@sun.com",
                                    "03-5999-2121",
                                    "03-5999-2123", solaris, sun));
        expected.add(new CustomerVO(new Integer(3008),
                                    new CustomerNameVO("FIRST8","LAST8"),
                                    "first8@sun.com",
                                    "03-5999-2121",
                                    "03-5999-2123", java, sun));
        expected.add(new CustomerVO(new Integer(3009),
                                    new CustomerNameVO("FIRST9","LAST9"),
                                    "first9@sun.com",
                                    "03-5999-2121",
                                    "03-5999-2123", java,sun));
        expected.add(new CustomerVO(new Integer(3010),
                                    new CustomerNameVO("FIRST10","LAST10"),
                                    "first10@sun.com",
                                    "03-5999-2121",
                                    "03-5999-2123",java,sun));
        expected.add(new CustomerVO(new Integer(3011),
                                    new CustomerNameVO("taro","yamada"),
                                    "yamada@sun.com",
                                    "03-5999-2121",
                                    "03-5999-2123", java, ibm));
        expected.add(new CustomerVO(new Integer(3012),
                                    new CustomerNameVO("jiro","yamadayama"),
                                    "yamadayama@sun.com",
                                    "03-5999-2121",
                                    "03-5999-2123", java, ibm));
        expected.add(new CustomerVO(new Integer(3013),
                                    new CustomerNameVO("FIRST11","LAST11"),
                                    "first11@sun.com",
                                    "03-5999-2121",
                                    "03-5999-2123", java, ibm));
        expected.add(new CustomerVO(new Integer(3014),
                                    new CustomerNameVO("FIRST12","LAST12"),
                                    "first12@sun.com",
                                    "03-5999-2121",
                                    "03-5999-2123", java, ms));
        expected.add(new CustomerVO(new Integer(3015), 
                                    new CustomerNameVO("Takeshi","Kitano"), 
                                    "tk9999@sun.com",
                                    "03-5999-2121",
                                    "03-5999-2123", dotnet, ms));
        AssertUtil.assertListEquals(expected, results);
        //一件目のみ
        CustomerVO vo = (CustomerVO) results.get(0);
        assertEquals("SUN", vo.getCompany().getName());
        assertEquals("JAVA", vo.getDepartment().getName());
    }

    public void testFindCustomerName() {
        List results = dao.find("yamada", null, null);
        assertEquals("yamadaにマッチするのは2件のはず", 2, results.size());

        results = dao.find("taro", null, null);
        assertEquals("taroにマッチするのは1件のはず", 1, results.size());

        results = dao.find("ro", null, null);
        assertEquals("roにマッチするのは2件のはず", 2, results.size());

        results = dao.find("yama", null, null);
        assertEquals("yamaにマッチするのは2件のはず", 2, results.size());

        results = dao.find("FIRST", null, null);
        assertEquals("FIRSTにマッチするのは12件のはず", 12, results.size());
        
        results = dao.find("FIRST1", null, null);
        assertEquals("フルネーム FIRST1にマッチするのは4件のはず", 4, results.size());
        
    }

    /**
     * 部署名による顧客検索のテスト。
     */
    public void testFindCustomerByDepartment() {
        List results = dao.find(null, "JAVA", null);
        assertEquals("10件該当するはず", 10, results.size());
    }

    public void testFindCustomerByCompany() {
        List results = dao.find(null, null, "SUN");
        assertEquals("10件該当するはず", 10, results.size());

        results = dao.find(null, null, "IBM");
        assertEquals("3件該当するはず", 3, results.size());

        results = dao.find(null, null, "MS");
        assertEquals("2件のはず", 2, results.size());
    }

    /**
     * 会社名と部署名が指定された場合の検索テスト。
     */
    public void testFindCustomerByComopanyAndDepartment() {
        List results = dao.find(null, "JAVA", "SUN");
        assertEquals("会社がSUN、部署がJAVAな顧客は6件のはず", 6, results.size());
    }

    /**
     * 顧客名と会社名が指定された場合の検索テスト。
     */
    public void testFindCustomerByCustomerAndCompany() {
        List results = dao.find("FIRST1", null, "SUN");
        assertEquals("会社がSUN、名前にFIRST1が含まれる顧客は2件のはず", 2, results.size());

        results = dao.find("yamada", null, "SUN");
        assertEquals("会社がSUN、名前にyamadaが含まれる顧客は0件のはず", 0, results.size());
    }

    /**
     * 顧客名と部署名が指定された場合の検索テスト。
     */
    public void testFindCustomerByCustomerAndDepartment() {
        List results = dao.find("FIRST", "JAVA", null);
        assertEquals("部署名がJAVA、名前にFIRSTが含まれる顧客は8件のはず", 8, results.size());

        results = dao.find("FIRST", "SOLARIS", null);
        assertEquals("部署名がSOLARIS、名前にFIRSTが含まれる顧客は3件のはず", 3, results.size());

        results = dao.find("FIRST", "SPARC", null);
        assertEquals("部署名がSPARC、名前にFIRSTが含まれる顧客は1件のはず", 1, results.size());
    }

    /**
     * 全条件を渡した場合の検索テスト。
     *
     */
    public void testFindCustomerAllCondition() {
        List results = dao.find("FIRST", "JAVA", "SUN");
        assertEquals("顧客名:FIRST、部署名:JAVA、会社名:SUNのデータは6件のはず", 6, results.size());

        results = dao.find("FIRST1", "JAVA", "SUN");
        assertEquals("顧客名:FIRST、部署名:JAVA、会社名:SUNのデータは2件のはず", 2, results.size());

        results = dao.find("FIRST1", "JAVA", "MS");
        assertEquals("顧客名:FIRST、部署名:JAVA、会社名:MSのデータは1件のはず", 1, results.size());

        results = dao.find("FIRST1", "SPARC", "MS");
        assertEquals("顧客名:FIRST、部署名:SPARC、会社名:MSのデータは0件のはず", 0, results.size());
    }

    /**
     * findメソッドで全ケースを確認する。
     */
    public void testFindAllCase() {
        List results = dao.find(null, null, null);
        assertEquals("条件無し検索は15件のはず",15, results.size());
        results = dao.find("taro", null, null);
        assertEquals("名前のみ検索は1件のはず",1, results.size());
        results = dao.find(null, "SPARC", null);
        assertEquals("部署:SPARC のみ検索は1件のはず",1, results.size());
        results = dao.find(null, null, "MS");
        assertEquals("会社:MS のみ検索は2件のはず",2, results.size());
        results = dao.find("yamada", null, "IBM");
        assertEquals("名前:yamada, 会社:IBMの検索は2件のはず",2, results.size());
        results = dao.find(null, "JAVA", "IBM");
        assertEquals("部署:JAVA, 会社:IBMの検索は3件のはず",3, results.size());
        results = dao.find("taro", "JAVA", "IBM");
        assertEquals("名前:taro, 部署:JAVA, 会社:IBMの検索は2件のはず",1, results.size());
    }
    public void testGetCustomerSuccess() {
        CustomerVO actual = dao.select(new Integer(3001));

        CustomerVO expected = new CustomerVO();
        expected.setId(new Integer(3001));
        CustomerNameVO name = new CustomerNameVO();
        name.setFirstName("FIRST1");
        name.setLastName("LAST1");
        expected.setName(name);
        expected.setPhone("03-5999-2121");
        expected.setFax("03-5999-2123");
        expected.setEmail("first1@sun.com");
        expected.setDepartment(new DepartmentVO(new Integer(2001),"JAVA","YOUGA"));
        expected.setCompany(new CompanyVO(new Integer(1001),"SUN"));
        assertEquals("同じ顧客情報のはず", expected, actual);
    }
    
    public void testGetDAOFromSpring() {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext(
                                               new String[] {
                                               "test-datasource-context.xml"
                                               });
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        CustomerVO vo = customerDAO.select(new Integer(3001));
        assertNotNull(vo);

        CustomerVO expected = new CustomerVO();
        expected.setId(new Integer(3001));
        CustomerNameVO name = new CustomerNameVO();
        name.setFirstName("FIRST1");
        name.setLastName("LAST1");
        expected.setName(name);
        expected.setPhone("03-5999-2121");
        expected.setFax("03-5999-2123");
        expected.setEmail("first1@sun.com");
        expected.setDepartment(new DepartmentVO(new Integer(2001), "JAVA", "YOUGA"));
        expected.setCompany(new CompanyVO(new Integer(1001), "SUN"));
        assertEquals("同じ顧客情報のはず", expected, vo);
        
    }

    /**
     * 存在しない顧客情報を削除しても、件数が変らないことを確認する。
     */
    public void testDeleteCustomerFailure() {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext(
                                               new String[] {
                                               "test-datasource-context.xml"
                                               });
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        List results = dao.find(null, null, null);
        assertEquals("15件のデータが取得できるはず", 15, results.size());

        // 存在しない顧客IDを削除する
        dao.delete(new Integer("99999999"));

        results = dao.find(null, null, null);
        assertEquals("15件のデータが取得できるはず", 15, results.size());
    }

    /**
     * 顧客情報を削除し、件数が1件減ることを確認する
     */
    public void testDeleteCustomerSuccess() {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext(
                                               new String[] {
                                               "test-datasource-context.xml"
                                               });
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        List results = dao.find(null, null, null);
        int before = results.size();
        assertEquals("15件のデータが取得できるはず", 15, before);

        CustomerVO customer = (CustomerVO) results.get(0);
        dao.delete(customer.getId());
//        customer.getDepartment().getCustomers().remove(customer);
//        customer.getCompany().getCustomers().remove(customer);

        results = dao.find(null, null, null);
        int expected = before - results.size();
        assertEquals("1件のデータが削除されているはず", 1, expected);
    }

    /**
     * 会社情報を名前指定で検索する。
     */
    public void testSelectCompanyByName() {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext(
                                               new String[] {
                                               "test-datasource-context.xml"
                                               });
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        // 1件取得できるはず
        CompanyVO company = customerDAO.selectCompanyByName("SUN");
        assertEquals("会社名:SUNのはず", "SUN", company.getName());
        assertEquals("会社ID:1001のはず", new Integer(1001), company.getId());

        // 取得できないはず
        company = customerDAO.selectCompanyByName("FOO");
        assertTrue("null のはず", null == company);

        company = customerDAO.selectCompanyByName(null);
        assertTrue("null のはず", null == company);
    }

    /**
     * 部署情報を、部署名と会社IDから検索する。
     */
    public void testSelectDepartmentByNameAndCompanyId() {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext(
                                               new String[] {
                                               "test-datasource-context.xml"
                                               });
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        DepartmentVO dept = customerDAO.selectDepartmentByNameAndCompanyId(
                                "JAVA", new Integer(1001));
        assertEquals("部署名:JAVAのはず", "JAVA", dept.getName());
        assertEquals("部署ID:2001のはず", new Integer(2001), dept.getId());

        // 取得できないはず
        dept = customerDAO.selectDepartmentByNameAndCompanyId(
                                "JAVA", new Integer(-1));
        assertTrue("null のはず", null == dept);

        dept = customerDAO.selectDepartmentByNameAndCompanyId("JAVA", null);
        assertTrue("null のはず", null == dept);

        dept = customerDAO.selectDepartmentByNameAndCompanyId(
                                null, new Integer(1001));
        assertTrue("null のはず", null == dept);

        dept = customerDAO.selectDepartmentByNameAndCompanyId(null, null);
        assertTrue("null のはず", null == dept);
    }
    
    /**
     * 新規顧客として保存するテストケース。
     * 既存の部署、会社を使用。
     * @throws HibernateException
     */
    public void testSaveAsNewCustomer() throws HibernateException {
        session = HibernateUtil.getSession(sessionFactory);
        DepartmentVO dept =
            (DepartmentVO)session.load(DepartmentVO.class, new Integer(2001));
        CompanyVO company =
            (CompanyVO)session.load(CompanyVO.class, new Integer(1001));
        CustomerVO vo =
            new CustomerVO(null, 
                           new CustomerNameVO("秀樹","松井"),
                           "hideki@yankees.com",
                           "+81-03-4500-1000",
                           "+81-03-4500-1001",
                           dept,
                           company);
        assertEquals("データは存在しないはず",
                     0, dao.find("松井",null,null).size());
        HibernateUtil.clearAllSessions();
        dept.setCompany(company);

        dao.save(vo);
        CustomerVO actual = (CustomerVO) dao.find("松井",null,null).get(0);
        assertEquals("同じ顧客情報のはず", vo, actual);
        DepartmentVO department = actual.getDepartment();
        CompanyVO company2 = actual.getCompany();

        HibernateUtil.clearAllSessions();
        assertEquals("同じ部署のはず", department, vo.getDepartment());
        assertEquals("同じ会社のはず", company2, vo.getCompany());
    }
    
    /**
     * 新規顧客、新規部署、新規会社を保存するテストケース。
     * 全て新規で保存されるはず。
     */
    public void testSaveAsNewCustomerAndDeptAndCompany() {
        DepartmentVO dept = new DepartmentVO(null,"ORACLE", "YOUGA");
        CompanyVO company = new CompanyVO(null,"ORACLE");
        CustomerVO vo = new CustomerVO(null, 
                                       new CustomerNameVO("秀樹","松井"),
                                       "hideki@yankees.com",
                                       "+81-03-4500-1000",
                                       "+81-03-4500-1001",
                                       dept,
                                       company);
        dept.setCompany(company);

        assertEquals("データは存在しないはず",
                     0,
                     dao.find("松井",null,null).size());

        dao.save(vo);
        
        CustomerVO actual = (CustomerVO) dao.find("松井",null,null).get(0);
        assertNotNull("IDが割当てられているはず", actual.getId());
        assertEquals("同じ顧客情報のはず", vo, actual);
        assertNotNull("部署のIDが割当てられているはず", actual.getDepartment().getId());
        assertEquals("同じ部署のはず", actual.getDepartment(), vo.getDepartment());
        assertNotNull("会社のIDが割当てられているはず", actual.getCompany().getId());
        assertEquals("同じ会社のはず", actual.getCompany(), vo.getCompany());
    }
    
    /**
     * 既存の顧客に、新規部署、会社を関連させるテストケース。
     * 明示的に関係を切断する必要がある。
     * @throws HibernateException
     */
    public void testSaveAsUpdateWithNewDeptAndCompany() throws HibernateException {
        DepartmentVO dept = new DepartmentVO(null, "Web", "US");
        CompanyVO company = new CompanyVO(null, "Adobe");
        CustomerVO vo = (CustomerVO) dao.find("taro", null, null).get(0);
        
        session = HibernateUtil.getSession(sessionFactory);
        
        DepartmentVO oldDept = vo.getDepartment();
        CompanyVO oldCompany = vo.getCompany();

        //新しい部署と会社に付け替え
        dept.setCompany(company);
        vo.setDepartment(dept);
        vo.setCompany(company);
        
        HibernateUtil.closeSession(session);

        dao.save(vo);
        
        CustomerVO actual =
            (CustomerVO) dao.find("taro", null, null).get(0);

        assertEquals("同じIDが割当てられているはず", vo.getId(), actual.getId());
        assertEquals("同じ顧客情報のはず", vo, actual);
        assertNotNull("部署のIDが割当てられているはず", actual.getDepartment().getId());
        assertEquals("同じ部署のはず", actual.getDepartment(), vo.getDepartment());
        assertNotNull("会社のIDが割当てられているはず", actual.getCompany().getId());
        assertEquals("同じ会社のはず", actual.getCompany(), vo.getCompany());
        assertFalse("別の部署のはず", oldDept.equals(actual.getDepartment()));
        assertFalse("別の会社のはず", oldCompany.equals(actual.getCompany()));
    }

    /*
     * @see org.dbunit.DatabaseTestCase#getConnection()
     */
//    protected IDatabaseConnection getConnection() throws Exception {
//        Session session = sessionFactory.openSession();
//        return new DatabaseConnection(session.connection());
//    }
//
//    /*
//     * @see org.dbunit.DatabaseTestCase#getDataSet()
//     */
//    protected IDataSet getDataSet() throws Exception {
//        return new XlsDataSet(new FileInputStream("conf/customerdao-test.xls"));
//    }
}
