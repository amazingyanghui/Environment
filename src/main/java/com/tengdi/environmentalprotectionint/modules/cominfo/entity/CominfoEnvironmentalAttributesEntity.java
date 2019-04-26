package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 环境属性
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:34
 */
@TableName("cominfo_environmental_attributes")
public class CominfoEnvironmentalAttributesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * UUID主键
	 */
	@TableId
	private String pid;
	/**
	 * 映射基本信息表主键（UUID）
	 */
	private String cid;
	/**
	 * 流域（数据字典）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String basin;
	/**
	 * 水域功能区级别（数据字典）
	 */
	private Integer waterLevel;
	/**
	 * 水域功能区级别name
	 */
	@TableField(exist = false)
	private String waterLevelName;
	/**
	 * 噪声功能区级别（数据字典）
	 */
	private Integer noiseLevel;
	/**
	 * 噪声功能区级别name
	 */
	@TableField(exist = false)
	private String noiseLevelName;
	/**
	 * 空气功能区级别（数据字典）
	 */
	private Integer airLevel;
	/**
	 * 空气功能区级别name
	 */
	@TableField(exist = false)
	private String airLevelName;
	/**
	 * 海域功能区级别（数据字典）
	 */
	private Integer seaLevel;
	/**
	 * 海域功能区级别name
	 */
	@TableField(exist = false)
	private String seaLevelName;
	/**
	 * 是否水源区（数据字典）
	 */
	private Integer waterSourceArea;
	/**
	 * 是否水源区name
	 */
	@TableField(exist = false)
	private String waterSourceAreaName;
	/**
	 * 是否SO2控制区（数据字典）
	 */
	private Integer sotwoArea;
	/**
	 * 是否SO2控制区name
	 */
	@TableField(exist = false)
	private String sotwoAreaName;
	/**
	 * 是否酸雨控制区（数据字典）
	 */
	private Integer acidRainArea;
	/**
	 * 是否酸雨控制区
	 */
	@TableField(exist = false)
	private String acidRainAreaName;
	/**
	 * 距最近河流（数据字典）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String nearestRiver;
	/**
	 * 距最近河流距离(km)
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String nearestRiverDistance;
	/**
	 * 创建时间
	 */
	private Date createdate;
	/**
	 * 修改时间
	 */
	private Date updatedate;
	/**
	 * 删除时间
	 */
	private Date deletedate;

	/**
	 * 设置：UUID主键
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：UUID主键
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
	 * 设置：流域（数据字典）
	 */
	public void setBasin(String basin) {
		this.basin = basin;
	}
	/**
	 * 获取：流域（数据字典）
	 */
	public String getBasin() {
		return basin;
	}
	/**
	 * 设置：水域功能区级别（数据字典）
	 */
	public void setWaterLevel(Integer waterLevel) {
		this.waterLevel = waterLevel;
	}
	/**
	 * 获取：水域功能区级别（数据字典）
	 */
	public Integer getWaterLevel() {
		return waterLevel;
	}
	/**
	 * 设置：噪声功能区级别（数据字典）
	 */
	public void setNoiseLevel(Integer noiseLevel) {
		this.noiseLevel = noiseLevel;
	}
	/**
	 * 获取：噪声功能区级别（数据字典）
	 */
	public Integer getNoiseLevel() {
		return noiseLevel;
	}
	/**
	 * 设置：空气功能区级别（数据字典）
	 */
	public void setAirLevel(Integer airLevel) {
		this.airLevel = airLevel;
	}
	/**
	 * 获取：空气功能区级别（数据字典）
	 */
	public Integer getAirLevel() {
		return airLevel;
	}
	/**
	 * 设置：海域功能区级别（数据字典）
	 */
	public void setSeaLevel(Integer seaLevel) {
		this.seaLevel = seaLevel;
	}
	/**
	 * 获取：海域功能区级别（数据字典）
	 */
	public Integer getSeaLevel() {
		return seaLevel;
	}
	/**
	 * 设置：是否水源区（数据字典）
	 */
	public void setWaterSourceArea(Integer waterSourceArea) {
		this.waterSourceArea = waterSourceArea;
	}
	/**
	 * 获取：是否水源区（数据字典）
	 */
	public Integer getWaterSourceArea() {
		return waterSourceArea;
	}
	/**
	 * 设置：是否SO2控制区（数据字典）
	 */
	public void setSotwoArea(Integer sotwoArea) {
		this.sotwoArea = sotwoArea;
	}
	/**
	 * 获取：是否SO2控制区（数据字典）
	 */
	public Integer getSotwoArea() {
		return sotwoArea;
	}
	/**
	 * 设置：是否酸雨控制区（数据字典）
	 */
	public void setAcidRainArea(Integer acidRainArea) {
		this.acidRainArea = acidRainArea;
	}
	/**
	 * 获取：是否酸雨控制区（数据字典）
	 */
	public Integer getAcidRainArea() {
		return acidRainArea;
	}
	/**
	 * 设置：距最近河流（数据字典）
	 */
	public void setNearestRiver(String nearestRiver) {
		this.nearestRiver = nearestRiver;
	}
	/**
	 * 获取：距最近河流（数据字典）
	 */
	public String getNearestRiver() {
		return nearestRiver;
	}
	/**
	 * 设置：距最近河流距离(km)
	 */
	public void setNearestRiverDistance(String nearestRiverDistance) {
		this.nearestRiverDistance = nearestRiverDistance;
	}
	/**
	 * 获取：距最近河流距离(km)
	 */
	public String getNearestRiverDistance() {
		return nearestRiverDistance;
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
	/**
	 * 设置：修改时间
	 */
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdatedate() {
		return updatedate;
	}
	/**
	 * 设置：删除时间
	 */
	public void setDeletedate(Date deletedate) {
		this.deletedate = deletedate;
	}
	/**
	 * 获取：删除时间
	 */
	public Date getDeletedate() {
		return deletedate;
	}

	public String getWaterLevelName() {
		return waterLevelName;
	}

	public void setWaterLevelName(String waterLevelName) {
		this.waterLevelName = waterLevelName;
	}

	public String getNoiseLevelName() {
		return noiseLevelName;
	}

	public void setNoiseLevelName(String noiseLevelName) {
		this.noiseLevelName = noiseLevelName;
	}

	public String getAirLevelName() {
		return airLevelName;
	}

	public void setAirLevelName(String airLevelName) {
		this.airLevelName = airLevelName;
	}

	public String getSeaLevelName() {
		return seaLevelName;
	}

	public void setSeaLevelName(String seaLevelName) {
		this.seaLevelName = seaLevelName;
	}

	public String getWaterSourceAreaName() {
		return waterSourceAreaName;
	}

	public void setWaterSourceAreaName(String waterSourceAreaName) {
		this.waterSourceAreaName = waterSourceAreaName;
	}

	public String getSotwoAreaName() {
		return sotwoAreaName;
	}

	public void setSotwoAreaName(String sotwoAreaName) {
		this.sotwoAreaName = sotwoAreaName;
	}

	public String getAcidRainAreaName() {
		return acidRainAreaName;
	}

	public void setAcidRainAreaName(String acidRainAreaName) {
		this.acidRainAreaName = acidRainAreaName;
	}
}
