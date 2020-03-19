/**
 * Arvin_Cheng
 */
$(document).ready(function() {
	
});

/*
 * 获取浏览器地址后的参数
 */
function getLiuLanQiArddss(){
	debugger;
	//获取地址后面的参数
	var getInfo = window.location.search.slice(window.location.search.lastIndexOf("?")+1);
	
	if("" == getInfo){
		return;
	}
	
	var activeUser = getInfo.substring(getInfo.indexOf("=") + 1,getInfo.length);
	
	$("#indexValue").text(activeUser);
	
	//将用户名存入cookie中
	$.cookie('userName', activeUser); 
	
	window.location.href = window.location.href.substring(0,window.location.href.indexOf("?"));
	
}