<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	function del(id){
		if(confirm("确定要删除吗？")){
			
			$.post("delGoods",{"gid":id},function(data){
				if(data){
					alert("删除成功!");
					location.reload();
				}
			})
		
		}
	}
	
	
	function deleteAll(){
		
		var id = $("[name='gid']:checked").map(function(){
			return $(this).val();
		}).get().join(",");
		
		 if(confirm("确定要删除吗？")){
			
			$.post("delGoods",{"gid":id},function(data){
				if(data){
					alert("删除成功!");
					location.reload();
				}
			})
		
		} 
	}
	
</script>
<script type="text/javascript">
	$(function(){
		//轮询事件
		$("#qx").toggle(function(){
			$("[name='gid']").attr("checked",true);
		},function(){
			$("[name='gid']").attr("checked",false);
		})
		
	})
</script>
</head>
<body>

	<table>
		<tr>
			<td colspan="15">
				<a href="add.jsp"><input type="button" value="添加"></a>
				<input type="button" value="批删" onclick="deleteAll()">
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" id="qx">
			</td>
			<td>编号</td>
			<td>商品名称</td>
			<td>英文名称</td>
			<td>商品图片</td>
			<td>价格</td>
			<td>尺寸</td>
			<td>数量</td>
			<td>所属品牌</td>
			<td>所属种类</td>
			<td>标签</td>
			<td>操作</td>
		</tr>
	
	<c:forEach items="${page.list }" var="g">
		<tr>
			<td>
				<input type="checkbox" value="${g.gid }" name="gid">
			</td>
			<td>${g.gid }</td>
			<td>${g.gname }</td>
			<td>${g.ename }</td>
			<td>
				<img alt="xx" src="lookImg?path=${g.picurl }" width="70px;" height="60px">
			</td>
			<td>${g.price }</td>
			<td>${g.size }</td>
			<td>${g.gnum }</td>
			<td>${g.bname }</td>
			<td>${g.kname }</td>
			<td>${g.label }</td>
			<td>
				<a href="queryGoodsById?id=${g.gid }"><input type="button" value="商品编辑"></a>
				<!-- <input type="button" value="商品详情"> -->
				<input type="button" value="删除" onclick="del('${g.gid}')">
			</td>
		</tr>
	</c:forEach>
	
	<tr>
		<td colspan="16">
			<a href="?pageNum=1">首页</a>
			<a href="?pageNum=${page.pageNum-1 <1 ? page.pageNum :page.pageNum-1 }">上一页</a>
			<a href="?pageNum=${page.pageNum+1 >page.pages ? page.pageNum :page.pageNum+1}">下一页</a>
			<a href="?pageNum=${page.pages }">尾页</a>
		</td>
	</tr>
	
	</table>


</body>
</html>