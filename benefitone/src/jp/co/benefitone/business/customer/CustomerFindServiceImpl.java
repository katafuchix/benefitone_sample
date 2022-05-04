/* ======================================================================
 * $Id: CustomerFindServiceImpl.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 * tkakeda
 * 2005/04/05
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/05
 * ======================================================================
 */
package jp.co.benefitone.business.customer;

import java.util.List;

import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import jp.co.benefitone.integration.customer.CustomerDAO;
import jp.co.benefitone.model.customer.CustomerVO;


/**
 * 顧客検索サービスの実装クラス。
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class CustomerFindServiceImpl implements CustomerFindService {

    /** 検索統計情報をセッションに格納する際のキー文字列 */
    public static final String STATISTICS = "findStatistics";
    /** 検索条件をセッションに格納する際のキー文字列*/
    public static final String CRITERIA = "criteria";

    /** 顧客DAO */
    private CustomerDAO dao = null;

    /**
     * デフォルトコンストラクタ。
     */
    public CustomerFindServiceImpl() {
    }

    /**
     * @see jp.co.benefitone.business.customer.CustomerFindService#findCustomer(jp.co.benefitone.business.customer.FindCustomerCriteria)
     */
    List findCustomer(FindCustomerCriteria criteria) {
        return dao.find(
                        criteria.getCustomerName(),
                        criteria.getDepartmentName(),
                        criteria.getCompanyName());
    }

    /**
     * 顧客IDを受けとり一件の顧客VOを取得します。
     * @param id 顧客ID
     * @return 顧客情報
     * @see jp.co.benefitone.business.customer.CustomerFindService#selectCustomer(java.lang.Integer)
     */
    public CustomerVO selectCustomer(Integer id) {
        return dao.select(id);
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
    public FindCustomerResult findCustomer(FindCustomerCriteria criteria,
                                           BusinessSession session) {
        FindCustomerResult result = new FindCustomerResult();
        setupCriteria(criteria);

        long start = System.currentTimeMillis();
        result.setResult(findCustomer(criteria));
        long end = System.currentTimeMillis();

        FindStatistics statistics = getFindStatistics(session, start, end);
        session.setAttribute(STATISTICS, statistics);
        session.setAttribute(CRITERIA, criteria);
        result.setBusinessSession(session);
        return result;
    }

    /**
     * 統計情報をセッション情報より取得します。
     * セッションになければ新規で、あればそちらを使って今回の検索時間を
     * 計算して格納します。
     * @param session セッション情報
     * @param start 開始時間
     * @param end 終了時間
     * @return 検索統計情報
     */
    private FindStatistics getFindStatistics(
                               BusinessSession session,
                               long start,
                               long end) {

        FindStatistics statistics = null;
        if (session.getAttribute(STATISTICS) == null) {
            statistics = new FindStatistics();
        }
        else {
            statistics =
                (FindStatistics) session.getAttribute(STATISTICS);
        }
        statistics.calculate(start, end);
        return statistics;
    }

    /**
     * 検索条件の設定をします。
     * 空文字の条件をnullに変換して格納しなおします。
     * @param criteria 検索条件
     */
    private void setupCriteria(FindCustomerCriteria criteria) {
        criteria.setCustomerName(empty2null(criteria.getCustomerName()));
        criteria.setDepartmentName(empty2null(criteria.getDepartmentName()));
        criteria.setCompanyName(empty2null(criteria.getCompanyName()));
    }

    /**
     * 空文字列をnullに変換します。 nullでも空文字でもない場合はそのまま返す。
     *
     * @param attribute 属性オブジェクト
     * @return 変換後文字列
     */
    private String empty2null(Object attribute) {
        if (attribute == null) {
            return null;
        }
        if (attribute.equals("")) {
            return null;
        }
        return String.valueOf(attribute);
    }

    /**
     * CustomerDAOを設定します。
     * SpringFrameworkによる依存関係の解決に使用します。
     * @param dao 顧客情報DAOオブジェクト
     */
    public void setCustomerDAO(CustomerDAO dao) {
        this.dao = dao;
    }
}
