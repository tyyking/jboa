/*部门经理请假*/
$(function () {
    /*显示请假单*/
    $.ajax({
        type: "get",
        url: "http://localhost:8080/eLeave/findBySn",
        data: {},
        datatype: "json",
        success: function (data) {
            var da = data["data"];
            for (var i = 0; i < da.length; i++) {
                if (da[i].status=="待审批"||da[i].status=="已打回" || da[i].status=="已拒绝"||da[i].status=="已终止"){
                    $("#tab").append(" <tr>\n" +
                        "<td>" + da[i].id + "</td>\n" +
                        "<td>" + da[i].ename + "请假" + da[i].leaveday + "天</td>\n" +
                        "<td>" + da[i].createTime + "</td>\n" +
                        "<td>" + da[i].modifytime + "</td>\n" +
                        "<td>" + da[i].approveOpinion + "</td>\n" +
                        "<td>" + da[i].status + "</td>\n" +
                        "<td>\n" +
                        "<span onclick='selectLeaver(" + da[i].id + ")' class=\"glyphicon glyphicon-zoom-in\"></span>&nbsp;&nbsp;\n" +
                        "</td>\n" +
                        "</tr>");
                }else {
                    $("#tab").append(" <tr>\n" +
                        "<td>" + da[i].id + "</td>\n" +
                        "<td>" + da[i].ename + "请假" + da[i].leaveday + "天</td>\n" +
                        "<td>" + da[i].createTime + "</td>\n" +
                        "<td>" + da[i].modifytime + "</td>\n" +
                        "<td>" + da[i].approveOpinion + "</td>\n" +
                        "<td>" + da[i].status + "</td>\n" +
                        "<td>\n" +
                        "<span onclick='selectLeaver(" + da[i].id + ")' class=\"glyphicon glyphicon-zoom-in\"></span>&nbsp;&nbsp;\n" +
                        "<span onclick='del(" + da[i].id + ")' class=\"glyphicon glyphicon-remove\"></span>&nbsp;&nbsp;\n" +
                        "</td>\n" +
                        "</tr>");
                }

            }
        }
    });
    /*按状态和时间进行查询*/
    $("#selec").click(function () {
        var createTime = $("#test04").val();
        var endTime = $("#enYMDhms").val();

        if ((createTime!=null||createTime!="")||(endTime!=null||endTime!="")){
            $.ajax({
                type: "get",
                url: "http://localhost:8080/eLeave/deFindLeveaBytime/" + createTime+"/"+endTime ,
                data: {},
                datatype: "json",
                success: function (data) {
                    var da = data["data"];
                    $("#tab").children("tr").remove();
                    for (var i = 0; i < da.length; i++) {
                        if (da[i].status=="待审批"||da[i].status=="已打回" || da[i].status=="已拒绝"||da[i].status=="已终止"){
                            $("#tab").append(" <tr>\n" +
                                "<td>" + da[i].id + "</td>\n" +
                                "<td>" + da[i].ename + "请假" + da[i].leaveday + "天</td>\n" +
                                "<td>" + da[i].createTime + "</td>\n" +
                                "<td>" + da[i].modifytime + "</td>\n" +
                                "<td>" + da[i].approveOpinion + "</td>\n" +
                                "<td>" + da[i].status + "</td>\n" +
                                "<td>\n" +
                                "<span onclick='selectLeaver(" + da[i].id + ")' class=\"glyphicon glyphicon-zoom-in\"></span>&nbsp;&nbsp;\n" +
                                "</td>\n" +
                                "</tr>");
                        }else {
                            $("#tab").append(" <tr>\n" +
                                "<td>" + da[i].id + "</td>\n" +
                                "<td>" + da[i].ename + "请假" + da[i].leaveday + "天</td>\n" +
                                "<td>" + da[i].createTime + "</td>\n" +
                                "<td>" + da[i].modifytime + "</td>\n" +
                                "<td>" + da[i].approveOpinion + "</td>\n" +
                                "<td>" + da[i].status + "</td>\n" +
                                "<td>\n" +
                                "<span onclick='selectLeaver(" + da[i].id + ")' class=\"glyphicon glyphicon-zoom-in\"></span>&nbsp;&nbsp;\n" +
                                "<span onclick='del(" + da[i].id + ")' class=\"glyphicon glyphicon-remove\"></span>&nbsp;&nbsp;\n" +
                                "</td>\n" +
                                "</tr>");
                        }
                    }
                }
            });
        }else {
            $.ajax({
                type: "get",
                url: "http://localhost:8080/eLeave/findBySn",
                data: {},
                datatype: "json",
                success: function (data) {
                    var da = data["data"];
                    for (var i = 0; i < da.length; i++) {
                        if (da[i].status=="待审批"||da[i].status=="已打回" || da[i].status=="已拒绝"||da[i].status=="已终止"){
                            $("#tab").append(" <tr>\n" +
                                "<td>" + da[i].id + "</td>\n" +
                                "<td>" + da[i].ename + "请假" + da[i].leaveday + "天</td>\n" +
                                "<td>" + da[i].createTime + "</td>\n" +
                                "<td>" + da[i].modifytime + "</td>\n" +
                                "<td>" + da[i].approveOpinion + "</td>\n" +
                                "<td>" + da[i].status + "</td>\n" +
                                "<td>\n" +
                                "<span onclick='selectLeaver(" + da[i].id + ")' class=\"glyphicon glyphicon-zoom-in\"></span>&nbsp;&nbsp;\n" +
                                "</td>\n" +
                                "</tr>");
                        }else {
                            $("#tab").append(" <tr>\n" +
                                "<td>" + da[i].id + "</td>\n" +
                                "<td>" + da[i].ename + "请假" + da[i].leaveday + "天</td>\n" +
                                "<td>" + da[i].createTime + "</td>\n" +
                                "<td>" + da[i].modifytime + "</td>\n" +
                                "<td>" + da[i].approveOpinion + "</td>\n" +
                                "<td>" + da[i].status + "</td>\n" +
                                "<td>\n" +
                                "<span onclick='selectLeaver(" + da[i].id + ")' class=\"glyphicon glyphicon-zoom-in\"></span>&nbsp;&nbsp;\n" +
                                "<span onclick='del(" + da[i].id + ")' class=\"glyphicon glyphicon-remove\"></span>&nbsp;&nbsp;\n" +
                                "</td>\n" +
                                "</tr>");
                        }
                    }
                }
            });
        }}
    );

    /*删除请假单*/
});
/**
 * 删除
 * @param i
 */
function del(i) {
  $(function () {
      $.ajax({
          type: "post",
          url: "http://localhost:8080/eLeave/empdelLeaver/"+i,
          data: {},
          datatype: "json",
          success: function (data) {
              if (data.code == 0) {
                   ("删除成功");
                  location. href="http://localhost:8080/page/selectLeavers";
              } else {
                   ("审批失败,请联系管理员");
              }
          }
      });
  });

}
/*查看详情*/
function selectLeaver(i) {
    $(function () {
        location.href = "http://localhost:8080/page/leaveShows/" + i;
    });

}