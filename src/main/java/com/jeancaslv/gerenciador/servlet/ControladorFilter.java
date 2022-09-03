package com.jeancaslv.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jeancaslv.gerenciador.acao.Acao;


//@WebFilter("/entrada")
public class ControladorFilter  implements Filter {
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	@Override
	public void destroy() {
	
	}
       
    
       
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("ControladorFilter");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String paramAcao = httpRequest.getParameter("acao");
		
		String nomeClasse = "com.jeancaslv.gerenciador.acao." + paramAcao;

		String nome;
		try {
			Class classe = Class.forName(nomeClasse);// carrega a classe com o nome da string
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(httpRequest, httpResponse);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

		String[] tipoEEntrada = nome.split(":");

		if (tipoEEntrada[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEntrada[1]);
			rd.forward(request, response);
		} else {
			httpResponse.sendRedirect(tipoEEntrada[1]);
		}
		
		//não tem chain.doFilter(request, response) porque é o ultimo da cadeia
		
		
	}

	
	

}
