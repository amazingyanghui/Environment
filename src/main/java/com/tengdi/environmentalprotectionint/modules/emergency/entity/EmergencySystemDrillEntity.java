package com.tengdi.environmentalprotectionint.modules.emergency.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 应急演练
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:16:54
 */
@TableName("emergency_system_drill")
public class EmergencySystemDrillEntity implements Serializable {
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
	 * 单位名称
	 */
	@TableField(exist = false)
	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 演练标题
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String drillTitle;
	/**
	 * 演练地点
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String drillPoint;
	/**
	 * 演练日期
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String drillDate;
	/**
	 * 演练情况
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String drillSituation;
	/**
	 * 演练文档
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String drillDocument;
	/**
	 * 演练单位（企业）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String drillCompany;
	/**
	 * 创建时间
	 */
	private Date createdate;
	/**
	 * 演练类型
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String drillType ;
	/**
	 * 演练类型name
	 */
	@TableField(exist = false)
	private String drillTypeName;

	public String getDrillTypeName() {
		return drillTypeName;
	}

	public void setDrillTypeName(String drillTypeName) {
		this.drillTypeName = drillTypeName;
	}

	/**
	 * 发布时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private  String publishDate ;
	/**
	 * 预案评估
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String planEvaluation;


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
	/**
	 * 获取：对应的污染源（企业）ID
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：演练标题
	 */
	public void setDrillTitle(String drillTitle) {
		this.drillTitle = drillTitle;
	}
	/**
	 * 获取：演练标题
	 */
	public String getDrillTitle() {
		return drillTitle;
	}
	/**
	 * 设置：演练地点
	 */
	public void setDrillPoint(String drillPoint) {
		this.drillPoint = drillPoint;
	}
	/**
	 * 获取：演练地点
	 */
	public String getDrillPoint() {
		return drillPoint;
	}
	/**
	 * 设置：演练日期
	 */
	public void setDrillDate(String drillDate) {
		this.drillDate = drillDate;
	}
	/**
	 * 获取：演练日期
	 */
	public String getDrillDate() {
		return drillDate;
	}
	/**
	 * 设置：演练情况
	 */
	public void setDrillSituation(String drillSituation) {
		this.drillSituation = drillSituation;
	}
	/**
	 * 获取：演练情况
	 */
	public String getDrillSituation() {
		return drillSituation;
	}
	/**
	 * 设置：演练文档
	 */
	public void setDrillDocument(String drillDocument) {
		this.drillDocument = drillDocument;
	}
	/**
	 * 获取：演练文档
	 */
	public String getDrillDocument() {
		return drillDocument;
	}
	/**
	 * 设置：演练单位（企业）
	 */
	public void setDrillCompany(String drillCompany) {
		this.drillCompany = drillCompany;
	}
	/**
	 * 获取：演练单位（企业）
	 */
	public String getDrillCompany() {
		return drillCompany;
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
	/**
	 * 发布时间
	 * @return
	 */

	public Date getCreatedate() {
		return createdate;
	}

	public String getDrillType() {
		return drillType;
	}

	public void setDrillType(String drillType) {
		this.drillType = drillType;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	/**
	 * 设置：预案评估
	 */
	public void setPlanEvaluation(String planEvaluation) {
		this.planEvaluation = planEvaluation;
	}
	/**
	 * 获取：预案评估
	 */
	public String getPlanEvaluation() {
		return planEvaluation;
	}

}
