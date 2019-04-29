package com.tengdi.environmentalprotectionint.modules.online.service.impl;

import com.tengdi.environmentalprotectionint.modules.online.dao.OnlineTableRetrieveDao;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineTableRetrieveEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineTableRetrieveService;
import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("onlineTableRetrieveService")
public class OnlineTableRetrieveServiceImpl extends ServiceImpl<OnlineTableRetrieveDao, OnlineTableRetrieveEntity> implements OnlineTableRetrieveService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String onlineTableRetrieveName = (String)params.get("onlineTableRetrieveName");
        Page<OnlineTableRetrieveEntity> page = this.selectPage(
                new Query<OnlineTableRetrieveEntity>(params).getPage(),
                new EntityWrapper<OnlineTableRetrieveEntity>()
                        .like(StringUtils.isNotBlank(onlineTableRetrieveName),"onlineTableRetrieveName", onlineTableRetrieveName)
        );

        return new PageUtils(page);
    }

    @Override
    public OnlineTableRetrieveEntity dataById(String mid) {
        return baseMapper.dataById(mid);
    }

    @Override
    public OnlineTableRetrieveEntity dataByCid(Map map) {
        return baseMapper.dataByCid(map);
    }



    @Override
    public List<Map<String, Object>> queryPortTable(Map map){
        JSONArray jsonArr = new JSONArray();
        List<Map<String, Object>> list  ;

        list  = baseMapper.queryPortTable(map);
        return  list ;
    }


}
