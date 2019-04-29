package com.tengdi.environmentalprotectionint.modules.common.controller;

import com.tengdi.environmentalprotectionint.modules.common.entity.ImportExcelEntity;
import com.tengdi.environmentalprotectionint.modules.common.service.ImportExcelService;
import com.tengdi.environmentalprotectionint.modules.common.utils.ReadExcelUtils;
import com.tengdi.environmentalprotectionint.modules.common.utils.Utils;
import com.tengdi.core.utils.*;
import com.tengdi.userauthenuuid.common.annotation.SysLog;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 导入Excel
 *
 * @author tengdi
 * @email 
 * @date 2018-08-22 10:03:40
 */
@RestController
@RequestMapping("common/importExcel")
@Api(tags="导入Excel")
public class ImportExcelController extends BaseController{
    @Autowired
    private ImportExcelService importExcelService;

    /**
     * 导入Excel，添加数据库
     * @param
     * @return
     */
    @PostMapping("/import/{tableName}")
    @ApiOperation("导入Excel，添加数据库")
    @SysLog("导入Excel，添加数据库")
    @Transactional(rollbackFor = {Exception.class})
    public @ResponseBody
    R export(@RequestParam("file")MultipartFile[] files
            , @PathVariable("tableName")String tableName
            , @RequestParam Map<String,Object> map
            , HttpServletRequest request) throws Exception {
        for(MultipartFile file:files){
            String fileName = file.getOriginalFilename();
            if(!fileName.toLowerCase().endsWith("xls")&!fileName.toLowerCase().endsWith("xlsx")){
                return R.ok().put("msg","请导入Excel！");
            }
            String filePath=request.getSession().getServletContext().getRealPath("/");
            String fileUploadPath = "/import/" + DateUtils.getDate().getTime() + "/";//暂时存在这里
            String fileNewPath=filePath+fileUploadPath;
            String header = request.getHeader("User-Agent").toUpperCase();
            if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {//IE
                fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
            }
            FileUtils.uploadFile(file.getBytes(), fileNewPath, fileName);
            String src=fileNewPath+fileName;
            List<String[]> list=ReadExcelUtils.getExcel(src);

            if(list.size()>0){
                ImportExcelEntity excelEntity=new ImportExcelEntity();
                excelEntity.setTableName(tableName);
                StringBuffer sbf=new StringBuffer();
                String colsName= StringUtils.join(list.get(0),",");
                for(String key : map.keySet()){
                    key=key+",";
                    sbf.append(key);
                }
                sbf.append(colsName);
                excelEntity.setColsName(sbf.toString());
                for(int i=1;i<list.size();i++){
                    String[] colsValue=list.get(i);
                    if(colsValue.length>1){
                        String newValue=" values(#{pid},";
                        StringBuffer sb=new StringBuffer();
                        sb.append(newValue);
                        for (Object value : map.values()) {
                            sb.append("\""+value+ "\",");
                        }
                        for(int j=0;j<colsValue.length;j++){
                            String value="";
                            if(j==0){
                                value= "\"" +colsValue[j]+'"';
                            }else {
                                value=",\""+colsValue[j]+'"';
                            }
                            sb.append(value);
                        }
                        sb.append(")");
                        excelEntity.setColsValue(sb.toString());
                        try {
                            importExcelService.insertData(excelEntity);
                        }catch (Exception e){
                            Utils.delFile(src);
                            return R.ok().put("msg","导入失败！");
                        }
                    }
                }
            }
            Utils.delFile(src);
        }
        return R.ok().put("msg","导入成功！");
    }

}
