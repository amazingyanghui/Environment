layui.define(['jquery'], function (exports) {
    var $ = layui.jquery;
    var admin = layui.admin;
    var setter = layui.setter;
    var form = layui.form;
    var regionData = [];
    /**
     * 生成指定市，区县联动下拉组件
     * @param targetselect
     * @param grade
     * @param linkCode
     * @param data
     */
    var createLinkageSelect = function (formid, targetselect, grade, linkCode) {
        var reg = new RegExp("^" + linkCode);
        for (var i = 0; i < regionData.length; i++) {
            if (reg.test(regionData[i].short_code) && linkCode != regionData[i].short_code && grade == regionData[i].grade) {
                targetselect.append('<option value="' + regionData[i].short_code + '" >' + regionData[i].name + '</option>');
            }

        }
        var formComponentName = $("#" + formid).attr("lay-filter");
        form.render(null, formComponentName);
    }
    var obj = {
        /**
         * 得到省市区县的联动组件
         * @param formid 表单 可缺省
         * @param tagetDiv 目标DIV 可缺省
         * @param province 指定省份 可缺省
         * @param formComponent 表单的过滤器，可缺省 默认是component-form-element
         */
        getRegionComponent: function (formid, $tagetDiv, province, callback) {
            var formComponentName = $("#" + formid).attr("lay-filter");
            var $regiondiv = $("#form_regiondiv");
            admin.req({
                url: setter.remoteServiceAddress + "/sys/config/regions",
                async: false,
                data: {
                    "province": province
                },
                done: function (result) {
                    $tagetDiv.html($regiondiv.html());
                    regionData = result.regions;
                    var provinceFilter = formid + "region_province";
                    var cityFilter = formid + "region_city";
                    var districtFilter = "region_district";
                    $("#" + formid + " [name=region_province]").attr("lay-filter", provinceFilter);
                    $("#" + formid + " [name=region_city]").attr("lay-filter", cityFilter);
                    for (var j = 0; j < regionData.length; j++) {
                        if (province != '') {
                            if (regionData[j].grade == 1) {
                                $("#" + formid + " [name=region_province]").append('<option value="' + regionData[j].short_code + '" selected="">' + regionData[j].name + '</option>');
                            }
                            if (regionData[j].grade == 2) {
                                $("#" + formid + " [name=region_city]").append('<option value="' + regionData[j].short_code + '">' + regionData[j].name + '</option>');
                            }
                            if (regionData[j].grade == 3) {
                                $("#" + formid + " [name=region_district]").append('<option value="' + regionData[j].short_code + '" >' + regionData[j].name + '</option>');
                            }
                        } else {
                            // 不指定省时只初始化省份选择
                            if (regionData[j].grade == 1) {
                                $("#" + formid + " [name=region_province]").append('<option value="' + regionData[j].short_code + '" >' + regionData[j].name + '</option>');
                            }
                        }

                    }

                    form.on('select(' + provinceFilter + ')', function (data) {
                        $("#" + formid + " [name=region_city]").attr("lay-filter", cityFilter);
                        $("#" + formid + " [name=region_city]").html('<option value="">请选择市</option>');
                        $("#" + formid + " [name=region_district]").html('<option value="">请选择县/区</option>');
                        createLinkageSelect(formid, $("#" + formid + " [name=region_city]"), 2, data.value, regionData);
                        if (callback != undefined) {
                            callback();
                        }
                    });
                    form.on('select(' + cityFilter + ')', function (data) {
                        $("#" + formid + " [name=region_district]").html('<option value="">请选择县/区</option>');
                        createLinkageSelect(formid, $("#" + formid + " [name=region_district]"), 3, data.value, regionData);
                        if (callback != undefined) {
                            callback();
                        }
                    });

                    form.on('select(' + districtFilter + ')', function (data) {
                        if (callback != undefined) {
                            callback();
                        }
                    });
                    form.render(null, formComponentName);
                }


            });
            //模板只生成一次
            // if ($('#region_province').children().size() > 1) {
            //     return $regiondiv.html();
            // } else {
            //
            //     return $regiondiv.html();
            // }
        },
        /**
         * 设置区域选中
         * @param selected
         */
        setRegionSelect: function (formid, selected) {
            selected = selected == undefined ? "" : selected;
            $("#" + formid + " [name=region_city]").html('<option value="">请选择市</option>');
            $("#" + formid + " [name=region_district]").html('<option value="">请选择县/区</option>');
            var province = selected.substring(0, 2);
            $("#" + formid + " [name=region_province]").val(province);
            var city = selected.substring(0, 4);
            createLinkageSelect(formid, $("#" + formid + " [name=region_city]"), 2, province);
            $("#" + formid + " [name=region_city]").val(city);
            createLinkageSelect(formid, $("#" + formid + " [name=region_district]"), 3, city);
            $("#" + formid + " [name=region_district]").val(selected);
            var formComponentName = $("#" + formid).attr("lay-filter");
            form.render(null, formComponentName);

        },

        /**
         * 获取选中区划
         * @param selected
         */
        getRegionValue: function (formid) {
            if ($("#" + formid + " [name=region_district]").val() != "") {
                return $("#" + formid + " [name=region_district]").val();
            } else {
                if ($("#" + formid + " [name=region_city]").val() != "") {
                    return $("#" + formid + " [name=region_city]").val();
                } else {
                    return $("#" + formid + " [name=region_province]").val();
                }
            }
        },
        generateUUID: function () {
            var d = new Date().getTime();
            var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
                var r = (d + Math.random() * 16) % 16 | 0;
                d = Math.floor(d / 16);
                return (c == 'x' ? r : (r & 0x3 | 0x8)).toString(16);
            });
            return uuid;
        },
        /**
         * 获取周期组件
         */
        createCycleComponent: function (formid, targetDiv) {
            var systemDate = new Date();
            var month = parseInt(systemDate.getMonth()) + 1;
            var yearOptions = '';
            for (var i = 0; i < 5; i++) {
                var year = parseInt(systemDate.getFullYear()) - i;
                if (i==0) {
                    yearOptions += '<option value="' + year + '" selected="selected">' + year + '</option>';
                }else {
                    yearOptions += '<option value="' + year + '">' + year + '</option>';
                }
            }
            var layFilter  = formid+"_cycle_type";
            var labelClass = "layui-form-label";    //表单组件
            if(/search_form$/.test(formid)){
                labelClass = "mylabel";     //搜索条件
            }
            // var cycleCompontDiv = '   <label class="layui-form-label">申报周期：</label>\n' +     // editForm ， 适配
            var cycleCompontDiv = '   <label class="'+labelClass+'">申报周期：</label> ' +       // search  ， 适配
                '    <div class="layui-input-inline querySelect" >' +
                '        <select  lay-verify="required" lay-search="" lay-filter="'+layFilter+'" name="cycle_type">' +
                '            <option value="1">年度检测</option>' +
                '            <option value="2">半年检测</option>' +
                '            <option value="3">季度检测</option>' +
                '            <option value="4">月度检测</option>' +
                '        </select>' +
                '    </div>' +
                '    <div class="layui-input-inline querySelect">' +
                '        <select  lay-search="" lay-filter="cycle_value1" name="cycle_value1">' +
                yearOptions +
                '        </select>' +
                '    </div>' +
                '    <div class="layui-input-inline querySelect cycle_value2_div">' +
                '        <select   lay-search="" lay-filter="cycle_value2" name="cycle_value2">' +
                '        </select>' +
                '    </div>';
            $(targetDiv).html(cycleCompontDiv);
            $("#"+formid+ " .cycle_value2_div").hide();
            var formComponentName = $("#" + formid).attr("lay-filter");
            form.render(null, formComponentName);
            form.on('select('+layFilter+')', function (data) {
                // 选中年度检测
                if (data.value == '1') {
                    $("#" + formid + " [name=cycle_value2]").html('');
                    $("#" + formid + " [name=cycle_value1]").html(yearOptions);
                    $("#" + formid + " [name=cycle_value2]").parent().hide();
                    form.render(null, formComponentName);
                }
                // 选中半年检测
                if (data.value == '2') {
                    $("#" + formid + " [name=cycle_value1]").html(yearOptions);
                    if (month>6) {
                        $("#" + formid + " [name=cycle_value2]").html('<option value="1">上半年</option><option value="2" selected = "selected">下半年</option>');
                    }else {
                        $("#" + formid + " [name=cycle_value2]").html('<option value="1" selected = "selected">上半年</option><option value="2">下半年</option>');
                    }
                    $("#" + formid + " [name=cycle_value2]").parent().show();
                    form.render(null, formComponentName);
                }
                // 选中季度检测
                if (data.value == '3') {
                    $("#" + formid + " [name=cycle_value1]").html(yearOptions);
                    if (month>2 && month<4) {
                        $("#" + formid + " [name=cycle_value2]").html('<option value="1" selected = "selected">第一季度</option><option value="2">第二季度</option><option value="3">第三季度</option><option value="4">第四季度</option>');
                    }
                    if (month>3 && month<7) {
                        $("#" + formid + " [name=cycle_value2]").html('<option value="1" >第一季度</option><option value="2" selected = "selected">第二季度</option><option value="3">第三季度</option><option value="4">第四季度</option>');
                    }
                    if (month>6 && month<10) {
                        $("#" + formid + " [name=cycle_value2]").html('<option value="1" >第一季度</option><option value="2" >第二季度</option><option value="3" selected = "selected">第三季度</option><option value="4">第四季度</option>');
                    }
                    if (month>9 && month<13) {
                        $("#" + formid + " [name=cycle_value2]").html('<option value="1" >第一季度</option><option value="2">第二季度</option><option value="3">第三季度</option><option value="4" selected = "selected">第四季度</option>');
                    }
                    $("#" + formid + " [name=cycle_value2]").parent().show();
                    form.render(null, formComponentName);
                }
                // 选中月度检测
                if (data.value == '4') {
                    $("#" + formid + " [name=cycle_value1]").html('');
                    for (var i=1;i<13;i++) {
                        if (i == month) {
                            $("#" + formid + " [name=cycle_value1]").append('<option value="'+i+'" selected = "selected">'+systemDate.getFullYear()+'-'+i+'</option>');
                        }else {
                            $("#" + formid + " [name=cycle_value1]").append('<option value="'+i+'">'+systemDate.getFullYear()+'-'+i+'</option>');
                        }
                        form.render(null, formComponentName);
                    }
                    $("#" + formid + " [name=cycle_value2]").html('');
                    $("#" + formid + " [name=cycle_value2]").parent().hide();
                }
            });
        },

        /**
         * 设置周期组件选中
         * @param formId
         * @param value
         */
        getCycleComponent: function (formid) {
            var cycleType = $("#" + formid + " [name=cycle_type]").val();
            var cycleTypeText = $("#" + formid + " [name=cycle_type] option:selected").text();
            var cycleValue1Text = $("#" + formid + " [name=cycle_value1] option:selected").text();
            var cycleValue2Text = $("#" + formid + " [name=cycle_value2] option:selected").text();
            if (cycleType != "") {
                if (cycleValue2Text !=""){
                    return cycleTypeText + "(" + cycleValue1Text + ")" + cycleValue2Text;
                }else{
                    var year = cycleValue1Text.split("-");
                    if (year.length>1) {
                        return cycleTypeText + "(" + year[0] + ")" + year[1] + "月" ;
                    }else {
                        return cycleTypeText + "(" + cycleValue1Text + ")";
                    }
                }
            }
        }

    };
    exports('bizComponent', obj);
});
