package com.tengdi.environmentalprotectionint.modules.sys.service.impl;

import net.sf.json.JSONArray;
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

import com.tengdi.environmentalprotectionint.modules.sys.dao.SysShuiwuranwuDao;
import com.tengdi.environmentalprotectionint.modules.sys.entity.SysShuiwuranwuEntity;
import com.tengdi.environmentalprotectionint.modules.sys.service.SysShuiwuranwuService;


@Service("sysShuiwuranwuService")
public class SysShuiwuranwuServiceImpl extends ServiceImpl<SysShuiwuranwuDao, SysShuiwuranwuEntity> implements SysShuiwuranwuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String sysShuiwuranwuName = (String)params.get("sysShuiwuranwuName");
        Page<SysShuiwuranwuEntity> page = this.selectPage(
                new Query<SysShuiwuranwuEntity>(params).getPage(),
                new EntityWrapper<SysShuiwuranwuEntity>()
                        .like(StringUtils.isNotBlank(sysShuiwuranwuName),"sysShuiwuranwuName", sysShuiwuranwuName)
        );

        return new PageUtils(page);
    }

    @Override
    public JSONArray getShuiWuRan(String code) {
        String[] daiMaZhis = code.split(",");
        List<String> list = new ArrayList<String>();
        for(String daiMaZhi : daiMaZhis){
            list.add(daiMaZhi);
        }
        List<SysShuiwuranwuEntity> daimaList = this.selectList(new EntityWrapper<SysShuiwuranwuEntity>());
        for(SysShuiwuranwuEntity sysdaima : daimaList){
            sysdaima.setNocheck(false);
            sysdaima.setChecked(list.contains(String.valueOf(sysdaima.getDaimazhi().trim())) ? true : false);
        }
        return JSONArray.fromObject(daimaList);
    }

}
