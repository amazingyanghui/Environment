package com.tengdi.environmentalprotectionint.modules.sys.service.impl;

import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;

import com.tengdi.environmentalprotectionint.modules.sys.dao.SysApprovalUnitDao;
import com.tengdi.environmentalprotectionint.modules.sys.entity.SysApprovalUnitEntity;
import com.tengdi.environmentalprotectionint.modules.sys.service.SysApprovalUnitService;


@Service("sysApprovalUnitService")
public class SysApprovalUnitServiceImpl extends ServiceImpl<SysApprovalUnitDao, SysApprovalUnitEntity> implements SysApprovalUnitService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String sysApprovalUnitName = (String)params.get("sysApprovalUnitName");
        Page<SysApprovalUnitEntity> page = this.selectPage(
                new Query<SysApprovalUnitEntity>(params).getPage(),
                new EntityWrapper<SysApprovalUnitEntity>()
                        .like(StringUtils.isNotBlank(sysApprovalUnitName),"company_name", sysApprovalUnitName)
        );

        return new PageUtils(page);
    }

    @Override
    public List<SelectEntity> selectList() {
        List<SysApprovalUnitEntity> list=this.selectList(new EntityWrapper<SysApprovalUnitEntity>());
        List<SelectEntity> entityList=new ArrayList<>();
        for(SysApprovalUnitEntity entity:list){
            SelectEntity selectEntity=new SelectEntity();
            selectEntity.setId(entity.getCompanyCode());
            selectEntity.setName(entity.getCompanyName());
            entityList.add(selectEntity);
        }
        return entityList;
    }

}
