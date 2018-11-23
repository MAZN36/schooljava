<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style1.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<title>Insert title here</title>
<style>
td {
    font-family: 宋体;
    font-size: 9pt;
    table-layout: fixed;
    word-break: break-all;
}table,td{
    border:1px solid #b7d5df;
    text-align:center;
}
</style>
</head>
<body >
	<table id="tables" width="100%" border='1' cellspacing='0' cellpadding='0' >
		<tr>
			<td width="15%" align="center" >部门</td>
			<td width="15%" align="center">姓名</td>
			<td width="15%" align="center">职务</td>
			<td align="center" width="15%">办公电话</td>
			<td align="center" width="20%">电子邮箱</td>
			<td align="center" width="25%">岗位备注</td>
		</tr>
	</table>
</body>
<script>
	$.ajax({
		url:'Adm?action=selectAll'
		,success:function(data){
			$.each(data.data,function(index,obj){
				var tr=$("<tr/>");
				$("<td/>").html(obj.department).appendTo(tr);
				$("<td/>").html(obj.adname).appendTo(tr);
				$("<td/>").html(obj.adpost).appendTo(tr);
				$("<td/>").html(obj.adphone).appendTo(tr);
				$("<td/>").html(obj.mailbox).appendTo(tr);
				$("<td/>").html(obj.adNote).appendTo(tr);
				$("#tables").append(tr);
			})
		}
	})
</script>
</html>