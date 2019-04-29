layui.define(['jquery'], function (exports) {
    var $ = layui.jquery;
    var admin = layui.admin;
    var table = layui.table;
    var setter = layui.setter;
    var laydate = layui.laydate;
    var dictobj = {
        /**
         *
         * @param dictType  字典类型
         * @param selectId  生成的select的ID ，如果不指定的话只返回select下的option值
         * @param selectClass 指定select的CLASS
         * @returns {string}
         */
        getDictSelect: function (dictType, selectId, selectClass) {
            if (selectClass == undefined) {
                selectClass = '';
            }
            // 加一层DIV是因为layui中使用templet时必须嵌套DIV
            var select = '<div><select lay-verify="required" ' + ' lay-ignore="true"' + ' name="' + selectId + '" id="' + selectId+ '" class="' + selectClass + '">';
            if (selectId==undefined) {
                select = '';
            }
            admin.req({//
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/" + dictType
                , async: false
                , done: function (result) {
                    if (result.code == 0) {//成功
                        var dicts = result.dicts;
                        for (var i = 0; i < dicts.length; i++) {
                            select += '<option value="' + dicts[i].key + '">' + dicts[i].value + '</option>';
                        }
                    }
                }
            });
            if (selectId!=undefined) {
                select += '</select></div>';
            }
            return select;

        },
        /**
         * 表格中的字段保存的字典KEY转为字典值
         * @param dictkey
         * @param realvalue
         */
        getDictValueForTable: function (dictType, realkey) {
            var value = "";
            admin.req({//
                url: setter.remoteServiceAddress + "/market/sysdict/dicts/" + dictType
                , async: false
                , done: function (result) {
                    if (result.code == 0) {//成功
                        var dicts = result.dicts;
                        for (var i = 0; i < dicts.length; i++) {
                            if (dicts[i].key == realkey) {
                                value = '<div><span>' + dicts[i].value + '</span></div>';
                            }
                        }
                    }
                }
            });
            return value;
        },
        /**
         * 根据字典生成单选按钮组
         * @param dictType
         * @param radioClass
         */
        getDictRadioGroup: function (dictType,radioClass) {
            // TODO
        },
        /**
         * 根据字典生成复选框组
         * @param dictType
         * @param checkClass
         */
        getDictRadioGroup: function (dictType,checkClass) {
            // TODO
        }
    };

    exports('dictComponent', dictobj);
});
