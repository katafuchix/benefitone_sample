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
 * �ڋqDAO�����N���X�̃e�X�g�P�[�X�B SessionFactory��setter��DAO�ɓn���B
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
     * �ڋq���S�������̃e�X�g�B
     */
    public void testCustomerFindAll() {
        List results = dao.find(null, null, null);
        assertEquals("15���̃f�[�^���擾�ł���͂�", 15, results.size());
        
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
        //�ꌏ�ڂ̂�
        CustomerVO vo = (CustomerVO) results.get(0);
        assertEquals("SUN", vo.getCompany().getName());
        assertEquals("JAVA", vo.getDepartment().getName());
    }

    public void testFindCustomerName() {
        List results = dao.find("yamada", null, null);
        assertEquals("yamada�Ƀ}�b�`����̂�2���̂͂�", 2, results.size());

        results = dao.find("taro", null, null);
        assertEquals("taro�Ƀ}�b�`����̂�1���̂͂�", 1, results.size());

        results = dao.find("ro", null, null);
        assertEquals("ro�Ƀ}�b�`����̂�2���̂͂�", 2, results.size());

        results = dao.find("yama", null, null);
        assertEquals("yama�Ƀ}�b�`����̂�2���̂͂�", 2, results.size());

        results = dao.find("FIRST", null, null);
        assertEquals("FIRST�Ƀ}�b�`����̂�12���̂͂�", 12, results.size());
        
        results = dao.find("FIRST1", null, null);
        assertEquals("�t���l�[�� FIRST1�Ƀ}�b�`����̂�4���̂͂�", 4, results.size());
        
    }

    /**
     * �������ɂ��ڋq�����̃e�X�g�B
     */
    public void testFindCustomerByDepartment() {
        List results = dao.find(null, "JAVA", null);
        assertEquals("10���Y������͂�", 10, results.size());
    }

    public void testFindCustomerByCompany() {
        List results = dao.find(null, null, "SUN");
        assertEquals("10���Y������͂�", 10, results.size());

        results = dao.find(null, null, "IBM");
        assertEquals("3���Y������͂�", 3, results.size());

        results = dao.find(null, null, "MS");
        assertEquals("2���̂͂�", 2, results.size());
    }

    /**
     * ��Ж��ƕ��������w�肳�ꂽ�ꍇ�̌����e�X�g�B
     */
    public void testFindCustomerByComopanyAndDepartment() {
        List results = dao.find(null, "JAVA", "SUN");
        assertEquals("��Ђ�SUN�A������JAVA�Ȍڋq��6���̂͂�", 6, results.size());
    }

    /**
     * �ڋq���Ɖ�Ж����w�肳�ꂽ�ꍇ�̌����e�X�g�B
     */
    public void testFindCustomerByCustomerAndCompany() {
        List results = dao.find("FIRST1", null, "SUN");
        assertEquals("��Ђ�SUN�A���O��FIRST1���܂܂��ڋq��2���̂͂�", 2, results.size());

        results = dao.find("yamada", null, "SUN");
        assertEquals("��Ђ�SUN�A���O��yamada���܂܂��ڋq��0���̂͂�", 0, results.size());
    }

    /**
     * �ڋq���ƕ��������w�肳�ꂽ�ꍇ�̌����e�X�g�B
     */
    public void testFindCustomerByCustomerAndDepartment() {
        List results = dao.find("FIRST", "JAVA", null);
        assertEquals("��������JAVA�A���O��FIRST���܂܂��ڋq��8���̂͂�", 8, results.size());

        results = dao.find("FIRST", "SOLARIS", null);
        assertEquals("��������SOLARIS�A���O��FIRST���܂܂��ڋq��3���̂͂�", 3, results.size());

        results = dao.find("FIRST", "SPARC", null);
        assertEquals("��������SPARC�A���O��FIRST���܂܂��ڋq��1���̂͂�", 1, results.size());
    }

    /**
     * �S������n�����ꍇ�̌����e�X�g�B
     *
     */
    public void testFindCustomerAllCondition() {
        List results = dao.find("FIRST", "JAVA", "SUN");
        assertEquals("�ڋq��:FIRST�A������:JAVA�A��Ж�:SUN�̃f�[�^��6���̂͂�", 6, results.size());

        results = dao.find("FIRST1", "JAVA", "SUN");
        assertEquals("�ڋq��:FIRST�A������:JAVA�A��Ж�:SUN�̃f�[�^��2���̂͂�", 2, results.size());

        results = dao.find("FIRST1", "JAVA", "MS");
        assertEquals("�ڋq��:FIRST�A������:JAVA�A��Ж�:MS�̃f�[�^��1���̂͂�", 1, results.size());

        results = dao.find("FIRST1", "SPARC", "MS");
        assertEquals("�ڋq��:FIRST�A������:SPARC�A��Ж�:MS�̃f�[�^��0���̂͂�", 0, results.size());
    }

    /**
     * find���\�b�h�őS�P�[�X���m�F����B
     */
    public void testFindAllCase() {
        List results = dao.find(null, null, null);
        assertEquals("��������������15���̂͂�",15, results.size());
        results = dao.find("taro", null, null);
        assertEquals("���O�̂݌�����1���̂͂�",1, results.size());
        results = dao.find(null, "SPARC", null);
        assertEquals("����:SPARC �̂݌�����1���̂͂�",1, results.size());
        results = dao.find(null, null, "MS");
        assertEquals("���:MS �̂݌�����2���̂͂�",2, results.size());
        results = dao.find("yamada", null, "IBM");
        assertEquals("���O:yamada, ���:IBM�̌�����2���̂͂�",2, results.size());
        results = dao.find(null, "JAVA", "IBM");
        assertEquals("����:JAVA, ���:IBM�̌�����3���̂͂�",3, results.size());
        results = dao.find("taro", "JAVA", "IBM");
        assertEquals("���O:taro, ����:JAVA, ���:IBM�̌�����2���̂͂�",1, results.size());
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
        assertEquals("�����ڋq���̂͂�", expected, actual);
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
        assertEquals("�����ڋq���̂͂�", expected, vo);
        
    }

    /**
     * ���݂��Ȃ��ڋq�����폜���Ă��A�������ς�Ȃ����Ƃ��m�F����B
     */
    public void testDeleteCustomerFailure() {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext(
                                               new String[] {
                                               "test-datasource-context.xml"
                                               });
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        List results = dao.find(null, null, null);
        assertEquals("15���̃f�[�^���擾�ł���͂�", 15, results.size());

        // ���݂��Ȃ��ڋqID���폜����
        dao.delete(new Integer("99999999"));

        results = dao.find(null, null, null);
        assertEquals("15���̃f�[�^���擾�ł���͂�", 15, results.size());
    }

    /**
     * �ڋq�����폜���A������1�����邱�Ƃ��m�F����
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
        assertEquals("15���̃f�[�^���擾�ł���͂�", 15, before);

        CustomerVO customer = (CustomerVO) results.get(0);
        dao.delete(customer.getId());
//        customer.getDepartment().getCustomers().remove(customer);
//        customer.getCompany().getCustomers().remove(customer);

        results = dao.find(null, null, null);
        int expected = before - results.size();
        assertEquals("1���̃f�[�^���폜����Ă���͂�", 1, expected);
    }

    /**
     * ��Џ��𖼑O�w��Ō�������B
     */
    public void testSelectCompanyByName() {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext(
                                               new String[] {
                                               "test-datasource-context.xml"
                                               });
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        // 1���擾�ł���͂�
        CompanyVO company = customerDAO.selectCompanyByName("SUN");
        assertEquals("��Ж�:SUN�̂͂�", "SUN", company.getName());
        assertEquals("���ID:1001�̂͂�", new Integer(1001), company.getId());

        // �擾�ł��Ȃ��͂�
        company = customerDAO.selectCompanyByName("FOO");
        assertTrue("null �̂͂�", null == company);

        company = customerDAO.selectCompanyByName(null);
        assertTrue("null �̂͂�", null == company);
    }

    /**
     * ���������A�������Ɖ��ID���猟������B
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
        assertEquals("������:JAVA�̂͂�", "JAVA", dept.getName());
        assertEquals("����ID:2001�̂͂�", new Integer(2001), dept.getId());

        // �擾�ł��Ȃ��͂�
        dept = customerDAO.selectDepartmentByNameAndCompanyId(
                                "JAVA", new Integer(-1));
        assertTrue("null �̂͂�", null == dept);

        dept = customerDAO.selectDepartmentByNameAndCompanyId("JAVA", null);
        assertTrue("null �̂͂�", null == dept);

        dept = customerDAO.selectDepartmentByNameAndCompanyId(
                                null, new Integer(1001));
        assertTrue("null �̂͂�", null == dept);

        dept = customerDAO.selectDepartmentByNameAndCompanyId(null, null);
        assertTrue("null �̂͂�", null == dept);
    }
    
    /**
     * �V�K�ڋq�Ƃ��ĕۑ�����e�X�g�P�[�X�B
     * �����̕����A��Ђ��g�p�B
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
                           new CustomerNameVO("�G��","����"),
                           "hideki@yankees.com",
                           "+81-03-4500-1000",
                           "+81-03-4500-1001",
                           dept,
                           company);
        assertEquals("�f�[�^�͑��݂��Ȃ��͂�",
                     0, dao.find("����",null,null).size());
        HibernateUtil.clearAllSessions();
        dept.setCompany(company);

        dao.save(vo);
        CustomerVO actual = (CustomerVO) dao.find("����",null,null).get(0);
        assertEquals("�����ڋq���̂͂�", vo, actual);
        DepartmentVO department = actual.getDepartment();
        CompanyVO company2 = actual.getCompany();

        HibernateUtil.clearAllSessions();
        assertEquals("���������̂͂�", department, vo.getDepartment());
        assertEquals("������Ђ̂͂�", company2, vo.getCompany());
    }
    
    /**
     * �V�K�ڋq�A�V�K�����A�V�K��Ђ�ۑ�����e�X�g�P�[�X�B
     * �S�ĐV�K�ŕۑ������͂��B
     */
    public void testSaveAsNewCustomerAndDeptAndCompany() {
        DepartmentVO dept = new DepartmentVO(null,"ORACLE", "YOUGA");
        CompanyVO company = new CompanyVO(null,"ORACLE");
        CustomerVO vo = new CustomerVO(null, 
                                       new CustomerNameVO("�G��","����"),
                                       "hideki@yankees.com",
                                       "+81-03-4500-1000",
                                       "+81-03-4500-1001",
                                       dept,
                                       company);
        dept.setCompany(company);

        assertEquals("�f�[�^�͑��݂��Ȃ��͂�",
                     0,
                     dao.find("����",null,null).size());

        dao.save(vo);
        
        CustomerVO actual = (CustomerVO) dao.find("����",null,null).get(0);
        assertNotNull("ID�������Ă��Ă���͂�", actual.getId());
        assertEquals("�����ڋq���̂͂�", vo, actual);
        assertNotNull("������ID�������Ă��Ă���͂�", actual.getDepartment().getId());
        assertEquals("���������̂͂�", actual.getDepartment(), vo.getDepartment());
        assertNotNull("��Ђ�ID�������Ă��Ă���͂�", actual.getCompany().getId());
        assertEquals("������Ђ̂͂�", actual.getCompany(), vo.getCompany());
    }
    
    /**
     * �����̌ڋq�ɁA�V�K�����A��Ђ��֘A������e�X�g�P�[�X�B
     * �����I�Ɋ֌W��ؒf����K�v������B
     * @throws HibernateException
     */
    public void testSaveAsUpdateWithNewDeptAndCompany() throws HibernateException {
        DepartmentVO dept = new DepartmentVO(null, "Web", "US");
        CompanyVO company = new CompanyVO(null, "Adobe");
        CustomerVO vo = (CustomerVO) dao.find("taro", null, null).get(0);
        
        session = HibernateUtil.getSession(sessionFactory);
        
        DepartmentVO oldDept = vo.getDepartment();
        CompanyVO oldCompany = vo.getCompany();

        //�V���������Ɖ�Ђɕt���ւ�
        dept.setCompany(company);
        vo.setDepartment(dept);
        vo.setCompany(company);
        
        HibernateUtil.closeSession(session);

        dao.save(vo);
        
        CustomerVO actual =
            (CustomerVO) dao.find("taro", null, null).get(0);

        assertEquals("����ID�������Ă��Ă���͂�", vo.getId(), actual.getId());
        assertEquals("�����ڋq���̂͂�", vo, actual);
        assertNotNull("������ID�������Ă��Ă���͂�", actual.getDepartment().getId());
        assertEquals("���������̂͂�", actual.getDepartment(), vo.getDepartment());
        assertNotNull("��Ђ�ID�������Ă��Ă���͂�", actual.getCompany().getId());
        assertEquals("������Ђ̂͂�", actual.getCompany(), vo.getCompany());
        assertFalse("�ʂ̕����̂͂�", oldDept.equals(actual.getDepartment()));
        assertFalse("�ʂ̉�Ђ̂͂�", oldCompany.equals(actual.getCompany()));
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
