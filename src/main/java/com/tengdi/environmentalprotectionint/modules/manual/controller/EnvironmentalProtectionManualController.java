package com.tengdi.environmentalprotectionint.modules.manual.controller;


import com.tengdi.environmentalprotectionint.modules.manual.entity.EnvironmentalProtectionManualEntity;
import com.tengdi.environmentalprotectionint.modules.manual.entity.LegalDocumentsEntity;
import com.tengdi.environmentalprotectionint.modules.manual.service.EnvironmentalProtectionManualService;
import com.tengdi.environmentalprotectionint.modules.common.utils.Utils;
import com.tengdi.core.utils.*;
import java.io.*;
import java.util.Arrays;
import java.util.Map;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import com.tengdi.userauthenuuid.modules.sys.entity.SysUserEntity;
import net.sf.json.JSONArray;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;


/**
 * 环保手册
 *
 * @author tengdi
 * @email 
 * @date 2018-10-08 09:44:23
 */
@RestController
@RequestMapping("manual/environmentalprotectionmanual")
@Api(tags="环保手册")
public class EnvironmentalProtectionManualController extends BaseController{
    @Autowired
    private EnvironmentalProtectionManualService environmentalProtectionManualService;


//    /**
//     * 信息
//     */
//    @GetMapping("/{id}")
//    @ApiOperation("信息")
//    public R info(@PathVariable("id") Integer id){
//       EnvironmentalProtectionManualEntity environmentalProtectionManual = environmentalProtectionManualService.selectById(id);
//
//        return R.ok().put("environmentalProtectionManual", environmentalProtectionManual);
//    }
    /**
     * 环保手册-树目录列表（查询）
     */
    @GetMapping("/getLawTree")
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation("选择仓库")
    public R getStorageTree(){
        JSONArray lawTree = environmentalProtectionManualService.getProductionProductionStorageEntityJSONArray("onlytree");
        return R.ok().put("lawTree", lawTree);
    }

    /**
     * 环保手册-树目录节点位置（保存）
     */
    @PostMapping("/saveManualTree")
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation("环保手册-目录节点位置（保存）")
    public R saveManualTree(@RequestBody EnvironmentalProtectionManualEntity environmentalProtectionManual){
        String uuid=UUIDTool.getUUID();
        environmentalProtectionManual.setPid(uuid);
        environmentalProtectionManual.setStatus(1);
        environmentalProtectionManual.setCreateDate(DateUtils.getDate());
        String  parentId=environmentalProtectionManual.getParentId();
        String id=environmentalProtectionManualService.addAndGetId(environmentalProtectionManual);
        if(parentId.equals("0")){
            environmentalProtectionManual.setStoreCode(id+"-");
            environmentalProtectionManualService.updateCode(environmentalProtectionManual);
        }else {
            String searchCondition=environmentalProtectionManualService.selectById(parentId).getStoreCode();
            System.out.println(searchCondition);
            environmentalProtectionManual.setStoreCode(searchCondition+id+"-");
            environmentalProtectionManualService.updateCode(environmentalProtectionManual);
        }
        return R.ok().put("environmentalProtectionManual",environmentalProtectionManual);
    }

//    /**
//     * 修改
//     */
//    @PutMapping
//    @ApiOperation("修改")
//    public R update(@RequestBody EnvironmentalProtectionManualEntity environmentalProtectionManual){
//        ValidatorUtils.validateEntity(environmentalProtectionManual, UpdateGroup.class);
//        environmentalProtectionManual.setUpdatedate(DateUtils.getDate());
//        environmentalProtectionManualService.updateById(environmentalProtectionManual);
//
//        return R.ok();
//    }

    /**
     * 环保手册-树目录节点位置(删除)
     */
    @DeleteMapping
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation("删除")
    public R delete(@RequestBody String[] ids){
        environmentalProtectionManualService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    /**
     * 查询节点下是否存在子节点
     */
    @GetMapping("nodeSel/{pid}")
    @ApiOperation("查询节点下是否存在子节点")
    public R nodeSel(@PathVariable("pid") String pid){
        Map<String,Integer> map= environmentalProtectionManualService.nodeSel(pid);
        R rew =new R();
        if(map.get("nodeflag")>0){
            rew.put("code",0);
            rew.put("msg","该节点下存在子节点，无法删除！");
            return rew;
        }else{
            if(map.get("fileflag")>0){
                rew.put("code",0);
                rew.put("msg","该节点下存在文件，无法删除！");
                return rew;
            }else{
                return R.ok().put("usercount",0);
            }
        }
    }
    /**
     * 环保手册-法律法规文件列表（查询）
     */
    @GetMapping
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation("环保手册-法律法规文件列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = environmentalProtectionManualService.queryPage(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }
    /**
     * 环保手册-法律法规文件列表（删除）
     */
    @DeleteMapping("/dellaw")
    @ApiOperation("删除")
    public R dellaw(@RequestBody String[] ids){
        environmentalProtectionManualService.dellaw(ids);
        return R.ok();
    }
    /**
     * 获取文件，写入数据库
     */
    @PostMapping("/test")
    @ApiOperation("获取文件，写入数据库")
    public R  filetest(@RequestParam("file") MultipartFile file,
                          @RequestParam(value = "code") String code,
                          HttpServletRequest request) throws Exception {
        if(code.equals("")){
            R rest=new R();
            rest.put("code",-1);
            rest.put("msg","请选择节点后再上传文件");
            return rest;
        }
        //上传文件
        String fileName = file.getOriginalFilename();
        String filePath = request.getSession().getServletContext().getRealPath("/");
        String fileUploadPath = "/uploadfile/" + code + "/" + DateUtils.getDate().getTime() + "/";//暂时存在这里
        String filePathnew = filePath + fileUploadPath;
        FileUtils.uploadFile(file.getBytes(), filePathnew, fileName);
        //生成预览文件上传
        String originalFileHtml = filePathnew + File.separator + "show.html";
        if (fileName.endsWith("doc")||fileName.endsWith("docx")) {
            PoiWordToHtmlUtil.wordToHtml(filePathnew+fileName,originalFileHtml);
        }
        if (fileName.endsWith("xls")||fileName.endsWith("xlsx")) {
            PoiExcelToHtmlUtil.excelToHtml(filePathnew+fileName, originalFileHtml);
        }
        //读取文件内容写入数据库
        File f = null;
        String contentStr ="";
        String image = fileName.substring(fileName.lastIndexOf(".")+1);
        if(file.equals("")||file.getSize()<=0){
            R rest=new R();
            rest.put("code",-1);
            rest.put("msg","请不要上传空文件");
            return rest;
        }else{
            InputStream ins = file.getInputStream();
            f=new File(file.getOriginalFilename());
            try {
                OutputStream os = new FileOutputStream(f);
                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                if(image.equals("pdf")) {
                    PDDocument document = PDDocument.load(f);
                    PDFTextStripper stripper = new PDFTextStripper();
                    stripper.setSortByPosition(false);
                    contentStr= stripper.getText(document);
                    System.out.println(contentStr);
                    document.close();
                }
                if(image.equals("doc")){
                    try {
                        FileInputStream fis = new FileInputStream(f);
                        HWPFDocument doc = new HWPFDocument(fis);
                        contentStr = doc.getDocumentText();
                        System.out.println(contentStr);
                        fis.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if(image.equals("docx")){
                    try {
                        FileInputStream fis = new FileInputStream(f);
                        XWPFDocument xdoc = new XWPFDocument(fis);
                        XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
                        contentStr = extractor.getText();
                        System.out.println(contentStr);
                        fis.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if(image.equals("text")||image.equals("txt")){
                    StringBuffer content = new StringBuffer();
                    try{
                        InputStreamReader isr = new InputStreamReader(new FileInputStream(f), "GBK");
                        BufferedReader read = new BufferedReader(isr);
                        String  str="";
                        while((str=read.readLine())!=null){
                            contentStr+=str+"\r\n";
                        }
                        System.out.println(contentStr);
                        read.close();
                    }catch(Exception e){
                        e.printStackTrace();

                    }
                }
                os.close();
                ins.close();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                File del = new File(f.toURI());
                del.delete();
            }
        }
        LegalDocumentsEntity legalDocumentsEntity= new LegalDocumentsEntity();
        //获取文件内容
        legalDocumentsEntity.setContent(contentStr);
        //获取文件名称
        legalDocumentsEntity.setFileName(file.getOriginalFilename());
        //获取文件大小
        legalDocumentsEntity.setFileSize(Utils.getFormatSize(file.getSize()));
        //获取文件的上传者
        SysUserEntity sysUserEntity = environmentalProtectionManualService.getUserByToken(request);
        legalDocumentsEntity.setHeir(sysUserEntity.getUsername());
        //获取文件的路径
        String srcnewpath = fileUploadPath + fileName;
        legalDocumentsEntity.setPath(srcnewpath);
        //获取文件的创建时间
        legalDocumentsEntity.setCreateTime(DateUtils.getDate());
        //获取文件的编码
        legalDocumentsEntity.setCode(code);
        //获取文件的id
        legalDocumentsEntity.setPid(UUIDTool.getUUID());
        environmentalProtectionManualService.insertFile(legalDocumentsEntity);
        return R.ok();
    }
}
