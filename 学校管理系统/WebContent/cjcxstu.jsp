<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="js/layui/css/layui.css"  media="all">
  <link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
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
.layui-btns {width: 100px;height: 32px;line-height: 32px;position:relative;top:5px;float:right;border-radius: 20px;background-color:#1E9FFF;}
.divtable{width:1145px;margin:auto;margin-top:-5px;}
.rigtop a{font-size:14px;}
#xzxy{position:relative;top:4px;}
.layui-form-radio{    margin: 0px;}
</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">信息查询</a></li>
    <li><a href="#">个人出勤查询</a></li>
    </ul>
    </div>
     <div class="rigtop">
	   	<div class="layui-form-item layui-form" >
     <div class="layui-inline" >
      <label class="layui-form-label"  >开始日期:</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="test" placeholder="yyyy-MM-dd">
      </div>
      <label class="layui-form-label"  >结束日期:</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="test1" placeholder="yyyy-MM-dd">
      </div>
      	   <input type="radio" name="sex" value="正常上课" title="正常上课" >
	      <input type="radio" name="sex" value="自习课" title="自习课">
	      <input type="radio" name="sex" value="班级活动" title="班级活动">
	      <input type="radio" name="sex" value="其他" title="其他">
	      <input type="radio" name="sex" value="所有类型" title="所有类型">
      </div>
	</div>
    </div>
<div class="divtable">
<table id="demo" lay-filter="demo" lay-filter="test"></table>
</div>
<script src="js/layui/layui.js" charset="utf-8"></script>
<script>
var table=null;
var form=null;
layui.use(['table','form'], function(){
	table= layui.table;
	form=layui.form;
  //第一个实例
  table.render({
    elem: '#demo'
    ,height: 471
    ,page:true
    ,url: 'Studentinfo?action=select' //数据接口
   	,cellMinWidth: 120
    ,cols: [[ //表头
    	{type:'numbers', title: '序号'}
        ,{field: 'sclass', title: '班级'}
        ,{field: 'aDate', title: '时间', sort: true}
        ,{field: 'city', title: '迟到'} 
        ,{field: 'sign', title: '早退' }
        ,{field: 'experience', title: '旷课',sort: true}
        ,{field: 'score', title: '请假', sort: true}
    ]]
  ,id:"idsw"
  });
  
});

</script>


<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //常规用法
  laydate.render({
    elem: '#test'
  });

  //自定义格式
  laydate.render({
    elem: '#test1'
  });
});

</script>

</body>
</html>