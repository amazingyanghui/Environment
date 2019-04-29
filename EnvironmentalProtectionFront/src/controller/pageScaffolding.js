layui.define(['jquery',"formSelects"], function (exports) {
    // var $ = layui.jquery;
    var table = layui.table;
    var layer = layui.layer;
    var setter = layui.setter;
    var laydate = layui.laydate;
    var admin = layui.admin;
    var laytpl = layui.laytpl;
    var form = layui.form;
    var affachCompontent = layui.attachment;
    var bizComponent = layui.bizComponent;
    // layui表格对象
    var objtable = {};
    var treeComponent = layui.treeComponent;
    var formSelects = layui.formSelects;
    var queryMaxWidth = null;     //保存查询表单实体父容器宽度
    /**
     * 算出最大块级有值宽度,不考虑内联div与别的容器混放在一个容器内，内部调用
     * @param dom 表单元素jquery
     * @returns {*}  innerWidth()计算padding，width()不计算padding
     */
    var getParentWidth = function (dom) {
        var parent = dom.parent();
        if (parent != undefined && parent.width() > 0) {
            queryMaxWidth = parent.width();
            return;
        } else {
            getParentWidth(parent);
        }
    }

    var getRequiredIcon = function () {
        return '<span  style="color: red;font-size:14px;font-weight:900;text-align:center;">*</span>';
    }

    // 生成通用查询条件
    var createQueryCriteria = function (formid) {
        var formdata = serializeFormObject(formid);
        var tablewhere = {};
        var likeColunms = [];
        var equalColumns = [];
        for (var attr in formdata) {
            var $input = $('#' + formid + ' input[name=' + attr + ']');
            if ($input.length > 0 && $input.val() != '') {
                if (attr == 'startDate') {
                    tablewhere.startDate = formdata[attr];
                } else if (attr == 'endDate') {
                    tablewhere.endDate = formdata[attr];
                } else {
                    likeColunms.push({column: attr, value: formdata[attr]});
                }
            } else {
                if (attr == 'startDate') {
                    tablewhere.startDate = "";
                }
                if (attr == 'endDate') {
                    tablewhere.endDate = "";
                }
            }
            var $select = $('#' + formid + ' select[name=' + attr + ']');
            if ($select.length > 0 && $select.val() != '') {
                equalColumns.push({column: attr, value: formdata[attr]});
            }
        }
        var regionCode = bizComponent.getRegionValue(formid);
        if (regionCode != "") {
            equalColumns.push({column: "regionCode", value: regionCode});
        }
        tablewhere.likeColumns = likeColunms;
        tablewhere.equalColumns = equalColumns;
        if (tablewhere.dateColumn != '' && (tablewhere.startDate == undefined || tablewhere.endDate == undefined)) {
            delete tablewhere.dateColumn;
        }
        return tablewhere;
    }

    /**
     * 获取表单JSON对象
     * @param form
     * @returns {{}}
     */
    var serializeFormObject = function (form) {
        var o = {};
        var a = $("#" + form).serializeArray();
        $.each(a, function () {
            // 区划组件的值要排除
            if (this.name.indexOf('region_') < 0 && this.name.indexOf('cycle_') < 0) {
                if (o[this.name] !== undefined) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            }
        });
        return o;
    };

    /**
     * 生成表单的input元素
     * @param divId
     * @param element
     * @param data
     */
    var createFormInput = function (divId, formId, element, data) {
        var title = element["label"] == undefined ? "" : element.label;
        var divClass = element["divClass"] == undefined ? "layui-col-md12" : element.divClass;
        var name = element.name;
        var verify = "";
        var required = "";
        if (element.verify && element.verify != '') {
            verify = element.verify;
            if (verify.indexOf("required")>-1 ) {
                required = getRequiredIcon();
            }
        }

        var input = '<div class="' + divClass + '">' +
            '           <label class="layui-form-label">' + required + title + '：</label>' +
            '                 <div class="layui-input-block">' +
            '                       <input type="text" name="' + name + '" lay-verify="' + verify + '" placeholder=""' +
            '                                    autocomplete="off" class="layui-input">' +
            '                  </div>' +
            '         </div>';
        $("#"+formId+" [id='"+divId+"']").append(input);
        if (data != null) {
            $("#" + formId + ' [name="' + element.name + '"]').val(data[element.name]);
        }
    }

    /**
     * 生成表单的textarea元素
     * @param divId
     * @param element
     * @param data
     */
    var createFormTextarea = function (divId, formId, element, data) {
        var title = element["label"] == undefined ? "" : element.label;
        var divClass = element["divClass"] == undefined ? "layui-col-md12" : element.divClass;
        var name = element.name;
        var verify = "";
        var required = "";
        if (element.verify && element.verify != '') {
            verify = element.verify;
            if (verify.indexOf("required")>-1 ) {
                required = getRequiredIcon();
            }
        }
        var input = '<div class="' + divClass + '">' +
            '           <label class="layui-form-label">' + required + title + '：</label>' +
            '                 <div class="layui-input-block">' +
            '                       <textarea style="resize:none"  name="' + name + '" lay-verify="' + verify + '" placeholder=""' +
            '                                     class="layui-textarea">' +
            '</textarea></div>' +
            '         </div>';
        $("#"+formId+" [id='"+divId+"']").append(input);
        if (data != null) {
            $("#" + formId + ' [name="' + element.name + '"]').val(data[element.name]);
        }
    }

    /**
     * 生成表单的上传附件元素
     * @param divId
     * @param element
     * @param data
     */
    var createFormFile = function (divId, formId, element, data) {
        var title = element["label"] == undefined ? "" : element.label;
        var divClass = element["divClass"] == undefined ? "layui-col-md12" : element.divClass;
        var name = element.name + "_div";
        var fileDiv = '<div style="margin-top: 5px" class="' + divClass + '" id="' + name + '">' +
            '         </div>';
        $("#"+formId+" [id='"+divId+"']").append(fileDiv);
        var config = element.config;
        var accept = "file";
        if (config && config.accept) {
            accept = config.accept;
        }
        var bizCode = "";
        if (data != null) {
            bizCode = data[element.name];
        }
        if (config && config.isMulti == true) {
            affachCompontent.multiUpload(name, '99', bizCode, accept);
        } else {
            affachCompontent.singleUpload(name, '99', bizCode, accept);
        }

    }

    /**
     * 生成表单的上传附件元素
     * @param divId
     * @param element
     * @param data
     */
    var createFormRegion = function (divId, formId, element, data) {
        $("#" + divId).removeClass("layui-col-md12");
        $("#" + divId).css("margin-bottom", "5px");
        bizComponent.getRegionComponent(formId, $("#" + divId), "", null);
        if (data != null) {
            bizComponent.setRegionSelect(formId, data[element.name]);
        }
    }

    /**
     * 生成表单的上传附件元素
     * @param divId
     * @param element
     * @param data
     */
    var formDisabled = function (form) {
        setTimeout(function () {
            $("#file_div button").hide();
            $("#" + form + " input").css("border", "none");
            $("#" + form + " input").attr("disabled", "disabled");
            $("#" + form + " select").attr("disabled", "disabled");
            $("#" + form + " textarea").attr("disabled", "disabled");
            $("#" + form + " .layui-edge").remove();
            $("#" + form + " .layui-anim-upbit").remove();
            $("#" + form + " .tree-content").remove();
        }, 300)
    }

    /**
     * 生成表单的下拉树元素
     * @param divId
     * @param element
     * @param data
     */
    var createFormTreeSelect = function (divId, formId, element, data) {
        var title = element["label"] == undefined ? "" : element.label;
        var divClass = element["divClass"] == undefined ? "layui-col-md12" : element.divClass;
        var selectTree = '                            <div class="' + divClass + '">' +
            '                                <label class="layui-form-label">' + title + '：</label>' +
            ' <div class="layui-input-block"> ' +
            ' <div id="' + element.name + '_tree" class="layui-form-select select-tree">' +
            ' </div> </div>'
        ' </div>';
        $("#"+formId+" [id='"+divId+"']").append(selectTree);
        var verify = "";
        if (element.verify && element.verify != '') {
            verify = element.verify;
        }
        if (data != null) {
            treeComponent.initSelectTree(element.name + "_tree", element.setting, data[element.name], verify);
        } else {
            treeComponent.initSelectTree(element.name + "_tree", element.setting, null, verify);
        }
    }

    /**
     * 生成表单的表格元素
     * @param divId
     * @param element
     * @param data
     */
    var createTableComponent = function (tableId, tableConfig) {
        var defaultConfig = {//查询列表信息
            elem: '#' + tableId
            , page: true
            , where: {
                hasPermission: false
            }
            , headers: {
                access_token: layui.data(setter.tableName).access_token
            }, skin: 'line'
            , done: function (res, curr, count) {
                if (tableConfig.callback) {
                    tableConfig.callback(res, curr, count);
                }
            }
        }
        tableConfig = $.extend(defaultConfig, tableConfig);
        return table.render(tableConfig);
    }

    /**
     * 生成表单的日期元素
     * @param divId
     * @param element
     * @param data
     */
    var createFormDate = function (divId, formId, element, data) {
        var title = element["label"] == undefined ? "" : element.label;
        var divClass = element["divClass"] == undefined ? "layui-col-md12" : element.divClass;
        var name = element.name;
        var verify = "";
        var required = "";
        if (element.verify && element.verify != '') {
            verify = element.verify;
            if (verify.indexOf("required")>-1 ) {
                required = getRequiredIcon();
            }
        }
        var date = '                            <div class="' + divClass + '">' +
            '                                <label class="layui-form-label">' + required + title + '：</label>' +
            '                                <div class="layui-input-block">' +
            '                                    <input type="text" name="' + name + '" lay-verify="' + verify + '" placeholder=""' +
            '                                           autocomplete="off" class="layui-input">' +
            '                                </div>' +
            '                            </div>';
        $("#"+formId+" [id='"+divId+"']").append(date);
        var type;
        var format;
        if (element.config == null) {
            type = "date";
            format = "yyyy-MM-dd";
        } else {
            type = element.config.type == undefined ? 'date' : element.config.type;
            format = element.config.format == undefined ? 'yyyy-MM-dd' : element.config.format;
        }
        var dateValue = new Date();
        if (data != null) {
            dateValue = data[element.name];
            if (dateValue instanceof Object) {
                dateValue = new Date(dateValue.time);
            }
        }
        laydate.render({
            elem: "#" + formId + ' [name="' + element.name + '"]'
            , type: type
            , format: format
            , value: dateValue
        });
    }

    /**
     * 生成表单的select元素
     * @param divId
     * @param element
     * @param data
     */
    var createFormSelect = function (divId, formId, element, data) {
        var title = element["label"] == undefined ? "" : element.label;
        var divClass = element["divClass"] == undefined ? "layui-col-md12" : element.divClass;
        var name = element.name;
        var verify = "";
        var required = "";
        if (element.verify && element.verify != '') {
            verify = element.verify;
            if (verify.indexOf("required")>-1 ) {
                required = getRequiredIcon();
            }
        }
        var setSelectOption = function ($select,array) {
            var $group = null;
            for (var i=0;i<array.length;i++) {
                if (array[i].group) {
                    if(i == 0){
                        $select.append('<option value=""></option>');
                    }else {
                        $select.append($group);
                    }
                    $group = $('<optgroup label="'+array[i].name+'"></optgroup>');
                }else {
                    if ($group != null) {
                        $group.append('<option value="'+array[i].id+'">'+array[i].name+'</option>');
                        if(i == array.length -1){
                            $select.append($group);
                        }
                    }else {
                        $select.append('<option value="'+array[i].id+'">'+array[i].name+'</option>');
                    }
                }
            }
        }
        var select = '                          <div class="' + divClass + '">' +
            '                                <label class="layui-form-label">' + required + title + '：</label>' +
            '                                <div class="layui-input-block">' +
            '                                    <select  name="' + name + '" lay-filter="' + name + '"' +
            '                                            lay-verify="' + verify + '" lay-search="">' +
            '                                    </select>' +
            '                                </div>' +
            '                            </div>';
        $("#"+formId+" [id='"+divId+"']").append(select);
        var $select = $("#" + formId + ' [name="' + element.name + '"]');
        var config = element.config;
        if (config.source instanceof Array) {
            // var selectTemplete = SelectTpl.innerHTML
            // laytpl(selectTemplete).render(config.source, function (html) {
            //     $select.html(html);
            // });
            setSelectOption($select,config.source);
            if (data != null) {
                $select.val(data[element.name]);
                $select.attr("modifyValue", data[element.name]);
                setTimeout(function () {
                    $('select[name="' + element.name + '"]').next().find('.layui-anim').children('dd[lay-value="' + data[element.name] + '"]').click();
                }, 100);
            }
            form.render(null, formId);
            form.on('select(' + name + ')', function (selected) {
                if (config.onSelect) {
                    // 第一个参为下拉框选中值，第二为当前表单项的JSON
                    config.onSelect(selected, data);
                }
            });
        } else {
            admin.req({//获取请求
                url: setter.remoteServiceAddress + config.source.url
                , data: config.source.data
                , async: false
                , done: function (result) {
                    // var selectTemplete = SelectTpl.innerHTML
                    // laytpl(selectTemplete).render(result.data, function (html) {
                    //     $select.html(html);
                    // });
                    setSelectOption($select,result.data);
                    if (data != null) {
                        $select.val(data[element.name]);
                        $select.attr("modifyValue", data[element.name]);
                        setTimeout(function () {
                            $('select[name="' + element.name + '"]').next().find('.layui-anim').children('dd[lay-value="' + data[element.name] + '"]').click();
                        }, 100);
                    }
                    form.render(null, formId);
                    form.on('select(' + name + ')', function (selected) {
                        if (config.onSelect) {
                            // 第一个参为下拉框选中值，第二为当前表单项的JSON
                            config.onSelect(selected, data);
                        }
                    });
                }
            });
        }
    }

    /**
     * 生成表单的multiSelect元素（多选）
     */
    var  createFormMultiSelect=function(divId, formId, element, data){
        var title = element["label"] == undefined ? "" : element.label;
        var divClass = element["divClass"] == undefined ? "layui-col-md12" : element.divClass;
        var name = element.name;
        var verify = "";
        var required = "";
        if (element.verify && element.verify != '') {
            verify = element.verify;
            if (verify.indexOf("required")>-1 ) {
                required = getRequiredIcon();
            }
        }
        var multiSelect = '                          <div class="' + divClass + '">' +
            '                                <label class="layui-form-label">' + required + title + '：</label>' +
            '                                <div class="layui-input-block">' +
            '                                    <select  name="' + name + '" xm-select="' + name + '" lay-verify="' + verify + '" xm-select-type="2" xm-select-search xm-select-skin="primary" >' +
            '                                    </select>' +
            '                                </div>' +
            '                            </div>';
        $("#"+formId+" [id='"+divId+"']").append(multiSelect);
        var $select = $("#" + formId + ' [name="' + element.name + '"]');
        var config = element.config;
        if (config.source instanceof Array) {
            formSelects.render({
                name: name, //xm-select的值
                type: 2,
                data: {
                    //自定义渲染数据
                    arr: config.source,
                    // name: 'content',//定义name的key, 默认name
                    val: 'value',//定义val的key, 默认val
                    // selected: 'sel',//定义selected的key, 默认selected
                    // disabled: 'dis',//定义disabled的key, 默认disabled
                }
            });
            if(data!=null){
                var shuzuStr=data[element.name].split(",");
                formSelects.value(name,shuzuStr);
            }
        } else {
            admin.req({//获取请求
                url: setter.remoteServiceAddress + config.source.url
                , data: config.source.data
                , async: false
                , done: function (result) {
                    var dataFromSelect=result.data;
                    formSelects.render({
                        name: name, //xm-select的值
                        type: 2,
                        data: {
                            //自定义渲染数据
                            arr: dataFromSelect,
                            // name: 'content',//定义name的key, 默认name
                            val: 'value',//定义val的key, 默认val
                            // selected: 'sel',//定义selected的key, 默认selected
                            // disabled: 'dis',//定义disabled的key, 默认disabled
                        }
                    });
                    if (data != null) {
                        var shuzuStr1=data[element.name].split(",");
                        formSelects.value(name,shuzuStr1);
                    }
                }
            });
        }

    }

    /**
     * 生成表单的checkbox元素
     * @param divId
     * @param element
     * @param data
     */
    var createFormCheckbox = function (divId, formId, element, data) {
        var title = element["label"] == undefined ? "" : element.label;
        var divClass = element["divClass"] == undefined ? "layui-col-md12" : element.divClass;
        var name = element.name;
        var checkbox = '                          <div class="' + divClass + '">' +
            '                                <label class="layui-form-label">' + title + '：</label>' +
            '                                <div class="layui-input-block" id="' + name + '_div">'
        '                                </div>' +
        '                            </div>';
        $("#"+formId+" [id='"+divId+"']").append(checkbox);
        var $checkboxdiv = $("#" + name + '_div');
        var config = element.config;
        if (config.source instanceof Array) {
            for (var i = 0; i < config.source.length; i++) {
                var check = "";
                var options = data == null ? "" : data[element.name] + ",";
                if (data && options.indexOf(config.source[i].value + ",") > -1) {
                    check = "checked";
                }
                if (element.config['laySkin'] == true) {
                    $checkboxdiv.append('<input lay-skin="primary" name="' + name + i + '" title="' + config.source[i].title + '" value="' + config.source[i].value + '" type="checkbox" ' + check + ' lay-filter="' + name + '"' + '>');
                } else {
                    $checkboxdiv.append('<input  name="' + name + i + '" title="' + config.source[i].title + '" value="' + config.source[i].value + '" type="checkbox" ' + check + ' lay-filter="' + name + '"' + '>');
                }
            }
            form.render(null, formId);
            form.on('checkbox(' + name + ')', function (data) {
                if (config.onCheck) {
                    config.onCheck(data);
                }
            });
        } else {
            admin.req({//获取请求
                url: setter.remoteServiceAddress + config.source.url
                , data: config.source.data
                , done: function (result) {
                    for (var i = 0; i < result.data.length; i++) {
                        var check = "";
                        var options = data == null ? "" : data[element.name] + ",";
                        if (data && options.indexOf(result.data[i].value + ",") > -1) {//修改时，回显选中状态
                            check = "checked";
                        }
                        if (element.config['laySkin'] == true) {
                            $checkboxdiv.append('<input lay-skin="primary" name="' + name + i + '" title="' + result.data[i].title + '" value="' + result.data[i].value + '" type="checkbox" ' + check + ' lay-filter="' + name + '"' + '>');
                        } else {
                            $checkboxdiv.append('<input  name="' + name + i + '" title="' + result.data[i].title + '" value="' + result.data[i].value + '" type="checkbox" ' + check + ' lay-filter="' + name + '"' + '>');
                        }
                    }
                    form.render(null, formId);
                    form.on('checkbox(' + name + ')', function (data) {
                        if (config.onCheck) {
                            config.onCheck(data);
                        }
                    });
                }
            });
        }
    }

    /**
     * 生成表单radio的元素
     * @param divId
     * @param element
     * @param data
     */
    var createFormRadio = function (divId, formId, element, data) {
        var title = element["label"] == undefined ? "" : element.label;
        var divClass = element["divClass"] == undefined ? "layui-col-md12" : element.divClass;
        var name = element.name;
        var radio = '                          <div class="' + divClass + '">' +
            '                                <label class="layui-form-label">' + title + '：</label>' +
            '                                <div class="layui-input-block" id="' + name + '_div">'
        '                                </div>' +
        '                            </div>';
        $("#"+formId+" [id='"+divId+"']").append(radio);
        var $radioDiv = $("#" + name + '_div');
        var config = element.config;
        if (config.source instanceof Array) {
            for (var i = 0; i < config.source.length; i++) {
                var check = "";
                if (data && data[element.name] == config.source[i].value) {
                    check = "checked";
                }
                if (data == null && i == 0) {
                    check = "checked";
                }
                $radioDiv.append('<input  name="' + name + '" title="' + config.source[i].title + '" value="' + config.source[i].value + '" type="radio" ' + check + ' lay-filter="' + name + '"' + '>');
            }
            form.render(null, formId);
            form.on('radio(' + name + ')', function (data) {
                if (config.onRadio) {
                    config.onRadio(data);
                }
            });
        } else {
            admin.req({//获取请求
                url: setter.remoteServiceAddress + config.source.url
                , data: config.source.data
                , done: function (result) {
                    for (var i = 0; i < result.data.length; i++) {
                        var check = "";
                        if (data && data[element.name] == result.data[i].value) {
                            check = "checked";
                        }
                        if (data == null && i == 0) {
                            check = "checked";
                        }
                        $radioDiv.append('<input  name="' + name + '" title="' + result.data[i].title + '" value="' + result.data[i].value + '" type="radio" ' + check + ' lay-filter="' + name + '"' + '>');
                    }
                    form.render(null, formId);
                    form.on('radio(' + name + ')', function (data) {
                        if (config.onRadio) {
                            config.onRadio(data);
                        }
                    });
                }
            });
        }
    }

    /**
     * 绑定表单提交
     * @param formid
     * @param elements
     * @param data
     */
    var bindFormSubmit = function (formid, elements, type) {
        form.verify(objtable.config.form.customVerify);
        form.on('submit(' + formid + ')', function (data) {
            if (JSON.stringify(data.field) != "{}") {
                for (var i = 0; i < elements.length; i++) {
                    // 处理区划
                    if (elements[i].type == "region") {
                        data.field[elements[i].name] = bizComponent.getRegionValue(formid);
                    }
                    // 处理自定义
                    if (elements[i].type == "custom" || elements[i].type == 'table') {
                        data.field[elements[i].name] = elements[i].config.getValue(formid);
                    }
                    // 处理树
                    if (elements[i].type == "tree") {
                        var treeObj = $.fn.zTree.getZTreeObj(elements[i].name + "_tree");
                        var nodes;
                        if (elements[i].setting.check.enable == true) {
                            nodes = treeObj.getCheckedNodes(true);
                        } else {
                            nodes = treeObj.getSelectedNodes();
                        }
                        data.field[elements[i].name] = "";
                        for (var j = 0; j < nodes.length; j++) {
                            if (j == 0) {
                                data.field[elements[i].name] += nodes[j].id;
                            } else {
                                data.field[elements[i].name] += "," + nodes[j].id;
                            }
                        }
                    }
                    //处理多选框
                    if (elements[i].type == "multiSelect") {
                        var selectStr=formSelects.value(elements[i].name, 'valStr');
                        // var shuzuStr=selectStr.split(",");
                        data.field[elements[i].name] =selectStr ;
                    }
                    // 处理复选框
                    for (var field in data.field) {
                        if (elements[i].type == "checkbox" && field.indexOf(elements[i].name) == 0) {
                            data.field[elements[i].name] = data.field[elements[i].name] == undefined ? "" : data.field[elements[i].name];
                            if (data.field[elements[i].name] == "") {
                                data.field[elements[i].name] += data.field[field];
                            } else {
                                data.field[elements[i].name] += "," + data.field[field];
                            }
                            delete data.field[field];
                        }
                    }
                }
                for (var field in data.field) {
                    if (field.indexOf("region_") == 0 || field.indexOf("cycle_") == 0) {
                        delete data.field[field];
                    }
                }
                //  后台提交数据
                var index = layer.msg('数据提交中，请稍候...',{icon:16,time:false,shade:0.1});
                admin.req({
                    type: type,
                    contentType: "application/json",
                    url: objtable.config.url,
                    data: JSON.stringify(data.field),
                    done: function (result) {
                        layer.close(index);
                        if (result.code == 0) {//成功
                            layer.msg('操作成功！', {icon: 6, time: 500}, function () {
                                if (objtable.dlgIndex) {
                                    layer.close(objtable.dlgIndex);
                                }
                                for (var i = 0; i < elements.length; i++) {
                                    // 表单有附件要单独提交
                                    if (elements[i].type == "file") {
                                        if (type == 'PUT') {
                                            $('#upload_file_bizcode').val(data.field.id);
                                        } else {
                                            $('#upload_file_bizcode').val(result.id);
                                        }
                                        $("#attachment_upload_btn").trigger('click');
                                    }
                                }
                                table.reload(objtable.config.id);
                            });
                        } else {
                            layer.msg(result.msg);
                        }
                    }
                });
            }
        });

    }

    /**
     * 生成表单内容
     * @param formid 表单ID
     * @param elements 表单配置项
     * @param data 表单数据
     * @param withSubmit 是否生成提交按钮
     */
    var createQueryForm = function (formid, withButton) {
        var elements = [];
        // 元素配置项
        var elementConfig = {};
        // 存储所有日期元素，最后统一渲染
        var tempDateObj = [];

        // 给定div的外层宽度（默认只有自己，即最大宽度）
        // var maxWidth = $("#"+formid).parent().parent().width();
        getParentWidth($("#" + formid));
        var maxWidth = queryMaxWidth;
        var tempTailPstLeft1;   //添加前 尾巴距左
        var tempTailPstLeft2;   //添加后 尾巴距左

        // 超出标志, 默认0没超，1超
        var flag = 0;
        // 隐藏显示按钮
        var searchShowBtn = '<button class="layui-btn" style="margin-left: 10px;" data-type="searchShow" id="searchShowBtn">' +
            '            <i class="layui-icon layui-icon-down"></i>' +
            '        </button>';
        // 装多余查询元素DIV       position: absolute;z-index: 1; 决定下面内容是不是往下挤 display:none;
        
        var searchHideDiv = $("<div id='searchHideDiv' style=' display:none;position: absolute;z-index: 1;background-color: #FFF;'>");
        // 临时辅助添加工具，方法结束删除
        var tempDiv = $("<div style='display: inline' id='" + formid + "TempDiv'></div>");
        var tempTailPstDiv = $("<div style='display: inline' id='" + formid + "tempTailPstDiv'></div>");    //尾巴定位

        $("#" + formid).append(tempDiv);


        // 显示隐藏点击颜色样式切换
        var showOrHide = function () {
            if ($("#searchHideDiv")[0].style.display == "none") {
                $("#searchShowBtn i").removeClass("layui-icon-down");
                $("#searchShowBtn i").addClass("layui-icon-up");
            } else {
                $("#searchShowBtn i").removeClass("layui-icon-up");
                $("#searchShowBtn i").addClass("layui-icon-down");
            }
            $("#searchHideDiv").toggle("fast", function () {
                $("#searchHideDiv")[0].style.display == "show" ? "none" : "show";
            });
        }

        // 查询元素的添加，内部调用,只有date元素才有element传入
        var queryElemAdd = function (elem, element) {
            // 日期元素收集器
            if (element != null) {
                tempDateObj.push(element);
            }
            //还没满
            if (flag == 0) {
                tempTailPstLeft1 = tempTailPstDiv.position().left;
                if(tempTailPstLeft1 < tempTailPstLeft2){
                    flag = 1;
                    $("#searchHideDiv").append($("<div></div>").append($("#" + formid + "TempDiv").prev().clone()).html());
                    $("#" + formid + "TempDiv").prev().remove();
                    $("#" + formid + "tempTailPstDiv").before(searchShowBtn);    //加个下拉按钮
                    $("#" + formid + "tempTailPstDiv").before(searchHideDiv);    //隐藏div
                    $("#searchHideDiv").append(elem);
                    $("#searchHideDiv").css("width", $("#" + formid).parent().width()); //最大宽度的话将此注释掉
                }else {
                    var b = $("#" + formid).width();  //添加前宽度
                    // 添加这个之前还没有满
                    $("#" + formid + "TempDiv").before(elem);
                    tempTailPstLeft2 = tempTailPstDiv.position().left;
                    var d = $("#" + formid).width();  //添加后宽度
                }
                //添加后满了
                if (d > maxWidth || d < b || tempTailPstLeft2<tempTailPstLeft1) {
                    flag = 1;
                    //添加完之后就满了，将刚刚添加的删除，然后增加一个下拉按钮，再将元素添加到附带的隐藏DIV里面
                    $("#" + formid + "TempDiv").prev().remove();
                    $("#" + formid + "tempTailPstDiv").before(searchShowBtn);    //加个下拉按钮
                    $("#" + formid + "tempTailPstDiv").before(searchHideDiv);    //隐藏div
                    // maxWidth = $("#"+formid).width();.
                    $("#searchHideDiv").css("width", $("#" + formid).parent().width());
                    tempTailPstLeft2 = tempTailPstDiv.position().left;
                    //加了下拉按钮之后还是满了
                    if ($("#" + formid).width() > maxWidth || $("#" + formid).width() < b || tempTailPstLeft2<tempTailPstLeft1) {
                        //加了下拉按钮超出范围，再将前一个装到 div 里面，然后删除
                        $("#searchHideDiv").append($("<div></div>").append($("#" + formid + "TempDiv").prev().clone()).html());
                        $("#" + formid + "TempDiv").prev().remove();
                        $("#searchHideDiv").append(elem);
                        $("#searchHideDiv").css("width", $("#" + formid).parent().width()); //最大宽度的话将此注释掉
                    } else {
                        //加了下拉框还没满
                        $("#searchHideDiv").append(elem);
                    }
                }

            } else {
                //添加这个之前就已经满了
                $("#searchHideDiv").append(elem);
            }

        }


        // 如果有需要生成按钮的话则加上
        if (withButton == true) {
            $("#" + formid).append('               <button id="' + formid + 'ReloadBtn" class="layui-btn layui-btn-reload" data-type="tableReload" ' +
                '         style="margin-left: 10px;"  perm="finance:contractexecute:index:query">' +
                '                    <i class="layui-icon">&#xe615;</i>' +
                '                </button>' +
                '                <button id="' + formid + 'ResetBtn"  class="layui-btn layui-btn-reload" data-type="reset" >' +
                '                    <i class="layui-icon">&#xe669;</i>' +
                '                </button>');
            $("#" + formid + " .layui-btn-reload").click(function () {
                if ($(this).attr("data-type") == "reset") {

                    // 点击重置按钮收起隐藏框,稳定后决定有无
                    /* if($("#searchHideDiv")[0].style.display != "none"){
                         $("#searchShowBtn").trigger("click");
                     }*/
                    // 如果有cycle，重置隐藏掉第三个下拉框
                    $("#" + formid + " .cycle_value2_div").hide();
                    $("#" + formid)[0].reset();
                }
                var formObject = serializeFormObject(formid);
                var region = bizComponent.getRegionValue(formid);
                if (region != undefined) {
                    formObject['region'] = region;
                }
                var cycle = bizComponent.getCycleComponent(formid);
                if (cycle != undefined) {
                    // 点击重置按钮  取消周期 cycle 的查询值
                    if ($(this).attr("data-type") == "reset") {
                        formObject['cycle'] = "";
                    } else {
                        formObject['cycle'] = cycle;
                    }
                }
                table.reload(objtable.config.id, {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: formObject
                });
            });
        }
        $("#" + formid).append(tempTailPstDiv);
        tempTailPstLeft2 = tempTailPstLeft1 = tempTailPstDiv.position().left;

        // 获取查询表单的元素
        for (var i = 0; i < objtable.config.form.queryCriteria.length; i++) {
            var queryElement = objtable.config.form.queryCriteria[i];
            if (typeof queryElement == 'number') {
                elements.push(objtable.config.form.elements[queryElement])
            } else {
                elements.push(queryElement);
            }
        }

        //  创建查询表单的元素，目前只支持时间，输入框和下拉框,以及区划

        for (var j = 0; j < elements.length; j++) {
            var element = elements[j];
            elementConfig[element.name] = element.config;
            var labelLength = element.label == undefined ? "" : element.label.length;
            // var lableWidth = labelLength == "" ? 0 : labelLength * 23;       //edit label宽度对齐
            var lableWidth ;
            if(labelLength == "" && element.labelWidth == undefined){
                lableWidth = 0;
            }else{
                lableWidth = element.labelWidth == undefined ? 90 : element.labelWidth;
            }

            var lable = element.label == '' ? '' : element.label + '：';
            if (elements[j].type == "input") {
                var input = '<div class="layui-inline" style="margin-bottom: 5px;margin-top: 5px">' +
                    '           <label class="mylabel" style="width: ' + lableWidth + 'px">' + lable + '</label>' +
                    '                       <input type="text" name="' + element.name +
                    // '"                                    autocomplete="off" class="layui-input myinput">' + //edit  将input框与下拉框同宽
                    '"                      autocomplete="off" class="layui-input queryInput">' +
                    '         </div>';

                // $("#" + formid).append(input);
                queryElemAdd(input);

                continue;
            }
            if (elements[j].type == "hide") {
                $("#" + formid).append('<input type="hidden" name="' + element.name + '"/>');
                continue;
            }
            // 自定义组件
            if (elements[j].type == "custom") {
                var divClass = elements[j]["divClass"] == undefined ? "layui-col-md12" : elements[j].divClass;
                var customDiv = '<div  style="margin-bottom: 5px;margin-top: 5px"  class="' + divClass + '">' + '</div>';

                // $("#" + formid).append(customDiv);

                queryElemAdd(customDiv);
                // 自定义组件创建配置。
                if(elements[j].config != undefined){
                    if(elements[j].config.create != undefined){
                        elements[j].config.create(formid);
                    }
                }

                continue;
            }
            if (elements[j].type == "region") {
                var regionDiv = element.name + "_search_div";
                var region = '<div style="margin-bottom: 5px;margin-top: 5px" class="layui-inline" id="' + regionDiv + '"></div>';

                // $("#" + formid).append(region);
                queryElemAdd(region);

                bizComponent.getRegionComponent(formid, $("#" + regionDiv), "", null);
                $("#" + formid + " .layui-form-label").addClass("mylabel");
                continue;
            }
            if (elements[j].type == "date") {

                var date = '<div class="layui-inline" style="margin-bottom: 5px;margin-top: 5px">' +
                    '           <label class="mylabel" style="width: ' + lableWidth + 'px">' + lable + '</label>' +
                    '                       <input type="text" name="' + element.name +
                    '"                                    autocomplete="off" class="layui-input myinput">' +
                    '         </div>';

                // $("#" + formid).append(date);
                element.id = "#" + formid + ' [name="' + element.name + '"]';
                queryElemAdd(date, element);

                // 统一放到最后渲染
                // var type;
                // var format;
                // if (element.config == null) {
                //     type = "date";
                //     format = "yyyy-MM-dd";
                // } else {
                //     type = element.config.type == undefined ? 'date' : element.config.type;
                //     format = element.config.format == undefined ? 'yyyy-MM-dd' : element.config.format;
                // }
                // laydate.render({
                //     elem: "#" + formid + ' [name="' + element.name + '"]'
                //     , type: type
                //     , format: format
                // });
                continue;
            }
            if (element.type == "select") {
                var select = '<div style="margin-bottom: 5px;margin-top: 5px"  class="layui-inline">' +
                    '           <label class="mylabel" style="width: ' + lableWidth + 'px">' + lable + '</label>' +
                    '<div class="layui-inline querySelect" >' +
                    '                                    <select  name="' + element.name + '" lay-filter="' + element.name + '"' +
                    '                                            lay-verify="" lay-search="">' +
                    '                                    </select>' +
                    '</div>' +
                    '                            </div>';


                // $("#" + formid).append(select);
                queryElemAdd(select);


                var $select = $("#" + formid + ' [name="' + element.name + '"]');
                var config = element.config;
                if (config.source instanceof Array) {
                    var selectTemplete = SelectTpl.innerHTML
                    laytpl(selectTemplete).render(config.source, function (html) {
                        $select.html(html);
                    });
                    form.render(null, formid);
                } else {
                    admin.req({//获取请求
                        url: setter.remoteServiceAddress + config.source.url
                        , async: false
                        , data: config.source.data
                        , done: function (result) {
                            var selectTemplete = SelectTpl.innerHTML
                            laytpl(selectTemplete).render(result.data, function (html) {
                                $select.html(html);
                            });
                            form.render(null, formid);
                        }
                    });
                }
                form.on('select(' + element.name + ')', function (data) {
                    var $currentSelect = $(this).parent().parent().prev();
                    var selectName = $currentSelect.attr("name");
                    if (elementConfig[selectName].onSelect) {
                        elementConfig[selectName].onSelect(data);
                    }
                });
                continue;
            }
            if (element.type == "multiSelect") {
                var select = '<div style="margin-bottom: 5px;margin-top: 5px"  class="layui-inline">' +
                    '           <label class="mylabel" style="width: ' + lableWidth + 'px">' + lable + '</label>' +
                    '<div class="layui-inline querySelect" >' +
                    '       <select  name="' + element.name + '"  xm-select="' + element.name +'" lay-filter="' + element.name + '" lay-verify="" lay-search=""xm-select-type="2" xm-select-search xm-select-skin="primary" >' +
                    '        </select>' +
                    '</div>' +
                    '</div>';
                // $("#" + formid).append(select);
                queryElemAdd(select);
                var $select = $("#" + formid + ' [name="' + element.name + '"]');
                var config = element.config;
                if (config.source instanceof Array) {
                    formSelects.render({
                        name: element.name, //xm-select的值
                        type: 2,
                        data: {
                            //自定义渲染数据
                            arr: config.source,
                            // name: 'content',//定义name的key, 默认name
                            val: 'value',//定义val的key, 默认val
                            // selected: 'sel',//定义selected的key, 默认selected
                            // disabled: 'dis',//定义disabled的key, 默认disabled
                        }
                    });
                } else {
                    admin.req({//获取请求
                        url: setter.remoteServiceAddress + config.source.url
                        , data: config.source.data
                        , async: false
                        , done: function (result) {
                            var dataFromSelect=result.data;
                            formSelects.render({
                                name: element.name, //xm-select的值
                                type: 2,
                                data: {
                                    //自定义渲染数据
                                    arr: dataFromSelect,
                                    // name: 'content',//定义name的key, 默认name
                                    val: 'value',//定义val的key, 默认val
                                    // selected: 'sel',//定义selected的key, 默认selected
                                    // disabled: 'dis',//定义disabled的key, 默认disabled
                                }
                            });
                        }
                    });
                }
                continue;
            }
        }

        for (var i = 0; i < tempDateObj.length; i++) {
            var elem = tempDateObj[i];
            var type;
            var format;
            if (elem.config == null) {
                type = "date";
                format = "yyyy-MM-dd";
            } else {
                type = elem.config.type == undefined ? 'date' : elem.config.type;
                format = elem.config.format == undefined ? 'yyyy-MM-dd' : elem.config.format;
            }
            laydate.render({
                elem: elem.id
                , type: type
                , format: format
            });
        }

        tempDateObj = null;
        queryMaxWidth = null;
        $("#searchShowBtn").bind('click', showOrHide);
        $("#" + formid + "TempDiv").remove();
        $("#" + formid + "tempTailPstDiv").remove();

        form.render('select');  //主要针对省市区放在隐藏div里面点击下拉没有效果
    }

    /**
     * 生成表单内容
     * @param formid 表单ID
     * @param elements 表单配置项
     * @param data 表单数据
     * @param withSubmit 是否生成提交按钮
     * @param divId 表单外部容器 div的id,有的话传,没有的话生成传
     */
    var createForm = function (formid, elements, data, withSubmit,divId) {
        formid += "_form";
        var form = '<div class="layui-fluid"><div class="layui-row layui-col-space15"><div class="layui-card-body"><form onSubmit="return false;" class="layui-form" id="' + formid + '" lay-filter="' + formid + '">';
        $("#"+divId).append(form);
        // 主键隐藏域
        $("#" + formid).append('<input type="hidden" name="id"/>');
        if (data != null) {
            $("#" + formid + " [name='id']").val(data.id);
        } else {
            $("#" + formid + " [name='id']").val(bizComponent.generateUUID());
        }
        // 表单中元素的名称
        var elementName = "";
        // 表单中元素的类型
        var elementType = "";
        var divRow;
        var divRowId;
        var rowFlag;
        for (var i = 0; i < elements.length; i++) {
            rowFlag = elements[i].row;
            elementName = elements[i].name;
            elementType = elements[i].type;
            // 其它隐藏列
            if (elementType == "hide") {
                $("#" + formid).append('<input type="hidden" name="' + elementName + '"/>');
            } else {
                // 有行标志新起一行
                if (rowFlag == true) {
                    divRowId = "form_row" + i;
                    divRow = '<div class="layui-row layui-col-space10 layui-form-item layui-col-md12" id="' + divRowId + '"></div>';
                    $('#' + formid).append(divRow);
                }
                if (elementType == "input") {
                    createFormInput(divRowId, formid, elements[i], data);
                }
                if (elementType == "date") {
                    createFormDate(divRowId, formid, elements[i], data);
                }
                if (elementType == "select") {
                    createFormSelect(divRowId, formid, elements[i], data);
                }
                if(elementType=="multiSelect"){
                    createFormMultiSelect(divRowId, formid, elements[i], data);
                }
                if (elementType == "checkbox") {
                    createFormCheckbox(divRowId, formid, elements[i], data);
                }
                if (elementType == "radio") {
                    createFormRadio(divRowId, formid, elements[i], data);
                }
                if (elementType == "textarea") {
                    createFormTextarea(divRowId, formid, elements[i], data);
                }
                if (elementType == "file") {
                    // 修改时附件的业务ID为当前业务ID
                    if (data != null) {
                        data[elements[i].name] = data.id;
                    }
                    createFormFile(divRowId, formid, elements[i], data);
                }
                if (elementType == "region") {
                    createFormRegion(divRowId, formid, elements[i], data);
                }
                if (elementType == "treeSelect") {
                    createFormTreeSelect(divRowId, formid, elements[i], data);
                }
                // 表格组件
                if (elementType == "table") {
                    var divClass = elements[i]["divClass"] == undefined ? "layui-col-md12" : elements[i].divClass;
                    var tableId = elements[i].name + "_table";
                    var tableDiv = '<div  class="' + divClass + ' formTableClass">' +
                        '<div  class="layui-card"><div class="layui-card-body"><table id="' + tableId + '" lay-filter=' + tableId + '"></table>' +
                        '</div></div></div>';
                    $("#"+formid+" [id='"+divRowId+"']").addClass("layui-col-space12");
                    $("#"+formid+" [id='"+divRowId+"']").append(tableDiv);
                    createTableComponent(tableId, elements[i].config);
                }
                // 树组件
                if (elementType == "tree") {
                    var divClass = elements[i]["divClass"] == undefined ? "layui-col-md12" : elements[i].divClass;
                    var treeId = elements[i].name + "_tree";
                    var treeDiv = '<div  class="' + divClass + ' formTreeClass">' +
                        '<div class="layui-card"><div class="layui-card-body"><ul id="' + treeId + '" class="ztree"></ul>' +
                        '</div></div></div>';
                    $("#"+formid+" [id='"+divRowId+"']").addClass("layui-col-space12");
                    $("#"+formid+" [id='"+divRowId+"']").append(treeDiv);
                    treeComponent.initTree(treeId, elements[i].setting);
                }
                // 自定义组件
                if (elementType == "custom") {
                    var divClass = elements[i]["divClass"] == undefined ? "layui-col-md12" : elements[i].divClass;
                    var customDiv = '<div  style="margin-bottom: 5px;margin-top: 5px" class="' + divClass + '">' + '</div>';
                    $("#"+formid+" [id='"+divRowId+"']").append(customDiv);

                    if(elements[i].config != undefined){
                        if(elements[i].config.create != undefined){
                            elements[i].config.create(formid);
                        }
                    }

                    if (data != null) {
                        elements[i].config.setValue(data);
                    }
                }
            }
        }
        formSelects.render();
        var hiddenSubmit = "";
        if (withSubmit == false) {
            hiddenSubmit = "layui-hide";
        }
        $('#' + formid).append('<div style="text-align:center;" class="layui-form-item ' + hiddenSubmit + '">' +
            '                        <div>' +
            '                            <button  class="layui-btn layui-btn-normal layui-submit" lay-submit lay-filter="' + formid + '">' +
            '                                确定' +
            '                            </button>' +
            '                            <button  class="layui-btn layui-btn-normal layui-cancel"  lay-filter="' + formid + '">' +
            '                                取消' +
            '                            </button>' +
            '                        </div>' +
            '                    </div>');
        var type = "POST";
        if (data != null) {
            type = "PUT";
        }
        $("#" + formid + " .layui-cancel").click(function () {
            layer.close(objtable.dlgIndex);
        });
        bindFormSubmit(formid, objtable.config.form.elements, type);
    }
    var obj = {
        /**
         * 生成layui表格
         * @param tableId 表格ID
         * @param tableConfig 表格配置
         */
        createTable: function (tableId, tableConfig) {
            objtable = createTableComponent(tableId, tableConfig);
            return objtable;
        },
        /**
         * 生成layui表格
         * @param tableId 表格ID
         * @param tableConfig 表格配置
         */
        createTree: function (treeId, treeSetting) {
            return treeComponent.initTree(treeId, treeSetting);
        },
        /**
         * 初始化表单配置
         * @param objtable 没有表格时单独配置表单项 url,form必需有
         */
        initForm: function (formConfig) {
            objtable.config = formConfig;
        },
        /**
         * 根据配置获取生成表单内容
         * @param data 表单数据
         * @param withSubmit 是否有提交按钮
         * @param isEdit 是否可编辑
         */
        getForm: function (divId, data, withSubmit, isEdit) {
            var formId = objtable.config.id + "_form";
            // 生成form表单
            if (isEdit == true) {
                createForm(objtable.config.id, objtable.config.form.elements, data, withSubmit, divId);
            } else {
                createForm(objtable.config.id, objtable.config.form.elements, data, false, divId);
                formDisabled(formId);
            }
            return formId;
        },
        /**
         * 根据表格中字段设置生成对应的可编辑表单
         * @param data 表单数据一般是表格行数据
         * @param dlgset 对话框配置，如大小等
         * @param callback 生成表单后的回调
         */
        showEditForm: function (data, callback) {
            var dlgSet = objtable.config.form.dlgSet;
            var title = "修改";
            if (data == null || data == "") {
                title = "新增";
            }
            var dlgwidth = "70%";
            var dlgheight = "85%";
            if (dlgSet != undefined) {
                title = dlgSet.title != undefined ? dlgSet.title : title;
                dlgwidth = dlgSet.width;
                dlgheight = dlgSet.height;
            }
            var divId = bizComponent.generateUUID();
            var html = '    <div class="layui-fluid">' +
                '      <div class="layui-row layui-col-space15">' +
                '        <div class="layui-card-body" id="'+divId+'"></div>' +
                '      </div>' +
                '    </div>';
            var layerIndex = layer.open({
                type: 1
                , title: title
                , area: admin.screen() < 2 ? ['80%', '300px'] : [dlgwidth, dlgheight]
                , content: html
            });
            objtable.dlgIndex = layerIndex;
            // 生成form表单
            createForm(objtable.config.id, objtable.config.form.elements, data, true, divId);
            // 调用回调方法
            if (callback != undefined) {
                var formId = objtable.config.id + "_form";
                callback(formId, data);
            }

        },
        /**
         * 提供的提交表单接口
         */
        formSubmit: function (callBack) {
            var form = objtable.config.id + "_form";
            $("#" + form + " .layui-submit").trigger('click');
            if (callBack) {
                callBack();
            }
        },
        /**
         * 查看表格行表单数据
         * @param data 需要查看表格行数据
         */
        showViewForm: function (data, callback) {
            var dlgset = objtable.config.form.dlgSet;
            var title = "查看";
            var dlgwidth = "70%";
            var dlgheight = "85%";
            if (dlgset != undefined) {
                title = dlgset.title != undefined ? dlgset.title : title;
                dlgwidth = dlgset.width;
                dlgheight = dlgset.height;
            }
            var divId = bizComponent.generateUUID();
            var html = '    <div class="layui-fluid">' +
                '      <div class="layui-row layui-col-space15">' +
                '        <div class="layui-card-body" id="'+divId+'"></div>' +
                '      </div>' +
                '    </div>';
            layer.open({
                type: 1
                , title: title
                , area: admin.screen() < 2 ? ['80%', '300px'] : [dlgwidth, dlgheight]
                , content: html
            });
            var form = objtable.config.id + "_form";
            // 生成form表单
            createForm(objtable.config.id, objtable.config.form.elements, data, false, divId);
            if (callback != undefined) {
                callback(data);
            }
            formDisabled(form);
        },
        /**
         * 删除表格选中的行数据
         * @param data 选中行数据
         */
        showDeleteDlg: function (data, callback) {
            layer.confirm('确定删除选中的数据吗？', function () {
                admin.req({//根据
                    url: objtable.config.url
                    , contentType: "application/json"
                    , type: "DELETE"
                    , data: JSON.stringify(data)
                    , done: function (result) {
                        if (result.code == 0) {//成功
                            layer.msg('删除成功', {
                                icon: 1,
                                time: 1000
                            });
                            table.reload(objtable.config.id); //刷新表格
                            if (callback) {
                                callback(data);
                            }
                        } else {
                            layer.alert(result.msg, {
                                skin: 'layui-layer-lan',
                                offset: 't',
                                anim: 6
                            });
                        }
                    }
                });
            });
        },
        /**
         * 根据生成配置生成查询条件表单
         * @param divId
         * @param data
         * @param withSubmit
         */
        getQueryForm: function (divId, withButton, callback) {
            // 解决刚登陆没参数加载方法报错
            if (objtable.config.id == undefined) {
                return;
            }

            var formid = objtable.config.id + "search_form";
            var form = '<form style="display: inline;" onSubmit="return false;" class="layui-form" id="' + formid + '" lay-filter="' + formid + '">';

            $("#" + divId).append($(form));

            createQueryForm(formid, withButton);
            //回调
            if (callback != undefined) {
                callback(formid);
            }

            return formid;
        },
        /**
         * 得到表单组装后的查询条件
         * @param formId
         */
        getQueryCriteria: function (formId) {
            var where = createQueryCriteria(formId);
            var cycle = bizComponent.getCycleComponent(formId);
            if (cycle != undefined) {
                where.equalColumns.push({column: "cycle", value: cycle});
            }
            return where;
        }
    }
    exports('pageScaffolding', obj);
})