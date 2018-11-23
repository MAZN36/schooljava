<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>专业选课方向</title>
<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="js/layui/css/layui.css"  media="all">
  <link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/layui/layui.js" charset="utf-8"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<style>
th .layui-table-cell,td {text-align:center;}
.rigtop { width: 1143px; height: 40px;border: 1px solid #b7d5df;line-height: 40px;margin:auto;margin-top:5px;}
.layui-btns {width: 120px;height: 32px;line-height: 32px;position:relative;float:right;border-radius: 20px;top:5px}
.divtable{width:1145px;margin:auto;margin-top:-5px;}
.rigtop a{font-size:14px;}
.input{width:275px;}
</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">日常工作</a></li>
    <li><a href="#">专业选课方向</a></li>
    </ul>
    </div>
    <div class="rigtop">
   当前状态未开发...
	    <button class="layui-btn layui-btn-normal layui-btns layui-btn-disabled"  id="insert2">设为第二志愿</button>
	    <button class="layui-btn layui-btn-normal layui-btns layui-btn-disabled"  id="insert">设为第一志愿</button>
    </div>
    <div class="divtable">
<table id="demo" lay-filter="demo" lay-filter="test"></table>
</div>
<script>
/* var table=null;
var form=null;
layui.use(['table','form'], function(){
	table= layui.table;
	form=layui.form;
  //第一个实例
  table.render({
    elem: '#demo'
    ,height: 471
    ,page:true
    ,cellMinWidth: 130
    ,url: 'SelectCoursetype?action=select' //数据接口
    ,cols: [[ //表头
    	{type:'checkbox', fixed: 'left'}
    	,{type:'numbers', title: '序号'}
      ,{field: 'select_name', title: '课程名称',align:'center'}
      ,{field: 'select_target', title: '课程目标',align:'center'}
      ,{field: 'select_introduce', title: '课程介绍',align:'center'}
      ,{field: 'select_capacityv', title: '具备能力',align:'center'}
      ,{field: 'select_jobs', title: '就业岗位',align:'center'}
      ,{field: 'select_teacher', title: '专业老师',align:'center'}
    ]]
  });
//监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
      layer.msg('ID：'+ data.id + ' 的查看操作');
    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.alert('编辑行：<br>'+ JSON.stringify(data))
    }
  });
  
});
 */
</script>

</body>
</html>