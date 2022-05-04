/* ======================================================================
 *  $Id: CourseClassDAO.java,v 1.1 2006/01/31 11:15:11 gon Exp $
 *    tkakeda
 *      2005/04/05
 * Originator: first.last@Sun.COM
 * OriginDate: 2005/MM/dd
 * ======================================================================
 */
package jp.co.benefitone.integration.course;

import java.util.List;
import jp.co.benefitone.model.menu.MenuStractureTypeVO;

/**
 * 顧客DAOインターフェース。
 *
 * @version $Revision: 1.1 $, $Date: 2006/01/31 11:15:11 $
 * @author first last, Sun Microsystems K.K.
 */
public interface CourseClassDAO {
    List getCourseClasses();
}
