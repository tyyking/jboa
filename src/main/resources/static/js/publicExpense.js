/*当点击时文件夹打开*/
$(function () {
    $("#gly1").click(function () {
        var span1=$(this).children("span").eq(0).html();
       if(span1==1){
           $(this).children("span").eq(1).hide();
           $(this).children("span").eq(2).show();
           $(this).children("span").eq(0).html("2");
       }else {
           $(this).children("span").eq(2).hide();
           $(this).children("span").eq(1).show();
           $(this).children("span").eq(0).html("1");
       }
    });
    $("#gly2").click(function () {
        var span1=$(this).children("span").eq(0).html();
        if(span1==1){
            $(this).children("span").eq(1).hide();
            $(this).children("span").eq(2).show();
            $(this).children("span").eq(0).html("2");
        }else {
            $(this).children("span").eq(2).hide();
            $(this).children("span").eq(1).show();
            $(this).children("span").eq(0).html("1");
        }
    });
    $("#gly3").click(function () {
        var span1=$(this).children("span").eq(0).html();
        if(span1==1){
            $(this).children("span").eq(1).hide();
            $(this).children("span").eq(2).show();
            $(this).children("span").eq(0).html("2");
        }else {
            $(this).children("span").eq(2).hide();
            $(this).children("span").eq(1).show();
            $(this).children("span").eq(0).html("1");
        }
    });
});
