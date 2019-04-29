layui.define(['jquery'], function (exports) {
    var admin = layui.admin;
    var setter = layui.setter;
    var treeSetting;

    var beforeClick = function (treeId, treeNode) {
        var check = (treeNode && !treeNode.isParent);
        if (!check) alert("只能选择城市...");
        return check;
    }

    var onClick = function (event, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj(treeId);
        if (zTree.setting.check.enable == true) {
            zTree.checkNode(treeNode, !treeNode.checked, false)
            assignment(treeId, zTree.getCheckedNodes());
        } else {
            assignment(treeId, zTree.getSelectedNodes());
            hideMenu();
        }
        if (treeSetting.onClick) {
            treeSetting.onClick(treeId,treeNode);
        }
    }

    var onCheck = function (event, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj(treeId);
        assignment(treeId, zTree.getCheckedNodes());
        if (treeSetting.onCheck) {
            treeSetting.onCheck(treeId,treeNode);
        }
    }

    var hideMenu = function () {
        $(".select-tree").removeClass("layui-form-selected");
        $(".tree-content").fadeOut("fast");
        $("body").unbind("mousedown", onBodyDown);
    }

    var assignment = function (treeId, nodes) {
        var names = "";
        var ids = "";
        for (var i = 0, l = nodes.length; i < l; i++) {
            names += nodes[i].name + ",";
            ids += nodes[i].id + ",";
        }
        if (names.length > 0) {
            names = names.substring(0, names.length - 1);
            ids = ids.substring(0, ids.length - 1);
        }
        treeId = treeId.substring(0, treeId.length - 4);
        $("#" + treeId + "Show").attr("value", names);
        $("#" + treeId + "Show").attr("title", names);
        $("#" + treeId + "Hide").attr("value", ids);
    }

    var onBodyDown = function (event) {
        if ($(event.target).parents(".tree-content").html() == null) {
            hideMenu();
        }
    }

    var treeObj = {
        /**
         * 初始化下拉树表
         * @param id
         * @param isMultiple 是否多选
         * @param chkboxType 多选框类型{"Y": "ps", "N": "s"}
         */
        initSelectTree: function (id, zTreeSetting, value,required) {
            treeSetting = zTreeSetting;
            var formName = id.split("_")[0];
            var setting = {
                view: {
                    dblClickExpand: false,
                    showLine: false
                },
                data: {
                    simpleData: {
                        enable: true
                    }
                },
                check: {
                    enable: false,
                    chkboxType: {"Y": "ps", "N": "s"}
                },
                callback: {
                    onClick: onClick,
                    onCheck: onCheck
                }

            };
            if (zTreeSetting.check) {
                setting.check.enable = zTreeSetting.check.enable;
            }
            var html = '<div class = "layui-select-title" >' +
                '<input id="' + id + 'Show"' + 'type = "text" lay-verify="' + required + '" placeholder = "请选择" value = "" class = "layui-input" readonly>' +
                '<i class= "layui-edge" ></i>' +
                '</div>';
            $("#" + id).append(html);
            $("#" + id).parent().append('<div class="tree-content scrollbar" style="display: none">' +
                '<input hidden id="' + id + 'Hide" ' +
                'name="' + formName + '">' +
                '<ul id="' + id + 'Tree" class="ztree scrollbar" style="margin-top:0;"></ul>' +
                '</div>');
            $("#" + id).bind("click", function () {
                if ($(this).parent().find(".tree-content").css("display") !== "none") {
                    hideMenu();
                } else {
                    $(this).addClass("layui-form-selected");
                    var Offset = $(this).offset();
                    var width = $(this).width() - 5;
                    $(this).parent().find(".tree-content").css({
                        left: Offset.left + "px",
                        top: Offset.top + $(this).height() + "px"
                    }).slideDown("fast");
                    $(this).parent().find(".tree-content").css({
                        width: width
                    });
                    $("body").bind("mousedown", onBodyDown);
                }
            });
            var zTree;
            if (zTreeSetting.source instanceof Array) {
                zTree = $.fn.zTree.init($("#" + id + "Tree"), setting, zTreeSetting.source);
            } else {
                // setting.async = zTreeSetting.source;
                // setting.async.url = setter.remoteServiceAddress + setting.async.url;
                admin.req({//获取部门请求
                    url: setter.remoteServiceAddress + zTreeSetting.source.url
                    ,async: false
                    , done: function (result) {
                        zTree = $.fn.zTree.init($("#" + id + "Tree"), setting, result.data);
                    }
                });
            }
            if (value != null) {
                if (zTreeSetting.check) {
                    var values = value.split(",");
                    var showValue = "";
                    for (var i = 0; i < values.length; i++) {
                        showValue += zTree.getNodeByParam("id", values[i], null).name + ","
                        zTree.checkNode(zTree.getNodeByParam("id", values[i], null));
                    }
                    $("#" + id + "Hide").val(value);
                    $("#" + id + "Show").val(showValue.substr(0, showValue.length - 1));
                } else {
                    $("#" + id + "Hide").val(value);
                    $("#" + id + "Show").val(zTree.getNodeByParam("id", value, null).name);
                    zTree.selectNode(zTree.getNodeByParam("id", value, null));
                }
            }
        },
        /**
         * 初始化树组件
         * @param id 树的ID
         * @param zTreeSetting zTree的配置项
         * @param value 选中值
         */
        initTree: function (id, zTreeSetting, value) {
            treeSetting = zTreeSetting;
            var setting = {
                view: {
                    dblClickExpand: false,
                    showLine: false
                },
                data: {
                    simpleData: {
                        enable: true
                    }
                },
                check: {
                    enable: false,
                    chkboxType: {"Y": "ps", "N": "s"}
                },
                callback: {
                    onClick: onClick,
                    onCheck: onCheck
                }

            };
            if (zTreeSetting.check) {
                setting.check.enable = zTreeSetting.check.enable;
            }
            var zTree;
            if (zTreeSetting.source instanceof Array) {
                zTree = $.fn.zTree.init($("#" + id), setting, zTreeSetting.source);
            } else {
                admin.req({
                    url: setter.remoteServiceAddress + zTreeSetting.source.url
                    ,async: false
                    , done: function (result) {
                        zTree = $.fn.zTree.init($("#" + id), setting, result.data);
                    }
                });
            }
            if (value != null) {
                if (zTreeSetting.check) {
                    var values = value.split(",");
                    var showValue = "";
                    for (var i = 0; i < values.length; i++) {
                        showValue += zTree.getNodeByParam("id", values[i], null).name + ","
                        zTree.checkNode(zTree.getNodeByParam("id", values[i], null));
                    }
                } else {
                    zTree.selectNode(zTree.getNodeByParam("id", value, null));
                }
            }
            return zTree;
        }
    };
    exports('treeComponent', treeObj);
});
