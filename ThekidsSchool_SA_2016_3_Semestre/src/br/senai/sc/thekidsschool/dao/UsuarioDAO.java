package br.senai.sc.thekidsschool.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.thekidsschool.model.Perfil;
import br.senai.sc.thekidsschool.model.Usuario;

import br.senai.sc.thekidsschool.commons.JpaUtil;



public class UsuarioDAO {
	
	public void salvar(Usuario usuario) {
		getEM().merge(usuario);
	}

	public Usuario buscarPorId(Long id) {
		return getEM().find(Usuario.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios() {
		Query query = getEM().createQuery("From Usuario", Usuario.class);
		return query.getResultList();
	}

	public void excluir(Long id) {
		Usuario usuario = getEM().getReference(Usuario.class, id);
		getEM().remove(usuario);
	}

	private EntityManager getEM() {
		EntityManager em = JpaUtil.getEntityManager();
		return em;
	}

	public List<Usuario> listarProfessores() {
		Query query = getEM().createQuery("From Usuario u Where u.perfil = :perfil", Usuario.class);
		query.setParameter("perfil", Perfil.PROFESSOR);
		
		return query.getResultList();
	}
	
	public List<Usuario> listarAdministrador() {
		Query query = getEM().createQuery("From Usuario u Where u.perfil = :perfil", Usuario.class);
		query.setParameter("perfil", Perfil.ADMINISTRADOR);
		
		return query.getResultList();
	}

	public List<Usuario> lisarAluno() {
		Query query = getEM().createQuery("From Usuario u Where u.perfil = :perfil", Usuario.class);
		query.setParameter("perfil", Perfil.ALUNO);
		
		return query.getResultList();
	}
	
	public List<Usuario> listarAlunosTurma() {
		Query query = getEM().createQuery("From turma_usuario", Usuario.class);
		query.setParameter("turma", Perfil.ALUNO);
		
		return query.getResultList();
	}
	
	
}
