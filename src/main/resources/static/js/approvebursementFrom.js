$(function () {
    var i = $("#ids").text();
    $.ajax({
        type: "get",
        url: "http://localhost:8080/departmentvoucher/deparShowbouche/"+i,
        data: {},
        datatype: "json",
        success: function (data) {
            var expense = (data["data"])["expenseById"];
            $("#tab").append(" <tr>\n" +
                "<td>编号:<span>" + expense.bid + "</span></td>\n" +
                "<td>填写人:<span>" + expense.ename + "</span></td>\n" +
                "<td>部门:<span>" + expense.deName + "</span></td>\n" +
                "<td>职位:<span>" + expense.poName + "</span></td>\n" +
                "</tr>");
            $("#tab").append(" <tr>\n" +
                "<td>总金额:<span id='zong'>" + expense.baccount + "</span></td>\n" +
                "<td>填报时间:<span>" + expense.btime + "</span></td>\n" +
                "<td>状态:<span>" + expense.bstatus + "</span></td>\n" +
                "<td>待处理人:<span>" + expense.nexSn + "</span></td>\n" +
                "</tr>" +
                "<tr>\n" +
                "<td colspan=\"4\">\n" +
                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                "</td>\n" +
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
            /*报销项*/
            var bizClaim = (data["data"])["bizClaimVoucherDetail"];
            for (var i = 0; i < bizClaim.length; i++) {
                $("#tab1").append(" <tr>\n" +
                    "<td>" + bizClaim[i].item + "</td>\n" +
                    "<td>" + bizClaim[i].account + "</td>\n" +
                    "<td>" + bizClaim[i].des + "</td>\n" +
                    "</tr>" +
                    "<tr>\n"+
                    "<td colspan=\"4\">\n"+
                    "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"+
                    "</td>\n"+
                    "</tr>");
            }
            /*审批编号*/
            $("#chesn").text(expense.chesn);
        }

    });
    /*审批通过*/
    $("#passs").click(function () {
       var comm=$("textarea").val();
        var i = $("#ids").text();
        var zong=$("#zong").html();
        if (comm=''||comm==null){
             ("请填写通过意见")
        }
        if (zong>=5000){
            var b='通过';
        }else {
            var b='待付款';
        }
        var a='通过';
        $.ajax({
            type:"post",
           url:"http://localhost:8080/departmentvoucher/updatebizvo/"+i+"/"+a+"/"+comm+"/"+b+"",
            data:{},
            dataType:"json",
            success:function (data) {
                if(data.code==0){
                    location.href="http://localhost:8080/page/seleDevouchers";
                }else {
                    alert("审批通过");
                    location.href="http://localhost:8080/page/seleDevouchers";
                }
            }
        });
    });
    /*审批拒绝*/
    $("#refuses").click(function () {
        var comm=$("textarea").val();
        var i = $("#ids").text();
        if (comm=''||comm==null){
             alert("请填写拒绝意见")
        }
        $.ajax({
            type:"post",
           url:"http://localhost:8080/departmentvoucher/updatebizvo/"+i+"/拒绝/"+comm+"/已拒绝",
            data:{},
            dataType:"json",
            success:function (data) {
                if(data.code==0){
                     alert("审批拒绝");
                    location.href="http://localhost:8080/page/seleDevouchers";
                }else {
                     alert("审批失败!请联系管理员")
                    location.href="http://localhost:8080/page/seleDevouchers";
                }
            }
        });
    });
    /*审批打回*/
    $("#beatback").click(function () {
        var comm=$("textarea").val();
        if (comm=''||comm==null){
             alert("请填写意见")
        }
        var i = $("#ids").text();
        $.ajax({
            type:"post",
           url:"http://localhost:8080/departmentvoucher/updatebizvo/"+i+"/打回/"+comm+"/已打回",
            data:{},
            dataType:"json",
            success:function (data) {
                if(data.code==0){
                     alert("审批打回");
                    location.href="http://localhost:8080/page/seleDevouchers";
                }else {
                     alert("审批失败!请联系管理员")
                    location.href="http://localhost:8080/page/seleDevouchers";
                }
            }
        });
    });
    /*审批返回*/
    $("#barck").click(function () {
        window.history.go(-1);
    });
});