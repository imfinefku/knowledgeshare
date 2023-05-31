var menuList = null;
var element = null;
var curOpen = null;// 当前打开的弹出层
window.onload = function() {
	layui.use([ 'element', 'form' ], function() {
		element = layui.element;
		form = layui.form;
		$("#content").load("/manage/questionType.html");
	});
};


function logout() {
	$.ajax({
		url : "/manager/logout",
		type : "post",
		contentType : 'application/json;charset=UTF-8',
		dataType : "json",
		data : {},
		success : function(response) {
			if (response.code == "200") {
				window.location = "/index.html";
			} else {
				alert(response.message);
			}
		},
		error : function(error) {
		}
	});
}

function loadContent(url){
	$("#content").load(url);
}