package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;

/**
 * 基本信息
 *
 * @author tengdi
 * @email
 * @date 2018-08-02 17:43:40
 */
@TableName("cominfo_baseinfo")
public class CominfoBaseinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * UUID主键
	 */
	@TableId
	private String pid;
	/**
	 * 污染源名称（公司名称）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String companyName;
	/**
	 * 公司法人代表
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String companyRepresentative;
	/**
	 *  法人联系电话
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String representativePhone;
	/**
	 * 环保联系人
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String environmentalProtectionName;
	/**
	 * 环保联系人电话
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String environmentalProtectionPhone;
	/**
	 * 环保联系人手机
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String environmentalProtectionMobile;
	/**
	 * 统一社会信用代码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String unifiedSocialCreditCode;
	/**
	 * 组织机构代码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String organizationCode;
	/**
	 * 营业执照代码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String businessLicenseCode;
	/**
	 * 污染源类别代码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pollutionSourceCategory;
	/**
	 * 污染源类别中文
	 */
	@TableField(exist = false)
	private String pollutionSourceCategoryText;
	/**
	 * 是否重点
	 */
	@TableField(exist = false)
	private String keySourceText;
	/**
	 * 所属行业
	 */
	@TableField(exist = false)
	private String industry;
	/**
	 * 所属行业IDS
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String industryids;
	/**
	 * 所属地市（数据字典）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String localCity;
	/**
	 * 所属区县（数据字典）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String districtAndCounty;
	/**
	 * 所属街道/乡镇（数据字典）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String streetOrTown;
	/**
	 * 污染源地址
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String companyAddress;
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
	 * 是否挂牌督办
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String supervise;
	/**
	 * 是否挂牌督办name
	 */
	@TableField(exist = false)
	private String superviseName;
	/**
	 * 是否在生态区
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String ecologicArea;
	/**
	 * 是否在生态区name
	 */
	@TableField(exist = false)
	private String ecologicAreaName;
	/**
	 * 是否约谈企业
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String talk;
	/**
	 * 是否约谈企业
	 */
	@TableField(exist = false)
	private String talkName;

	/**
	 * 注册生成用户名
	 * @return
	 */
	@TableField(exist = false)
	private String usernamecode;

    /**
     *单位简称
     * @return
     */
	@TableField(fill = FieldFill.INSERT_UPDATE)
    private String unitAbbreviation;
    /**
     *公司是否上市
     * @return
     */
	@TableField(fill = FieldFill.INSERT_UPDATE)
    private String quotedCompany;
    /**
     *是否有子公司
     * @return
     */
	@TableField(fill = FieldFill.INSERT_UPDATE)
    private String isSubsidiaryCompany;
    /**
     *子公司名称
     * @return
     */
	@TableField(fill = FieldFill.INSERT_UPDATE)
    private String subsidiaryCompanyname;

	public String getSuperviseName() {
		return superviseName;
	}

	public void setSuperviseName(String superviseName) {
		this.superviseName = superviseName;
	}

	public String getEcologicAreaName() {
		return ecologicAreaName;
	}

	public void setEcologicAreaName(String ecologicAreaName) {
		this.ecologicAreaName = ecologicAreaName;
	}

	public String getTalkName() {
		return talkName;
	}

	public void setTalkName(String talkName) {
		this.talkName = talkName;
	}

	/**
	 * 污染源介绍
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String companyIntroduction;
	/**
	 * 隶属关系	（数据字典）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String affiliation;
	/**
	 * 隶属关系name
	 */
	@TableField(exist = false)
	private String affiliationName;
	/**
	 * 登记注册类型（数据字典）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String registrationType;
	/**
	 * 登记注册类型name
	 */
	@TableField(exist = false)
	private String registrationTypeName;
	/**
	 * 企业规模（数据字典）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String enterpriseScale;
	/**
	 * 企业规模name
	 */
	@TableField(exist = false)
	private String enterpriseScaleName;

	public String getAffiliationName() {
		return affiliationName;
	}

	public void setAffiliationName(String affiliationName) {
		this.affiliationName = affiliationName;
	}

	public String getRegistrationTypeName() {
		return registrationTypeName;
	}

	public void setRegistrationTypeName(String registrationTypeName) {
		this.registrationTypeName = registrationTypeName;
	}

	public String getEnterpriseScaleName() {
		return enterpriseScaleName;
	}

	public void setEnterpriseScaleName(String enterpriseScaleName) {
		this.enterpriseScaleName = enterpriseScaleName;
	}

	/**
	 * 所在工业园区
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String industrialArea;
	/**
	 * 电子邮箱
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String email;
	/**
	 * 传真号码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String faxNumber;
	/**
	 * 邮政编码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String postalCode;
	/**
	 * 网址
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String website;
	/**
	 * 总投资
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String totalInvestment;
	/**
	 * 环保投资
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String environmentalInvestment;
	/**
	 * 开户银行
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String bankOfDeposit;
	/**
	 * 银行账号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String bankAccount;
	/**
	 * 员工人数
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String numberOfEmployees;
	/**
	 * 生产状态
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String productionState;
	/**
	 * 生产状态
	 */
	@TableField(exist = false)
	private String productionStateName;

	public String getProductionStateName() {
		return productionStateName;
	}

	public void setProductionStateName(String productionStateName) {
		this.productionStateName = productionStateName;
	}

	/**
	 * 开业时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String openingDate;
	/**
	 * 停业时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String stopDate;
	/**
	 * 总占地面积
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String totalArea;
	/**
	 * 厂区面积
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String factoryArea;
	/**
	 * 最新改扩建时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String latestDate;
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
	 * 工业产值
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String industryOutputValue;
	/**
	 * 工业增加值
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String industryValueAdded;
	/**
	 * 排污强度
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pollutionIntensity;

	public String getIndustryOutputValue() {
		return industryOutputValue;
	}

	public void setIndustryOutputValue(String industryOutputValue) {
		this.industryOutputValue = industryOutputValue;
	}

	public String getIndustryValueAdded() {
		return industryValueAdded;
	}

	public void setIndustryValueAdded(String industryValueAdded) {
		this.industryValueAdded = industryValueAdded;
	}

	public String getPollutionIntensity() {
		return pollutionIntensity;
	}

	public void setPollutionIntensity(String pollutionIntensity) {
		this.pollutionIntensity = pollutionIntensity;
	}

	/**
	 * 风险等级
	 */
	@TableField(exist = false)
	private String riskRating;

	/**
	 * 监控级别
	 */
	@TableField(exist = false)
	private String regulatoryLevel;

	/**
	 * 评估年份
	 */
	@TableField(exist = false)
	private String regulatoryYear;

	/**
	 * 评估年份
	 */
	@TableField(exist = false)
	private String regulatoryYearName;

	/**
	 * 风险等级
	 */
	@TableField(exist = false)
	private String riskRatingName;

	/**
	 * username
	 * @return
	 */
	@TableField(exist = false)
	private String username;
	public String getRegulatoryYearName() {
		return regulatoryYearName;
	}

	public void setRegulatoryYearName(String regulatoryYearName) {
		this.regulatoryYearName = regulatoryYearName;
	}

	public String getRiskRatingName() {
		return riskRatingName;
	}

	public void setRiskRatingName(String riskRatingName) {
		this.riskRatingName = riskRatingName;
	}

	public String getPollutionSourceCategoryText() {
		return pollutionSourceCategoryText;
	}

	public void setPollutionSourceCategoryText(String pollutionSourceCategoryText) {
		this.pollutionSourceCategoryText = pollutionSourceCategoryText;
	}

	public String getKeySourceText() {
		return keySourceText;
	}

	public void setKeySourceText(String keySourceText) {
		this.keySourceText = keySourceText;
	}

	public String getIndustryids() {
		return industryids;
	}

	public void setIndustryids(String industryids) {
		this.industryids = industryids;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getRegulatoryLevel() {
		return regulatoryLevel;
	}

	public void setRegulatoryLevel(String regulatoryLevel) {
		this.regulatoryLevel = regulatoryLevel;
	}

	public String getRiskRating() {
		return riskRating;
	}

	public void setRiskRating(String riskRating) {
		this.riskRating = riskRating;
	}

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
	 * 设置：污染源名称（公司名称）
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：污染源名称（公司名称）
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：公司法人代表
	 */
	public void setCompanyRepresentative(String companyRepresentative) {
		this.companyRepresentative = companyRepresentative;
	}
	/**
	 * 获取：公司法人代表
	 */
	public String getCompanyRepresentative() {
		return companyRepresentative;
	}
	/**
	 * 设置： 法人联系电话
	 */
	public void setRepresentativePhone(String representativePhone) {
		this.representativePhone = representativePhone;
	}
	/**
	 * 获取： 法人联系电话
	 */
	public String getRepresentativePhone() {
		return representativePhone;
	}
	/**
	 * 设置：环保联系人
	 */
	public void setEnvironmentalProtectionName(String environmentalProtectionName) {
		this.environmentalProtectionName = environmentalProtectionName;
	}
	/**
	 * 获取：环保联系人
	 */
	public String getEnvironmentalProtectionName() {
		return environmentalProtectionName;
	}
	/**
	 * 设置：环保联系人电话
	 */
	public void setEnvironmentalProtectionPhone(String environmentalProtectionPhone) {
		this.environmentalProtectionPhone = environmentalProtectionPhone;
	}
	/**
	 * 获取：环保联系人电话
	 */
	public String getEnvironmentalProtectionPhone() {
		return environmentalProtectionPhone;
	}
	/**
	 * 设置：环保联系人手机
	 */
	public void setEnvironmentalProtectionMobile(String environmentalProtectionMobile) {
		this.environmentalProtectionMobile = environmentalProtectionMobile;
	}
	/**
	 * 获取：环保联系人手机
	 */
	public String getEnvironmentalProtectionMobile() {
		return environmentalProtectionMobile;
	}
	/**
	 * 设置：统一社会信用代码
	 */
	public void setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
		this.unifiedSocialCreditCode = unifiedSocialCreditCode;
	}
	/**
	 * 获取：统一社会信用代码
	 */
	public String getUnifiedSocialCreditCode() {
		return unifiedSocialCreditCode;
	}
	/**
	 * 设置：组织机构代码
	 */
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	/**
	 * 获取：组织机构代码
	 */
	public String getOrganizationCode() {
		return organizationCode;
	}
	/**
	 * 设置：营业执照代码
	 */
	public void setBusinessLicenseCode(String businessLicenseCode) {
		this.businessLicenseCode = businessLicenseCode;
	}
	/**
	 * 获取：营业执照代码
	 */
	public String getBusinessLicenseCode() {
		return businessLicenseCode;
	}
	/**
	 * 设置：污染源类别
	 */
	public void setPollutionSourceCategory(String pollutionSourceCategory) {
		this.pollutionSourceCategory = pollutionSourceCategory;
	}
	/**
	 * 获取：污染源类别
	 */
	public String getPollutionSourceCategory() {
		return pollutionSourceCategory;
	}
	/**
	 * 设置：所属地市（数据字典）
	 */
	public void setLocalCity(String localCity) {
		this.localCity = localCity;
	}
	/**
	 * 获取：所属地市（数据字典）
	 */
	public String getLocalCity() {
		return localCity;
	}
	/**
	 * 设置：所属区县（数据字典）
	 */
	public void setDistrictAndCounty(String districtAndCounty) {
		this.districtAndCounty = districtAndCounty;
	}
	/**
	 * 获取：所属区县（数据字典）
	 */
	public String getDistrictAndCounty() {
		return districtAndCounty;
	}
	/**
	 * 设置：所属街道/乡镇（数据字典）
	 */
	public void setStreetOrTown(String streetOrTown) {
		this.streetOrTown = streetOrTown;
	}
	/**
	 * 获取：所属街道/乡镇（数据字典）
	 */
	public String getStreetOrTown() {
		return streetOrTown;
	}
	/**
	 * 设置：污染源地址
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	/**
	 * 获取：污染源地址
	 */
	public String getCompanyAddress() {
		return companyAddress;
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
	 * 设置：是否挂牌督办
	 */
	public void setSupervise(String supervise) {
		this.supervise = supervise;
	}
	/**
	 * 获取：是否挂牌督办
	 */
	public String getSupervise() {
		return supervise;
	}
	/**
	 * 设置：是否在生态区
	 */
	public void setEcologicArea(String ecologicArea) {
		this.ecologicArea = ecologicArea;
	}
	/**
	 * 获取：是否在生态区
	 */
	public String getEcologicArea() {
		return ecologicArea;
	}
	/**
	 * 设置：是否约谈企业
	 */
	public void setTalk(String talk) {
		this.talk = talk;
	}
	/**
	 * 获取：是否约谈企业
	 */
	public String getTalk() {
		return talk;
	}
	/**
	 * 设置：污染源介绍
	 */
	public void setCompanyIntroduction(String companyIntroduction) {
		this.companyIntroduction = companyIntroduction;
	}
	/**
	 * 获取：污染源介绍
	 */
	public String getCompanyIntroduction() {
		return companyIntroduction;
	}
	/**
	 * 设置：隶属关系	（数据字典）
	 */
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	/**
	 * 获取：隶属关系	（数据字典）
	 */
	public String getAffiliation() {
		return affiliation;
	}
	/**
	 * 设置：登记注册类型（数据字典）
	 */
	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}
	/**
	 * 获取：登记注册类型（数据字典）
	 */
	public String getRegistrationType() {
		return registrationType;
	}
	/**
	 * 设置：企业规模（数据字典）
	 */
	public void setEnterpriseScale(String enterpriseScale) {
		this.enterpriseScale = enterpriseScale;
	}
	/**
	 * 获取：企业规模（数据字典）
	 */
	public String getEnterpriseScale() {
		return enterpriseScale;
	}
	/**
	 * 设置：所在工业园区
	 */
	public void setIndustrialArea(String industrialArea) {
		this.industrialArea = industrialArea;
	}
	/**
	 * 获取：所在工业园区
	 */
	public String getIndustrialArea() {
		return industrialArea;
	}
	/**
	 * 设置：电子邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：电子邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：传真号码
	 */
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	/**
	 * 获取：传真号码
	 */
	public String getFaxNumber() {
		return faxNumber;
	}
	/**
	 * 设置：邮政编码
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * 获取：邮政编码
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * 设置：网址
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	/**
	 * 获取：网址
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * 设置：总投资
	 */
	public void setTotalInvestment(String totalInvestment) {
		this.totalInvestment = totalInvestment;
	}
	/**
	 * 获取：总投资
	 */
	public String getTotalInvestment() {
		return totalInvestment;
	}
	/**
	 * 设置：环保投资
	 */
	public void setEnvironmentalInvestment(String environmentalInvestment) {
		this.environmentalInvestment = environmentalInvestment;
	}
	/**
	 * 获取：环保投资
	 */
	public String getEnvironmentalInvestment() {
		return environmentalInvestment;
	}
	/**
	 * 设置：开户银行
	 */
	public void setBankOfDeposit(String bankOfDeposit) {
		this.bankOfDeposit = bankOfDeposit;
	}
	/**
	 * 获取：开户银行
	 */
	public String getBankOfDeposit() {
		return bankOfDeposit;
	}
	/**
	 * 设置：银行账号
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	/**
	 * 获取：银行账号
	 */
	public String getBankAccount() {
		return bankAccount;
	}
	/**
	 * 设置：员工人数
	 */
	public void setNumberOfEmployees(String numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
	/**
	 * 获取：员工人数
	 */
	public String getNumberOfEmployees() {
		return numberOfEmployees;
	}
	/**
	 * 设置：生产状态
	 */
	public void setProductionState(String productionState) {
		this.productionState = productionState;
	}
	/**
	 * 获取：生产状态
	 */
	public String getProductionState() {
		return productionState;
	}

	/**
	 * 设置：总占地面积
	 */
	public void setTotalArea(String totalArea) {
		this.totalArea = totalArea;
	}
	/**
	 * 获取：总占地面积
	 */
	public String getTotalArea() {
		return totalArea;
	}
	/**
	 * 设置：厂区面积
	 */
	public void setFactoryArea(String factoryArea) {
		this.factoryArea = factoryArea;
	}
	/**
	 * 获取：厂区面积
	 */
	public String getFactoryArea() {
		return factoryArea;
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

	public String getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	public String getStopDate() {
		return stopDate;
	}

	public void setStopDate(String stopDate) {
		this.stopDate = stopDate;
	}

	public String getLatestDate() {
		return latestDate;
	}

	public void setLatestDate(String latestDate) {
		this.latestDate = latestDate;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String getDeletedate() {
		return deletedate;
	}

	public void setDeletedate(String deletedate) {
		this.deletedate = deletedate;
	}

	public String getRegulatoryYear() {
		return regulatoryYear;
	}

	public void setRegulatoryYear(String regulatoryYear) {
		this.regulatoryYear = regulatoryYear;
	}


	public String getUsernamecode() {
		return usernamecode;
	}

	public void setUsernamecode(String usernamecode) {
		this.usernamecode = usernamecode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    public String getUnitAbbreviation() {
        return unitAbbreviation;
    }

    public void setUnitAbbreviation(String unitAbbreviation) {
        this.unitAbbreviation = unitAbbreviation;
    }

    public String getQuotedCompany() {
        return quotedCompany;
    }

    public void setQuotedCompany(String quotedCompany) {
        this.quotedCompany = quotedCompany;
    }

    public String getIsSubsidiaryCompany() {
        return isSubsidiaryCompany;
    }

    public void setIsSubsidiaryCompany(String isSubsidiaryCompany) {
        this.isSubsidiaryCompany = isSubsidiaryCompany;
    }

    public String getSubsidiaryCompanyname() {
        return subsidiaryCompanyname;
    }

    public void setSubsidiaryCompanyname(String subsidiaryCompanyname) {
        this.subsidiaryCompanyname = subsidiaryCompanyname;
    }
}
