$(function () {
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
                    "<td >编号:<span id='bid'>"+da.bid+"</span></td>\n"+
                    "<td>填写人:"+da.ename+"</td>\n"+
                    "<td>部门:"+data["data"].dName+"</td>\n"+
                    "<td>职位:"+data["data"].pName+"</td>\n"+
                    "</tr>\n"+
                    "<tr>\n"+
                    "<td>总金额:<span id='account'>"+da.baccount+"</span></td>\n"+
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
                        "<td style='display: none'>"+das[i].id+"</td>\n"+
                        "<td><input type=\"text\"  disabled='disabled'  value='"+das[i].item+"'></td>"+
                        "<td><input type=\"text\"  disabled='disabled' onblur='add()' name='money'  value='"+das[i].account+"'></td>"+
                        "<td><input type=\"text\"  disabled='disabled'value='"+das[i].des+"'></td>"+
                        "<td><a onclick='delselect(this)'><span  class='glyphicon glyphicon-remove'></span></a></td>\n"+
                        "</tr>");
                }
                $("#tab").append("<tr>\n"+
                    "<td colspan=\"4\">\n"+
                    "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"+
                    "</td>\n"+
                    "</tr>\n"+
                    "<tr>\n"+
                    "</tr>");
            }
        });

        /*添加报销单项*/
        $("#addplus").click(
            function () {
                $("#item").append("<tr>\n" +
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
                    "<input type=\"text\" onblur='add()' name='money'>*\n" +
                    "</td>\n" +
                    "<td>\n" +
                    "<input type=\"text\">*\n" +
                    "</td>\n" +
                    "<td><a onclick='del(this)'><span  class=\"glyphicon glyphicon-minus\"></span></a></td>\n" +
                    "</tr>");

            }
        );
    });
    /*添加报销单表*/
    $("#add").click(function () {
        var id=$("#lid").text();
        var childs = $("#item").find("tr");
        var leng = childs.length;
        var  sid=$("#bid").text();
        var event=$("#textarea").val();
        $.ajax({
            type: "post",
            url: "http://localhost:8080/empAccount/updateVoucher/"+$("#account").html()+"/"+id,
            data: {},
            dataType: "json",
            success: function (data) {

            }
        });
        for (var i=0; i < leng; i++) {
            var item = $("#item>tr:eq("+i+")>td:eq(0)>select>option:selected").val();
            var account = $("#item>tr:eq("+i+")>td:eq(1)>input").val();
            var des = $("#item>tr:eq("+i+")>td:eq(2)>input").val();
            $.ajax({
                type: "post",
                url: "http://localhost:8080/empAccount/updExpentItem/"+item+"/"+account+"/"+des+"/"+event+"/"+sid,
                data: {},
                dataType: "json",
                success: function (data) {

                }
            });
        }
        location.href = "http://localhost:8080/page/accountShowList";
    });
});
function add() {
    var account=0;
    var a=document.getElementsByName("money");
    for(var i=0;i<a.length;i++){
        account=(account-1+1)+(a[i].value-1+1);
    }
    document.getElementById("account").innerHTML=account;
    /*
     account+=i.value-1;
     */
    /*var money=$(".money")
     for(){

     }
     var account=*/
}
/*删除项*/
function del(i) {
    $(function () {
        $(i).parent("td").parent("tr").remove();

    });
    var account=0;
    var a=document.getElementsByName("money");
    for(var i=0;i<a.length;i++){
        account=(account-1+1)+(a[i].value-1+1);
    }
    document.getElementById("account").innerHTML=account;
}
/*删除查询出来的数据*/
function delselect(i) {
    $(function () {
        $(i).parent("td").parent("tr").remove();
        var id=$(i).parent("td").prev("td").prev("td").prev("td").prev("td").text();
         $.ajax({
            type: "post",
            url: "http://localhost:8080/empAccount/delItem/"+id,
            data: {},
            dataType: "json",
            success: function (data) {
                if(data.code==0){
                     ("删除成功")
                }
            }
        });
    });
    var account=0;
    var a=document.getElementsByName("money");
    for(var i=0;i<a.length;i++){
        account=(account-1+1)+(a[i].value-1+1);
    }
    document.getElementById("account").innerHTML=account;
}
function breaks() {
    window.history.go(-1);
}