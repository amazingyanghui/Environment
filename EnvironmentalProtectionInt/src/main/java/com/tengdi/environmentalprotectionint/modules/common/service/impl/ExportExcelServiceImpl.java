package com.tengdi.environmentalprotectionint.modules.common.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.SysHangyedaimaEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.SysHangyedaimaService;
import com.tengdi.environmentalprotectionint.modules.common.dao.ExportExcelDao;
import com.tengdi.environmentalprotectionint.modules.common.entity.ExportExcelData;
import com.tengdi.environmentalprotectionint.modules.common.service.ExportExcelService;
import com.tengdi.core.utils.MapUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysDictService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.codec.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("exportExcelService")
public class ExportExcelServiceImpl extends ServiceImpl<ExportExcelDao, ExportExcelData> implements ExportExcelService {

    @Autowired
    private SysDictService sysDictService;
    @Autowired
    private SysHangyedaimaService sysHangyedaimaService;

    @Override
    public PageUtils queryList(ExportExcelData criterias) {
        Integer limit = criterias.getLimit();
        Integer page = criterias.getPage();
        if(limit==null){
            limit=1;
        }
        Integer offset = (page-1) * limit;
        criterias.setPagenumber(offset);
        criterias.setPagesize(limit);
        List<Map<String,Object>> list;
        int count;
        // 非汇总表调用普通通用查询接口
        if (StringUtils.isEmpty(criterias.getSumCols())) {
            list = baseMapper.queryList(criterias);
            count = baseMapper.queryListCount(criterias);
        }else {
            list = baseMapper.querySumList(criterias);
            count = baseMapper.querySumListCount(criterias);
        }
        if (criterias.isShowXh()==true) {
            // 增加序号
            Integer xh = offset + 1;
            for (Map<String,Object> entity : list) {
                entity.put("xh",xh);
                xh++;
            }
        }
        return new PageUtils(addUnit(list),count,limit,page);
    }

    @Override
    public String getLawEnforcementType(String lawEnforcementType) {
        String[] lawEnforcementTypeName=lawEnforcementType.split(",");
        List<String> strList = new ArrayList<String>();
        for(String str : lawEnforcementTypeName){
            strList.add(str);
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<strList.size();i++){
            List<SysDictEntity> sysDictList=sysDictService.selectByMap(new MapUtils().put("`key`", strList.get(i)).put("type","law_enforcement_type_type"));
            if(sysDictList.size()>0){
                if(sb.length()>0){
                    sb.append(",");
                }
                sb.append(sysDictList.get(0).getValue());
            }
        }
        return String.valueOf(sb);
    }

    private List<Map<String,Object>> addUnit(List<Map<String,Object>> list){
        list = MapUtils.convertKeyToLowerCase(list);
        //处理二位小数和加重量单位、字典
        for (Map<String,Object> obj :list){
            Object contractMoney = obj.get("contractmoney");
            if (contractMoney!=null) {
                obj.put("contractmoney",String.format("%.2f", contractMoney));
            }

            Object law_enforcement_type = obj.get("lawenforcementtype");
            if(law_enforcement_type!=null){
                String lawEnforcementType=(String)law_enforcement_type;
                String string=getLawEnforcementType(lawEnforcementType);
                obj.put("lawenforcementtype",string);

            }

            Object industryids = obj.get("industryids");
            if(industryids!=null){
                String industry=(String)industryids;
                String[] daiMaZhis =  industry.split(",");
                List<String> strList = new ArrayList<String>();
                for(String daiMaZhi : daiMaZhis){
                    strList.add(daiMaZhi);
                }
                StringBuffer sb=new StringBuffer();
                for(int i=0;i<strList.size();i++){
                    List<SysHangyedaimaEntity> daimaList=sysHangyedaimaService.selectByMap(new MapUtils().put("DaiMaZhi", strList.get(i)));
                    if(daimaList.size()>0){
                        if(sb.length()>0){
                            sb.append(",");
                        }
                        sb.append(daimaList.get(0).getMingcheng());
                    }
                }
                obj.put("industryids",sb);

            }
        //用户账号密码密文转明文
            Object password = obj.get("password");
            if(password!=null){
                String password_ =Base64.decodeToString((String)password);
                obj.put("password",password_);
            }
        }
        return list;
    }

}
