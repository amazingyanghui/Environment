package com.tengdi.environmentalprotectionint.modules.building.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目建设审批情况
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-22 10:03:40
 */
@TableName("building_project_approval")
public class BuildingProjectApprovalEntity implements Serializable {
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
	 * 公司名称name
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
	 * 项目名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String projectName;
	/**
	 * 项目地址
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String projectAddress;
	/**
	 * 文件类型
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer fileType;
	/**
	 * 文件类型name
	 */
	@TableField(exist = false)
	private String fileTypeName;

	public String getFileTypeName() {
		return fileTypeName;
	}

	public void setFileTypeName(String fileTypeName) {
		this.fileTypeName = fileTypeName;
	}

	/**
	 * 项目总投资(万元)
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Double totalInvestment;
	/**
	 * 项目环保投资(万元)
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Double environmentalProtectionInvestment;
	/**
	 * 建设单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String constructionUnit;
	/**
	 * 环评单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String eiaUnit;
	/**
	 * 环评审批机关
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String eiaApprovalAuthority;
	/**
	 * 受理时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String admissibilityTime;
	/**
	 * 审批单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String approvalUnit;
	/**
	 * 审批单位name
	 */
	@TableField(exist = false)
	private String approvalUnitName;

	public String getApprovalUnitName() {
		return approvalUnitName;
	}

	public void setApprovalUnitName(String approvalUnitName) {
		this.approvalUnitName = approvalUnitName;
	}

	/**
	 * 批复时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String batchTime;
	/**
	 * 验收申请时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String acceptanceRequestTime;
	/**
	 * 验收批复时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String acceptanceBatchTime;
	/**
	 * 创建时间
	 */
	private Date createdate;



	/**
	 * 项目性质 0,1  0:新建 1:扩建
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer projectNature;
	/**
	 * 项目性质name
	 */
	@TableField(exist = false)
	private String projectNatureName;

	public String getProjectNatureName() {
		return projectNatureName;
	}

	public void setProjectNatureName(String projectNatureName) {
		this.projectNatureName = projectNatureName;
	}

	/**
	 * 对应的污染源（企业）ID  名称
	 */
	@TableField(exist = false)
	private String cidName;

	/**
	 * 建设内容
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String constructionContent;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	/**
	 *联系人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String linkman;
	/**
	 *联系电话
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String	phone;
	/**
	 *法人代表
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String representative;
	/**
	 *法人电话
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String legalPersonPhone;
	/**
	 *项目类别
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String projectType;
	/**
	 *审批意见
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String	approvalOpinion;
	/**
	 *审批文号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String approvalNumbe;
	/**
	 *经办人员
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String	operator;
	/**
	 *环评意见
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String environmentalAssessmentOpinion;
	/**
	 *验收意见
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String	acceptanceOpinion;
	/**
	 *后评价
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String postAssessment;
	/**
	 *环评补充意见加
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String	environmentalAssessmentAddopinion;


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
	 * 设置：项目名称
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 设置：项目地址
	 */
	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}
	/**
	 * 获取：项目地址
	 */
	public String getProjectAddress() {
		return projectAddress;
	}
	/**
	 * 设置：文件类型
	 */
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}
	/**
	 * 获取：文件类型
	 */
	public Integer getFileType() {
		return fileType;
	}
	/**
	 * 设置：项目总投资(万元)
	 */
	public void setTotalInvestment(Double totalInvestment) {
		this.totalInvestment = totalInvestment;
	}
	/**
	 * 获取：项目总投资(万元)
	 */
	public Double getTotalInvestment() {
		return totalInvestment;
	}
	/**
	 * 设置：项目环保投资(万元)
	 */
	public void setEnvironmentalProtectionInvestment(Double environmentalProtectionInvestment) {
		this.environmentalProtectionInvestment = environmentalProtectionInvestment;
	}
	/**
	 * 获取：项目环保投资(万元)
	 */
	public Double getEnvironmentalProtectionInvestment() {
		return environmentalProtectionInvestment;
	}
	/**
	 * 设置：建设单位
	 */
	public void setConstructionUnit(String constructionUnit) {
		this.constructionUnit = constructionUnit;
	}
	/**
	 * 获取：建设单位
	 */
	public String getConstructionUnit() {
		return constructionUnit;
	}
	/**
	 * 设置：环评单位
	 */
	public void setEiaUnit(String eiaUnit) {
		this.eiaUnit = eiaUnit;
	}
	/**
	 * 获取：环评单位
	 */
	public String getEiaUnit() {
		return eiaUnit;
	}
	/**
	 * 设置：环评审批机关
	 */
	public void setEiaApprovalAuthority(String eiaApprovalAuthority) {
		this.eiaApprovalAuthority = eiaApprovalAuthority;
	}
	/**
	 * 获取：环评审批机关
	 */
	public String getEiaApprovalAuthority() {
		return eiaApprovalAuthority;
	}
	/**
	 * 设置：受理时间
	 */
	public void setAdmissibilityTime(String admissibilityTime) {
		this.admissibilityTime = admissibilityTime;
	}
	/**
	 * 获取：受理时间
	 */
	public String getAdmissibilityTime() {
		return admissibilityTime;
	}
	/**
	 * 设置：审批单位
	 */
	public void setApprovalUnit(String approvalUnit) {
		this.approvalUnit = approvalUnit;
	}
	/**
	 * 获取：审批单位
	 */
	public String getApprovalUnit() {
		return approvalUnit;
	}
	/**
	 * 设置：批复时间
	 */
	public void setBatchTime(String batchTime) {
		this.batchTime = batchTime;
	}
	/**
	 * 获取：批复时间
	 */
	public String getBatchTime() {
		return batchTime;
	}
	/**
	 * 设置：验收申请时间
	 */
	public void setAcceptanceRequestTime(String acceptanceRequestTime) {
		this.acceptanceRequestTime = acceptanceRequestTime;
	}
	/**
	 * 获取：验收申请时间
	 */
	public String getAcceptanceRequestTime() {
		return acceptanceRequestTime;
	}
	/**
	 * 设置：验收批复时间
	 */
	public void setAcceptanceBatchTime(String acceptanceBatchTime) {
		this.acceptanceBatchTime = acceptanceBatchTime;
	}
	/**
	 * 获取：验收批复时间
	 */
	public String getAcceptanceBatchTime() {
		return acceptanceBatchTime;
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

	public String getConstructionContent() {
		return constructionContent;
	}

	public void setConstructionContent(String constructionContent) {
		this.constructionContent = constructionContent;
	}

	public String getCidName() {
		return cidName;
	}

	public void setCidName(String cidName) {
		this.cidName = cidName;
	}

	public Integer getProjectNature() {
		return projectNature;
	}

	public void setProjectNature(Integer projectNature) {
		this.projectNature = projectNature;
	}


	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRepresentative() {
		return representative;
	}

	public void setRepresentative(String representative) {
		this.representative = representative;
	}

	public String getLegalPersonPhone() {
		return legalPersonPhone;
	}

	public void setLegalPersonPhone(String legalPersonPhone) {
		this.legalPersonPhone = legalPersonPhone;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getApprovalOpinion() {
		return approvalOpinion;
	}

	public void setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion = approvalOpinion;
	}

	public String getApprovalNumbe() {
		return approvalNumbe;
	}

	public void setApprovalNumbe(String approvalNumbe) {
		this.approvalNumbe = approvalNumbe;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getEnvironmentalAssessmentOpinion() {
		return environmentalAssessmentOpinion;
	}

	public void setEnvironmentalAssessmentOpinion(String environmentalAssessmentOpinion) {
		this.environmentalAssessmentOpinion = environmentalAssessmentOpinion;
	}

	public String getAcceptanceOpinion() {
		return acceptanceOpinion;
	}

	public void setAcceptanceOpinion(String acceptanceOpinion) {
		this.acceptanceOpinion = acceptanceOpinion;
	}

	public String getPostAssessment() {
		return postAssessment;
	}

	public void setPostAssessment(String postAssessment) {
		this.postAssessment = postAssessment;
	}

	public String getEnvironmentalAssessmentAddopinion() {
		return environmentalAssessmentAddopinion;
	}

	public void setEnvironmentalAssessmentAddopinion(String environmentalAssessmentAddopinion) {
		this.environmentalAssessmentAddopinion = environmentalAssessmentAddopinion;
	}
}
