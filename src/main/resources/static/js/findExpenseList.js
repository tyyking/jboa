/*员工查询报销单表*/
$(function () {
    /*默认查询报销单,列表*/
    $.ajax({
        type:"get",
       url:"http://localhost:8080/empAccount/selectEmpAccount",
        data:{},
        dataType:"json",
        success:function (data) {
            var da=data["data"];
            for(var i=0;i<da.length;i++){
                if (da[i].bstatus=="新创建" ||da[i].bstatus=="已打回" || da[i].bstatus=="已拒绝"||da[i].bstatus=="已终止"){
                    $("#tab").append("<tr>\n"+
                        "<td>"+da[i].bid+"</td>\n"+
                        "<td>"+da[i].btime+"</td>\n"+
                        "<td>"+da[i].ename+"</td>\n"+
                        "<td>"+da[i].baccount+"</td>\n"+
                        "<td>"+da[i].bstatus+"</td>\n"+
                        "<td>"+da[i].nexSn+"</td>\n"+
                        "<td>\n"+
                        "<a onclick='upd("+da[i].bid+")'><span class=\"glyphicon glyphicon-pencil\"></span></a> &nbsp;&nbsp;\n"+
                        "<a onclick='del("+da[i].bid+")'><span class=\"glyphicon glyphicon-trash\"></span></a> &nbsp;&nbsp;\n"+
                        "<a onclick='tijiao("+da[i].bid+")'><span class=\"glyphicon glyphicon-ok\"></span></a>&nbsp;&nbsp;\n"+
                        "<a onclick='show("+da[i].bid+")'><span class=\"glyphicon glyphicon-zoom-in\"></span></a>&nbsp;&nbsp;\n"+
                        "</td>\n"+
                        "</tr>");
                }else {
                    $("#tab").append("<tr>\n"+
                        "<td>"+da[i].bid+"</td>\n"+
                        "<td>"+da[i].btime+"</td>\n"+
                        "<td>"+da[i].ename+"</td>\n"+
                        "<td>"+da[i].baccount+"</td>\n"+
                        "<td>"+da[i].bstatus+"</td>\n"+
                        "<td>"+da[i].nexSn+"</td>\n"+
                        "<td>\n"+
                        "<a onclick='show("+da[i].bid+")'><span class=\"glyphicon glyphicon-zoom-in\"></span></a>&nbsp;&nbsp;\n"+
                        "</td>\n"+
                        "</tr>");
                }

            }
        }
    });
    $("#selec").click(function () {
        var start= $("#test04").val();
        var end= $("#enYMDhms").val();
        var optin=$("#option>option:selected").val();

        if((optin==""||optin==null)&&(start==''||start==null)&&(end==null||end=='')){
            $(function () {
                /*默认查询报销单,列表*/
                $.ajax({
                    type:"get",
                    url:"http://localhost:8080/empAccount/selectEmpAccount",
                    data:{},
                    dataType:"json",
                    success:function (data) {
                        var da = data["data"];
                        $("#tab").children("tr").remove();
                        for (var i = 0; i < da.length; i++) {
                            if (da[i].bstatus=="新创建" ||da[i].bstatus=="已打回" || da[i].bstatus=="已拒绝"||da[i].bstatus=="已终止"){
                                $("#tab").append("<tr>\n" +
                                    "<td>" + da[i].bid + "</td>\n" +
                                    "<td>" + da[i].btime + "</td>\n" +
                                    "<td>" + da[i].ename + "</td>\n" +
                                    "<td>" + da[i].baccount + "</td>\n" +
                                    "<td>" + da[i].bstatus + "</td>\n" +
                                    "<td>" + da[i].nexSn + "</td>\n" +
                                    "<td>\n" +
                                    "<a onclick='upd(" + da[i].bid + ")'><span class=\"glyphicon glyphicon-pencil\"></span></a> &nbsp;&nbsp;\n" +
                                    "<a onclick='del(" + da[i].bid + ")'><span class=\"glyphicon glyphicon-trash\"></span></a> &nbsp;&nbsp;\n" +
                                    "<a onclick='tijiao(" + da[i].bid + ")'><span class=\"glyphicon glyphicon-ok\"></span></a>&nbsp;&nbsp;\n" +
                                    "<a onclick='show(" + da[i].bid + ")'><span class=\"glyphicon glyphicon-zoom-in\"></span></a>&nbsp;&nbsp;\n" +
                                    "</td>\n" +
                                    "</tr>");
                            } else {
                                $("#tab").append("<tr>\n" +
                                    "<td>" + da[i].bid + "</td>\n" +
                                    "<td>" + da[i].btime + "</td>\n" +
                                    "<td>" + da[i].ename + "</td>\n" +
                                    "<td>" + da[i].baccount + "</td>\n" +
                                    "<td>" + da[i].bstatus + "</td>\n" +
                                    "<td>" + da[i].nexSn + "</td>\n" +
                                    "<td>\n" +
                                    "<a onclick='show(" + da[i].bid + ")'><span class=\"glyphicon glyphicon-zoom-in\"></span></a>&nbsp;&nbsp;\n" +
                                    "</td>\n" +
                                    "</tr>");
                            }
                        }
                    }
                });
            });
        }else if(((start==''||start==null)&&(end==null||end=='')&&(optin!=""||optin!=null))){
            $(function () {
                /*默认查询报销单,列表*/
                $.ajax({
                    type:"get",
                    url:"http://localhost:8080/empAccount/selectEmpAccountStatus/"+optin,
                    data:{},
                    dataType:"json",
                    success:function (data) {
                        $("#tab").children("tr").remove();
                        var da=data["data"];
                        for(var i=0;i<da.length;i++){
                            if (da[i].bstatus=="新创建" ||da[i].bstatus=="已打回" || da[i].bstatus=="已拒绝"||da[i].bstatus=="已终止"){
                                $("#tab").append("<tr>\n"+
                                    "<td>"+da[i].bid+"</td>\n"+
                                    "<td>"+da[i].btime+"</td>\n"+
                                    "<td>"+da[i].ename+"</td>\n"+
                                    "<td>"+da[i].baccount+"</td>\n"+
                                    "<td>"+da[i].bstatus+"</td>\n"+
                                    "<td>"+da[i].nexSn+"</td>\n"+
                                    "<td>\n"+
                                    "<a onclick='upd("+da[i].bid+")'><span class=\"glyphicon glyphicon-pencil\"></span></a> &nbsp;&nbsp;\n"+
                                    "<a onclick='del("+da[i].bid+")'><span class=\"glyphicon glyphicon-trash\"></span></a> &nbsp;&nbsp;\n"+
                                    "<a onclick='tijiao("+da[i].bid+")'><span class=\"glyphicon glyphicon-ok\"></span></a>&nbsp;&nbsp;\n"+
                                    "<a onclick='show("+da[i].bid+")'><span class=\"glyphicon glyphicon-zoom-in\"></span></a>&nbsp;&nbsp;\n"+
                                    "</td>\n"+
                                    "</tr>");
                            }else {
                                $("#tab").append("<tr>\n"+
                                    "<td>"+da[i].bid+"</td>\n"+
                                    "<td>"+da[i].btime+"</td>\n"+
                                    "<td>"+da[i].ename+"</td>\n"+
                                    "<td>"+da[i].baccount+"</td>\n"+
                                    "<td>"+da[i].bstatus+"</td>\n"+
                                    "<td>"+da[i].nexSn+"</td>\n"+
                                    "<td>\n"+
                                    "<a onclick='show("+da[i].bid+")'><span class=\"glyphicon glyphicon-zoom-in\"></span></a>&nbsp;&nbsp;\n"+
                                    "</td>\n"+
                                    "</tr>");
                            }
                        }
                    }
                });
            });
        }else{
            $(function () {
                /*默认查询报销单,列表*/
                if(optin==""||optin==null){
                    optin=1;
                }
                $.ajax({
                    type:"get",
                    url:"http://localhost:8080/empAccount/selectEmpAccountTime/"+optin+"/"+start+"/"+end,
                    data:{},
                    dataType:"json",
                    success:function (data) {
                        var da=data["data"];
                        $("#tab").children("tr").remove();
                        for(var i=0;i<da.length;i++){
                            if (da[i].bstatus=="新创建" ||da[i].bstatus=="已打回" || da[i].bstatus=="已拒绝"||da[i].bstatus=="已终止"){
                                $("#tab").append("<tr>\n"+
                                    "<td>"+da[i].bid+"</td>\n"+
                                    "<td>"+da[i].btime+"</td>\n"+
                                    "<td>"+da[i].ename+"</td>\n"+
                                    "<td>"+da[i].baccount+"</td>\n"+
                                    "<td>"+da[i].bstatus+"</td>\n"+
                                    "<td>"+da[i].nexSn+"</td>\n"+
                                    "<td>\n"+
                                    "<a onclick='upd("+da[i].bid+")'><span class=\"glyphicon glyphicon-pencil\"></span></a> &nbsp;&nbsp;\n"+
                                    "<a onclick='del("+da[i].bid+")'><span class=\"glyphicon glyphicon-trash\"></span></a> &nbsp;&nbsp;\n"+
                                    "<a onclick='tijiao("+da[i].bid+")'><span class=\"glyphicon glyphicon-ok\"></span></a>&nbsp;&nbsp;\n"+
                                    "<a onclick='show("+da[i].bid+")'><span class=\"glyphicon glyphicon-zoom-in\"></span></a>&nbsp;&nbsp;\n"+
                                    "</td>\n"+
                                    "</tr>");
                            }else {
                                $("#tab").append("<tr>\n"+
                                    "<td>"+da[i].bid+"</td>\n"+
                                    "<td>"+da[i].btime+"</td>\n"+
                                    "<td>"+da[i].ename+"</td>\n"+
                                    "<td>"+da[i].baccount+"</td>\n"+
                                    "<td>"+da[i].bstatus+"</td>\n"+
                                    "<td>"+da[i].nexSn+"</td>\n"+
                                    "<td>\n"+
                                    "<a onclick='show("+da[i].bid+")'><span class=\"glyphicon glyphicon-zoom-in\"></span></a>&nbsp;&nbsp;\n"+
                                    "</td>\n"+
                                    "</tr>");
                            }
                        }
                    }
                });
            });
        }
    });

});

/*删除*/
function del(i) {
    $(function () {
        /*默认查询报销单,列表*/
        $.ajax({
            type:"post",
           url:"http://localhost:8080/empAccount/delAccount/"+i,
            data:{},
            dataType:"json",
            success:function (data) {
                if(data.code==0){
                     ("删除成功")
                    location. href="http://localhost:8080/page/accountShowList";
                }else {
                     ("删除失败,请联系管理员")
                }
            }
        });
    });

}
/*提交*/
function tijiao(i) {
    $(function () {
        /*默认查询报销单,列表*/
        $.ajax({
            type:"post",
           url:"http://localhost:8080/empAccount/updAccount/"+i,
            data:{},
            dataType:"json",
            success:function (data) {
                if(data.code==0){
                     alert("提交成功")
                    location. href="http://localhost:8080/page/accountShowList";
                }else {
                     alert("提交失败,请联系管理员")
                }
            }
        });
    });

}
/*查看详情*/
function show(i) {
    location. href="http://localhost:8080/page/accountShows/"+i;

}
/*修改*/
function upd(i) {
    location. href="http://localhost:8080/page/updaccountShows/"+i;
}
