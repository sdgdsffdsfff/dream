$(function(){
	/*
	 * 左侧菜单
	 */
	$('#menuTreeId').tree({
		onClick: function(node){
			console.log(node.text);
			var subContentHeight = $(window).height() - 130;
			var content = '';
			var headContent = '<iframe border="0" frameBorder="no" scrolling="auto" name="inner-frame" src="';
			var tailContent = '" height="'+ subContentHeight +'px"  width="100%"></iframe>';
			if("1" == node.id){
				var url = accountUrl;
				content = headContent + url + tailContent;
				openTabs(node.text,content);
			}else if("2" == node.id){
				var url = actUrl;
				content = headContent + url + tailContent;
				openTabs(node.text,content);
			}else if("3" == node.id){
				var url = msgUrl;
				content = headContent + url + tailContent;
				openTabs(node.text,content);
			}else if("4" == node.id){
				var url = awardUrl;
				content = headContent + url + tailContent;
				openTabs(node.text,content);
			}else if("5" == node.id){
				var url = winningUrl;
				content = headContent + url + tailContent;
				openTabs(node.text,content);
			}else if("6" == node.id){
				var url = accountUrl;
				content = headContent + url + tailContent;
				openTabs(node.text,content);
			}
		}
	});
	
	/*
	 * 打开tabs
	 */
	function openTabs(title,content){
		if($('#tapsId').tabs('exists',title)){
			$('#tapsId').tabs('select',title)
		}else{
			addTabs(title,content);
		}
	}
	
	/*
	 * 增加taps
	 */
	function addTabs(title,content){
		$('#tapsId').tabs('add',{
		    title:''+title,
		    content:''+content,
		    closable:true,
		    tools:[{
		        handler:function(){
		        }
		    }]
		});
	}
	
});