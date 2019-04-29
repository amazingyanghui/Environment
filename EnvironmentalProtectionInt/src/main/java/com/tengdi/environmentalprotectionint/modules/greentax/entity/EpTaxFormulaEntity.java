package com.tengdi.environmentalprotectionint.modules.greentax.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 环保税公式，根据行业类别和污染物来适配所用公式
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-05 11:19:08
 */
@TableName("ep_tax_formula")
public class EpTaxFormulaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 公式表达式
	 */
	private String formulaExpression;
	/**
	 * 行业类别
	 */
	private String industryCategory;
	/**
	 * 污染物
	 */
	private String contaminant;
	/**
	 * 公式说明
	 */
	private String remark;

	/**
	 * 公式的元素集合
	 */
	@TableField(exist = false)
	private List<EpTaxFormulaItemEntity> epTaxFormulaItemEntityList;

	/**
	 * 污染物所对应的当量计算对象
	 */
	@TableField(exist = false)

	private EpTaxAmountEntity epTaxAmountEntity;




	public List<EpTaxFormulaItemEntity> getEpTaxFormulaItemEntityList() {
		return epTaxFormulaItemEntityList;
	}

	public void setEpTaxFormulaItemEntityList(List<EpTaxFormulaItemEntity> epTaxFormulaItemEntityList) {
		this.epTaxFormulaItemEntityList = epTaxFormulaItemEntityList;
	}
	public EpTaxAmountEntity getEpTaxAmountEntity() {
		return epTaxAmountEntity;
	}

	public void setEpTaxAmountEntity(EpTaxAmountEntity epTaxAmountEntity) {
		this.epTaxAmountEntity = epTaxAmountEntity;
	}

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：公式表达式
	 */
	public void setFormulaExpression(String formulaExpression) {
		this.formulaExpression = formulaExpression;
	}
	/**
	 * 获取：公式表达式
	 */
	public String getFormulaExpression() {
		return formulaExpression;
	}
	/**
	 * 设置：行业类别
	 */
	public void setIndustryCategory(String industryCategory) {
		this.industryCategory = industryCategory;
	}
	/**
	 * 获取：行业类别
	 */
	public String getIndustryCategory() {
		return industryCategory;
	}
	/**
	 * 设置：污染物
	 */
	public void setContaminant(String contaminant) {
		this.contaminant = contaminant;
	}
	/**
	 * 获取：污染物
	 */
	public String getContaminant() {
		return contaminant;
	}
	/**
	 * 设置：公式说明
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：公式说明
	 */
	public String getRemark() {
		return remark;
	}
}
