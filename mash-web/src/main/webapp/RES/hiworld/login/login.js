$(function(){
	
	/*
	 * 点击
	 */
	$("#btn").click(function(){
	    var url = base + "/j_spring_security_check";
	    var username= $("input[name='j_username']").val();  
	    var password= $("input[name='j_password']").val();  
	    $.ajax({
	        url:url,  
	        type:"POST",
	        data:"j_username="+username+"&j_password="+password,
	        dataType:"json",
	        success: function(data){
	            console.log(data);
	            if(data.succFlag){
	            	window.location.href=""+data.msg;
	            }else{
	            	$("#results").text(data.msg);
	            }
	        }  
	    });
	});
    
});