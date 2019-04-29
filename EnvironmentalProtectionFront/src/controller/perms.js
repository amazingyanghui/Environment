layui.define(['jquery'], function (exports) {
    var $ = layui.jquery;
    var setter = layui.setter;
    /**
     * 供obj内部调用
     * @param path
     */
    var obj = {
        /**
         * 根据按钮的perm属性判断是否有权限显示
         */
        doPerm: function () {
            if(layui.data(setter.userId).userId != setter.superAdmin){//系统超级管理员
                $('.layui-btn').each(function () {
                    if($(this).attr("perm")){
                        if(!(layui.data(setter.permissionName).permissionName.indexOf($(this).attr("perm")) == -1)){
                            $(this).show();
                        }else{
                            $(this).hide();
                        }
                    }
                });
            }
        }
        /**
         * 获取指定的URL参数值
         * URL:http://www.quwan.com/index?name=tyler
         * 参数：paramName URL参数
         * 调用方法:getParam("name")
         * 返回值:tyler
         */
        ,getParam: function(paramName,url) {
            var paramValue = "", isFound = !1;
            if (url.indexOf("?") == 0 && url.indexOf("=") > 1) {
                arrSource = unescape(url).substring(1, url.length).split("&"), i = 0;
                while (i < arrSource.length && !isFound) arrSource[i].indexOf("=") > 0 && arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase() && (paramValue = arrSource[i].split("=")[1], isFound = !0), i++
            }
            return paramValue == "" && (paramValue = null), paramValue
        }
        /**
         * 判断当前登录用户是否居然领导者权限
         */
        ,isLeader: function () {
            var isLead = false;//是否领导人角色
            var roles = layui.data(setter.userRoles).userRoles;
            var rolesnew = roles.replace("[","").replace("]","").replace(/^\"|\"$/g,'');
            var rolesnewArray = rolesnew.split(",");
            for(var i = 0 ; i < rolesnewArray.length;i++){
                var rolesnewTemp = parseInt(rolesnewArray[i]);
                if(setter.leadAdmin.indexOf(rolesnewTemp) !== -1){
                    isLead = true;
                    break;
                }
            }
            return isLead;
        }
    };
    exports('perms', obj);
});
