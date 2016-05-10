package br.senai.sc.thekidsschool.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.thekidsschool.commons.JpaUtil;
import br.senai.sc.thekidsschool.model.Turma;

public class TurmaDAO {

	public List<Turma> listar() {
		Query query = getEM().createQuery("From Turma", Turma.class);
		return query.getResultList();
		
	}
	
	private EntityManager getEM() {
		EntityManager em = JpaUtil.getEntityManager();
		return em;
	}

}
