/* ======================================================================
 *  $Id: MockCustomerDAO.java,v 1.1.1.1 2006/01/29 13:03:26 gon Exp $
 *    tkakeda
 *      2005/04/05
 * Originator: first.last@Sun.COM
 * OriginDate: 2005/MM/dd
 * ======================================================================
 */
package jp.co.benefitone.common.sample.integration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jp.co.benefitone.common.fw.integration.DatabaseRuntimeException;
import jp.co.benefitone.common.sample.model.CompanyVO;
import jp.co.benefitone.common.sample.model.CustomerNameVO;
import jp.co.benefitone.common.sample.model.CustomerVO;
import jp.co.benefitone.common.sample.model.DepartmentVO;
import junit.framework.Assert;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;


/**
 * CustomerDAOのMockObject.
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:26 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class MockCustomerDAO extends CustomerDAOImpl {

    /**
     * delete メソッドテスト用
     */
    private List deleteArray;
    private CustomerVO savedCustomer;

    public MockCustomerDAO() {
        initialize();
    }
    
    private void initialize() {
        deleteArray = new ArrayList();
        deleteArray.add(new CustomerVO(new Integer(101),
                                       new CustomerNameVO("Sur1", "Given1"),
                                       "foo@foo.bar",
                                       "03-3333-1111",
                                       "03-3333-1112", null, null));
        deleteArray.add(new CustomerVO(new Integer(102),
                                       new CustomerNameVO("Sur2", "Given2"),
                                       "foo@foo.bar",
                                       "03-3333-1111",
                                       "03-3333-1112", null, null));
        deleteArray.add(new CustomerVO(new Integer(103),
                                       new CustomerNameVO("Sur3", "Given3"),
                                       "foo@foo.bar",
                                       "03-3333-1111",
                                       "03-3333-1112", null, null));
        deleteArray.add(new CustomerVO(new Integer(104),
                                       new CustomerNameVO("Sur4", "Given4"),
                                       "foo@foo.bar",
                                       "03-3333-1111",
                                       "03-3333-1112", null, null));
        deleteArray.add(new CustomerVO(new Integer(105),
                                       new CustomerNameVO("Sur5", "Given5"),
                                       "foo@foo.bar",
                                       "03-3333-1111",
                                       "03-3333-1112", null, null));
    }
    
    /**
     * 削除結果の検証を行う。
     * @param size 件数
     */
    public void verifyDeleteResult(int size) {
        Assert.assertEquals("件数が異なる！", size, deleteArray.size());
    }

    /*
     * @see jp.co.benefitone.common.sample.integration.CustomerDAO#delete(java.lang.String)
     */
    public void delete(Integer id) {
        for(Iterator it = deleteArray.iterator(); it.hasNext();) {
            CustomerVO c = (CustomerVO) it.next();
            if (id.equals(c.getId())) {
                it.remove();
            }
        }
    }

    /* 
     * @see jp.co.benefitone.common.sample.integration.CustomerDAO#select(int)
     */
    public CustomerVO select(Integer id) {
        return new CustomerVO(new Integer(3001),
                              new CustomerNameVO("Sato","Eriko"),
                              "satoeri@sample.com",
                              "090-9898-1212",
                              "090-9898-1212",null, null);
    }

    public CompanyVO selectCompanyByName(String name) {
        CompanyVO company = new CompanyVO();
        company.setId(new Integer(1001));
        company.setName("SUN");
        return company;
    }

    public DepartmentVO selectDepartmentByNameAndCompanyId(
            String name, Integer id) {
        DepartmentVO dept = new DepartmentVO();
        dept.setId(new Integer(2001));
        dept.setName("JAVA");
        dept.setAddress("YOUGA");
        return dept;
    }

    /* 
     * @see jp.co.benefitone.common.sample.integration.CustomerDAO#save(jp.co.benefitone.common.sample.model.CustomerVO)
     */
    public void save(CustomerVO customer) {
        try {
            Session session = getSessionFactory().openSession();
            session.saveOrUpdate(customer);
        }
        catch (HibernateException e) {
            throw new DatabaseRuntimeException(e);
        }
        this.savedCustomer = customer;
    }
    
    /* 
     * @see jp.co.benefitone.common.sample.integration.CustomerDAOImpl#find(java.lang.String, java.lang.String, java.lang.String)
     */
    public List find(String customerName, String departmentName,
                    String companyName) {
        if (customerName != null && departmentName != null && companyName != null) {
            return createResultByAllCriteria();
        }
        if (customerName != null && departmentName != null) {
            return createResultByCustomerAndDept();
        }
        if (customerName != null && companyName != null) {
            return createResultByCustomerAndCompany();
        }
        if (departmentName != null  && companyName != null) {
            return createResultByDeptAndCompany();
        }
        if (customerName != null) {
            return createResultByCustomerName();
        }
        if (departmentName != null) {
            return createResultByDepartmentName();
        }
        if (companyName != null) {
            return createResultByCompanyName();
        }
        return createResultByNoCriteria();
    }

    /**
     * @return
     */
    private List createResultByCustomerAndDept() {
        ArrayList list = new ArrayList();
        list.add(new CustomerVO(new Integer(103),
                                new CustomerNameVO("Sur3", "Given3"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
        return list;
    }

    /**
     * @return
     */
    private List createResultByCustomerAndCompany() {
        ArrayList list = new ArrayList();
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
        return list;
    }

    /**
     * @return
     */
    private List createResultByDeptAndCompany() {
        ArrayList list = new ArrayList();
        list.add(new CustomerVO(new Integer(102),
                                new CustomerNameVO("Sur2", "Given2"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
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
        return list;
    }

    /**
     * @return
     */
    private List createResultByAllCriteria() {
        ArrayList list = new ArrayList();
        list.add(new CustomerVO(new Integer(101),
                                new CustomerNameVO("Sur1", "Given1"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
        return list;
    }

    /**
     * @return
     */
    private List createResultByDepartmentName() {
        ArrayList list = new ArrayList();
        list.add(new CustomerVO(new Integer(101),
                                new CustomerNameVO("Sur1", "Given1"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
        list.add(new CustomerVO(new Integer(102),
                                new CustomerNameVO("Sur2", "Given2"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
        
        return list;
    }

    /**
     * @return
     */
    private List createResultByCompanyName() {
        ArrayList list = new ArrayList();
        list.add(new CustomerVO(new Integer(101),
                                new CustomerNameVO("Sur1", "Given1"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
        list.add(new CustomerVO(new Integer(102),
                                new CustomerNameVO("Sur2", "Given2"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
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
        return list;
    }

    /**
     * @return
     */
    private List createResultByCustomerName() {
        ArrayList list = new ArrayList();
        list.add(new CustomerVO(new Integer(101),
                                new CustomerNameVO("Sur1", "Given1"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
        list.add(new CustomerVO(new Integer(102),
                                new CustomerNameVO("Sur2", "Given2"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
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
        list.add(new CustomerVO(new Integer(105),
                                new CustomerNameVO("Sur5", "Given5"),
                                "foo@foo.bar",
                                "03-3333-1111",
                                "03-3333-1112", null, null));
        return list;
    }

    /**
     * @return
     */
    protected List createResultByNoCriteria() {
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

    /**
     */
    public void verifyAssignedId() {
        Assert.assertNotNull("保存された顧客はIDが割り振られているはず", savedCustomer.getId());
    }
}
