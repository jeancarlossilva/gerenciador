<%@ page import="java.util.List"%>
<%@ page import="com.jeancaslv.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Standard Taglib</title>
</head>
<body>

		Lista de empresas: <br />
		
		
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				
				<li> ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>	 </li>
			
			</c:forEach>
		
		</ul>
	
		
</body>
</html>