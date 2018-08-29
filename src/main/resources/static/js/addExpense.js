/*当点击时文件夹打开*/
$(function () {
    /*添加报销单项*/
    $("#addplus").click(
        function () {
            $("#firsttr").after("<tr class=\"error\">\n" +
                "<td>\n" +
                "<select name='item'>\n" +
                "<option>城市交通费</option>\n" +
                "<option>礼品费</option>\n" +
                "<option>交际餐费</option>\n" +
                "<option>办公费</option>\n" +
                "<option>住宿</option>\n" +
                "<option>交通</option>\n" +
                "</select>\n" +
                "</td>\n" +
                "<td>\n" +
                "<input  type=\"text\" name='money' onblur='add(this)'>*\n" +
                "</td>\n" +
                "<td>\n" +
                "<input  type=\"text\" name='des'>*\n" +
                "</td>\n" +
                "<td><a onclick='del(this)'><span  class=\"glyphicon glyphicon-minus\"></span></a></td>\n" +
                "                                                </tr>");

        }
    );
    /*添加报销单表*/
    $("#add").click(function () {
        var account = $("#account").val();
        var status = $("#status").val();
        var EVENT = $("#EVENT").val();
        var name=$("#name").html();
        $.ajax({
            type: "post",
            url: "http://localhost:8080/empAccount/addExpent/" + EVENT + "/" + account + "/" + status+"/"+name,
            data: {},
            dataType: "json",
            success: function (data) {
                alert("添加成功")
                var a=$("[name=item]").length;
                var item=$("[name=item]");
                var account=$("[name=money]");
                var des=$("[name=des]");
                for (var i = 0; i <a; i++) {
                    var itemVal=item.get(i).value;
                    var accountVal=account.get(i).value;
                    var desVal=des.get(i).value;
                    $.ajax({
                        type: "post",
                        url: "http://localhost:8080/empAccount/addExpentItem/" + itemVal + "/" + accountVal + "/" + desVal,
                        data: {},
                        dataType: "json",
                        success: function (data) {
                            location. href="http://localhost:8080/page/accountShowList";
                        }
                    });
                }
            }
        });



    });



});
function add() {
    var account=0;
    var a=document.getElementsByName("money");
    for(var i=0;i<a.length;i++){
        account=(account-1+1)+(a[i].value-1+1);
    }
    document.getElementById("account").value=account;
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
    document.getElementById("account").value=account;
}