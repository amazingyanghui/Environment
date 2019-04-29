package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;

/**
 * 能源消耗
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:00
 */
@TableName("cominfo_production_energy")
public class CominfoProductionEnergyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键UUID
	 */
	@TableId
	private String pid;
	/**
	 * 映射基本信息表主键（UUID）
	 */
	private String cid;
	/**
	 * 能源代码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String energyCode;
	/**
	 * 能源名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String energyName;
	/**
	 * 能源消耗量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String energyConsumption;
	/**
	 * 单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String unit;
	/**
	 * 备注
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String remarks;


	/**
	 *能源类型编号
	 */
	private String energyTypeCode ;


	/**
	 *能源类型
	 */
	private String energyType ;

	/**
	 *发电消耗量
	 */
	private String electricityConsumption ;

	/**
	 * 供热消耗量
	 */

	private String heatingConsumption ;

	/**
	 * 低位发热量
	 */
	private String lowCalorificValue ;

	/**
	 *平均收到基含硫量
	 */
	private String aveSulphurContent ;


	/**
	 *平均收到基灰分
	 */
	private String aveAshContent ;

	/**
	 *平均干燥无灰基挥发分
	 */
	private String aveDryAshlessVolatiles ;

	/**
	 *其他燃料消耗总量
	 */
	private String otherFuelConsumption;

	/**
	 *用作原辅材料量
	 */
	private String	usedPrimaryMaterialValue;

	/**
	 * 创建时间
	 */
	private String createdate;
	/**
	 * 修改时间
	 */
	private String updatedate;
	/**
	 * 删除时间
	 */
	private String deletedate;
	/**
	 * 年度
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String year;
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
	 * 设置：映射基本信息表主键（UUID）
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：映射基本信息表主键（UUID）
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：能源代码
	 */
	public void setEnergyCode(String energyCode) {
		this.energyCode = energyCode;
	}
	/**
	 * 获取：能源代码
	 */
	public String getEnergyCode() {
		return energyCode;
	}
	/**
	 * 设置：能源名称
	 */
	public void setEnergyName(String energyName) {
		this.energyName = energyName;
	}
	/**
	 * 获取：能源名称
	 */
	public String getEnergyName() {
		return energyName;
	}
	/**
	 * 设置：能源消耗量
	 */
	public void setEnergyConsumption(String energyConsumption) {
		this.energyConsumption = energyConsumption;
	}
	/**
	 * 获取：能源消耗量
	 */
	public String getEnergyConsumption() {
		return energyConsumption;
	}
	/**
	 * 设置：单位
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取：单位
	 */
	public String getUnit() {
		return unit;
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
	 * 设置：修改时间
	 */
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：修改时间
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}


	public String getEnergyTypeCode() {
		return energyTypeCode;
	}

	public void setEnergyTypeCode(String energyTypeCode) {
		this.energyTypeCode = energyTypeCode;
	}

	public String getEnergyType() {
		return energyType;
	}

	public void setEnergyType(String energyType) {
		this.energyType = energyType;
	}

	public String getElectricityConsumption() {
		return electricityConsumption;
	}

	public void setElectricityConsumption(String electricityConsumption) {
		this.electricityConsumption = electricityConsumption;
	}

	public String getHeatingConsumption() {
		return heatingConsumption;
	}

	public void setHeatingConsumption(String heatingConsumption) {
		this.heatingConsumption = heatingConsumption;
	}

	public String getLowCalorificValue() {
		return lowCalorificValue;
	}

	public void setLowCalorificValue(String lowCalorificValue) {
		this.lowCalorificValue = lowCalorificValue;
	}

	public String getAveSulphurContent() {
		return aveSulphurContent;
	}

	public void setAveSulphurContent(String aveSulphurContent) {
		this.aveSulphurContent = aveSulphurContent;
	}

	public String getAveAshContent() {
		return aveAshContent;
	}

	public void setAveAshContent(String aveAshContent) {
		this.aveAshContent = aveAshContent;
	}

	public String getAveDryAshlessVolatiles() {
		return aveDryAshlessVolatiles;
	}

	public void setAveDryAshlessVolatiles(String aveDryAshlessVolatiles) {
		this.aveDryAshlessVolatiles = aveDryAshlessVolatiles;
	}

	public String getOtherFuelConsumption() {
		return otherFuelConsumption;
	}

	public void setOtherFuelConsumption(String otherFuelConsumption) {
		this.otherFuelConsumption = otherFuelConsumption;
	}

	public String getUsedPrimaryMaterialValue() {
		return usedPrimaryMaterialValue;
	}

	public void setUsedPrimaryMaterialValue(String usedPrimaryMaterialValue) {
		this.usedPrimaryMaterialValue = usedPrimaryMaterialValue;
	}
}
