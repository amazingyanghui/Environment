var factor={
    editWin:function (admin,setter,$,table,form,baseurl,laytpl,laydate,element,differType,global_obj,pid,mid) {
        var showAndHide=function () {
            $("#factorAdd").removeClass("layui-hide");
            $("#factorMod").removeClass("layui-hide");
            $("#factorDel").removeClass("layui-hide");
            $("#monitorPointFactor").removeClass("layui-hide");
            $("#onlineMonitorPointFactor").addClass("layui-hide");
        };

        //是否下拉框
        var booleanTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/boolean_type"
                , done: function (result) {
                    var getDictTpl = SelectDictTpl.innerHTML
                        ,useflag = document.getElementById('useflag');
                    laytpl(getDictTpl).render(result.dicts, function(html){
                        useflag.innerHTML = html;
                        $("#useflag").val(data.useflag);
                    });
                    form.render(null, 'factor-form-element');
                }
            });
        };

        //因子下拉框
        var factortTpl=function (data) {
            admin.req({//获取字典请求
                url: setter.remoteServiceAddress + "/online/onlinemonitorfactor/selectList/"+differType
                , done: function (result) {
                    var getSelectTpl = SelectTpl.innerHTML
                        ,fid = document.getElementById('fid');
                    laytpl(getSelectTpl).render(result.data, function(html){
                        fid.innerHTML = html;
                        $("#fid").val(data.fid);
                    });
                    form.render(null, 'factor-form-element');
                }
            });
        };


        var getBaseInfo = editonlineMonitorPointFactor.innerHTML;
        if(pid!=null&pid!="undefined"){
            admin.req({//根据id获取该记录的详细信息
                url: baseurl + "/" + pid
                ,done: function(result){
                    if(result.code == 0){//成功
                        var laboratorytechnician = document.getElementById('onlineMonitorPointFactor');
                        laytpl(getBaseInfo).render(result.onlineMonitorPointFactor, function(html){
                            laboratorytechnician.innerHTML = html;
                            booleanTpl(result.onlineMonitorPointFactor);
                            factortTpl(result.onlineMonitorPointFactor);
                        });
                        $("[name='factorHome']").on("click",function () {
                            showAndHide();
                            table.reload("LAY-online-onlineMonitorPointFactor"); //刷新表格
                        });
                        form.render(null, 'factor-form-element');
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
            var laboratorytechnician = document.getElementById('onlineMonitorPointFactor');
            laytpl(getBaseInfo).render(data, function(html){
                laboratorytechnician.innerHTML = html;
                booleanTpl(data);
                factortTpl(data);
            });
            $("[name='factorHome']").on("click",function () {
                showAndHide();
                table.reload("LAY-online-onlineMonitorPointFactor"); //刷新表格
            });
            form.render(null, 'factor-form-element');
        }

    }
};
