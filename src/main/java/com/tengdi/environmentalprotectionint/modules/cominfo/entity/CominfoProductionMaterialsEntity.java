package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;

/**
 * 主要原辅助材料
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:42:35
 */
@TableName("cominfo_production_materials")
public class CominfoProductionMaterialsEntity implements Serializable {
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
	 * 原辅材料名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String materialsName;
	/**
	 * 原辅材料编码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String materialsCode;
	/**
	 * 计划年用量 
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Double plannedAnnualAmount;
	/**
	 * 实际年用量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Double actualAnnualAmount;
	/**
	 *  单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String unit;

	/**
	 *原辅材料类别
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String sourceMaterialType;
	/**
	 *原辅材料品牌
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String sourceMaterialBrand;
	/**
	 *原辅材料品牌代码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String sourceMaterialBrandCode;
	/**
	 * 处理工艺
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String treatmentProcess;
	/**
	 *收集方式
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String collectionMode;

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
	 * 修改时间
	 */
	private String updatedate;
	/**
	 * 删除时间
	 */
	private String deletedate;

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
	 * 设置：原辅材料名称
	 */
	public void setMaterialsName(String materialsName) {
		this.materialsName = materialsName;
	}
	/**
	 * 获取：原辅材料名称
	 */
	public String getMaterialsName() {
		return materialsName;
	}
	/**
	 * 设置：原辅材料编码
	 */
	public void setMaterialsCode(String materialsCode) {
		this.materialsCode = materialsCode;
	}
	/**
	 * 获取：原辅材料编码
	 */
	public String getMaterialsCode() {
		return materialsCode;
	}
	/**
	 * 设置：计划年用量 
	 */
	public void setPlannedAnnualAmount(Double plannedAnnualAmount) {
		this.plannedAnnualAmount = plannedAnnualAmount;
	}
	/**
	 * 获取：计划年用量 
	 */
	public Double getPlannedAnnualAmount() {
		return plannedAnnualAmount;
	}
	/**
	 * 设置：实际年用量
	 */
	public void setActualAnnualAmount(Double actualAnnualAmount) {
		this.actualAnnualAmount = actualAnnualAmount;
	}
	/**
	 * 获取：实际年用量
	 */
	public Double getActualAnnualAmount() {
		return actualAnnualAmount;
	}
	/**
	 * 设置： 单位
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取： 单位
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

	public String getSourceMaterialType() {
		return sourceMaterialType;
	}

	public void setSourceMaterialType(String sourceMaterialType) {
		this.sourceMaterialType = sourceMaterialType;
	}

	public String getSourceMaterialBrand() {
		return sourceMaterialBrand;
	}

	public void setSourceMaterialBrand(String sourceMaterialBrand) {
		this.sourceMaterialBrand = sourceMaterialBrand;
	}

	public String getSourceMaterialBrandCode() {
		return sourceMaterialBrandCode;
	}

	public void setSourceMaterialBrandCode(String sourceMaterialBrandCode) {
		this.sourceMaterialBrandCode = sourceMaterialBrandCode;
	}

	public String getCollectionMode() {
		return collectionMode;
	}

	public void setCollectionMode(String collectionMode) {
		this.collectionMode = collectionMode;
	}

	public String getTreatmentProcess() {
		return treatmentProcess;
	}

	public void setTreatmentProcess(String treatmentProcess) {
		this.treatmentProcess = treatmentProcess;
	}
}
