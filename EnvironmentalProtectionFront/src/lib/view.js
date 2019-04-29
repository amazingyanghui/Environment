/** layuiAdmin-v1.0.0-beta6 LPPL License By http://www.layui.com/admin/ */
;layui.define(["laytpl", "layer"], function (e) {
    var t = layui.jquery, a = layui.laytpl, n = layui.layer, r = layui.setter, o = (layui.device(), layui.hint()),
        i = function (e) {
            return new d(e)
        }, s = "LAY_app_body", d = function (e) {
            this.id = e, this.container = t("#" + (e || s))
        };
    i.loading = function (e) {
        e.append(this.elemLoad = t('<i class="layui-anim layui-anim-rotate layui-anim-loop layui-icon layui-icon-loading layadmin-loading"></i>'))
    },
        i.removeLoad = function () {
            this.elemLoad && this.elemLoad.remove()
        },
        i.exit = function () {
            layui.data(r.tableName, {key: r.request.tokenName, remove: !0}),
                layui.data(r.permissionName, {key: r.permissionName, remove: !0}),
                layui.data(r.userName, {key: r.userName, remove: !0}),
                layui.data(r.userId, {key: r.userId, remove: !0}),
                layui.data(r.userRoles, {key: r.userRoles, remove: !0}),
                layui.data(r.userDeptId, {key: r.userDeptId, remove: !0}),
                layui.data(r.userDeptName, {key: r.userDeptName, remove: !0}),
                layui.data(r.remoteServiceAddressStore, {key: r.remoteServiceAddressStore, remove: !0}),
                layui.data(r.superAdminStore, {key: r.superAdminStore, remove: !0}),
                layui.data(r.companyRoleIdStore, {key: r.companyRoleIdStore, remove: !0}),
                n.closeAll(),
                location.hash = "/user/login"
        },
        i.req = function (e) {
            var a = e.success, n = (e.error, r.request), rr = r, o = r.response, s = function () {
                return r.debug ? "<br><cite>URL：</cite>" + e.url : ""
            };
            return e.data = e.data || {}, e.headers = e.headers || {},
                // n.tokenName&&(e.data[n.tokenName]=n.tokenName in e.data?e.data[n.tokenName]:layui.data(r.tableName)[n.tokenName]||"",
                e.headers[n.tokenName] = n.tokenName in e.headers ? e.headers[n.tokenName] : layui.data(r.tableName)[n.tokenName] || ""
                // ),
                , delete e.success, delete e.error, t.ajax(t.extend({
                type: "get",
                dataType: "json",
                success: function (t) {
                    var n = o.statusCode;
                    if (t[o.statusName] == n.ok || t[o.statusName] == n.tip) {
                        if (t[rr.request.tokenName]) {
                            layui.data(rr.tableName, {
                                key: rr.request.tokenName
                                , value: t[rr.request.tokenName]
                            })
                        }
                        ;
                        "function" == typeof e.done && e.done(t);
                    }else if (t[o.statusName] == n.logout) i.exit();
                    else if (t[o.statusName] == n.invalidToken) i.exit();
                    else {
                        var r = ["<cite>Error：</cite> " + (t[o.msgName] || "返回状态码异常"), s()].join("");
                        i.error(r)
                    }
                    "function" == typeof a && a(t)
                }
                , error: function (e, t) {
                    if (e.status === o.statusCode.logout) {
                        //     var html = ""
                        //     html += '<div class="layui-card-body">'
                        //     html += '<input type="hidden" name="userId" />'
                        //     html += '<div class="layui-row layui-col-space10 layui-form-item">'
                        //     html += '<label class="layui-form-label">用户名：</label>'
                        //     html += '<div class="layui-input-block">
                        //     html += '<input type="text" name="username" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
                        //     html += '</div>
                        //     html += '</div>
                        //     html += ' <div class="layui-row layui-col-space10 layui-form-item">
                        //         <label class="layui-form-label">密码：</label>
                        //     <div class="layui-input-block">
                        //         <input type="password" name="password" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
                        //         </div>
                        //         </div>
                        //         </div>
                        //     layui.layer.open({
                        //     title: '在线调试'
                        //     ,content: ''
                        // })
                        i.exit()
                        ;
                    }//token过期
                    else {
                        var a = ["请求异常，请检查后台服务是否开启<br><cite>错误信息：</cite>" + t, s()].join("");
                        i.error(a), "function" == typeof a && a(res)
                    }
                }
            }, e))
        }
        ,
        i.popup = function (e) {
            var a = e.success, r = e.skin;
            delete e.success, delete e.skin, n.open(t.extend(
                {
                    type: 1,
                    title: "提示",
                    content: "",
                    id: "LAY-system-view-popup",
                    skin: "layui-layer-admin" + (r ? " " + r : ""),
                    shadeClose: !0,
                    closeBtn: !1,
                    success: function (e, r) {
                        var o = t('<i class="layui-icon" close>&#x1006;</i>');
                        e.append(o), o.on("click", function () {
                            n.close(r)
                        }), "function" == typeof a && a.apply(this, arguments)
                    }
                }
                , e))
        }, i.error = function (e, a) {
        return i.popup(t.extend({content: e, maxWidth: 300, offset: "t", anim: 6, id: "LAY_adminError"}, a))
    },
        d.prototype.render = function (e, a) {
            // var data = {v: layui.cache.version};
            var reg = new RegExp("^"+"parm:");
            if (reg.test(e)==true) {
                e = e.replace("parm:","");
                var url = e.split("?");
                e = url[0];
                var param = url[1].split("&");
                param.forEach(function(value,index,array){
                    // var dataparm = value.split("=");
                    // data[dataparm[0]] = dataparm[1];
                });
            }
            var n = this;
            layui.router();
            return e = r.views + e + r.engine, t("#" + s).children(".layadmin-loading").remove(), i.loading(n.container),
                t.ajax({
                    url: e, type: "get", dataType: "html", data: {v: layui.cache.version},
                    success: function (e) {
                        e = "<div>" + e + "</div>";
                        var r = t(e).find("title"), o = r.text(), s = {title: o, body: e};
                        r.remove(), n.params = a || {}, n.then && (n.then(s), delete n.then), n.parse(e), i.removeLoad(), n.done && (n.done(s), delete n.done)
                    },
                    error: function (e) {
                        return i.removeLoad(), n.render.isError ? i.error("请求视图文件异常，状态：" + e.status) : (404 === e.status ? n.render("template/tips/404") : n.render("template/tips/error"),
                            void(n.render.isError = !0))
                    }
                }), n
        },
        d.prototype.parse = function (e, n, r) {
            var s = this, d = "object" == typeof e, l = d ? e : t(e), u = d ? e : l.find("*[template]"),
                c = function (e) {
                    var n = a(e.dataElem.html());
                    e.dataElem.after(n.render(t.extend({params: y.params}, e.res))), "function" == typeof r && r();
                    try {
                        e.done && new Function("d", e.done)(e.res)
                    } catch (o) {
                        console.error(e.dataElem[0], "\n存在错误回调脚本\n\n", o)
                    }
                }, y = layui.router();
            l.find("title").remove(), s.container[n ? "after" : "html"](l.children()), y.params = s.params || {};
            for (var p = u.length; p > 0; p--) !function () {
                var e = u.eq(p - 1), t = e.attr("lay-done") || e.attr("lay-then"),
                    n = a(e.attr("lay-url") || "").render(y), r = a(e.attr("lay-data") || "").render(y),
                    s = a(e.attr("lay-headers") || "").render(y);
                try {
                    r = new Function("return " + r + ";")()
                } catch (d) {
                    o.error("lay-data: " + d.message), r = {}
                }
                try {
                    s = new Function("return " + s + ";")()
                } catch (d) {
                    o.error("lay-headers: " + d.message), s = s || {}
                }
                n ? i.req({
                    type: e.data("lay-type") || "get", url: n, data: r, dataType: "json", headers: s,
                    success: function (a) {
                        c({dataElem: e, res: a, done: t})
                    }
                }) : c({dataElem: e, done: t})
            }();
            return s
        },
        d.prototype.send = function (e, t) {
            var n = a(e || this.container.html()).render(t || {});
            return this.container.html(n), this
        },
        d.prototype.refresh = function (e) {
            var t = this, a = t.container.next(), n = a.attr("lay-templateid");
            return t.id != n ? t : (t.parse(t.container, "refresh", function () {
                t.container.siblings('[lay-templateid="' + t.id + '"]:last').remove(), "function" == typeof e && e()
            }), t)
        },
        d.prototype.then = function (e) {
            return this.then = e, this
        },
        d.prototype.done = function (e) {
            return this.done = e, this
        },
        e("view", i)
});