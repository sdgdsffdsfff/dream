//激活时改变输入框边框色
function changeTextBorder(t,b,f){
    var uiText = $(t);
    uiText.bind("focus",function(){
        $(this).parent().addClass(f).removeClass(b);
    });
    uiText.bind("blur",function(){
        $(this).parent().addClass(b).removeClass(f);
    });
};
//登录框
function loginText(){
    var uiText1 = $(".userName");
    var uiText2 = $(".passWord");
    uiText1.find("input").bind("focus",function(){
        uiText1.addClass("userNameFocus");
        uiText2.addClass("passWordFocus");
    });
    uiText1.find("input").bind("blur",function(){
        uiText1.removeClass("userNameFocus");
        uiText2.removeClass("passWordFocus");
    });
    uiText2.find("input").bind("focus",function(){
        uiText1.addClass("userNameFocus");
        uiText2.addClass("passWordFocus");
    });
    uiText2.find("input").bind("blur",function(){
        uiText1.removeClass("userNameFocus");
        uiText2.removeClass("passWordFocus");
    });
};
//文本得到焦点
//o为对象，v为默认值
function snTxtFocus(o,v){
    if($(o).val() == $(o)[0].defaultValue && $(o).val() == v){
        $(o).val("");
        $(o).css({"color":"#333"});
    };
};
//文本失去焦点
//o为对象，v为默认值
function snTxtBlur(o,v){
    if ($(o).val() == ''){
        $(o).val(v);
        $(o).css({"color":"#999"});
    };
};
//菜单
function menu(){
    var btn = $(".menu").find("a");
    btn.mouseover(function(){
        if($(this).next().hasClass("subMenu")||$(this).next().hasClass("subMenu_sub")){
            $(this).next().show();
            $(this).parent().addClass("hover").siblings().removeClass("hover");
        }
    });
    $(".menu").mouseleave(function(){
        $(this).find("li").removeClass("hover");
    });
    $(".subMenu").mouseleave(function(){
        $(this).find("li").removeClass("hover");
    });
    $(".menu").find("li").mouseleave(function(){
        $(this).removeClass("hover");
        $(this).find(".subMenu").hide();
    });
    $(".subMenu").find("li").mouseleave(function(){
        $(this).removeClass("hover");
        $(this).find(".subMenu_sub").hide();
    });
}
//友情链接
function linkScroll(){
    var newList = $(".linkList").clone();
    $(newList).removeClass("linkScroll");
    $(newList).appendTo($(".linkListWrap"));
    var timer;
    var t=0;
    var h = $(".linkScroll").height()+8;
    function auto(){
        timer = setInterval(
            function () {
                t--;

                if (t < -h) {
                    t = 0;
                }
                $(".linkScroll").css("margin-top",t+"px");
            },20
        );
    }
    $(".linkListWrap").hover(function(){clearInterval(timer);},function(){auto();}).trigger("mouseleave");
}

function linkScroll1(){
    var newList = $(".linkList1").clone();
    $(newList).removeClass("linkScroll");
    $(newList).appendTo($(".linkListWrap2"));
    var timer;
    var l=0;
    var w = $(".linkScroll").width();
    function auto(){
        timer = setInterval(
            function () {
                l--;

                if (l < -w) {
                    l = 0;
                }
                $(".linkScroll").css("margin-left",l+"px");
            },10
        );
    }
    $(".linkListWrap2").hover(function(){clearInterval(timer);},function(){auto();}).trigger("mouseleave");
}
//我的工作台
function myWork(){
    var tabBtn = $(".myWorkList").find("a");
    var tabCon = $(".myWorkCon_c");
    tabBtn.click(function(){
        var index = $(tabBtn).index(this);
        $(this).addClass("on").siblings().removeClass("on");
        tabCon.eq(index).show().siblings().hide();
    });
}
//表格隔行变色
function oddTr(t){
     $(t).find("tbody").find("tr:odd").each(function(){
         $(this).find("td").addClass("oddTd");
     });
}
$(function () {
    changeTextBorder(".uiText","uiTextBlur","uiTextFocus");
    loginText();
    menu();
    linkScroll();
    linkScroll1();
    myWork();
    oddTr(".uiTable");
});