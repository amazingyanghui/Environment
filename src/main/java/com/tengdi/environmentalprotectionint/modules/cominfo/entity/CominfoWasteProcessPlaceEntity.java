package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * (固废,危险)废物处理场所
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-07 16:51:37
 */
@TableName("cominfo_waste_process_place")
public class CominfoWasteProcessPlaceEntity implements Serializable {
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
	 * 年度
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String year;
	/**
	 * 处置场编号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String wasteProcessPlaceCode;
	/**
	 * 处置场名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String wasteProcessPlaceName;
	/**
	 * 处置场类型
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String wasteProcessPlaceType;
	/**
	 * 贮存处置场详细地址
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String wasteProcessPlacePosition;
	/**
	 * 废物类型(固废、危废）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String wasteCategoryType;
	/**
	 * 处置场经度
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String placeLongitude;
	/**
	 * 处置场纬度
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String placeLatitude;
	/**
	 * 处置场设计容量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String placeDesignCapacity;
	/**
	 * 处置场已填容量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String placeFilledCapacity;
	/**
	 * 处置场设计处置能力
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String placeDesignAbility;
	/**
	 * 尾矿库环境风险等级（仅尾矿库填报）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String riskLevel;
	/**
	 * 尾矿库环境风险等级划定年份
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String riskDelineationYear;
	/**
	 * 本年实际填埋处置量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String actualLandfillCapacity;
	/**
	 * 焚烧装置的具体位置
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String burnDevicePosition;
	/**
	 * 焚烧装置的地理坐标-经度
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String burnDeviceLongitude;
	/**
	 * 焚烧装置的地理坐标-纬度
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String burnDeviceLatitude;
	/**
	 * 设施数量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String facilitiesNumber;
	/**
	 * 设计焚烧处置能力
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String burnDisposalCapacity;
	/**
	 * 本年实际焚烧处置量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String actualBurnDisposalCapacity;
	/**
	 * 综合利用方式
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String comprehensiveMode;
	/**
	 * 综合利用能力
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String comprehensiveAbility;
	/**
	 * 本年实际综合利用量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String actualComprehensiveAmount;
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
	 * 单台设计能力
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String singleDesignCapability;
	/**
	 * 日平均运行时间（小时）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String dayRuntime;
	/**
	 * 治理期限
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String governanceLimit;
	/**
	 * 验收意见
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String acceptanceOpinion;

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
	 * 设置：处置场编号
	 */
	public void setWasteProcessPlaceCode(String wasteProcessPlaceCode) {
		this.wasteProcessPlaceCode = wasteProcessPlaceCode;
	}
	/**
	 * 获取：处置场编号
	 */
	public String getWasteProcessPlaceCode() {
		return wasteProcessPlaceCode;
	}
	/**
	 * 设置：处置场名称
	 */
	public void setWasteProcessPlaceName(String wasteProcessPlaceName) {
		this.wasteProcessPlaceName = wasteProcessPlaceName;
	}
	/**
	 * 获取：处置场名称
	 */
	public String getWasteProcessPlaceName() {
		return wasteProcessPlaceName;
	}
	/**
	 * 设置：处置场类型
	 */
	public void setWasteProcessPlaceType(String wasteProcessPlaceType) {
		this.wasteProcessPlaceType = wasteProcessPlaceType;
	}
	/**
	 * 获取：处置场类型
	 */
	public String getWasteProcessPlaceType() {
		return wasteProcessPlaceType;
	}
	/**
	 * 设置：贮存处置场详细地址
	 */
	public void setWasteProcessPlacePosition(String wasteProcessPlacePosition) {
		this.wasteProcessPlacePosition = wasteProcessPlacePosition;
	}
	/**
	 * 获取：贮存处置场详细地址
	 */
	public String getWasteProcessPlacePosition() {
		return wasteProcessPlacePosition;
	}
	/**
	 * 设置：废物类型(固废、危废）
	 */
	public void setWasteCategoryType(String wasteCategoryType) {
		this.wasteCategoryType = wasteCategoryType;
	}
	/**
	 * 获取：废物类型(固废、危废）
	 */
	public String getWasteCategoryType() {
		return wasteCategoryType;
	}
	/**
	 * 设置：处置场经度
	 */
	public void setPlaceLongitude(String placeLongitude) {
		this.placeLongitude = placeLongitude;
	}
	/**
	 * 获取：处置场经度
	 */
	public String getPlaceLongitude() {
		return placeLongitude;
	}
	/**
	 * 设置：处置场纬度
	 */
	public void setPlaceLatitude(String placeLatitude) {
		this.placeLatitude = placeLatitude;
	}
	/**
	 * 获取：处置场纬度
	 */
	public String getPlaceLatitude() {
		return placeLatitude;
	}
	/**
	 * 设置：处置场设计容量
	 */
	public void setPlaceDesignCapacity(String placeDesignCapacity) {
		this.placeDesignCapacity = placeDesignCapacity;
	}
	/**
	 * 获取：处置场设计容量
	 */
	public String getPlaceDesignCapacity() {
		return placeDesignCapacity;
	}
	/**
	 * 设置：处置场已填容量
	 */
	public void setPlaceFilledCapacity(String placeFilledCapacity) {
		this.placeFilledCapacity = placeFilledCapacity;
	}
	/**
	 * 获取：处置场已填容量
	 */
	public String getPlaceFilledCapacity() {
		return placeFilledCapacity;
	}
	/**
	 * 设置：处置场设计处置能力
	 */
	public void setPlaceDesignAbility(String placeDesignAbility) {
		this.placeDesignAbility = placeDesignAbility;
	}
	/**
	 * 获取：处置场设计处置能力
	 */
	public String getPlaceDesignAbility() {
		return placeDesignAbility;
	}
	/**
	 * 设置：尾矿库环境风险等级（仅尾矿库填报）
	 */
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}
	/**
	 * 获取：尾矿库环境风险等级（仅尾矿库填报）
	 */
	public String getRiskLevel() {
		return riskLevel;
	}
	/**
	 * 设置：尾矿库环境风险等级划定年份
	 */
	public void setRiskDelineationYear(String riskDelineationYear) {
		this.riskDelineationYear = riskDelineationYear;
	}
	/**
	 * 获取：尾矿库环境风险等级划定年份
	 */
	public String getRiskDelineationYear() {
		return riskDelineationYear;
	}
	/**
	 * 设置：本年实际填埋处置量
	 */
	public void setActualLandfillCapacity(String actualLandfillCapacity) {
		this.actualLandfillCapacity = actualLandfillCapacity;
	}
	/**
	 * 获取：本年实际填埋处置量
	 */
	public String getActualLandfillCapacity() {
		return actualLandfillCapacity;
	}
	/**
	 * 设置：焚烧装置的具体位置
	 */
	public void setBurnDevicePosition(String burnDevicePosition) {
		this.burnDevicePosition = burnDevicePosition;
	}
	/**
	 * 获取：焚烧装置的具体位置
	 */
	public String getBurnDevicePosition() {
		return burnDevicePosition;
	}
	/**
	 * 设置：焚烧装置的地理坐标-经度
	 */
	public void setBurnDeviceLongitude(String burnDeviceLongitude) {
		this.burnDeviceLongitude = burnDeviceLongitude;
	}
	/**
	 * 获取：焚烧装置的地理坐标-经度
	 */
	public String getBurnDeviceLongitude() {
		return burnDeviceLongitude;
	}
	/**
	 * 设置：焚烧装置的地理坐标-纬度
	 */
	public void setBurnDeviceLatitude(String burnDeviceLatitude) {
		this.burnDeviceLatitude = burnDeviceLatitude;
	}
	/**
	 * 获取：焚烧装置的地理坐标-纬度
	 */
	public String getBurnDeviceLatitude() {
		return burnDeviceLatitude;
	}
	/**
	 * 设置：设施数量
	 */
	public void setFacilitiesNumber(String facilitiesNumber) {
		this.facilitiesNumber = facilitiesNumber;
	}
	/**
	 * 获取：设施数量
	 */
	public String getFacilitiesNumber() {
		return facilitiesNumber;
	}
	/**
	 * 设置：设计焚烧处置能力
	 */
	public void setBurnDisposalCapacity(String burnDisposalCapacity) {
		this.burnDisposalCapacity = burnDisposalCapacity;
	}
	/**
	 * 获取：设计焚烧处置能力
	 */
	public String getBurnDisposalCapacity() {
		return burnDisposalCapacity;
	}
	/**
	 * 设置：本年实际焚烧处置量
	 */
	public void setActualBurnDisposalCapacity(String actualBurnDisposalCapacity) {
		this.actualBurnDisposalCapacity = actualBurnDisposalCapacity;
	}
	/**
	 * 获取：本年实际焚烧处置量
	 */
	public String getActualBurnDisposalCapacity() {
		return actualBurnDisposalCapacity;
	}
	/**
	 * 设置：综合利用方式
	 */
	public void setComprehensiveMode(String comprehensiveMode) {
		this.comprehensiveMode = comprehensiveMode;
	}
	/**
	 * 获取：综合利用方式
	 */
	public String getComprehensiveMode() {
		return comprehensiveMode;
	}
	/**
	 * 设置：综合利用能力
	 */
	public void setComprehensiveAbility(String comprehensiveAbility) {
		this.comprehensiveAbility = comprehensiveAbility;
	}
	/**
	 * 获取：综合利用能力
	 */
	public String getComprehensiveAbility() {
		return comprehensiveAbility;
	}
	/**
	 * 设置：本年实际综合利用量
	 */
	public void setActualComprehensiveAmount(String actualComprehensiveAmount) {
		this.actualComprehensiveAmount = actualComprehensiveAmount;
	}
	/**
	 * 获取：本年实际综合利用量
	 */
	public String getActualComprehensiveAmount() {
		return actualComprehensiveAmount;
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
	/**
	 * 设置：单台设计能力
	 */
	public void setSingleDesignCapability(String singleDesignCapability) {
		this.singleDesignCapability = singleDesignCapability;
	}
	/**
	 * 获取：单台设计能力
	 */
	public String getSingleDesignCapability() {
		return singleDesignCapability;
	}
	/**
	 * 设置：日平均运行时间（小时）
	 */
	public void setDayRuntime(String dayRuntime) {
		this.dayRuntime = dayRuntime;
	}
	/**
	 * 获取：日平均运行时间（小时）
	 */
	public String getDayRuntime() {
		return dayRuntime;
	}
	/**
	 * 设置：治理期限
	 */
	public void setGovernanceLimit(String governanceLimit) {
		this.governanceLimit = governanceLimit;
	}
	/**
	 * 获取：治理期限
	 */
	public String getGovernanceLimit() {
		return governanceLimit;
	}
	/**
	 * 设置：验收意见
	 */
	public void setAcceptanceOpinion(String acceptanceOpinion) {
		this.acceptanceOpinion = acceptanceOpinion;
	}
	/**
	 * 获取：验收意见
	 */
	public String getAcceptanceOpinion() {
		return acceptanceOpinion;
	}
}
