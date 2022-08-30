<%@page import="java.util.List"%>
<%@page import="com.jeancaslv.gerenciador.servlet.Empresa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<ul>
		
		<%
			List<Empresa> lista = (List<Empresa>) request.getAttribute("empresas");
			for(Empresa emp: lista) {
		%>		
			<li> <%=emp.getNome()%></li>
		<%	} %>
		
		</ul>
		
</body>
</html>