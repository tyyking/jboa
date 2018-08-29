<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加保险单</title>
    <style>
        textarea {
            width: 98.9%;
            max-width: 99%;
            height: 90px;
            max-height: 100px;
            scrollbar: overflow;
            overflow-y: auto;
        }
    </style>
    <link  href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
    <script src="../../js/jquery.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.js"></script>
    <script src="../../js/publicExpense.js"></script>
    <script src="../../js/addExpense.js"></script>
</head>
<body style="  background-color: darkgray;">
<div id="div">
    <div><h2 style="color: rebeccapurple">上海三利</h2></div>
    <div style="height:50px;background-color: #eaeaea;"><h4 style="position: relative;top: 20px">【登录角色:员工】 &nbsp;&nbsp;&nbsp;<span>  <#if Session["ename"]?exists>
    ${Session["ename"]}
    </#if>你好!欢迎访问上海三利的管理系统!</span>&nbsp;&nbsp;&nbsp;<a href="http://localhost:8080/lodings/lodingOut">退出</a>
    </h4></div>
    <div>
        <div style="background-color: #A9A9A9;height: 15px;color: #A9A9A9">0000</div>
        <div class="container" style="width: auto;margin-left:2%;margin-right: 2%">
            <div class="row">
                <div class="col-md-12 column">
                    <div class="row">
                        <div class="col-md-3 column" style="background-color: white;height: 300px">
                            <!--左侧工具栏-->
                            <div class="row clearfix" style="width: auto">
                                <div class="col-md-12 column"
                                     style="margin-left: -15px;margin-right: -15px;width: auto">
                                    <div class="panel-group" id="panel-536715">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                <a class="panel-title collapsed" data-toggle="collapse" id="gly1"
                                                   data-parent="#panel-536715"
                                                    href="http://localhost:8080/#panel-element-857286">
                                                    <span style="display:none">1</span>
                                                    <span class="glyphicon glyphicon-folder-open"> </span>
                                                    <span class="glyphicon glyphicon-folder-close"
                                                          style="display: none"> </span> 报销单管理</a>
                                            </div>
                                            <div id="panel-element-857286" class="panel-collapse in">
                                                <div class="panel-body">
                                                    <a  href="http://localhost:8080/page/accountShowList">
                                                        &nbsp; &nbsp; &nbsp;<span
                                                            class="glyphicon glyphicon-list-alt"></span>&nbsp;查看保险单
                                                    </a></div>

                                                <div class="panel-body">
                                                    <a  href="http://localhost:8080/page/addExen">
                                                        &nbsp; &nbsp; &nbsp;<span
                                                            class="glyphicon glyphicon-list-alt"></span>&nbsp;添加报销单
                                                    </a></div>
                                                <div class="panel-body">
                                                    &nbsp; &nbsp; &nbsp;<span
                                                        class="glyphicon glyphicon-list-alt"></span>&nbsp;下载报销单
                                                </div>
                                            </div>
                                        </div>
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                <a class="panel-title collapsed" data-toggle="collapse" id="gly2"
                                                   data-parent="#panel-536715"
                                                    href="http://localhost:8080/#panel-element-160107">
                                                    <span style="display:none">1</span>
                                                    <span class="glyphicon glyphicon-folder-close"> </span>
                                                    <span class="glyphicon glyphicon-folder-open"
                                                          style="display: none"></span> 请假单管理</a>
                                            </div>
                                            <div id="panel-element-160107"
                                                 class="panel-collapse collapse">
                                                <a  href="http://localhost:8080/page/selectLeavers">
                                                    <div class="panel-body">
                                                        &nbsp; &nbsp; &nbsp;<span
                                                            class="glyphicon glyphicon-list-alt"></span>&nbsp;查看请假单
                                                    </div>
                                                </a>
                                                <div class="panel-body">
                                                    <a  href="http://localhost:8080/page/addLeaver">
                                                        &nbsp; &nbsp; &nbsp;<span
                                                            class="glyphicon glyphicon-list-alt"></span>&nbsp;添加请假单
                                                    </a>
                                                </div>
                                                <div class="panel-body">
                                                    &nbsp; &nbsp; &nbsp;<span
                                                        class="glyphicon glyphicon-list-alt"></span>&nbsp;下载请假单
                                                </div>
                                            </div>
                                        </div>
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                <a class="panel-title collapsed" data-toggle="collapse" id="gly3"
                                                   data-parent="#panel-536715"
                                                    href="http://localhost:8080/#panel-element-160106">
                                                    <span style="display:none">1</span>
                                                    <span class="glyphicon glyphicon-folder-close"> </span>
                                                    <span class="glyphicon glyphicon-folder-open"
                                                          style="display: none"></span> 信息中心</a>
                                            </div>
                                            <div id="panel-element-160106"
                                                 class="panel-collapse collapse">
                                                <div class="panel-body">
                                                    &nbsp; &nbsp; &nbsp;<span
                                                        class="glyphicon glyphicon-list-alt"></span>&nbsp;待定
                                                </div>
                                                <div class="panel-body">
                                                    &nbsp; &nbsp; &nbsp;<span
                                                        class="glyphicon glyphicon-list-alt"></span>&nbsp;待定
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-8 column col-md-offset-1" style="background-color: white">
                            <!--右侧添加页面-->
                            <div class="row clearfix">
                                <div class="col-md-12 column">
                                    <div class="row ">
                                        <div class="col-md-12 column">
                                            <div class="row clearfix">
                                                <table class="table">
                                                    <tbody>
                                                    <tr>
                                                        <div class="container">
                                                            <div class="row clearfix">
                                                                <div class="col-md-12 column">
                                                                    <div class="row clearfix">
                                                                        <div class="col-md-1 column">
                                                                            <div class="row clearfix">
                                                                                <div class="col-md-12 column">
                                                                                    <span style="font-size:12px">报销单添加</span>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-7 column">
                                                                            <div class="row clearfix">
                                                                                <div class="col-md-12 column"
                                                                                     style="background-color:#A9A9A9">
                                                                                    <span style="color: #A9A9A9">报销单</span>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-4 column">
                                                                            <div class="row clearfix">
                                                                                <div class="col-md-12 column"
                                                                                     style="background-color:#A9A9A9">
                                                                                    <span style="color: #A9A9A9">报销单</span>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </tr>
                                                    <tr class="success">
                                                        <td>
                                                            *填报人
                                                        </td>
                                                        <td id="name">
                                                        <#if Session["ename"]?exists>
                                                        ${Session["ename"]}
                                                        </#if>
                                                        </td>
                                                        <td>
                                                            *填报时间
                                                        </td>
                                                        <td id="time">
                                                            2013-8-13 8:30
                                                        </td>
                                                    </tr>
                                                    <tr class="error">
                                                        <td>
                                                            *总金额￥
                                                        </td>
                                                        <td>
                                                            <input id="account" type="text" disabled="disabled" value="0">
                                                        </td>
                                                        <td>
                                                            *状态
                                                        </td>
                                                        <td>
                                                            <input type="text" id="status" value="新创建"
                                                                   disabled="disabled">
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <table class="table">
                                                    <tbody id="item">
                                                    <tr>
                                                        <td colspan="3">
                                                            *
                                                        </td>
                                                    </tr>
                                                    <tr class="success">
                                                        <td>
                                                            项目类别
                                                        </td>
                                                        <td>
                                                            项目金额
                                                        </td>
                                                        <td>
                                                            费用说明
                                                        </td>
                                                        <td>
                                                            操作
                                                        </td>
                                                    </tr>
                                                    <tr class="error" id="firsttr">
                                                        <td>
                                                            <select name="item">
                                                                <option>城市交通费</option>
                                                                <option>礼品费</option>
                                                                <option>交际餐费</option>
                                                                <option>办公费</option>
                                                                <option>住宿</option>
                                                                <option>交通</option>
                                                            </select>
                                                        </td>
                                                        <td>
                                                            <input type="text" name="money" onblur='add(this)'>*
                                                        </td>
                                                        <td>
                                                            <input type="text" name="des">*
                                                        </td>
                                                        <td><a id="addplus"><span
                                                                class="glyphicon glyphicon-plus"></span></a></td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="4">
                                                            <span>*事由</span>
                                                            <textarea id="EVENT" style="resize:none"
                                                                      placeholder="请填写请假事由..."></textarea>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="4" style="text-align: center">
                                                            <button id="add" type="button"
                                                                    class="btn btn-default btn-danger">保存
                                                            </button>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $(function () {
       /* var username = '<%= session.getAttribute("ename")%>';*/
/*
        $("#name").html(username);
*/
        function p(s) {
            return s < 10 ? '0' + s: s;
        }
        var myDate = new Date();
//获取当前年
        var year=myDate.getFullYear();
//获取当前月
        var month=myDate.getMonth()+1;
//获取当前日
        var date=myDate.getDate();
        var now=year+'-'+p(month)+"-"+p(date)
        $("#time").html(now);
/*
         (now)
*/
/*
         (username)
*/
    })
   /* $(function () {
     /!*   $(".money").blur(
            function () {
                var money=document.getElementsByClassName(money);
                var account=0
                for(var i=0;i<money.length;i++){
                     account=account+money.get(i).value;
                }
               /!*var money=$(".money")
                for(){

                }
                       var account=*!/
                 (account);
            }
        )*!/
    })*/
</script>
</html>