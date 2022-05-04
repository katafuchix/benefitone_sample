package jp.co.benefitone.model.course;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

public class BntyTypeVO implements Serializable {

	private Integer bntyTypeKey;
	private String bntyTypeCd;
	private String bntyTypeRem;
	private String scaDelFlg;
	private Integer scaVerNo;
	private Date scaEntDt;
	private String scaEntUsrNo;
	private Date scaLatUpdDt;
	private String scaLatUpdUsrNo;

	public BntyTypeVO() { }

	public BntyTypeVO(
		Integer bntyTypeKey,
		String bntyTypeCd,
		String bntyTypeRem,
		String scaDelFlg,
		Integer scaVerNo,
		Date scaEntDt,
		String scaEntUsrNo,
		Date scaLatUpdDt,
		String scaLatUpdUsrNo) {

		this.bntyTypeKey = bntyTypeKey;
		this.bntyTypeCd = bntyTypeCd;
		this.bntyTypeRem = bntyTypeRem;
		this.scaDelFlg = scaDelFlg;
		this.scaVerNo = scaVerNo;
		this.scaEntDt = scaEntDt;
		this.scaEntUsrNo = scaEntUsrNo;
		this.scaLatUpdDt = scaLatUpdDt;
		this.scaLatUpdUsrNo = scaLatUpdUsrNo;
	}

	public Integer getBntyTypeKey() { return bntyTypeKey; }
	public void setBntyTypeKey(Integer bntyTypeKey) { this.bntyTypeKey = bntyTypeKey; }

	public String getBntyTypeCd() { return bntyTypeCd; }
	public void setBntyTypeCd(String bntyTypeCd) { this.bntyTypeCd = bntyTypeCd; }

	public String getBntyTypeRem() { return bntyTypeRem; }
	public void setBntyTypeRem(String bntyTypeRem) { this.bntyTypeRem = bntyTypeRem; }

	public String getScaDelFlg() { return scaDelFlg; }
	public void setScaDelFlg(String scaDelFlg) { this.scaDelFlg = scaDelFlg; }

	public Integer getScaVerNo() { return scaVerNo; }
	public void setScaVerNo(Integer scaVerNo) { this.scaVerNo = scaVerNo; }

	public Date getScaEntDt() { return scaEntDt; }
	public void setScaEntDt(Date scaEntDt) { this.scaEntDt = scaEntDt; }

	public String getScaEntUsrNo() { return scaEntUsrNo; }
	public void setScaEntUsrNo(String scaEntUsrNo) { this.scaEntUsrNo = scaEntUsrNo; }

	public Date getScaLatUpdDt() { return scaLatUpdDt; }
	public void setScaLatUpdDt(Date scaLatUpdDt) { this.scaLatUpdDt = scaLatUpdDt; }

	public String getScaLatUpdUsrNo() { return scaLatUpdUsrNo; }
	public void setScaLatUpdUsrNo(String scaLatUpdUsrNo) { this.scaLatUpdUsrNo = scaLatUpdUsrNo; }

}
