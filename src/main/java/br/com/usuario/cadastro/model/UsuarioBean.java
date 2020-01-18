package br.com.usuario.cadastro.model;

import java.util.List;

import br.com.usuario.model.Usuario;
import br.com.usuario.model.dao.UsuarioDAO;


public class UsuarioBean {

	public UsuarioBean() {
	}
	
	private Usuario usuario = new Usuario();
	private UsuarioDAO userDao = new UsuarioDAO();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String logar() {
		List<Usuario> usuarios = userDao.FindEmail(usuario.getEmail());
		for(Usuario c: usuarios) {
			if(c.getEmail().equals(usuario.getEmail()) && c.getSenha().equals(usuario.getSenha())) {
				return "/Paginas/lista";
			}
		}
		return "index.xhtml";
	}
	
	public String Cadastrar(Usuario usuario) {
		List<Usuario> usuarios = userDao.FindEmail(usuario.getEmail());
		for(Usuario c: usuarios) {
			if(c.getEmail().equals(usuario.getEmail())) {
				return "/Paginas/Cadastrar";
			}
		}
		userDao.save(usuario);
		return "index.xhtml";
	}
	
	public List<Usuario> listarTodos(){
		return userDao.findAll();
	}
	
	public void excluir(Integer id) {
		userDao.remove(id);
	}
	
	public Usuario atualizar() {
		return userDao.save(usuario); // o metodo Save Salva e Atualiza o Usuario ( Caso ja tenha o Id ele Atualiza o Usuario )
	}
}
