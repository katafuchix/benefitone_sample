/* ======================================================================
 *  $Id: MockSessionFactory.java,v 1.1.1.1 2006/01/29 13:03:26 gon Exp $
 *    tkakeda
 *      2005/04/20
 * Originator: first.last@Sun.COM
 * OriginDate: 2005/MM/dd
 * ======================================================================
 */
package jp.co.benefitone.common.sample.business;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Map;

import javax.naming.NamingException;
import javax.naming.Reference;

import net.sf.hibernate.Databinder;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Interceptor;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.exception.SQLExceptionConverter;
import net.sf.hibernate.metadata.ClassMetadata;
import net.sf.hibernate.metadata.CollectionMetadata;


/**
 * SessionFactoryƒNƒ‰ƒX‚ÌMockObject.
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:26 $
 * @author first last, Sun Microsystems K.K.
 */
public class MockSessionFactory implements SessionFactory {

    private Session session;

    /**
     * @param session
     */
    public MockSessionFactory(MockSession session) {
        this.session = session;
    }

    /* 
     * @see net.sf.hibernate.SessionFactory#openSession(java.sql.Connection)
     */
    public Session openSession(Connection connection) {
        return null;
    }

    /* 
     * @see net.sf.hibernate.SessionFactory#openSession(net.sf.hibernate.Interceptor)
     */
    public Session openSession(Interceptor interceptor)
                    throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.SessionFactory#openSession(java.sql.Connection, net.sf.hibernate.Interceptor)
     */
    public Session openSession(Connection connection,
                    Interceptor interceptor) {
        return null;
    }

    /* 
     * @see net.sf.hibernate.SessionFactory#openSession()
     */
    public Session openSession() throws HibernateException {
        return this.session;
    }

    /* 
     * @see net.sf.hibernate.SessionFactory#openDatabinder()
     */
    public Databinder openDatabinder() throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.SessionFactory#getClassMetadata(java.lang.Class)
     */
    public ClassMetadata getClassMetadata(Class persistentClass)
                    throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.SessionFactory#getCollectionMetadata(java.lang.String)
     */
    public CollectionMetadata getCollectionMetadata(String roleName)
                    throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.SessionFactory#getAllClassMetadata()
     */
    public Map getAllClassMetadata() throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.SessionFactory#getAllCollectionMetadata()
     */
    public Map getAllCollectionMetadata() throws HibernateException {
        return null;
    }

    /* 
     * @see net.sf.hibernate.SessionFactory#close()
     */
    public void close() throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.SessionFactory#evict(java.lang.Class)
     */
    public void evict(Class persistentClass) throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.SessionFactory#evict(java.lang.Class, java.io.Serializable)
     */
    public void evict(Class persistentClass, Serializable id)
                    throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.SessionFactory#evictCollection(java.lang.String)
     */
    public void evictCollection(String roleName) throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.SessionFactory#evictCollection(java.lang.String, java.io.Serializable)
     */
    public void evictCollection(String roleName, Serializable id)
                    throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.SessionFactory#evictQueries()
     */
    public void evictQueries() throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.SessionFactory#evictQueries(java.lang.String)
     */
    public void evictQueries(String cacheRegion) throws HibernateException {
    }

    /* 
     * @see net.sf.hibernate.SessionFactory#getSQLExceptionConverter()
     */
    public SQLExceptionConverter getSQLExceptionConverter() {
        return null;
    }

    /* 
     * @see javax.naming.Referenceable#getReference()
     */
    public Reference getReference() throws NamingException {
        return null;
    }

}