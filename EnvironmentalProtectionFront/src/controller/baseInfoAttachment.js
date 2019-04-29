layui.define(['jquery'], function (exports) {
    var $ = layui.jquery;
    var admin = layui.admin;
    var layer = layui.layer;
    var setter = layui.setter;
    var upload=layui.upload;
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
                location.href = setter.remoteServiceAddress + "/sys/file/download?file=" +encodeURI(viewfile);
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
                    url: setter.remoteServiceAddress + "/cominfo/cominfobaseinfoattachment/view",
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
        /**
         * 单文件上传后查看
         * table中使用
         */
        singleShowFile: function (id) {
            admin.req({//
                url: setter.remoteServiceAddress + "/cominfo/cominfobaseinfoattachment/" +  id
                , done: function (result) {
                    if (result.code == 0 && result.cominfoBaseinfoAttachment!=null) {//成功
                        showFile(result.cominfoBaseinfoAttachment.attachmentUrl);
                    }else {
                        return layer.msg('附件没有上传!');
                    }
                }
            });
        },
        /**
         * targetDiv:目标div, biztype: 业务类型，bizCode: 业务单号，新增时为空，accept: 文件类型，不指定默认是file,url:查询文件存放的url
         */
        multiUpload : function (targetDiv,bizType,bizCode,url,accept,attachment_upload_btn,upload_file_bizcode) {
            $("#"+targetDiv).html("");
            globle_obj.fileNumber = 0;
            if (accept==undefined || accept==null) {
                accept = "file";
            }
            if(attachment_upload_btn==null || attachment_upload_btn==undefined){
                attachment_upload_btn="attachment_upload_btn";
            }
            if(upload_file_bizcode==undefined || upload_file_bizcode==null){
                upload_file_bizcode='upload_file_bizcode';
            }
            var timestamp = Date.parse(new Date());
            var elem = "multifileupload" + timestamp;
            $('#'+ targetDiv).html('  <button type="button" class="layui-btn" id="'+elem+'"> <i class="layui-icon">&#xe67c;</i>上传</button> \n' +
                '  <div class="layui-upload-list">\n' +
                '<input id="'+upload_file_bizcode+'" type="hidden">' +
                '    <table class="layui-table">\n' +
                '      <thead>\n' +
                '        <tr><th>文件名</th>\n' +
                '        <th>状态</th>\n' +
                '        <th>操作</th>\n' +
                '      </tr></thead>\n' +
                '      <tbody id="multifileList'+timestamp+'"></tbody>\n' +
                '    </table>\n' +
                '  </div>\n' +
                '  <button type="button" class="hide" id="'+attachment_upload_btn+'"></button>');
            var demoListView = $('#multifileList'+timestamp)
                ,uploadListIns = layui.upload.render({
                elem: '#'+elem
                , headers: {
                    access_token: layui.data(setter.tableName).access_token
                }
                , url: setter.remoteServiceAddress + '/cominfo/cominfobaseinfoattachment/upload/'+bizType //上传接口//上传接口
                , accept: accept
                , before: function (obj) {
                    this.data = {cid:$('#'+upload_file_bizcode).val(),uploadType: 2}
                }
                ,multiple: true
                ,auto: false
                ,bindAction: '#'+attachment_upload_btn
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
                    url: url+"/dataByFile/" +  bizCode
                    , done: function (result) {
                        if (result.code == 0 && result.fileAttachment.length>0) {//成功
                            globle_obj.fileNumber = result.fileAttachment.length;
                            for (var index=0;index<result.fileAttachment.length;index++) {
                                var tr = $(['<tr id="upload-'+ index +'" filePath="' + result.fileAttachment[index].attachmentUrl +'" fileId="' + result.fileAttachment[index].pid +'">'
                                    ,'<td>'+ result.fileAttachment[index].fileName +'</td>'
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
                                    url: url
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

    };
    exports('baseInfoAttachment', obj);
});
