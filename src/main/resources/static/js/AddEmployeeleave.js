/*添加请假单*/
$(function () {

    $("#submits").click(function () {

        //开始时间
        var createTime=$("#test04").val();
        //结束时间
        var endTime=$("#enYMDhms").val();
        //请假天数
        var leaveday=$("#leaveday").val();
        //请假类型
        var leaveType=$("#leaveType>option:selected").val();
        //备注
        var textarea=$("#textarea").val();
        $.ajax({
            type:"post",
           url:"http://localhost:8080/eLeave/addLeaver/"+createTime+"/"+endTime+"/"+leaveday+"/"+leaveType+"/"+textarea,
            data:{},
            dataType:"json",
            success:function (data) {
                if(data.code==0){
                     alert("添加成功");
                    location. href="http://localhost:8080/page/selectLeavers";
                }else{
                     alert("添加失败");
                    location. href="http://localhost:8080/page/selectLeavers";
                }
            }
        });
    });
});