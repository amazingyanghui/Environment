layui.define(['jquery'], function (exports) {
    var $ = layui.jquery;
    var admin = layui.admin;
    var setter = layui.setter;
    var form = layui.form;
    var regionData = [];
    var obj = {
        /**
         * 获取组件
         */
        createComponent: function (formid, targetDiv) {
            var systemDate = new Date();
            var month = parseInt(systemDate.getMonth()) + 1;
            var yearOptions = '';
            var quarterOptions = '';
            for (var i = 0; i < 5; i++) {
                var year = parseInt(systemDate.getFullYear()) - i;
                if (i==0) {
                    yearOptions += '<option value="' + year + '" selected="selected">' + year + '</option>';
                }else {
                    yearOptions += '<option value="' + year + '">' + year + '</option>';
                }
            }
            var labelClass = "layui-form-label";    //表单组件
            if(/search_form$/.test(formid)){
                labelClass = "mylabel";     //搜索条件
            }
            if (month>2 && month<4) {
                quarterOptions = '<option value="1" selected = "selected">第一季度</option><option value="2">第二季度</option><option value="3">第三季度</option><option value="4">第四季度</option>';
            }
            if (month>3 && month<7) {
                quarterOptions = '<option value="1" >第一季度</option><option value="2" selected = "selected">第二季度</option><option value="3">第三季度</option><option value="4">第四季度</option>';
            }
            if (month>6 && month<10) {
                quarterOptions = '<option value="1" >第一季度</option><option value="2" >第二季度</option><option value="3" selected = "selected">第三季度</option><option value="4">第四季度</option>';
            }
            if (month>9 && month<13) {
                quarterOptions = '<option value="1" >第一季度</option><option value="2">第二季度</option><option value="3">第三季度</option><option value="4" selected = "selected">第四季度</option>';
            }
            var cycleCompontDiv = '   <label class="'+labelClass+'">上报时间：</label> ' +
                '    <div class="layui-input-inline querySelect">' +
                '        <select lay-verify="required" lay-search="" name="year_value">' +  // lay-filter="'+layFilter+'"
                yearOptions +
                '        </select>' +
                '    </div>' +
                '    <div class="layui-input-inline querySelect quarter_value_div">' +
                '        <select   lay-search="" lay-filter="quarter_value" name="quarter_value">' +
                quarterOptions +
                '        </select>' +
                '    </div>';
            $(targetDiv).html(cycleCompontDiv);
            var formComponentName = $("#" + formid).attr("lay-filter");
            form.render(null, formComponentName);
        },

        /**
         * 设置选中
         * @param selected
         */
        setComponentValue: function ( data , formId) {
            var data1 = data.reportSection;
            var valArr = data1.split("-");
            var year = valArr[0];
            var quarter = valArr[1];
            quarter = quarter == "第一季度" ? '1' : "第二季度" ? '2' : "第三季度" ? '3' : "第四季度" ? '4' : '1';
            $(`#${formId} select[name='year_value']`).next().find('.layui-anim').children(`dd[lay-value="${year}"]`).click();
            $(`#${formId} select[name='quarter_value']`).next().find('.layui-anim').children(`dd[lay-value="${quarter}"]`).click();
            form.render(null, formId);
        },

        /**
         * 获得值
         * @param formId
         * @param value
         */
        getComponentValue: function (formId) {
            var yearValue = $("#"+formId+" [name='year_value'] option:selected").val();
            var quarter_value = $("#"+formId+" [name='quarter_value'] option:selected").text();
            return yearValue+"-"+quarter_value;
        }
    };
    exports('quarterlyCycle', obj);
});
