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
 * 顧客検索サービスの実装クラス。
 *
 * @version $Revision: 1.1 $, $Date: 2006/01/31 09:24:00 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CourseClassServiceImpl implements CourseClassService {

    /** 検索統計情報をセッションに格納する際のキー文字列 */
    public static final String STATISTICS = "findStatistics";
    /** 検索条件をセッションに格納する際のキー文字列*/
    public static final String CRITERIA = "criteria";

    /** 顧客DAO */
    private CourseClassDAO dao = null;

    private CategoryDAO catDAO = null;

    /**
     * デフォルトコンストラクタ。
     */
    public CourseClassServiceImpl() {
    }

    /**
     * 顧客情報を検索条件を元にセッション情報を元に検索します。
     * <p>検索条件には、顧客名、部署名、会社名が設定されており、それらの
     * 条件を元に顧客情報の一覧を取得します。</p>
     * <p>顧客情報の毎回の検索時間、平均の検索時間、検索回数を計測しセッション
     * 情報に格納します。</p>
     * @param criteria 検索条件
     * @param session ビジネスセッション
     * @return 顧客検索結果
     * @see jp.co.benefitone.business.customer.CustomerFindService#findCustomer(jp.co.benefitone.business.customer.FindCustomerCriteria, jp.co.benefitone.common.fw.interceptor.session.BusinessSession)
     */
    public List getCourseClasses() {
        return dao.getCourseClasses();
    }

    /**
     * CustomerDAOを設定します。
     * SpringFrameworkによる依存関係の解決に使用します。
     * @param dao 顧客情報DAOオブジェクト
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
