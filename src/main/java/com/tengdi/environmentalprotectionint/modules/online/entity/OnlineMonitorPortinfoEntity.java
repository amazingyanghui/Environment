package com.tengdi.environmentalprotectionint.modules.online.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 监控点信息表
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:52:11
 */
@TableName("online_monitor_portinfo")
public class OnlineMonitorPortinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 监控点ID（主键UUID）
	 */
	@TableId
	private String pid;
	/**
	 * 企业ID
	 */
	private String cid;
	/**
	 * 监控点编号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String monitorCode;
	/**
	 * 监控点名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String monitorName;
	/**
	 * 监控点类型(0：废水；1：废气；2：VOCs)
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer monitorType;
	/**
	 * 监控点是否使用（0：否；1：是）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer monitorUseflag;
	/**
	 * 监控点是否使用名称
	 */
	@TableField(exist = false)
	private String monitorUseFlagName;

	public String getMonitorUseFlagName() {
		return monitorUseFlagName;
	}

	public void setMonitorUseFlagName(String monitorUseFlagName) {
		this.monitorUseFlagName = monitorUseFlagName;
	}

	/**
	 * 联系人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String linkmen;
	/**
	 * 联系电话
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String linkphone;
	/**
	 * 地址码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String addressCode;
	/**
	 * 经度
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Double longitude;
	/**
	 * 纬度
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Double latitude;
	/**
	 * 主要污染物
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String mainPollution;
	/**
	 * 排放方式（0：直接排放；1：间接排放）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String emissionMode;
	/**
	 * 排放方式名称
	 */
	@TableField(exist = false)
	private String emissionModeName;

	public String getEmissionModeName() {
		return emissionModeName;
	}

	public void setEmissionModeName(String emissionModeName) {
		this.emissionModeName = emissionModeName;
	}

	/**
	 * 排放去向
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String emissionDirection;
	/**
	 * 受纳水体
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String receivingWater;
	/**
	 * 运维单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String operationUnit;
	/**
	 * 排口照片
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String photoPath;
	/**
	 * 排放类型（0：持续排放:1：间歇排放）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer emissionType;
	/**
	 * 排放类型名称
	 */
	@TableField(exist = false)
	private String emissionTypeName;

	public String getEmissionTypeName() {
		return emissionTypeName;
	}

	public void setEmissionTypeName(String emissionTypeName) {
		this.emissionTypeName = emissionTypeName;
	}

	/**
	 * 联网日期
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String networkingDate;
	/**
	 * 创建日期
	 */
	private Date createdate;
	/**
	 * 更新日期
	 */
	private Date updatedate;
	/**
	 * 删除日期
	 */
	private Date deletedata;

	/**
	 * 公司名称
	 */
	@TableField(exist = false)
	private String companyName;

	/**
	 * 公司地址
	 */
	@TableField(exist = false)
	private String companyAddress;

	/**
	 * 环保联系人
	 */
	@TableField(exist = false)
	private String environmentalProtectionName;

	/**
	 * 环保联系人联系电话
	 */
	@TableField(exist = false)
	private String environmentalProtectionPhone;

	/**
	 * 监控级别
	 */
	@TableField(exist = false)
	private String regulatoryLevel;

	/**
	 * 行政区
	 */
	@TableField(exist = false)
	private String localCity;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String mn;

	/**
	 * 监测站使用类型（0：企业；1：园区）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private int useType;
	/**
	 * 监测站使用类型（0：企业；1：园区）name
	 */
	@TableField(exist = false)
	private String useTypeName;

	public String getUseTypeName() {
		return useTypeName;
	}

	public void setUseTypeName(String useTypeName) {
		this.useTypeName = useTypeName;
	}

	/**
	 *排污许可证ID（外键关联排污许可证表）
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String permitid;

	/**
	 *税源编号
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String taxSourceCode;

	/**
	 *污染物排放量计算方法
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String computingMethod;
	/**
	 *污染物排放量计算方法name
	 * @return
	 */
	@TableField(exist = false)
	private String computingMethodName;

	/**
	 *功能区分类
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer domainType;
	/**
	 *功能区分类name
	 * @return
	 */
	@TableField(exist = false)
	private String domainTypeName;

	public String getDomainTypeName() {
		return domainTypeName;
	}

	public void setDomainTypeName(String domainTypeName) {
		this.domainTypeName = domainTypeName;
	}

	/**
	 *是否昼夜产生(0：否；1：是)
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer dayAndNight;
	/**
	 *是否昼夜产生(0：否；1：是)name
	 * @return
	 */
	@TableField(exist = false)
	private String dayAndNightName;

	public String getDayAndNightName() {
		return dayAndNightName;
	}

	public void setDayAndNightName(String dayAndNightName) {
		this.dayAndNightName = dayAndNightName;
	}

	/**
	 *执行标准
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String executiveStandard;

	/**
	 *标准限值-昼（分贝）
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String standardLimitsDay;

	/**
	 *标准限值-夜（分贝）
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String standardLimitsNight;

	/**
	 *监控点位置
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String monitorPosition;

    /**
     * 许可证编号
     * @return
     */
    @TableField(exist = false)
    private String permitCode ;

	/**
	 * 大气污染物排放口类别
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer airpollutantType;

	/**
	 * 大气污染物排放口类别name
	 * @return
	 */
	@TableField(exist = false)
	private String airpollutantTypeName;

	public String getComputingMethodName() {
		return computingMethodName;
	}

	public void setComputingMethodName(String computingMethodName) {
		this.computingMethodName = computingMethodName;
	}

	public String getAirpollutantTypeName() {
		return airpollutantTypeName;
	}

	public void setAirpollutantTypeName(String airpollutantTypeName) {
		this.airpollutantTypeName = airpollutantTypeName;
	}

	/**
	 *堆放场所面积
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pointArea;

	/**
	 *排入污水处理厂名称(废气)
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String sewagePlantName;

	/**
	 *排口高度(米)(废气)
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String outPortHeight;

	/**
	 *出口内经(米)(废气)
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String outPortDiameter;

	/**
	 *燃料名称(废气)/堆存物料
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String fuelName;

	/**
	 *燃料种类(废气)/堆存物料类型
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String fuelType;

	/**
	 *燃料种类(废气)/堆存物料类型name
	 * @return
	 */
	@TableField(exist = false)
	private String fuelTypeName;

	public String getFuelTypeName() {
		return fuelTypeName;
	}

	public void setFuelTypeName(String fuelTypeName) {
		this.fuelTypeName = fuelTypeName;
	}

	/**
	 *燃烧方式(废气)/粉尘控制措施
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String fuelMode;

	/**
	 *年物料运载车次(车)
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String deliveryVehicleCount;

	/**
	 *单车平均运载量(吨/车)
	 * @return
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String averageCarryingCapacity;

	public String getPointArea() {
		return pointArea;
	}

	public void setPointArea(String pointArea) {
		this.pointArea = pointArea;
	}

	public String getSewagePlantName() {
		return sewagePlantName;
	}

	public void setSewagePlantName(String sewagePlantName) {
		this.sewagePlantName = sewagePlantName;
	}

	public String getOutPortHeight() {
		return outPortHeight;
	}

	public void setOutPortHeight(String outPortHeight) {
		this.outPortHeight = outPortHeight;
	}

	public String getOutPortDiameter() {
		return outPortDiameter;
	}

	public void setOutPortDiameter(String outPortDiameter) {
		this.outPortDiameter = outPortDiameter;
	}

	public String getFuelName() {
		return fuelName;
	}

	public void setFuelName(String fuelName) {
		this.fuelName = fuelName;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getFuelMode() {
		return fuelMode;
	}

	public void setFuelMode(String fuelMode) {
		this.fuelMode = fuelMode;
	}

	public String getDeliveryVehicleCount() {
		return deliveryVehicleCount;
	}

	public void setDeliveryVehicleCount(String deliveryVehicleCount) {
		this.deliveryVehicleCount = deliveryVehicleCount;
	}

	public String getAverageCarryingCapacity() {
		return averageCarryingCapacity;
	}

	public void setAverageCarryingCapacity(String averageCarryingCapacity) {
		this.averageCarryingCapacity = averageCarryingCapacity;
	}

	public Integer getAirpollutantType() {
		return airpollutantType;
	}

	public void setAirpollutantType(Integer airpollutantType) {
		this.airpollutantType = airpollutantType;
	}

	public String getMonitorPosition() {
		return monitorPosition;
	}

	public void setMonitorPosition(String monitorPosition) {
		this.monitorPosition = monitorPosition;
	}

	public Integer getDomainType() {
		return domainType;
	}

	public void setDomainType(Integer domainType) {
		this.domainType = domainType;
	}

	public Integer getDayAndNight() {
		return dayAndNight;
	}

	public void setDayAndNight(Integer dayAndNight) {
		this.dayAndNight = dayAndNight;
	}

	public String getExecutiveStandard() {
		return executiveStandard;
	}

	public void setExecutiveStandard(String executiveStandard) {
		this.executiveStandard = executiveStandard;
	}

	public String getStandardLimitsDay() {
		return standardLimitsDay;
	}

	public void setStandardLimitsDay(String standardLimitsDay) {
		this.standardLimitsDay = standardLimitsDay;
	}

	public String getStandardLimitsNight() {
		return standardLimitsNight;
	}

	public void setStandardLimitsNight(String standardLimitsNight) {
		this.standardLimitsNight = standardLimitsNight;
	}

	public String getPermitid() {
		return permitid;
	}

	public void setPermitid(String permitid) {
		this.permitid = permitid;
	}

	public String getTaxSourceCode() {
		return taxSourceCode;
	}

	public void setTaxSourceCode(String taxSourceCode) {
		this.taxSourceCode = taxSourceCode;
	}

	public String getComputingMethod() {
		return computingMethod;
	}

	public void setComputingMethod(String computingMethod) {
		this.computingMethod = computingMethod;
	}

	public int getUseType() {
		return useType;
	}

	public void setUseType(int useType) {
		this.useType = useType;
	}

	public String getMn() {
		return mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	public String getEnvironmentalProtectionName() {
		return environmentalProtectionName;
	}

	public void setEnvironmentalProtectionName(String environmentalProtectionName) {
		this.environmentalProtectionName = environmentalProtectionName;
	}

	public String getEnvironmentalProtectionPhone() {
		return environmentalProtectionPhone;
	}

	public void setEnvironmentalProtectionPhone(String environmentalProtectionPhone) {
		this.environmentalProtectionPhone = environmentalProtectionPhone;
	}

	public String getRegulatoryLevel() {
		return regulatoryLevel;
	}

	public void setRegulatoryLevel(String regulatoryLevel) {
		this.regulatoryLevel = regulatoryLevel;
	}

	public String getLocalCity() {
		return localCity;
	}

	public void setLocalCity(String localCity) {
		this.localCity = localCity;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 设置：监控点ID（主键UUID）
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：监控点ID（主键UUID）
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
	 * 设置：监控点编号
	 */
	public void setMonitorCode(String monitorCode) {
		this.monitorCode = monitorCode;
	}
	/**
	 * 获取：监控点编号
	 */
	public String getMonitorCode() {
		return monitorCode;
	}
	/**
	 * 设置：监控点名称
	 */
	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}
	/**
	 * 获取：监控点名称
	 */
	public String getMonitorName() {
		return monitorName;
	}
	/**
	 * 设置：监控点类型
	 */
	public void setMonitorType(Integer monitorType) {
		this.monitorType = monitorType;
	}
	/**
	 * 获取：监控点类型
	 */
	public Integer getMonitorType() {
		return monitorType;
	}
	/**
	 * 设置：监控点是否使用（0：否；1：是）
	 */
	public void setMonitorUseflag(Integer monitorUseflag) {
		this.monitorUseflag = monitorUseflag;
	}
	/**
	 * 获取：监控点是否使用（0：否；1：是）
	 */
	public Integer getMonitorUseflag() {
		return monitorUseflag;
	}
	/**
	 * 设置：联系人
	 */
	public void setLinkmen(String linkmen) {
		this.linkmen = linkmen;
	}
	/**
	 * 获取：联系人
	 */
	public String getLinkmen() {
		return linkmen;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLinkphone(String linkphone) {
		this.linkphone = linkphone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLinkphone() {
		return linkphone;
	}
	/**
	 * 设置：地址码
	 */
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
	/**
	 * 获取：地址码
	 */
	public String getAddressCode() {
		return addressCode;
	}
	/**
	 * 设置：经度
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：经度
	 */
	public Double getLongitude() {
		return longitude;
	}
	/**
	 * 设置：纬度
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：纬度
	 */
	public Double getLatitude() {
		return latitude;
	}
	/**
	 * 设置：主要污染物
	 */
	public void setMainPollution(String mainPollution) {
		this.mainPollution = mainPollution;
	}
	/**
	 * 获取：主要污染物
	 */
	public String getMainPollution() {
		return mainPollution;
	}
	/**
	 * 设置：排放方式（0：直接排放；1：间接排放）
	 */
	public void setEmissionMode(String emissionMode) {
		this.emissionMode = emissionMode;
	}
	/**
	 * 获取：排放方式（0：直接排放；1：间接排放）
	 */
	public String getEmissionMode() {
		return emissionMode;
	}
	/**
	 * 设置：排放去向
	 */
	public void setEmissionDirection(String emissionDirection) {
		this.emissionDirection = emissionDirection;
	}
	/**
	 * 获取：排放去向
	 */
	public String getEmissionDirection() {
		return emissionDirection;
	}
	/**
	 * 设置：受纳水体
	 */
	public void setReceivingWater(String receivingWater) {
		this.receivingWater = receivingWater;
	}
	/**
	 * 获取：受纳水体
	 */
	public String getReceivingWater() {
		return receivingWater;
	}
	/**
	 * 设置：运维单位
	 */
	public void setOperationUnit(String operationUnit) {
		this.operationUnit = operationUnit;
	}
	/**
	 * 获取：运维单位
	 */
	public String getOperationUnit() {
		return operationUnit;
	}
	/**
	 * 设置：排口照片
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	/**
	 * 获取：排口照片
	 */
	public String getPhotoPath() {
		return photoPath;
	}
	/**
	 * 设置：排放类型（0：持续排放:1：间歇排放）
	 */
	public void setEmissionType(Integer emissionType) {
		this.emissionType = emissionType;
	}
	/**
	 * 获取：排放类型（0：持续排放:1：间歇排放）
	 */
	public Integer getEmissionType() {
		return emissionType;
	}
	/**
	 * 设置：联网日期
	 */
	public void setNetworkingDate(String networkingDate) {
		this.networkingDate = networkingDate;
	}
	/**
	 * 获取：联网日期
	 */
	public String getNetworkingDate() {
		return networkingDate;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getCreatedate() {
		return createdate;
	}
	/**
	 * 设置：更新日期
	 */
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：更新日期
	 */
	public Date getUpdatedate() {
		return updatedate;
	}
	/**
	 * 设置：删除日期
	 */
	public void setDeletedata(Date deletedata) {
		this.deletedata = deletedata;
	}
	/**
	 * 获取：删除日期
	 */
	public Date getDeletedata() {
		return deletedata;
	}


    public String getPermitCode() {
        return permitCode;
    }

    public void setPermitCode(String permitCode) {
        this.permitCode = permitCode;
    }
}
