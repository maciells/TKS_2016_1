package br.senai.sc.thekidsschool.rn;

import java.util.List;

import br.senai.sc.thekidsschool.dao.TurmaDAO;
import br.senai.sc.thekidsschool.model.Perfil;
import br.senai.sc.thekidsschool.model.Turma;
import br.senai.sc.thekidsschool.model.Usuario;

public class TurmaRN {
	
	private TurmaDAO dao;

	public TurmaRN(){
		dao = new TurmaDAO();		
	}
	
	public List<Turma> listar() {
		return dao.listarTurma();
	}
	
	public void salvar(Turma turma) throws IllegalArgumentException, Exception {
		if(turma.getProfessor() == null){
			throw new IllegalArgumentException("� preciso selecionar um Professor");
		}
		if(!turma.getProfessor().getPerfil().equals(Perfil.PROFESSOR)){
			throw new IllegalArgumentException("� preciso selecionar um Professor");
		}
		
		dao.salvar(turma);
	}
	public void excluir(Long id) {
		dao.excluir(id);
		
	}
	
	public Turma buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public List<Turma> listarTurmaProfessor(Long usuarioLogado) {
		return dao.listaTurmaProfessor(usuarioLogado);
	}
}