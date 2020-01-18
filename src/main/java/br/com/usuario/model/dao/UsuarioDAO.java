package br.com.usuario.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.connection.ConnectionFactory;
import br.com.usuario.model.Usuario;

public class UsuarioDAO {

	
	public Usuario save(Usuario usuario) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			if(usuario.getId() == null) {
				em.persist(usuario);
			}else {
				em.merge(usuario);
			}
			em.getTransaction().commit();
		}catch (Exception e){
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return usuario;
	}
	
	public Usuario findById(Integer id) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		Usuario usuario = null;
		
		try {
			usuario = em.find(Usuario.class, id);
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return usuario;
	}
	
	
	public List<Usuario> findAll(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Usuario> usuarios = null;
		
		try {
			usuarios = em.createQuery("from Usuario u").getResultList(); //JPQL
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		
		return usuarios;
		
	}
	
	public Usuario remove(Integer id) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		Usuario usuario = null;
		try {
			usuario = em.find(Usuario.class, id);
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
			
		}
		
		return usuario;
	}
	
	public List<Usuario> FindEmail(String email) {
		EntityManager em = new ConnectionFactory().getConnection();
		List<Usuario> usuarios = null;
		try {
			String jpaq = "from Usuario where email = '"+ email + "'";
			usuarios = em.createQuery(jpaq).getResultList();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
			
		}
		return usuarios;
	}
	
	
}
