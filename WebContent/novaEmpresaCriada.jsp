<%
	//scriptlet
	String nomeEmpresa = (String) request.getAttribute("empresa");
	System.out.println("Cadastro de empresa!");

%>
<html>

<body>
	Empresa <%=nomeEmpresa%> cadastrada com sucesso!
</body>
</html>