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
		return dao.listar();
	}

}
