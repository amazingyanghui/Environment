layui.define(['jquery'], function (exports) {
    var $ = layui.jquery;
    var table = layui.table;
    var layer = layui.layer;
    var setter = layui.setter;
    var laydate = layui.laydate;
    var tableQuery = layui.tableQuery;
    var admin = layui.admin;
    var laytpl = layui.laytpl;
    var form = layui.form;
    // layui表格对象
    var objtable;

    /**
     * 生成表单的input元素
     * @param divId
     * @param element
     * @param data
     */
    var createFormInput = function (divId, formId, element, data) {
        var title = element["label"] == undefined ? "" : element.label;
        var divClass = element["divClass"]== undefined?"layui-col-md6":element.divClass;
        var name = element.name;
        var input = '                            <div class="' + divClass + '">' +
            '                                <label class="layui-form-label">' + title + '：</label>' +
            '                                <div class="layui-input-block">' +
            '                                    <input type="text" name="' + name + '" lay-verify="required" placeholder=""' +
            '                                           autocomplete="off" class="layui-input">' +
            '                                </div>' +
            '                            </div>';
        $("#" + divId).append(input);
        if (data != null) {
            $("#" + formId + ' [name="' + element.name + '"]').val(data[element.name]);
        }
    }

    /**
     * 生成表单的日期元素
     * @param divId
     * @param element
     * @param data
     */
    var createFormDate = function (divId, formId, element, data) {
        var title = element["label"] == undefined ? "" : element.label;
        var divClass = element["divClass"]== undefined?"layui-col-md6":element.divClass;
        var name = element.name;
        var date = '                            <div class="' + divClass + '">' +
            '                                <label class="layui-form-label">' + title + '：</label>' +
            '                                <div class="layui-input-block">' +
            '                                    <input type="text" name="' + name + '" lay-verify="required" placeholder=""' +
            '                                           autocomplete="off" class="layui-input">' +
            '                                </div>' +
            '                            </div>';
        $("#" + divId).append(date);
        laydate.render({
            elem: "#" + formId + ' [name="' + element.name + '"]'
            // , type: 'datetime'
            // , format: "yyyy-MM-dd"
            ,value: data==null?new Date():data[element.name]
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
        var divClass = element["divClass"]== undefined?"layui-col-md6":element.divClass;
        var name = element.name;
        var select = '                          <div class="' + divClass + '">' +
            '                                <label class="layui-form-label">' + title + '：</label>' +
            '                                <div class="layui-input-block">' +
            '                                    <select  name="'+name+'" lay-filter="'+name+'"' +
            '                                            lay-verify="required" lay-search="">' +
            '                                    </select>' +
            '                                </div>' +
            '                            </div>';
        $("#" + divId).append(select);
        var $select =  $("#" + formId + ' [name="' + element.name + '"]');
        if (element.source instanceof Array) {
            var selectTemplete = SelectTpl.innerHTML
            laytpl(selectTemplete).render(element.source, function(html){
                $select.html(html);
            });
            if (data != null) {
                $select.val(data[element.name]);
            }
            form.render(null, 'component-tableform-element');
        }else {
            admin.req({//获取请求
                url: element.source
                , done: function (result) {
                    var selectTemplete = SelectTpl.innerHTML
                    laytpl(selectTemplete).render(result.data, function(html){
                        $select.html(html);
                    });
                    if (data != null) {
                        $select.val(data[element.name]);
                    }
                    form.render(null, 'component-tableform-element');
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
        var divClass = element["divClass"]== undefined?"layui-col-md6":element.divClass;
        var value = element["value"];
        var name = element.name;
        var checkbox = '                          <div class="' + divClass + '">' +
            '                                <label class="layui-form-label">' + title + '：</label>' +
            '                                <div class="layui-input-block" id="'+name+'_div">'
            '                                </div>' +
            '                            </div>';
        $("#" + divId).append(checkbox);
        var $checkboxdiv =  $("#" + name + '_div');
        if (element.source instanceof Array) {

            if (data != null) {
                $select.val(data[element.name]);
            }
            form.render(null, 'component-tableform-element');
        }else {
            admin.req({//获取请求
                url: element.source
                , done: function (result) {
                    var selectTemplete = SelectTpl.innerHTML
                    laytpl(selectTemplete).render(result.data, function(html){
                        $select.html(html);
                    });
                    if (data != null) {
                        $select.val(data[element.name]);
                    }
                    form.render(null, 'component-tableform-element');
                }
            });
        }
    }

    /**
     *
     * @param formid
     * @param elements
     */
    var createForm = function (formid, elements, data) {
        formid += "_form";
        var form = '<form class="layui-form" id="' + formid + '" action="" lay-filter="component-tableform-element">';
        $("#table_form_div").append(form);
        // 表单中元素的名称
        var elementName = "";
        // 表单中元素的类型
        var elementType = "";
        var elementColset;
        var divRow;
        var divRowId;
        for (var i = 0; i < elements.length; i++) {
            elementName = elements[i].name;
            elementType = elements[i].type;
            elementColset = elements[i].class == undefined ? "layui-col-md6" : elements[i].class;
            // 隐藏列统一放在最后
            if (elementType == "hide") {
                $("#" + formid).append('<input type="hidden" name="' + elementName + '"/>');
            } else {
                // 一行两列布局
                if (i % 2 == 0) {
                    divRowId = "form_row" + i;
                    divRow = '<div class="layui-row layui-col-space10 layui-form-item" id="' + divRowId + '"></div>';
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
                if (elementType == "checkbox") {
                    createFormCheckbox(divRowId, formid, formid, elements[i], data);
                }
                // if (elementType == "radio") {
                //     createFormRadio(divRowId, formid, elements[i], data);
                // }
                // if (elementType == "file") {
                //     createFormFile(divRowId, formid, elements[i], data);
                // }
            }

        }
    }
    var obj = {
        /**
         * 根据表格初始化脚手架
         * @param objtable 表格对象
         */
        init: function (table) {
            objtable = table;
        },
        /**
         * 根据表格中字段设置生成对应的可编辑表单
         * @param id 可以不传使用通用对话框
         */
        showEditForm: function (data, dlgset, callback) {
            var title = "修改";
            if (data == null || data == "") {
                title = "新增";
            }
            var dlgwidth = "70%";
            var dlgheight = "85%";
            if (dlgset != undefined) {
                title = dlgset.title != undefined ? dlgset.title : title;
                dlgwidth = dlgset.width;
                dlgheight = dlgset.height;
            }
            layer.open({
                type: 1
                , title: title
                , area: admin.screen() < 2 ? ['80%', '300px'] : [dlgwidth, dlgheight]
                , content: tableFormdlg.innerHTML
            });
            // 生成form表单
            createForm(objtable.config.id, objtable.config.form, data);
            // 调用回调方法
            if (callback != undefined) {
                callback();
            }
        },
        /**
         * 根据表格中字段设置生成对应的可编辑表单
         * @param id 可以不传使用通用对话框
         */
        showViewForm: function (data) {

        },
        /**
         * 根据表格列设置生成查询表单
         */
        getQueryForm: function () {

        }
    }
    exports('tableScaffolding', obj);
})