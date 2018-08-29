/*查看请假单详情*/
$(function () {
    var lid = $("#lid").text();
    $.ajax({
        type: "get",
        url: "http://localhost:8080/eLeave/empShowLeaver/"+lid,
        data: {},
        datatype: "json",
        success: function (data) {
            var da = data["data"];

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
                " <td>审批意见:"+da.apperveOpinion+"</td>\n"+
                "</tr>");

        }
    });
    $("#tguo").click(
        function () {
            var dahui = $("textarea").val();
            var lid = $("#lid").text();
            if (dahui=''||dahui==null){
                 ("请填写意见")
            }
            $.ajax({
                type: "post",
                url: "http://localhost:8080/departmentLeave/updateLevea/" + lid+"/通过/"+dahui,
                data: {},
                datatype: "json",
                success: function (data) {
                    if(data.code==0){
                         ("审批通过");
                        window.history.go(-1);
                    }else{
                         ("打回失败,请联系管理员");
                        window.history.go(-1);
                    }
                }
            });
        }
    );
    /*修改*/
    $("#dahui").click(
        function () {
            var dahui = $("textarea").val();
            var lid = $("#lid").text();
            if (dahui=''||dahui==null){
                 ("请填写意见")
            }
            var a='打回';
            $.ajax({
                type: "post",
                url: "http://localhost:8080/departmentLeave/updateLevea/" + lid+"/"+a+"/"+dahui,
                data: {},
                datatype: "json",
                success: function (data) {
                    if(data.code==0){
                         alert("审批打回");
                        location.href="http://localhost:8080/page/seleDeLeavess";
                    }else{
                         alert("打回失败,请联系管理员");
                        location.href="http://localhost:8080/page/seleDeLeavess";
                    }
                }
            });
        }
    );
    /*返回*/
    $("#barck").click(
        function () {
            window.history.go(-1);
        }
    );
});