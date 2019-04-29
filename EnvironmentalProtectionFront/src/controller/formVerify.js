layui.define(['jquery'], function (exports) {
    var form=layui.form;
    var $ = layui.jquery;
    var admin = layui.admin;
    var layer = layui.layer;
    var setter = layui.setter;

    var objVerify=function () {
        obj.verifyForm();
    };

    /* 自定义验证规则 */
    var obj={
        verifyForm:function () {
            form.verify({
                numberSize: function(value){
                    if(value.length > 15){
                        return '字数不能超过15个字符！';
                    }
                }
                ,nullNumberSize: function(value,item){//有值判断
                    if(value.length > 0){
                        var nump=/^[0-9]*$/;
                        if(!nump.test(value)){
                            return '必须为数字！';
                        }
                    }
                }
                ,nullNumberFormat:function (value,item) {//不为空判断
                    if(value.length>0 ){
                        var numP=/(^0(\.\d{1,2})?$)|(^[1-9]\d*(\.\d{1,2})?$)/;
                        if(!numP.test(value)){
                            return "格式不正确，保留2位小数！";
                        }
                    }
                }
                ,nullNumber:function (value,item) {
                    if(value.length>0){
                        var numP= /\d+$|\d+[.]?\d+$/;
                        if(!numP.test(value)){
                            return "请输入数字！";
                        }
                    }
                }
                ,longitudeVerify:function (value,item) {//不为空判断
                    if(value.length>0 ){
                        var numP = /^(\-|\+)?(((\d|[1-9]\d|1[0-7]\d|0{1,3})\.\d{0,})|(\d|[1-9]\d|1[0-7]\d|0{1,3})|180\.0{0,}|180)$/;
                        if(!numP.test(value)){
                            return "请输入正确的经度！";
                        }
                    }
                }
                ,latitudeVerify:function (value,item) {//不为空判断
                    if(value.length>0 ){
                        var numP = /^(\-|\+)?([0-8]?\d{1}\.\d{0,}|90\.0{0,}|[0-8]?\d{1}|90)$/;
                        if(!numP.test(value)){
                            return "请输入正确的纬度！";
                        }
                    }
                }
                ,numberFormat: function (value,item) {
                    var numP=/(^0(\.\d{1,2})?$)|(^[1-9]\d*(\.\d{1,2})?$)/;
                    if(!numP.test(value)){
                        return "格式不正确，保留2位小数！";
                    }
                }
                ,ShistringSize: function(value){
                    if(value.length > 10){
                        return '字数不能超过10个字符！';
                    }
                }
                ,erShistringSize: function(value){
                    if(value.length > 20){
                        return '字数不能超过20个字符！';
                    }
                }
                ,stringSize: function(value){
                    if(value.length > 30){
                        return '字数不能超过30个字符！';
                    }
                }
                ,SanShiLiuSize: function(value){
                    if(value.length > 36){
                        return '字数不能超过36个字符！';
                    }
                }
                ,strSize:function (value) {
                    if(value.length > 50){
                        return '字数不能超过50个字符！';
                    }
                }
                ,bigStrSize:function(value){
                    if(value.length > 400){
                        return '字数不能超过400个字符！';
                    }
                }
                ,wuBaiSize:function(value){
                    if(value.length > 500){
                        return '字数不能超过500个字符！';
                    }
                }
                ,bigSize:function(value){
                    if(value.length > 3000){
                        return '字数不能超过3000个字符！';
                    }
                }
                ,centerSize:function (value) {
                    if(value.length > 1000){
                        return '字数不能超过1000个字符！';
                    }
                }
                ,centerStrSize:function(value){
                    if(value.length > 200){
                        return '字数不能超过200个字符！';
                    }
                }
                ,midCenterStrSize:function(value){
                    if(value.length > 150){
                        return '字数不能超过150个字符！';
                    }
                }
                ,smallStrSize:function(value){
                    if(value.length > 100){
                        return '字数不能超过100个字符！';
                    }
                }
                ,specialCharacter:function (value) {//有值判断,input类型（不包含数字）
                    if(value.length>0){
                        var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>《》/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]");
                        if(pattern.test(value)){
                            return "包含特殊字符！";
                        }
                    }
                }
                ,strSpecialCharacter:function (value) {//有值判断,textarea类型（或一段文字时）
                    if(value.length>0){
                        var pattern = new RegExp("[`~@#$^&*=|{}\\[\\]<>《》/~@#￥……&*——|{}【】]");
                        if(pattern.test(value)){
                            return "包含特殊字符！";
                        }
                    }
                }
                ,emailVerify:function (value) {
                    if(value.length>0){
                        var pattern = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
                        if(!pattern.test(value)){
                            return "请输入正确的邮箱地址！"
                        }
                    }
                }
                ,username: function(value, item){ //value：表单的值、item：表单的DOM对象

                    if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                        return '不能有特殊字符';
                    }
                    if(/(^\_)|(\__)|(\_+$)/.test(value)){
                        return '首尾不能出现下划线\'_\'';
                    }
                    if(/^\d+\d+\d$/.test(value)){
                        return '不能全为数字';
                    }
                }
                ,pass: [
                    /^[A-Za-z0-9]{6,20}$/
                    ,'密码必须6到20位，至少必须包含字母和数字！'
                ]
                ,phoneVerify:function (value) {
                    if(value.length>0){
                        var pattern=new RegExp("^((0\\d{2,3}-\\d{7,8})|(1[3584]\\d{9}))$");
                        if(!pattern.test(value)){
                            return "请输入正确的电话号码！"
                        }
                    }
                }
                ,faxNumber:function (value) {
                    if(value.length>0){
                        var pattern=/^(\d{3,4}-)?\d{7,8}$/;
                        if(!pattern.test(value)){
                            return "请输入正确的传真号码！"
                        }
                    }
                }
                ,urlNumber:function (value) {
                    if(value.length>0){
                        var pattern=/^(https?|ftp|file):\/\/[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]$/;
                        if(!pattern.test(value)){
                            return "请输入正确的url！"
                        }
                    }
                }
                ,amountUnit:function(value){
                    if(value.length>0 ){
                       var reg=/^([1-9]\d*|[0]{1,1})$/;
                        if(!reg.test(value)){
                            return "请输入正整数！"
                        }
                    }

                }
                ,unifiedSocialCreditCode:function (value) {
                    if(value.length>0){
                        var pattern=new RegExp("^[0-9A-Z]{18}$");
                        if(!pattern.test(value)){
                            return "请输入正确的统一社会信用代码！"
                        }
                    }
                }
                ,organizationCode:function (value) {
                    if(value.length>0){
                        var pattern=new RegExp("^[a-zA-Z0-9]{8}-[a-zA-Z0-9]$");
                        if(!pattern.test(value)){
                            return "请输入正确的组织机构代码！"
                        }
                    }
                }
                ,businessLicenseCode:function (value) {
                    if(value.length>=0 && value.length < 38){
                        //var pattern=new RegExp("^[0-9]");
                        //if(!pattern.test(value)){
                        //    return "请输入正确的营业执照代码！"
                        //}
                    }else{
                        return "请输入正确的营业执照代码！"
                    }
                }
                ,zipCode:function (value) {
                    if(value.length>0){
                        var pattern=new RegExp("^[0-9]{6}$");
                        if(!pattern.test(value)){
                            return "请输入正确的邮政编码！"
                        }
                    }
                }
                ,bankCardNumber:function (value) {
                    if(value.length>0){
                        var pattern=new RegExp("^([1-9]{1})(\d{14}|\d{18})$");
                        if(!pattern.test(value)){
                            return "请输入正确的银行卡号！"
                        }
                    }
                }
                ,
                proportion:function (value) {
                    if(value.length>0){
                        var reg=new RegExp("^(((\\d{1,2})[.]((\\d{1,2})?))|100|(?:0|[1-9][0-9]?)|100.00|100.0)$");
                        if(!reg.test(value)){
                            return"请输入0-100的数，且最多有两位小数！"
                        }

                    }
                }
            });
        }
    };

    exports('formVerify', obj);

});
