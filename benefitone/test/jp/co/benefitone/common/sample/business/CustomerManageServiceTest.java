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
 * �ڋq�Ǘ��T�[�r�X�N���X�e�X�g�P�[�X�B
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
     * �ڋq����1���폜�����ꍇ�̃e�X�g�ł��B
     */
    public void testDeleteCustomerUsingMockDAO() {

        BusinessSession session = new BusinessSession();
        FindCustomerCriteria criteria = createFindCustomerCriteria(null, "JAVA", "Sun");
        dao.verifyDeleteResult(5);

        // 1���̌ڋq�����폜����
        FindCustomerResult deleteResult = service.deleteCustomer(new Integer("101"), 
                                                                 criteria,
                                                                 session);
        dao.verifyDeleteResult(4);
    }
    

    /**
     * �ڋq���̃T�j�^�C�Y�e�X�g�B
     * ��Ж��ƌڋq��񂪓��͂���Ă��邪�A�����̏��
     * ���͂���Ă��Ȃ��ꍇ�B
     * �ʏ�͂��̂悤�ȃI�u�W�F�N�g�͓n����Ȃ��B
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

        assertEquals("�ڋqID:3001�̂͂�", new Integer(3001), customer.getId());
        assertEquals("�ڋq��:FIRST1�̂͂�", "FIRST1", customer.getName().getFirstName());
        assertEquals("�ڋq��:LAST1�̂͂�", "LAST1", customer.getName().getLastName());
        assertEquals("EMAIL:first1@sun.com�̂͂�", "first1@sun.com", customer.getEmail());
        assertEquals("�d�b�ԍ�:03-5999-2121�̂͂�", "03-5999-2121", customer.getPhone());
        assertEquals("FAX:03-5999-2123�̂͂�", "03-5999-2123", customer.getFax());
        assertEquals("���ID:1001�̂͂�", new Integer(1001), customer.getCompany().getId());
        assertEquals("��Ж�:SUN�̂͂�", "SUN", customer.getCompany().getName());
        assertEquals("����ID:2001�̂͂�", new Integer(2001), customer.getDepartment().getId());
        assertEquals("������:JAVA�̂͂�", "JAVA", customer.getDepartment().getName());
        assertEquals("�����̏Z��:YOUGA�̂͂�", "YOUGA", customer.getDepartment().getAddress());
    }

    /**
     * �ڋq���̃T�j�^�C�Y�e�X�g�B
     * �V�K�o�^�̏ꍇ�A���ID�ƕ���ID�A�����ČڋqID �� null ��
     * �I�u�W�F�N�g���n�����
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
        assertTrue("�ڋqID:null�̂͂�", null ==  customer.getId());
        assertEquals("�ڋq��:FIRST1�̂͂�", "FIRST1", customer.getName().getFirstName());
        assertEquals("�ڋq��:LAST1�̂͂�", "LAST1", customer.getName().getLastName());
        assertEquals("EMAIL:first1@sun.com�̂͂�", "first1@sun.com", customer.getEmail());
        assertEquals("�d�b�ԍ�:03-5999-2121�̂͂�", "03-5999-2121", customer.getPhone());
        assertEquals("FAX:03-5999-2123�̂͂�", "03-5999-2123", customer.getFax());
        assertEquals("���ID:1001�̂͂�", new Integer(1001), customer.getCompany().getId());
        assertEquals("��Ж�:SUN�̂͂�", "SUN", customer.getCompany().getName());
        assertEquals("����ID:2001�̂͂�", new Integer(2001), customer.getDepartment().getId());
        assertEquals("������:JAVA�̂͂�", "JAVA", customer.getDepartment().getName());
        assertEquals("�����̏Z��:SANNO�̂͂�", "SANNO", customer.getDepartment().getAddress());
    }

    /**
     * �ڋq�̕ۑ��e�X�g�P�[�X(Mock�I�u�W�F�N�g���g�p)�B
     */
    public void testSaveCustomerInsertedCase() {
        MockSession session = new MockSession(); 
        SessionFactory sessionFactory = new MockSessionFactory(session);
        dao.setSessionFactory(sessionFactory);
        service.setCustomerDAO(dao);
        CustomerVO customer = new CustomerVO(null,
                                             new CustomerNameVO("�G��","����"),
                                             "sato@sato.com",
                                             "03-9999-1234","03-9999-1235",
                                             new DepartmentVO(new Integer(1),"Dummpy","�����s���c�J��p��"),
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
     * �ڋq�̍X�V�e�X�g�P�[�X(MockObject���g�p)�B
     *
     */
    public void testSaveCustomerUpdatedCase() {
        MockSession session = new MockSession(); 
        SessionFactory sessionFactory = new MockSessionFactory(session);
        dao.setSessionFactory(sessionFactory);
        service.setCustomerDAO(dao);
        CustomerVO customer = new CustomerVO(new Integer(10),
                                             new CustomerNameVO("�G��","����"),
                                             "sato@sato.com",
                                             "03-9999-1234","03-9999-1235",
                                             new DepartmentVO(new Integer(1),"Dummpy","�����s���c�J��p��"),
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
                                             new CustomerNameVO("�G��","����"),
                                             "sato@sato.com",
                                             "03-9999-1234","03-9999-1235",
                                             new DepartmentVO(new Integer(1),"Dummpy","�����s���c�J��p��"),
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
