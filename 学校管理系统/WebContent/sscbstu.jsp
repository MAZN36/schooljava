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
.layui-btns {width: 100px;height: 32px;line-height: 32px;position:relative;float:right;border-radius: 20px;top:5px}
.divtable{width:1145px;margin:auto;margin-top:-5px;}
.rigtop a{font-size:14px;}
.input{width:275px;}
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
    	<div class="layui-form-item layui-form">  
     <div class="layui-inline" >
      <label class="layui-form-label" style="width:40px;" >年份:</label>
      <div class="layui-input-inline">
        <select name="quiz">
          <option value="">2018</option>
            <option value="">2017</option>
            <option value="">2016</option>
            <option value="">2015</option>
            <option value="">2014</option>
            <option value="">2013</option>
        </select>
      </div>
    </div>
	<div class="layui-inline" >
	      <input type="radio" name="sex" value="电表" title="电表">
	      <input type="radio" name="sex" value="热水" title="热水">
	      <input type="radio" name="sex" value="矿泉水" title="矿泉水">
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
    ,height: 430
    ,cellMinWidth: 80
    ,url: 'Studentinfo?action=select' //数据接口
    ,cols: [[ //表头
    	{type:'numbers', title: '序号'}
    	 ,{field: 'id', title: '宿舍名', sort: true}
         ,{field: '1', title: '一月'}
         ,{field: '2', title: '二月',  sort: true}
         ,{field: '3', title: '三月'} 
         ,{field: '4', title: '四月'}
         ,{field: '5', title: '五月', sort: true}
         ,{field: '6', title: '六月', sort: true}
         ,{field: '7', title: '七月', sort: true}
         ,{field: '8', title: '八月', sort: true}
         ,{field: '9', title: '九月', sort: true}
         ,{field: '10', title: '十月', sort: true}
         ,{field: '11', title: '十一月', sort: true}
         ,{field: '12', title: '十二月', sort: true}
    ]]
  ,id:"idsw"
  });
  
});

</script>

</body>
</html>

</body>
</html>