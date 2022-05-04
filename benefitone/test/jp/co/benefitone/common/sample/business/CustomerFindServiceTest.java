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
 * �ڋq�����T�[�r�X�N���X�e�X�g�P�[�X�B
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:26 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CustomerFindServiceTest extends TestCase {
    
    /**
     * BusinessSessin�̓��v���I�u�W�F�N�g�̎擾�ݒ�̃e�X�g�B
     * Session�Ɋ��ɑ��݂���΂�������g���A���݂��Ȃ��Ȃ�C���X
     * �^���X�𐶐����Ċi�[����B
     * �����������r�W�l�X�Z�b�V�����Ɋi�[����Ă���͂��B
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
        
        assertEquals("�����������i�[����Ă���͂�:�ڋq��=null",
                     null, criteria.getCustomerName());
        assertEquals("�����������i�[����Ă���͂�:������=JAVA",
                     "JAVA", criteria.getDepartmentName());
        assertEquals("�����������i�[����Ă���͂�:��Ж�=Sun",
                     "Sun", criteria.getCompanyName());

        FindCustomerResult resultSecond =
            service.findCustomer(findCustomerCriteria, beforeSession);
        BusinessSession session2 = resultSecond.getBusinessSession();
        FindStatistics statSecond=
            (FindStatistics) session2.getAttribute("findStatistics");
        
        assertSame("����FindCustomerResult�I�u�W�F�N�g�̂͂�",
                   statistics, statSecond);
        FindCustomerCriteria criteria2 =
            (FindCustomerCriteria) session2.getAttribute("criteria");
        assertSame("���������������i�[����Ă���͂�",
                   criteria, criteria2);

        afterSession.setAttribute("findStatistics", null);
        afterSession.setAttribute("criteria", null);
        FindCustomerResult resultThird =
            service.findCustomer(findCustomerCriteria, afterSession);
        
        BusinessSession session3 = resultThird.getBusinessSession();
        FindStatistics statThird =
            (FindStatistics) session3.getAttribute("findStatistics");

        assertNotSame("�ႤFindCustomerResult�I�u�W�F�N�g�̂͂�",statistics, statThird);
        FindCustomerCriteria criteria3 =
            (FindCustomerCriteria) session3.getAttribute("criteria");
        assertSame("�Ⴄ�����������i�[����Ă���͂�",
                   criteria, criteria3);
    }

    /**
     * MockCustomerDAO���g�p�������v���t���̌����e�X�g�B
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
        assertEquals("�ڋq����3���̂͂�", 3, actual);
        
        assertTrue("1�b�ȓ��̂͂�", statistics.getTime() < 1000);
        assertTrue("1�b�ȓ��̂͂�", statistics.getAverageTime() < 1000);

        //3�b�̏ꍇ
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
        //3�b�҂͂�
        FindCustomerResult resultAll = service.findCustomer(secondCriteria, businessSession);
        System.out.println(statistics.getTime());
        
        assertTrue("2�b����4�b���̂͂�",
                   (2000 < statistics.getTime() && statistics.getTime() < 4000) );

        System.out.println(statistics.getAverageTime());
        assertTrue("(1�ȉ�*1+3)/2=1�b�ȏ�3�b�ȓ��̂͂�",
                   1000 < statistics.getAverageTime() && statistics.getAverageTime() < 3000);
    }

    /**
     * MockCustomerDAO���g�p�������v���i1�b���z�����z��)�t���̌����e�X�g�B
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
        //��������1�b�҂悤�ɂ��Ă���B
        FindCustomerCriteria findCustomerCriteria =
            this.createFindCriteria("Sur1", "Sun", "JAVA");
        FindCustomerResult findResult =
            service.findCustomer(findCustomerCriteria, session);

        service.verifyFindCustomerResult("Sur1", "JAVA", "Sun");
        int actual = findResult.getResult().size();
        assertEquals("�ڋq����1���̂͂�", 1, actual);
        
        BusinessSession businessSession = findResult.getBusinessSession();
        FindStatistics statistics =
            (FindStatistics) businessSession.getAttribute("findStatistics");
        assertTrue("1�b�ȏ�2�b�ȓ��̂͂�",
                   1000 < statistics.getTime() && statistics.getTime() < 2000);
    }

    /**
     * ��������DB�G���[�����������ꍇ�̃e�X�g�B
     * DatabaseRuntimeException��catch�ł���͂��B
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
        
        //TODO ��O�ɂ��Ă͖�����B�v�ύX
        try {
            FindCustomerCriteria criteria = createFindCriteria(null, "Sun", null);
            service.findCustomer(criteria);
            fail("DatabaseRuntimeException�����o�����ׂ��I");
        } catch (DatabaseRuntimeException e) {
            assertEquals("��O���b�Z�[�W���قȂ�", "Error", e.getMessage());
        }
    }
    /**
     * �S�������̃e�X�g�B
     *
     */
    public void testFindCustomerWithoutCondition() {
        FindCustomerCriteria criteria =
            createFindCriteria(null, null, null);
        CustomerFindServiceImpl service = getCustomerFindService();
        List results = service.findCustomer(criteria);
        assertEquals("�S���ڋq��񂪌��������͂�", 12, results.size());
    }
    
    /**
     * �ڋq��񌟍��e�X�g�B
     * �ڋq���̂݁B
     */
    public void testFindCustomerByName() {
        FindCustomerCriteria criteria =
            createFindCriteria("Given", null, null);

        CustomerFindServiceImpl service = getCustomerFindService();

        List results = service.findCustomer(criteria);
        int actual = results.size();
        assertEquals("�ڋq����5���̂͂�", 5, actual);
        
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
     * MockCustomerDAO���g�p������Ж��݂̂̌����e�X�g�B
     *
     */
    public void testFindCustomerByCompanyName() {
        FindCustomerCriteria criteria =
            createFindCriteria(null, "Sun Micro", null);

        CustomerFindServiceImpl service = getCustomerFindService();

        List results = service.findCustomer(criteria);
        int actual = results.size();
        assertEquals("�ڋq����10���̂͂�", 10, actual);
        
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
     * MockCustomerDAO���g�p�����������݂̂̌����e�X�g�B
     *
     */
    public void testFindCustomerByDepartment() {
        FindCustomerCriteria criteria =
            createFindCriteria(null, null, "JAVA");
        CustomerFindServiceImpl service = getCustomerFindService();

        List results = service.findCustomer(criteria);
        int actual = results.size();
        assertEquals("�ڋq����2���̂͂�", 2, actual);

        List expected = new ArrayList();
        expected.add(createCustomerVO(101, "Sur1", "Given1", "foo@foo.bar",
                                      "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(102, "Sur2", "Given2", "foo@foo.bar",
                                      "03-3333-1111", "03-3333-1112"));
        AssertUtil.assertListEquals(expected, results);

    }
    
    /**
     * MockCustomerDAO���g�p�����S���������e�X�g�B
     *
     */
    public void testFindCustomerByAll() {
        FindCustomerCriteria criteria =
            createFindCriteria("Kake", "Sun", "JAVA");
        CustomerFindServiceImpl service = getCustomerFindService();
        
        List results = service.findCustomer(criteria);
        int actual = results.size();
        assertEquals("�ڋq����1���̂͂�", 1, actual);
        
        List expected = new ArrayList();
        expected.add(createCustomerVO(101, "Sur1", "Given1", "foo@foo.bar",
                                      "03-3333-1111", "03-3333-1112"));
        AssertUtil.assertListEquals(expected, results);
    }

    /**
     * MockCustomerDAO���g�p�����������A��Ж��ł̌����e�X�g�B
     *
     */
    public void testFIndCustomerByCompanyAndDepartment() {
        FindCustomerCriteria criteria =
            createFindCriteria(null, "Sun", "JAVA");
        CustomerFindServiceImpl service = getCustomerFindService();

        List results = service.findCustomer(criteria);
        int actual = results.size();
        assertEquals("�ڋq����3���̂͂�", 3, actual);

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
     * MockCustomerDAO���g�p�����ڋq���A��Ж��ɂ�錟���e�X�g�B
     *
     */
    public void testFindCustomerByCustomerAndCompany() {
        FindCustomerCriteria criteria =
            createFindCriteria("Takeshi", "Sun", null);
        CustomerFindServiceImpl service = getCustomerFindService();
        
        List results = service.findCustomer(criteria);
        assertEquals("�ڋq����2���̂͂�", 2, results.size());
        
        List expected = new ArrayList();
        expected.add(createCustomerVO(103, "Sur3", "Takeshi", "foo@foo.bar",
                                      "03-3333-1111", "03-3333-1112"));
        expected.add(createCustomerVO(104, "Sur4", "Takeshi", "foo@foo.bar",
                                      "03-3333-1111", "03-3333-1112"));
        AssertUtil.assertListEquals(expected, results);
    }
    
    /**
     * MockCustomerDAO�ɂ��ڋq���A�������ł̌����e�X�g�B
     *
     */
    public void testFindCustomerByCustomerAndDepartment() {
        FindCustomerCriteria criteria =
            createFindCriteria("Takeshi", null, "JAVA");
        
        CustomerFindServiceImpl service = getCustomerFindService();
        List results = service.findCustomer(criteria);
        assertEquals("�ڋq����1���̂͂�", 1, results.size());
        List expected = new ArrayList();
        expected.add(createCustomerVO(103, "Sur3", "Takeshi", "foo@foo.bar",
                                      "03-3333-1111", "03-3333-1112"));
        AssertUtil.assertListEquals(expected, results);
    }

    /**
     * MockCustomerDAO��p�����ڋq��1���擾�e�X�g�B
     *
     */
    public void testSelectCustomerUsingMockDAO() {
        CustomerFindServiceImpl service = getCustomerFindService();
        CustomerVO actual = service.selectCustomer(new Integer(3001));
        assertNotNull("�ڋq����1���擾�ł��Ă���͂�", actual);
        
        CustomerVO expected =
            createCustomerVO(3001,
                             "Sato",
                             "Eriko",
                             "satoeri@sample.com",
                             "090-9898-1212","090-9898-1212");
        assertEquals("�����ڋq���̂͂�", actual, expected);
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
     * MockCustomerDAO���g�p����CustomerFindService�̐������s���܂��B
     * @return CustomerFindService�I�u�W�F�N�g
     */
    private CustomerFindServiceImpl getCustomerFindService() {
        CustomerFindServiceImpl service = new CustomerFindServiceImpl();
        MockCustomerDAO dao = new MockCustomerDAO();
        service.setCustomerDAO(dao);
        return service;
    }

    /**
     * �����I�u�W�F�N�g���쐬���܂��B
     * @param customer �ڋq��
     * @param company ��Ж�
     * @param department ������
     * @return ���������I�u�W�F�N�g
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
