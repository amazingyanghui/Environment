package com.tengdi.environmentalprotectionint.modules.radioactive.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;

/**
 * 放射性同位素
 * 
 * @author tengdi
 * @email 
 * @date 2018-09-17 15:44:27
 */
@TableName("radioactive_isotope_info")
public class RadioactiveIsotopeInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键UUID
	 */
	@TableId
	private String pid;
	/**
	 * 对应的污染源（企业）ID
	 */
	private String cid;
	/**
	 * 存放单位
	 */
	@TableField(exist=false)
	private String companyName;
	/**
	 * 核素名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String isotopeName;
	/**
	 * 出厂日期
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String productionDate;
	/**
	 * 出厂活度
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String factoryActivity;
	/**
	 * 生产厂家
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String manufactureFactory;
	/**
	 * 放射性类别
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String radioactiveCategory;
	/**
	 * 放射性类别name
	 */
	@TableField(exist = false)
	private String radioactiveCategoryName;
	/**
	 * 放射源编码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String radioactiveCoding;
	/**
	 * 安装/存储位置
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String storageLocation;
	/**
	 * 最大等效年操作量（Bq）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String maximumOperation;
	/**
	 * 数量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String amount;
	/**
	 * 主要应用用途
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String mainPurpose;
	/**
	 * 目前状况
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer curstatus;
	/**
	 * 目前状况name
	 */
	@TableField(exist = false)
	private String curstatusName;

	public String getRadioactiveCategoryName() {
		return radioactiveCategoryName;
	}

	public void setRadioactiveCategoryName(String radioactiveCategoryName) {
		this.radioactiveCategoryName = radioactiveCategoryName;
	}

	public String getCurstatusName() {
		return curstatusName;
	}

	public void setCurstatusName(String curstatusName) {
		this.curstatusName = curstatusName;
	}

	/**
	 * 对应的用户ID
	 */
	private String person;
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
	 * 设置：对应的污染源（企业）ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：对应的污染源（企业）ID
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：核素名称
	 */
	public void setIsotopeName(String isotopeName) {
		this.isotopeName = isotopeName;
	}
	/**
	 * 获取：核素名称
	 */
	public String getIsotopeName() {
		return isotopeName;
	}
	/**
	 * 设置：出厂日期
	 */
	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}
	/**
	 * 获取：出厂日期
	 */
	public String getProductionDate() {
		return productionDate;
	}
	/**
	 * 设置：出厂活度
	 */
	public void setFactoryActivity(String factoryActivity) {
		this.factoryActivity = factoryActivity;
	}
	/**
	 * 获取：出厂活度
	 */
	public String getFactoryActivity() {
		return factoryActivity;
	}
	/**
	 * 设置：生产厂家
	 */
	public void setManufactureFactory(String manufactureFactory) {
		this.manufactureFactory = manufactureFactory;
	}
	/**
	 * 获取：生产厂家
	 */
	public String getManufactureFactory() {
		return manufactureFactory;
	}
	/**
	 * 设置：放射性类别
	 */
	public void setRadioactiveCategory(String radioactiveCategory) {
		this.radioactiveCategory = radioactiveCategory;
	}
	/**
	 * 获取：放射性类别
	 */
	public String getRadioactiveCategory() {
		return radioactiveCategory;
	}
	/**
	 * 设置：放射源编码
	 */
	public void setRadioactiveCoding(String radioactiveCoding) {
		this.radioactiveCoding = radioactiveCoding;
	}
	/**
	 * 获取：放射源编码
	 */
	public String getRadioactiveCoding() {
		return radioactiveCoding;
	}
	/**
	 * 设置：安装/存储位置
	 */
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}
	/**
	 * 获取：安装/存储位置
	 */
	public String getStorageLocation() {
		return storageLocation;
	}
	/**
	 * 设置：最大等效年操作量（Bq）
	 */
	public void setMaximumOperation(String maximumOperation) {
		this.maximumOperation = maximumOperation;
	}
	/**
	 * 获取：最大等效年操作量（Bq）
	 */
	public String getMaximumOperation() {
		return maximumOperation;
	}
	/**
	 * 设置：数量
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * 获取：数量
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * 设置：主要应用用途
	 */
	public void setMainPurpose(String mainPurpose) {
		this.mainPurpose = mainPurpose;
	}
	/**
	 * 获取：主要应用用途
	 */
	public String getMainPurpose() {
		return mainPurpose;
	}
	/**
	 * 设置：目前状况
	 */
	public void setCurstatus(Integer curstatus) {
		this.curstatus = curstatus;
	}
	/**
	 * 获取：目前状况
	 */
	public Integer getCurstatus() {
		return curstatus;
	}
	/**
	 * 设置：对应的用户ID
	 */
	public void setPerson(String person) {
		this.person = person;
	}
	/**
	 * 获取：对应的用户ID
	 */
	public String getPerson() {
		return person;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
