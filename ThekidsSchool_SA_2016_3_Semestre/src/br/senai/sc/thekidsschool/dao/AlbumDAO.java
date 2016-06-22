package br.senai.sc.thekidsschool.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.senai.sc.thekidsschool.commons.JpaUtil;
import br.senai.sc.thekidsschool.model.Imagem;


public class AlbumDAO {

	public void salvar(Imagem foto) {
		getEM().merge(foto);
	}

	public List<Imagem> listarImagensPorTurma(Long idTurma) {
		Query query = getEM().createQuery("From Imagem i Where i.turma.id = :idTurma ", Imagem.class);
		query.setParameter("idTurma", idTurma);
		return query.getResultList();
	}

	public Imagem buscarImagemPorId(Long idImagem) {
		return getEM().find(Imagem.class, idImagem);
	}

	public void excluir(Imagem imagem) {
		getEM().remove(imagem);
	}

	private EntityManager getEM() {
		EntityManager em = JpaUtil.getEntityManager();
		return em;
	}

	public List<Imagem> listaImagemUsuarioDAO(Long usuarioLogado) {
		Query query = getEM().createQuery("From Imagem i Where i.usuario.id = :idUsuario", Imagem.class);
		query.setParameter("idUsuario", usuarioLogado);
		return query.getResultList();

	}

}
