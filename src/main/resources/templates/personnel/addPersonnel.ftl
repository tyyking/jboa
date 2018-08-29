<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加人员</title>
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
                                        <div class="panel panel-default" style="display:none" id="renshi">
                                            <div class="panel-heading">
                                                <a class="panel-title collapsed" data-toggle="collapse" id="gly1"
                                                   data-parent="#panel-536715"
                                                   href="#panel-element-857286">
                                                    <span style="display:none">1</span>
                                                    <span class="glyphicon glyphicon-folder-open"> </span>
                                                    <span class="glyphicon glyphicon-folder-close"
                                                          style="display: none"> </span> 人员管理</a>
                                            </div>
                                            <div id="panel-element-857286" class="panel-collapse in">
                                                <div class="panel-body">
                                                    <a  href="http://localhost:8080/page/checkTheStaff">
                                                        &nbsp; &nbsp; &nbsp;<span
                                                            class="glyphicon glyphicon-list-alt"></span>&nbsp;查看人员
                                                    </a></div>

                                                <div class="panel-body">
                                                    <a  href="http://localhost:8080/page/addPersonnel">
                                                        &nbsp; &nbsp; &nbsp;<span
                                                            class="glyphicon glyphicon-list-alt"></span>&nbsp;添加人员
                                                    </a></div>
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

                                                    <tr class="error">
                                                        <td>
                                                            员工所在部门
                                                        </td>
                                                        <td>
                                                            <select id="sysDepartment">

                                                            </select>
                                                        </td>
                                                        <td>
                                                            员工职位
                                                        </td>
                                                        <td>
                                                            <select id="sysPosition">
                                                            </select>
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
                                                            员工编号
                                                        </td>
                                                        <td>
                                                            员工姓名
                                                        </td>
                                                        <td>
                                                            员工登陆密码
                                                        </td>
                                                    </tr>
                                                    <tr class="error" id="firsttr">
                                                        <td>
                                                            <input type="text" name="sn" id="sn" ><span id="span"></span>*
                                                        </td>
                                                        <td>
                                                            <input type="text" name="name" id="name">*
                                                        </td>
                                                        <td>
                                                            <input type="password" name="passWord" id="passWord">*
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
        $.ajax({
            type:"get",
            url:"http://localhost:8080/personnel/qeuryAllSysDepartmentAnd",
            data:{},
            datatype:"json",
            success:function (data) {
                $("select").children("option").remove();
                if (data["code"]==5){
                    $("#renshi").css("display","block");
                }
                var sysDepartment=(data["data"])["sysDepartment"];
                var sysPosition=(data["data"])["sysPosition"];
                for(var i=0;i<sysDepartment.length;i++){
                    $("#sysDepartment").append(" <option value='"+sysDepartment[i].id+"'>"+sysDepartment[i].name+"</option>");
                }
                for(var i=0;i<sysPosition.length;i++){
                    $("#sysPosition").append(" <option value='"+sysPosition[i].id+"'>"+sysPosition[i].nameCn+"</option>");
                }
            }
        });
        $("#sn").blur(function () {
            $.ajax({
                type:"get",
                url:"http://localhost:8080/personnel/queryPersonnelBySn",
                data:{
                    sn:$(this).val()
                },
                datatype:"json",
                success:function (data) {
                    if (data["code"]==5){
                        $("#renshi").css("display","block");
                    }
                    if (data["data"]==0){
                        $("#span").html("");
                   }else {
                       $("#span").html("已经有员工使用了这个编号请换一个");
                   }
                }
            });
        })
        $("#add").click(function () {
            $.ajax({
                type:"get",
                url:"http://localhost:8080/personnel/queryPersonnelBySn",
                data:{
                    sn:$(this).val()
                },
                datatype:"json",
                success:function (data) {
                    if (data["code"]==5){
                        $("#renshi").css("display","block");
                    }
                    if (data["data"]==0){
                        $("#span").html("");
                    }else {
                        $("#span").html("已经有员工使用了这个编号请换一个");
                        return false;
                    }
                }
            });
            $.ajax({
                type:"Post",
                url:"http://localhost:8080/personnel/addPersonnel",
                data:{
            /*        private  String  sn ;//员工编号
            private  Integer positionId;//员工职称
            private    Integer departmentId;//员工所属部
            private    String name;//员工名字
            private    String passWord;//密码
            private      String  status;//员工状态*/
            sn: $("#sn").val(),
                    positionId:$("#sysPosition>option:selected").val(),
                    departmentId:$("#sysDepartment>option:selected").val(),
                    name:$("#name").val(),
                    passWord:$("#passWord").val(),
                },
                datatype:"json",
                success:function (data) {
                   if (data["data"]>0){
                       location.href="http://localhost:8080/page/checkTheStaff";
                   }else {
                        ("添加失败请联系管理员")
                   }
                }
            });
        })
    })
</script>
</html>