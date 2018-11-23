<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教员信息</title>
<meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="js/layui/css/layui.css"  media="all">
  <script src="js/layui/layui.js" charset="utf-8"></script>
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
.rigtop { width: 1143px; height: 40px;border: 1px solid #b7d5df;line-height: 40px;margin:auto;margin-top:5px;}
.layui-btns {width: 100px;height: 32px;line-height: 32px;position:relative;top:1px;float:right;border-radius: 20px;background-color:#1E9FFF;}
.divtable{width:1145px;margin:auto;margin-top:-5px;}
.input{width:160px;}
#demo1{width: 150px;height: 170px;}
#tp{position:absolute;left:820px;top: 30px;}
.rig{width:1155px;}
.layui-textarea {min-height: 65px;min-width:455px;}
.layui-form-select dl{height:150px;}
.layui-form-label{width:55px;}
#form{height:300px;}
#xzxy{position:relative;top:4px;}
#forms{height:200px; text-align:center;}
</style>
	</head>
	<body>  
		<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="#">首页</a></li>
	    <li><a href="#">学员管理</a></li>
	    <li><a href="#">学员信息</a></li>
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
	    <button class="layui-btn layui-btns layui-btn-normal"  id="xzxy">导出xls</button>
	    </div>
	    </div>
	  
	 <div class="divtable">
<table id="demo" lay-filter="demo"  ></table>
</div>
<form class="layui-form" style="background-color: ghostwhite;" id="forms" hidden="hidden">
<br/>
<br/>
<br/>
			      <label style="font-size:16px;">转学日期:</label>
			     <div class="layui-input-inline" >
	 <input type="text" name="dates" id="dates" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input input">
			      </div>
		 <label style="font-size:16px;"><br/><br/>是否将该学生设为毕业<br/>设置后不可更改<br/>请谨慎</label>
			   
</form>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">详细</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">转学</a>
</script>
<script>
//进行按班级查询
var form
layui.use('form', function(){
  form= layui.form;
  form.on('select(classselect)', function(data){
	  table.render({
		    elem: '#demo'
		    ,height: 471
		    ,page:false
		    ,url: 'Studentinfo?action=Pagingsclasss&zt=在读&sclasss='+data.value //数据接口
		    ,cellMinWidth: 120
		    ,cols: [[ //表头
		    	{type:'numbers', title: '序号'}
				      ,{field: 'studentid', title: '学号',align:'center'}
				      ,{field: 'cName', title: '班级',align:'center'}
				      ,{field: 'sname', title: '姓名',align:'center'}
				      ,{field: 'ssex', title: '性别',align:'center'}
				      ,{field: 'snumber', title: '手机号码', align:'center'}
				      ,{field: 'sparentsNumber', title: '家长电话', align:'center'}
				      ,{field: 'sdate', title: '入学日期',align:'center'}
				      ,{field: 'right', title: '操作',width:'178', align:'center',  toolbar: '#barDemo'}
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
		
});
layui.use('laydate', function(){
	  laydate = layui.laydate;
	  laydate.render({
	    elem: '#dates'
	  });
	});
var table=null;
layui.use('table', function(){
	table= layui.table;
	var index = layer.load(2, {time: 100}); 
	//监听工具条
	table.on('tool(demo)', function(obj){
	  var data = obj.data;
	  if(obj.event === 'detail'){
		$("#studentid").html(data.studentid),
		$("#sclasss").html(data.cName),
		$("#sname").html(data.sname),
		$("#ssex").html(data.ssex),
		$("#snational").html(data.snational),
		$("#sdate").html(data.sdate),
		$("#scard").html(data.scard),
		$("#snativeplace").html(data.snativeplace),
		$("#saddress").html(data.saddress),
		$("#sparentsname").html(data.sparentsName),
		$("#sparentsnumber").html(data.sparentsNumber),
		$("#sface").html(data.sface),
		$("#snumber").html(data.snumber),
		$("#sentrancedate").html(data.sentranceDate),
		$("#sqq").html(data.sqq),
		$("#demo1").attr("src","stuimage/"+data.spicture),
		$("#snote").html(data.snote),
	    upda(data.stuId);
	  } else if(obj.event === 'del'){
	    	del(data.studentid);
	  } 
	});
  //进行渲染
  table.render({
    elem: '#demo'
    ,height: 471
    ,page:true
    ,url: 'Studentinfo?action=select&zt=在读' //数据接口
    ,cellMinWidth: 120
    ,cols: [[ //表头
    	{type:'numbers', title: '序号'}
		      ,{field: 'studentid', title: '学号',align:'center'}
		      ,{field: 'cName', title: '班级',align:'center'}
		      ,{field: 'sname', title: '姓名',align:'center'}
		      ,{field: 'ssex', title: '性别',align:'center'}
		      ,{field: 'snumber', title: '手机号码', align:'center'}
		      ,{field: 'sparentsNumber', title: '家长电话', align:'center'}
		      ,{field: 'sdate', title: '入学日期',align:'center'}
		      ,{field: 'right', title: '操作',width:'178', align:'center',  toolbar: '#barDemo'}
	    ]]
	  ,id:"idsw"
	  });
	  
	});
		//删除操作
		 function del(Studentid){
			 layer.open({
					type:1
					,title:"转学时间"
					,content:$("#forms")
					,area:['500px','300px']
					,shade:0.5
					 ,offset: [ //为了演示，随机坐标
				         50
				          ,300
				        ]
				 ,btn: ['确定', '取消'] 
			    ,yes: function(){
			    	layer.confirm('转学设为毕业状态,是否继续?', function(index){
			    	$.ajax({
			    		type:"get"
			    			,url:"Studentinfo?action=upzx"
			    		,data:{
			    			Studentid:Studentid,//毕业id
			    			Sxsj:$("#dates").val()
			    			}
			    		,success:function(data){
			    			if(data>0){
			    				//关闭
			    				 layer.closeAll();
			    				layer.msg("修改成功");
			    				//重载
			    				table.reload('idsw', {
			    			        page: {
			    			          curr: 1 //重新从第 1 页开始
			    			        }
			    				});
			    				//清空
			    				empty();
			    				}
			    			else{
			    				layer.msg("修改失败");
			    			}
			    		} 
			    	});
			    });
			    }
			    ,btn2: function(){
			      layer.closeAll();
			      empty();
			    },cancel: function(index, layero){ 
			    	empty();
			   	 layer.closeAll();
			   		  return false; 
			   		} 
				});
			
		}
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
			    	{type:'numbers', title: '序号'}
					      ,{field: 'studentid', title: '学号',align:'center'}
					      ,{field: 'cName', title: '班级',align:'center'}
					      ,{field: 'sname', title: '姓名',align:'center'}
					      ,{field: 'ssex', title: '性别',align:'center'}
					      ,{field: 'snumber', title: '手机号码', align:'center'}
					      ,{field: 'sparentsNumber', title: '家长电话', align:'center'}
					      ,{field: 'sdate', title: '入学日期',align:'center'}
					      ,{field: 'right', title: '操作',width:'178', align:'center',  toolbar: '#barDemo'}
				    ]]
				  ,id:"idsw"
				  });
	})
	$("#xzxy").click(function(){
		var head=[];
		$('table thead tr th span').each(function(index,obj){
			head[index]=$(this).html();
		})
		window.location.href="Studentinfo?action=file&head="+head;
			});
	</script>
	<script>
function upda(stuId){
	layer.open({
		type:1
		,title:"详细信息"
		,content:$("#form2")
		,area:['1000px','400px']
		,shade:0.5
	 ,btn: ['返回'] 
    ,yes: function(){
    	 layer.closeAll();
    	 empty();
    },cancel: function(index, layero){ 
    	empty();
      	 layer.closeAll();
      		  return false; 
      		} 
	});
}
function empty(){
	 $("#form2").attr("hidden","hidden").css("display","none");
	 $("#forms").attr("hidden","hidden").css("display","none");
}
</script>
	<form class="layui-form" style="background-color: ghostwhite;" id="form2" hidden="hidden">
	<table cellspacing="5" cellpadding="5" width="790px" height="280px" style="margin-left: 30px;" id="tabcx">
	<tr><td><div style="height:30px"></div></td></tr>
		<tr>
			<td style="text-align-last:justify;">
			    <label style="font-size:16px;">学号:</label></td><td><label style="font-size:14px;" id="studentid">2991489382</label>
			 </td>
			 <td style="text-align-last:justify;">
			   <label style="font-size:16px;">姓名:</label></td><td><label style="font-size:14px;" id="sname">梁光健</label>
			 </td>
			 <td style="text-align-last:justify;">
			       <label style="font-size:16px;">身份证:</label></td><td> <label style="font-size:14px;" id="scard">452226199909022115</label>
			 </td>
		</tr>
		<tr>
			<td style="text-align-last:justify;">
			       <label style="font-size:16px;">性别:</label></td><td> <label style="font-size:14px;" id="ssex">男</label>
			 </td>
			 <td style="text-align-last:justify;">
			     <label style="font-size:16px;"> 民族:</label></td><td><label style="font-size:14px;" id="snational">壮族</label>
			 </td>
			 <td style="text-align-last:justify;">
			    <label style="font-size:16px;">出生日期:</label></td><td><label style="font-size:14px;" id="sdate">19990902</label>
			 </td>
		</tr>
		<tr>
			<td style="text-align-last:justify;">
			    <label style="font-size:16px;">班级:</label></td><td><label style="font-size:14px;" id="sclasss">S143</label>
			 </td>
			 <td style="text-align-last:justify;">
			      <label style="font-size:16px;">籍贯:</label></td><td><label style="font-size:14px;" id="snativeplace">中国</label>
			 </td>
			 <td style="text-align-last:justify;">
			   <label style="font-size:16px;"> 家庭住址:</label></td><td><label style="font-size:14px;" id="saddress">广西来宾</label>
			 </td>
		</tr>
		<tr>
			<td style="text-align-last:justify;">
			      <label style="font-size:16px;"> 家长姓名:</label></td><td> <label style="font-size:14px;" id="sparentsname">梁先生</label>
			 </td>
			 <td style="text-align-last:justify;">
			     <label style="font-size:16px;">家长电话:</label></td><td><label style="font-size:14px;" id="sparentsnumber">18473857392</label>
			 </td>
			 <td style="text-align-last:justify;">
			     <label style="font-size:16px;"> 政治面貌:</label></td><td><label style="font-size:14px;" id="sface">群众</label>
			 </td>
		</tr>
		<tr>
			<td style="text-align-last:justify;">
			     <label style="font-size:16px;">手机号码:</label></td><td> <label style="font-size:14px;" id="snumber">13016381702</label>
			 </td>
			 <td style="text-align-last:justify;">
			    <label style="font-size:16px;">入学时间:</label></td><td><label style="font-size:14px;" id="sentrancedate">2017-07-01</label>
			 </td>
			 <td style="text-align-last:justify;">
			   <label style="font-size:16px;">QQ号码:</label></td><td><label style="font-size:14px;" id="sqq">2361928131</label>
			 </td>
		</tr>
		<tr>
			<td style="text-align-last:justify;">
			     <label style="font-size:16px;">备注:</label></td><td style="width:150px"><label style="font-size:14px;" width="640" id="snote">案发时可接受的21898317239</label>
			</td>
		</tr>
		<tr>
			<td><div id="tp">		
		 	<div id="divimg"><img class="layui-upload-img" id="demo1"></div><br/>
		  </div></td>
		</tr>
	</table>
</form>
</body>
</html>