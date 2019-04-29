layui.define(['jquery'], function (exports) {
    var $ = layui.jquery;
    var admin = layui.admin;
    var layer = layui.layer;
    var setter = layui.setter;
    var statistics={
        /**
         * 固废产生与利用、危废产生与利用新增修改页面
         * @param pid
         */
        getBaseInfo:null
        ,getHtml:function (admin,setter,$,table,form,baseurl,laytpl,laydate,element,differType,global_obj,pid,cid) {
            //加载下时间类型选项
            var dateTime=function () {
                laydate.render({
                    elem: '#produceYear'+differType//或 elem: document.getElementById('test')、elem: lay('#test')
                    ,type: 'year'
                });
            }
            var booleanTpl=function (isWasteType) {
                var type='waste_type';
                admin.req({//获取字典请求
                    url: setter.remoteServiceAddress + "/online/onlinewasteproduce/wasteType/"+type
                    , done: function (result) {
                        var getDictTpl = SelectDictTpl.innerHTML
                            ,monitorUseflag = document.getElementById('isWaste'+differType);
                        laytpl(getDictTpl).render(result.data, function(html){
                            monitorUseflag.innerHTML = html;
                            if(isWasteType!=null){
                                $('#isWaste'+differType).val(isWasteType);
                            }
                        });
                        form.render(null, 'component-form-element');
                        form.on("select(wasteType)",function (data) {
                            if(data.value){
                                admin.req({//获取字典请求
                                    url: setter.remoteServiceAddress + "/sys/syswaste/getDictList/"+data.value+"/waste_type"
                                    , done: function (result) {
                                        var data=result.data;
                                        if(data!=null){
                                            $("#getWasteCode").val(data[0].backup)
                                        }
                                    }
                                });
                            }
                        })
                    }
                });
            }
            var getWasteCodeTpl=function (isWasteType) {
                admin.req({//获取字典请求
                    url: setter.remoteServiceAddress + "/sys/syswaste/queryList/"
                    , done: function (result) {
                        var getDictTpl = SelectTpl.innerHTML
                            ,monitorUseflag = document.getElementById('isWaste'+differType);
                        laytpl(getDictTpl).render(result.data, function(html){
                            monitorUseflag.innerHTML = html;
                            if(isWasteType!=null){
                                $('#isWaste'+differType).val(isWasteType);
                            }
                            form.render(null, 'component-form-element');
                            form.on("select(wasteType)",function (data) {
                                if(data.value){
                                    admin.req({//获取字典请求
                                        url: setter.remoteServiceAddress + "/sys/syswaste/"+data.value
                                        , done: function (result) {
                                            var data=result.sysWaste;
                                            if(data!=null){
                                                $("#getWasteCode").val(data.wastecode);
                                            }
                                        }
                                    });
                                }
                            })
                        });
                        form.render(null, 'component-form-element');
                    }
                });
            }

            var placeIdTpl=function (placeId) {
                admin.req({//获取字典请求
                    url: setter.remoteServiceAddress + "/comInfo/cominfowasteprocessplace/selectList/"+(differType-3)+"/"+cid
                    , done: function (result) {
                        var getDictTpl = SelectTpl.innerHTML
                            ,flag = document.getElementById('placeId'+differType);
                        laytpl(getDictTpl).render(result.data, function(html){
                            flag.innerHTML = html;
                            if(placeId!=null){
                                $('#placeId'+differType).val(placeId);
                            }
                        });
                        form.render(null, 'component-form-element');
                    }
                });
            }

            //加载的模板
            statistics.getBaseInfo=editonlineMonitorPortinfo3.innerHTML;
            var differ=0;
            if(differType==3){
                differ=1;
            }
            //通过pid判断是修改还是新增
            if(pid!=null&pid!="undefined"){
                admin.req({//根据id获取该记录的详细信息
                    url: baseurl + "/" + pid+"/"+differ
                    ,done: function(result){
                        if(result.code == 0){//成功
                            var laboratorytechnician = document.getElementById('comInfoProcessingPlace'+differType);
                            laytpl(statistics.getBaseInfo).render(result.onlineWasteProduce, function(html){
                                laboratorytechnician.innerHTML = html;
                                // doCallback(differType,result.comInfoProcessingPlace);
                                dateTime();
                                if(differType==3){
                                    booleanTpl(result.onlineWasteProduce.wasteType);
                                }
                                if(differType==4){
                                    getWasteCodeTpl(result.onlineWasteProduce.wasteType)
                                }
                                placeIdTpl(result.onlineWasteProduce.placeId)
                            });

                            $("[name='portInfoHome']").on("click",function () {
                                statistics.showAndHide();
                                table.reload("LAY-comInfo-processingPlace"+differType); //刷新表格
                            });
                            form.render(null, 'component-form-element');
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
                var data=null;
                if(differType==3){
                    data={useType:0};
                }else{
                    data={useType:1};
                }
                //需要占位，否则为空没法渲染
                var laboratorytechnician = document.getElementById('comInfoProcessingPlace'+differType);
                laytpl(statistics.getBaseInfo).render(data, function(html){
                    laboratorytechnician.innerHTML = html;
                    // doCallback(differType,data);
                    dateTime();
                    if(differType==3){
                        booleanTpl();
                    }
                    if(differType==4){
                        getWasteCodeTpl();
                    }
                    placeIdTpl();
                });


                $("[name='portInfoHome']").on("click",function () {
                    statistics.showAndHide();
                    table.reload("LAY-comInfo-processingPlace"+differType); //刷新表格
                });
                form.render(null, 'component-form-element');
            }
        }
        ,showAndHide:function () {
            $("#processingPlace3").removeClass("layui-hide");
            $("#processingPlace4").removeClass("layui-hide");
            $("#comInfoProcessingPlace3").addClass("layui-hide");
            $("#comInfoProcessingPlace4").addClass("layui-hide");
            $("#add").removeClass("layui-hide");
            $("#mod").removeClass("layui-hide");
            $("#del").removeClass("layui-hide");
            $("#link").removeClass("layui-hide");
        }
        //动态加载下拉框
        ,yearQuery:function(element){
            admin.req({
                url:setter.remoteServiceAddress + "/mobile/mobileenforcementscene/statisticalYearQuery"
                ,async: false
                , done: function (result) {
                    if(result.code == 0){
                        var data=result.dicts;
                        for(var i=0;i<data.length;i++){
                            $("#"+element).append("<span >"+data[i].value+"</span>")
                        }
                    }
                }
            });
        }
        ,editWin:function (admin,setter,$,table,form,baseurl,laytpl,laydate,element,differType,global_obj,pid,cid,getBaseInfo) {
            //加载下时间类型选项
            var dateTime1=function () {
                laydate.render({
                    elem: '#year'+differType//或 elem: document.getElementById('test')、elem: lay('#test')
                    ,type: 'year'
                });
                laydate.render({
                    elem: '#samplingDate'+differType
                    ,type: 'datetime'
                });
            }
            //原矿选择下拉框
            var rawOreSelect=function (data) {
                admin.req({//获取字典请求
                    url: setter.remoteServiceAddress + "/market/sysdict/dicts/raw_ore_type"
                    , done: function (result) {
                        var getDictTpl = SelectDictTpl.innerHTML
                            ,governanceMode = document.getElementById('rawOre');
                        laytpl(getDictTpl).render(result.dicts, function(html){
                            governanceMode.innerHTML = html;
                            if(data.rawOre!=null&data.rawOre!==''){
                                $("#rawOre").val(data.rawOre);
                            }
                        });
                        form.render(null, 'component-form-element');
                    }
                });
            };
            //精矿选择下拉框
            var concentrateSelect=function (data) {
                admin.req({//获取字典请求
                    url: setter.remoteServiceAddress + "/market/sysdict/dicts/concentrate_type"
                    , done: function (result) {
                        var getDictTpl = SelectDictTpl.innerHTML
                            ,governanceMode = document.getElementById('concentrate');
                        laytpl(getDictTpl).render(result.dicts, function(html){
                            governanceMode.innerHTML = html;
                            if(data.concentrate!=null&data.concentrate!==''){
                                $("#concentrate").val(data.concentrate);
                            }
                        });
                        form.render(null, 'component-form-element');
                    }
                });
            };
            //固体废物选择下拉框
            var solidWasteSelect=function (data) {
                admin.req({//获取字典请求
                    url: setter.remoteServiceAddress + "/market/sysdict/dicts/solid_waste_type"
                    , done: function (result) {
                        var getDictTpl = SelectDictTpl.innerHTML
                            ,governanceMode = document.getElementById('solidWaste');
                        laytpl(getDictTpl).render(result.dicts, function(html){
                            governanceMode.innerHTML = html;
                            if(data.solidWaste!=null&data.solidWaste!==''){
                                $("#solidWaste").val(data.solidWaste);
                            }
                        });
                        form.render(null, 'component-form-element');
                    }
                });
            };
            //检测类型选择下拉框
            var monitorTypeSelect=function (data) {
                admin.req({//获取字典请求
                    url: setter.remoteServiceAddress + "/market/cominforadioactiveoremonitor/dicts/monitor_type/"+differType
                    , done: function (result) {
                        var getDictTpl = SelectDictTpl.innerHTML
                            ,governanceMode = document.getElementById('monitorType'+differType);
                        laytpl(getDictTpl).render(result.dicts, function(html){
                            governanceMode.innerHTML = html;
                            if(data.monitorType!=null&data.monitorType!==''){
                                $("#monitorType"+differType).val(data.monitorType);
                            }
                        });
                        form.render(null, 'component-form-element');
                    }
                });
            };
            //放射性检测取样口选择下拉框
            var getRadioactiveDetection=function (data,type) {
                admin.req({//获取字典请求
                    url: setter.remoteServiceAddress + "/market/cominforadioactiveoremonitor/getRadioactiveDetection/"+type+"/"+cid
                    , done: function (result) {
                        var getDictTpl = SelectDictTpl.innerHTML
                            ,governanceMode = document.getElementById('mid'+differType);
                        laytpl(getDictTpl).render(result.returnObject, function(html){
                            governanceMode.innerHTML = html;
                            if(data.mid!=null&data.mid!==''){
                                $("#mid"+differType).val(data.mid);
                            }
                        });
                        form.render(null, 'component-form-element');
                    }
                });
            };
            var showAndHide1=function () {
                $("#processingPlace0").removeClass("layui-hide");
                $("#processingPlace1").removeClass("layui-hide");
                $("#processingPlace2").removeClass("layui-hide");
                $("#processingPlace3").removeClass("layui-hide");
                $("#processingPlace4").removeClass("layui-hide");
                $("#comInfoProcessingPlace0").addClass("layui-hide");
                $("#comInfoProcessingPlace1").addClass("layui-hide");
                $("#comInfoProcessingPlace2").addClass("layui-hide");
                $("#comInfoProcessingPlace3").addClass("layui-hide");
                $("#comInfoProcessingPlace4").addClass("layui-hide");
                $("#add").removeClass("layui-hide");
                $("#mod").removeClass("layui-hide");
                $("#del").removeClass("layui-hide");
            };
            if(pid!=null&pid!="undefined"){
                if(differType==0||differType==1||differType==2){
                    admin.req({//根据id获取该记录的详细信息
                        url: baseurl + "/" + pid
                        ,done: function(result){
                            if(result.code == 0){//成功
                                afterLoad(result.cominfoRadioactiveOre);
                            }else{
                                layer.alert(result.msg, {
                                    skin: 'layui-layer-lan',
                                    offset: 't',
                                    anim: 6
                                });
                            }
                        }
                    });
                }else if(differType==3||differType==4){
                    admin.req({//根据id获取该记录的详细信息
                        url: baseurl + "/" + pid
                        ,done: function(result){
                            if(result.code == 0){//成功
                                afterLoad(result.onlineMonitorStoreinfo);
                            }else{
                                layer.alert(result.msg, {
                                    skin: 'layui-layer-lan',
                                    offset: 't',
                                    anim: 6
                                });
                            }
                        }
                    });
                }

            }else {
                //需要占位，否则为空没法渲染
                var data=null;
                if(differType==0){
                    data=1;
                }
                if(differType==1){
                    data={category:0};
                }
                if(differType==2){
                    data={category:1};
                }
                if(differType==3){
                    data={useType:3};
                }
                if(differType==4){
                    data={useType:4};
                }
                afterLoad(data)
            }

            function afterLoad(data) {
                var laboratorytechnician = document.getElementById('comInfoProcessingPlace'+differType);
                laytpl(getBaseInfo).render(data, function(html){
                    laboratorytechnician.innerHTML = html;
                    if(differType==0){
                        rawOreSelect(data);
                        concentrateSelect(data);
                        solidWasteSelect(data);
                        dateTime1();
                    }
                    if(differType==1||differType==2){
                        monitorTypeSelect(data);
                        dateTime1();
                    }
                    if(differType==3||differType==4){
                        var type=differType-3;
                        getRadioactiveDetection(data,type);
                    }
                });
                $("[name='processingPlace']").unbind();
                $("[name='processingPlace']").on("click",function () {
                    showAndHide1();
                    table.reload("LAY-comInfo-processingPlace"+differType); //刷新表格
                });
                form.render(null, 'component-form-element');
            }

        }
    }
    exports('wasteProduceAndUse', statistics);
});