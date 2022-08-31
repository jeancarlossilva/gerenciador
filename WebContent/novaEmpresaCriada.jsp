<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	//scriptlet
	//String nomeEmpresa = (String) request.getAttribute("empresa");
	//System.out.println("Cadastro de empresa!");

%>
<html>

<body>
	
	<c:if test="${not empty empresa }">
		Empresa ${empresa} cadastrada com sucesso!
	</c:if>
	
	<c:if test="${empty empresa }">
		Nenhuma Empresa cadastrada com sucesso!
	</c:if>

	
</body>
</html>