package com.tengdi.environmentalprotectionint.modules.online.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 固废产生与利用（危废产生与利用）
 * 
 * @author tengdi
 * @email 
 * @date 2003-07-16 01:03:26
 */
@TableName("online_waste_produce")
public class OnlineWasteProduceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 因子ID(主键UUID)
	 */
	@TableId
	private String pid;
	/**
	 * 企业ID
	 */
	private String cid;

	/**
	 * 固废（危废）处理场所ID
	 */
	private String placeId;
	/**
	 * 分类（0：固体废物；1：危险废物）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer useType;
	/**
	 * 分类名称（0：固体废物；1：危险废物）
	 */
	@TableField(exist = false)
	private String useTypeStr;
	/**
	 * 年度
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String produceYear;
	/**
	 * 废物名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String wasteName;
	/**
	 * 废物种类
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer wasteType;
	/**
	 * 废物种类
	 */
	@TableField(exist = false)
	private String wasteTypeName;

	public String getWasteTypeName() {
		return wasteTypeName;
	}

	public void setWasteTypeName(String wasteTypeName) {
		this.wasteTypeName = wasteTypeName;
	}

	/**
	 * 废物小类代码
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String wasteCode;
	/**
	 * 处置方法
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String disposeMethod;
	/**
	 * 当年产生量（吨）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String yearCount;
	/**
	 * 历年储存总量（吨）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String totalCount;
	/**
	 * 是否属于危险废物
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isWaste;
	/**
	 * 是否属于危险废物name
	 */
	@TableField(exist = false)
	private String isWasteName;
	/**
	 * 是否办理转移联单
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isTransferCouplet;
	/**
	 * 是否办理转移联单name
	 */
	@TableField(exist = false)
	private String isTransferCoupletName;

	public String getIsWasteName() {
		return isWasteName;
	}

	public void setIsWasteName(String isWasteName) {
		this.isWasteName = isWasteName;
	}

	public String getIsTransferCoupletName() {
		return isTransferCoupletName;
	}

	public void setIsTransferCoupletName(String isTransferCoupletName) {
		this.isTransferCoupletName = isTransferCoupletName;
	}

	/**
	 * 储存场所三防设施
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String storeFacilities;
	/**
	 * 处置单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String disposeCompany;
	/**
	 * 备注
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createdate;
	/**
	 * 更新时间
	 */
	private Date updatedate;
	/**
	 * 删除时间
	 */
	private Date deletedate;

	/**
	 * 废物产生量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String wasteProduction;

	/**
	 * 废物综合利用量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String wasteComprehensive;

	/**
	 * 自行综合利用量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String selfComprehensive;

	/**
	 * 综合利用往年贮存量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pastYearsComprehensive;

	/**
	 * 废物处置量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String wasteDisposal;

	/**
	 * 自行处置量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String selfDisposal;

	/**
	 * 处置往年贮存量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String pastYearsDisposal;

	/**
	 * 废物贮存量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String wasteStorage;

	/**
	 * 废物倾倒丢弃量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String wasteDumpingDiscarding;

	/**
	 * 送持证单位量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String sendCertificatesUnitage;

	/**
	 * 接收外来危险废物量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String receiveForeignDangerWaste;

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getWasteProduction() {
		return wasteProduction;
	}

	public void setWasteProduction(String wasteProduction) {
		this.wasteProduction = wasteProduction;
	}

	public String getWasteComprehensive() {
		return wasteComprehensive;
	}

	public void setWasteComprehensive(String wasteComprehensive) {
		this.wasteComprehensive = wasteComprehensive;
	}

	public String getSelfComprehensive() {
		return selfComprehensive;
	}

	public void setSelfComprehensive(String selfComprehensive) {
		this.selfComprehensive = selfComprehensive;
	}

	public String getPastYearsComprehensive() {
		return pastYearsComprehensive;
	}

	public void setPastYearsComprehensive(String pastYearsComprehensive) {
		this.pastYearsComprehensive = pastYearsComprehensive;
	}

	public String getWasteDisposal() {
		return wasteDisposal;
	}

	public void setWasteDisposal(String wasteDisposal) {
		this.wasteDisposal = wasteDisposal;
	}

	public String getSelfDisposal() {
		return selfDisposal;
	}

	public void setSelfDisposal(String selfDisposal) {
		this.selfDisposal = selfDisposal;
	}

	public String getPastYearsDisposal() {
		return pastYearsDisposal;
	}

	public void setPastYearsDisposal(String pastYearsDisposal) {
		this.pastYearsDisposal = pastYearsDisposal;
	}

	public String getWasteStorage() {
		return wasteStorage;
	}

	public void setWasteStorage(String wasteStorage) {
		this.wasteStorage = wasteStorage;
	}

	public String getWasteDumpingDiscarding() {
		return wasteDumpingDiscarding;
	}

	public void setWasteDumpingDiscarding(String wasteDumpingDiscarding) {
		this.wasteDumpingDiscarding = wasteDumpingDiscarding;
	}

	public String getSendCertificatesUnitage() {
		return sendCertificatesUnitage;
	}

	public void setSendCertificatesUnitage(String sendCertificatesUnitage) {
		this.sendCertificatesUnitage = sendCertificatesUnitage;
	}

	public String getReceiveForeignDangerWaste() {
		return receiveForeignDangerWaste;
	}

	public void setReceiveForeignDangerWaste(String receiveForeignDangerWaste) {
		this.receiveForeignDangerWaste = receiveForeignDangerWaste;
	}

	/**
	 * 设置：因子ID(主键UUID)
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：因子ID(主键UUID)
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
	 * 设置：分类（0：固体废物；1：危险废物）
	 */
	public void setUseType(Integer useType) {
		this.useType = useType;
	}
	/**
	 * 获取：分类（0：固体废物；1：危险废物）
	 */
	public Integer getUseType() {
		return useType;
	}
	/**
	 * 设置：年度
	 */
	public void setProduceYear(String produceYear) {
		this.produceYear = produceYear;
	}
	/**
	 * 获取：年度
	 */
	public String getProduceYear() {
		return produceYear;
	}
	/**
	 * 设置：废物名称
	 */
	public void setWasteName(String wasteName) {
		this.wasteName = wasteName;
	}
	/**
	 * 获取：废物名称
	 */
	public String getWasteName() {
		return wasteName;
	}
	/**
	 * 设置：废物种类
	 */
	public void setWasteType(Integer wasteType) {
		this.wasteType = wasteType;
	}
	/**
	 * 获取：废物种类
	 */
	public Integer getWasteType() {
		return wasteType;
	}
	/**
	 * 设置：废物小类代码
	 */
	public void setWasteCode(String wasteCode) {
		this.wasteCode = wasteCode;
	}
	/**
	 * 获取：废物小类代码
	 */
	public String getWasteCode() {
		return wasteCode;
	}
	/**
	 * 设置：处置方法
	 */
	public void setDisposeMethod(String disposeMethod) {
		this.disposeMethod = disposeMethod;
	}
	/**
	 * 获取：处置方法
	 */
	public String getDisposeMethod() {
		return disposeMethod;
	}
	/**
	 * 设置：当年产生量（吨）
	 */
	public void setYearCount(String yearCount) {
		this.yearCount = yearCount;
	}
	/**
	 * 获取：当年产生量（吨）
	 */
	public String getYearCount() {
		return yearCount;
	}
	/**
	 * 设置：历年储存总量（吨）
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * 获取：历年储存总量（吨）
	 */
	public String getTotalCount() {
		return totalCount;
	}
	/**
	 * 设置：是否属于危险废物
	 */
	public void setIsWaste(Integer isWaste) {
		this.isWaste = isWaste;
	}
	/**
	 * 获取：是否属于危险废物
	 */
	public Integer getIsWaste() {
		return isWaste;
	}
	/**
	 * 设置：是否办理转移联单
	 */
	public void setIsTransferCouplet(Integer isTransferCouplet) {
		this.isTransferCouplet = isTransferCouplet;
	}
	/**
	 * 获取：是否办理转移联单
	 */
	public Integer getIsTransferCouplet() {
		return isTransferCouplet;
	}
	/**
	 * 设置：储存场所三防设施
	 */
	public void setStoreFacilities(String storeFacilities) {
		this.storeFacilities = storeFacilities;
	}
	/**
	 * 获取：储存场所三防设施
	 */
	public String getStoreFacilities() {
		return storeFacilities;
	}
	/**
	 * 设置：处置单位
	 */
	public void setDisposeCompany(String disposeCompany) {
		this.disposeCompany = disposeCompany;
	}
	/**
	 * 获取：处置单位
	 */
	public String getDisposeCompany() {
		return disposeCompany;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
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
	 * 设置：更新时间
	 */
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：更新时间
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

	public String getUseTypeStr() {
		return useTypeStr;
	}

	public void setUseTypeStr(String useTypeStr) {
		this.useTypeStr = useTypeStr;
	}
}
