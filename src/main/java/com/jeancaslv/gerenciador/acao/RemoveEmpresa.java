package com.jeancaslv.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeancaslv.gerenciador.modelo.Banco;

public class RemoveEmpresa {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String paramId = request.getParameter("id");
		
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		
		banco.remove(id);
		
		response.sendRedirect("ListaEmpresas");
	}
	
}
