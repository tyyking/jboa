/**
 * Created by zcp on 2018/7/22.
 */
$(function () {
    /*总经理模块显示列表*/
    $.ajax({
        type:"get",
       url:"http://localhost:8080/generalList/ShowList",
        data:{},
        datatype:"json",
        success:function (data) {
            var da=data["data"];
            $("#datatbody").children("tr").remove();
            for(var i=0;i<da.length;i++){
                if (da[i].bstatus=="通过"){
                    $("#datatbody").append(" <tr>\n"+
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
                }else {
                    $("#datatbody").append(" <tr>\n"+
                        "<td>"+da[i].bid+"</td>\n"+
                        "<td>"+da[i].btime+"</td>\n"+
                        "<td>"+da[i].ename+"</td>\n"+
                        "<td>"+da[i].baccount+"</td>\n"+
                        "<td>"+da[i].bstatus+"</td>\n"+
                        "<td>"+da[i].nexSn+"</td>\n"+
                        "<td>"+da[i].btime+"</td>\n"+
                        "<td>\n"+
                        "<a onclick='show("+da[i].bid+")'><span class=\"glyphicon glyphicon-zoom-in\"></span></a>&nbsp;&nbsp;\n"+
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

      /*  if(startTime!=""&&endTime!=""){
            $.ajax({
                type:"get",
               url:"http://localhost:8080/generalList/ShowListByBstatusbyTime/"+bStatus+"/"+startTime+"/"+endTime,
                data:{},
                datatype:"json",
                success:function (data) {
                    var da=data["data"];
                    $("#datatbody").children("tr").remove();
                    for(var i=0;i<da.length;i++){
                        $("#datatbody").append(" <tr>\n"+
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
        }else {
            $.ajax({
                type:"get",
               url:"http://localhost:8080/generalList/ShowListByBstatus/"+bStatus,
                data:{},
                datatype:"json",
                success:function (data) {
                    var da=data["data"];
                    $("#datatbody").children("tr").remove();
                    for(var i=0;i<da.length;i++){
                        $("#datatbody").append(" <tr>\n"+
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

        if((bStatus==""||bStatus==null)&&(startTime==''||startTime==null)&&(endTime==null||endTime=='')){
            $.ajax({
                type:"get",
                url:"http://localhost:8080/generalList/ShowList",
                data:{},
                datatype:"json",
                success:function (data) {
                    var da=data["data"];
                    $("#datatbody").children("tr").remove();
                    for(var i=0;i<da.length;i++){
                        if (da[i].bstatus=="通过"){
                            $("#datatbody").append(" <tr>\n"+
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
                        }else {
                            $("#datatbody").append(" <tr>\n"+
                                "<td>"+da[i].bid+"</td>\n"+
                                "<td>"+da[i].btime+"</td>\n"+
                                "<td>"+da[i].ename+"</td>\n"+
                                "<td>"+da[i].baccount+"</td>\n"+
                                "<td>"+da[i].bstatus+"</td>\n"+
                                "<td>"+da[i].nexSn+"</td>\n"+
                                "<td>"+da[i].btime+"</td>\n"+
                                "<td>\n"+
                                "<a onclick='show("+da[i].bid+")'><span class=\"glyphicon glyphicon-zoom-in\"></span></a>&nbsp;&nbsp;\n"+
                                "</td>\n"+
                                "</tr>");
                        }
                    }
                }
            });
        }else if(((startTime==''||startTime==null)&&(endTime==null||endTime=='')&&(bStatus!=""||bStatus!=null))){
            $.ajax({
                type:"get",
                url:"http://localhost:8080/generalList/ShowListByBstatus/"+bStatus,
                data:{},
                datatype:"json",
                success:function (data) {
                    var da=data["data"];
                    $("#datatbody").children("tr").remove();
                    for(var i=0;i<da.length;i++){
                        if (da[i].bstatus=="通过"){
                            $("#datatbody").append(" <tr>\n"+
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
                        }else {
                            $("#datatbody").append(" <tr>\n"+
                                "<td>"+da[i].bid+"</td>\n"+
                                "<td>"+da[i].btime+"</td>\n"+
                                "<td>"+da[i].ename+"</td>\n"+
                                "<td>"+da[i].baccount+"</td>\n"+
                                "<td>"+da[i].bstatus+"</td>\n"+
                                "<td>"+da[i].nexSn+"</td>\n"+
                                "<td>"+da[i].btime+"</td>\n"+
                                "<td>\n"+
                                "<a onclick='show("+da[i].bid+")'><span class=\"glyphicon glyphicon-zoom-in\"></span></a>&nbsp;&nbsp;\n"+
                                "</td>\n"+
                                "</tr>");
                        }
                    }
                }
            });
        }else{
            if(bStatus==""||bStatus==null){
                bStatus=1;
            }
            $.ajax({
                type:"get",
                url:"http://localhost:8080/generalList/ShowListByBstatusbyTime/"+bStatus+"/"+startTime+"/"+endTime,
                data:{},
                datatype:"json",
                success:function (data) {
                    var da=data["data"];
                    $("#datatbody").children("tr").remove();
                    for(var i=0;i<da.length;i++){
                        if (da[i].bstatus=="通过"){
                            $("#datatbody").append(" <tr>\n"+
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
                        }else {
                            $("#datatbody").append(" <tr>\n"+
                                "<td>"+da[i].bid+"</td>\n"+
                                "<td>"+da[i].btime+"</td>\n"+
                                "<td>"+da[i].ename+"</td>\n"+
                                "<td>"+da[i].baccount+"</td>\n"+
                                "<td>"+da[i].bstatus+"</td>\n"+
                                "<td>"+da[i].nexSn+"</td>\n"+
                                "<td>"+da[i].btime+"</td>\n"+
                                "<td>\n"+
                                "<a onclick='show("+da[i].bid+")'><span class=\"glyphicon glyphicon-zoom-in\"></span></a>&nbsp;&nbsp;\n"+
                                "</td>\n"+
                                "</tr>");
                        }
                    }
                }
            });
        }
    });
});
function selectgenerApprove(i) {
    $(function () {
        location. href="http://localhost:8080/page/selectgenerApproves/"+i;
    });

}
function show(i) {
    location. href="http://localhost:8080/page/accountShows/"+i;

}