/*财务报销*/
$(function () {
    var i = $("#ids").text();
    $.ajax({
        type: "get",
        url: "http://localhost:8080/financeList/findExpenseById/" + i,
        data: {},
        datatype: "json",
        success: function (data) {
            var expense = (data["data"])["expenseById"];
            $("#chesn").text(expense.chesn);
            $("#tab").append(" <tr>\n" +
                "<td>编号:<span id='cid'>" + expense.bid + "</span></td>\n" +
                "<td>填写人:<span>" + expense.ename + "</span></td>\n" +
                "<td>部门:<span>" + expense.deName + "</span></td>\n" +
                "<td>职位:<span>" + expense.poName + "</span></td>\n" +
                "</tr>");
            $("#tab").append(" <tr>\n" +
                "<td>总金额:<span>" + expense.baccount + "</span></td>\n" +
                "<td>填报时间:<span>" + expense.btime + "</span></td>\n" +
                "<td>状态:<span>" + expense.bstatus + "</span></td>\n" +
                "<td>待处理人:<span>" + expense.nexSn + "</span></td>\n" +
                "</tr>" +
                "<tr>\n" +
                "<td colspan=\"4\">\n" +
                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                "</td>\n" +
                "</tr>");
            /*报销项*/
            var bizClaim = (data["data"])["bizClaimVoucherDetail"];
            for (var i = 0; i < bizClaim.length; i++) {
                $("#tab1").append(" <tr>\n" +
                    "<td>" + bizClaim[i].item + "</td>\n" +
                    "<td>" + bizClaim[i].account + "</td>\n" +
                    "<td>" + bizClaim[i].des + "</td>\n" +
                    "</tr>");
            }
            $("#tab1").append(
                "<td colspan=\"4\">\n" +
                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                "</td>\n" +
                "</tr>");
            var reslut=data["data"].reslut;
            for (var i=0;i<reslut.length;i++){
                $("#tab2").append(
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
            /*意见*/
           /* var comone = (data["data"])["commone"];
            var comtwo = (data["data"])["comm"];
            if (comtwo==null||comtwo==""){
                $("#tab2").append(
                    "<tr>\n"+
                    "<td>审批人:<span style='color: red'>"+comone.ename+"</span>(部门经理)</td>\n"+
                    "<td>审批时间:<span style='color:darkmagenta'>"+comone.createTime+"</span></td>\n"+
                    "<td>审批:"+comone.result+"</td>\n"+
                    "</tr>\n"+
                    "<tr>\n"+
                    "<td>审核意见:"+comone.comm+"</td>\n"+
                    "</tr>\n"+
                    "<tr>\n"+
                    "<td colspan=\"4\">\n"
                )
            }else {
            $("#tab2").append(
                "<tr>\n"+
                "<td>审批人:<span style='color: red'>"+comone.ename+"</span>(部门经理)</td>\n"+
                "<td>审批时间:<span style='color:darkmagenta'>"+comone.createTime+"</span></td>\n"+
                "<td>审批:"+comone.result+"</td>\n"+
                "</tr>\n"+
                "<tr>\n"+
                "<td>审核意见:"+comone.comm+"</td>\n"+
                "</tr>\n"+
                "<tr>\n"+
                "<td colspan=\"4\">\n"+
                " ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"+
                " </td>\n"+
                "</tr>\n"+
                "<tr>\n"+
                "<td>审批人:<span style='color: red'>"+comtwo.ename+"</span>(总经理)</td>\n"+
                "<td>审批时间:<span style='color:darkmagenta'>"+comtwo.createTime+"</span></td>\n"+
                "<td>审批:"+comtwo.result+"</td>\n"+
                "</tr>\n"+
                "<tr>\n"+
                "<td>审核意见:"+comtwo.comm+"</td>\n"+
                "</tr>\n"+
                "<tr>\n"+
                "<td colspan=\"4\">\n"+
                " ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"+
                " </td>\n"+
                "</tr>"
            )}*/
        }

    });
    /*审批报销单通过*/
    $("#pass").click(function () {
        var comm=$("textarea").val();
        var id=$("#cid").text();
        if (comm=''||comm==null){
             ("请填写意见")
        }
        $.ajax({
            type:"post",
           url:"http://localhost:8080/financeList/updatebizvo/"+id+"/通过/"+comm+"/已付款",
            data:{},
            dataType:"json",
            success:function (data) {
                if(data.code==1){
                     alert("审批通过");
                    location.href="http://localhost:8080/page/pageshow";
                }else {
                     alert("审批失败!请联系管理员")
                    location.href="http://localhost:8080/page/pageshow";
                }
            }
        });
    });
    /*审批报销单返回*/
    $("#barck").click(function () {
        location.href="http://localhost:8080/page/pageshow";
    });
});


