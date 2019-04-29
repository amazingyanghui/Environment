layui.define(['jquery'], function (exports) {
    var $ = layui.jquery;
    var table = layui.table;
    var setter = layui.setter;
    var laydate = layui.laydate;
    var serializeObject = function (form) {
        var o = {};
        var a = $("#" + form).serializeArray();
        $.each(a, function () {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
    var reload = function (formid, tableelem) {
        var formdata = serializeObject(formid);
        // if (height) {
        //     height = "full-" + height;
        // }else {
        //     height = "full-400";
        // }
        table.reload(tableelem, {
            page: {
                curr: 1 //重新从第 1 页开始
            }
            , where: formdata
            // , height: height
        });
    };
    var obj = {
        createQueryStandardForm: function (id, cols) {
            // TODO 根据表头信息自动生成标准查询表单，细节还需要思考
        },
        createQueryForm: function (id, cols) {
            // TODO 根据表头信息动态生成查询表单，细节还需要思考
        },
        initTableQuery: function (formId,tableelem) {
            laydate.render({
                elem: '#startDate' //指定元素,根据实际定义字段
                , type: 'datetime'
                , format: "yyyy-MM-dd HH:mm:ss"
            });
            laydate.render({
                elem: '#endDate' //指定元素,根据实际定义字段
                , type: 'datetime'
                , format: "yyyy-MM-dd HH:mm:ss"
            });

            $("#queryForm" + " input").each(function (index) { //取得整个页面的input值
                var inputname = $(this).attr("name");
                if (inputname != 'startDate' || inputname != 'endDate') {
                    $(this).keypress(function (event) {
                        if (event.keyCode == 13) {
                            reload(formId, tableelem);
                        }
                    });
                }
            });

            $("#queryForm" + " select").each(function (index) { //取得整个页面的input值
                $(this).change(function () {
                    reload(formId, tableelem);
                });
            });

        },
        reloadTable: function (formid, tableelem) {
            reload(formid, tableelem);
        },
        searchShow: function () {
            $("#searchCondition").removeClass("layui-hide").addClass("layui-show");
            $("#searchShow").addClass("layui-hide");
            $("#searchHide").removeClass("layui-hide");
        },
        searchHide: function () {
            $("#searchCondition").removeClass("layui-show").addClass("layui-hide");
            $("#searchHide").addClass("layui-hide");
            $("#searchShow").removeClass("layui-hide");
        },
        resetAndReload: function (formId, tableelem) {
            $("#" + formId)[0].reset();
            reload(formId, tableelem);
        },
        // 通用查询，暂时不启用
        commonQuery: function (formid, elem, tablewhere) {
            debugger;
            var formdata = serializeObject(formid);
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
                }
                var $select = $('#' + formid + ' select[name=' + attr + ']');
                if ($select.length > 0 && $select.val() != '') {
                    equalColumns.push({column: attr, value: formdata[attr]});
                }
            }
            tablewhere.likeColumns = likeColunms;
            tablewhere.equalColumns = equalColumns;
            if (tablewhere.dateColumn != '' && (tablewhere.startDate == undefined || tablewhere.endDate == undefined)) {
                delete tablewhere.dateColumn;
            }
            table.reload(elem, {
                url: setter.remoteServiceAddress + "/ledger/ledgerrunlist"
                , page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: tablewhere
                , done: function (res, curr, count) {
                    delete this.where.likeColumns;
                    delete this.where.equalColumns;
                }
            });
        }

    };
    //输出接口
    exports('tableQuery', obj);
});
