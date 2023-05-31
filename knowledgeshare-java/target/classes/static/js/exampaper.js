var table;
var curType;// 当前type,insert or update
var curID;// 当前编辑ID
var curOpen;// 当前打开的弹出层
var form;// 表单
var xzNum=150;//选择题数量
var jdNum=10;//简答题数量

$(function() {
	initLayui();
});

function initQuestionContent(){
	var html="";
	if (xzNum>0){
		html += "<div class=\"layui-form-item\">" +
			"<label class=\"layui-form-label\" style=\"width: 110px; float: left;\">一、选择题：</label>" +
			"</div>";
	}
	for (var i=1;i<=xzNum;i++){
		html+="<div class=\"layui-form-item\">" +
			"<label class=\"layui-form-label\">第"+i+"题：</label>" +
			"<div class=\"layui-input-block\">" +
			"<select name=\"dx"+i+"\" lay-filter=\"dx"+i+"\" id=\"dx"+i+"\" lay-verify=\"dx"+i+"\" lay-search>" +
			"</select>" +
			"</div>" +
			"</div>";
	}
	if (jdNum>0){
		html += "<div class=\"layui-form-item\">\n" +
			"<label class=\"layui-form-label\" style=\"width: 110px;\">二、简答题：</label>\n" +
			"</div>";
	}
	for (var i=1;i<=jdNum;i++){
		html+="<div class=\"layui-form-item\">" +
			"<label class=\"layui-form-label\">第"+i+"题：</label>" +
			"<div class=\"layui-input-block\">" +
			"<select name=\"jd"+i+"\" lay-filter=\"jd"+i+"\" id=\"jd"+i+"\" lay-verify=\"jd"+i+"\" lay-search>" +
			"</select>" +
			"</div>" +
			"</div>";
	}
	$("#questionContent").html(html);
	getXzJd();
}

// 初始化layui
function initLayui() {
	layui.use([ 'layer', 'table', 'form' ], function() {
		table = layui.table;
		form = layui.form;
		initTable();
		getLevel(null);
	});
}

// 初始化表格
function initTable() {
	table.render({
		elem : '#grid',
		url : '/exampaper/getPage',
		toolbar : '#toolbar',
		id : "grid",
		parseData : function(res) { // res 即为原始返回的数据
			return {
				"data" : res.data.data,
				"code" : res.data.code,
				"count" : res.data.count
			};
		},
		height : "full",
		cols : [ [ {
			field : 'id',
			width : 0,
			title : 'id'
		}, {
			field : 'title',
			width : 0,
			title : '试卷名称'
		}, {
			field : 'score',
			width : 0,
			title : '分数'
		},  {
			field : 'addtime',
			width : 0,
			title : '添加时间',
			templet : function(d) {
				return getDate(d.addtime);
			}
		},  {
			field : 'updatetime',
			width : 0,
			title : '修改时间',
			templet : function(d) {
				return getDate(d.updatetime);
			}
		}, {
			field : 'cz',
			width : 0,
			title : '操作',
			toolbar : '#tool'
		} ] ],
		page : true,
		limit : 10, // 分页，10条数据一页
		done : function(res) {
			// 获取数据后操作
		}
	});
	// 绑定头部事件
	table.on('toolbar(grid)', function(obj) {
		switch (obj.event) {
		case 'insert':
			initQuestionContent();
			curType = "insert";
			curOpen = layer.open({
				type : 1,
				title : "添加试卷",
				offset : "auto", // http://www.layui.com/doc/modules/layer.html#offset
				id : 'message', // 防止多次弹出
				content : $("#formbar"),
				area : [ '600px', '600px' ],
				shade : 0.3,
				success : function(layero) {
					// 把内容放到遮罩层里，防止遮罩挡住弹出层
					var mask = $(".layui-layer-shade");
					mask.appendTo(layero.parent());
					var dataJson={
						"title" : "",
						"level" : ""
					};
					for (var i=1;i<=xzNum;i++){
						var dxf = "dx"+i;
						dataJson[dxf]="";
					}
					for (var i=1;i<=jdNum;i++){
						var jdf = "jd"+i;
						dataJson[jdf]="";
					}
					form.val('message', dataJson);
					form.render();
				}
			});
			break;
		}
		;
	});
}

// 表格数据重载
function tableReload() {
	table.reload('grid', {
		url : "/exampaper/getPage",
		where : {},
		page : {
			curr : 1
		// 重新从第 1 页开始
		}
	});
}

//获取试卷级别下拉数据
function getLevel(level) {
	$.ajax({
		url : "/level/getAll",
		dataType : "json",
		data : {},
		success : function(response) {
			if (response.code == "200") {
				var html = "<option value=\"\">请选择</option>";
				for (var i = 0; i < response.data.length; i++) {
					html += "<option value=\"" + response.data[i].id + "\" ";
					if (level != null
							&& level == response.data[i].id) {
						html += "selected"
					}
					html += " >"
					html += response.data[i].name + "</option>";
				}
				$("#level").html(html);
				form.render("select");
			}
		},
		error : function(error) {
		}
	});
}

function getXzJd() {
	$.ajax({
		url : "/question/getAll",
		dataType : "json",
		data : {},
		success : function(response) {
			if (response.code == "200") {
				var html = "<option value=\"\">请选择</option>";
				for (var i = 0; i < response.data.xz.length; i++) {
					html += "<option value=\"" + response.data.xz[i].id + "\" ";
					html += " >"
					html += response.data.xz[i].title + "</option>";
				}
				for (var i=1;i<=xzNum;i++){
					$("#dx"+i).html(html);
				}
				var html2 = "<option value=\"\">请选择</option>";
				for (var i = 0; i < response.data.jd.length; i++) {
					html2 += "<option value=\"" + response.data.jd[i].id + "\" ";
					html2 += " >"
					html2 += response.data.jd[i].title + "</option>";
				}
				for (var i=1;i<=jdNum;i++){
					$("#jd"+i).html(html2);
				}
				form.render("select");
			}
		},
		error : function(error) {
		}
	});
}

//获取试卷子卷
function getSub(id) {
	$.ajax({
		url : "/exampaper/getSubByExampaperid/"+id,
		dataType : "json",
		data : {},
		success : function(response) {
			if (response.code == "200") {
				var jdNumt = 0;
				for (var i=0;i<response.data.length;i++){
					if (response.data[i].type=="单选"){
						var temp="dx"+(i+1);
						$("#"+temp).val(response.data[i].questionid);
					}else if (response.data[i].type=="简答"){
						jdNumt++;
						var temp="jd"+(jdNumt);
						$("#"+temp).val(response.data[i].questionid);
					}

				}
			}
		},
		error : function(error) {
		}
	});
}

function getDate(timestamp) {
	var date = new Date(timestamp);
	Y = date.getFullYear() + '-';
	M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date
			.getMonth() + 1)
			+ '-';
	D = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
	D += ' ';
	h = date.getHours() < 10 ? '0' + date.getHours() : date.getHours();
	h += ':';
	m = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes();
	m += ':';
	s = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds();
	return Y + M + D + h + m + s;
}