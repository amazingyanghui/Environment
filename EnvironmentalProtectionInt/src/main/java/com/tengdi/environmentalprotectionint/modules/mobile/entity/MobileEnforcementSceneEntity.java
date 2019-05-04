package com.tengdi.environmentalprotectionint.modules.mobile.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.tengdi.environmentalprotectionint.modules.common.utils.Utils;
import com.tengdi.environmentalprotectionint.modules.task.entity.CheckRecord;

import java.io.Serializable;
import java.util.Date;

/**
 * 移动执法现场执法
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-23 11:57:35
 */
@TableName("mobile_enforcement_scene")
public class MobileEnforcementSceneEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID（UUID）
	 */
	@TableId
	private String pid;
	/**
	 * 对应的企业（污染源）ID
	 */
	private String cid;
	/**
	 * 单位名称
	 */
	@TableField(exist = false)
	private String companyName;
	/**
	 * 单位地址
	 */
	@TableField(exist = false)
	private String companyAddress;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
	 * 检查开始时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String checkStarttime;
	/**
	 * 检查结束时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String checkEndtime;
	/**
	 * 检查单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String checkCompany;
	/**
	 * 检查人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String checkPersonName;
	/**
	 * 检查人执法证号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String checkPersonNumber;
	/**
	 * 被检查单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String checkedCompanyName;
	/**
	 * 被检查单位编号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String checkedCompanyCode;
	/**
	 * 被检查单位地址
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String checkedCompanyAddress;
	/**
	 * 被检查单位法人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String checkedCompanyLegal;
	/**
	 * 公司法人
	 */
	@TableField(exist = false)
	private String companyRepresentative;
	/**
	 * 被检查单位法人联系电话
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String checkedCompanyLegalPhone;
	/**
	 * 公司法人代表电话
	 */
	@TableField(exist = false)
	private String representativePhone;

	/**
	 * 统一社会信用代码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String unifiedSocialCreditCode;

	public String getUnifiedSocialCreditCode() {
		return unifiedSocialCreditCode;
	}

	public void setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
		this.unifiedSocialCreditCode = unifiedSocialCreditCode;
	}

	/**
	 * 所属区县（数据字典）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String districtAndCounty;

	public String getDistrictAndCounty() {
		return districtAndCounty;
	}

	public void setDistrictAndCounty(String districtAndCounty) {
		this.districtAndCounty = districtAndCounty;
	}

	/**
	 * 所属行业IDS
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String industryids;

	public String getIndustryids() {
		return industryids;
	}

	public void setIndustryids(String industryids) {
		this.industryids = industryids;
	}
	/**
	 * 检查目的
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String checkpurpose;

	public String getCheckpurpose() {
		return checkpurpose;
	}

	public void setCheckpurpose(String checkpurpose) {
		this.checkpurpose = checkpurpose;
	}

	/**
	 * 生产状态
	 */
	@TableField(exist = false)
	private String productionstate;

	public String getProductionstate() {
		return productionstate;
	}

	public void setProductionstate(String productionstate) {
		this.productionstate = productionstate;
	}

	public String getCompanyRepresentative() {
		return companyRepresentative;
	}

	public void setCompanyRepresentative(String companyRepresentative) {
		this.companyRepresentative = companyRepresentative;
	}

	public String getRepresentativePhone() {
		return representativePhone;
	}

	public void setRepresentativePhone(String representativePhone) {
		this.representativePhone = representativePhone;
	}

	/**
	 * 被检查单位现场负责人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String checkedCompanyLeader;
	/**
	 * 负责人联系电话
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String checkedCompanyLeaderPhone;
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
	 * 执法类型
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String lawEnforcementType;
	/**
	 * 执法类型name
	 */
	@TableField(exist = false)
	private String lawEnforcementTypeName;

	public String getLawEnforcementTypeName() {
		return lawEnforcementTypeName;
	}

	public void setLawEnforcementTypeName(String lawEnforcementTypeName) {
		this.lawEnforcementTypeName = lawEnforcementTypeName;
	}

	/**
	 * 现场情况
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String fieldSituation;
	/**
	 * 监测意见
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String monitoringOpinion;
	/**
	 * 检查结果
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String examinationResults;
	/**
	 * 检查结果name
	 */
	@TableField(exist = false)
	private String examinationResultsName;

	/**
	 * 办理人
	 */
	@TableField(exist = false)
	private String taskmanager;
	/**
	 * 任务名
	 */
	@TableField(exist = false)
	private String taskname;
	/**
	 * 任务描述
	 */
	@TableField(exist = false)
	private String taskdescription;
	/**
	 * 办理意见
	 */
	@TableField(exist = false)
	private String handlingopinions;

	private CheckRecord record;
	private MobileEnforcementAttachmentEntity attachmentEntity;

	public CheckRecord getRecord() {
		return record;
	}

	public void setRecord(CheckRecord record) {
		this.record = record;
	}

	public MobileEnforcementAttachmentEntity getAttachmentEntity() {
		return attachmentEntity;
	}

	public void setAttachmentEntity(MobileEnforcementAttachmentEntity attachmentEntity) {
		this.attachmentEntity = attachmentEntity;
	}

	public String getTaskmanager() {
		return taskmanager;
	}

	public void setTaskmanager(String taskmanager) {
		this.taskmanager = taskmanager;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getTaskdescription() {
		return taskdescription;
	}

	public void setTaskdescription(String taskdescription) {
		this.taskdescription = taskdescription;
	}

	public String getHandlingopinions() {
		return handlingopinions;
	}

	public void setHandlingopinions(String handlingopinions) {
		this.handlingopinions = handlingopinions;
	}

	public String getExaminationResultsName() {
		return examinationResultsName;
	}

	public void setExaminationResultsName(String examinationResultsName) {
		this.examinationResultsName = examinationResultsName;
	}

	/**
	 * 结果类型
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer resultType;
	/**
	 * 结果类型
	 */
	@TableField(exist=false)
	private String resultTypeStr;

	/**
	 * 创建时间
	 */
	private Date createdate;
	/**
	 * 创建时间
	 */
	@TableField(exist=false)
	private String createdateStr;

	/**
	 *数量（统计图表用）
	 */
	@TableField(exist=false)
	private Integer number;
	/**
	 *总数（统计图表用）
	 */
	@TableField(exist=false)
	private Integer sumNumber;
	/**
	 *月份（统计图表用）
	 */
	@TableField(exist=false)
	private Integer monthStr;

	public String getResultTypeStr() {
		return resultTypeStr;
	}

	public void setResultTypeStr(String resultTypeStr) {
		this.resultTypeStr = resultTypeStr;
	}

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
	 * 设置：对应的企业（污染源）ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：对应的企业（污染源）ID
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：检查开始时间
	 */
	public void setCheckStarttime(String checkStarttime) {
		this.checkStarttime = checkStarttime;
	}
	/**
	 * 获取：检查开始时间
	 */
	public String getCheckStarttime() {
		return Utils.subStringDate(checkStarttime);
	}
	/**
	 * 设置：检查结束时间
	 */
	public void setCheckEndtime(String checkEndtime) {
		this.checkEndtime = checkEndtime;
	}
	/**
	 * 获取：检查结束时间
	 */
	public String getCheckEndtime() {
		return Utils.subStringDate(checkEndtime);
	}
	/**
	 * 设置：检查单位
	 */
	public void setCheckCompany(String checkCompany) {
		this.checkCompany = checkCompany;
	}
	/**
	 * 获取：检查单位
	 */
	public String getCheckCompany() {
		return checkCompany;
	}
	/**
	 * 设置：检查人
	 */
	public void setCheckPersonName(String checkPersonName) {
		this.checkPersonName = checkPersonName;
	}
	/**
	 * 获取：检查人
	 */
	public String getCheckPersonName() {
		return checkPersonName;
	}
	/**
	 * 设置：检查人执法证号
	 */
	public void setCheckPersonNumber(String checkPersonNumber) {
		this.checkPersonNumber = checkPersonNumber;
	}
	/**
	 * 获取：检查人执法证号
	 */
	public String getCheckPersonNumber() {
		return checkPersonNumber;
	}
	/**
	 * 设置：被检查单位
	 */
	public void setCheckedCompanyName(String checkedCompanyName) {
		this.checkedCompanyName = checkedCompanyName;
	}
	/**
	 * 获取：被检查单位
	 */
	public String getCheckedCompanyName() {
		return checkedCompanyName;
	}
	/**
	 * 设置：被检查单位编号
	 */
	public void setCheckedCompanyCode(String checkedCompanyCode) {
		this.checkedCompanyCode = checkedCompanyCode;
	}
	/**
	 * 获取：被检查单位编号
	 */
	public String getCheckedCompanyCode() {
		return checkedCompanyCode;
	}
	/**
	 * 设置：被检查单位地址
	 */
	public void setCheckedCompanyAddress(String checkedCompanyAddress) {
		this.checkedCompanyAddress = checkedCompanyAddress;
	}
	/**
	 * 获取：被检查单位地址
	 */
	public String getCheckedCompanyAddress() {
		return checkedCompanyAddress;
	}
	/**
	 * 设置：被检查单位法人
	 */
	public void setCheckedCompanyLegal(String checkedCompanyLegal) {
		this.checkedCompanyLegal = checkedCompanyLegal;
	}
	/**
	 * 获取：被检查单位法人
	 */
	public String getCheckedCompanyLegal() {
		return checkedCompanyLegal;
	}
	/**
	 * 设置：被检查单位法人联系电话
	 */
	public void setCheckedCompanyLegalPhone(String checkedCompanyLegalPhone) {
		this.checkedCompanyLegalPhone = checkedCompanyLegalPhone;
	}
	/**
	 * 获取：被检查单位法人联系电话
	 */
	public String getCheckedCompanyLegalPhone() {
		return checkedCompanyLegalPhone;
	}
	/**
	 * 设置：被检查单位现场负责人
	 */
	public void setCheckedCompanyLeader(String checkedCompanyLeader) {
		this.checkedCompanyLeader = checkedCompanyLeader;
	}
	/**
	 * 获取：被检查单位现场负责人
	 */
	public String getCheckedCompanyLeader() {
		return checkedCompanyLeader;
	}
	/**
	 * 设置：负责人联系电话
	 */
	public void setCheckedCompanyLeaderPhone(String checkedCompanyLeaderPhone) {
		this.checkedCompanyLeaderPhone = checkedCompanyLeaderPhone;
	}
	/**
	 * 获取：负责人联系电话
	 */
	public String getCheckedCompanyLeaderPhone() {
		return checkedCompanyLeaderPhone;
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
	 * 设置：执法类型
	 */
	public void setLawEnforcementType(String lawEnforcementType) {
		this.lawEnforcementType = lawEnforcementType;
	}
	/**
	 * 获取：执法类型
	 */
	public String getLawEnforcementType() {
		return lawEnforcementType;
	}
	/**
	 * 设置：现场情况
	 */
	public void setFieldSituation(String fieldSituation) {
		this.fieldSituation = fieldSituation;
	}
	/**
	 * 获取：现场情况
	 */
	public String getFieldSituation() {
		return fieldSituation;
	}
	/**
	 * 设置：监测意见
	 */
	public void setMonitoringOpinion(String monitoringOpinion) {
		this.monitoringOpinion = monitoringOpinion;
	}
	/**
	 * 获取：监测意见
	 */
	public String getMonitoringOpinion() {
		return monitoringOpinion;
	}
	/**
	 * 设置：检查结果
	 */
	public void setExaminationResults(String examinationResults) {
		this.examinationResults = examinationResults;
	}
	/**
	 * 获取：检查结果
	 */
	public String getExaminationResults() {
		return examinationResults;
	}
	/**
	 * 设置：结果类型
	 */
	public void setResultType(Integer resultType) {
		this.resultType = resultType;
	}
	/**
	 * 获取：结果类型
	 */
	public Integer getResultType() {
		return resultType;
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

	public String getCreatedateStr() {
		return createdateStr;
	}

	public void setCreatedateStr(String createdateStr) {
		this.createdateStr = createdateStr;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getSumNumber() {
		return sumNumber;
	}

	public void setSumNumber(Integer sumNumber) {
		this.sumNumber = sumNumber;
	}

	public Integer getMonthStr() {
		return monthStr;
	}

	public void setMonthStr(Integer monthStr) {
		this.monthStr = monthStr;
	}
}
