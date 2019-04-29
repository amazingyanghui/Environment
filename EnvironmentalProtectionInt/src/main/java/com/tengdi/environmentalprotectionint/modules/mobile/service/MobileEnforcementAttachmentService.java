package com.tengdi.environmentalprotectionint.modules.mobile.service;


import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.mobile.entity.MobileEnforcementAttachmentEntity;
import com.tengdi.core.utils.PageUtils;


import java.util.List;
import java.util.Map;

/**
 * 现场检查附件信息
 *
 * @author tengdi
 * @email
 * @date 2018-09-10 11:08:54
 */
public interface MobileEnforcementAttachmentService extends IService<MobileEnforcementAttachmentEntity> {

    PageUtils queryPage(Map<String, Object> params);
    /**
     * 根据考核情况id查附件
     * @param map
     * @return
     */
    List<MobileEnforcementAttachmentEntity> dataByFile(Map<String,Object> map);
}


