package com.tengdi.environmentalprotectionint.modules.manual.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.environmentalprotectionint.modules.manual.dao.EnvironmentalProtectionManualDao;
import com.tengdi.environmentalprotectionint.modules.manual.entity.EnvironmentalProtectionManualEntity;
import com.tengdi.environmentalprotectionint.modules.manual.entity.LegalDocumentsEntity;
import com.tengdi.environmentalprotectionint.modules.manual.service.EnvironmentalProtectionManualService;
import com.tengdi.core.utils.Query;
import com.tengdi.userauthenuuid.modules.auth.shiro.jwt.UserUtils;
import com.tengdi.userauthenuuid.modules.sys.entity.SysUserEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.tengdi.core.utils.PageUtils;

import javax.servlet.http.HttpServletRequest;

@Service("environmentalProtectionManualService")
public class EnvironmentalProtectionManualServiceImpl extends ServiceImpl<EnvironmentalProtectionManualDao, EnvironmentalProtectionManualEntity> implements EnvironmentalProtectionManualService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        int page =Integer.parseInt((String)params.get("page"));
        int limit =Integer.parseInt((String)params.get("limit"));
        Query query = new Query(params);
        List<EnvironmentalProtectionManualEntity> list =baseMapper.queryPage(query);
        int totalCount =baseMapper.queryPageSum(query);
        return new PageUtils(list,totalCount,limit,page);
    }

    @Override
    public JSONArray getProductionProductionStorageEntityJSONArray(String type) {
        Map map=new HashMap<String, Object>();
        List<EnvironmentalProtectionManualEntity> list=queryList(map);
        return getStorageJsonArray(list,"0",type);
    }

    @Override
    public List<EnvironmentalProtectionManualEntity> queryList(Map<String, Object> params) {
        List<EnvironmentalProtectionManualEntity> deptList =baseMapper.sellist();
//
//        for(EnvironmentalProtectionManualEntity sysDeptEntity : deptList){
//            EnvironmentalProtectionManualEntity parentDeptEntity =  this.selectById(sysDeptEntity.getParentId());
//            if(parentDeptEntity != null){
//                sysDeptEntity.setName(parentDeptEntity.getName());
//            }
//        }
        return deptList;
    }

    @Override
    public JSONArray getStorageJsonArray(List<EnvironmentalProtectionManualEntity> codeList, String parentId, String type) {
        String key1 = "name" , key2 = "pid" , key3 = "children",key4="parentid",key5="storecode";
        if(type.equals("checkboxtree")){
            key1 = "title" ;
            key2 = "value" ;
            key3 = "data";
        }
        JSONArray jsonArr = new JSONArray();
        for(EnvironmentalProtectionManualEntity environmentalProtectionManualEntity : codeList){
            JSONObject jsonObjTemp = new JSONObject();
            if(environmentalProtectionManualEntity.getParentId().equals(parentId)){
                jsonObjTemp.put(key1,environmentalProtectionManualEntity.getCodeName());
                jsonObjTemp.put(key2,environmentalProtectionManualEntity.getPid());
                jsonObjTemp.put(key4,environmentalProtectionManualEntity.getParentId());
                jsonObjTemp.put(key5,environmentalProtectionManualEntity.getStoreCode());
                jsonObjTemp.put(key3,getStorageJsonArray(codeList,environmentalProtectionManualEntity.getPid(),type));
                jsonArr.add(jsonObjTemp);
            }
        }
        return jsonArr;
    }
    /**
     * 获取文件，写入数据库
     */
    @Override
    public void insertFile(LegalDocumentsEntity legalDocumentsEntity) {
        baseMapper.insertFile(legalDocumentsEntity);
    }
    /**
     * 获取HttpServletRequest 请求中token的用户信息
     */
    @Override
     public SysUserEntity getUserByToken(HttpServletRequest request) {
        String token = UserUtils.getToken(request);
        SysUserEntity sysUserEntity = new SysUserEntity();
        if (StringUtils.isEmpty(token)) {
            return sysUserEntity;
        }
        Map<String, String> map = UserUtils.getPoyload(token);
        sysUserEntity.setUserId(map.get("userId"));
        sysUserEntity.setDeptId(map.get("userDeptId"));
        sysUserEntity.setUsername(map.get("userName"));
        return sysUserEntity;
    }
    /**
     * 插入环保手册目录节点（获取节点自增长id）
     */
    @Override
    public String addAndGetId(EnvironmentalProtectionManualEntity productionProductionStorageEntity) {
        long result=baseMapper.addAndGetId(productionProductionStorageEntity);
        return productionProductionStorageEntity.getPid();
    }
    /**
     *根据id更新环保手册法律法规目录-目录编码字段
     */
    @Override
    public void updateCode(EnvironmentalProtectionManualEntity environmentalProtectionManualEntity) {
        baseMapper.updateCode(environmentalProtectionManualEntity);
    }
    /**
     *删除文件
     */
    @Override
    public void dellaw(String[] ids) {
        baseMapper.dellaw(ids);
    }
    /**
     * 查询节点下是否存在子节点
     */
    @Override
    public Map<String,Integer> nodeSel(String pid) {
        int exists;
        Map<String,Object> map =baseMapper.nodeSel(pid);
        int nodeflag=Integer.parseInt(map.get("counts").toString());
        int fileflag=Integer.parseInt(map.get("countst").toString());
        Map<String,Integer> map1=new HashMap<>();
        map1.put("nodeflag",nodeflag);
        map1.put("fileflag",fileflag);
        return map1;
    }
    /**
     * 删除文件
     */
    @Override
    public String delFile(String path) {
        String resultInfo = null;
        File file = new File(path);
        if (file.exists()) {
            if (file.delete()) {
                resultInfo =  "1-删除成功";
            } else {
                resultInfo =  "0-删除失败";
            }
        } else {
            resultInfo = "文件不存在！";
        }
        return resultInfo;
    }
}
