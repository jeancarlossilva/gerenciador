package com.jeancaslv.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	public static List<Empresa> LISTA = new ArrayList<>();
	public static List<Usuario> LISTA_USUARIOS = new ArrayList<>();
	public static Integer chaveSequencial = 1;
	
	
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(Banco.chaveSequencial++);
		empresa.setNome("Facebook");
		Empresa empresa2 = new Empresa();
		empresa2.setId(Banco.chaveSequencial++);
		empresa2.setNome("Google");
		LISTA.add(empresa);
		LISTA.add(empresa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("Jean");
		u1.setSenha("123");
		
		LISTA_USUARIOS.add(u1);
	
		
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.LISTA.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.LISTA;
	}
	
	public void remove(Integer id) {
		
		Iterator<Empresa> it = LISTA.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId().equals(id)) {
				it.remove();
			}
		}
		
	}

	public Empresa buscaEmpresaPorId(Integer id) {
		for (Empresa empresa : LISTA) {
			if(empresa.getId().equals(id)) {
				return empresa;
			}
		}
		
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : LISTA_USUARIOS) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		
		return null;
	}

}
