package com.tengdi.environmentalprotectionint.modules.radioactiveore.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 伴生放射性矿产企业含放射性固体物料及废物情况
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-12 14:52:38
 */
@TableName("cominfo_radioactive_ore")
public class CominfoRadioactiveOreEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键（UUID）
	 */
	@TableId
	private String pid;
	/**
	 * 企业ID
	 */
	private String cid;
	/**
	 * 年度
	 */
	private String year;
	/**
	 * 原矿
	 */
	private String rawOre;
	/**
	 * 原矿产生量
	 */
	private String rawOreQuantity;
	/**
	 * 精矿
	 */
	private String concentrate;
	/**
	 * 精矿产生量
	 */
	private String concentrateQuantity;
	/**
	 * 固体废物
	 */
	private String solidWaste;
	/**
	 * 固体废物产生量
	 */
	private String solidWasteQuantity;
	/**
	 * 固体废物综合利用量
	 */
	private String solidWasteUtilize;
	/**
	 * 内部综合利用量
	 */
	private String solidWasteInnerUtilize;
	/**
	 * 送外部综合利用量
	 */
	private String solidWasteOuterUtilize;
	/**
	 * 接收外来固体废物综合利用量
	 */
	private String solidWasteReceiveUtilize;
	/**
	 * 固体废物处理处置量
	 */
	private String solidWasteDeal;
	/**
	 * 固体废物内部处理处置量
	 */
	private String solidWasteInnerDeal;
	/**
	 * 固体废物送外部处理处置量
	 */
	private String solidWasteOuterDeal;
	/**
	 * 接收外来固体废物处理处置量
	 */
	private String solidWasteReceiveDeal;
	/**
	 * 固体废物累计贮存量
	 */
	private String solidWasteStorage;
	/**
	 * 备注
	 */
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
	 * 设置：主键（UUID）
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：主键（UUID）
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
	 * 设置：原矿
	 */
	public void setRawOre(String rawOre) {
		this.rawOre = rawOre;
	}
	/**
	 * 获取：原矿
	 */
	public String getRawOre() {
		return rawOre;
	}
	/**
	 * 设置：原矿产生量
	 */
	public void setRawOreQuantity(String rawOreQuantity) {
		this.rawOreQuantity = rawOreQuantity;
	}
	/**
	 * 获取：原矿产生量
	 */
	public String getRawOreQuantity() {
		return rawOreQuantity;
	}
	/**
	 * 设置：精矿
	 */
	public void setConcentrate(String concentrate) {
		this.concentrate = concentrate;
	}
	/**
	 * 获取：精矿
	 */
	public String getConcentrate() {
		return concentrate;
	}
	/**
	 * 设置：精矿产生量
	 */
	public void setConcentrateQuantity(String concentrateQuantity) {
		this.concentrateQuantity = concentrateQuantity;
	}
	/**
	 * 获取：精矿产生量
	 */
	public String getConcentrateQuantity() {
		return concentrateQuantity;
	}
	/**
	 * 设置：固体废物
	 */
	public void setSolidWaste(String solidWaste) {
		this.solidWaste = solidWaste;
	}
	/**
	 * 获取：固体废物
	 */
	public String getSolidWaste() {
		return solidWaste;
	}
	/**
	 * 设置：固体废物产生量
	 */
	public void setSolidWasteQuantity(String solidWasteQuantity) {
		this.solidWasteQuantity = solidWasteQuantity;
	}
	/**
	 * 获取：固体废物产生量
	 */
	public String getSolidWasteQuantity() {
		return solidWasteQuantity;
	}
	/**
	 * 设置：固体废物综合利用量
	 */
	public void setSolidWasteUtilize(String solidWasteUtilize) {
		this.solidWasteUtilize = solidWasteUtilize;
	}
	/**
	 * 获取：固体废物综合利用量
	 */
	public String getSolidWasteUtilize() {
		return solidWasteUtilize;
	}
	/**
	 * 设置：内部综合利用量
	 */
	public void setSolidWasteInnerUtilize(String solidWasteInnerUtilize) {
		this.solidWasteInnerUtilize = solidWasteInnerUtilize;
	}
	/**
	 * 获取：内部综合利用量
	 */
	public String getSolidWasteInnerUtilize() {
		return solidWasteInnerUtilize;
	}
	/**
	 * 设置：送外部综合利用量
	 */
	public void setSolidWasteOuterUtilize(String solidWasteOuterUtilize) {
		this.solidWasteOuterUtilize = solidWasteOuterUtilize;
	}
	/**
	 * 获取：送外部综合利用量
	 */
	public String getSolidWasteOuterUtilize() {
		return solidWasteOuterUtilize;
	}
	/**
	 * 设置：接收外来固体废物综合利用量
	 */
	public void setSolidWasteReceiveUtilize(String solidWasteReceiveUtilize) {
		this.solidWasteReceiveUtilize = solidWasteReceiveUtilize;
	}
	/**
	 * 获取：接收外来固体废物综合利用量
	 */
	public String getSolidWasteReceiveUtilize() {
		return solidWasteReceiveUtilize;
	}
	/**
	 * 设置：固体废物处理处置量
	 */
	public void setSolidWasteDeal(String solidWasteDeal) {
		this.solidWasteDeal = solidWasteDeal;
	}
	/**
	 * 获取：固体废物处理处置量
	 */
	public String getSolidWasteDeal() {
		return solidWasteDeal;
	}
	/**
	 * 设置：固体废物内部处理处置量
	 */
	public void setSolidWasteInnerDeal(String solidWasteInnerDeal) {
		this.solidWasteInnerDeal = solidWasteInnerDeal;
	}
	/**
	 * 获取：固体废物内部处理处置量
	 */
	public String getSolidWasteInnerDeal() {
		return solidWasteInnerDeal;
	}
	/**
	 * 设置：固体废物送外部处理处置量
	 */
	public void setSolidWasteOuterDeal(String solidWasteOuterDeal) {
		this.solidWasteOuterDeal = solidWasteOuterDeal;
	}
	/**
	 * 获取：固体废物送外部处理处置量
	 */
	public String getSolidWasteOuterDeal() {
		return solidWasteOuterDeal;
	}
	/**
	 * 设置：接收外来固体废物处理处置量
	 */
	public void setSolidWasteReceiveDeal(String solidWasteReceiveDeal) {
		this.solidWasteReceiveDeal = solidWasteReceiveDeal;
	}
	/**
	 * 获取：接收外来固体废物处理处置量
	 */
	public String getSolidWasteReceiveDeal() {
		return solidWasteReceiveDeal;
	}
	/**
	 * 设置：固体废物累计贮存量
	 */
	public void setSolidWasteStorage(String solidWasteStorage) {
		this.solidWasteStorage = solidWasteStorage;
	}
	/**
	 * 获取：固体废物累计贮存量
	 */
	public String getSolidWasteStorage() {
		return solidWasteStorage;
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
