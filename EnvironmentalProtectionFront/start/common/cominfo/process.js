var process={
    editWin:function (admin,setter,$,table,form,baseurl,laytpl,laydate,element,differType,global_obj,pid) {
        var showAndHide=function () {
            $("#productionProcess0").removeClass("layui-hide");
            $("#productionProcess1").removeClass("layui-hide");
            $("#productionProcess2").removeClass("layui-hide");
            $("#productionProcess3").removeClass("layui-hide");
            $("#productionProcess4").removeClass("layui-hide");
            $("#productionProcess5").removeClass("layui-hide");
            $("#productionProcess6").removeClass("layui-hide");
            $("#productionProcess7").removeClass("layui-hide");
            $("#cominfoProductionProcess0").addClass("layui-hide");
            $("#cominfoProductionProcess1").addClass("layui-hide");
            $("#cominfoProductionProcess2").addClass("layui-hide");
            $("#cominfoProductionProcess3").addClass("layui-hide");
            $("#cominfoProductionProcess4").addClass("layui-hide");
            $("#cominfoProductionProcess5").addClass("layui-hide");
            $("#cominfoProductionProcess6").addClass("layui-hide");
            $("#cominfoProductionProcess7").addClass("layui-hide");
            $("#add").removeClass("layui-hide");
            $("#mod").removeClass("layui-hide");
            $("#del").removeClass("layui-hide");
            $("#upload").addClass("layui-hide");
        };

        var booleanTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/boolean_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML;
                    var isCogeneration = document.getElementById('isCogeneration');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        isCogeneration.innerHTML = html;
                        if(data.isCogeneration!=null){
                            $("#isCogeneration").val(data.isCogeneration);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        var equipmentClassifyTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/equipment_classify_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML;
                    var equipmentClassify = document.getElementById('equipmentClassify');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        equipmentClassify.innerHTML = html;
                        if(data!=1 && data.equipmentClassify!=null){
                            $("#equipmentClassify").val(data.equipmentClassify);
                        }
                    });
                    form.render(null, 'component-form-element');
                    form.on('select(equipmentClassify)', function(data){
                        if(data.value){
                            equipmentTypeTpl(1,data.value);
                        }
                    });
                }
            });
        };

        var processingModeTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/processing_mode_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML;
                    var processingMode = document.getElementById('processingMode');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        processingMode.innerHTML = html;
                        if(data!=1 && data.processingMode!=null){
                            $("#processingMode").val(data.processingMode);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        var equipmentTypeTpl=function (data,differ) {
            if(differ!=null){
                admin.req({//获取字典请求
                    url: setter.remoteServiceAddress + "/market/sysdict/dicts/boiler_equipment_type"+differ
                    , done: function (result) {
                        var getDictTpl = SelectDictTpl.innerHTML;
                        var equipmentType = document.getElementById('equipmentType');
                        laytpl(getDictTpl).render(result.dicts, function(html){
                            equipmentType.innerHTML = html;
                            if(data!=1 && data.equipmentType!=null){
                                $("#equipmentType").val(data.equipmentType);
                            }
                        });
                        form.render(null, 'component-form-element');
                    }
                });
            }
        };

        var productionProcessTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/production_process_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML;
                    var productionProcess = document.getElementById('productionProcess');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        productionProcess.innerHTML = html;
                        if(data!=1 && data.productionProcess!=null){
                            $("#productionProcess").val(data.productionProcess);
                        }
                    });
                    form.render(null, 'component-form-element');
                }
            });
        };

        var getBaseInfo = editcominfoProductionProcess.innerHTML;
        if(differType==1){
            getBaseInfo = editcominfoProductionEquipment.innerHTML;
        }
        if(differType==2){
            getBaseInfo = editcominfoProductionMaterials.innerHTML;
        }
        if(differType==3){
            getBaseInfo = editcominfoProductionWater.innerHTML;
        }
        if(differType==4){
            getBaseInfo = editcominfoProductionEnergy.innerHTML;
        }
        if(differType==5){
            getBaseInfo = editcominfoProductionProduct.innerHTML;
        }
        if(differType==6){
            getBaseInfo = editcominfoOrganicLiquidStorageLoad.innerHTML;
        }
        if(differType==7){
            getBaseInfo = editcominfoProductionAndProcess.innerHTML;
        }
        if(pid!=null&pid!="undefined"){
            admin.req({//根据id获取该记录的详细信息
                url: baseurl + "/" + pid
                ,done: function(result){
                    if(result.code == 0){//成功6
                        var laboratorytechnician = document.getElementById('cominfoProductionProcess'+differType);
                        if(differType==6){
                            laytpl(getBaseInfo).render(result.organicLiquidStorageLoad, function(html){
                                laboratorytechnician.innerHTML = html;
                            });
                        }else if(differType==7){
                            laboratorytechnician =  document.getElementById('cominfoProductionAndProcessedit'+differType);
                            laytpl(getBaseInfo).render(result.cominfoProductionProcess, function(html){
                                laboratorytechnician.innerHTML = html;
                            });
                        }else{
                             laboratorytechnician = document.getElementById('cominfoProductionProcess'+differType);
                            laytpl(getBaseInfo).render(result.cominfoProductionProcess, function(html){
                                laboratorytechnician.innerHTML = html;
                                if(differType==1){
                                    booleanTpl(result.cominfoProductionProcess);
                                    equipmentClassifyTpl(result.cominfoProductionProcess);
                                    processingModeTpl(result.cominfoProductionProcess);
                                    equipmentTypeTpl(result.cominfoProductionProcess,result.cominfoProductionProcess.equipmentClassify);
                                    productionProcessTpl(result.cominfoProductionProcess);
                                }
                            });
                        }
                        $("[name='productionHome"+differType+"']").on("click",function () {
                            showAndHide();
                            table.reload("LAY-market-cominfoProductionProcess"+differType); //刷新表格
                        });
                        form.render(null, 'component-form-element');
                        // if(result.organicLiquidStorageLoad.url!=null){
                        //     $("#showPicture").attr("src",setter.remoteServiceAddress+result.organicLiquidStorageLoad.url);
                        // }
                       // form.render(null, 'component-form-element');
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
            var laboratorytechnician = document.getElementById('cominfoProductionProcess'+differType);
            laytpl(getBaseInfo).render(data, function(html){
                laboratorytechnician.innerHTML = html;
                if(differType==1){
                    booleanTpl(data);
                    equipmentClassifyTpl(data);
                    processingModeTpl(data);
                    productionProcessTpl(data);
                    // equipmentTypeTpl(data);
                }
            });

            $("[name='productionHome"+differType+"']").on("click",function () {
                showAndHide();
                table.reload("LAY-market-cominfoProductionProcess"+differType); //刷新表格
            });
            form.render(null, 'component-form-element');
        }

    }
};
