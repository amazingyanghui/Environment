package com.tengdi.environmentalprotectionint.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.sys.entity.SysApprovalUnitEntity;
import java.util.List;
import java.util.Map;

/**
 * 审批单位字典表
 *
 * @author tengdi
 * @email 
 * @date 2018-10-18 12:00:20
 */
public interface SysApprovalUnitService extends IService<SysApprovalUnitEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<SelectEntity> selectList();
}

