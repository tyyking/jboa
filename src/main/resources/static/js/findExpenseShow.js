/**
 * Created by zcp on 2018/7/29.
 */
$(function () {
    var id=$("#lid").text();
    $.ajax({
        type:"get",
       url:"http://localhost:8080/empAccount/findAllExpenseShow/"+id,
        data:{},
        dataType: "json",
        success: function (data) {
            var das=data["data"].expenseItem;
            var da=data["data"].findAllExpenseDto;
            $("#tabs").append("<tr>\n"+
                "<td>编号:"+da.bid+"</td>\n"+
                "<td>填写人:"+da.ename+"</td>\n"+
                "<td>部门:"+data["data"].dName+"</td>\n"+
                "<td>职位:"+data["data"].pName+"</td>\n"+
                "</tr>\n"+
                "<tr>\n"+
                "<td>总金额:"+da.baccount+"</td>\n"+
                "<td>填报时间:"+da.btime+"</td>\n"+
                "<td>状态:"+da.bstatus+"</td>\n"+
                "<td>待处理人:"+da.nexSn+"</td>\n"+
                "</tr>\n"+
                "<tr>\n"+
                "<td colspan=\"4\">\n"+
                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"+
                "</td>\n"+
                "</tr>");
            var reslut=data["data"].reslut;
            for (var i=0;i<reslut.length;i++){
                $("#tab").append(
                    "<tr>\n"+
                    "<td>审批人:<span style='color: red'>"+reslut[i].name+"</span>("+reslut[i].nameCn+")</td>\n"+
                    "<td>审批时间:<span style='color:darkmagenta'>"+reslut[i].createTime+"</span></td>\n"+
                    "<td>审批:"+reslut[i].result+"</td>\n"+
                    "</tr>\n"+
                    "<tr>\n"+
                    "<td>审核意见:"+reslut[i].comm+"</td>\n"+
                    "</tr>\n"+
                    "<tr>\n"+
                    "<td colspan=\"4\">\n"
                )
            }
            $("#tab1").append("<tr><td>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- </td></tr>")

            for(var i=0;i<das.length;i++){
                $("#tab").append("<tr>\n"+
                    "<td>"+das[i].item+"</td>\n"+
                    "<td>"+das[i].account+"</td>\n"+
                    "<td>"+das[i].des+"</td>\n"+
                    "</tr>");
            }
            $("#tab").append("<tr>\n"+
                "<td colspan=\"4\">\n"+
                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"+
                "</td>\n"+
                "</tr>\n"+
                "<tr>\n"+
                "<td><button onclick='breaks()' class=\"btn btn-primary btn-small\" type=\"button\">返回</button></td>\n"+
                "</tr>");
        }
    });

});
function breaks() {
    window.history.go(-1);
}