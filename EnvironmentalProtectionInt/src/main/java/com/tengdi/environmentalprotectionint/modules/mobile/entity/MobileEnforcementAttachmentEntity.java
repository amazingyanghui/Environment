package com.tengdi.environmentalprotectionint.modules.mobile.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.tengdi.core.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 现场检查附件信息
 *
 * @author tengdi
 * @email
 * @date 2018-09-10 11:08:54
 */
@TableName("mobile_enforcement_attachment")
public class MobileEnforcementAttachmentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID（UUID）
     */
    @TableId
    private String pid;
    /**
     * 对应的企业(污染源)ID
     */
    private String cid;
    /**
     * 行政处罚id
     */
    private String mid;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 附件大小
     */
    private String attachmentSize;
    /**
     * 附件格式
     */
    private String attachmentFormat;
    /**
     * 附件地址
     */
    private String attachmentUrl;
    /**
     * 上传者
     */
    private String uploadPerson;
    /**
     * 上传时间
     */
    private String uploadTime;
    /**
     * 创建时间
     */
    private Date createdate;
    /**
     * 创建时间，转换String接受
     */
    @TableField(exist = false)
    private String createdateStr;
    public String getCreatedateStr() {
        return  DateUtils.format(createdate);
    }

    public void setCreatedateStr(String createdateStr) {
        this.createdateStr = createdateStr;
    }
    /**
     * 移动执法附件类型（0：现场检查；1：调查询问）
     */
    private Integer type;

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAttachmentSize() {
        return attachmentSize;
    }

    public void setAttachmentSize(String attachmentSize) {
        this.attachmentSize = attachmentSize;
    }

    public String getAttachmentFormat() {
        return attachmentFormat;
    }

    public void setAttachmentFormat(String attachmentFormat) {
        this.attachmentFormat = attachmentFormat;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    public String getUploadPerson() {
        return uploadPerson;
    }

    public void setUploadPerson(String uploadPerson) {
        this.uploadPerson = uploadPerson;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
