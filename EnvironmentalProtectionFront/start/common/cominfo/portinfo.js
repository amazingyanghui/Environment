var portInfo={
    editWin:function (admin,setter,$,table,form,baseurl,laytpl,laydate,element,differType,global_obj,pid,cid) {

        var showAndHide=function () {
            $("#monitorPortinfo0").removeClass("layui-hide");
            $("#monitorPortinfo1").removeClass("layui-hide");
            $("#monitorPortinfo2").removeClass("layui-hide");
            $("#monitorPortinfo3").removeClass("layui-hide");
            $("#monitorPortinfo4").removeClass("layui-hide");
            $("#monitorPortinfo5").removeClass("layui-hide");
            $("#monitorPortinfo6").removeClass("layui-hide");
            $("#monitorPortinfo7").removeClass("layui-hide");
            $("#onlineMonitorPortinfo0").addClass("layui-hide");
            $("#onlineMonitorPortinfo1").addClass("layui-hide");
            $("#onlineMonitorPortinfo2").addClass("layui-hide");
            $("#onlineMonitorPortinfo3").addClass("layui-hide");
            $("#onlineMonitorPortinfo4").addClass("layui-hide");
            $("#onlineMonitorPortinfo5").addClass("layui-hide");
            $("#onlineMonitorPortinfo6").addClass("layui-hide");
            $("#onlineMonitorPortinfo7").addClass("layui-hide");
            $("#add").removeClass("layui-hide");
            $("#mod").removeClass("layui-hide");
            $("#del").removeClass("layui-hide");
            // $("#link").removeClass("layui-hide");
        };
        var dateTime=function () {
            laydate.render({
                elem: '#networkingDate'+differType //或 elem: document.getElementById('test')、elem: lay('#test') 等
                ,type: 'date'
                // ,value:new Date()
            });
        };

        //排污许可证编号
        var permCode = function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/online/onlinemonitorportinfo/permCodeList/"+cid
                , done: function (result) {

                    var getSelectTpl = SelectTpl.innerHTML
                        ,permitid = document.getElementById('permitid'+differType);
                    laytpl(getSelectTpl).render(result.data, function(html){
                        permitid.innerHTML = html;

                        if(data.permitid!=null&data.permitid!==''){
                           $("#permitid"+differType).val(data.permitid);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });

        }


        //是否下拉框
        var booleanTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/boolean_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,monitorUseflag = document.getElementById('monitorUseflag'+differType)
                        ,dayAndNight = document.getElementById('dayAndNight'+differType);
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        monitorUseflag.innerHTML = html;
                        $("#monitorUseflag"+differType).val(data.monitorUseflag);
                        if(differType==5){
                            dayAndNight.innerHTML = html;
                            $("#dayAndNight"+differType).val(data.dayAndNight);
                        }
                    });

                    form.render(null, 'component-form-element');
                }
            });
        };

        // //排放方式下拉框
        // var emissionMmodeTpl=function (data) {
        //     admin.req({//获取字典请求
        //         url: setter.remoteServiceAddress + "/market/sysdict/dicts/emission_mode_type"
        //         , done: function (result) {
        //             var getDictTpl = SelectDictTpl.innerHTML
        //                 ,emissionMode = document.getElementById('emissionMode'+differType);
        //             laytpl(getDictTpl).render(result.dicts, function(html){
        //                 emissionMode.innerHTML = html;
        //                 $("#emissionMode"+differType).val(data.emissionMode);
        //             });
        //             form.render(null, 'component-form-element');
        //         }
        //     });
        // };

        function uploadFile(bizType,differType) {
            //执行实例
            var uploadInst = layui.upload.render({
                elem: '#uploadPicture'+differType //绑定元素
                ,headers: {
                    access_token: layui.data(setter.tableName).access_token
                }
                ,url: setter.remoteServiceAddress + '/cominfo/cominfobaseinfoattachment/upload/'+bizType //上传接口
                ,accept:"images"
                ,before : function(obj){
                    this.data = {uploadType:1,cid:""};
                    layer.load();
                }
                ,done: function(result){
                    layer.closeAll('loading');
                    if(result.code == 0){//成功
                        $("[name='photoPath']").val(result.data.src);
                        layer.msg('上传成功！', {icon: 6,time:1000},function(){
                        });
                        $("#photoPath"+differType).attr("src",setter.remoteServiceAddress+result.data.src);
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

        //排放类型下拉框
        var emissionTypeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/emission_type_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,emissionType = document.getElementById('emissionType'+differType);
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        emissionType.innerHTML = html;
                        $("#emissionType"+differType).val(data.emissionType);
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //使用类型下拉框
        var useTypeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/use_type_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,useType = document.getElementById('useType'+differType);
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        useType.innerHTML = html;
                        $("#useType"+differType).val(data.useType);
                    });
                    form.render(null, 'component-form-element');

                    $("#useType"+differType).val(0);
                    if( $("#useType0")){
                        $("#useType0").val(0);
                    }
                    if( $("#useType1")){
                        $("#useType1").val(0);
                    }
                    if( $("#useType2")){
                        $("#useType2").val(0);
                    }

                }
            });
        };

        //用于噪声功能区分类
        var domainTypeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/domain_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,domainType = document.getElementById('domainType'+differType);
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        domainType.innerHTML = html;
                        $("#domainType"+differType).val(data.domainType);
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //用于污染物排放量计算方法分类
        var computingMethodTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/computing_method_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,computingMethod = document.getElementById('computingMethod'+differType);
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        computingMethod.innerHTML = html;
                        $("#computingMethod"+differType).val(data.computingMethod);
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //用于排放口类别分类
        var airpollutantTypeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/airpollutant_type_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,airpollutantType = document.getElementById('airpollutantType'+differType);
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        airpollutantType.innerHTML = html;
                        $("#airpollutantType"+differType).val(data.airpollutantType);
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        //用于堆存物料类型分类
        var fuelTypeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/fuel_type_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,fuelType = document.getElementById('fuelType'+differType);
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        fuelType.innerHTML = html;
                        $("#fuelType"+differType).val(data.fuelType);
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        var doCallback = function (data) {
            if(differType==0||differType==1||differType==2||differType==5){
                if(differType==0||differType==1||differType==2){
                    emissionTypeTpl(data);
                }
                booleanTpl(data);
                computingMethodTpl(data);
                airpollutantTypeTpl(data);
                fuelTypeTpl(data);
                permCode(data);
                if(differType==5){
                    domainTypeTpl(data);
                }
                dateTime();
                useTypeTpl(data);
                doShowMap(data);
            }
            // emissionMmodeTpl(data);
        }

        var doShowMap = function (data) {
            $("#bannibutton input").each(function () {
                $(this).unbind();
            });
            $("#resultDIV input").each(function () {
                $(this).unbind();
            });
            $("#dine img").each(function () {
                $(this).unbind();
            });
            $("#simpleMap").remove();
            $("#simpleMap").empty();
            $("#simpleMapTpl").remove();
            $("#simpleMapTpl").empty();
            $("#bamboo").remove();
            $("#bamboo").empty();
            $("#dialog").remove();
            $("#dialog").empty();
            $("#dine").remove();
            $("#dine").empty();
            $("#resultDIV").remove();
            $("#resultDIV").empty();
            $("#updatePosition").remove();
            $("#updatePosition").empty();
            $("#updatePosition").unbind();
            BaiduMap.map_level = 11;

            // var maphtmltemp =
            //     '<div class="wrapper"> ' +
            //     '   <div class="newmap" id="simpleMap"></div>' +
            //     '</div>' +
            //     '    <div id="bamboo">' +
            //     '        <div class="banni" id="bannibutton">' +
            //     // '            <input type="text" id="queryText" value="" style="width:150px;"/> &nbsp;&nbsp;' +
            //     '            <input type="button" value="设置坐标点" style="width:80px;" id="setPoint'+differType+'"/>' +
            //     // '            <input type="button" value="修改" id="updatePosition'+differType+'" style="width:80px;" onclick="BaiduMap.updatePoint(BaiduMap.lon_temp,BaiduMap.lat_temp);"/>' +
            //     // '            <input type="button" value="确定" style="width:80px;" onclick="BaiduMap.confirmPointMonitor('+differType+');"/>' +
            //     '        </div>' +
            //     '    </div>' +
            //     // '    <div id="dialog" class="dialog hadai">' +
            //     // '    <div class="hadu" id="dine">' +
            //     // '        <img style="cursor:hand;display:none;cursor: pointer;margin-right:16px;margin-top:16px;" id="openD" class="kaji" onclick="BaiduMap.openDialog(this)" src="TDTNJApi/profile/images/openD.png">' +
            //     // '        <img style="cursor:hand;cursor: pointer;" id="closeD" class="kaji"  onclick="BaiduMap.closeDialog(this)" src="TDTNJApi/profile/images/closeD.png">' +
            //     // '    </div>' +
            //     // '    <div id="resultDIV" class="juma"></div>' +
            //     '</div>';
            // var mapHtmlTpl =
            //     '<div class="wrapper"> ' +
            //     '   <div class="newmap" id="simpleMapTpl"></div>' +
            //     '</div>' +
            //     '    <div id="bamboo">' +
            //     '        <div class="banni" id="bannibutton">' +
            //     '            <input type="text" id="queryText" value="" style="width:150px;"/> &nbsp;&nbsp;' +
            //     '            <input type="button" value="查询" style="width:80px;" onclick="BaiduMap.query(1);"/>' +
            //     '            <input type="button" value="修改" id="updatePosition'+differType+'" style="width:80px;" onclick="BaiduMap.updatePoint(BaiduMap.lon_temp,BaiduMap.lat_temp);"/>' +
            //     '            <input type="button" value="确定" style="width:80px;" id="confirmButton'+differType+'" onclick="BaiduMap.confirmPointMonitor('+differType+');"/>' +
            //     '        </div>' +
            //     '    </div>' +
            //     '    <div id="dialog" class="dialog hadai">' +
            //     '    <div class="hadu" id="dine">' +
            //     '        <img style="cursor:hand;display:none;cursor: pointer;margin-right:16px;margin-top:16px;" id="openD" class="kaji" onclick="BaiduMap.openDialog(this)" src="TDTNJApi/profile/images/openD.png">' +
            //     '        <img style="cursor:hand;cursor: pointer;" id="closeD" class="kaji"  onclick="BaiduMap.closeDialog(this)" src="TDTNJApi/profile/images/closeD.png">' +
            //     '    </div>' +
            //     '    <div id="resultDIV" class="juma"></div>' +
            //     '</div>';
            // $("#divmap"+differType).append(maphtmltemp);
            initMapForAdd('container'+differType,$("#monitorName"+differType).val(),'txtMonitorName'+differType,'searchResultPanel'+differType,true,$("#longitude"+differType).val(),$("#latitude"+differType).val());
            // $("#setPoint"+differType).bind("click",function () {
            //     layer.open({
            //         type: 1
            //         , title: "查看"
            //         , area: ['700px', '500px']
            //         // offset: '120px',
            //         , content: mapHtmlTpl
            //         ,success: function(layero, index){
            //             BaiduMap.init(1,null,setter,null,data,"simpleMapTpl");
            //             $("#confirmButton"+differType).bind("click",function () {
            //                 layer.close(index);
            //                 var longitude=$("#longitude"+differType).val();
            //                 var latitude=$("#latitude"+differType).val();
            //                 if(data==1){
            //                     data={"longitude":longitude,"latitude":latitude};
            //                 }else {
            //                     data.longitude=longitude;
            //                     data.latitude=latitude;
            //                 }
            //                 $("#simpleMap").html("");
            //                 BaiduMap.init(1,null,setter,null,data);
            //             });
            //         }
            //     });
            // });

        };

        var getBaseInfo = editonlineMonitorPortinfo0.innerHTML;
        if(differType==1){
            getBaseInfo=editonlineMonitorPortinfo1.innerHTML;
        }
        if(differType==2){
            getBaseInfo=editonlineMonitorPortinfo2.innerHTML;
        }
        if(differType==5){
            getBaseInfo=editonlineMonitorPortinfo5.innerHTML;
        }
        if(pid!=null&pid!="undefined"){
            admin.req({//根据id获取该记录的详细信息
                url: baseurl + "/" + pid
                ,done: function(result){
                    if(result.code == 0){//成功
                        var laboratorytechnician = document.getElementById('onlineMonitorPortinfo'+differType);
                        laytpl(getBaseInfo).render(result.onlineMonitorPortinfo, function(html){
                            laboratorytechnician.innerHTML = html;
                            if(differType==0){
                                uploadFile(13,differType);
                            }
                            if(differType==1){
                                uploadFile(14,differType);
                            }
                            if(differType==2){
                                uploadFile(15,differType);
                            }
                            if(differType==5){
                                uploadFile(16,differType);
                            }
                            $("[name='portInfoHome']").unbind();
                            $("[name='portInfoHome']").on("click",function () {
                                showAndHide();
                                table.reload("LAY-online-onlineMonitorPortinfo"+differType); //刷新表格
                            });
                            $("#photoPath"+differType).attr("src",setter.remoteServiceAddress+result.onlineMonitorPortinfo.photoPath);
                            doCallback(result.onlineMonitorPortinfo);
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
            var data=1;
            //需要占位，否则为空没法渲染
            var laboratorytechnician = document.getElementById('onlineMonitorPortinfo'+differType);
            laytpl(getBaseInfo).render(data, function(html){
                laboratorytechnician.innerHTML = html;
                if(differType==0){
                    uploadFile(13,differType);
                }
                if(differType==1){
                    uploadFile(14,differType);
                }
                if(differType==2){
                    uploadFile(15,differType);
                }
                if(differType==5){
                    uploadFile(16,differType);
                }
                $("[name='portInfoHome']").unbind();
                $("[name='portInfoHome']").on("click",function () {
                    showAndHide();
                    table.reload("LAY-online-onlineMonitorPortinfo"+differType); //刷新表格
                });
                doCallback(data);
            });
            form.render(null, 'component-form-element');
        }

    }
};
