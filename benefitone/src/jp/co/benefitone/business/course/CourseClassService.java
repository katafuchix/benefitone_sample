/* ======================================================================
 * $Id: CourseClassService.java,v 1.1 2006/01/31 09:24:00 gon Exp $
 * tkakeda
 * 2005/01/21
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/MM/dd
 * ======================================================================
 */
package jp.co.benefitone.business.course;

import java.util.List;
import java.util.Map;

import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import jp.co.benefitone.model.menu.MenuStractureTypeVO;

/**
 * 顧客検索サービスインターフェース。
 *
 * @version $Revision: 1.1 $, $Date: 2006/01/31 09:24:00 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public interface CourseClassService {
    /**
     * セッション情報から顧客情報を検索します。
     * @param criteria 検索条件
     * @param session ビジネスセッション
     * @return 検索条件に一致した顧客情報の一覧を返します。
     * @ejb.transaction type="Required"
     * @ejb.permission unchecked="true"
     */
    List getCourseClasses();
    Map getCatItemMapByLevelAndKey(String catLevel, String catKey);
    Map getCourseTypeItemMap();
}
