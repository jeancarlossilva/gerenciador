package com.jeancaslv.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeancaslv.gerenciador.modelo.Banco;
import com.jeancaslv.gerenciador.modelo.Empresa;

public class NovaEmpresaForm implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova emrpesa");
		
		return "forward:formNovaEmpresa.jsp";
	}
	
}
