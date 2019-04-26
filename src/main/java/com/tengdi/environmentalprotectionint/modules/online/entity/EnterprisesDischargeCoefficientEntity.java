package com.tengdi.environmentalprotectionint.modules.online.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
/**
 * 工业企业污染物产排污系数核算信息
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-08 14:08:30
 */
@TableName("enterprises_discharge_coefficient")
public class EnterprisesDischargeCoefficientEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键（UUID）
	 */
	@TableId
	private String pid;
	/**
	 * 企业ID
	 */
	private String cid;
	/**
	 * 年度
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String year;
	/**
	 * 对应的普查表号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String censusCode;
	/**
	 * 对应的排放口编号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String mid;
	/**
	 * 对应的排放口名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String monitorName;
	/**
	 * 核算环节名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String accountingLink;
	/**
	 * 原料名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String materialName;
	/**
	 * 产品名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String productName;
	/**
	 * 工艺名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String processName;
	/**
	 * 生产规模等级
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String productionGrade;
	/**
	 * 产品产量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String productOutput;
	/**
	 * 产品产量的计量单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String productOutputUnit;
	/**
	 * 原料/燃料用量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String rawMaterialConsumption;
	/**
	 * 原料/燃料用量的计量单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String rawMaterialConsumptionUnit;
	/**
	 * 污染物名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pollutantName;
	/**
	 * 污染物产污系数
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pollutantsCoefficient;
	/**
	 * 污染物计量单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pollutantUnit;
	/**
	 * 污染物产污系数中参数取值
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pollutantsCoefficientParamValue;
	/**
	 * 污染物产生量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pollutantProduction;
	/**
	 * 污染物产生量计量单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pollutantProductionUnit;
	/**
	 * 污染物处理工艺名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pollutantTreatmentProcess;
	/**
	 * 污染物去除效率/排污系数
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pollutantsRemovalEfficiency;
	/**
	 * 污染物去除效率/排污系数计量单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pollutantsRemovalEfficiencyUnit;
	/**
	 * 污染治理设施实际运行参数一名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String actualOperatingParametersName1;
	/**
	 * 污染治理设施实际运行参数一数值
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String actualOperatingParametersValue1;
	/**
	 * 污染治理设施实际运行参数一计量单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String actualOperatingParametersUnit1;
	/**
	 * 污染治理设施实际运行参数二名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String actualOperatingParametersName2;
	/**
	 * 污染治理设施实际运行参数二数值
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String actualOperatingParametersValue2;
	/**
	 * 污染治理设施实际运行参数二计量单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String actualOperatingParametersUnit2;
	/**
	 * 污染治理设施实际运行参数三名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String actualOperatingParametersName3;
	/**
	 * 污染治理设施实际运行参数三数值
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String actualOperatingParametersValue3;
	/**
	 * 污染治理设施实际运行参数三计量单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String actualOperatingParametersUnit3;
	/**
	 * 污染物排放量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pollutantDischargeCounts;
	/**
	 * 污染物排放量计量单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pollutantDischargeCountsUnit;
	/**
	 * 排污许可证执行报告排放量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String permitExecutionReporCounts;
	/**
	 * 备注
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String remarks;
	/**
	 * 创建时间
	 */
	private String createdate;
	/**
	 * 更新时间
	 */
	private String updatedate;
	/**
	 * 删除时间
	 */
	private String deletedate;

	/**
	 * 设置：主键（UUID）
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：主键（UUID）
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：企业ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：企业ID
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：年度
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 获取：年度
	 */
	public String getYear() {
		return year;
	}
	/**
	 * 设置：对应的普查表号
	 */
	public void setCensusCode(String censusCode) {
		this.censusCode = censusCode;
	}
	/**
	 * 获取：对应的普查表号
	 */
	public String getCensusCode() {
		return censusCode;
	}
	/**
	 * 设置：对应的排放口编号
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}
	/**
	 * 获取：对应的排放口编号
	 */
	public String getMid() {
		return mid;
	}
	/**
	 * 设置：对应的排放口名称
	 */
	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}
	/**
	 * 获取：对应的排放口名称
	 */
	public String getMonitorName() {
		return monitorName;
	}
	/**
	 * 设置：核算环节名称
	 */
	public void setAccountingLink(String accountingLink) {
		this.accountingLink = accountingLink;
	}
	/**
	 * 获取：核算环节名称
	 */
	public String getAccountingLink() {
		return accountingLink;
	}
	/**
	 * 设置：原料名称
	 */
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	/**
	 * 获取：原料名称
	 */
	public String getMaterialName() {
		return materialName;
	}
	/**
	 * 设置：产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 获取：产品名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 设置：工艺名称
	 */
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	/**
	 * 获取：工艺名称
	 */
	public String getProcessName() {
		return processName;
	}
	/**
	 * 设置：生产规模等级
	 */
	public void setProductionGrade(String productionGrade) {
		this.productionGrade = productionGrade;
	}
	/**
	 * 获取：生产规模等级
	 */
	public String getProductionGrade() {
		return productionGrade;
	}
	/**
	 * 设置：产品产量
	 */
	public void setProductOutput(String productOutput) {
		this.productOutput = productOutput;
	}
	/**
	 * 获取：产品产量
	 */
	public String getProductOutput() {
		return productOutput;
	}
	/**
	 * 设置：产品产量的计量单位
	 */
	public void setProductOutputUnit(String productOutputUnit) {
		this.productOutputUnit = productOutputUnit;
	}
	/**
	 * 获取：产品产量的计量单位
	 */
	public String getProductOutputUnit() {
		return productOutputUnit;
	}
	/**
	 * 设置：原料/燃料用量
	 */
	public void setRawMaterialConsumption(String rawMaterialConsumption) {
		this.rawMaterialConsumption = rawMaterialConsumption;
	}
	/**
	 * 获取：原料/燃料用量
	 */
	public String getRawMaterialConsumption() {
		return rawMaterialConsumption;
	}
	/**
	 * 设置：原料/燃料用量的计量单位
	 */
	public void setRawMaterialConsumptionUnit(String rawMaterialConsumptionUnit) {
		this.rawMaterialConsumptionUnit = rawMaterialConsumptionUnit;
	}
	/**
	 * 获取：原料/燃料用量的计量单位
	 */
	public String getRawMaterialConsumptionUnit() {
		return rawMaterialConsumptionUnit;
	}
	/**
	 * 设置：污染物名称
	 */
	public void setPollutantName(String pollutantName) {
		this.pollutantName = pollutantName;
	}
	/**
	 * 获取：污染物名称
	 */
	public String getPollutantName() {
		return pollutantName;
	}
	/**
	 * 设置：污染物产污系数
	 */
	public void setPollutantsCoefficient(String pollutantsCoefficient) {
		this.pollutantsCoefficient = pollutantsCoefficient;
	}
	/**
	 * 获取：污染物产污系数
	 */
	public String getPollutantsCoefficient() {
		return pollutantsCoefficient;
	}
	/**
	 * 设置：污染物计量单位
	 */
	public void setPollutantUnit(String pollutantUnit) {
		this.pollutantUnit = pollutantUnit;
	}
	/**
	 * 获取：污染物计量单位
	 */
	public String getPollutantUnit() {
		return pollutantUnit;
	}
	/**
	 * 设置：污染物产污系数中参数取值
	 */
	public void setPollutantsCoefficientParamValue(String pollutantsCoefficientParamValue) {
		this.pollutantsCoefficientParamValue = pollutantsCoefficientParamValue;
	}
	/**
	 * 获取：污染物产污系数中参数取值
	 */
	public String getPollutantsCoefficientParamValue() {
		return pollutantsCoefficientParamValue;
	}
	/**
	 * 设置：污染物产生量
	 */
	public void setPollutantProduction(String pollutantProduction) {
		this.pollutantProduction = pollutantProduction;
	}
	/**
	 * 获取：污染物产生量
	 */
	public String getPollutantProduction() {
		return pollutantProduction;
	}
	/**
	 * 设置：污染物产生量计量单位
	 */
	public void setPollutantProductionUnit(String pollutantProductionUnit) {
		this.pollutantProductionUnit = pollutantProductionUnit;
	}
	/**
	 * 获取：污染物产生量计量单位
	 */
	public String getPollutantProductionUnit() {
		return pollutantProductionUnit;
	}
	/**
	 * 设置：污染物处理工艺名称
	 */
	public void setPollutantTreatmentProcess(String pollutantTreatmentProcess) {
		this.pollutantTreatmentProcess = pollutantTreatmentProcess;
	}
	/**
	 * 获取：污染物处理工艺名称
	 */
	public String getPollutantTreatmentProcess() {
		return pollutantTreatmentProcess;
	}
	/**
	 * 设置：污染物去除效率/排污系数
	 */
	public void setPollutantsRemovalEfficiency(String pollutantsRemovalEfficiency) {
		this.pollutantsRemovalEfficiency = pollutantsRemovalEfficiency;
	}
	/**
	 * 获取：污染物去除效率/排污系数
	 */
	public String getPollutantsRemovalEfficiency() {
		return pollutantsRemovalEfficiency;
	}
	/**
	 * 设置：污染物去除效率/排污系数计量单位
	 */
	public void setPollutantsRemovalEfficiencyUnit(String pollutantsRemovalEfficiencyUnit) {
		this.pollutantsRemovalEfficiencyUnit = pollutantsRemovalEfficiencyUnit;
	}
	/**
	 * 获取：污染物去除效率/排污系数计量单位
	 */
	public String getPollutantsRemovalEfficiencyUnit() {
		return pollutantsRemovalEfficiencyUnit;
	}
	/**
	 * 设置：污染治理设施实际运行参数一名称
	 */
	public void setActualOperatingParametersName1(String actualOperatingParametersName1) {
		this.actualOperatingParametersName1 = actualOperatingParametersName1;
	}
	/**
	 * 获取：污染治理设施实际运行参数一名称
	 */
	public String getActualOperatingParametersName1() {
		return actualOperatingParametersName1;
	}
	/**
	 * 设置：污染治理设施实际运行参数一数值
	 */
	public void setActualOperatingParametersValue1(String actualOperatingParametersValue1) {
		this.actualOperatingParametersValue1 = actualOperatingParametersValue1;
	}
	/**
	 * 获取：污染治理设施实际运行参数一数值
	 */
	public String getActualOperatingParametersValue1() {
		return actualOperatingParametersValue1;
	}
	/**
	 * 设置：污染治理设施实际运行参数一计量单位
	 */
	public void setActualOperatingParametersUnit1(String actualOperatingParametersUnit1) {
		this.actualOperatingParametersUnit1 = actualOperatingParametersUnit1;
	}
	/**
	 * 获取：污染治理设施实际运行参数一计量单位
	 */
	public String getActualOperatingParametersUnit1() {
		return actualOperatingParametersUnit1;
	}
	/**
	 * 设置：污染治理设施实际运行参数二名称
	 */
	public void setActualOperatingParametersName2(String actualOperatingParametersName2) {
		this.actualOperatingParametersName2 = actualOperatingParametersName2;
	}
	/**
	 * 获取：污染治理设施实际运行参数二名称
	 */
	public String getActualOperatingParametersName2() {
		return actualOperatingParametersName2;
	}
	/**
	 * 设置：污染治理设施实际运行参数二数值
	 */
	public void setActualOperatingParametersValue2(String actualOperatingParametersValue2) {
		this.actualOperatingParametersValue2 = actualOperatingParametersValue2;
	}
	/**
	 * 获取：污染治理设施实际运行参数二数值
	 */
	public String getActualOperatingParametersValue2() {
		return actualOperatingParametersValue2;
	}
	/**
	 * 设置：污染治理设施实际运行参数二计量单位
	 */
	public void setActualOperatingParametersUnit2(String actualOperatingParametersUnit2) {
		this.actualOperatingParametersUnit2 = actualOperatingParametersUnit2;
	}
	/**
	 * 获取：污染治理设施实际运行参数二计量单位
	 */
	public String getActualOperatingParametersUnit2() {
		return actualOperatingParametersUnit2;
	}
	/**
	 * 设置：污染治理设施实际运行参数三名称
	 */
	public void setActualOperatingParametersName3(String actualOperatingParametersName3) {
		this.actualOperatingParametersName3 = actualOperatingParametersName3;
	}
	/**
	 * 获取：污染治理设施实际运行参数三名称
	 */
	public String getActualOperatingParametersName3() {
		return actualOperatingParametersName3;
	}
	/**
	 * 设置：污染治理设施实际运行参数三数值
	 */
	public void setActualOperatingParametersValue3(String actualOperatingParametersValue3) {
		this.actualOperatingParametersValue3 = actualOperatingParametersValue3;
	}
	/**
	 * 获取：污染治理设施实际运行参数三数值
	 */
	public String getActualOperatingParametersValue3() {
		return actualOperatingParametersValue3;
	}
	/**
	 * 设置：污染治理设施实际运行参数三计量单位
	 */
	public void setActualOperatingParametersUnit3(String actualOperatingParametersUnit3) {
		this.actualOperatingParametersUnit3 = actualOperatingParametersUnit3;
	}
	/**
	 * 获取：污染治理设施实际运行参数三计量单位
	 */
	public String getActualOperatingParametersUnit3() {
		return actualOperatingParametersUnit3;
	}
	/**
	 * 设置：污染物排放量
	 */
	public void setPollutantDischargeCounts(String pollutantDischargeCounts) {
		this.pollutantDischargeCounts = pollutantDischargeCounts;
	}
	/**
	 * 获取：污染物排放量
	 */
	public String getPollutantDischargeCounts() {
		return pollutantDischargeCounts;
	}
	/**
	 * 设置：污染物排放量计量单位
	 */
	public void setPollutantDischargeCountsUnit(String pollutantDischargeCountsUnit) {
		this.pollutantDischargeCountsUnit = pollutantDischargeCountsUnit;
	}
	/**
	 * 获取：污染物排放量计量单位
	 */
	public String getPollutantDischargeCountsUnit() {
		return pollutantDischargeCountsUnit;
	}
	/**
	 * 设置：排污许可证执行报告排放量
	 */
	public void setPermitExecutionReporCounts(String permitExecutionReporCounts) {
		this.permitExecutionReporCounts = permitExecutionReporCounts;
	}
	/**
	 * 获取：排污许可证执行报告排放量
	 */
	public String getPermitExecutionReporCounts() {
		return permitExecutionReporCounts;
	}
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注
	 */
	public String getRemarks() {
		return remarks;
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
	/**
	 * 设置：更新时间
	 */
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：更新时间
	 */
	public String getUpdatedate() {
		return updatedate;
	}
	/**
	 * 设置：删除时间
	 */
	public void setDeletedate(String deletedate) {
		this.deletedate = deletedate;
	}
	/**
	 * 获取：删除时间
	 */
	public String getDeletedate() {
		return deletedate;
	}
}
