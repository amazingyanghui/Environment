package com.tengdi.environmentalprotectionint.modules.online.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 表名检索表
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-24 10:54:40
 */
@TableName("online_table_retrieve")
public class OnlineTableRetrieveEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键（UUID）
	 */
	@TableId
	private String pid;
	/**
	 * 排口id
	 */
	private String mid;
	/**
	 * 单位id
	 */
	private String cid;
	/**
	 * 小时数据表名
	 */
	private String hdTabName;
	/**
	 * 日数据表名
	 */
	private String ddTabName;

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
	 * 设置：排口id
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}
	/**
	 * 获取：排口id
	 */
	public String getMid() {
		return mid;
	}
	/**
	 * 设置：小时数据表名
	 */
	public void setHdTabName(String hdTabName) {
		this.hdTabName = hdTabName;
	}
	/**
	 * 获取：小时数据表名
	 */
	public String getHdTabName() {
		return hdTabName;
	}
	/**
	 * 设置：日数据表名
	 */
	public void setDdTabName(String ddTabName) {
		this.ddTabName = ddTabName;
	}
	/**
	 * 获取：日数据表名
	 */
	public String getDdTabName() {
		return ddTabName;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
}
