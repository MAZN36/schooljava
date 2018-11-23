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
.layui-btns {width: 100px;height: 32px;line-height: 32px;position:relative;float:right;border-radius: 20px;top:5px}
.divtable{width:1145px;margin:auto;margin-top:-5px;}
.input{width:190px;}
.layui-textarea {min-height: 65px;min-width:455px;}
.item {width: 680px;margin-bottom: 15px; clear: both;}
.layui-form-select dl{height:150px;}
.layui-form-label{width:55px;}
#form,#form2,#form3{height:300px;}
#forms{height:200px; text-align:center;}
</style>
</head>
<body>  
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">年级管理</a></li>
    <li><a href="#">年级信息</a></li>
    </ul>
    </div>
    <div class="rigtop">
    	<div class="layui-form-item layui-form" >
     <div class="layui-inline" >
	      <label class="layui-form-label">年级名称:</label>
	      <div class="layui-input-inline">
	        <select name="quiz" lay-verify="classselect" lay-search="" lay-filter="classselect" id="classselect"  >
	          <option value="">请选择</option>
	        </select>
	      </div>
	    </div>
  <button class="layui-btn layui-btn-normal layui-btns"  id="subs">新增班级</button>
    </div>
    </div>
    <div class="divtable">
<table id="demo" lay-filter="demo" lay-filter="test"></table>
</div>
<form class="layui-form" style="background-color: ghostwhite;" id="form" hidden="hidden">
	<table style="text-align:center">
	<tr><td><div style="height:30px"></div></td></tr>
		<tr>
			<td><div class="item">
			    <label style="font-size:16px;margin-left: -15px;">年级名称:</label>
			      <div class="layui-input-inline input">
			      <select name="quiz" lay-verify="classselect" lay-search="" lay-filter="cTypeName" id="cTypeName"  >
			          <option value="">请选择</option>
			       </select>
			      </div>
			      <label style="font-size:16px;">开班日期:</label>
			     <div class="layui-input-inline">
			        <input type="text" name="cGtime" id="cGtime" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input input">
			      </div>
			      </div></td>
		</tr>
		<tr>
			<td><div class="item">
			    <label style="font-size:16px;">班主任:</label>
			      <div class="layui-input-inline input">
			<select name="modules" id="cTeacher" lay-verify="required" lay-search="">
			        <option>请选择</option>
			        </select>
			      </div>
			      <label style="font-size:16px">班级名称:</label>
			      <div class="layui-input-inline">
			        <input type="text" name="cName" id="cName" lay-verify="required|phone" class="layui-input  input" >
			
			      </div>
			      </div>
			   </td>
		</tr>
		
		<tr>
			<td><div class="item">
			    <label style="font-size:16px;margin-left: 15px;">备注:</label>
			    <div class="layui-input-inline">
			      <textarea placeholder="请输入内容" id="cNote" class="layui-textarea"></textarea>
			    </div>
			  </div></td>
		</tr>
	</table>
</form>
<form class="layui-form" style="background-color: ghostwhite;" id="forms" hidden="hidden">
<br/>
<br/>
<br/>
			      <label style="font-size:16px;">毕业日期:</label>
			     <div class="layui-input-inline" >
	 <input type="text" name="dates" id="dates" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input input">
			      </div>
		 <label style="font-size:16px;"><br/><br/>是否将该班级学生以及班级设为毕业<br/>设置后不可更改<br/>请谨慎！！！</label>
			   
</form>
<form class="layui-form" style="background-color: ghostwhite;" id="form2" hidden="hidden">
	<table style="text-align:center">
	<tr><td><div style="height:30px"></div></td></tr>
		<tr>
			<td><div class="item">
			    <label style="font-size:16px" id="bjs">当前所在班级:</label>
			      </div></td>
		</tr>
		<tr>
			<td>
			
			<div class="item">
			<label style="font-size:16px;margin-left: -30px;">升学至:</label>
			      <div class="layui-input-inline input">
		        	<select name="quiz" lay-verify="cals" lay-search="" lay-filter="cals" id="cals">
		          <option>请选择班级</option>
		        </select>
		      </div>
			<label style="font-size:16px">升学时间:</label>
			      <div class="layui-input-inline" >
			          <input type="text" class="layui-input" id="test1" placeholder="yyyy-MM-dd">

			 </div>
			 </div></td>
		</tr>
		<tr>
			<td><div class="item">
			    <label style="font-size:16px">备注:</label>
			    <div class="layui-input-inline">
			      <textarea placeholder="请输入内容" class="layui-textarea" id="sxbz"></textarea>
			    </div>
			  </div></td>
		</tr>
	</table>
</form>
<form class="layui-form" style="background-color: ghostwhite;" id="form3" hidden="hidden">
	<table style="text-align:center">
	<tr><td><div style="height:30px"></div></td></tr>
		<tr>
			<td><div class="item">
			    <label style="font-size:16px;margin-left: -15px;">年级名称:</label>
			      <div class="layui-input-inline input">
			        <input type="text" name="quiz" id="TypeName" lay-verify="required|phone" class="layui-input  input" disabled="true ">
			      </div>
			      <label style="font-size:16px;">开班日期:</label>
			     <div class="layui-input-inline">
			        <input type="text" name="Gtime" id="Gtime" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input input" disabled="true ">
			      </div>
			      </div></td>
		</tr>
		<tr>
			<td><div class="item">
			    <label style="font-size:16px;">班主任:</label>
			      <div class="layui-input-inline input">
					<select name="Teacher" id="Teacher" lay-verify="required" lay-search="">
			        <option>请选择</option>
			        </select>
			      </div>
			      <label style="font-size:16px">班级名称:</label>
			      <div class="layui-input-inline input">
			        <input type="text" name="quiz" id="bjmc" lay-verify="required|phone" class="layui-input  input" >
			      </div>
			      </div>
			   </td>
		</tr>
		<tr>
			<td><div class="item">
			    <label style="font-size:16px;margin-left: 15px;">备注:</label>
			    <div class="layui-input-inline">
			      <textarea placeholder="请输入内容" id="Note" class="layui-textarea"></textarea>
			    </div>
			  </div></td>
		</tr>
	</table>
</form>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">升学</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">毕业</a>
</script>

<script>
layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  //常规用法
	  laydate.render({
	    elem: '#test1'
	  });
})
var table=null;
var form=null;
layui.use(['table','form'], function(){
	table= layui.table;
	form= layui.form;
	
	var index = layer.load(2, {time: 300}); 
	//加载年级
	$.ajax({
		type:"get",
		url:"Grade?action=selectAll",//请求路径
		success:function(data){//请求成功后的事件
				$.each(data.data,function(index,obj){
					var option=$("<option value='"+obj.gid+"'>"+obj.gname+"</option>");
					$("#classselect").append(option);
				})
				$.each(data.data,function(index,obj){
					var option=$("<option value='"+obj.gid+"'>"+obj.gname+"</option>");
					$("#cTypeName").append(option);
					
				})
				form.render(); 
			}
		})
		//加载班主任
		$.ajax({
		type:"get",
		url:"Teacher?action=PagingtPosition&zw=在职&tPosition=1",//请求路径
		success:function(data){//请求成功后的事件
				$.each(data.data,function(index,obj){
					var option=$("<option value='"+obj.tid+"'>"+obj.tname+"</option>");
					$("#cTeacher").append(option);
					
					form.render(); 
				})
				$.each(data.data,function(index,obj){
					var option=$("<option value='"+obj.tid+"'>"+obj.tname+"</option>");
				
					$("#Teacher").append(option);
					form.render(); 
				})
				
			}
		})
		
		//班级加载
		 $.ajax({
		type:"get",
		url:"Classs?action=selectAll&cGstate=开学",//请求路径
		success:function(data){//请求成功后的事件
				$.each(data.data,function(index,obj){
					var option=$("<option value='"+obj.cId+"'>"+obj.cName+"</option>");
					$("#cals").append(option);
					form.render(); 
				})
				$.each(data.data,function(index,obj){
					var option=$("<option value='"+obj.cId+"'>"+obj.cName+"</option>");
					$("#Name").append(option);
					form.render(); 
				})
			}
		})
		 //第一
  table.render({
    elem: '#demo'
    ,height: 471
    ,page:true
    ,url: 'Classs?action=select&cGstate=开学' //数据接口
    ,cols: [[ //表头
    	{type:'numbers', title: '序号'}
        ,{field: 'gName', title: '年级名称',align:'center'}
        ,{field: 'cName', title: '班级名称',align:'center'}
        ,{field: 'tName', title: '班主任',align:'center'}
        ,{field: 'cPhone', title: '电话号码',align:'center'}
      ,{field: 'cou', title: '总人数',align:'center'}
      ,{field: 'cGtime', title: '开班时间',align:'center'}
      ,{field: 'right', title: '操    作', align:'center',  toolbar: '#barDemo'}
    ]],
    id:"idsw"
  });
		form.on('select(classselect)', function(data){
			  table.render({
				    elem: '#demo'
				    ,height: 471
				    ,page:false
				    ,url: 'Classs?action=finAlltPosition&cGstate=开学&cTypeName='+data.value //数据接口
				    ,cols: [[ //表头
				    	{type:'numbers', title: '序号'}
				        ,{field: 'gName', title: '年级名称',align:'center'}
				        ,{field: 'cName', title: '班级名称',align:'center'}
				        ,{field: 'tName', title: '班主任',align:'center'}
				        ,{field: 'cPhone', title: '电话号码',align:'center'}
				      ,{field: 'cou', title: '总人数',align:'center'}
				      ,{field: 'cGtime', title: '开班时间',align:'center'}
				      ,{field: 'right', title: '操    作', align:'center',  toolbar: '#barDemo'}
					    ]]
					  ,id:"idsw"
					  });
			}); 
 
//监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
    	$("#bjs").html("当前所在班级:"+data.cName);
    	upda(data.cId,data.cName);
    } else if(obj.event === 'del'){
    	ups(data.cId,data.cName);
    
    } else if(obj.event === 'edit'){
        $("#TypeName").val(data.gName),
        $("#Gtime").val(data.cGtime),
        $("#bjmc").val(data.cName),
        $("#Teacher").val(data.tid);
      $('#Teacher').find('option').each(function(){
            $(this).attr('selected',$(this).val()==data.tid);
       				});
  $('#bookType').next().children().eq(0).children().eq(0).val($('#bookType').find("option:selected").text());
        //找到ID的下一步元素，的子元素，的第一个，的子元素，的第一个，设置他得值为当前应该选中的值
        form.render(); 
        update(data.cId);
  }
  });
})
 

</script>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //日期
  laydate.render({
    elem: '#cGtime'
  });
  laydate.render({
    elem: '#date1'
  });
  laydate.render({
    elem: '#dates'
  });
});

</script>
<script>
function upda(id,e){
			 layer.open({
					type:1
					,title:"升学信息"
					,content:$("#form2")
					,area:['700px','400px']
					,shade:0.5
					 ,offset: [ //为了演示，随机坐标
				         50
				          ,300
				        ]
				 ,btn: ['升学', '取消'] 
			    ,yes: function(){
			    	layer.load(1);
			    	
			    	$.ajax({
			    		type:"post"
			    		,url:"Sxcalss?action=addAll"
			    		,data:{
			    			Sxqbjid:id,//升学前id
			    			Sxqbj:e,//升学前班级名称
			    			Sxhbj:$("#cals").val(),
			    			Sxsj:$("#test1").val(),
			    			Bz:$("#sxbz").val()
			    			}
			    		,success:function(data){
			    			setTimeout(function(){
					    	    layer.closeAll('loading');
					    	});
			    			if(data>0){
			    				//关闭
			    				 layer.closeAll();
			    				layer.msg("升学成功");
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
			    				layer.msg("升学失败");
			    			}
			    		}
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
function ups(id,e){
	layer.open({
		type:1
		,title:"毕业时间"
		,content:$("#forms")
		,area:['500px','300px']
		,shade:0.5
	 ,btn: ['确定', '取消'] 
    ,yes: function(){
    	layer.load(1);
    	$.ajax({
    		type:"get"
    			,url:"Sxcalss?action=addby"
    		,data:{
    			Sxqbjid:id,//毕业id
    			Sxsj:$("#dates").val(),
    			Sxqbj:e,//升学前班级名称
    			}
    		,success:function(data){
    			setTimeout(function(){
		    	    layer.closeAll('loading');
		    	});
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
function update(cId){
	layer.open({
		type:1
		,title:"编辑信息"
		,content:$("#form3")
		,area:['700px','400px']
		,shade:0.5
	 ,btn: ['修改', '取消'] 
    ,yes: function(){
    	$.ajax({
    		type:"get"
    		,url:"Classs?action=updatexx"
    		,data:{
    			CName:$("#bjmc").val(),
    			CTeacher:$("#Teacher").val(),
    			CNote:$("#Note").val(),
    			CId:cId
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

$("#subs").click(function(){
	layer.open({
		type:1
		,title:"添加班级"
		,content:$("#form")
		,area:['700px','400px']
		,shade:0.5
	 ,btn: ['添加', '取消'] 
    ,yes: function(){
    	$.ajax({
    		type:"get"
    		,url:"Classs?action=add"
    		,data:{
    			CName:$("#cName").val(),
    			CTypeName:$("#cTypeName").val(),
    			CTeacher:$("#cTeacher").val(),
    			CGtime:$("#cGtime").val(),
    			CNote:$("#cNote").val(),
    			}
    		,success:function(data){
    			if(data>0){
    				//关闭
    				 layer.closeAll();
    				layer.msg("添加成功");
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
    				layer.msg("添加失败");
    			}
    		}
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
	});
function empty(){
	 $("#form2").attr("hidden","hidden").css("display","none");
	 $("#form").attr("hidden","hidden").css("display","none");
	 $("#forms").attr("hidden","hidden").css("display","none");
	 $("#form3").attr("hidden","hidden").css("display","none");
	$("#cName").val("");
	$("#cNote").val("");
}
</script>

</body>
</html>