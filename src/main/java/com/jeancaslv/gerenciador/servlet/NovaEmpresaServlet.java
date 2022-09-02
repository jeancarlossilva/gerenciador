package com.jeancaslv.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeancaslv.gerenciador.modelo.Banco;
import com.jeancaslv.gerenciador.modelo.Empresa;


//@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("Cadastrando nova emrpesa");
			
			String nomeEmpresa = req.getParameter("nome");
			String paramDataEmpresa = req.getParameter("data");
			
			Date dataAbertura = null;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				dataAbertura = sdf.parse(paramDataEmpresa);
			} catch (ParseException e) {
				throw new ServletException(e);
				
				
			}
			
			Empresa empresa = new Empresa();
			empresa.setNome(nomeEmpresa);
			empresa.setDataAbertura(dataAbertura);
			Banco banco = new Banco();
			banco.adiciona(empresa);
			
			resp.sendRedirect("ListaEmpresas");
			
//			RequestDispatcher rd = req.getRequestDispatcher("ListaEmpresas");
//			req.setAttribute("empresa", empresa.getNome());
//			rd.forward(req, resp);
		}

}
