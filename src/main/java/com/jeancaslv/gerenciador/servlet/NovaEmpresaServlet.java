package com.jeancaslv.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("Cadastrando nova emrpesa");
			
			String nomeEmpresa = req.getParameter("nome");
			Empresa empresa = new Empresa();
			empresa.setNome(nomeEmpresa);
			
			Banco banco = new Banco();
			banco.adiciona(empresa);
			
			PrintWriter out = resp.getWriter();
			out.println("Empresa Cadastrada com sucesso");
		}

}