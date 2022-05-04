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
 * �o�b�L���O�r�[���̃X�[�p�N���X�ł��B
 *
 * @author Hiroshi Kajisha
 * @version $Revision: 1.1 $
 */
public abstract class BaseBean {
    /**
     * �Ǘ��҃��[��
     */
    public static final String MANAGER_ROLE = "manager";

    /**
     * �G���[�n���h��
     */
    private ErrorHandlerBean errorHandlerBean;

    /**
     * ���[�U�́A�Ǘ��Ҍ��������邩�𒲂ׂ܂��B
     * @return true �Ȃ�Ǘ��Ҍ���������܂��B
     */
    public boolean isManager() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getExternalContext().isUserInRole(MANAGER_ROLE);
    }

    /**
     * @return sessionMap ��Ԃ��܂��B
     */
    public Map getSessionMap() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getExternalContext().getSessionMap();
    }

    /**
     * @return errorHandler ��Ԃ��܂��B
     */
    public ErrorHandlerBean getErrorHandlerBean() {
        return errorHandlerBean;
    }

    /**
     * @param errorHandler errorHandler ��ݒ肵�܂��B
     */
    public void setErrorHandlerBean(ErrorHandlerBean errorHandler) {
        this.errorHandlerBean = errorHandler;
    }
}
