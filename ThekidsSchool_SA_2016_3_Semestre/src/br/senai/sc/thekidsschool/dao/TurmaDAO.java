package br.senai.sc.thekidsschool.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.thekidsschool.commons.JpaUtil;
import br.senai.sc.thekidsschool.model.Turma;



public class TurmaDAO {

	@SuppressWarnings("unchecked")
	public List<Turma> listarTurma() {
		Query query = getEM().createQuery("From Turma", Turma.class);
		return query.getResultList();	
	}
	
	public void salvar(Turma turma) {
		getEM().merge(turma);	
	}

	public void excluir(Long id) {
		Turma turma = getEM().getReference(Turma.class, id);
		getEM().remove(turma);
	}

	public Turma buscarPorId(Long id) {
		return getEM().find(Turma.class, id);
	}
	
	
	private EntityManager getEM() {
		EntityManager em = JpaUtil.getEntityManager();
		return em;
	}

}
