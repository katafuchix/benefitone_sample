/* ======================================================================
 * $Id: CourseClassServiceImpl.java,v 1.1 2006/01/31 09:24:00 gon Exp $
 * tkakeda
 * 2005/04/05
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/05
 * ======================================================================
 */
package jp.co.benefitone.business.course;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import jp.co.benefitone.integration.course.CourseClassDAO;
import jp.co.benefitone.integration.course.CategoryDAO;
import jp.co.benefitone.model.menu.MenuStractureTypeVO;
import jp.co.benefitone.model.menu.CategoryVO;


/**
 * �ڋq�����T�[�r�X�̎����N���X�B
 *
 * @version $Revision: 1.1 $, $Date: 2006/01/31 09:24:00 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CourseClassServiceImpl implements CourseClassService {

    /** �������v�����Z�b�V�����Ɋi�[����ۂ̃L�[������ */
    public static final String STATISTICS = "findStatistics";
    /** �����������Z�b�V�����Ɋi�[����ۂ̃L�[������*/
    public static final String CRITERIA = "criteria";

    /** �ڋqDAO */
    private CourseClassDAO dao = null;

    private CategoryDAO catDAO = null;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public CourseClassServiceImpl() {
    }

    /**
     * �ڋq�����������������ɃZ�b�V�����������Ɍ������܂��B
     * <p>���������ɂ́A�ڋq���A�������A��Ж����ݒ肳��Ă���A������
     * ���������Ɍڋq���̈ꗗ���擾���܂��B</p>
     * <p>�ڋq���̖���̌������ԁA���ς̌������ԁA�����񐔂��v�����Z�b�V����
     * ���Ɋi�[���܂��B</p>
     * @param criteria ��������
     * @param session �r�W�l�X�Z�b�V����
     * @return �ڋq��������
     * @see jp.co.benefitone.business.customer.CustomerFindService#findCustomer(jp.co.benefitone.business.customer.FindCustomerCriteria, jp.co.benefitone.common.fw.interceptor.session.BusinessSession)
     */
    public List getCourseClasses() {
        return dao.getCourseClasses();
    }

    /**
     * CustomerDAO��ݒ肵�܂��B
     * SpringFramework�ɂ��ˑ��֌W�̉����Ɏg�p���܂��B
     * @param dao �ڋq���DAO�I�u�W�F�N�g
     */
    public void setCourseClassDAO(CourseClassDAO dao) {
        this.dao = dao;
    }

    /**
     * @ejb.transaction type="Required"
     * @ejb.permission unchecked="true"
     */
    public List<CategoryVO> getCatItemsByLevelAndKey(String catLevel, String catKey) {
        return catDAO.getCatItemsByLevelAndKey(catLevel, catKey);
    }

    /**
     * @ejb.transaction type="Required"
     * @ejb.permission unchecked="true"
     */
    public Map getCatItemMapByLevelAndKey(String catLevel, String catKey) {
        Map valueMap = new HashMap();
        CategoryVO catVO = null;
        List catList = null;
//        valueMap.put(new Long(1), "AAA");
//        valueMap.put(new Long(2), "BBB");


            catList = new LinkedList< CategoryVO >();
            catVO = new CategoryVO();
            catVO.setKey(new Long(1));
            catVO.setName("AAA");
            catList.add(catVO);
            catVO = new CategoryVO();
            catVO.setKey(new Long(2));
            catVO.setName("BBB");
            catList.add(catVO);

//        catList = getCatItemsByLevelAndKey(catLevel, catKey);
        Iterator catListIt = (Iterator) catList.iterator();

        while (catListIt.hasNext()) {
            catVO = (CategoryVO) catListIt.next();
            valueMap.put(catVO.getKey(), catVO.getName());
        }
        return valueMap;
    }

    /**
     * @ejb.transaction type="Required"
     * @ejb.permission unchecked="true"
     */
    public Map getCourseTypeItemMap() {
        Map valueMap = new HashMap();

        CategoryVO catVO = null;
        List catList = null;

        catList = catDAO.getCourseTypeItem();
        Iterator catListIt = (Iterator) catList.iterator();

        while (catListIt.hasNext()) {
            catVO = (CategoryVO) catListIt.next();
            valueMap.put(catVO.getKey(), catVO.getName());
        }
        return valueMap;
    }

    /**
     * @ejb.transaction type="Required"
     * @ejb.permission unchecked="true"
     */
    public CategoryDAO getCatDAO() {
        return catDAO;
    }

    /**
     * @ejb.transaction type="Required"
     * @ejb.permission unchecked="true"
     */
    public void setCatDAO(CategoryDAO catDAO) {
        this.catDAO = catDAO;
    }

}
