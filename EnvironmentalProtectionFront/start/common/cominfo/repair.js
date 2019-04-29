var repair={
    editWin:function (admin,setter,$,table,form,baseurl,laytpl,laydate,element,differType,global_obj,pid) {
        var showAndHide=function () {
            $("#repairAdd").removeClass("layui-hide");
            $("#repairMod").removeClass("layui-hide");
            $("#repairDel").removeClass("layui-hide");
            $("#import").removeClass("layui-hide");
            $("#cominfoRepair").removeClass("layui-hide");
            $("#cominfoRepairRecord").addClass("layui-hide");
        };

        var dateTime=function () {
            laydate.render({
                elem: "[name='repairDate']" //或 elem: document.getElementById('test')、elem: lay('#test') 等
                ,type: 'date'
                // ,value:new Date()
            });

        };

        var getBaseInfo = editcominfoRepairRecord.innerHTML;
        if(pid!=null&pid!="undefined"){
            admin.req({//根据id获取该记录的详细信息
                url: baseurl + "/" + pid
                ,done: function(result){
                    if(result.code == 0){//成功
                        afterLoad(result.cominfoRepairRecord);
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
            afterLoad(1);
        }
        function afterLoad(data) {
            var laboratorytechnician = document.getElementById('cominfoRepairRecord');
            laytpl(getBaseInfo).render(data, function(html){
                laboratorytechnician.innerHTML = html;
            });
            $("[name='repairHome']").on("click",function () {
                showAndHide();
                table.reload("LAY-cominfo-cominfoRepairRecord"); //刷新表格
            });
            dateTime();
            form.render(null, 'factor-form-element');
        }

    }
};
