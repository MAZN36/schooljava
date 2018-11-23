<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学员重置密码</title>
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
.layui-btns {width: 100px;height: 32px;line-height: 32px;position:relative;top:1px;float:right;border-radius: 20px;background-color:#1E9FFF;}
.divtable{width:1145px;margin:auto;margin-top:-5px;}
.rigtop a{font-size:14px;}
#xzxy{position:relative;top:4px;}
	</style>
	</head>
	<body>  
		<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="#">首页</a></li>
	    <li><a href="#">学员管理</a></li>
	    <li><a href="#">学员重置密码</a></li>
	    </ul>
	    </div>
	    <div class="rigtop">
	   	<div class="layui-form-item layui-form" >
	    <div class="layui-inline" >
	      <label class="layui-form-label" style="width: 28px;">班级:</label>
	      <div class="layui-input-inline">
	        <select name="quiz" lay-verify="classselect" lay-search="" lay-filter="classselect" id="classselect">
	          <option value="">请选择班级</option>
	        </select>
	      </div>
	    </div>
	 	   姓名：
		<div class="layui-inline" style="width:190px">
		    <input class="layui-input" name="name" id="demoReload" autocomplete="off"> 
		</div>
		<div class="layui-inline">
		    <button class="layui-btn layui-btns layui-btn-normal" id="snamesele" data-type="getCheckData" >模糊查询</button>
		</div>
	    <button class="layui-btn layui-btns layui-btn-normal"  id="xzxy">重置密码</button>
	    </div>
	    </div>
	 <div class="divtable">
<table id="demo" lay-filter="demo"  ></table>
</div>
<script>
//进行按班级查询
var form=null;
var table=null;
layui.use(['table','form'], function(){
	table= layui.table;
	form= layui.form;
	var index = layer.load(2, {time: 100}); 
	  form.on('select(classselect)', function(data){
		  table.render({
			    elem: '#demo'
			    ,height: 471
			    ,page:false
			    ,url: 'Studentinfo?action=Pagingsclasss&zt=在读&sclasss='+data.value //数据接口
			    ,cellMinWidth: 120
			    ,cols: [[ //表头
			    	{type:'checkbox', fixed: 'left'}
			    	,{type:'numbers', title: '序号'}
					      ,{field: 'studentid', title: '学号',align:'center'}
					      ,{field: 'cName', title: '班级',align:'center'}
					      ,{field: 'sname', title: '姓名',align:'center'}
					      ,{field: 'ssex', title: '性别',align:'center'}
					      ,{field: 'snumber', title: '手机号码', align:'center'}
					      ,{field: 'sparentsNumber', title: '家长电话', align:'center'}
					      ,{field: 'sdate', title: '入学日期',align:'center'}
				    ]]
				  ,id:"idsw"
				  });
		});
		$.ajax({
			type:"get",
			url:"Classs?action=selectAll&cGstate=开学",//请求路径
			success:function(data){//请求成功后的事件
					$.each(data.data,function(index,obj){
						var option=$("<option value='"+obj.cId+"'>"+obj.cName+"</option>");
						$("#classselect").append(option);
						form.render(); 
					})
					
				}
			})
  //进行渲染
  table.render({
    elem: '#demo'
    ,height: 471
    ,page:true
    ,url: 'Studentinfo?action=select&zt=在读' //数据接口
    ,cellMinWidth: 120
    ,cols: [[ //表头
    	{type:'checkbox', fixed: 'left'}
    	,{type:'numbers', title: '序号'}
		      ,{field: 'studentid', title: '学号',align:'center'}
		      ,{field: 'cName', title: '班级',align:'center'}
		      ,{field: 'sname', title: '姓名',align:'center'}
		      ,{field: 'ssex', title: '性别',align:'center'}
		      ,{field: 'snumber', title: '手机号码', align:'center'}
		      ,{field: 'sparentsNumber', title: '家长电话', align:'center'}
		      ,{field: 'sdate', title: '入学日期',align:'center'}
	    ]]
	  ,id:"idsw"
	  });
	  
	});
	
	</script>
	<script>
	$("#snamesele").click(function(){
		 table.render({
			    elem: '#demo'
			    ,height: 471
			    ,page:false
			    ,url: 'Studentinfo?action=selectsname&zt=在读&sname='+$("#demoReload").val() //数据接口
			    ,cellMinWidth: 120
			    ,cols: [[ //表头
			    	{type:'checkbox', fixed: 'left'}
			    	,{type:'numbers', title: '序号'}
					      ,{field: 'studentid', title: '学号',align:'center'}
					      ,{field: 'cName', title: '班级',align:'center'}
					      ,{field: 'sname', title: '姓名',align:'center'}
					      ,{field: 'ssex', title: '性别',align:'center'}
					      ,{field: 'snumber', title: '手机号码', align:'center'}
					      ,{field: 'sparentsNumber', title: '家长电话', align:'center'}
					      ,{field: 'sdate', title: '入学日期',align:'center'}
				    ]]
				  ,id:"idsw"
				  });
	})
	$("#xzxy").click(function(){
		var checkStatus = table.checkStatus('idsw'),data = checkStatus.data;
		if(data.length>0){
			layer.confirm('需要重置密码,当前选中数量：'+ data.length, function(index){
				  var ins=[];
				  for(var i=0;i<data.length;i++){
					  ins[i]=data[i].studentid;
				  }
				  dele(ins,data.length);
				  layer.close(index);
			  })
		}else{
			layer.msg("请选择重置学生",{time: 1000});
		}
		  
	})
	function dele(datas,sum){
		$.ajax({
			url:"Studentinfo?action=deleteAll&data="+datas+"&sum="+sum
    		,success:function(data){
    			console.log(data);
    				layer.msg(data.msg,{time: 2000});
    				//重载
    				table.reload('idsw', {
    			        page: {
    			          curr: 1 //重新从第 1 页开始
    			        }
    				});
    		}
    	});
	}
	
	</script>
</body>
</html>