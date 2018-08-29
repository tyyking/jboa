/*查看请假单详情*/
$(function () {
    var lid = $("#lid").text();
    $.ajax({
        type: "get",
        url: "http://localhost:8080/departmentLeave/deFindLeveaShow/" + lid,
        data: {},
        datatype: "json",
        success: function (data) {
            var da = data["data"];
             (da.status)
            if(da.status=="新创建" || da.status=="已打回"|| da.status=="已拒绝"||da.status=="已终止" ||da.status=="打回"){
                $("#tab").append("<tr>\n" +
                    "<td style='display: none'>编号:" + da.id + "</td>\n" +
                    "<td>姓名:" + da.ename + "</td>\n" +
                    "<td>部门:" + da.deName + "\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td>开始时间:<input id='starttime' type='date' value='" + da.starttime + "'></td>\n" +
                    "<td>结束时间:<input id='endtime' type='date' value='" + da.endtime + "'></td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td>请假天数:<input id='leaveday' type='text' value='" + da.leaveday + "'></td>\n" +
                    "<td>休假类型:<input id='leavetype' type='text' value='" + da.leavetype + "'></td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td>请假事由:<input id='reason' type='text' value='" + da.reason + "'></td>\n" +
                    "<td>审批状态:" + da.status + "</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td colspan=\"2\">\n" +
                    "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                    "</td>\n" +
                    "</tr>"+
                    "<tr>\n" +
                    "<td>审批意见:</td>\n" +
                    "</tr>");
            }else{
                $("#tab").append("<tr>\n" +
                    "<td style='display: none'>编号:" + da.id + "</td>\n" +
                    "<td>姓名:" + da.ename + "</td>\n" +
                    "<td>部门:" + da.deName + "\n" +
                    "</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td>开始时间:" + da.starttime + "</td>\n" +
                    "<td>结束时间:" + da.endtime + "</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td>请假天数:" + da.leaveday + "</td>\n" +
                    "<td>休假类型:" + da.leavetype + "</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td>请假事由:" + da.reason + "</td>\n" +
                    "<td>审批状态:" + da.status + "</td>\n" +
                    "</tr>\n" +
                    "<tr>\n" +
                    "<td colspan=\"2\">\n" +
                    "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                    "</td>\n" +
                    "</tr>"+
                    "<tr>\n" +
                    "<td>审批意见:" + da.apperveOpinion + "</td>\n" +
                    "</tr>");
                if(da.status=="新创建" || da.status=="已打回"|| da.status=="已拒绝"||da.status=="已终止") {
                    $("#pass").css("display","block");
                    $("#update").css("display","block");
                }else {
                    $("#pass").css("display","none");
                    $("#update").css("display","none");

                }
            }

        }
    });
    /*修改*/
    $("#update").click(
        function () {
            var lid = $("#lid").text();
            var starttime = $("#starttime").val();
            var endtime = $("#endtime").val();
            var leaveday = $("#leaveday").val();
            var leavetype = $("#leavetype").val();
            var reason = $("#reason").val();
            $.ajax({
                type: "post",
                url: "http://localhost:8080/eLeave/empUpdLeaver/" + starttime+"/"+ endtime+"/"+ leaveday+"/"+ leavetype+"/"+ reason+"/"+ lid,
                data: {},
                datatype: "json",
                success: function (data) {
                    if(data.code==0){
                         ("修改成功");
                    }else{
                         ("修改失败,请联系管理员");
                    }
                }
            });
           window.location.href  ="http://localhost:8080/page/selectLeavers";
        }
    );
    /*返回*/
    $("#barck").click(
        function () {
            window.history.go(-1);
        }
    );
    /**
     * 打回
     */
   /* $("#dahui").click(function () {
        var lid = $("#lid").text();
        $.ajax({
            type: "get",
            url: " eLeave/updleaver/"+ lid+"/'打回'",
            data: {},
            datatype: "json",
            success: function (data) {
                if(data.code==0){
                     ("打回成功");
                }else{
                     ("修改失败,请联系管理员");
                }
            }
        });
    });*/
    /**
     * 通过
     */
    $("#pass").click(function () {
        var lid = $("#lid").text();
        $.ajax({
            type: "post",
            url: "http://localhost:8080/eLeave/updleaver/"+ lid,
            data: {},
            datatype: "json",
            success: function (data) {
                if(data.code==0){
                     ("正在审核中。。。。");
                    window.history.go(-1);
                }else{
                     ("修改失败,请联系管理员");
                }
            }
        });
    });
});