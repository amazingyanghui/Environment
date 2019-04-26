package com.tengdi.environmentalprotectionint.modules.greentaxesinformation.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 固体废物基础信息采集
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-04 11:14:18
 */
@TableName("solidwaste_information")
public class SolidwasteInformationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private String id;

	/**
	 * 设置：ID
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：ID
	 */
	public String getId() {
		return id;
	}
}
