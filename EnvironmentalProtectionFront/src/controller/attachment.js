layui.define(['jquery'], function (exports) {
    var $ = layui.jquery;
    var admin = layui.admin;
    var layer = layui.layer;
    var setter = layui.setter;
    var globle_obj = {};
    /**
     * 供obj内部调用
     * @param path
     */
    var showFile = function (path) {
        obj.view(path);
    }
    var obj = {
        /**
         * 附件预览，目前只支持doc,xls和pdf 以及图片
         * @param viewfile
         */
        view: function (viewfile) {
            if(viewfile==null || viewfile==undefined ||viewfile==""){
                layer.msg('附件没有上传！');
                return false;
            }
            var height = (window.innerHeight - 184) + 'px';
            var index = layer.open({
                type: 1
                , title: '附件预览'
                , area: admin.screen() < 2 ? ['80%', '300px'] : ['70%', '90%']
                // offset: '120px',
                , content: attachmentView.innerHTML
            });

            $("#common_download_btn").on('click', function () {
                location.href = setter.remoteServiceAddress + "/sys/file/download?file=" + encodeURI(viewfile);
            });

            var viewfile_array = viewfile.split(".");
            var type = viewfile_array[viewfile_array.length - 1];
            if (type == null || type == undefined) {
                layer.msg('附件的文件名错误!');
                return false;
            }
            if (type == 'pdf') {
                $('#doc_attachment').remove();
                $('#attachment_file').html();
                var options = {
                    height: height,
                    pdfOpenParams: {
                        pagemode: "thumbs",
                        navpanes: 0,
                        toolbar: 0,
                        scrollbar: 700,
                        statusbar: 0
                    }
                };
                PDFObject.embed(setter.remoteServiceAddress + viewfile, "#attachment_file", options);
            } else if (type == 'doc' || type == 'docx' ||type == 'xlsx'|| type == 'xls') {
                admin.req({
                    url: setter.remoteServiceAddress + "/sys/file/view",
                    data: {
                        "filepath": viewfile
                    },
                    done: function (result) {
                        debugger;
                        if (result.htmlfile.src == '') {
                            layer.msg('附件不存在!');
                        } else {
                            $('#attachment_file').html('');
                            $('#doc_attachment').remove();
                            $('#attachment_file').after('<iframe src=' + setter.remoteServiceAddress + result.htmlfile.src + ' style="width:100%;height:'+height+'" id="doc_attachment" ></iframe>');
                        }
                    }
                });
            } else if (type == 'jpg' || type == 'jpeg' || type == 'png' || type == 'gif') {
                $('#attachment_file').after('<iframe src=' + setter.remoteServiceAddress + viewfile + ' style="width:100%;height:'+height+'" id="doc_attachment" ></iframe>');
            } else {
                alert(type + '类型的附件暂不支持预览！');
                // layer.close(index);
            }
        },
        // 单文件上传后查看
        singleFileShow: function (targetDiv,bizCode) {
            $('#'+ targetDiv).html('          <label class="layui-form-label">附件：</label>\n' +
                '                                <div class="layui-input-block">\n' +
                '<input id="upload_file_bizcode" type="hidden">' +
                '                                    <span  id="uploadFileName"></span>\n' +
                '                                </div>');
            admin.req({//
                url: setter.remoteServiceAddress + "/sys/file/" +  bizCode
                , done: function (result) {
                    if (result.code == 0 && result.sysFile.length>0) {//成功
                        $("#uploadFileName").html('<a class="attachment_view" style="color:blue;cursor:pointer;">'+ result.sysFile[0].fileName+'<a>');
                        $('.attachment_view').click(function(){
                            showFile(result.sysFile[0].path);
                        });
                    }
                }
            });
        },
        /**
         * targetDiv:目标div, biztype: 业务类型，bizCode: 业务单号，新增时为空，accept: 文件类型，不指定默认是file
         */
        singleUpload: function (targetDiv, biztype,bizCode, accept) {
            if (accept==undefined) {
                accept = "file";
            }
            var timestamp = Date.parse(new Date());
            var elem = "uploadfile" + timestamp;
            $('#'+ targetDiv).html('          <label class="layui-form-label">附件：</label>\n' +
                '                                <div class="layui-input-block">\n' +
                '<input id="upload_file_bizcode" type="hidden">' +
                '                                    <button type="button" class="layui-btn" id="'+elem+'" style="float: left">\n' +
                '                                        <i class="layui-icon">&#xe67c;</i>上传\n' +
                '                                    </button>\n' +
                '                                    <span  id="uploadFileName"></span>\n' +
                '                                    <button type="button" style="display: none" id="attachment_upload_btn"></button>\n' +
                '                                </div>');
            //执行实例
            layui.upload.render({
                elem: '#'+elem  //绑定元素
                , headers: {
                    access_token: layui.data(setter.tableName).access_token
                }
                , url: setter.remoteServiceAddress + '/sys/file/upload/' + biztype//上传接口
                , accept: accept
                , before: function (obj) {
                    this.data = {bizCode: $('#upload_file_bizcode').val(),uploadType: "1"}
                    layer.load();
                }
                ,auto: false
                ,bindAction: '#attachment_upload_btn'
                , error: function (result) {
                    layer.closeAll('loading');
                    layer.msg('附件提交失败！');
                }
                ,done:function (result) {
                    layer.closeAll('loading');
                }
            });

            if (bizCode!='') {
                admin.req({//
                    url: setter.remoteServiceAddress + "/sys/file/" +  bizCode
                    , done: function (result) {
                        if (result.code == 0 && result.sysFile.length>0) {//成功
                            $("#uploadFileName").html('<a class="attachment_view" style="color:blue;cursor:pointer;">'+ result.sysFile[0].fileName+'<a>');
                            $('.attachment_view').click(function(){
                                showFile(result.sysFile[0].path);
                            });
                        }
                    }
                });
            }
        },
        /**
         * targetDiv:目标div, biztype: 业务类型，bizCode: 业务单号，新增时为空，accept: 文件类型，不指定默认是file
         */
        multiUpload : function (targetDiv,biztype,bizCode,accept) {
            globle_obj.fileNumber = 0;
            if (accept==undefined) {
                accept = "file";
            }
            var timestamp = Date.parse(new Date());
            var elem = "multifileupload" + timestamp;
            $('#'+ targetDiv).html('  <button type="button" class="layui-btn" id="'+elem+'"> <i class="layui-icon">&#xe67c;</i>上传</button> \n' +
                '  <div class="layui-upload-list">\n' +
                '<input id="upload_file_bizcode" type="hidden">' +
                '    <table class="layui-table">\n' +
                '      <thead>\n' +
                '        <tr><th>文件名</th>\n' +
                '        <th>状态</th>\n' +
                '        <th>操作</th>\n' +
                '      </tr></thead>\n' +
                '      <tbody id="multifileList"></tbody>\n' +
                '    </table>\n' +
                '  </div>\n' +
                '  <button type="button" class="hide" id="attachment_upload_btn"></button>');

            var demoListView = $('#multifileList')
                ,uploadListIns = layui.upload.render({
                elem: '#'+elem
                , headers: {
                    access_token: layui.data(setter.tableName).access_token
                }
                , url: setter.remoteServiceAddress + '/sys/file/upload/' + biztype//上传接口
                , accept: accept
                , before: function (obj) {
                    this.data = {bizCode: $('#upload_file_bizcode').val(),uploadType: "2"}
                }
                ,multiple: true
                ,auto: false
                ,bindAction: '#attachment_upload_btn'
                ,choose: function(obj){
                    var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                    //读取本地文件
                    obj.preview(function(index, file, result){
                        var i = index + globle_obj.fileNumber
                        var tr = $(['<tr id="upload-'+ i +'">'
                            ,'<td>'+ file.name +'</td>'
                            ,'<td>等待上传</td>'
                            ,'<td>'
                            ,'<a class="layui-btn layui-btn-mini layui-btn-danger  newfile-delete">删除</a>'
                            ,'</td>'
                            ,'</tr>'].join(''));

                        //删除
                        tr.find('.newfile-delete').on('click', function(){
                            delete files[index]; //删除对应的文件
                            tr.remove();
                            uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                        });

                        demoListView.append(tr);
                    });
                }
                ,done: function(res, index, upload){
                    if(res.code == 0){ //上传成功
                        var tr = demoListView.find('tr#upload-'+ index)
                            ,tds = tr.children();
                        tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                        tds.eq(3).html(''); //清空操作
                        return delete this.files[index]; //删除文件队列已经上传成功的文件
                    }
                    this.error(index, upload);
                }
                ,error: function(index, upload){
                    var tr = demoListView.find('tr#upload-'+ index)
                        ,tds = tr.children();
                    tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
                    tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
                }
            });
            // 修改
            if (bizCode!='') {
                admin.req({//
                    url: setter.remoteServiceAddress + "/sys/file/" +  bizCode
                    , done: function (result) {
                        if (result.code == 0 && result.sysFile.length>0) {//成功
                            globle_obj.fileNumber = result.sysFile.length;
                            for (var index=0;index<result.sysFile.length;index++) {
                                var tr = $(['<tr id="upload-'+ index +'" filePath="' + result.sysFile[index].path +'" fileId="' + result.sysFile[index].fileId +'">'
                                    ,'<td>'+ result.sysFile[index].fileName +'</td>'
                                    ,'<td>已上传文件</td>'
                                    ,'<td>'
                                    ,'<a class="layui-btn layui-btn-mini layui-btn-normal oldfile-view">预览</a>'
                                    ,'<a class="layui-btn layui-btn-mini layui-btn-danger oldfile-delete">删除</a>'
                                    ,'</td>'
                                    ,'</tr>'].join(''));
                                demoListView.append(tr);
                            }
                            //删除
                            $('.oldfile-delete').on('click', function(){
                                var $tr = $(this).parent().parent();
                                var id = [];
                                id.push($tr.attr("fileId"));
                                admin.req({//
                                    url: setter.remoteServiceAddress + "/sys/file"
                                    ,type: "DELETE"
                                    ,contentType:"application/json"
                                    ,data: JSON.stringify(id)
                                    , done: function (result) {
                                        if (result.code == 0) {//成功
                                            $tr.remove();
                                        }
                                    }
                                });
                            });

                            $('.oldfile-view').on('click', function(){
                                var $tr = $(this).parent().parent();
                                showFile($tr.attr("filePath"));
                            });
                        }
                    }
                });
            }
        },
        /**
         * 多文件
         */
        multiFileShow: function (targetDiv,bizCode) {
            $('#'+ targetDiv).html(
                '  <div class="layui-upload-list">\n' +
                '<input id="upload_file_bizcode" type="hidden">' +
                '    <table class="layui-table">\n' +
                '      <thead>\n' +
                '        <tr><th>文件名</th>\n' +
                '        <th>状态</th>\n' +
                '        <th>操作</th>\n' +
                '      </tr></thead>\n' +
                '      <tbody id="multifileList"></tbody>\n' +
                '    </table>\n' +
                '  </div>\n');
            var demoListView = $('#multifileList');
            admin.req({//
                url: setter.remoteServiceAddress + "/sys/file/" +  bizCode
                , done: function (result) {
                    if (result.code == 0 && result.sysFile.length>0) {//成功
                        globle_obj.fileNumber = result.sysFile.length;
                        for (var index=0;index<result.sysFile.length;index++) {
                            var tr = $(['<tr id="upload-'+ index +'" filePath="' + result.sysFile[index].path +'" fileId="' + result.sysFile[index].fileId +'">'
                                ,'<td>'+ result.sysFile[index].fileName +'</td>'
                                ,'<td>已上传文件</td>'
                                ,'<td>'
                                ,'<a class="layui-btn layui-btn-mini layui-btn-normal oldfile-view">预览</a>'
                                ,'</td>'
                                ,'</tr>'].join(''));
                            demoListView.append(tr);
                        }

                        $('.oldfile-view').on('click', function(){
                            var $tr = $(this).parent().parent();
                            showFile($tr.attr("filePath"));
                        });
                    }
                }
            });

        },

        /**
         * 多个单号，多个文件，一一对应
         * yjd
         */
        multiFileListShow: function (targetDiv,bizCode) {
            $('#'+ targetDiv).html(
                '  <div class="layui-upload-list">\n' +
                '<input id="upload_file_bizcode" type="hidden">' +
                '    <table class="layui-table">\n' +
                '      <thead>\n' +
                '        <tr><th>文件名</th>\n' +
                '        <th>状态</th>\n' +
                '        <th>操作</th>\n' +
                '      </tr></thead>\n' +
                '      <tbody id="multifileList"></tbody>\n' +
                '    </table>\n' +
                '  </div>\n');
            var demoListView = $('#multifileList');
            admin.req({//
                url: setter.remoteServiceAddress + "/production/productionwastewasteregister/fileInfo"
                ,type:"POST"
                ,data:{"strCols":JSON.stringify(bizCode)}
                ,done: function (result) {
                    if (result.code == 0 && result.sysFile.length>0) {//成功
                        globle_obj.fileNumber = result.sysFile.length;
                        for (var index=0;index<result.sysFile.length;index++) {
                            var tr = $(['<tr id="upload-'+ index +'" filePath="' + result.sysFile[index].path +'" fileId="' + result.sysFile[index].fileId +'">'
                                ,'<td>'+ result.sysFile[index].fileName +'</td>'
                                ,'<td>已上传文件</td>'
                                ,'<td>'
                                ,'<a class="layui-btn layui-btn-mini layui-btn-normal oldfile-view">预览</a>'
                                ,'</td>'
                                ,'</tr>'].join(''));
                            demoListView.append(tr);
                        }

                        $('.oldfile-view').on('click', function(){
                            var $tr = $(this).parent().parent();
                            showFile($tr.attr("filePath"));
                        });
                    }
                }
            });

        },
        /**
         * 单文件上传后查看
         * table中使用
         */
        singleShowFile: function (bizCode) {
            admin.req({//
                url: setter.remoteServiceAddress + "/sys/file/" +  bizCode
                , done: function (result) {
                    if (result.code == 0 && result.sysFile.length>0) {//成功
                        showFile(result.sysFile[0].path);
                    }else {
                        return layer.msg('附件没有上传!');
                    }
                }
            });
        }

    };
    exports('attachment', obj);
});
