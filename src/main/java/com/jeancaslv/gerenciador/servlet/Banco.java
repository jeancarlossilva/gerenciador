package com.jeancaslv.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	public static List<Empresa> LISTA = new ArrayList<>();
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Empresa 1");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Empresa 2");
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
