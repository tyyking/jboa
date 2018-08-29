<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>查看保险单详情</title>
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
    <script src="../../js/findExpenseShow.js"></script>
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
                                                        class="glyphicon glyphicon-list-alt"></span>&nbsp;待定...
                                                </div>
                                                <div class="panel-body">
                                                    &nbsp; &nbsp; &nbsp;<span
                                                        class="glyphicon glyphicon-list-alt"></span>&nbsp;待定...
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
                                <div class="col-md-12 column" style="width: auto">
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
                                                                                    <span style="font-size:12px">报销单更新</span>
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
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="row" style="width: auto">
                                            <div class="col-md-12 column">
                                                <!---------------------------------------------数据列表------------------------------------------------------------------------>
                                                <h4>保险单更新</h4>
                                                <table id="tabs">

                                                    </tbody>
                                                </table>
                                                <!---------------------------------------------数据列表------------------------------------------------------------------------>
                                                <table id="tab">
                                                    <tr>
                                                        <td>项目</td>
                                                        <td>金额</td>
                                                        <td>备注</td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                                <span style="display: none" id="lid">${id}</span>
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

</script>
</html>