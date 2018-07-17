<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%--<script type="text/javascript" src="<%=path%>/static/js/jquery.js"></script>--%>
<title>Insert title here</title>
</head>
<body>
	<h1>cmpyinfo list</h1>
	<%--<button onclick="getCmpy(1)">获取企业信息</button>
	<p id="cmpyinfo"></p>--%>
</body>
<%--<script type="text/javascript">
	function getCmpy(id){
		$.ajax({
			type:"post",
			url:"<%=path%>/a/cmpy/"+id,
			success:function(data){
				console.log(data);
				$("#cmpyinfo").text(data.cmpname);
			},error:function(data){
				$("#cmpyinfo").text(data);
			}
		});
	}
</script>--%>
</html>