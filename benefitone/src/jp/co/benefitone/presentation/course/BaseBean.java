/* ======================================================================
 * $Id: BaseBean.java,v 1.1 2006/01/31 09:27:13 gon Exp $
 * Hiroshi Kajisha
 * 2005/04/11
 * Originator: Hiroshi.Kajisha@Sun.COM
 * OriginDate: 2005/04/11
 * ======================================================================
 */
package jp.co.benefitone.presentation.course;

import java.util.Map;

import javax.faces.context.FacesContext;

import jp.co.benefitone.common.fw.web.ErrorHandlerBean;

/**
 * バッキングビーンのスーパクラスです。
 *
 * @author Hiroshi Kajisha
 * @version $Revision: 1.1 $
 */
public abstract class BaseBean {
    /**
     * 管理者ロール
     */
    public static final String MANAGER_ROLE = "manager";

    /**
     * エラーハンドラ
     */
    private ErrorHandlerBean errorHandlerBean;

    /**
     * ユーザは、管理者権限があるかを調べます。
     * @return true なら管理者権限があります。
     */
    public boolean isManager() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getExternalContext().isUserInRole(MANAGER_ROLE);
    }

    /**
     * @return sessionMap を返します。
     */
    public Map getSessionMap() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getExternalContext().getSessionMap();
    }

    /**
     * @return errorHandler を返します。
     */
    public ErrorHandlerBean getErrorHandlerBean() {
        return errorHandlerBean;
    }

    /**
     * @param errorHandler errorHandler を設定します。
     */
    public void setErrorHandlerBean(ErrorHandlerBean errorHandler) {
        this.errorHandlerBean = errorHandler;
    }
}
