package com.tengdi.environmentalprotectionint.modules.greentax.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 环保税公式的公式项
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-05 11:19:12
 */
@TableName("ep_tax_formula_item")
public class EpTaxFormulaItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 公式ID
	 */
	private String formulaId;
	/**
	 * 公式项名称
	 */
	private String itemName;
	/**
	 * 公式项的说明
	 */
	private String itemExplain;
	/**
	 * 公式项的类型，和表单的组件类型一致即可
	 */
	private String itemType;
	/**
	 * 公式项的值来源，支持AJAX动态和静态JSON
	 */
	private String itemDataSource;
	/**
	 * 公式项的顺序
	 */
	private Integer itemOrder;

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
	 * 设置：公式ID
	 */
	public void setFormulaId(String formulaId) {
		this.formulaId = formulaId;
	}
	/**
	 * 获取：公式ID
	 */
	public String getFormulaId() {
		return formulaId;
	}
	/**
	 * 设置：公式项名称
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * 获取：公式项名称
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * 设置：公式项的说明
	 */
	public void setItemExplain(String itemExplain) {
		this.itemExplain = itemExplain;
	}
	/**
	 * 获取：公式项的说明
	 */
	public String getItemExplain() {
		return itemExplain;
	}
	/**
	 * 设置：公式项的类型，和表单的组件类型一致即可
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	/**
	 * 获取：公式项的类型，和表单的组件类型一致即可
	 */
	public String getItemType() {
		return itemType;
	}
	/**
	 * 设置：公式项的值来源，支持AJAX动态和静态JSON
	 */
	public void setItemDataSource(String itemDataSource) {
		this.itemDataSource = itemDataSource;
	}
	/**
	 * 获取：公式项的值来源，支持AJAX动态和静态JSON
	 */
	public String getItemDataSource() {
		return itemDataSource;
	}
	/**
	 * 设置：公式项的顺序
	 */
	public void setItemOrder(Integer itemOrder) {
		this.itemOrder = itemOrder;
	}
	/**
	 * 获取：公式项的顺序
	 */
	public Integer getItemOrder() {
		return itemOrder;
	}
}
