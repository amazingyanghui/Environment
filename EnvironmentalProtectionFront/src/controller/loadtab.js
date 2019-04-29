layui.define(['jquery'], function (exports) {
    var $ = layui.jquery;
    var setter = layui.setter;
    var admin = layui.admin;
    /**
     * 供obj内部调用
     * @param path
     */
    var obj = {
        /**
         * 加载tab页面
         * _dom：存放tab选项卡的根元素
         * curPageIndex：当前页的tab索引
         */
        tab:function (_pageid,_dom){
            var values = location.hash.split("pid=");
            var pid = values[1];

            if(layui.data(setter.userRoles).userRoles.indexOf(setter.companyRoleId) !== -1){
                pid = layui.data(setter.userDeptId).userDeptId;
            }
            var permissionNames = layui.data(setter.permissionName).permissionName;
            // alert(permissionNames)
            // wryqk:jbxx
            // wryqk:hjglsx
            if(_pageid != -1){
                var layuicard = $("<div>").addClass("layui-card");
                if(_dom){
                    _dom.append(layuicard);
                }else{
                    $("#LAY-tab").append(layuicard);
                }
                var layuitab = $("<div>").addClass("layui-tab layui-tab-brief");
                layuicard.append(layuitab);
                var _ul = $("<ul>").addClass("layui-tab-title");
                layuitab.append(_ul);
                var tabArrayTemp = [
                    {'id':'jb:xx:xxwh','objid':'baseinfo','name':'基本信息','href':'cominfo/baseinfo//pid='+pid}
                    ,{'id':'hj:gl:xxwh','objid':'environmental','name':'环境管理','href':'cominfo/environmental/attributes/pid='+pid}
                    ,{'id':'sc:gy:xxwh','objid':'production','name':'生产工艺','href':'cominfo/production/process/pid='+pid}
                    ,{'id':'pf:yjc:xxwh','objid':'online','name':'排放与监测','href':'cominfo/online/portinfo/pid='+pid}
                    ,{'id':'zl:ss:xxwh','objid':'measure','name':'治理设施','href':'cominfo/measure/wastewater/pid='+pid}
                    ,{'id':'hj:yw:xxwh','objid':'environmenttraffic','name':'环境业务','href':'cominfo/environmenttraffic/buildproject/pid='+pid}
                    ,{'id':'hj:yj:xxwh','objid':'emergency','name':'环境应急','href':'cominfo/emergency/system/pid='+pid}
                    ,{'id':'tw:sdj:xxwh','objid':'nuclearradiation','name':'同位素登记','href':'cominfo/nuclearradiation//pid='+pid}
                    // ,{'id':'jc:sj:xxwh','objid':'monitordata','name':'监测数据','href':'cominfo/monitordata//pid='+pid}
                    ,{'id':'cl:cs:xxwh','objid':'wasteprocessplace','name':'废物产生与利用','href':'cominfo/wasteprocessplace//pid='+pid}
                    ,{'id':'fs:xjc:xxwh','objid':'radioactiveore','name':'放射性监测','href':'cominfo/radioactiveore//pid='+pid}
                    ,{'id':'jz:sqyyxqk:xxwh','objid':'centralized','name':'集中式企业运行情况','href':'cominfo/centralized//pid='+pid}
                    // ,{'id':'hjjc:xxwh','objid':'environmentmonitor','name':'环境监察','href':'cominfo/environmentmonitor/record/pid='+pid}
                    ];
                var tabArray = [];
                if(layui.data(setter.userId).userId != setter.superAdmin){
                    for(var i = 0 ; i < tabArrayTemp.length; i++){
                        if(JSON.stringify(permissionNames).indexOf(tabArrayTemp[i].id) !== -1){
                            tabArray.push(tabArrayTemp[i]);
                        }
                    }
                }else{
                    tabArray = tabArrayTemp;
                }

                for(var i = 0 ; i < tabArray.length; i++){
                    var tabobj = tabArray[i];
                    var _li = $("<li>");
                    var _a = $("<a>").attr("lay-href",tabobj.href).text(tabobj.name);
                    if(tabobj.objid == _pageid){
                        _a.addClass("layui-this");
                    }

                    _li.append(_a);
                    _ul.append(_li);
                }
            }
            var baseurl = setter.remoteServiceAddress + "/market/cominfobaseinfo";
            admin.req({//根据id获取该记录的详细信息
                url: baseurl + "/" + pid
                ,done: function(result){
                    if(result.code == 0){//成功
                        $("#tabCompanyName").text(result.cominfoBaseinfo.companyName);
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
        },
        /**
         * 加载tab页面(园区管理)
         * _dom：存放tab选项卡的根元素
         * curPageIndex：当前页的tab索引
         */
        zonetab:function (_pageid,_dom){
            var values = location.hash.split("pid=");
            var pid = values[1];

            if(layui.data(setter.userRoles).userRoles.indexOf(setter.companyRoleId) !== -1){
                pid = layui.data(setter.userDeptId).userDeptId;
            }
            var permissionNames = layui.data(setter.permissionName).permissionName;
            // alert(permissionNames)
            // wryqk:jbxx
            // wryqk:hjglsx
            if(_pageid != -1){
                var layuicard = $("<div>").addClass("layui-card");
                if(_dom){
                    _dom.append(layuicard);
                }else{
                    $("#LAY-tab").append(layuicard);
                }
                var layuitab = $("<div>").addClass("layui-tab layui-tab-brief");
                layuicard.append(layuitab);
                var _ul = $("<ul>").addClass("layui-tab-title");
                layuitab.append(_ul);
                var tabArrayTemp = [
                    {'id':'jb:xx:xxwh','objid':'zonebaseinfo','name':'基本信息','href':'zoneinfo/baseinfo//pid='+pid}
                    ,{'id':'hj:gl:xxwh','objid':'leadingindustry','name':'主导行业及占比','href':'zoneinfo/leadingindustry//pid='+pid}
                    ,{'id':'sc:gy:xxwh','objid':'sewagediversion','name':'清污分流','href':'zoneinfo/sewagediversion//pid='+pid}
                    ,{'id':'pf:yjc:xxwh','objid':'centralization','name':'集中式管理','href':'zoneinfo/centralization//pid='+pid}
                    ,{'id':'pf:yjc:xxwh','objid':'monitorpoint','name':'监测站点','href':'zoneinfo/monitorpoint//pid='+pid}
                ];
                var tabArray = [];
                if(layui.data(setter.userId).userId != setter.superAdmin){
                    for(var i = 0 ; i < tabArrayTemp.length; i++){
                        if(JSON.stringify(permissionNames).indexOf(tabArrayTemp[i].id) !== -1){
                            tabArray.push(tabArrayTemp[i]);
                        }
                    }
                }else{
                    tabArray = tabArrayTemp;
                }

                for(var i = 0 ; i < tabArray.length; i++){
                    var tabobj = tabArray[i];
                    var _li = $("<li>");
                    var _a = $("<a>").attr("lay-href",tabobj.href).text(tabobj.name);
                    if(tabobj.objid == _pageid){
                        _a.addClass("layui-this");
                    }

                    _li.append(_a);
                    _ul.append(_li);
                }
            }
            var baseurl = setter.remoteServiceAddress + "/zoneinfo/zoneinfobaseinfo";
            admin.req({//根据id获取该记录的详细信息
                url: baseurl + "/" + pid
                ,done: function(result){
                    if(result.code == 0){//成功
                        $("#tabZoneName").text(result.zoneinfoBaseinfo.zoneName);
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
        },
        /**
         * 信息维护权限
         * _dom :权限标识
         */
        power:function (dom_tab,dom_table){
            var permissionNames = layui.data(setter.permissionName).permissionName;
            if(dom_tab){
                $('#'+dom_tab+' li').each(function () {
                    if(JSON.stringify(permissionNames).indexOf($(this).attr("power")) === -1
                        && layui.data(setter.userId).userId != setter.superAdmin){
                        $(this).remove();
                        $(this).empty();
                    }
                });
            }

            if(dom_table){
                $('#'+dom_table+' .layui-tab-item').each(function () {
                    if(JSON.stringify(permissionNames).indexOf($(this).attr("power")) === -1
                        && layui.data(setter.userId).userId != setter.superAdmin){
                        $(this).remove();
                        $(this).empty();
                    }
                });
            }
        }
    };
    exports('loadtab', obj);
});
