package com.jeancaslv.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jeancaslv.gerenciador.acao.Acao;
import com.jeancaslv.gerenciador.acao.AlteraEmpresa;
import com.jeancaslv.gerenciador.acao.ListaEmpresas;
import com.jeancaslv.gerenciador.acao.MostraEmpresa;
import com.jeancaslv.gerenciador.acao.NovaEmpresa;
import com.jeancaslv.gerenciador.acao.NovaEmpresaForm;
import com.jeancaslv.gerenciador.acao.RemoveEmpresa;

//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
//
//		HttpSession session = request.getSession();
//		boolean usuarioNaoEstaLogado = session.getAttribute("usuarioLogado") == null;
//		boolean ehAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//		
//		if (ehAcaoProtegida && usuarioNaoEstaLogado) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			//return "redirect:entrada?acao=LoginForm";
//			return;
//		}

	

		String nomeClasse = "com.jeancaslv.gerenciador.acao." + paramAcao;

		String nome;
		try {
			Class classe = Class.forName(nomeClasse);// carrega a classe com o nome da string
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

		String[] tipoEEntrada = nome.split(":");

		if (tipoEEntrada[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEntrada[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEntrada[1]);
		}

//		if (paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas listaEmpresas = new ListaEmpresas();
//			nome = listaEmpresas.executa(request, response);
//
//		} else if (paramAcao.equals("RemoveEmpresa")) {
//
//			RemoveEmpresa removeEmpresa = new RemoveEmpresa();
//			nome = removeEmpresa.executa(request, response);
//
//		} else if (paramAcao.equals("MostraEmpresa")) {
//			MostraEmpresa mostraEmpresa = new MostraEmpresa();
//			nome = mostraEmpresa.executa(request, response);
//		} else if (paramAcao.equals("AlteraEmpresa")) {
//			AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
//			alteraEmpresa.executa(request, response);
//		} else if (paramAcao.equals("NovaEmpresa")) {
//			NovaEmpresa novaEmpresa = new NovaEmpresa();
//			novaEmpresa.executa(request, response);
//		}  else if (paramAcao.equals("NovaEmpresaForm")) {
//			NovaEmpresaForm novaEmpresaForm = new NovaEmpresaForm();
//			novaEmpresaForm.executa(request, response);
//		}

	}

}
