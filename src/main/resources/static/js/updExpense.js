/*当点击时文件夹打开*/
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
            for(var i=0;i<das.length;i++){
                $("#tab").append("<tr>\n"+
                    "<td>"+das[i].item+"</td>\n"+
                    "<td>"+das[i].account+"</td>\n"+
                    "<td>"+das[i].des+"</td>\n"+
                    "<td><a onclick='delselect(this)'><span  class='glyphicon glyphicon-remove'></span></a></td>\n"+
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

    /*添加报销单项*/
    $("#addplus").click(
        function () {
            $("#firsttr").after("<tr class=\"error\">\n" +
                "<td>\n" +
                "<select>\n" +
                "<option>城市交通费</option>\n" +
                "<option>礼品费</option>\n" +
                "<option>交际餐费</option>\n" +
                "<option>办公费</option>\n" +
                "<option>住宿</option>\n" +
                "<option>交通</option>\n" +
                "</select>\n" +
                "</td>\n" +
                "<td>\n" +
                "<input type=\"text\">*\n" +
                "</td>\n" +
                "<td>\n" +
                "<input type=\"text\">*\n" +
                "</td>\n" +
                "<td><a onclick='del(this)'><span  class=\"glyphicon glyphicon-minus\"></span></a></td>\n" +
            "</tr>");

        }
    );
});
/*删除项*/
function del(i) {
    $(function () {
        $(i).parent("td").parent("tr").remove();
    });
}
/*删除查询出来的数据*/
function delselect(i) {
    $(function () {
        $(i).parent("td").parent("tr").remove();
    });
}
function breaks() {
    window.history.go(-1);
}