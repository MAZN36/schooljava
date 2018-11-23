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
.rigtop { width: 1143px; height: 40px;border: 1px solid #b7d5df;line-height: 40px;margin:auto;margin-top:5px;}
.layui-btns {width: 100px;height: 32px;line-height: 32px;position:relative;top:1px;float:right;border-radius: 20px;background-color:#1E9FFF;}
.divtable{width:1145px;margin:auto;margin-top:-5px;}
.input{width:160px;}
#demo1{width: 150px;height: 170px;}
#tp{position:absolute;left:720px;top: 30px;}
.rig{width:1155px;}
.layui-textarea {min-height: 65px;min-width:455px;}
.item {width: 800px;margin-bottom: 15px; clear: both;}
.layui-form-select dl{height:150px;}
.layui-form-label{width:55px;}
#form{height:300px;}
#xzxy{position:relative;top:4px;}
</style>
	</head>
	<body>  
		<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="#">首页</a></li>
	    <li><a href="#">教员管理</a></li>
	    <li><a href="#">教员信息</a></li>
	    </ul>
	    </div>
	    <div class="rigtop">
	   	<div class="layui-form-item layui-form" >
	    <div class="layui-inline" >
	      <label class="layui-form-label" style="width: 28px;">职位:</label>
	      <div class="layui-input-inline">
	        <select name="quiz" lay-verify="tPosition" lay-search="" lay-filter="tPosition" id="tPosition">
	          <option value="">请选择职位</option>
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
<table id="demo" lay-filter="demo" lay-filter="test"></table>
</div>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">详细</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">离职</a>
</script>
	<script src="js/layui/layui.js" charset="utf-8"></script>
	<script>
	 var form=null;
	var table=null;
	layui.use(['table','form'], function(){
		form= layui.form;
		table= layui.table;
		var index = layer.load(2, {time: 100}); 
		$.ajax({
			type:"get",
			url:"Position?action=selectAll",//请求路径
			success:function(data){//请求成功后的事件
					$.each(data.data,function(index,obj){
						var option=$("<option value='"+obj.pid+"'>"+obj.pname+"</option>");
						$("#tPosition").append(option);
						form.render(); 
					})
				}
			})
			
		
		table.render({
		    elem: '#demo'
		    ,height: 471
		    ,page:true
	    ,url: 'Teacher?action=select&zw=在职' //数据接口
	    ,cols: [[ //表头
	      {type:'numbers', title: '序号', sort: true}
	      ,{field: 'tjnumber', title: '工号', sort: true ,align:'center'}
	      ,{field: 'tname', title: '姓名',align:'center'}
	      ,{field: 'tsex', title: '性别',align:'center'}
	      ,{field: 'tbirthday', title: '出生日期',align:'center'}
	      ,{field: 'pName', title: '职位',align:'center'}
	      ,{field: 'ttelephone', title: '联系电话',align:'center'}
	      ,{field: 'right', title: '操作', align:'center',  toolbar: '#barDemo'}
	    ]]
	  ,id:"idsw"
	  });
		 form.on('select(tPosition)', function(data){
			  table.render({
				    elem: '#demo'
				    ,height: 471
				    ,page:false
				    ,url: 'Teacher?action=PagingtPosition&zw=在职&tPosition='+data.value //数据接口
				    ,cellMinWidth: 120
				    ,cols: [[ //表头
				    	{type:'checkbox', fixed: 'left'}
					      ,{type:'numbers', title: '序号', sort: true}
					      ,{field: 'tjnumber', title: '工号', sort: true}
					      ,{field: 'tname', title: '姓名'}
					      ,{field: 'tsex', title: '性别',align:'center'}
					      ,{field: 'tbirthday', title: '出生日期',align:'center'}
					      ,{field: 'pName', title: '职位',align:'center'}
					      ,{field: 'ttelephone', title: '联系电话',align:'center'}
					    ]]
					  ,id:"idsw"
					  });
			});
		 //监听工具条
		  table.on('tool(demo)', function(obj){
		    var data = obj.data;
		    if(obj.event === 'detail'){
		    	$("#tJNumber").html(data.tjnumber),
		    	$("#tName").html(data.tname),
		    	$("#tsex").html(data.tsex),
		    	$("#tBirthday").html(data.tbirthday),
		    	$("#pName").html(data.pName),
		    	$("#tTelephone").html(data.ttelephone),
		    	$("#tNation").html(data.tnation),
		    	$("#tPolitical").html(data.tpolitical),
		    	$("#tid_card").html(data.tid_card),
		    	$("#tEducation").html(data.teducation),
		    	$("#tHome").html(data.thome),
		    	$("#tNative").html(data.tnative),
		    	$("#img").html(data.img),
		    	$("#tnote").html(data.tnote),
		    	$("#demo1").attr("src","teaimage/"+data.img);
			    upda(data.Tid);
			  } else if(obj.event === 'del'){
		      layer.confirm('确定离职?', function(index){
		    	  del(data.tid);
		      });
		    } else if(obj.event === 'edit'){
		      layer.alert('编辑行：<br>'+ JSON.stringify(data))
		    }
		  });
	});
	</script>
<script>
function del(Tid){
	$.ajax({
		type:"get"
		,url:"Teacher?action=updaid"
		,data:{Tid:Tid,SState:"离职"}
		,success:function(data){
			if(data>0){
				//关闭
  				 layer.closeAll();
				layer.msg("修改成功",{time: 1000});
				//重载
				table.reload('idsw', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			        }
				});
			}
			else{
				layer.msg("修改失败",{time: 1000});
			}
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
			    ,url: 'Teacher?action=selectsname&zw=在职&tname='+$("#demoReload").val() //数据接口
			    ,cellMinWidth: 120
			    ,cols: [[ //表头
			    	{type:'numbers', title: '序号'}
				     ,{field: 'tjnumber', title: '工号', sort: true}
				      ,{field: 'tname', title: '姓名'}
				      ,{field: 'tsex', title: '性别',align:'center'}
				      ,{field: 'tbirthday', title: '出生日期',align:'center'}
				      ,{field: 'pName', title: '职位',align:'center'}
				      ,{field: 'ttelephone', title: '联系电话',align:'center'}
				      ,{field: 'right', title: '操作', align:'center',  toolbar: '#barDemo'}
				    ]]
				  ,id:"idsw"
				  });
	})
	$("#xzxy").click(function(){
		var head=[];
		$('table thead tr th div span:first-child').each(function(index,obj){
			head[index]=$(this).text();
		})
		window.location.href="Teacher?action=file&head="+head;
			});
</script>
<script>
function upda(Tid){
	layer.open({
		type:1
		,title:"详细信息"
		,content:$("#form")
		,area:['900px','400px']
		,shade:0.5
	 ,btn: ['确定'] 
    ,yes: function(){
    	layer.closeAll();
    	empty()
    },cancel: function(index, layero){ 
    	empty();
      	 layer.closeAll();
      		  return false; 
      		} 
	});
}
function empty(){
	 $("#form").attr("hidden","hidden").css("display","none");
}
</script>
<form class="layui-form" style="background-color: ghostwhite;" id="form" hidden="hidden">
	<table cellspacing="0" cellpadding="0" width="690px" height="280px" style="margin-left: 30px;">
	<tr><td><div style="height:30px"></div></td></tr>
		<tr>
			<td style="text-align-last:justify;">
			    <label style="font-size:16px;">工号:</label></td><td> <label style="font-size:14px;" id="tJNumber">8737238728</label>
			 </td>
			 
			 <td style="text-align-last:justify;">
			  <label style="font-size:16px;">姓名:</label></td><td><label style="font-size:14px;" id="tName">梁光健</label>
			 </td>
			 <td style="text-align-last:justify;">
			 <label style="font-size:16px;">身份证:</label></td><td><label style="font-size:14px;" id="tid_card">45222619990902115</label>
			 </td>
		</tr>
		<tr>
			<td style="text-align-last:justify;">
			  <label style="font-size:16px;"> 职位:</label></td><td> <label style="font-size:14px;" id="pName">体育老师</label>
			 </td>
			 <td style="text-align-last:justify;">
			  <label style="font-size:16px;">民族:</label></td><td><label style="font-size:14px;" id="tNation">壮族</label>
			 </td>
			 <td style="text-align-last:justify;">
			 <label style="font-size:16px;"> 出生日期:</label></td><td> <label style="font-size:14px;" id="tBirthday">1999-09-02</label>
			 </td>
		</tr>
		<tr>
			<td style="text-align-last:justify;">
			  <label style="font-size:16px;"> 籍贯:</label></td><td><label style="font-size:14px;" id="tNative">中国</label>
			 </td>
			 <td style="text-align-last:justify;">
			  <label style="font-size:16px;">性别:</label></td><td><label style="font-size:14px;" id="tsex">男</label>
			 </td>
			 <td style="text-align-last:justify;">
			 <label style="font-size:16px;"> 家庭住址:</label></td><td> <label style="font-size:14px;" id="tHome">广西来宾</label>
			 </td>
		</tr>
		<tr>
			<td style="text-align-last:justify;">
			   <label style="font-size:16px;">学历:</label></td><td><label style="font-size:14px;" id="tEducation">大专</label>
			 </td>
			 <td style="text-align-last:justify;">
			<label style="font-size:16px;">电话号码:</label></td><td><label style="font-size:14px;" id="tTelephone">13016381702</label>
			 </td>
			 <td style="text-align-last:justify;">
			<label style="font-size:16px;"> 政治面貌:</label></td><td><label style="font-size:14px;" id="tPolitical">群众</label>
			 </td>
		</tr>
  		
		<tr>
			<td style="text-align-last:justify;">
			   <label style="font-size:16px;"> 备注:</label></td><td style="width:150px"><label style="font-size:14px;" width="640" id="tnote">案发时可接受的21898317239</label>
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