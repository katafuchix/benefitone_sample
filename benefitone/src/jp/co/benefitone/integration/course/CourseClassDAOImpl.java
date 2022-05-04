/* ======================================================================
 *  $Id: CourseClassDAOImpl.java,v 1.1 2006/01/31 11:15:11 gon Exp $
 *    tkakeda
 *      2005/04/05
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/05
 * ======================================================================
 */
package jp.co.benefitone.integration.course;

import java.util.List;
import java.util.ArrayList;

import jp.co.benefitone.common.fw.integration.DatabaseRuntimeException;
import jp.co.benefitone.common.fw.integration.HibernateUtil;
import jp.co.benefitone.model.menu.MenuStractureTypeVO;
import net.sf.hibernate.Criteria;
import net.sf.hibernate.FetchMode;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.MatchMode;
import net.sf.hibernate.expression.Order;

/**
 * �ڋqDAO�����N���X�ł��B
 * �����Hibernate��HQL�ł͂Ȃ��ACriteria�Ō������������܂����B
 *
 * @version $Revision: 1.1 $, $Date: 2006/01/31 11:15:11 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CourseClassDAOImpl implements CourseClassDAO {

    /** �Z�b�V�����t�@�N�g���I�u�W�F�N�g */
    private SessionFactory sessionFactory;

    /**
     * SessionFactory��ݒ肵�܂��B
     * �e�X�g�ł͎蓮�A���s���ł�SpringFramework�ɂ��Wiring����܂��B
     *
     * @param sessionFactory �Z�b�V�����t�@�N�g���I�u�W�F�N�g
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * �Z�b�V�����t�@�N�g����Ԃ��܂��B
     * @return �Z�b�V�����t�@�N�g��
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

	public List getCourseClasses() {
		List mylist = new ArrayList();
		mylist.add(new MenuStractureTypeVO(1, "AAA", "A12345"));
		mylist.add(new MenuStractureTypeVO(2, "BBB", "B12345"));
		mylist.add(new MenuStractureTypeVO(3, "CCC", "C12345"));
		
		return mylist;
	}
}
