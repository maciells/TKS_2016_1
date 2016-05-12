package br.senai.sc.thekidsschool.rn;

import java.util.List;

import br.senai.sc.thekidsschool.dao.TurmaDAO;
import br.senai.sc.thekidsschool.model.Turma;

public class TurmaRN {
	
	private TurmaDAO dao;

	
	public TurmaRN(){
		dao = new TurmaDAO();
		
	}
	
	public List<Turma> listar() {
		return dao.listarTurma();
	}

	public void excluir(Long id) {
		dao.excluir(id);
		
	}

	public void salvar(Turma turma) {
		dao.salvar(turma);
		
	}

	public Turma buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

}
