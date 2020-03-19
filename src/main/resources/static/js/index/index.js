/**
 * Arvin_Cheng
 */
$(document).ready(function() {
	
//	getLiuLanQiArddss();
	var html = "";
		html += "<div id='daohanglanHeight'>"
			html += "<ul id='ul' class='nav nav-stacked index-a-style-2'>"
				html += "<li><a class='index-a-style-1' onclick=goPage('static/html/dashboard/dashboardHtml.html',this)>首页</a></li>"
				html += "<li><a class='index-a-style-1' onclick=goPage('static/html/user/userHtml.html',this)>创建用户脚本</a>"
				html += "<li><a class='index-a-style-1' onclick=goPage('static/html/post/postHtml.html',this)>创建岗位脚本</a>"
				html += "<li><a class='index-a-style-1' onclick=goPage('static/html/userPost/userPostHtml.html',this)>创建用户岗位脚本</a>"
				html += "<li><a class='index-a-style-1' onclick=goPage('static/html/rolePost/rolePostHtml.html',this)>创建角色岗位脚本</a>"
				html += "<li><a class='index-a-style-1' onclick=goPage('static/html/postJurisdiction/postJurisdictionHtml.html',this)>创建岗位权限脚本</a>"
			html += "</ul>"
		html += "</div>"
	$("#menuId").html(html);
})

/**
 * 登出按钮
 */
function logOutButton(){
	$.cookie('loginName', null); 
	window.location.href = ARVINPROJECT_PATH + "/loginPage";
}

function goPage(url){
	$("#commonContent").load(url);  
}
