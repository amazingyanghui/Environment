package com.tengdi.environmentalprotectionint.modules.online.service.impl;

import com.tengdi.environmentalprotectionint.modules.online.dao.OnlineWasteProduceDao;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineWasteProduceEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineWasteProduceService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;


@Service("onlineWasteProduceService")
public class OnlineWasteProduceServiceImpl extends ServiceImpl<OnlineWasteProduceDao, OnlineWasteProduceEntity> implements OnlineWasteProduceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        int page =Integer.parseInt((String)params.get("page"));
        int limit =Integer.parseInt((String)params.get("limit"));
        Query query = new Query(params);
        List<OnlineWasteProduceEntity> list =baseMapper.queryPage(query);
        int totalCount =baseMapper.queryPageCom(params);
        return new PageUtils(list,totalCount,limit,page);
    }

}
