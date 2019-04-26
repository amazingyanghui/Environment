package com.tengdi.environmentalprotectionint.modules.greentax.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 环境保护税税目税额表
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-06 09:19:00
 */
@TableName("ep_tax_amount")
public class EpTaxAmountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 污染物
	 */
	@TableId
	private String pollutant;
	/**
	 * 污染当量
	 */
	private String pollutantEquivalent;

	/**
	 * 设置：污染物
	 */
	public void setPollutant(String pollutant) {
		this.pollutant = pollutant;
	}
	/**
	 * 获取：污染物
	 */
	public String getPollutant() {
		return pollutant;
	}
	/**
	 * 设置：污染当量
	 */
	public void setPollutantEquivalent(String pollutantEquivalent) {
		this.pollutantEquivalent = pollutantEquivalent;
	}
	/**
	 * 获取：污染当量
	 */
	public String getPollutantEquivalent() {
		return pollutantEquivalent;
	}
}
