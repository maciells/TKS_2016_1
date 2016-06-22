package br.senai.sc.thekidsschool.rn;

import java.util.List;

import br.senai.sc.thekidsschool.dao.AlbumDAO;
import br.senai.sc.thekidsschool.model.Imagem;



public class AlbumRN {

	private AlbumDAO dao;

	public AlbumRN() {
		dao = new AlbumDAO();
	}

	public void adicionar(Imagem foto) {
		dao.salvar(foto);
	}

	public List<Imagem> listarImagensPorTurma(Long idTurma) {
		return dao.listarImagensPorTurma(idTurma);
	}

	public Imagem buscarImagemPorId(Long idImagem) {
		return dao.buscarImagemPorId(idImagem);
	}

	public void excluir(Imagem imagem) {
		dao.excluir(imagem);
	}

}
