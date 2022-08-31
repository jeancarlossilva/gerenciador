package com.jeancaslv.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	public static List<Empresa> LISTA = new ArrayList<>();
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Facebook");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Google");
		LISTA.add(empresa);
		LISTA.add(empresa2);
		
	}
	
	public void adiciona(Empresa empresa) {
		Banco.LISTA.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.LISTA;
	}

}
