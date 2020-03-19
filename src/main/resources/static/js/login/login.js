/**
 * Arvin_Cheng
 */
jQuery(document).ready(function() {
	$("#loginNameError").hide();
	$("#loginPasswordError").hide();
	
	
})

/**
 * （√） （×）
 * 获取当前登录用户账号he密码
 * */
function getUserNameAndPassword(){
	var loginName = $("#loginName").val();
	var loginPassword = $("#loginPassword").val();

	if(!judgeLoginInfo()){
		return false;
	}
	
	var loginObj = {};
	loginObj.loginName = loginName;
	loginObj.loginPassword = loginPassword;
	
	//将用户名存入cookie中
	$.cookie('loginName', loginName); 
	
	$.ajax({  
		url:ARVINPROJECT_PATH + "/loginRequest",
		data : {"loginObj" : JSON.stringify(loginObj)},
		dataType: "json",  
		type: "POST",  
		async : false,
		success : function(resultData){
			if("S" == resultData.status){//登录成功，将跳转到系统首页
				window.location= ARVINPROJECT_PATH + "/homePageRequest";//登录成功跳转首页（index.html）
			}else{
				window.location = ARVINPROJECT_PATH + "/loginPage";//登录失败继续留在登录页面，并给出提示（login.html）
			}
		},
        error : function(response) {
        	window.location = ARVINPROJECT_PATH + "/loginPage";//登录失败继续留在登录页面，并给出提示（login.html）
        }
    });
}

/**
 * 判断登录信息是否为空
 * @param event
 */
function judgeLoginInfo(){
	var judgeResult = true;
	if(!$("#loginName").val()){
		$("#loginNameError").show();
		$("#loginNameError").text("×    用户名不能为空！");
		judgeResult =  false;
	}else{
		$("#loginNameError").hide();
	}
	if(!$("#loginPassword").val()){
		$("#loginPasswordError").show();
		$("#loginPasswordError").text("×  密码不能为空！");
		judgeResult =  false;
	}else{
		$("#loginPasswordError").hide();
	}
	return judgeResult;
}

/*
 * 点击回车键触发事件
 * */
function keyLogin(event) {
	var e = event || window.event || arguments.callee.caller.arguments[0];
	if (e && e.keyCode == 13){
		getUserNameAndPassword();
	}
}

/***
 * 跳转到当前页（解析浏览器被转义后的地址）
 * @param name
 * @returns
 */
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}