<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">

	$(function(){
		
		//发送请求，查询品牌与种类列表
		$.post("queryBrandAndKind",function(data){
			
			var brand = data.listBrand;
			var kind = data.listKind;
			
			var str = "";
			for(var i in brand){
				str+="<option value='"+brand[i].bid+"'>"+brand[i].bname+"</option>";
			}
			
			
			var kstr = "";
			for(var i in kind){
				kstr+="<option value='"+kind[i].kid+"'>"+kind[i].kname+"</option>";
			}
			
			
			$("#bid").html(str);
			$("#kid").html(kstr);
		})
		
		
	})

</script>
</head>
<body>

	<form action="add" method="post" enctype="multipart/form-data">
		商品名称：<input type="text" name="gname"><br><br>
		英文名称：<input type="text" name="ename"><br><br>
		商品品牌：<select id="bid" name="bid">
					<option value=""></option>
			  </select><br><br>
		商品种类：<select id="kid" name="kid">
		
			  </select><br><br>
		尺寸：<input type="text" name="size"><br><br>
		单价(元)：<input type="text" name="price"><br><br>
		数量：<input type="text" name="gnum"><br><br>
		标签：<input type="text" name="label"><br><br>
		商品图片上传:<input type="file" name="file"><br><br>
		<input type="submit" value="添加">
	</form>

</body>
</html>