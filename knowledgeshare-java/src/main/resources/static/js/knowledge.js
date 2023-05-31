var table;
var curType;// 当前type,insert or update
var curID;// 当前编辑ID
var curOpen;// 当前打开的弹出层
var form;// 表单
var imgUrl = "";// 文章配图路径

$(function() {
	initLayui();
});

// 初始化layui
function initLayui() {
	layui.use([ 'layer', 'table', 'upload','form' ], function() {
		table = layui.table;
		form = layui.form;
		initTable();
		getQuestionType(null);
		var upload = layui.upload;
		// 执行实例
		upload.render({
			elem : "#imageXs", // 绑定元素
			url : "/image/uploadImage", // 上传接口
			type : "post",
			done : function(res) {
				// 上传完毕回调
				if (res.code == 0) {// 上传成功
					layer.msg('图片上传成功', {
						icon : 1
					});
					document.getElementById("imageXs").src = "/showImage/"+res.data.src;
					imgUrl = res.data.src;
				} else {// 上传失败
					layer.msg('图片上传失败!', {
						icon : 5
					});
				}
			},
			error : function() {
				// 请求异常回调
				layer.msg('图片上传失败!', {
					icon : 5
				});
			}
		});
	});
}

// 初始化表格
function initTable() {
	table.render({
		elem : '#grid',
		url : '/knowledge/getPage',
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
			title : '标题'
		}, {
			field : 'questiontypetitle',
			width : 0,
			title : '类别'
		}, {
			field : 'questiontypeid',
			width : 0,
			title : '类别id',
			hide : true
		}, {
			field : 'content',
			width : 0,
			title : '内容'
		}, {
			field : 'addtime',
			width : 0,
			title : '添加时间',
			templet : function(d) {
				return getDate(d.addtime);
			}
		}, {
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
			curType = "insert";
			curOpen = layer.open({
				type : 1,
				title : "添加知识点",
				offset : "auto", // http://www.layui.com/doc/modules/layer.html#offset
				id : 'message', // 防止多次弹出
				content : $("#formbar"),
				area : [ '600px', '600px' ],
				shade : 0.3,
				success : function(layero) {
					// 把内容放到遮罩层里，防止遮罩挡住弹出层
					var mask = $(".layui-layer-shade");
					mask.appendTo(layero.parent());
					form.val('message', {
						"title" : "",
						"questionType" : "",
						"content" : ""
					});
					document.getElementById("imageXs").src = "/img/uploadBackground.png";
					imgUrl="";
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
		url : "/knowledge/getPage",
		where : {},
		page : {
			curr : 1
		// 重新从第 1 页开始
		}
	});
}

// 获取笔记类别下拉数据
function getQuestionType(questiontypeid) {
	$.ajax({
		url : "/questionType/getAll",
		dataType : "json",
		data : {},
		success : function(response) {
			if (response.code == "200") {
				var html = "<option value=\"\">请选择</option>";
				for (var i = 0; i < response.data.length; i++) {
					html += "<option value=\"" + response.data[i].id + "\" ";
					if (questiontypeid != null
							&& questiontypeid == response.data[i].id) {
						html += "selected"
					}
					html += " >"
					html += response.data[i].title + "</option>";
				}
				$("#questionType").html(html);
				form.render("select");
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