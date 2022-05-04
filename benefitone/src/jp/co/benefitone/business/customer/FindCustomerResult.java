/* ======================================================================
 *  $Id: FindCustomerResult.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 *    tkakeda
 *      2005/04/05
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/05
 * ======================================================================
 */
package jp.co.benefitone.business.customer;

import java.util.List;

import jp.co.benefitone.common.fw.interceptor.session.BusinessSession;
import jp.co.benefitone.common.fw.interceptor.session.BusinessSessionComposite;

/**
 * 顧客検索結果オブジェクト。
 * <code>BusinessSessionComposite</code>を実装し、ビジネス層からの
 * 情報をWeb層に渡します。
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author first last, Sun Microsystems K.K.
 */
public class FindCustomerResult implements BusinessSessionComposite {
    /** 検索結果リスト */
    private List result;

    /** ビジネスセッションオブジェクト */
    private BusinessSession businessSession;

    /**
     * 検索結果リストを返します。
     * @return 検索結果リスト
     */
    public List getResult() {
        return result;
    }

    /**
     * 検索結果リストを設定します。
     * @param result 検索結果リスト
     */
    public void setResult(List result) {
        this.result = result;
    }

    /**
     * ビジネスセッションを設定します。
     * @param session ビジネスセッション
     */
    public void setBusinessSession(BusinessSession session) {
        this.businessSession = session;
    }

    /**
     * ビジネスセッションを返します。
     * @return ビジネスセッション
     * @see jp.co.benefitone.common.fw.interceptor.session.BusinessSessionComposite#getBusinessSession()
     */
    public BusinessSession getBusinessSession() {
        return this.businessSession;
    }
}
