$(function(){
	
	$(".showInfoDetails").click(function(){
		var infoId = $(this).attr("infoId");
		$.ajax({
			type: "POST",
			url: base + infosUrl + infoId,
			success: function(data){
				myDialog(data);
			}
		});
	});
	
    function myDialog(content){
    	$.dialog({
    		title:'信息详情',
            fixed:true,
            lock:true,
            content:''+content
        });
    }
}); 