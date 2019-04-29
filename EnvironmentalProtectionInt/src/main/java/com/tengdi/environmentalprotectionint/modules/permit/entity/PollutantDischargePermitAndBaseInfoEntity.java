package com.tengdi.environmentalprotectionint.modules.permit.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 专门用于环保税基础信息采集表
 *
 * @author tengdi
 * @email
 * @date 2018-09-10 15:38:35
 */
public class PollutantDischargePermitAndBaseInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 许可证id
	 */
	private String pid;

	/**
	 * 企业ID
	 */
	private String cid;

	/**
	 * 环境管理id
	 */
	private String eid;

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 排口id
	 */
	private String oid;

	/**
	 * 许可证编号
	 */
	private String permitCode;

	/**
	 * 纳税人名称
	 */
	private String companyName;

	/**
	 * 统一社会信用代码
	 */
	private String unifiedSocialCreditCode;

	/**
	 * 生产经营场所地址
	 */
	private String companyAddress;

	/**
	 * 环保联系人
	 */
	private String environmentalProtectionName;

	/**
	 * 环保联系人电话
	 */
	private String environmentalProtectionMobile;

	/**
	 * 是否取得排污许可证
	 */
	private String isGetSewageDischargePermission;

	/**
	 * 是否采用抽样测算法计算
	 */
	private Integer isSampling;

	/**
	 * 是否从事海洋工程
	 */
	private Integer isOceaneering;

	/**
	 * 城乡污水集中处理场所
	 */
	private String isSewagetreatmentSites;

	/**
	 * 生活垃圾集中处理场所
	 */
	private String isDomesticwasteSites;

	/**
	 * 主要污染物类别
	 */
	private Integer mainWasteCategory;

	/**
	 * 有效期开始日期
	 */
	private String startDate;
	/**
	 * 有效期结束日期
	 */
	private String endDate;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * 排放口类型
	 */
	private String monitorType;

	/**
	 *税源编号
	 * @return
	 */
	private String taxSourceCode;

	/**
	 * 监控点编号
	 */
	private String monitorCode;

	/**
	 * 监控点名称
	 */
	private String monitorName;

	/**
	 * 所属街道/乡镇
	 */
	private String streetOrTown;

	/**
	 * 所属区县
	 */
	private String districtAndCounty;

	/**
	 * 经度
	 */
	private Double longitude;
	/**
	 * 纬度
	 */
	private Double latitude;
	/**
	 * 地址码
	 */
	private String mn;

	/**
	 * 排放方式（0：直接排放；1：间接排放）
	 */
	private String emissionMode;

	/**
	 * 排放去向
	 */
	private String emissionDirection;

	/**
	 * 管控要求
	 */
	private String controlRequirements;

	/**
	 * 大气污染物排放口类别
	 * @return
	 */
	private Integer airpollutantType;
	/**
	 * 是否水污染
	 */
	private String isWaterWaste;
	/**
	 * 是否大气污染
	 */
	private String isAirWaste;
	/**
	 * 是否固废污染
	 */
	private String isSolidWaste;
	/**
	 * 是否噪声污染
	 */
	private String isNoiseWaste;

	public String getIsWaterWaste() {
		return isWaterWaste;
	}

	public void setIsWaterWaste(String isWaterWaste) {
		this.isWaterWaste = isWaterWaste;
	}

	public String getIsAirWaste() {
		return isAirWaste;
	}

	public void setIsAirWaste(String isAirWaste) {
		this.isAirWaste = isAirWaste;
	}

	public String getIsSolidWaste() {
		return isSolidWaste;
	}

	public void setIsSolidWaste(String isSolidWaste) {
		this.isSolidWaste = isSolidWaste;
	}

	public String getIsNoiseWaste() {
		return isNoiseWaste;
	}

	public void setIsNoiseWaste(String isNoiseWaste) {
		this.isNoiseWaste = isNoiseWaste;
	}

	private List<PollutantDischargePermitAndBaseInfoEntity> baseInfoEntityList;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getPermitCode() {
		return permitCode;
	}

	public void setPermitCode(String permitCode) {
		this.permitCode = permitCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getUnifiedSocialCreditCode() {
		return unifiedSocialCreditCode;
	}

	public void setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
		this.unifiedSocialCreditCode = unifiedSocialCreditCode;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getEnvironmentalProtectionName() {
		return environmentalProtectionName;
	}

	public void setEnvironmentalProtectionName(String environmentalProtectionName) {
		this.environmentalProtectionName = environmentalProtectionName;
	}

	public String getEnvironmentalProtectionMobile() {
		return environmentalProtectionMobile;
	}

	public void setEnvironmentalProtectionMobile(String environmentalProtectionMobile) {
		this.environmentalProtectionMobile = environmentalProtectionMobile;
	}

	public String getIsGetSewageDischargePermission() {
		return isGetSewageDischargePermission;
	}

	public void setIsGetSewageDischargePermission(String isGetSewageDischargePermission) {
		this.isGetSewageDischargePermission = isGetSewageDischargePermission;
	}

	public Integer getIsSampling() {
		return isSampling;
	}

	public void setIsSampling(Integer isSampling) {
		this.isSampling = isSampling;
	}

	public Integer getIsOceaneering() {
		return isOceaneering;
	}

	public void setIsOceaneering(Integer isOceaneering) {
		this.isOceaneering = isOceaneering;
	}

	public String getIsSewagetreatmentSites() {
		return isSewagetreatmentSites;
	}

	public void setIsSewagetreatmentSites(String isSewagetreatmentSites) {
		this.isSewagetreatmentSites = isSewagetreatmentSites;
	}

	public String getIsDomesticwasteSites() {
		return isDomesticwasteSites;
	}

	public void setIsDomesticwasteSites(String isDomesticwasteSites) {
		this.isDomesticwasteSites = isDomesticwasteSites;
	}

	public Integer getMainWasteCategory() {
		return mainWasteCategory;
	}

	public void setMainWasteCategory(Integer mainWasteCategory) {
		this.mainWasteCategory = mainWasteCategory;
	}

	public String getMonitorType() {
		return monitorType;
	}

	public void setMonitorType(String monitorType) {
		this.monitorType = monitorType;
	}

	public String getTaxSourceCode() {
		return taxSourceCode;
	}

	public void setTaxSourceCode(String taxSourceCode) {
		this.taxSourceCode = taxSourceCode;
	}

	public String getMonitorCode() {
		return monitorCode;
	}

	public void setMonitorCode(String monitorCode) {
		this.monitorCode = monitorCode;
	}

	public String getMonitorName() {
		return monitorName;
	}

	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}

	public String getStreetOrTown() {
		return streetOrTown;
	}

	public void setStreetOrTown(String streetOrTown) {
		this.streetOrTown = streetOrTown;
	}

	public String getDistrictAndCounty() {
		return districtAndCounty;
	}

	public void setDistrictAndCounty(String districtAndCounty) {
		this.districtAndCounty = districtAndCounty;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getMn() {
		return mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	public String getEmissionMode() {
		return emissionMode;
	}

	public void setEmissionMode(String emissionMode) {
		this.emissionMode = emissionMode;
	}

	public String getEmissionDirection() {
		return emissionDirection;
	}

	public void setEmissionDirection(String emissionDirection) {
		this.emissionDirection = emissionDirection;
	}

	public String getControlRequirements() {
		return controlRequirements;
	}

	public void setControlRequirements(String controlRequirements) {
		this.controlRequirements = controlRequirements;
	}

	public Integer getAirpollutantType() {
		return airpollutantType;
	}

	public void setAirpollutantType(Integer airpollutantType) {
		this.airpollutantType = airpollutantType;
	}

	public List<PollutantDischargePermitAndBaseInfoEntity> getBaseInfoEntityList() {
		return baseInfoEntityList;
	}

	public void setBaseInfoEntityList(List<PollutantDischargePermitAndBaseInfoEntity> baseInfoEntityList) {
		this.baseInfoEntityList = baseInfoEntityList;
	}
}
