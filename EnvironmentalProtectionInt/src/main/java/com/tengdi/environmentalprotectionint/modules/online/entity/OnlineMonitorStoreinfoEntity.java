package com.tengdi.environmentalprotectionint.modules.online.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 企业数据存放信息表
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:52:02
 */
@TableName("online_monitor_storeinfo")
public class OnlineMonitorStoreinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键UUID
	 */
	@TableId
	private String pid;
	/**
	 * 对应企业信息表中的【企业ID】
	 */
	private String cid;
	/**
	 * 对应排口信息表中的【监控点ID】
	 */
	private String ipid;
	/**
	 * 小时数据存放表
	 */
	private String hdTabname;
	/**
	 * 日数据存放表
	 */
	private String ddTabname;

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
	 * 设置：对应企业信息表中的【企业ID】
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：对应企业信息表中的【企业ID】
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：对应排口信息表中的【监控点ID】
	 */
	public void setIpid(String ipid) {
		this.ipid = ipid;
	}
	/**
	 * 获取：对应排口信息表中的【监控点ID】
	 */
	public String getIpid() {
		return ipid;
	}
	/**
	 * 设置：小时数据存放表
	 */
	public void setHdTabname(String hdTabname) {
		this.hdTabname = hdTabname;
	}
	/**
	 * 获取：小时数据存放表
	 */
	public String getHdTabname() {
		return hdTabname;
	}
	/**
	 * 设置：日数据存放表
	 */
	public void setDdTabname(String ddTabname) {
		this.ddTabname = ddTabname;
	}
	/**
	 * 获取：日数据存放表
	 */
	public String getDdTabname() {
		return ddTabname;
	}
}
