var buildproject={
    editWin:function (admin,setter,$,table,form,upload,baseurl,laytpl,laydate,element,differType,global_obj,pid,getBaseInfo,baseInfoAttachment) {
        var showAndHide=function () {
            $("#com-table table").each(function () {
                $(this).parent().removeClass("layui-hide");
                $(this).parent().next().addClass("layui-hide")
            });
            $("#add").removeClass("layui-hide");
            $("#mod").removeClass("layui-hide");
            $("#del").removeClass("layui-hide");

        };

        //文件类型下拉框
        var fileTypeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/file_type_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,fileType = document.getElementById('fileType');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        fileType.innerHTML = html;
                        if(data.fileType!=null&data.fileType!==''){
                            $("#fileType").val(data.fileType);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //项目性质下拉框
        var projectNatureTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/project_nature_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,projectNature = document.getElementById('projectNature');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        projectNature.innerHTML = html;
                        if(data.projectNature!=null&data.projectNature!==''){
                            $("#projectNature").val(data.projectNature);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //违法类型下拉框
        var illegalTypeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/illegal_type_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,illegalType = document.getElementById('illegalType');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        illegalType.innerHTML = html;
                        if(data.illegalType!=null&data.illegalType!==''){
                            $("#illegalType").val(data.illegalType);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };


        //举报方式下拉框
        var informTypeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/inform_type_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,informType = document.getElementById('informType');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        informType.innerHTML = html;
                        if(data.informType!=null&data.informType!==''){
                            $("#informType").val(data.informType);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //举报内容是否属实下拉框
        var informIsTrueTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/boolean_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,informIsTrue = document.getElementById('informIsTrue');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        informIsTrue.innerHTML = html;
                        if(data.informIsTrue!=null&data.informIsTrue!==''){
                            $("#informIsTrue").val(data.informIsTrue);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //是否反馈下拉框
        var isReplyTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/boolean_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,isReply = document.getElementById('isReply');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        isReply.innerHTML = html;
                        if(data.isReply!=null&data.isReply!==''){
                            $("#isReply").val(data.isReply);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //立案查处否下拉框
        var isPenalizeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/boolean_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,isPenalize = document.getElementById('isPenalize');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        isPenalize.innerHTML = html;
                        if(data.isPenalize!=null&data.isPenalize!==''){
                            $("#isPenalize").val(data.isPenalize);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //反馈方式下拉框
        var replyTypeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/reply_type_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,replyType = document.getElementById('replyType');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        replyType.innerHTML = html;
                        if(data.replyType!=null&data.replyType!==''){
                            $("#replyType").val(data.replyType);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //审批单位下拉框
        var approvalUnitTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/sys/sysapprovalunit/list"
                , done: function (result) {
                    var getDictTpl = SelectTpl.innerHTML
                        ,approvalUnit = document.getElementById('approvalUnit');
                    laytpl(getDictTpl).render(result.data, function(html){
                        approvalUnit.innerHTML = html;
                        if(data.approvalUnit!=null&data.approvalUnit!==''){
                            $("#approvalUnit").val(data.approvalUnit);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //执法类型下拉框
        var lawEnforcementTypeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/law_enforcement_type_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,lawEnforcementType = document.getElementById('lawEnforcementType');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        lawEnforcementType.innerHTML = html;
                        if(data.lawEnforcementType!=null&data.lawEnforcementType!==''){
                            $("#lawEnforcementType").val(data.lawEnforcementType);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //检查结果下拉框
        var examinationResultsTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/examination_results_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,examinationResults = document.getElementById('examinationResults');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        examinationResults.innerHTML = html;
                        if(data.examinationResults!=null&data.examinationResults!==''){
                            $("#examinationResults").val(data.examinationResults);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };
        //结果类型/问题类型下拉框
        var typeProblemTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/mobileEnforcement_problemType"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,typeProblem = document.getElementById('resultType');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        typeProblem.innerHTML = html;
                        if(data.resultType!=null&data.resultType!==''){
                            $("#resultType").val(data.resultType);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };
        //证书类型下拉框
        var permitTypeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/permit_type_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,permitType = document.getElementById('permitType');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        permitType.innerHTML = html;
                        if(data.permitType!=null&data.permitType!==''){
                            $("#permitType").val(data.permitType);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //主要污染物类别下拉框
        var mainWasteCategoryTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/main_waste_category_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,mainWasteCategory = document.getElementById('mainWasteCategory');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        mainWasteCategory.innerHTML = html;
                        if(data.mainWasteCategory!=null&data.mainWasteCategory!==''){
                            $("#mainWasteCategory").val(data.mainWasteCategory);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //大气污染物排放规律下拉框
        var airPollutantsRuleTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/air_pollutants_rule_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,airPollutantsRule = document.getElementById('airPollutantsRule');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        airPollutantsRule.innerHTML = html;
                        if(data.airPollutantsRule!=null&data.airPollutantsRule!==''){
                            $("#airPollutantsRule").val(data.airPollutantsRule);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        var afterLoad = function(data){
            //需要占位，否则为空没法渲染
            var laboratorytechnician = document.getElementById('buildingEnvironmenttraffic'+differType);
            laytpl(getBaseInfo).render(data, function(html){
                laboratorytechnician.innerHTML = html;
                if(differType==0){
                    $("#showAttachment").removeClass("layui-hide");
                    var url=setter.remoteServiceAddress + "/market/buildingprojectattachment";
                    if(data==1){
                        baseInfoAttachment.multiUpload("attachment_div","9","",url,null,"attachment_upload_btn"+differType,"upload_file_bizcode"+differType);
                    }else{
                        baseInfoAttachment.multiUpload("attachment_div","9",data.pid,url,null,"attachment_upload_btn"+differType,"upload_file_bizcode"+differType);
                    }
                    $("#showAttachment").on("click",function () {
                        $("#showAttachment").addClass("layui-hide");
                        $("#showAttachmentInfo").removeClass("layui-hide");
                        $("#hideAttachment").removeClass("layui-hide");
                    });

                    $("#hideAttachment").on("click",function () {
                        $("#hideAttachment").addClass("layui-hide");
                        $("#showAttachmentInfo").addClass("layui-hide");
                        $("#showAttachment").removeClass("layui-hide");
                    });
                    fileTypeTpl(data);
                    projectNatureTpl(data);
                    approvalUnitTpl(data);
                }
                if(differType==1){
                    permitTypeTpl(data);
                    mainWasteCategoryTpl(data);
                    airPollutantsRuleTpl(data);
                    var url=setter.remoteServiceAddress + "/market/buildingprojectattachment";
                    if(data==1){
                        // baseInfoAttachment.singleUpload("attachment_div","9","",url);
                        // baseInfoAttachment.singleUpload("attachment_div2","9","",url);
                        //执行实例
                        var uploadInst1 = upload.render({
                            elem: '#upload1' //绑定元素
                            ,headers: {
                                access_token: layui.data(setter.tableName).access_token
                            }
                            ,url: setter.remoteServiceAddress + '/sys/file/upload/7' //上传接口
                            ,accept:"file"
                            ,before : function(obj){
                                this.data = {bizCode:"",uploadType: ""}
                                layer.load();
                            }
                            ,done: function(result){
                                layer.closeAll('loading');
                                if(result.code == 0){//成功
                                    // layer.msg('上传成功！', {icon: 6,time:1000},function(){
                                    //     $1("[name='url1']").val(result.data.src);
                                    //     $1("#noUploaded1").attr("src",setter.remoteServiceAddress+result.data.src);
                                    //     $1("#div-pic1").show();
                                    // });
                                    $("#demoText1").text(result.filename);
                                    $("#file_url1").val(result.data.src)
                                }else{
                                    layer.alert(result.msg, {
                                        skin: 'layui-layer-lan',
                                        offset: 't',
                                        anim: 6
                                    });
                                }
                            }
                            ,error: function(){
                                layer.closeAll('loading');
                            }
                        });

                        //执行实例
                        var uploadInst2 = upload.render({
                            elem: '#upload2' //绑定元素
                            ,headers: {
                                access_token: layui.data(setter.tableName).access_token
                            }
                            ,url: setter.remoteServiceAddress + '/sys/file/upload/7' //上传接口
                            ,accept:"file"
                            ,before : function(obj){
                                this.data = {bizCode:"",uploadType: ""}
                                layer.load();
                            }
                            ,done: function(result){
                                layer.closeAll('loading');
                                if(result.code == 0){//成功
                                    // layer.msg('上传成功！', {icon: 6,time:1000},function(){
                                    //     $1("[name='url2']").val(result.data.src);
                                    //     $1("#noUploaded2").attr("src",setter.remoteServiceAddress+result.data.src);
                                    //     $1("#div-pic2").show();
                                    // });
                                    $("#demoText2").text(result.filename);
                                    $("#file_url2").val(result.data.src)
                                }else{
                                    layer.alert(result.msg, {
                                        skin: 'layui-layer-lan',
                                        offset: 't',
                                        anim: 6
                                    });
                                }
                            }
                            ,error: function(){
                                layer.closeAll('loading');
                            }
                        });
                    }else{
                        var uploadInst1 = upload.render({
                            elem: '#upload1' //绑定元素
                            ,headers: {
                                access_token: layui.data(setter.tableName).access_token
                            }
                            ,url: setter.remoteServiceAddress + '/sys/file/upload/7' //上传接口
                            ,accept:"file"
                            ,before : function(obj){
                                this.data = {bizCode:"",uploadType: ""}
                                layer.load();
                            }
                            ,done: function(result){
                                layer.closeAll('loading');
                                if(result.code == 0){//成功
                                    // layer.msg('上传成功！', {icon: 6,time:1000},function(){
                                    //     $1("[name='url1']").val(result.data.src);
                                    //     $1("#noUploaded1").attr("src",setter.remoteServiceAddress+result.data.src);
                                    //     $1("#div-pic1").show();
                                    // });
                                    $("#demoText1").text(result.filename);
                                    $("#file_url1").val(result.data.src)
                                }else{
                                    layer.alert(result.msg, {
                                        skin: 'layui-layer-lan',
                                        offset: 't',
                                        anim: 6
                                    });
                                }
                            }
                            ,error: function(){
                                layer.closeAll('loading');
                            }
                        });

                        //执行实例
                        var uploadInst2 = upload.render({
                            elem: '#upload2' //绑定元素
                            ,headers: {
                                access_token: layui.data(setter.tableName).access_token
                            }
                            ,url: setter.remoteServiceAddress + '/sys/file/upload/7' //上传接口
                            ,accept:"file"
                            ,before : function(obj){
                                this.data = {bizCode:"",uploadType: ""}
                                layer.load();
                            }
                            ,done: function(result){
                                layer.closeAll('loading');
                                if(result.code == 0){//成功
                                    // layer.msg('上传成功！', {icon: 6,time:1000},function(){
                                    //     $1("[name='url2']").val(result.data.src);
                                    //     $1("#noUploaded2").attr("src",setter.remoteServiceAddress+result.data.src);
                                    //     $1("#div-pic2").show();
                                    // });
                                    $("#demoText2").text(result.filename);
                                    $("#file_url2").val(result.data.src)
                                }else{
                                    layer.alert(result.msg, {
                                        skin: 'layui-layer-lan',
                                        offset: 't',
                                        anim: 6
                                    });
                                }
                            }
                            ,error: function(){
                                layer.closeAll('loading');
                            }
                        });
                    }
                }
                if(differType==2){
                    informTypeTpl(data);
                    informIsTrueTpl(data);
                    isReplyTpl(data);
                    isPenalizeTpl(data);
                    replyTypeTpl(data);
                }
                if(differType==3){
                    $("#showPunishment").removeClass("layui-hide");
                    var url=setter.remoteServiceAddress + "/penalty/administrativepenaltyfile";
                    if(data==1){
                        baseInfoAttachment.multiUpload("punishment_div","10","",url,null,"attachment_upload_btn"+differType,"upload_file_bizcode"+differType);
                    }else{
                        baseInfoAttachment.multiUpload("punishment_div","10",data.pid,url,null,"attachment_upload_btn"+differType,"upload_file_bizcode"+differType);
                    }
                    $("#showPunishment").on("click",function () {
                        $("#showPunishment").addClass("layui-hide");
                        $("#showPunishmentInfo").removeClass("layui-hide");
                        $("#hidePunishment").removeClass("layui-hide");
                    });

                    $("#hidePunishment").on("click",function () {
                        $("#hidePunishment").addClass("layui-hide");
                        $("#showPunishmentInfo").addClass("layui-hide");
                        $("#showPunishment").removeClass("layui-hide");
                    });
                    illegalTypeTpl(data);
                }
                if(differType==4){
                    $("#showEnforcementScene").removeClass("layui-hide");
                    var url=setter.remoteServiceAddress + "/mobile/mobileenforcementattachment";
                    if(data==1){
                        baseInfoAttachment.multiUpload("enforcementScene_div","16","",url,null,"attachment_upload_btn"+differType,"upload_file_bizcode"+differType);
                    }else{
                        baseInfoAttachment.multiUpload("enforcementScene_div","16",data.pid,url,null,"attachment_upload_btn"+differType,"upload_file_bizcode"+differType);
                    }
                    $("#showEnforcementScene").on("click",function () {
                        $("#showEnforcementScene").addClass("layui-hide");
                        $("#showEnforcementSceneInfo").removeClass("layui-hide");
                        $("#hideEnforcementScene").removeClass("layui-hide");
                    });

                    $("#hideEnforcementScene").on("click",function () {
                        $("#hideEnforcementScene").addClass("layui-hide");
                        $("#showEnforcementSceneInfo").addClass("layui-hide");
                        $("#showEnforcementScene").removeClass("layui-hide");
                    });
                    lawEnforcementTypeTpl(data);
                    examinationResultsTpl(data);
                    typeProblemTpl(data);
                }
                if(differType==5){
                    $("#showControlPlan").removeClass("layui-hide");
                    var url=setter.remoteServiceAddress + "/cominfo/cominfototalcontrolplanfile";
                    if(data==1){
                        baseInfoAttachment.multiUpload("controlPlan_div","17","",url,null,"attachment_upload_btn"+differType,"upload_file_bizcode"+differType);
                    }else{
                        baseInfoAttachment.multiUpload("controlPlan_div","17",data.pid,url,null,"attachment_upload_btn"+differType,"upload_file_bizcode"+differType);
                    }
                    $("#showControlPlan").on("click",function () {
                        $("#showControlPlan").addClass("layui-hide");
                        $("#showControlPlanInfo").removeClass("layui-hide");
                        $("#hideControlPlan").removeClass("layui-hide");
                    });

                    $("#hideControlPlan").on("click",function () {
                        $("#hideControlPlan").addClass("layui-hide");
                        $("#showControlPlanInfo").addClass("layui-hide");
                        $("#showControlPlan").removeClass("layui-hide");
                    });
                }
            });
            $("[name='buildingHome"+differType+"']").on("click",function () {
                showAndHide();
                table.reload("LAY-building-environmenttraffic"+differType); //刷新表格
            });
            if(differType==0){
                laydate.render({
                    elem: '[name="admissibilityTime"]'
                    ,type: 'date'
                    // ,value:new Date()
                });
                laydate.render({
                    elem: '[name="batchTime"]'
                    ,type: 'date'
                    // ,value:new Date()
                });
                laydate.render({
                    elem: '[name="acceptanceRequestTime"]'
                    ,type: 'date'
                    // ,value:new Date()
                });
                laydate.render({
                    elem: '[name="acceptanceBatchTime"]'
                    ,type: 'date'
                    // ,value:new Date()
                });
            }
            if(differType==1){
                laydate.render({
                    elem: '[name="issueDate"]'
                    ,type: 'date'
                    // ,value:new Date()
                });
                laydate.render({
                    elem: '[name="startDate"]'
                    ,type: 'date'
                    // ,value:new Date()
                });
                laydate.render({
                    elem: '[name="endDate"]'
                    ,type: 'date'
                    // ,value:new Date()
                });
            }
            if(differType==2){
                laydate.render({
                    elem: '[name="informDate"]'
                    ,type: 'date'
                    // ,value:new Date()
                });
            }
            if(differType==3){
                laydate.render({
                    elem: '[name="filingTime"]'
                    ,type: 'date'
                    // ,value:new Date()
                });
                laydate.render({
                    elem: '[name="closingTime"]'
                    ,type: 'date'
                    // ,value:new Date()
                });
            }
            if(differType==4){
                laydate.render({
                    elem: '[name="checkStarttime"]'
                    ,type: 'date'
                    // ,value:new Date()
                });
                laydate.render({
                    elem: '[name="checkEndtime"]'
                    ,type: 'date'
                    // ,value:new Date()
                });
            }
            if(differType==6){
                laydate.render({
                    elem: '[name="testDate"]'
                    ,type: 'date'
                    // ,value:new Date()
                });
            }
            form.render(null, 'component-form-element');
        }
        if(pid!=null&pid!="undefined"){
            admin.req({//根据id获取该记录的详细信息
                url: baseurl + "/" + pid
                ,done: function(result){
                    if(result.code == 0){//成功
                        var datatemp = result.buildingProjectApproval;
                        if(differType==1){
                            datatemp = result.pollutantDischargePermit;
                        }
                        if(differType==2){
                            datatemp=result.petitionSystemComplain;
                        }
                        if(differType==3){
                            datatemp = result.administrativePenaltyInfo;
                        }
                        if(differType==4){
                            datatemp = result.mobileEnforcementScene;
                        }
                        if(differType==5){
                            datatemp = result.cominfoTotalControlplan;
                        }
                        if(differType==6){
                            datatemp = result.environmentalMonitoringRecord;
                        }
                        afterLoad(datatemp);
                    }else{
                        layer.alert(result.msg, {
                            skin: 'layui-layer-lan',
                            offset: 't',
                            anim: 6
                        });
                    }
                }
            });
        }else {
            afterLoad(1);
        }

    }
};
