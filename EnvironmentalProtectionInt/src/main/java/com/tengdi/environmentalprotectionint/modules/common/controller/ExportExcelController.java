package com.tengdi.environmentalprotectionint.modules.common.controller;

import com.tengdi.environmentalprotectionint.modules.cominfo.service.SysHangyedaimaService;
import com.tengdi.environmentalprotectionint.modules.common.entity.ExportExcelData;
import com.tengdi.environmentalprotectionint.modules.common.service.ExportExcelService;
import com.tengdi.core.constant.CommonConstant;
import com.tengdi.core.utils.*;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

/**
 * 导出Excel
 *
 * @author tengdi
 * @email 
 * @date 2018-08-22 10:03:40
 */
@RestController
@RequestMapping("common/exportExcel")
@Api(tags="导出Excel")
public class ExportExcelController extends BaseController{
    @Autowired
    private ExportExcelService exportExcelService;
    @Autowired
    private SysHangyedaimaService sysHangyedaimaService;
    /**
     * 按照条件查询后,把创建Excel的条件放入excelData,生成Excel
     * @param
     * @return
     */
    @RequestMapping("/export")
    @ApiOperation("按照条件查询后,把创建Excel的条件放入excelData,生成Excel")
    public String export(HttpServletResponse response, HttpServletRequest request, ExportExcelData criterias) throws Exception {
        List<Map<String,Object>> mapList=criterias.getEqualColumns();
        String string="firstGrade,secondGrade,thirdGrade,fourGrade";
        List<Map<String,Object>> equalList=new ArrayList<>();
        if(mapList!=null){
            Map<String,Object> params=new HashMap<>();
            for(Map<String,Object> map:mapList){
                String column= (String)map.get("column");
                if(column!=null){
                    if(!string.contains(column)){
                        equalList.add(map);
                    }else {
                        String value=(String)map.get("value");
                        params.put(column,value);
                    }
                }
            }
            if(!params.isEmpty()){
                List<String> arrayList=sysHangyedaimaService.getIndustryList(params);
                if(arrayList!=null){
                    StringBuffer sb=new StringBuffer();
                    sb.append("(");
                    for(int i=0;i<arrayList.size();i++){
                        if(i==0){
                            String str="FIND_IN_SET("+arrayList.get(i)+",industryids)";
                            sb.append(str);
                        }else {
                            String str=" or "+"FIND_IN_SET("+arrayList.get(i)+",industryids)";
                            sb.append(str);
                        }
                    }
                    sb.append(")");
                    criterias.setBackup(sb.toString());
                }
            }
        }
//        if(equalList.size()>0){
        criterias.setEqualColumns(equalList);
//        }
        PageUtils page = exportExcelService.queryList(criterias);
        List<?> reslut = page.getList();
        List<Map<String,Object>> data = new ArrayList<>();
//        for (Object record : reslut) {
//            Map<String,Object> newRecord = (Map<String,Object>)record;
//            List<SysDictEntity> dicts = sysDictService.selectByMap(new MapUtils().put("type","packingtype"));
//            for (SysDictEntity dict : dicts) {
//                if (newRecord.get("packingtype")!=null && dict.getKey().toString().equals(newRecord.get("packingtype").toString())) {
//                    newRecord.put("packingtype",dict.getValue());
//                }
//            }
//            data.add(newRecord);
//        }
        ExcelData excelData=new ExcelData();
        String []headerList=criterias.getHeaders().split(",");
        String []fieldNames=criterias.getHeaderFields().split(",");
        String title=criterias.getTitle();
        if (StringUtils.isEmpty(title)) {
            title = "导出EXCEL文件";
        }else {
            title = title + "";
        }
        String pattern="yyyy-MM-dd";
        excelData.setTitle(title);
        excelData.setDataset(reslut);
        excelData.setHeaders(headerList);
        excelData.setFieldNames(fieldNames);
        excelData.setPattern(pattern);
        ExportExcelUtils utils=new ExportExcelUtils();
        HSSFWorkbook wb = utils.exportExcel2003(response,excelData,request);
        String filepath = request.getSession().getServletContext().getRealPath("/");
        String fileUploadPath = "/exportfile/";//暂时存在这里
        String fileName = title+ ".xls";
        filepath = java.net.URLDecoder.decode(filepath+fileUploadPath,"utf-8");
        FileUtils.createNewFile(filepath,fileName);
        FileOutputStream output = new FileOutputStream(filepath + File.separator + fileName);
        wb.write(output);
        output.flush();
        output.close();
        JSONObject src = new JSONObject();
        src.put("src",fileUploadPath + fileName);
        JSONObject root = new JSONObject();
        root.put("code", CommonConstant.HTTP_STATUS_OK);
        root.put("data",src);
        return root.toString();
    }

    /**
     * 得到服务器时间
     */
    @GetMapping("/getDate")
    @ApiOperation("得到服务器时间")
    public R getDate(){
        Date date=DateUtils.getDate();
        return R.ok().put("date",date);
    }


}
