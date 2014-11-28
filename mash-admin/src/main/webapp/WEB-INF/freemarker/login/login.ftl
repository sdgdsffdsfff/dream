<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
<script type="text/javascript" src="${resRoot}/lib/jquery.min.js"></script>  
<script type="text/javascript">  
function doLogin(){
    var url = "${base}/j_spring_security_check";  
    var username= $("input[name='j_username']").val();  
    var password= $("input[name='j_password']").val();  
    $.ajax({  
        url:url,  
        type:"POST",  
        data:"j_username="+username+"&j_password="+password,  
        success: function(data){
            $("#results").text(data);
        }  
    });  
}
</script>  
  
  
<title>登陆界面</title>  
</head>  
<body>  
<h3>欢迎登陆1</h3>  
<form>  
 <table>  
    <tr><td>用户名:</td><td><input type='text' name='j_username' value=''></td></tr>  
    <tr><td>密    码:</td><td><input type='password' name='j_password'/></td></tr>  
    <tr><td colspan='2'><input name="submit" type="button" onclick="doLogin()" value="登陆"/></td></tr>  
  </table>  
  <div id="results"></div>  
</form>  
</body>  
</html>