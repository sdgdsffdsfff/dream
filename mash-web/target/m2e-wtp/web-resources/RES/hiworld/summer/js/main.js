/**
 */
;(function($){
	
	/*
	 * 过滤表情
	 */
	function filterContext(context){
		var data = context;
		var mycars=new Array("/::)", "/::~", "/::B", "/::|", "/:8-)", "/::<", "/::$", "/::X", "/::Z", "/::'(", "/::-|", "/::@", "/::P", "/::D", "/::O", "/::(", "/::+", "/:--b", "/::Q", "/::T", "/:,@P", "/:,@-D", "/::d", "/:,@o", "/::g", "/:|-)", "/::!", "/::L", "/::>", "/::,@", "/:,@f", "/::-S", "/:?", "/:,@x", "/:,@@", "/::8", "/:,@!", "/:!!!", "/:xx", "/:bye", "/:wipe", "/:dig", "/:handclap", "/:&-(", "/:B-)", "/:<@", "/:@>", "/::-O", "/:>-|", "/:P-(", "/::'|", "/:X-)", "/::*", "/:@x", "/:8*", "/:pd", "/:<W>", "/:beer", "/:basketb", "/:oo", "/:coffee", "/:eat", "/:pig", "/:rose", "/:fade", "/:showlove", "/:heart", "/:break", "/:cake", "/:li", "/:bome", "/:kn", "/:footb", "/:ladybug", "/:shit", "/:moon", "/:sun", "/:gift", "/:hug", "/:strong", "/:weak", "/:share", "/:v", "/:@)", "/:jj", "/:@@", "/:bad", "/:lvu", "/:no", "/:ok", "/:love", "/:<L>", "/:jump", "/:shake", "/:<O>", "/:circle", "/:kotow", "/:turn", "/:skip", "/:oY");
		var imgPreUrl = "<img src='https://res.wx.qq.com/mpres/htmledition/images/icon/emotion/";
		var imgFUrl = ".gif' style='clear: both;float: none;width: 36px;height: 36px;border: none;margin: 10px 0;' >";
		for(var i=0;i<mycars.length;i++){
			data = data.replace(mycars[i], imgPreUrl+i+imgFUrl);
		}
		return data;
	}
	
    $.extend($.easing,{
        easeOutBack:function(x,t,b,c,d,s){
            if (s == undefined) s = 1.70158;
            return c*((t=t/d-1)*t*((s+1)*t + s) + 1) + b;
        },
        easeOutCubic: function (x, t, b, c, d) {
            return c * ((t = t / d - 1) * t * t + 1) + b;
        }
    });
    var _timer = setInterval(function(){
    	var imguuuurl ="http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0";
    	if(logoImg){
    		imguuuurl = logoImg;
    	}
    	
        $.ajax({
	        type: "post",
	        url: base + msgsUrl,
	        data:searchMsg,
	        cache : "false",
            dataType:"json",
            success:function(data){
            	/* 当前会置展示标志位
            	searchMsg.pageIndex = searchMsg.pageIndex + 1;
            	if(data.isLastPage){
            		searchMsg.pageIndex = 1;
            	}
            	*/
            	if(data.totalDataCount<=0){
            		initMsgShowFlag();
            		return;
            	}
            	var dataContext = filterContext(data.datas[0].msgContext);
                var _nWeibo = '<li class="clearfix" style="opacity:0;">' +
                                '<img src="' + imguuuurl +'" alt="' + data.datas[0].nickname + '"/>' +
                                '<div class="info">' +
                                    '<strong>' + data.datas[0].nickname + '</strong>' +
                                    '<p class="time">' + data.datas[0].msgTime + '</p>' +
                                    '<p class="con">' + dataContext + '</p>' +
                                '</div>' +
                              '</li>';
                $("#weiboList").find("ul").stop().animate({"margin-top":[210+"px",'easeOutCubic']},1000,function(){
                    $("#weiboList").find("ul").css({"margin-top":0});
                    $("#weiboList").find("li").first().before(_nWeibo);
                    $("#weiboList").find("li").first().animate({opacity:[1,'easeOutCubic']},1000);
                    $("#weiboList").find("li").last().remove();
                });
            }
        });
    },3000);

    var _timer_actExtInfo = setInterval(function(){
    	getActInfoExt();
    },3000);
    
})(jQuery);

/*
 * 初始化公众信息-展示标识-未展示（随机）
 */
function initMsgShowFlag(){
    $.ajax({
        type: "post",
        url: base + initShowUrl,
        cache : "false",
        dataType:"json",
        success:function(data){
        	console.log(data);
        }
    });
}

/*
 * 获取活动的额外信息-活动参与人数-发送消息总数
 */
function getActInfoExt(){
    $.ajax({
        type: "post",
        url: base + actExtUrl,
        cache : "false",
        dataType:"json",
        success:function(data){
        	$(".top-stat.r strong:first-child").html(data.msgCounts);
        	$(".top-stat.r.pr50 strong:first-child").html(data.userCounts);
        }
    });

}