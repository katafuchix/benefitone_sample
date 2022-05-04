package jp.co.benefitone.presentation.course;

public class CourseMenuSerchBean { //extends BaseBean {

	public String init() {
	
		return "session";
	}

}


/**

import jp.co.benefitone.business.partner.MenuAgreeService;

import jp.co.benefitone.model.menu.MServiceAgreeInfVO;
import jp.co.benefitone.presentation.common.LoginUserBean;
import jp.co.benefitone.presentation.common.util.ConvertString;

public class MenuAgreeBean extends BaseBean {
	private String supplierHonrfic;

	private String agreeSntceTitle;

	private String agreeSntce1;

	private String addSntceEntExist;

	private Long trsctCpnyKey;

	private MenuAgreeService menuAgreeService;

	private MServiceAgreeInfVO agreeInf;

	private String trsctInf;

	private String loginUserName;

	private LoginUserBean userbean = new LoginUserBean();

	public String init() {
		userbean = (LoginUserBean) getSessionMap().get("loginUserBean");
		Long trsctCpnyKey = userbean.getTrsctCpnyKey();
		loginUserName = userbean.getLoginUserName();

		agreeInf = menuAgreeService.getAgreeInf();
		trsctInf = menuAgreeService.getTrsctInf(trsctCpnyKey);
		if (agreeInf != null) {
			if (trsctInf.equals("1")) {
				addSntceEntExist = ConvertString.showText(agreeInf
						.getAddSntceEntExist());
			}
			supplierHonrfic = agreeInf
					.getSupplierHonrfic();
			agreeSntceTitle = agreeInf
					.getAgreeSntceTitle();
			agreeSntce1 = ConvertString.showText(agreeInf.getAgreeSntce1());
		}

		return "success";
	}

	public String getAddSntceEntExist() {
		return addSntceEntExist;
	}

	public void setAddSntceEntExist(String addSntceEntExist) {
		this.addSntceEntExist = addSntceEntExist;
	}

	public String getAgreeSntce1() {
		return agreeSntce1;
	}

	public void setAgreeSntce1(String agreeSntce1) {
		this.agreeSntce1 = agreeSntce1;
	}

	public String getAgreeSntceTitle() {
		return agreeSntceTitle;
	}

	public void setAgreeSntceTitle(String agreeSntceTitle) {
		this.agreeSntceTitle = agreeSntceTitle;
	}

	public MenuAgreeService getMenuAgreeService() {
		return menuAgreeService;
	}

	public void setMenuAgreeService(MenuAgreeService menuAgreeService) {
		this.menuAgreeService = menuAgreeService;
	}

	public String getSupplierHonrfic() {
		return supplierHonrfic;
	}

	public void setSupplierHonrfic(String supplierHonrfic) {
		this.supplierHonrfic = supplierHonrfic;
	}

	public long getTrsctCpnyKey() {
		return trsctCpnyKey;
	}

	public void setTrsctCpnyKey(long trsctCpnyKey) {
		this.trsctCpnyKey = trsctCpnyKey;
	}
*/
	/**
	 * @return Returns the loginUserName.
	 */
/**	public String getLoginUserName() {
		return loginUserName;
	}
*/
	/**
	 * @param loginUserName
	 *            The loginUserName to set.
	 */
/**	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}
}

*/



