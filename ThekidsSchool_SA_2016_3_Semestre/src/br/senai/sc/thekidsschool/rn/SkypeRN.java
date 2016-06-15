package br.senai.sc.thekidsschool.rn;

import java.util.List;

import br.senai.sc.thekidsschool.dao.SkypeDAO;
import br.senai.sc.thekidsschool.model.Skype;



public class SkypeRN {
	
	private SkypeDAO dao;
	
	
	public SkypeRN() {
		dao = new SkypeDAO();
	}
	

	public void salvar(Skype skype) {
		dao.salvar(skype);
	}

	public Skype buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public List<Skype> listarSkype() {
		return dao.listarSkype();
	}

	public void excluir(Long id) {
		dao.excluir(id);
	}

}
