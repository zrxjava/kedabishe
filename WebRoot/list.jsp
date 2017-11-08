<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="utf-8">
<title>分页查询数据</title>
</head>
<body>
	<table border="1" width="80%" align="center" cellpadding="5" cellspacing="0">
		<tr>
			<th>序号</th>
			<th>员工编号</th>
			<th>姓名</th>
		</tr>
		<!-- 迭代数据 -->
		<c:choose>
			<c:when test="${not empty requestScope.pageBean.pageData }">
				<c:forEach var="emp" items="${requestScope.pageBean.pageData }" varStatus="vs">
					<tr>
						<td>${vs.count }</td>
						<td>${emp.empId }</td>
						<td>${emp.empName }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="3">对不起，没有数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="3" align="center">
				当前${requestScope.pageBean.currentPage }/${requestScope.pageBean.totalPage }页&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/EmployeeServlet?currentPage=1">首页</a>
				&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/EmployeeServlet?currentPage=${requestScope.pageBean.currentPage-1}">上一页</a>
				&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/EmployeeServlet?currentPage=${requestScope.pageBean.currentPage+1}">下一页</a>
				&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/EmployeeServlet?currentPage=${requestScope.pageBean.totalPage}">末页</a>
			</td>
		</tr>
	</table>
</body>
</html>