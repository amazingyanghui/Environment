package com.tengdi.environmentalprotectionint.modules.cominfo.controller;

import com.tengdi.environmentalprotectionint.modules.building.entity.BuildingProjectAttachmentEntity;
import com.tengdi.environmentalprotectionint.modules.building.service.BuildingProjectAttachmentService;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoTotalControlplanFileEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoTotalControlplanFileService;
import com.tengdi.environmentalprotectionint.modules.common.utils.Utils;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemDrillFileEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemPlanFileEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemDrillFileService;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemPlanFileService;
import com.tengdi.environmentalprotectionint.modules.mobile.entity.MobileEnforcementAttachmentEntity;
import com.tengdi.environmentalprotectionint.modules.mobile.service.MobileEnforcementAttachmentService;
import com.tengdi.environmentalprotectionint.modules.penalty.entity.AdministrativePenaltyFileEntity;
import com.tengdi.environmentalprotectionint.modules.penalty.service.AdministrativePenaltyFileService;
import com.tengdi.core.constant.CommonConstant;
import com.tengdi.core.utils.*;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;

import java.io.*;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import com.tengdi.userauthenuuid.modules.sys.entity.SysUserEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoAttachmentEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoBaseinfoAttachmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 污染源（企业）附件
 *
 * @author tengdi
 * @email 
 * @date 2018-08-24 15:29:14
 */
@RestController
@RequestMapping("cominfo/cominfobaseinfoattachment")
@Api(tags="污染源（企业）附件")
public class CominfoBaseinfoAttachmentController extends BaseController{
    @Autowired
    private CominfoBaseinfoAttachmentService cominfoBaseinfoAttachmentService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private BuildingProjectAttachmentService buildingProjectAttachmentService;
    @Autowired
    private AdministrativePenaltyFileService administrativePenaltyFileService;
    @Autowired
    private EmergencySystemDrillFileService emergencySystemDrillFileService;
    @Autowired
    private EmergencySystemPlanFileService emergencySystemPlanFileService;
    @Autowired
    private MobileEnforcementAttachmentService mobileEnforcementAttachmentService;
    @Autowired
    private CominfoTotalControlplanFileService cominfoTotalControlplanFileService;

    private static String UPLOAD_TYPE_SINGLE = "1";

    /**
     * @param files
     * @param type 上传的文件种类（0:企业照片；1：组织机构证书；2：治理设施照片；3：排污口照片；4：环境信访附件;5:建设项目附件；
     *             6:行政处罚附件;7:排污许可证附件;8:工艺流程图；9：建设项目附件;10:行政处罚附件;11:应急预案；12：应急演练；13：废水排放情况照片；14：废气排放情况照片；15：VOCs排放情况照片；16：考核情况附件;17:控制计划附件）
     * @return
     */
    @PostMapping("/upload/{type}")
    public @ResponseBody
    String upload(@RequestParam("file") MultipartFile[] files,
                  @PathVariable("type") Integer type,
                  @RequestParam(value = "cid") String cid,
                  @RequestParam(value = "uploadType") Integer uploadType,
                  HttpServletRequest request) throws Exception {
        JSONObject root = new JSONObject();
        SysUserEntity sysUserEntity=getLoginedUserInfo();
        SysUserEntity userEntity=sysUserService.selectById(sysUserEntity.getUserId());
        for (MultipartFile file : files) {
            String contentType = file.getContentType();
            String fileName = file.getOriginalFilename();
            System.out.println("fileName-->" + fileName);
            System.out.println("file-->" + file.getName());

            System.out.println("getContentType-->" + contentType);
            String filePath = request.getSession().getServletContext().getRealPath("/");
            String fileUploadPath = "/uploadfile/" + type + "/" + DateUtils.getDate().getTime() + "/";//暂时存在这里
            String filePathnew = filePath + fileUploadPath;
            System.out.print(filePathnew);
            String srcnewpath = "";
            String header = request.getHeader("User-Agent").toUpperCase();
            if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {//IE
                fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
            }
            FileUtils.uploadFile(file.getBytes(), filePathnew, fileName);
            srcnewpath = fileUploadPath + fileName;
            if(uploadType==null){//是污染源附件进入，其他返回url存本表
                CominfoBaseinfoAttachmentEntity entity = new CominfoBaseinfoAttachmentEntity();
                entity.setCreatedate(DateUtils.getDate());
                entity.setFileName(fileName);
                entity.setAttachmentFormat(fileName.substring(fileName.lastIndexOf(".")+1));
                entity.setAttachmentUrl(srcnewpath);
                entity.setFileType(type);
                entity.setCid(cid);
                entity.setAttachmentSize(Utils.getFormatSize(file.getSize()));
                entity.setUploadPerson(userEntity.getUsername());
                entity.setUploadTime(DateUtils.getStringDate());
                cominfoBaseinfoAttachmentService.insert(entity);
            }else {
                //进入（建设项目、行政处罚）
                if(uploadType==2){
                    if(type==9){
                        BuildingProjectAttachmentEntity attachmentEntity=new BuildingProjectAttachmentEntity();
                        attachmentEntity.setFileName(fileName);
                        attachmentEntity.setCreatedate(DateUtils.getDate());
                        attachmentEntity.setAttachmentSize(Utils.getFormatSize(file.getSize()));
                        attachmentEntity.setAttachmentFormat(fileName.substring(fileName.lastIndexOf(".")+1));
                        attachmentEntity.setAttachmentUrl(srcnewpath);
                        attachmentEntity.setBid(cid);
                        buildingProjectAttachmentService.insert(attachmentEntity);
                    }
                    if(type==10){
                        AdministrativePenaltyFileEntity fileEntity=new AdministrativePenaltyFileEntity();
                        fileEntity.setFileName(fileName);
                        fileEntity.setCreatedate(DateUtils.getDate());
                        fileEntity.setAttachmentSize(Utils.getFormatSize(file.getSize()));
                        fileEntity.setAttachmentFormat(fileName.substring(fileName.lastIndexOf(".")+1));
                        fileEntity.setAttachmentUrl(srcnewpath);
                        fileEntity.setAid(cid);
                        administrativePenaltyFileService.insert(fileEntity);
                    }
                    if(type==11){
                        EmergencySystemPlanFileEntity fileEntity=new EmergencySystemPlanFileEntity();
                        fileEntity.setFileName(fileName);
                        fileEntity.setCreatedate(DateUtils.getDate());
                        fileEntity.setAttachmentSize(Utils.getFormatSize(file.getSize()));
                        fileEntity.setAttachmentFormat(fileName.substring(fileName.lastIndexOf(".")+1));
                        fileEntity.setAttachmentUrl(srcnewpath);
                        fileEntity.setAid(cid);
                        emergencySystemPlanFileService.insert(fileEntity);
                    }
                    if(type==12){
                        EmergencySystemDrillFileEntity fileEntity=new EmergencySystemDrillFileEntity();
                        fileEntity.setFileName(fileName);
                        fileEntity.setCreatedate(DateUtils.getDate());
                        fileEntity.setAttachmentSize(Utils.getFormatSize(file.getSize()));
                        fileEntity.setAttachmentFormat(fileName.substring(fileName.lastIndexOf(".")+1));
                        fileEntity.setAttachmentUrl(srcnewpath);
                        fileEntity.setAid(cid);
                        emergencySystemDrillFileService.insert(fileEntity);
                    }
                    if(type==16){
                        MobileEnforcementAttachmentEntity attachmentEntity=new MobileEnforcementAttachmentEntity();
                        attachmentEntity.setFileName(fileName);
                        attachmentEntity.setCreatedate(DateUtils.getDate());
                        attachmentEntity.setAttachmentSize(Utils.getFormatSize(file.getSize()));
                        attachmentEntity.setAttachmentFormat(fileName.substring(fileName.lastIndexOf(".")+1));
                        attachmentEntity.setAttachmentUrl(srcnewpath);
                        attachmentEntity.setMid(cid);
                        attachmentEntity.setType(0);
                        mobileEnforcementAttachmentService.insert(attachmentEntity);
                    }
                    if(type==17){
                        CominfoTotalControlplanFileEntity attachmentEntity=new CominfoTotalControlplanFileEntity();
                        attachmentEntity.setFileName(fileName);
                        attachmentEntity.setCreatedate(DateUtils.getDate());
                        attachmentEntity.setAttachmentSize(Utils.getFormatSize(file.getSize()));
                        attachmentEntity.setAttachmentFormat(fileName.substring(fileName.lastIndexOf(".")+1));
                        attachmentEntity.setAttachmentUrl(srcnewpath);
                        attachmentEntity.setAid(cid);
                        cominfoTotalControlplanFileService.insert(attachmentEntity);
                    }
                }

            }
            File originalFile = new File(filePathnew+fileName);
            String originalFileHtml = filePathnew + File.separator + "show.html";
            if (fileName.endsWith("doc")||fileName.endsWith("docx")) {
                PoiWordToHtmlUtil.wordToHtml(filePathnew+fileName,originalFileHtml);
            }
            if (fileName.endsWith("xls")||fileName.endsWith("xlsx")) {
                PoiExcelToHtmlUtil.excelToHtml(filePathnew+fileName, originalFileHtml);
            }
            JSONObject src = new JSONObject();
            src.put("src", srcnewpath);
            root.put("code", CommonConstant.HTTP_STATUS_OK);
            root.put("msg", "ok");
            root.put("data", src);
            root.put("filename", fileName);
        }
        return root.toString();
    }

    @GetMapping(value = "/view")
    public R viewAttachment(
            @RequestParam("filepath") String filepath, HttpServletRequest request) throws Exception {
        Map<String, String> fileinfo = new HashMap<>();
        String attachmentFile = request.getSession().getServletContext()
                .getRealPath(filepath);
        File file = new File(attachmentFile);
        file.getPath();
        if (!file.exists()) {
            fileinfo.put("src", "");
        } else {
            String fileName = file.getName();
            String htmlsrc = filepath.replace(fileName, "show.html");
            String htmlFilePath = request.getSession().getServletContext()
                    .getRealPath(htmlsrc);
            File fileHmtl = new File(htmlFilePath);
            //如果文件不存在则先生成
            if (!fileHmtl.exists()) {
                if (fileName.startsWith("doc")) {
                    PoiWordToHtmlUtil.wordToHtml(attachmentFile, htmlFilePath);
                } else {
                    PoiExcelToHtmlUtil.excelToHtml(attachmentFile, htmlFilePath);
                }

            }
            fileinfo.put("src", htmlsrc);
        }
        return R.ok().put("htmlfile", fileinfo);
    }


    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletRequest request,HttpServletResponse res) throws UnsupportedEncodingException {
        String filePath = request.getParameter("file");
        String attachmentFile = request.getSession().getServletContext()
                .getRealPath(filePath);
        File file = new File(attachmentFile);
        String fileName = file.getName();
//        String fileName = URLEncoder.encode(file.getName(), "UTF-8");
        String header = request.getHeader("User-Agent").toUpperCase();
        res.setContentType("application/x-download");
        if (header.indexOf("FIREFOX") > 0)
        {
            res.setHeader("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO8859-1") + "\""); // 一定要前后双引号括起来，不然火狐遇到带空格的文件名，会显示不全。
        } else if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {//IE
            fileName = URLEncoder.encode(fileName, "utf-8");
            fileName = fileName.replaceAll("\\+", "%20");
            res.setHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");
        }else{
            res.setHeader("content-type", "application/octet-stream");
            res.setContentType("application/octet-stream");
            res.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO-8859-1") );
        }
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = bis.read(buff);
            while (i >0) {
                os.write(buff, 0, i);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoBaseinfoAttachmentService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        CominfoBaseinfoAttachmentEntity cominfoBaseinfoAttachment = cominfoBaseinfoAttachmentService.selectById(pid);

        return R.ok().put("cominfoBaseinfoAttachment", cominfoBaseinfoAttachment);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody CominfoBaseinfoAttachmentEntity cominfoBaseinfoAttachment){
        ValidatorUtils.validateEntity(cominfoBaseinfoAttachment, AddGroup.class);
        cominfoBaseinfoAttachment.setCreatedate(DateUtils.getDate());
        cominfoBaseinfoAttachmentService.insert(cominfoBaseinfoAttachment);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody CominfoBaseinfoAttachmentEntity cominfoBaseinfoAttachment){
        ValidatorUtils.validateEntity(cominfoBaseinfoAttachment, UpdateGroup.class);
        cominfoBaseinfoAttachmentService.updateById(cominfoBaseinfoAttachment);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        cominfoBaseinfoAttachmentService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
