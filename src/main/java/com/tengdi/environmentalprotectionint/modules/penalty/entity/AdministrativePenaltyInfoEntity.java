package com.tengdi.environmentalprotectionint.modules.penalty.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.tengdi.environmentalprotectionint.modules.common.utils.Utils;

import java.io.Serializable;
import java.util.Date;

/**
 * 处罚情况
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-23 09:24:41
 */
@TableName("administrative_penalty_info")
public class AdministrativePenaltyInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键UUID
	 */
	@TableId
	private String pid;
	/**
	 * 对应的污染源（企业）ID
	 */
	private String cid;
	/**
	 * 立案时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String filingTime;
	/**
	 * 处罚主体
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String punishSubject;
	/**
	 * 被处罚单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String punishedCompanyName;
	/**
	 * 案情概述
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String caseOverview;
	/**
	 * 违法行为
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String illegalActivities;
	/**
	 * 违法类型
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String  illegalType;
	/**
	 * 违法类型name
	 */
	@TableField(exist = false)
	private String illegalTypeName;

	public String getIllegalTypeName() {
		return illegalTypeName;
	}

	public void setIllegalTypeName(String illegalTypeName) {
		this.illegalTypeName = illegalTypeName;
	}

	/**
	 * 处罚结果
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String punishmentResult;
	/**
	 * 处罚依据
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String punishmentBasis;
	/**
	 * 处罚执行情况
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String punishmentExecution;
	/**
	 * 结案时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String closingTime;

	/**
	 * 创建时间
	 */
	private Date createdate;

	/**
	 * 复议情况
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String reconsideration;
	/**
	 *申诉情况
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String appealSituation;

	public String getReconsideration() {
		return reconsideration;
	}

	public void setReconsideration(String reconsideration) {
		this.reconsideration = reconsideration;
	}

	public String getAppealSituation() {
		return appealSituation;
	}

	public void setAppealSituation(String appealSituation) {
		this.appealSituation = appealSituation;
	}

	/**
	 * 被罚单位名称
	 */
	@TableField(exist=false)
	private String companyName ;
	/**
	 * 被罚单位地址
	 */
	@TableField(exist=false)
	private String companyaddress;
	/**
	 *
	 *年份
	 */
	@TableField(exist=false)
	private String year ;
	/**
	 *
	 *月份
	 */
	@TableField(exist=false)
	private String month ;

	/**
	 *
	 *月处罚金额
	 */
	@TableField(exist=false)
	private String monthmonery ;
	/**
	 * 月处罚数量
	 */
	@TableField(exist=false)
	private String monthcases ;

	/**
	 * 类型总数统计
	 * @return
	 */
	@TableField(exist=false)
	private String typecounts ;

	public String getTypecounts() {
		return typecounts;
	}

	public void setTypecounts(String typecounts) {
		this.typecounts = typecounts;
	}

	public String getCompanycases() {
		return companycases;
	}

	public void setCompanycases(String companycases) {
		this.companycases = companycases;
	}

	public String getCompanymonerys() {
		return companymonerys;
	}

	public void setCompanymonerys(String companymonerys) {
		this.companymonerys = companymonerys;
	}

	/**
	 * 公司年度处罚数量
	 */
	@TableField(exist=false)
	private String companycases ;
	/**
	 * 公司年度处罚金额
	 */
	@TableField(exist=false)
	private String  companymonerys ;

	/**
	 * 公司排名数量
	 */
	@TableField(exist=false)
	private String  companyrankcount ;

	/**
	 *处罚编号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String  penaltyNumber ;
	/**
	 *营业执照注册号（公民身份证号）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String  business ;
	/**
	 *法定代表人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String  representative ;
	/**
	 *联系电话
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String  phone ;
	/**
	 *邮政编码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String  postcode ;
	/**
	 *调查人员
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String  researcher ;
	/**
	 * 处罚决定文号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String  penaltySign ;

	public String getPenaltyNumber() {
		return penaltyNumber;
	}

	public void setPenaltyNumber(String penaltyNumber) {
		this.penaltyNumber = penaltyNumber;
	}

	/**
	 * 设置：主键UUID
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：主键UUID
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：对应的污染源（企业）ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCompanyrankcount() {
		return companyrankcount;
	}

	public void setCompanyrankcount(String companyrankcount) {
		this.companyrankcount = companyrankcount;
	}

	/**
	 * 获取：对应的污染源（企业）ID
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：立案时间
	 */
	public void setFilingTime(String filingTime) {
		this.filingTime = filingTime;
	}
	/**
	 * 获取：立案时间
	 */
	public String getFilingTime() {
		return Utils.subStringDate(filingTime);
	}
	/**
	 * 设置：处罚主体
	 */
	public void setPunishSubject(String punishSubject) {
		this.punishSubject = punishSubject;
	}
	/**
	 * 获取：处罚主体
	 */
	public String getPunishSubject() {
		return punishSubject;
	}
	/**
	 * 设置：被处罚单位
	 */
	public void setPunishedCompanyName(String punishedCompanyName) {
		this.punishedCompanyName = punishedCompanyName;
	}
	/**
	 * 获取：被处罚单位
	 */
	public String getPunishedCompanyName() {
		return punishedCompanyName;
	}
	/**
	 * 设置：案情概述
	 */
	public void setCaseOverview(String caseOverview) {
		this.caseOverview = caseOverview;
	}
	/**
	 * 获取：案情概述
	 */
	public String getCaseOverview() {
		return caseOverview;
	}
	/**
	 * 设置：违法行为
	 */
	public void setIllegalActivities(String illegalActivities) {
		this.illegalActivities = illegalActivities;
	}
	/**
	 * 获取：违法行为
	 */
	public String getIllegalActivities() {
		return illegalActivities;
	}
	/**
	 * 设置：违法类型
	 */
	public void setIllegalType(String  illegalType) {
		this.illegalType = illegalType;
	}
	/**
	 * 获取：违法类型
	 */
	public String  getIllegalType() {
		return illegalType;
	}
	/**
	 * 设置：处罚结果
	 */
	public void setPunishmentResult(String punishmentResult) {
		this.punishmentResult = punishmentResult;
	}
	/**
	 * 获取：处罚结果
	 */
	public String getPunishmentResult() {
		return punishmentResult;
	}
	/**
	 * 设置：处罚依据
	 */
	public void setPunishmentBasis(String punishmentBasis) {
		this.punishmentBasis = punishmentBasis;
	}
	/**
	 * 获取：处罚依据
	 */
	public String getPunishmentBasis() {
		return punishmentBasis;
	}
	/**
	 * 设置：处罚执行情况
	 */
	public void setPunishmentExecution(String punishmentExecution) {
		this.punishmentExecution = punishmentExecution;
	}
	/**
	 * 获取：处罚执行情况
	 */
	public String getPunishmentExecution() {
		return punishmentExecution;
	}
	/**
	 * 设置：结案时间
	 */
	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}
	/**
	 * 获取：结案时间
	 */
	public String getClosingTime() {
		return Utils.subStringDate(closingTime);
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：创建时间
	 */



	public Date getCreatedate() {
		return createdate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyaddress() {
		return companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getMonthmonery() {
		return monthmonery;
	}

	public void setMonthmonery(String monthmonery) {
		this.monthmonery = monthmonery;
	}

	public String getMonthcases() {
		return monthcases;
	}

	public void setMonthcases(String monthcases) {
		this.monthcases = monthcases;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getRepresentative() {
		return representative;
	}

	public void setRepresentative(String representative) {
		this.representative = representative;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getResearcher() {
		return researcher;
	}

	public void setResearcher(String researcher) {
		this.researcher = researcher;
	}

	public String getPenaltySign() {
		return penaltySign;
	}

	public void setPenaltySign(String penaltySign) {
		this.penaltySign = penaltySign;
	}
}
