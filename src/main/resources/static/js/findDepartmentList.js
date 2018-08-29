/*部门经理*/
$(function () {
    /*总经理模块显示列表*/
    $.ajax({
        type:"get",
       url:"http://localhost:8080/departmentvoucher/deparShowVoucher",
        data:{},
        datatype:"json",
        success:function (data) {
            var da=data["data"];
            $("#tbo").children("tr").remove();
            if (data["code"]==5){
                $("#renshi").css("display","block");
            }
            for(var i=0;i<da.length;i++){
                if (da[i].bstatus!="已提交"){
                    $("#tbo").append(" <tr>\n"+
                        "<td>"+da[i].bid+"</td>\n"+
                        "<td>"+da[i].btime+"</td>\n"+
                        "<td>"+da[i].ename+"</td>\n"+
                        "<td>"+da[i].baccount+"</td>\n"+
                        "<td>"+da[i].bstatus+"</td>\n"+
                        "<td>"+da[i].nexSn+"</td>\n"+
                        "<td>\n"+
                        "<a onclick='show("+da[i].bid+")'><span class=\"glyphicon glyphicon-zoom-in\"></span></a>&nbsp;&nbsp;\n"+
                        "</tr>");
                }else {
                    $("#tbo").append(" <tr>\n"+
                        "<td>"+da[i].bid+"</td>\n"+
                        "<td>"+da[i].btime+"</td>\n"+
                        "<td>"+da[i].ename+"</td>\n"+
                        "<td>"+da[i].baccount+"</td>\n"+
                        "<td>"+da[i].bstatus+"</td>\n"+
                        "<td>"+da[i].nexSn+"</td>\n"+
                        "<td>\n"+
                        "<span onclick='selectgenerApprove("+da[i].bid+")' class=\"glyphicon glyphicon-ok\"></span>&nbsp;&nbsp;\n"+
                        "</td>\n"+
                        "</tr>");
                }

            }
        }
    });
    /*a按状态查询*/
    $("#submi").click(function () {
        /*状态*/
        var bStatus=$("#status>option:selected").val();
        /*开始时间*/
        var startTime=$("#test04").val();
        /*开始时间*/
        var endTime=$("#enYMDhms").val();


        if((bStatus==""||bStatus==null)&&(startTime==''||startTime==null)&&(endTime==null||endTime=='')){
            $.ajax({
                type:"get",
                url:"http://localhost:8080/departmentvoucher/deparShowVoucher",
                data:{},
                datatype:"json",
                success:function (data) {
                    var da=data["data"];
                    if (data["code"]==5){
                        $("#renshi").css("display","block");
                    }
                    $("#tbo").children("tr").remove();
                    for(var i=0;i<da.length;i++){
                        if (da[i].bstatus!="已提交"){
                            $("#tbo").append(" <tr>\n"+
                                "<td>"+da[i].bid+"</td>\n"+
                                "<td>"+da[i].btime+"</td>\n"+
                                "<td>"+da[i].ename+"</td>\n"+
                                "<td>"+da[i].baccount+"</td>\n"+
                                "<td>"+da[i].bstatus+"</td>\n"+
                                "<td>"+da[i].nexSn+"</td>\n"+
                                "<td>\n"+
                                "<a onclick='show("+da[i].bid+")'><span class=\"glyphicon glyphicon-zoom-in\"></span></a>&nbsp;&nbsp;\n"+
                                "</tr>");
                        }else {
                            $("#tbo").append(" <tr>\n"+
                                "<td>"+da[i].bid+"</td>\n"+
                                "<td>"+da[i].btime+"</td>\n"+
                                "<td>"+da[i].ename+"</td>\n"+
                                "<td>"+da[i].baccount+"</td>\n"+
                                "<td>"+da[i].bstatus+"</td>\n"+
                                "<td>"+da[i].nexSn+"</td>\n"+
                                "<td>\n"+
                                "<span onclick='selectgenerApprove("+da[i].bid+")' class=\"glyphicon glyphicon-ok\"></span>&nbsp;&nbsp;\n"+
                                "</td>\n"+
                                "</tr>");
                        }

                    }
                }
            });
        }else if(((startTime==''||startTime==null)&&(endTime==null||endTime=='')&&(bStatus!=""||bStatus!=null))){
            $.ajax({
                type:"get",
                url:"http://localhost:8080/departmentvoucher/deparShowVoucherByStatus/"+bStatus,
                data:{},
                datatype:"json",
                success:function (data) {
                    var da=data["data"];
                    if (data["code"]==5){
                        $("#renshi").css("display","block");
                    }
                    $("#tbo").children("tr").remove();
                    for(var i=0;i<da.length;i++){
                        if (da[i].bstatus!="已提交"){
                            $("#tbo").append(" <tr>\n"+
                                "<td>"+da[i].bid+"</td>\n"+
                                "<td>"+da[i].btime+"</td>\n"+
                                "<td>"+da[i].ename+"</td>\n"+
                                "<td>"+da[i].baccount+"</td>\n"+
                                "<td>"+da[i].bstatus+"</td>\n"+
                                "<td>"+da[i].nexSn+"</td>\n"+
                                "<td>\n"+
                                "<a onclick='show("+da[i].bid+")'><span class=\"glyphicon glyphicon-zoom-in\"></span></a>&nbsp;&nbsp;\n"+
                                "</tr>");
                        }else {
                            $("#tbo").append(" <tr>\n"+
                                "<td>"+da[i].bid+"</td>\n"+
                                "<td>"+da[i].btime+"</td>\n"+
                                "<td>"+da[i].ename+"</td>\n"+
                                "<td>"+da[i].baccount+"</td>\n"+
                                "<td>"+da[i].bstatus+"</td>\n"+
                                "<td>"+da[i].nexSn+"</td>\n"+
                                "<td>\n"+
                                "<span onclick='selectgenerApprove("+da[i].bid+")' class=\"glyphicon glyphicon-ok\"></span>&nbsp;&nbsp;\n"+
                                "</td>\n"+
                                "</tr>");
                        }

                    }
                }
            });
        }else{
            $(function () {
                /*默认查询报销单,列表*/
                if(bStatus==""||bStatus==null){
                    bStatus=1;
                }
                $.ajax({
                    type:"get",
                    url:"http://localhost:8080/departmentvoucher/deparShowVoucherByTime/"+bStatus+"/"+startTime+"/"+endTime,
                    data:{},
                    datatype:"json",
                    success:function (data) {
                        if (data["code"]==5){
                            $("#renshi").css("display","block");
                        }
                        var da=data["data"];
                        $("#tbo").children("tr").remove();
                        for(var i=0;i<da.length;i++){
                            if (da[i].bstatus!="已提交"){
                                $("#tbo").append(" <tr>\n"+
                                    "<td>"+da[i].bid+"</td>\n"+
                                    "<td>"+da[i].btime+"</td>\n"+
                                    "<td>"+da[i].ename+"</td>\n"+
                                    "<td>"+da[i].baccount+"</td>\n"+
                                    "<td>"+da[i].bstatus+"</td>\n"+
                                    "<td>"+da[i].nexSn+"</td>\n"+
                                    "<td>\n"+
                                    "<a onclick='show("+da[i].bid+")'><span class=\"glyphicon glyphicon-zoom-in\"></span></a>&nbsp;&nbsp;\n"+
                                    "</tr>");
                            }else {
                                $("#tbo").append(" <tr>\n"+
                                    "<td>"+da[i].bid+"</td>\n"+
                                    "<td>"+da[i].btime+"</td>\n"+
                                    "<td>"+da[i].ename+"</td>\n"+
                                    "<td>"+da[i].baccount+"</td>\n"+
                                    "<td>"+da[i].bstatus+"</td>\n"+
                                    "<td>"+da[i].nexSn+"</td>\n"+
                                    "<td>\n"+
                                    "<span onclick='selectgenerApprove("+da[i].bid+")' class=\"glyphicon glyphicon-ok\"></span>&nbsp;&nbsp;\n"+
                                    "</td>\n"+
                                    "</tr>");
                            }

                        }
                    }
                });
            });
        }
      /*  if(startTime!=""&&endTime!=""){
            $.ajax({
                type:"get",
               url:"http://localhost:8080/departmentvoucher/deparShowVoucherByTime/"+bStatus+"/"+startTime+"/"+endTime,
                data:{},
                datatype:"json",
                success:function (data) {
                    var da=data["data"];
                    $("#tob").children("tr").remove();
                    for(var i=0;i<da.length;i++){
                        $("#tbo").append(" <tr>\n"+
                            "<td>"+da[i].bid+"</td>\n"+
                            "<td>"+da[i].btime+"</td>\n"+
                            "<td>"+da[i].ename+"</td>\n"+
                            "<td>"+da[i].baccount+"</td>\n"+
                            "<td>"+da[i].bstatus+"</td>\n"+
                            "<td>"+da[i].nexSn+"</td>\n"+
                            "<td>\n"+
                            "<span onclick='selectgenerApprove("+da[i].bid+")' class=\"glyphicon glyphicon-ok\"></span>&nbsp;&nbsp;\n"+
                            "</td>\n"+
                            "</tr>");
                    }
                }
            });
        }else {
            $.ajax({
                type:"get",
               url:"http://localhost:8080/departmentvoucher/deparShowVoucherByStatus/"+bStatus,
                data:{},
                datatype:"json",
                success:function (data) {
                    var da=data["data"];
                    $("#tob").children("tr").remove();
                    for(var i=0;i<da.length;i++){
                        $("#tbo").append(" <tr>\n"+
                            "<td>"+da[i].bid+"</td>\n"+
                            "<td>"+da[i].btime+"</td>\n"+
                            "<td>"+da[i].ename+"</td>\n"+
                            "<td>"+da[i].baccount+"</td>\n"+
                            "<td>"+da[i].bstatus+"</td>\n"+
                            "<td>"+da[i].nexSn+"</td>\n"+
                            "<td>"+da[i].btime+"</td>\n"+
                            "<td>\n"+
                            "<span onclick='selectgenerApprove("+da[i].bid+")' class=\"glyphicon glyphicon-ok\"></span>&nbsp;&nbsp;\n"+
                            "</td>\n"+
                            "</tr>");
                    }
                }
            });
        }*/

    });
});
function selectgenerApprove(i) {
    $(function () {
        location. href="http://localhost:8080/page/seleDevouch/"+i;
    });

}
function show(i) {
    location. href="http://localhost:8080/page/accountShows/"+i;

}