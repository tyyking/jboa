<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<center>
    <h1>登录系统</h1>
        <table>
            <tr>
                <th>工号:</th>
                <td><input id="useCode" type="text" name="userCode"/></td>
            </tr>
            <tr>
                <th>密码:</th>
                <td><input id="password"  type="password" name="password"/></td>
            </tr>
            <tr>
                <th>所在部门:</th>
                <td>
                    <select id="deparntment">

                    </select>
                </td>
            </tr>
            <tr>
                <th colspan="2"><button onclick="loding()">登录</button></th>
            </tr>
        </table>
</center>
</body>
<script>
    /*查看有多少部门*/
    $(function () {
        $.ajax({
            type:"get",
           url:"http://localhost:8080/lodings/showDepanrtment",
            data:{},
            dataType:"json",
            success:function (data) {
                var da=data["data"];
                for(var i=0;i<da.length;i++){
                    $("#deparntment").append(" <option>"+da[i].name+"</option>")
                }
            }
        });

    });
    //登录
    function loding() {
       $(function () {
           var useCode= $("#useCode").val();
           var password= $("#password").val();
           var option=$("#deparntment>option:selected").val();
           $.ajax({
               type:"get",
              url:"http://localhost:8080/lodings/loding/"+useCode+"/"+password+"/"+option,
               data:{},
               dataType:"json",
               success:function (data) {
                   var da=data["data"];
                  if(da.bool){
                      switch (da.Pname){
                          case "员工":
                              location. href="http://localhost:8080/page/accountShowList";
                              break;
                          case "部门经理":
                              location. href="http://localhost:8080/page/seleDevouchers";
                              break;
                          case "总经理":
                              location. href="http://localhost:8080/page/generpageshow";
                              break;
                          case "财务":
                              location. href="http://localhost:8080/page/pageshow";
                              break;
                      }
                  }else{
                       alert("账号或密码错误");
                  }
               }
           });
       });
    }
</script>
</html>