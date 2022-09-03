package com.jeancaslv.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeancaslv.gerenciador.modelo.Banco;
import com.jeancaslv.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.parseInt(paramId);
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaEmpresaPorId(id);
		
		
		//RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		request.setAttribute("empresa", empresa);
		//rd.forward(request, response);
		
		return "forward:/formAlteraEmpresa.jsp";
	}
	
}
