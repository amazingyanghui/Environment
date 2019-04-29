package com.tengdi.environmentalprotectionint.modules.permit.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 排污许可证
 *
 * @author tengdi
 * @email
 * @date 2018-09-10 15:38:35
 */
@TableName("pollutant_discharge_permit")
public class PollutantDischargePermitEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * UUID主键
	 */
	@TableId
	private String pid;
	/**
	 * 对应的企业ID
	 */
	private String cid;
	/**
	 * 许可证编号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String permitCode;
	/**
	 * 单位名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String companyName;
	/**
	 * 生产经营场所地址
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String companyAddress;
	/**
	 * 行业类别
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer industryCategory;
	@TableField(exist = false)
	private String industryids;

	public String getIndustryids() {
		return industryids;
	}

	public void setIndustryids(String industryids) {
		this.industryids = industryids;
	}

	/**
	 * 技术负责人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String technologyLeader;
	/**
	 * 联系电话
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String linkphone;
	/**
	 * 发证日期
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String issueDate;
	/**
	 * 有效期开始日期
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String startDate;
	/**
	 * 有效期结束日期
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String endDate;
	/**
	 * 发证单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String issueCompany;
	/**
	 * 主要污染物类别(0:废气、1:废水)
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer mainWasteCategory;
	/**
	 * 主要污染物类别name
	 */
	@TableField(exist = false)
	private String mainWasteCategoryName;
	/**
	 * 大气主要污染物种类
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String airMainWaste;
	/**
	 * 大气污染物排放规律(0:有组织,1:无组织)
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String airPollutantsRule;
	/**
	 * 大气污染物排放规律(name)
	 */
	@TableField(exist = false)
	private String airPollutantsRuleName;

	public String getMainWasteCategoryName() {
		return mainWasteCategoryName;
	}

	public void setMainWasteCategoryName(String mainWasteCategoryName) {
		this.mainWasteCategoryName = mainWasteCategoryName;
	}

	public String getAirPollutantsRuleName() {
		return airPollutantsRuleName;
	}

	public void setAirPollutantsRuleName(String airPollutantsRuleName) {
		this.airPollutantsRuleName = airPollutantsRuleName;
	}

	/**
	 * 大气污染物排放执行标准
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String airPollutantsStandard;
	/**
	 * 废水主要污染物种类
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String waterMainWaste;
	/**
	 * 废水污染物排放规律
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String waterPollutantsRule;
	/**
	 * 废水污染物排放执行标准
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String waterPollutantsStandard;
	/**
	 * 排污权使用和交易信息
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String emissionsTrading;
	/**
	 * 正本文件
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String originalDocument;
	/**
	 * 副本文件
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String copyFile;
	/**
	 * 创建时间
	 */
	private Date createdate;
	/**
	 * 修改时间
	 */
	private Date updatedate;
	/**
	 * 删除时间
	 */
	private Date deletedate;

	/**
	 * 月份
	 */
	@TableField(exist=false)
	private String month;

	/**
	 * 月统计数
	 */
	@TableField(exist=false)
	private String counts;
	/**
	 * 行业名称
	 */
	@TableField(exist=false)
	private String industry ;
	/**
	 * 行业证书数量
	 */
	@TableField(exist=false)
	private String industrypermits ;
	/**
	 * 证书类型 0 临时 1 正式
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer permitType;
	/**
	 * 证书类型name
	 */
	@TableField(exist = false)
	private String permitTypeName;

	public String getPermitTypeName() {
		return permitTypeName;
	}

	public void setPermitTypeName(String permitTypeName) {
		this.permitTypeName = permitTypeName;
	}

	public Integer getPermitType() {
		return permitType;
	}

	public void setPermitType(Integer permitType) {
		this.permitType = permitType;
	}

	/**
	 * 行业证书所占比例
	 */
	@TableField(exist=false)
	private String industrypermitscale ;

	/**
	 * 管控要求
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String controlRequirements;

	public String getControlRequirements() {
		return controlRequirements;
	}

	public void setControlRequirements(String controlRequirements) {
		this.controlRequirements = controlRequirements;
	}

	/**
	 * 设置：UUID主键
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：UUID主键
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：对应的企业ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：对应的企业ID
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：许可证编号
	 */
	public void setPermitCode(String permitCode) {
		this.permitCode = permitCode;
	}
	/**
	 * 获取：许可证编号
	 */
	public String getPermitCode() {
		return permitCode;
	}
	/**
	 * 设置：单位名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：单位名称
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：生产经营场所地址
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	/**
	 * 获取：生产经营场所地址
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}
	/**
	 * 设置：行业类别
	 */
	public void setIndustryCategory(Integer industryCategory) {
		this.industryCategory = industryCategory;
	}
	/**
	 * 获取：行业类别
	 */
	public Integer getIndustryCategory() {
		return industryCategory;
	}
	/**
	 * 设置：技术负责人
	 */
	public void setTechnologyLeader(String technologyLeader) {
		this.technologyLeader = technologyLeader;
	}
	/**
	 * 获取：技术负责人
	 */
	public String getTechnologyLeader() {
		return technologyLeader;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLinkphone(String linkphone) {
		this.linkphone = linkphone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLinkphone() {
		return linkphone;
	}
	/**
	 * 设置：发证日期
	 */
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	/**
	 * 获取：发证日期
	 */
	public String getIssueDate() {
		return issueDate;
	}
	/**
	 * 设置：有效期开始日期
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取：有效期开始日期
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * 设置：有效期结束日期
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：有效期结束日期
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 设置：发证单位
	 */
	public void setIssueCompany(String issueCompany) {
		this.issueCompany = issueCompany;
	}
	/**
	 * 获取：发证单位
	 */
	public String getIssueCompany() {
		return issueCompany;
	}
	/**
	 * 设置：主要污染物类别
	 */
	public void setMainWasteCategory(Integer mainWasteCategory) {
		this.mainWasteCategory = mainWasteCategory;
	}
	/**
	 * 获取：主要污染物类别
	 */
	public Integer getMainWasteCategory() {
		return mainWasteCategory;
	}
	/**
	 * 设置：大气主要污染物种类
	 */
	public void setAirMainWaste(String airMainWaste) {
		this.airMainWaste = airMainWaste;
	}
	/**
	 * 获取：大气主要污染物种类
	 */
	public String getAirMainWaste() {
		return airMainWaste;
	}
	/**
	 * 设置：大气污染物排放规律
	 */
	public void setAirPollutantsRule(String airPollutantsRule) {
		this.airPollutantsRule = airPollutantsRule;
	}
	/**
	 * 获取：大气污染物排放规律
	 */
	public String getAirPollutantsRule() {
		return airPollutantsRule;
	}
	/**
	 * 设置：大气污染物排放执行标准
	 */
	public void setAirPollutantsStandard(String airPollutantsStandard) {
		this.airPollutantsStandard = airPollutantsStandard;
	}
	/**
	 * 获取：大气污染物排放执行标准
	 */
	public String getAirPollutantsStandard() {
		return airPollutantsStandard;
	}
	/**
	 * 设置：废水主要污染物种类
	 */
	public void setWaterMainWaste(String waterMainWaste) {
		this.waterMainWaste = waterMainWaste;
	}
	/**
	 * 获取：废水主要污染物种类
	 */
	public String getWaterMainWaste() {
		return waterMainWaste;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getCounts() {
		return counts;
	}

	public void setCounts(String counts) {
		this.counts = counts;
	}

	/**
	 * 设置：废水污染物排放规律
	 */
	public void setWaterPollutantsRule(String waterPollutantsRule) {
		this.waterPollutantsRule = waterPollutantsRule;
	}
	/**
	 * 获取：废水污染物排放规律
	 */
	public String getWaterPollutantsRule() {
		return waterPollutantsRule;
	}
	/**
	 * 设置：废水污染物排放执行标准
	 */
	public void setWaterPollutantsStandard(String waterPollutantsStandard) {
		this.waterPollutantsStandard = waterPollutantsStandard;
	}
	/**
	 * 获取：废水污染物排放执行标准
	 */
	public String getWaterPollutantsStandard() {
		return waterPollutantsStandard;
	}
	/**
	 * 设置：排污权使用和交易信息
	 */
	public void setEmissionsTrading(String emissionsTrading) {
		this.emissionsTrading = emissionsTrading;
	}
	/**
	 * 获取：排污权使用和交易信息
	 */
	public String getEmissionsTrading() {
		return emissionsTrading;
	}
	/**
	 * 设置：正本文件
	 */
	public void setOriginalDocument(String originalDocument) {
		this.originalDocument = originalDocument;
	}
	/**
	 * 获取：正本文件
	 */
	public String getOriginalDocument() {
		return originalDocument;
	}
	/**
	 * 设置：副本文件
	 */
	public void setCopyFile(String copyFile) {
		this.copyFile = copyFile;
	}
	/**
	 * 获取：副本文件
	 */
	public String getCopyFile() {
		return copyFile;
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
	/**
	 * 设置：修改时间
	 */
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdatedate() {
		return updatedate;
	}
	/**
	 * 设置：删除时间
	 */
	public void setDeletedate(Date deletedate) {
		this.deletedate = deletedate;
	}
	/**
	 * 获取：删除时间
	 */
	public Date getDeletedate() {
		return deletedate;
	}
	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getIndustrypermits() {
		return industrypermits;
	}

	public void setIndustrypermits(String industrypermits) {
		this.industrypermits = industrypermits;
	}

	public String getIndustrypermitscale() {
		return industrypermitscale;
	}

	public void setIndustrypermitscale(String industrypermitscale) {
		this.industrypermitscale = industrypermitscale;
	}
}
