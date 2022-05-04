/* ======================================================================
 * $Id: CourseClassListBean.java,v 1.1 2006/01/31 09:27:13 gon Exp $
 * Hiroshi Kajisha
 * 2005/04/11
 * Originator: Hiroshi.Kajisha@Sun.COM
 * OriginDate: 2005/04/11
 * ======================================================================
 */
package jp.co.benefitone.presentation.course;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Collections;
import java.util.Iterator;

import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import jp.co.benefitone.business.course.CourseClassService;
import jp.co.benefitone.common.fw.web.WebBusinessSessionFactoryBean;
import jp.co.benefitone.core.util.partner.PartnerConstant;


/**
 * コース検索のための BackingBean です。
 * @author Hiroshi Kajisha
 * @version $Revision: 1.1 $
 */
public class CourseClassListBean extends BaseBean {
    /**
     * 顧客情報検索サービス。
     */
    private CourseClassService courseClassService;

    /**
     * 顧客情報の一覧。
     */
//    private List courseClassList;
    private List<SelectItem> courseClassItems = null;
    
    /**
     * コース検索条件
     */
    // コース種別
    private Map selectCourseTypeMap = new HashMap();
    private List selectCourseTypeList = new ArrayList();

    // コース区分・ベース
    private List<SelectItem> courseClassItems1 = null;
    // コース区分・オリジナル
    private List<SelectItem> courseClassItems2 = null;
    // コース区分・カスタム
    private List<SelectItem> courseClassItems3 = null;
    // 利用可能カテゴリ・大カテゴリ
    private Map selectLargeCategoryMap = new HashMap();
    private List selectLargeCategoryList = new ArrayList();

    // 利用可能カテゴリ・中カテゴリ
    private Map selectMiddleCategoryMap = new HashMap();
    private List selectMiddleCategoryList = new ArrayList();
    // 利用可能カテゴリ・小カテゴリ 
    private Map selectSmallCategoryMap = new HashMap();
    private List selectSmallCategoryList = new ArrayList();

	private String test = "コーステスト";
	
    /**
     * <code>BusinessSession</code>のファクトリ
     */
    private WebBusinessSessionFactoryBean businessSessionFactoryBean;

    /**
     * @return sessionFactory を返します。
     */
    public WebBusinessSessionFactoryBean getBusinessSessionFactoryBean() {
        return businessSessionFactoryBean;
    }

    /**
     * @param sessionFactory sessionFactory を設定します。
     */
    public void setBusinessSessionFactoryBean(
            WebBusinessSessionFactoryBean sessionFactory) {
        this.businessSessionFactoryBean = sessionFactory;
    }

    private List convertMapToSelectList(Map map) {
    	List list = new ArrayList();
    	
    	if (map != null) {
    		Set keySet = map.keySet();
    		List keylist = new ArrayList(keySet);
    		Collections.sort(keylist);
    		list.add(new SelectItem("-1", "------------"));

    		for (Iterator iterator = keylist.iterator(); iterator.hasNext();) {
    			Long key = (Long)iterator.next();
    			String value = (String)map.get(key);
    			if (value == null) value = " ";
    			list.add(new SelectItem(String.valueOf(key), value));
    		}
    	}
		
		return list;
	}

    /**
     * @return コース種別のselectOneMenuリストを取得する
     */
    public List getSelectCourseTypeList() {
        if (selectCourseTypeList.size() > 0) {
            return selectCourseTypeList;
        }
        selectCourseTypeMap = courseClassService.getCourseTypeItemMap();
        selectCourseTypeList = convertMapToSelectList(selectCourseTypeMap);
        return selectCourseTypeList;
    }

	public void setSelectCourseTypeList(List selectCourseTypeList)
	{
		this.selectCourseTypeList = selectCourseTypeList;
	}
	
    /**
     * @return 大カテゴリのselectOneMenuリストを取得する
     */
    public List getSelectLargeCategoryList() {
        if (selectLargeCategoryList.size() > 0) {
            return selectLargeCategoryList;
        }
        selectLargeCategoryMap = courseClassService.getCatItemMapByLevelAndKey(PartnerConstant.LARGE_CAT_LEVEL, "");
        selectLargeCategoryList = convertMapToSelectList(selectLargeCategoryMap);
        return selectLargeCategoryList;
    }

	public void setSelectLargeCategoryList(List selectLargeCategoryList)
	{
		this.selectLargeCategoryList = selectLargeCategoryList;
	}
	
    /**
     * @return 中カテゴリのselectOneMenuリストを取得する
     */
    public List getSelectMiddleCategoryList() {
        if (selectMiddleCategoryList.size() > 0) {
            return selectMiddleCategoryList;
        }
        selectMiddleCategoryMap = courseClassService.getCatItemMapByLevelAndKey(PartnerConstant.MIDDLE_CAT_LEVEL, "");
        selectMiddleCategoryList = convertMapToSelectList(selectMiddleCategoryMap);
        return selectMiddleCategoryList;
    }

	public void setSelectMiddleCategoryList(List selectMiddleCategoryList)
	{
		this.selectLargeCategoryList = selectLargeCategoryList;
	}
	
    /**
     * @return 小カテゴリのselectOneMenuリストを取得する
     */
    public List getSelectSmallCategoryList() {
        if (selectSmallCategoryList.size() > 0) {
            return selectSmallCategoryList;
        }
        selectSmallCategoryMap = courseClassService.getCatItemMapByLevelAndKey(PartnerConstant.SMALL_CAT_LEVEL, "");
        selectSmallCategoryList = convertMapToSelectList(selectSmallCategoryMap);
        return selectSmallCategoryList;
    }

	public void setSelectSmallCategoryList(List selectSmallCategoryList)
	{
		this.selectSmallCategoryList = selectSmallCategoryList;
	}
	
    /**
     * @return customerList を返します。
     */
    public List getCourseClassItems() {
        this.courseClassItems = new LinkedList< SelectItem >();
        this.courseClassItems.add(new SelectItem("a","aaa"));
        this.courseClassItems.add(new SelectItem("b","bbb"));
        this.courseClassItems.add(new SelectItem("c","ccc"));
        return this.courseClassItems;
    }

    /**
     * @param customerList customerList を設定します。
     */
    public void setCourseClassItems(List courseClassItems) {
        this.courseClassItems = courseClassItems;
    }

    /**
     * @return service を返します。
     */
    public CourseClassService getCourseClassService() {
        return courseClassService;
    }

    /**
     * @param service service を設定します。
     */
    public void setCourseClassService(CourseClassService service) {
        this.courseClassService = service;
    }

	public String getTest() {
		return this.test;
	}

	public void setTest(String test) {
		this.test = test;
	}

}
