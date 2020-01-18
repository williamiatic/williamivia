package br.com.usuario.model.teste;


import java.util.List;

import br.com.usuario.cadastro.model.UsuarioBean;
import br.com.usuario.model.Usuario;
import br.com.usuario.model.dao.UsuarioDAO;

public class UsuarioTeste {

	
	public static void main(String[] args) {
		
		
		Usuario user = new Usuario();
		user.setNome("WilliamTeste");
		user.setEmail("WilliamTeste@gmail.com");
		user.setSenha("Teste");
		user.setTelefone("81986724039");
		
		UsuarioBean Bean = new UsuarioBean();
		Bean.setUsuario(user);
		Bean.Cadastrar(user); // TESTE CADASTRO USUARIO
		
		
		/*
		
		UsuarioBean Bean = new UsuarioBean();
		
		for (Usuario u: Bean.listarTodos()) {
			System.out.println("Id: " +u.getId());
			System.out.println("Nome: " +u.getNome());
			System.out.println("Email: " +u.getEmail());
			System.out.println("Senha: " +u.getSenha());
			System.out.println("Telefone: " +u.getTelefone());
		}*/  //TESTE LISTAR TODOS OS USUARIOS
		
		
		/*UsuarioBean Bean = new UsuarioBean();
		Bean.excluir(2);*/ // TESTE EXCLUIR USUARIO PELO ID
		
		
		/*UsuarioBean Bean = new UsuarioBean();
		Usuario usuario = new Usuario();
		usuario.setEmail("WilliamTeste@gmail.com");
		usuario.setSenha("Teste");
		Bean.setUsuario(usuario);
		System.out.println(Bean.logar());*/ // TESTE PARA LOGAR NO SITE PELO EMAIL E SENHA
		
		
		/*Usuario user = new Usuario();
		user.setId(3);
		user.setNome("NomeAlterar");
		user.setEmail("EmailAlterar");
		user.setSenha("SenhaAlterar");
		user.setTelefone("TelefoneAlterar");
		UsuarioBean Bean = new UsuarioBean();
		Bean.setUsuario(user);
		Bean.atualizar();*/ // TESTE ALTERAR USUARIO
	}
	
}
