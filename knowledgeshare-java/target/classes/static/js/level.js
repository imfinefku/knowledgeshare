var table;
var curType;// 当前type,insert or update
var curID;// 当前编辑ID
var curOpen;// 当前打开的弹出层
var form;// 表单

$(function() {
	initLayui();
});

// 初始化layui
function initLayui() {
	layui.use([ 'layer', 'table', 'form' ], function() {
		table = layui.table;
		form = layui.form;
		initTable();
	});
}

// 初始化表格
function initTable() {
	table.render({
		elem : '#grid',
		url : '/level/getPage',
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
			field : 'code',
			width : 0,
			title : '编码'
		}, {
			field : 'name',
			width : 0,
			title : '等级名称'
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
				title : "添加等级",
				offset : "auto", // http://www.layui.com/doc/modules/layer.html#offset
				id : 'message', // 防止多次弹出
				content : $("#formbar"),
				area : [ '400px', '400px' ],
				shade : 0.3,
				success : function(layero) {
					// 把内容放到遮罩层里，防止遮罩挡住弹出层
					var mask = $(".layui-layer-shade");
					mask.appendTo(layero.parent());
					$("#code").val("");
					$("#name").val("");
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
		url : "/level/getPage",
		where : {},
		page : {
			curr : 1
		// 重新从第 1 页开始
		}
	});
}