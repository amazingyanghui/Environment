package com.tengdi.environmentalprotectionint.modules.zoneinfo.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 园区环境管理信息
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-11 09:56:11
 */
@TableName("zoneinfo_baseinfo")
public class ZoneinfoBaseinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键UUID
	 */
	@TableId
	private String pid;
	/**
	 * 01.园区名称
	 */
	private String zoneName;
	/**
	 * 02.园区代码
	 */
	private String zoneCode;
	/**
	 * 03.区划代码
	 */
	private String compartmentCode;
	/**
	 * 04.详细地址
	 */
	private String address;
	/**
	 * 所属省份
	 */
	private String province;
	/**
	 * 所属地市
	 */
	private String city;
	/**
	 * 所属区县
	 */
	private String area;
	/**
	 * 乡镇
	 */
	private String town;
	/**
	 * 街道
	 */
	private String street;
	/**
	 * 07.园区级别
	 */
	private String zoneLevel;
	/**
	 * 08.园区类型(行业类型)
	 */
	private String zoneTypeIndustry;
	/**
	 * 08.园区类型(综合类)
	 */
	private String zoneTypeComprehensive;
	/**
	 * 09.批准面积（公顷）
	 */
	private String approvedArea;
	/**
	 * 10.批准部门
	 */
	private String approvedDept;
	/**
	 * 11.批准时间
	 */
	private String approvedDate;
	/**
	 * 12.企业数量（家）注册工业企业数量：
	 */
	private String enterprisesNumber;
	/**
	 * 12.企业数量（家）园区内实际生产的企业数量：
	 */
	private String actualEnterprisesNumber;
	/**
	 * 13.主导行业一名称
	 */
	private String leadingIndustryName1;
	/**
	 * 13.主导行业一代码
	 */
	private String leadingIndustryCode1;
	/**
	 * 13.主导行业一产值占比（%）
	 */
	private String leadingIndustryPercent1;
	/**
	 * 13.主导行业二名称
	 */
	private String leadingIndustryName2;
	/**
	 * 13.主导行业二代码
	 */
	private String leadingIndustryCode2;
	/**
	 * 13.主导行业二产值占比（%）
	 */
	private String leadingIndustryPercent2;
	/**
	 * 13.主导行业三名称
	 */
	private String leadingIndustryName3;
	/**
	 * 13.主导行业三代码
	 */
	private String leadingIndustryCode3;
	/**
	 * 13.主导行业三产值占比（%）
	 */
	private String leadingIndustryPercent3;
	/**
	 * 14.是否清污分流
	 */
	private String isSewageDiversion;
	/**
	 * 清水排水去向类型：
	 */
	private String clearWaterDrainageDirection;
	/**
	 * 清水受纳水体名称：
	 */
	private String clearWaterReceivingBodyName;
	/**
	 * 清水受纳水体代码：
	 */
	private String clearWaterReceivingBodyCode;
	/**
	 * 污水排水去向类型：
	 */
	private String sewageDrainageDirection;
	/**
	 * 污水受纳水体名称：
	 */
	private String sewageReceivingBodyName;
	/**
	 * 污水受纳水体代码：
	 */
	private String sewageReceivingBodyCode;
	/**
	 * 17.有无集中生活污水处理厂
	 */
	private String isDomesticSewageTreatmentPlant;
	/**
	 * 18.集中式生活污水处理厂名称
	 */
	private String domesticSewageTreatmentPlantName;
	/**
	 * 18.集中式生活污水处理厂统一社会信用代码
	 */
	private String domesticSewageTreatmentPlantCode;
	/**
	 * 18.集中式生活污水处理厂原组织机构代码号：
	 */
	private String domesticSewageTreatmentPlantOrganizational;
	/**
	 * 19.有无集中工业污水处理厂
	 */
	private String isIndustrialSewageTreatmentPlant;
	/**
	 * 20.集中式生活污水处理厂名称
	 */
	private String industrialSewageTreatmentPlantName;
	/**
	 * 20.集中式生活污水处理厂统一社会信用代码
	 */
	private String industrialSewageTreatmentPlantCode;
	/**
	 * 20.集中式生活污水处理厂原组织机构代码号：
	 */
	private String industrialSewageTreatmentPlantOrganizational;
	/**
	 * 20.接入的工业企业数量（家）：
	 */
	private String industrialSewageTreatmentPlantEnterprisesNumber;
	/**
	 * 21.有无集中危险废物处置厂
	 */
	private String isHazardousWasteDisposalPlant;
	/**
	 * 22.集中危险废物处置厂名称
	 */
	private String hazardousWasteDisposalPlantName;
	/**
	 * 22.集中危险废物处置厂统一社会信用代码
	 */
	private String hazardousWasteDisposalPlantCode;
	/**
	 * 22.集中危险废物处置厂原组织机构代码号：
	 */
	private String hazardousWasteDisposalPlantOrganizational;
	/**
	 * 23.有无集中供热设施
	 */
	private String isHeatingFacilities;
	/**
	 * 24.集中供热单位名称
	 */
	private String heatingFacilitiesName;
	/**
	 * 24.集中供热单位统一社会信用代码
	 */
	private String heatingFacilitiesCode;
	/**
	 * 24.集中式供热单位原组织机构代码号：
	 */
	private String heatingFacilitiesOrganizational;
	/**
	 * 25.园区环境管理机构名称
	 */
	private String zoneEnvironmentalManagementInstitutionName;
	/**
	 * 26.一企一档建设
	 */
	private String archives;
	/**
	 * 27.大气环境自动监测站点是否联网
	 */
	private String airMonitoringStationInternet;
	/**
	 * 27.大气环境自动监测站点（可多选）
	 */
	private String airMonitoringStationPoints;
	/**
	 * 28.水环境自动监测站点是否联网
	 */
	private String waterMonitoringStationInternet;
	/**
	 * 28.水环境自动监测站点（可多选）
	 */
	private String waterMonitoringStationPoints;
	/**
	 * 29.编制园区应急预案
	 */
	private String zoneEmergencyPlan;
	/**
	 * 30.污染源信息公开平台
	 */
	private String informationOpenPlatform;
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
	 * 备注
	 */
	private String remarks;

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
	 * 设置：01.园区名称
	 */
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	/**
	 * 获取：01.园区名称
	 */
	public String getZoneName() {
		return zoneName;
	}
	/**
	 * 设置：02.园区代码
	 */
	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}
	/**
	 * 获取：02.园区代码
	 */
	public String getZoneCode() {
		return zoneCode;
	}
	/**
	 * 设置：03.区划代码
	 */
	public void setCompartmentCode(String compartmentCode) {
		this.compartmentCode = compartmentCode;
	}
	/**
	 * 获取：03.区划代码
	 */
	public String getCompartmentCode() {
		return compartmentCode;
	}
	/**
	 * 设置：04.详细地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：04.详细地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：所属省份
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：所属省份
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：所属地市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：所属地市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：所属区县
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：所属区县
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：乡镇
	 */
	public void setTown(String town) {
		this.town = town;
	}
	/**
	 * 获取：乡镇
	 */
	public String getTown() {
		return town;
	}
	/**
	 * 设置：街道
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * 获取：街道
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * 设置：07.园区级别
	 */
	public void setZoneLevel(String zoneLevel) {
		this.zoneLevel = zoneLevel;
	}
	/**
	 * 获取：07.园区级别
	 */
	public String getZoneLevel() {
		return zoneLevel;
	}
	/**
	 * 设置：08.园区类型(行业类型)
	 */
	public void setZoneTypeIndustry(String zoneTypeIndustry) {
		this.zoneTypeIndustry = zoneTypeIndustry;
	}
	/**
	 * 获取：08.园区类型(行业类型)
	 */
	public String getZoneTypeIndustry() {
		return zoneTypeIndustry;
	}
	/**
	 * 设置：08.园区类型(综合类)
	 */
	public void setZoneTypeComprehensive(String zoneTypeComprehensive) {
		this.zoneTypeComprehensive = zoneTypeComprehensive;
	}
	/**
	 * 获取：08.园区类型(综合类)
	 */
	public String getZoneTypeComprehensive() {
		return zoneTypeComprehensive;
	}
	/**
	 * 设置：09.批准面积（公顷）
	 */
	public void setApprovedArea(String approvedArea) {
		this.approvedArea = approvedArea;
	}
	/**
	 * 获取：09.批准面积（公顷）
	 */
	public String getApprovedArea() {
		return approvedArea;
	}
	/**
	 * 设置：10.批准部门
	 */
	public void setApprovedDept(String approvedDept) {
		this.approvedDept = approvedDept;
	}
	/**
	 * 获取：10.批准部门
	 */
	public String getApprovedDept() {
		return approvedDept;
	}
	/**
	 * 设置：11.批准时间
	 */
	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}
	/**
	 * 获取：11.批准时间
	 */
	public String getApprovedDate() {
		return approvedDate;
	}
	/**
	 * 设置：12.企业数量（家）注册工业企业数量：
	 */
	public void setEnterprisesNumber(String enterprisesNumber) {
		this.enterprisesNumber = enterprisesNumber;
	}
	/**
	 * 获取：12.企业数量（家）注册工业企业数量：
	 */
	public String getEnterprisesNumber() {
		return enterprisesNumber;
	}
	/**
	 * 设置：12.企业数量（家）园区内实际生产的企业数量：
	 */
	public void setActualEnterprisesNumber(String actualEnterprisesNumber) {
		this.actualEnterprisesNumber = actualEnterprisesNumber;
	}
	/**
	 * 获取：12.企业数量（家）园区内实际生产的企业数量：
	 */
	public String getActualEnterprisesNumber() {
		return actualEnterprisesNumber;
	}
	/**
	 * 设置：13.主导行业一名称
	 */
	public void setLeadingIndustryName1(String leadingIndustryName1) {
		this.leadingIndustryName1 = leadingIndustryName1;
	}
	/**
	 * 获取：13.主导行业一名称
	 */
	public String getLeadingIndustryName1() {
		return leadingIndustryName1;
	}
	/**
	 * 设置：13.主导行业一代码
	 */
	public void setLeadingIndustryCode1(String leadingIndustryCode1) {
		this.leadingIndustryCode1 = leadingIndustryCode1;
	}
	/**
	 * 获取：13.主导行业一代码
	 */
	public String getLeadingIndustryCode1() {
		return leadingIndustryCode1;
	}
	/**
	 * 设置：13.主导行业一产值占比（%）
	 */
	public void setLeadingIndustryPercent1(String leadingIndustryPercent1) {
		this.leadingIndustryPercent1 = leadingIndustryPercent1;
	}
	/**
	 * 获取：13.主导行业一产值占比（%）
	 */
	public String getLeadingIndustryPercent1() {
		return leadingIndustryPercent1;
	}
	/**
	 * 设置：13.主导行业二名称
	 */
	public void setLeadingIndustryName2(String leadingIndustryName2) {
		this.leadingIndustryName2 = leadingIndustryName2;
	}
	/**
	 * 获取：13.主导行业二名称
	 */
	public String getLeadingIndustryName2() {
		return leadingIndustryName2;
	}
	/**
	 * 设置：13.主导行业二代码
	 */
	public void setLeadingIndustryCode2(String leadingIndustryCode2) {
		this.leadingIndustryCode2 = leadingIndustryCode2;
	}
	/**
	 * 获取：13.主导行业二代码
	 */
	public String getLeadingIndustryCode2() {
		return leadingIndustryCode2;
	}
	/**
	 * 设置：13.主导行业二产值占比（%）
	 */
	public void setLeadingIndustryPercent2(String leadingIndustryPercent2) {
		this.leadingIndustryPercent2 = leadingIndustryPercent2;
	}
	/**
	 * 获取：13.主导行业二产值占比（%）
	 */
	public String getLeadingIndustryPercent2() {
		return leadingIndustryPercent2;
	}
	/**
	 * 设置：13.主导行业三名称
	 */
	public void setLeadingIndustryName3(String leadingIndustryName3) {
		this.leadingIndustryName3 = leadingIndustryName3;
	}
	/**
	 * 获取：13.主导行业三名称
	 */
	public String getLeadingIndustryName3() {
		return leadingIndustryName3;
	}
	/**
	 * 设置：13.主导行业三代码
	 */
	public void setLeadingIndustryCode3(String leadingIndustryCode3) {
		this.leadingIndustryCode3 = leadingIndustryCode3;
	}
	/**
	 * 获取：13.主导行业三代码
	 */
	public String getLeadingIndustryCode3() {
		return leadingIndustryCode3;
	}
	/**
	 * 设置：13.主导行业三产值占比（%）
	 */
	public void setLeadingIndustryPercent3(String leadingIndustryPercent3) {
		this.leadingIndustryPercent3 = leadingIndustryPercent3;
	}
	/**
	 * 获取：13.主导行业三产值占比（%）
	 */
	public String getLeadingIndustryPercent3() {
		return leadingIndustryPercent3;
	}
	/**
	 * 设置：14.是否清污分流
	 */
	public void setIsSewageDiversion(String isSewageDiversion) {
		this.isSewageDiversion = isSewageDiversion;
	}
	/**
	 * 获取：14.是否清污分流
	 */
	public String getIsSewageDiversion() {
		return isSewageDiversion;
	}
	/**
	 * 设置：清水排水去向类型：
	 */
	public void setClearWaterDrainageDirection(String clearWaterDrainageDirection) {
		this.clearWaterDrainageDirection = clearWaterDrainageDirection;
	}
	/**
	 * 获取：清水排水去向类型：
	 */
	public String getClearWaterDrainageDirection() {
		return clearWaterDrainageDirection;
	}
	/**
	 * 设置：清水受纳水体名称：
	 */
	public void setClearWaterReceivingBodyName(String clearWaterReceivingBodyName) {
		this.clearWaterReceivingBodyName = clearWaterReceivingBodyName;
	}
	/**
	 * 获取：清水受纳水体名称：
	 */
	public String getClearWaterReceivingBodyName() {
		return clearWaterReceivingBodyName;
	}
	/**
	 * 设置：清水受纳水体代码：
	 */
	public void setClearWaterReceivingBodyCode(String clearWaterReceivingBodyCode) {
		this.clearWaterReceivingBodyCode = clearWaterReceivingBodyCode;
	}
	/**
	 * 获取：清水受纳水体代码：
	 */
	public String getClearWaterReceivingBodyCode() {
		return clearWaterReceivingBodyCode;
	}
	/**
	 * 设置：污水排水去向类型：
	 */
	public void setSewageDrainageDirection(String sewageDrainageDirection) {
		this.sewageDrainageDirection = sewageDrainageDirection;
	}
	/**
	 * 获取：污水排水去向类型：
	 */
	public String getSewageDrainageDirection() {
		return sewageDrainageDirection;
	}
	/**
	 * 设置：污水受纳水体名称：
	 */
	public void setSewageReceivingBodyName(String sewageReceivingBodyName) {
		this.sewageReceivingBodyName = sewageReceivingBodyName;
	}
	/**
	 * 获取：污水受纳水体名称：
	 */
	public String getSewageReceivingBodyName() {
		return sewageReceivingBodyName;
	}
	/**
	 * 设置：污水受纳水体代码：
	 */
	public void setSewageReceivingBodyCode(String sewageReceivingBodyCode) {
		this.sewageReceivingBodyCode = sewageReceivingBodyCode;
	}
	/**
	 * 获取：污水受纳水体代码：
	 */
	public String getSewageReceivingBodyCode() {
		return sewageReceivingBodyCode;
	}
	/**
	 * 设置：17.有无集中生活污水处理厂
	 */
	public void setIsDomesticSewageTreatmentPlant(String isDomesticSewageTreatmentPlant) {
		this.isDomesticSewageTreatmentPlant = isDomesticSewageTreatmentPlant;
	}
	/**
	 * 获取：17.有无集中生活污水处理厂
	 */
	public String getIsDomesticSewageTreatmentPlant() {
		return isDomesticSewageTreatmentPlant;
	}
	/**
	 * 设置：18.集中式生活污水处理厂名称
	 */
	public void setDomesticSewageTreatmentPlantName(String domesticSewageTreatmentPlantName) {
		this.domesticSewageTreatmentPlantName = domesticSewageTreatmentPlantName;
	}
	/**
	 * 获取：18.集中式生活污水处理厂名称
	 */
	public String getDomesticSewageTreatmentPlantName() {
		return domesticSewageTreatmentPlantName;
	}
	/**
	 * 设置：18.集中式生活污水处理厂统一社会信用代码
	 */
	public void setDomesticSewageTreatmentPlantCode(String domesticSewageTreatmentPlantCode) {
		this.domesticSewageTreatmentPlantCode = domesticSewageTreatmentPlantCode;
	}
	/**
	 * 获取：18.集中式生活污水处理厂统一社会信用代码
	 */
	public String getDomesticSewageTreatmentPlantCode() {
		return domesticSewageTreatmentPlantCode;
	}
	/**
	 * 设置：18.集中式生活污水处理厂原组织机构代码号：
	 */
	public void setDomesticSewageTreatmentPlantOrganizational(String domesticSewageTreatmentPlantOrganizational) {
		this.domesticSewageTreatmentPlantOrganizational = domesticSewageTreatmentPlantOrganizational;
	}
	/**
	 * 获取：18.集中式生活污水处理厂原组织机构代码号：
	 */
	public String getDomesticSewageTreatmentPlantOrganizational() {
		return domesticSewageTreatmentPlantOrganizational;
	}
	/**
	 * 设置：19.有无集中工业污水处理厂
	 */
	public void setIsIndustrialSewageTreatmentPlant(String isIndustrialSewageTreatmentPlant) {
		this.isIndustrialSewageTreatmentPlant = isIndustrialSewageTreatmentPlant;
	}
	/**
	 * 获取：19.有无集中工业污水处理厂
	 */
	public String getIsIndustrialSewageTreatmentPlant() {
		return isIndustrialSewageTreatmentPlant;
	}
	/**
	 * 设置：20.集中式生活污水处理厂名称
	 */
	public void setIndustrialSewageTreatmentPlantName(String industrialSewageTreatmentPlantName) {
		this.industrialSewageTreatmentPlantName = industrialSewageTreatmentPlantName;
	}
	/**
	 * 获取：20.集中式生活污水处理厂名称
	 */
	public String getIndustrialSewageTreatmentPlantName() {
		return industrialSewageTreatmentPlantName;
	}
	/**
	 * 设置：20.集中式生活污水处理厂统一社会信用代码
	 */
	public void setIndustrialSewageTreatmentPlantCode(String industrialSewageTreatmentPlantCode) {
		this.industrialSewageTreatmentPlantCode = industrialSewageTreatmentPlantCode;
	}
	/**
	 * 获取：20.集中式生活污水处理厂统一社会信用代码
	 */
	public String getIndustrialSewageTreatmentPlantCode() {
		return industrialSewageTreatmentPlantCode;
	}
	/**
	 * 设置：20.集中式生活污水处理厂原组织机构代码号：
	 */
	public void setIndustrialSewageTreatmentPlantOrganizational(String industrialSewageTreatmentPlantOrganizational) {
		this.industrialSewageTreatmentPlantOrganizational = industrialSewageTreatmentPlantOrganizational;
	}
	/**
	 * 获取：20.集中式生活污水处理厂原组织机构代码号：
	 */
	public String getIndustrialSewageTreatmentPlantOrganizational() {
		return industrialSewageTreatmentPlantOrganizational;
	}
	/**
	 * 设置：20.接入的工业企业数量（家）：
	 */
	public void setIndustrialSewageTreatmentPlantEnterprisesNumber(String industrialSewageTreatmentPlantEnterprisesNumber) {
		this.industrialSewageTreatmentPlantEnterprisesNumber = industrialSewageTreatmentPlantEnterprisesNumber;
	}
	/**
	 * 获取：20.接入的工业企业数量（家）：
	 */
	public String getIndustrialSewageTreatmentPlantEnterprisesNumber() {
		return industrialSewageTreatmentPlantEnterprisesNumber;
	}
	/**
	 * 设置：21.有无集中危险废物处置厂
	 */
	public void setIsHazardousWasteDisposalPlant(String isHazardousWasteDisposalPlant) {
		this.isHazardousWasteDisposalPlant = isHazardousWasteDisposalPlant;
	}
	/**
	 * 获取：21.有无集中危险废物处置厂
	 */
	public String getIsHazardousWasteDisposalPlant() {
		return isHazardousWasteDisposalPlant;
	}
	/**
	 * 设置：22.集中危险废物处置厂名称
	 */
	public void setHazardousWasteDisposalPlantName(String hazardousWasteDisposalPlantName) {
		this.hazardousWasteDisposalPlantName = hazardousWasteDisposalPlantName;
	}
	/**
	 * 获取：22.集中危险废物处置厂名称
	 */
	public String getHazardousWasteDisposalPlantName() {
		return hazardousWasteDisposalPlantName;
	}
	/**
	 * 设置：22.集中危险废物处置厂统一社会信用代码
	 */
	public void setHazardousWasteDisposalPlantCode(String hazardousWasteDisposalPlantCode) {
		this.hazardousWasteDisposalPlantCode = hazardousWasteDisposalPlantCode;
	}
	/**
	 * 获取：22.集中危险废物处置厂统一社会信用代码
	 */
	public String getHazardousWasteDisposalPlantCode() {
		return hazardousWasteDisposalPlantCode;
	}
	/**
	 * 设置：22.集中危险废物处置厂原组织机构代码号：
	 */
	public void setHazardousWasteDisposalPlantOrganizational(String hazardousWasteDisposalPlantOrganizational) {
		this.hazardousWasteDisposalPlantOrganizational = hazardousWasteDisposalPlantOrganizational;
	}
	/**
	 * 获取：22.集中危险废物处置厂原组织机构代码号：
	 */
	public String getHazardousWasteDisposalPlantOrganizational() {
		return hazardousWasteDisposalPlantOrganizational;
	}
	/**
	 * 设置：23.有无集中供热设施
	 */
	public void setIsHeatingFacilities(String isHeatingFacilities) {
		this.isHeatingFacilities = isHeatingFacilities;
	}
	/**
	 * 获取：23.有无集中供热设施
	 */
	public String getIsHeatingFacilities() {
		return isHeatingFacilities;
	}
	/**
	 * 设置：24.集中供热单位名称
	 */
	public void setHeatingFacilitiesName(String heatingFacilitiesName) {
		this.heatingFacilitiesName = heatingFacilitiesName;
	}
	/**
	 * 获取：24.集中供热单位名称
	 */
	public String getHeatingFacilitiesName() {
		return heatingFacilitiesName;
	}
	/**
	 * 设置：24.集中供热单位统一社会信用代码
	 */
	public void setHeatingFacilitiesCode(String heatingFacilitiesCode) {
		this.heatingFacilitiesCode = heatingFacilitiesCode;
	}
	/**
	 * 获取：24.集中供热单位统一社会信用代码
	 */
	public String getHeatingFacilitiesCode() {
		return heatingFacilitiesCode;
	}
	/**
	 * 设置：24.集中式供热单位原组织机构代码号：
	 */
	public void setHeatingFacilitiesOrganizational(String heatingFacilitiesOrganizational) {
		this.heatingFacilitiesOrganizational = heatingFacilitiesOrganizational;
	}
	/**
	 * 获取：24.集中式供热单位原组织机构代码号：
	 */
	public String getHeatingFacilitiesOrganizational() {
		return heatingFacilitiesOrganizational;
	}
	/**
	 * 设置：25.园区环境管理机构名称
	 */
	public void setZoneEnvironmentalManagementInstitutionName(String zoneEnvironmentalManagementInstitutionName) {
		this.zoneEnvironmentalManagementInstitutionName = zoneEnvironmentalManagementInstitutionName;
	}
	/**
	 * 获取：25.园区环境管理机构名称
	 */
	public String getZoneEnvironmentalManagementInstitutionName() {
		return zoneEnvironmentalManagementInstitutionName;
	}
	/**
	 * 设置：26.一企一档建设
	 */
	public void setArchives(String archives) {
		this.archives = archives;
	}
	/**
	 * 获取：26.一企一档建设
	 */
	public String getArchives() {
		return archives;
	}
	/**
	 * 设置：27.大气环境自动监测站点是否联网
	 */
	public void setAirMonitoringStationInternet(String airMonitoringStationInternet) {
		this.airMonitoringStationInternet = airMonitoringStationInternet;
	}
	/**
	 * 获取：27.大气环境自动监测站点是否联网
	 */
	public String getAirMonitoringStationInternet() {
		return airMonitoringStationInternet;
	}
	/**
	 * 设置：27.大气环境自动监测站点（可多选）
	 */
	public void setAirMonitoringStationPoints(String airMonitoringStationPoints) {
		this.airMonitoringStationPoints = airMonitoringStationPoints;
	}
	/**
	 * 获取：27.大气环境自动监测站点（可多选）
	 */
	public String getAirMonitoringStationPoints() {
		return airMonitoringStationPoints;
	}
	/**
	 * 设置：28.水环境自动监测站点是否联网
	 */
	public void setWaterMonitoringStationInternet(String waterMonitoringStationInternet) {
		this.waterMonitoringStationInternet = waterMonitoringStationInternet;
	}
	/**
	 * 获取：28.水环境自动监测站点是否联网
	 */
	public String getWaterMonitoringStationInternet() {
		return waterMonitoringStationInternet;
	}
	/**
	 * 设置：28.水环境自动监测站点（可多选）
	 */
	public void setWaterMonitoringStationPoints(String waterMonitoringStationPoints) {
		this.waterMonitoringStationPoints = waterMonitoringStationPoints;
	}
	/**
	 * 获取：28.水环境自动监测站点（可多选）
	 */
	public String getWaterMonitoringStationPoints() {
		return waterMonitoringStationPoints;
	}
	/**
	 * 设置：29.编制园区应急预案
	 */
	public void setZoneEmergencyPlan(String zoneEmergencyPlan) {
		this.zoneEmergencyPlan = zoneEmergencyPlan;
	}
	/**
	 * 获取：29.编制园区应急预案
	 */
	public String getZoneEmergencyPlan() {
		return zoneEmergencyPlan;
	}
	/**
	 * 设置：30.污染源信息公开平台
	 */
	public void setInformationOpenPlatform(String informationOpenPlatform) {
		this.informationOpenPlatform = informationOpenPlatform;
	}
	/**
	 * 获取：30.污染源信息公开平台
	 */
	public String getInformationOpenPlatform() {
		return informationOpenPlatform;
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
}
