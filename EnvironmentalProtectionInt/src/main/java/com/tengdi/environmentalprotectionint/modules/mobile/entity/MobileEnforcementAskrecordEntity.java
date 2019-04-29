package com.tengdi.environmentalprotectionint.modules.mobile.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;


/**
 * 案件调查询问笔录
 * 
 * @author tengdi
 * @email 
 * @date 2003-07-25 23:56:39
 */
@TableName("mobile_enforcement_askrecord")
public class MobileEnforcementAskrecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID（UUID）
	 */
	@TableId
	private String pid;
	/**
	 * 对应的污染源（企业）ID
	 */
	private String cid;
	/**
	 * 调查开始时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String investigateStarttime;
	/**
	 * 调查结束时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String investigateEndtime;
	/**
	 * 调查单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String investigateCompany;
	/**
	 * 询问人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String inquirerPersonName;
	/**
	 * 询问人执法证号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String inquirerPersonNumber;
	/**
	 * 被调查单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String investigatedCompanyName;
	/**
	 * 被调查单位(输入域发生变化动态查询数据展示下拉返回需要用)
	 */
	@TableField(exist = false)
	private String companyName;

	/**
	 * 被调查单位编号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String investigatedCompanyCode;
	/**
	 * 被调查单位地址
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String investigatedCompanyAddress;
	/**
	 * 被调查单位法人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String investigatedCompanyLegal;
	/**
	 * 被调查单位法人联系电话
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String investigatedCompanyLegalPhone;
	/**
	 * 被调查询问人姓名
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String investigatedInquirerName;
	/**
	 * 被调查询问人年龄
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String investigatedInquirerAge;
	/**
	 * 被调查询问人身份证号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String investigatedInquirerIdentity;
	/**
	 * 被调查询问人联系电话
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String investigatedInquirerPhone;
	/**
	 * 记录人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String recordPersonName;
	/**
	 * 记录人执法证号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String recordPersonNumber;
	/**
	 * 调查询问内容
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String investigateInquirerContent;
	/**
	 * 创建时间
	 */
	private String createdate;

	/**
	 * 设置：主键ID（UUID）
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：主键ID（UUID）
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
	/**
	 * 获取：对应的污染源（企业）ID
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：调查开始时间
	 */
	public void setInvestigateStarttime(String investigateStarttime) {
		this.investigateStarttime = investigateStarttime;
	}
	/**
	 * 获取：调查开始时间
	 */
	public String getInvestigateStarttime() {
		return investigateStarttime;
	}
	/**
	 * 设置：调查结束时间
	 */
	public void setInvestigateEndtime(String investigateEndtime) {
		this.investigateEndtime = investigateEndtime;
	}
	/**
	 * 获取：调查结束时间
	 */
	public String getInvestigateEndtime() {
		return investigateEndtime;
	}
	/**
	 * 设置：调查单位
	 */
	public void setInvestigateCompany(String investigateCompany) {
		this.investigateCompany = investigateCompany;
	}
	/**
	 * 获取：调查单位
	 */
	public String getInvestigateCompany() {
		return investigateCompany;
	}
	/**
	 * 设置：询问人
	 */
	public void setInquirerPersonName(String inquirerPersonName) {
		this.inquirerPersonName = inquirerPersonName;
	}
	/**
	 * 获取：询问人
	 */
	public String getInquirerPersonName() {
		return inquirerPersonName;
	}
	/**
	 * 设置：询问人执法证号
	 */
	public void setInquirerPersonNumber(String inquirerPersonNumber) {
		this.inquirerPersonNumber = inquirerPersonNumber;
	}
	/**
	 * 获取：询问人执法证号
	 */
	public String getInquirerPersonNumber() {
		return inquirerPersonNumber;
	}
	/**
	 * 设置：被调查单位
	 */
	public void setInvestigatedCompanyName(String investigatedCompanyName) {
		this.investigatedCompanyName = investigatedCompanyName;
	}
	/**
	 * 获取：被调查单位
	 */
	public String getInvestigatedCompanyName() {
		return investigatedCompanyName;
	}

	public String getCompanyName() {
		return investigatedCompanyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 设置：被调查单位编号
	 */
	public void setInvestigatedCompanyCode(String investigatedCompanyCode) {
		this.investigatedCompanyCode = investigatedCompanyCode;
	}
	/**
	 * 获取：被调查单位编号
	 */
	public String getInvestigatedCompanyCode() {
		return investigatedCompanyCode;
	}
	/**
	 * 设置：被调查单位地址
	 */
	public void setInvestigatedCompanyAddress(String investigatedCompanyAddress) {
		this.investigatedCompanyAddress = investigatedCompanyAddress;
	}
	/**
	 * 获取：被调查单位地址
	 */
	public String getInvestigatedCompanyAddress() {
		return investigatedCompanyAddress;
	}
	/**
	 * 设置：被调查单位法人
	 */
	public void setInvestigatedCompanyLegal(String investigatedCompanyLegal) {
		this.investigatedCompanyLegal = investigatedCompanyLegal;
	}
	/**
	 * 获取：被调查单位法人
	 */
	public String getInvestigatedCompanyLegal() {
		return investigatedCompanyLegal;
	}
	/**
	 * 设置：被调查单位法人联系电话
	 */
	public void setInvestigatedCompanyLegalPhone(String investigatedCompanyLegalPhone) {
		this.investigatedCompanyLegalPhone = investigatedCompanyLegalPhone;
	}
	/**
	 * 获取：被调查单位法人联系电话
	 */
	public String getInvestigatedCompanyLegalPhone() {
		return investigatedCompanyLegalPhone;
	}
	/**
	 * 设置：被调查询问人姓名
	 */
	public void setInvestigatedInquirerName(String investigatedInquirerName) {
		this.investigatedInquirerName = investigatedInquirerName;
	}
	/**
	 * 获取：被调查询问人姓名
	 */
	public String getInvestigatedInquirerName() {
		return investigatedInquirerName;
	}
	/**
	 * 设置：被调查询问人年龄
	 */
	public void setInvestigatedInquirerAge(String investigatedInquirerAge) {
		this.investigatedInquirerAge = investigatedInquirerAge;
	}
	/**
	 * 获取：被调查询问人年龄
	 */
	public String getInvestigatedInquirerAge() {
		return investigatedInquirerAge;
	}
	/**
	 * 设置：被调查询问人身份证号
	 */
	public void setInvestigatedInquirerIdentity(String investigatedInquirerIdentity) {
		this.investigatedInquirerIdentity = investigatedInquirerIdentity;
	}
	/**
	 * 获取：被调查询问人身份证号
	 */
	public String getInvestigatedInquirerIdentity() {
		return investigatedInquirerIdentity;
	}
	/**
	 * 设置：被调查询问人联系电话
	 */
	public void setInvestigatedInquirerPhone(String investigatedInquirerPhone) {
		this.investigatedInquirerPhone = investigatedInquirerPhone;
	}
	/**
	 * 获取：被调查询问人联系电话
	 */
	public String getInvestigatedInquirerPhone() {
		return investigatedInquirerPhone;
	}
	/**
	 * 设置：记录人
	 */
	public void setRecordPersonName(String recordPersonName) {
		this.recordPersonName = recordPersonName;
	}
	/**
	 * 获取：记录人
	 */
	public String getRecordPersonName() {
		return recordPersonName;
	}
	/**
	 * 设置：记录人执法证号
	 */
	public void setRecordPersonNumber(String recordPersonNumber) {
		this.recordPersonNumber = recordPersonNumber;
	}
	/**
	 * 获取：记录人执法证号
	 */
	public String getRecordPersonNumber() {
		return recordPersonNumber;
	}
	/**
	 * 设置：调查询问内容
	 */
	public void setInvestigateInquirerContent(String investigateInquirerContent) {
		this.investigateInquirerContent = investigateInquirerContent;
	}
	/**
	 * 获取：调查询问内容
	 */
	public String getInvestigateInquirerContent() {
		return investigateInquirerContent;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreatedate() {
		return createdate;
	}
}
