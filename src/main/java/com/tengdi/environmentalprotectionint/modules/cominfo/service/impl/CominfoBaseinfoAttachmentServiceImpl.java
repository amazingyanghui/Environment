package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysDictService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoBaseinfoAttachmentDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoAttachmentEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoBaseinfoAttachmentService;


@Service("cominfoBaseinfoAttachmentService")
public class CominfoBaseinfoAttachmentServiceImpl extends ServiceImpl<CominfoBaseinfoAttachmentDao, CominfoBaseinfoAttachmentEntity> implements CominfoBaseinfoAttachmentService {
    @Autowired
    SysDictService sysDictService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String cominfoBaseinfoAttachmentName = (String)params.get("cominfoBaseinfoAttachmentName");
        String cid=(String)params.get("cid");
        String fileType=(String)params.get("fileType");
        Page<CominfoBaseinfoAttachmentEntity> page = this.selectPage(
                new Query<CominfoBaseinfoAttachmentEntity>(params).getPage(),
                new EntityWrapper<CominfoBaseinfoAttachmentEntity>()
                        .eq(StringUtils.isNotBlank(cid),"cid",cid)
                        .eq(StringUtils.isNotBlank(fileType),"file_type",fileType)
                        .like(StringUtils.isNotBlank(cominfoBaseinfoAttachmentName),"cominfoBaseinfoAttachmentName", cominfoBaseinfoAttachmentName)
        );
        List<CominfoBaseinfoAttachmentEntity> list=page.getRecords();
        for(CominfoBaseinfoAttachmentEntity attachmentEntity:list){
            SysDictEntity entity = new SysDictEntity();
            entity.setType("attachment_type");
            entity.setKey(attachmentEntity.getFileType());
            String value = sysDictService.getDictValue(entity);
            attachmentEntity.setFileTypeValue(value);
        }
        return new PageUtils(page);
    }

}
