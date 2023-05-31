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
		url : '/questionType/getPage',
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
			title : '类别名称'
		}, {
			field : 'addtime',
			width : 0,
			title : '添加时间',
			templet : function(d) {
				return getDate(d.addtime);
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

}

// 表格数据重载
function tableReload() {
	table.reload('grid', {
		url : "/questionType/getPage",
		where : {},
		page : {
			curr : 1
		// 重新从第 1 页开始
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