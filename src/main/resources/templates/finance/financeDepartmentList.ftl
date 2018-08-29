<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>财务报销单列表</title>
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
    <script src="../../js/financeDepartmentList.js" rel="script"></script>
    <link type="text/css" rel="stylesheet" href="../../js/test/jeDate-test.css">
    <link type="text/css" rel="stylesheet" href="../../js/skin/jedate.css">
    <script type="text/javascript" src="../../js/src/jedate.js"></script>
</head>
<body style="  background-color: darkgray;">
<div id="div">
    <div><h2 style="color: rebeccapurple">上海三T</h2></div>
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
                                               <a  href="http://localhost:8080/page/pageshow"><div class="panel-body">
                                                    &nbsp; &nbsp; &nbsp;<span
                                                        class="glyphicon glyphicon-list-alt"></span>&nbsp;查看保险单
                                                </div></a>
                                                <div class="panel-body">
                                                    &nbsp; &nbsp; &nbsp;<span
                                                        class="glyphicon glyphicon-list-alt"></span>&nbsp;下载报销单
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
                                                                                    <span style="font-size:12px">报销单列表</span>
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
                                                <table class="table">
                                                    <tbody>
                                                        <tr class="error" id="firsttr">
                                                                <from>
                                                                    <td>报销单状态
                                                                        <select id="status">
                                                                            <option value="">全部</option>
                                                                            <option value="新创建">新建状态</option>
                                                                            <option value="已提交">已提交</option>
                                                                            <option value="待审批">待审批</option>
                                                                            <option value="已付款">已付款</option>
                                                                            <option value="待付款">待付款</option>
                                                                            <option value="通过">通过</option>
                                                                            <option value="已审批">已审批</option>
                                                                            <option value="已打回">已打回</option>
                                                                            <option value="已拒绝">已拒绝</option>
                                                                        </select>
                                                                    </td>
                                                                </from>
                                                            <td>
                                                                <div class="jeitem">
                                                                    <label class="jelabel">开始时间</label>
                                                                    <div class="jeinpbox"><input type="text" class="jeinput" id="test04" placeholder="YYYY-MM-DD hh:mm:ss"></div>
                                                                </div>
                                                            </td>
                                                            <td>
                                                                <div class="jeitem">
                                                                    <label
                                                                            class="jelabel">结束时间</label>
                                                                    <div class="jeinpbox"><input type="text" class="jeinput" id="enYMDhms" placeholder="YYYY-MM-DD hh:mm:ss"></div>
                                                                </div>
                                                            </td>
                                                                <th><button id="submi"
                                                                            class="btn btn-default btn-success btn-block">查询</button>
                                                                </th>
                                                                <th></th>
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
                                                <table class="table table-bordered table-hover table-condensed">
                                                    <thead>
                                                    <tr>
                                                        <th>编号</th>
                                                        <th>填报日期</th>
                                                        <th>填报人</th>
                                                        <th>总金额</th>
                                                        <th>状态</th>
                                                        <th>待处理人</th>
                                                        <th>修改时间</th>
                                                        <th>操作</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody id="datatbody">

                                                    </tbody>
                                                </table>
                                                <!---------------------------------------------数据列表------------------------------------------------------------------------>
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
<script type="text/javascript" src="../../js/test/demo.js"></script>

<script>
    $(function () {
        $("#enYMDhms").blur(function () {
            if ($("#test04").val()>$(this).val()){
                alert("请输入正确的时间")
            }
        })
    })
</script>
</html>