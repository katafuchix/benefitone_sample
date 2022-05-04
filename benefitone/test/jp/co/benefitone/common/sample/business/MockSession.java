/* ======================================================================
 *  $Id: MockSession.java,v 1.1.1.1 2006/01/29 13:03:26 gon Exp $
 *    tkakeda
 *      2005/04/20
 * Originator: first.last@Sun.COM
 * OriginDate: 2005/MM/dd
 * ======================================================================
 */
package jp.co.benefitone.common.sample.business;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import jp.co.benefitone.common.sample.model.CustomerVO;
import junit.framework.Assert;
import net.sf.hibernate.Criteria;
import net.sf.hibernate.FlushMode;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.LockMode;
import net.sf.hibernate.Query;
import net.sf.hibernate.ReplicationMode;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.type.Type;


/**
 * |> Class Description <|
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:26 $
 * @author first last, Sun Microsystems K.K.
 */
public class MockSession implements Session {

    private CustomerVO savedCustomer;
    private boolean inserted;
    private boolean updated;

    /* 
     * @see net.sf.hibernate.Session#flush()
     */
    public void flush() throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.Session#setFlushMode(net.sf.hibernate.FlushMode)
     */
    public void setFlushMode(FlushMode flushMode) {
    }

    /* 
     * @see net.sf.hibernate.Session#getFlushMode()
     */
    public FlushMode getFlushMode() {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#getSessionFactory()
     */
    public SessionFactory getSessionFactory() {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#connection()
     */
    public Connection connection() throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#disconnect()
     */
    public Connection disconnect() throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#reconnect()
     */
    public void reconnect() throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.Session#reconnect(java.sql.Connection)
     */
    public void reconnect(Connection connection) throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.Session#close()
     */
    public Connection close() throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#cancelQuery()
     */
    public void cancelQuery() throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.Session#isOpen()
     */
    public boolean isOpen() {
        return false;
    }

    /* 
     * @see net.sf.hibernate.Session#isConnected()
     */
    public boolean isConnected() {
        return false;
    }

    /* 
     * @see net.sf.hibernate.Session#isDirty()
     */
    public boolean isDirty() throws HibernateException {
        return false;
    }

    /* 
     * @see net.sf.hibernate.Session#getIdentifier(java.lang.Object)
     */
    public Serializable getIdentifier(Object object)
                    throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#contains(java.lang.Object)
     */
    public boolean contains(Object object) {
        return false;
    }

    /* 
     * @see net.sf.hibernate.Session#evict(java.lang.Object)
     */
    public void evict(Object object) throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.Session#load(java.lang.Class, java.io.Serializable, net.sf.hibernate.LockMode)
     */
    public Object load(Class theClass, Serializable id, LockMode lockMode)
                    throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#load(java.lang.Class, java.io.Serializable)
     */
    public Object load(Class theClass, Serializable id)
                    throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#load(java.lang.Object, java.io.Serializable)
     */
    public void load(Object object, Serializable id)
                    throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.Session#replicate(java.lang.Object, net.sf.hibernate.ReplicationMode)
     */
    public void replicate(Object object, ReplicationMode replicationMode)
                    throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.Session#save(java.lang.Object)
     */
    public Serializable save(Object object) throws HibernateException {
        if (object instanceof CustomerVO) {
            savedCustomer = (CustomerVO) object;
        }
        return savedCustomer.getId();
    }

    /* 
     * @see net.sf.hibernate.Session#save(java.lang.Object, java.io.Serializable)
     */
    public void save(Object object, Serializable id)
                    throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.Session#saveOrUpdate(java.lang.Object)
     */
    public void saveOrUpdate(Object object) throws HibernateException {
        CustomerVO vo = (CustomerVO) object;
        if (vo.getId() == null) {
            inserted = true;
            updated = false;
            vo.setId(new Integer(7777));
        }
        else {
            inserted = false;
            updated = true;
        }
    }

    /* 
     * @see net.sf.hibernate.Session#update(java.lang.Object)
     */
    public void update(Object object) throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.Session#update(java.lang.Object, java.io.Serializable)
     */
    public void update(Object object, Serializable id)
                    throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.Session#saveOrUpdateCopy(java.lang.Object)
     */
    public Object saveOrUpdateCopy(Object object) throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#saveOrUpdateCopy(java.lang.Object, java.io.Serializable)
     */
    public Object saveOrUpdateCopy(Object object, Serializable id)
                    throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#delete(java.lang.Object)
     */
    public void delete(Object object) throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.Session#find(java.lang.String)
     */
    public List find(String query) throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#find(java.lang.String, java.lang.Object, net.sf.hibernate.type.Type)
     */
    public List find(String query, Object value, Type type)
                    throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#find(java.lang.String, java.lang.Object[], net.sf.hibernate.type.Type[])
     */
    public List find(String query, Object[] values, Type[] types)
                    throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#iterate(java.lang.String)
     */
    public Iterator iterate(String query) throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#iterate(java.lang.String, java.lang.Object, net.sf.hibernate.type.Type)
     */
    public Iterator iterate(String query, Object value, Type type)
                    throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#iterate(java.lang.String, java.lang.Object[], net.sf.hibernate.type.Type[])
     */
    public Iterator iterate(String query, Object[] values, Type[] types)
                    throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#filter(java.lang.Object, java.lang.String)
     */
    public Collection filter(Object collection, String filter)
                    throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#filter(java.lang.Object, java.lang.String, java.lang.Object, net.sf.hibernate.type.Type)
     */
    public Collection filter(Object collection, String filter,
                    Object value, Type type) throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#filter(java.lang.Object, java.lang.String, java.lang.Object[], net.sf.hibernate.type.Type[])
     */
    public Collection filter(Object collection, String filter,
                    Object[] values, Type[] types)
                    throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#delete(java.lang.String)
     */
    public int delete(String query) throws HibernateException {
        return 0;
    }

    /* 
     * @see net.sf.hibernate.Session#delete(java.lang.String, java.lang.Object, net.sf.hibernate.type.Type)
     */
    public int delete(String query, Object value, Type type)
                    throws HibernateException {
        return 0;
    }

    /* 
     * @see net.sf.hibernate.Session#delete(java.lang.String, java.lang.Object[], net.sf.hibernate.type.Type[])
     */
    public int delete(String query, Object[] values, Type[] types)
                    throws HibernateException {
        return 0;
    }

    /* 
     * @see net.sf.hibernate.Session#lock(java.lang.Object, net.sf.hibernate.LockMode)
     */
    public void lock(Object object, LockMode lockMode)
                    throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.Session#refresh(java.lang.Object)
     */
    public void refresh(Object object) throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.Session#refresh(java.lang.Object, net.sf.hibernate.LockMode)
     */
    public void refresh(Object object, LockMode lockMode)
                    throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.Session#getCurrentLockMode(java.lang.Object)
     */
    public LockMode getCurrentLockMode(Object object)
                    throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#beginTransaction()
     */
    public Transaction beginTransaction() throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#createCriteria(java.lang.Class)
     */
    public Criteria createCriteria(Class persistentClass) {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#createQuery(java.lang.String)
     */
    public Query createQuery(String queryString) throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#createFilter(java.lang.Object, java.lang.String)
     */
    public Query createFilter(Object collection, String queryString)
                    throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#getNamedQuery(java.lang.String)
     */
    public Query getNamedQuery(String queryName) throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#createSQLQuery(java.lang.String, java.lang.String, java.lang.Class)
     */
    public Query createSQLQuery(String sql, String returnAlias,
                    Class returnClass) {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#createSQLQuery(java.lang.String, java.lang.String[], java.lang.Class[])
     */
    public Query createSQLQuery(String sql, String[] returnAliases,
                    Class[] returnClasses) {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#clear()
     */
    public void clear() {
    }

    /* 
     * @see net.sf.hibernate.Session#get(java.lang.Class, java.io.Serializable)
     */
    public Object get(Class clazz, Serializable id)
                    throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.Session#get(java.lang.Class, java.io.Serializable, net.sf.hibernate.LockMode)
     */
    public Object get(Class clazz, Serializable id, LockMode lockMode)
                    throws HibernateException {
        return null;
    }

    /**
     * @param customer
     */
    public void verifyCustomer(CustomerVO customer) {
        Assert.assertEquals("“¯‚¶ŒÚ‹qî•ñ‚Ì‚Í‚¸", savedCustomer, customer);
    }

    /**
     * INSERT‚³‚ê‚½‚©‚ÌŒŸØ‚ð‚µ‚Ü‚·B
     */
    public void verifyInserted() {
        Assert.assertTrue("INSERT‚³‚ê‚Ä‚¢‚é‚Í‚¸", inserted);
    }

    /**
     * UPDATE‚³‚ê‚½‚©‚ÌŒŸØ‚ð‚µ‚Ü‚·B
     */
    public void verifyUpdated() {
        Assert.assertTrue("UPDATE‚³‚ê‚Ä‚¢‚é‚Í‚¸", updated);
    }
    

}