/*部门经理请假*/
$(function () {
   /*显示请假单*/
   $.ajax({
       type:"get",
      url:"http://localhost:8080/departmentLeave/findBySn",
       data:{},
       datatype:"json",
       success:function (data) {
           var da=data["data"];
           $("#tab").children("tr").remove();
         for(var i=0;i<da.length;i++){
             if (da[i].status=="待审批"){
                 $("#tab").append(" <tr>\n"+
                     "<td>"+da[i].id+"</td>\n"+
                     "<td>"+da[i].ename+"请假"+da[i].leaveday+"天</td>\n"+
                     "<td>"+da[i].createTime+"</td>\n"+
                     "<td>"+da[i].modifytime+"</td>\n"+
                     "<td>"+da[i].approveOpinion+"</td>\n"+
                     "<td>"+da[i].status+"</td>\n"+
                     "<td>\n"+
                     "<span onclick='selectLeaver("+da[i].id+")' class=\"glyphicon glyphicon-zoom-in\"></span>&nbsp;&nbsp;\n"+
                     "</td>\n"+
                     "</tr>");
             }else {
                 $("#tab").append(" <tr>\n"+
                     "<td>"+da[i].id+"</td>\n"+
                     "<td>"+da[i].ename+"请假"+da[i].leaveday+"天</td>\n"+
                     "<td>"+da[i].createTime+"</td>\n"+
                     "<td>"+da[i].modifytime+"</td>\n"+
                     "<td>"+da[i].approveOpinion+"</td>\n"+
                     "<td>"+da[i].status+"</td>\n"+
                     "<td>\n"+
                     "</tr>");
             }

         }
       }
   });
   /*按状态和时间进行查询*/
   $("#selec").click(function () {
       var createTime=$("#test04").val();
       var endTime=$("#enYMDhms").val();

       if ((createTime!=null||createTime!="")||(endTime!=null||endTime!="")){
           $.ajax({
               type:"get",
               url:"http://localhost:8080/departmentLeave/findBySnByTime/"+createTime+"/"+endTime,
               data:{},
               datatype:"json",
               success:function (data) {
                   var da=data["data"];
                   $("#tab").children("tr").remove();
                   for(var i=0;i<da.length;i++){
                       if (da[i].status=="待审批"){
                           $("#tab").append(" <tr>\n"+
                               "<td>"+da[i].id+"</td>\n"+
                               "<td>"+da[i].ename+"请假"+da[i].leaveday+"天</td>\n"+
                               "<td>"+da[i].createTime+"</td>\n"+
                               "<td>"+da[i].modifytime+"</td>\n"+
                               "<td>"+da[i].approveOpinion+"</td>\n"+
                               "<td>"+da[i].status+"</td>\n"+
                               "<td>\n"+
                               "<span onclick='selectLeaver("+da[i].id+")' class=\"glyphicon glyphicon-zoom-in\"></span>&nbsp;&nbsp;\n"+
                               "</td>\n"+
                               "</tr>");
                       }else {
                           $("#tab").append(" <tr>\n"+
                               "<td>"+da[i].id+"</td>\n"+
                               "<td>"+da[i].ename+"请假"+da[i].leaveday+"天</td>\n"+
                               "<td>"+da[i].createTime+"</td>\n"+
                               "<td>"+da[i].modifytime+"</td>\n"+
                               "<td>"+da[i].approveOpinion+"</td>\n"+
                               "<td>"+da[i].status+"</td>\n"+
                               "<td>\n"+
                               "</tr>");
                       }
                   }

               }
           });
       }else {
           $.ajax({
               type:"get",
               url:"http://localhost:8080/departmentLeave/findBySn",
               data:{},
               datatype:"json",
               success:function (data) {
                   var da=data["data"];
                   $("#tab").children("tr").remove();
                   for(var i=0;i<da.length;i++){
                       if (da[i].status=="待审批"){
                           $("#tab").append(" <tr>\n"+
                               "<td>"+da[i].id+"</td>\n"+
                               "<td>"+da[i].ename+"请假"+da[i].leaveday+"天</td>\n"+
                               "<td>"+da[i].createTime+"</td>\n"+
                               "<td>"+da[i].modifytime+"</td>\n"+
                               "<td>"+da[i].approveOpinion+"</td>\n"+
                               "<td>"+da[i].status+"</td>\n"+
                               "<td>\n"+
                               "<span onclick='selectLeaver("+da[i].id+")' class=\"glyphicon glyphicon-zoom-in\"></span>&nbsp;&nbsp;\n"+
                               "</td>\n"+
                               "</tr>");
                       }else {
                           $("#tab").append(" <tr>\n"+
                               "<td>"+da[i].id+"</td>\n"+
                               "<td>"+da[i].ename+"请假"+da[i].leaveday+"天</td>\n"+
                               "<td>"+da[i].createTime+"</td>\n"+
                               "<td>"+da[i].modifytime+"</td>\n"+
                               "<td>"+da[i].approveOpinion+"</td>\n"+
                               "<td>"+da[i].status+"</td>\n"+
                               "<td>\n"+
                               "</tr>");
                       }
                   }
               }
           });
       }

   });

});
/*查看详情*/
function  selectLeaver(i) {
    $(function () {
        location. href="http://localhost:8080/page/seleDeLeave/"+i;
    });

}