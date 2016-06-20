package br.senai.sc.thekidsschool.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.thekidsschool.commons.JpaUtil;
import br.senai.sc.thekidsschool.model.Pergunta;
import br.senai.sc.thekidsschool.model.Resposta;
import br.senai.sc.thekidsschool.model.Usuario;

public class PerguntaDAO {

	@SuppressWarnings("unchecked")
	public List<Pergunta> listarPergunta() {
		Query query = getEM().createQuery("From Pergunta", Pergunta.class);
		return query.getResultList();	
	}
	public void salvar(Pergunta pergunta) {
		getEM().merge(pergunta);
		
	}
	private EntityManager getEM() {
		EntityManager em = JpaUtil.getEntityManager();
		return em;
	}
	public Pergunta buscarPergunta(Pergunta pergunta) {
		return getEM().find(Pergunta.class, pergunta);
		
	}

}
