var centralize={
    editWin:function (admin,setter,$,table,form,baseurl,laytpl,laydate,element,differType,global_obj,pid,cid,getBaseInfo) {
        debugger
        var showAndHide=function () {
            $("#centralized0").removeClass("layui-hide");
            $("#centralized1").removeClass("layui-hide");
            $("#centralized2").removeClass("layui-hide");
            $("#comInfoCentralized0").addClass("layui-hide");
            $("#comInfoCentralized1").addClass("layui-hide");
            $("#comInfoCentralized2").addClass("layui-hide");
            $("#add").removeClass("layui-hide");
            $("#mod").removeClass("layui-hide");
            $("#del").removeClass("layui-hide");
        };

        if(pid!=null&pid!="undefined"){
            admin.req({//根据id获取该记录的详细信息
                url: baseurl + "/" + pid
                ,done: function(result){
                    if(result.code == 0){//成功
                        afterLoad(result.cominfoWasteProcessPlace);
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
            //需要占位，否则为空没法渲染
            afterLoad(1)
        }
        function afterLoad(data) {
            var laboratorytechnician = document.getElementById('comInfocentralized'+differType); //table 父级div相邻的下一个div
            laytpl(getBaseInfo).render(data, function(html){
                laboratorytechnician.innerHTML = html;
            });
            $("[name='centralized']").unbind();
            $("[name='centralized']").on("click",function () {
                showAndHide();
                table.reload("LAY-comInfo-centralized"+differType); //刷新表格
            });
            form.render(null, 'component-form-element');
        }

    }
};
