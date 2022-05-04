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
 * �ڋq�����T�[�r�X�C���^�[�t�F�[�X�B
 *
 * @version $Revision: 1.1 $, $Date: 2006/01/31 09:24:00 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public interface CourseClassService {
    /**
     * �Z�b�V������񂩂�ڋq�����������܂��B
     * @param criteria ��������
     * @param session �r�W�l�X�Z�b�V����
     * @return ���������Ɉ�v�����ڋq���̈ꗗ��Ԃ��܂��B
     * @ejb.transaction type="Required"
     * @ejb.permission unchecked="true"
     */
    List getCourseClasses();
    Map getCatItemMapByLevelAndKey(String catLevel, String catKey);
    Map getCourseTypeItemMap();
}
