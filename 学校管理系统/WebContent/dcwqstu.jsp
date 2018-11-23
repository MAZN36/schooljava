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
		.bc{
			align:right;
		}
		#div{
			height:25px;
			font-size:15px;
			background-color:#f5f5f5;
			position:relative;
			top:10px;
			left:10xp;
			padding:10px;
		}
	</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">满意度调查</a></li>
    <li><a href="#">填写问卷调查</a></li>
    </ul>
    </div>
    <div id="div">[注意：每个问题满分为10分，您可以输入0-10分]</div>
    
    <div class="layui-form-item layui-form" style="margin-top: 10px;margin-bottom: 0px;margin-right: 10px;">
     <div class="layui-inline" >
     
      <label class="layui-form-label"  >调查问卷:</label>
      <div class="layui-input-inline">
        <select name="quiz">
          <option value="">暂无调查问卷</option>
        </select>
      </div>
      
      <label class="layui-form-label"  >调查对象:</label>
      <div class="layui-input-inline">
        <select name="quiz">
          <option value="">无调查对象</option>
        </select>
      </div>
      <div class="layui-input-inline">
        <button class="layui-btn">追加问卷</button>
      </div> 
     </div>
		       <button class="layui-btn layui-btn-primary">保存</button>
	

	 
   

<table id="demo" lay-filter="test" style="text-align:center"></table>

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
	    ,height: 400
	    ,url: 'Studentinfo?action=select' //数据接口
	    ,cols: [[ //表头
	    	{field: 'id', title: '序号', width:100, sort: true, fixed: 'left'}
	        ,{field: 'sClass', title: '调查问题', width:100}
	        ,{field: 'sex', title: '得分', width:130, sort: true}
	        ,{field: 'city', title: '建议与评论', width:120} 
	    ]]
	  ,id:"idsw"
	  });
	  
  
});

</script>


</body>
</html>
