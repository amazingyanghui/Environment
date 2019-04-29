package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;

/**
 * 用水情况
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 14:30:09
 */
@TableName("cominfo_production_water")
public class CominfoProductionWaterEntity implements Serializable {
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
	 * 用水总量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String totalWater;
	/**
	 * 新鲜用水量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String freshWater;
	/**
	 * 再生用水量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String regeneratedWater;
	/**
	 * 自备水量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String selfcontainedWater;
	/**
	 *  单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String unit;
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
	 * 设置：用水总量
	 */
	public void setTotalWater(String totalWater) {
		this.totalWater = totalWater;
	}
	/**
	 * 获取：用水总量
	 */
	public String getTotalWater() {
		return totalWater;
	}
	/**
	 * 设置：新鲜用水量
	 */
	public void setFreshWater(String freshWater) {
		this.freshWater = freshWater;
	}
	/**
	 * 获取：新鲜用水量
	 */
	public String getFreshWater() {
		return freshWater;
	}
	/**
	 * 设置：再生用水量
	 */
	public void setRegeneratedWater(String regeneratedWater) {
		this.regeneratedWater = regeneratedWater;
	}
	/**
	 * 获取：再生用水量
	 */
	public String getRegeneratedWater() {
		return regeneratedWater;
	}
	/**
	 * 设置：自备水量
	 */
	public void setSelfcontainedWater(String selfcontainedWater) {
		this.selfcontainedWater = selfcontainedWater;
	}
	/**
	 * 获取：自备水量
	 */
	public String getSelfcontainedWater() {
		return selfcontainedWater;
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
}
