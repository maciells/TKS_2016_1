package br.senai.sc.thekidsschool.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.thekidsschool.commons.JpaUtil;
import br.senai.sc.thekidsschool.model.Resposta;


public class RespostaDAO {

	@SuppressWarnings("unchecked")
	public List<Resposta> listarResposta() {
		Query query = getEM().createQuery("From Resposta", Resposta.class);
		return query.getResultList();	
	}
	

	public void salvar(Resposta resposta) {
		getEM().merge(resposta);
	}
	
	private EntityManager getEM() {
		EntityManager em = JpaUtil.getEntityManager();
		return em;
	}

}
