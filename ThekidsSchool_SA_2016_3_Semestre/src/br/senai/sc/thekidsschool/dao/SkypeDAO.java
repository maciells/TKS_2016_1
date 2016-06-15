package br.senai.sc.thekidsschool.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.thekidsschool.commons.JpaUtil;
import br.senai.sc.thekidsschool.model.Skype;

public class SkypeDAO {

	public void salvar(Skype skype) {
		getEM().merge(skype);
	}

	public Skype buscarPorId(Long id) {
		return getEM().find(Skype.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Skype> listarSkype() {
		Query query = getEM().createQuery("From Skype", Skype.class);
		return query.getResultList();
	}

	public void excluir(Long id) {
		Skype skype = getEM().getReference(Skype.class, id);
		getEM().remove(skype);
	}

	private EntityManager getEM() {
		EntityManager em = JpaUtil.getEntityManager();
		return em;
	}

}
