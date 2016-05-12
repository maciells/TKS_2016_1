package br.senai.sc.thekidsschool.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.event.ComponentSystemEvent;

import br.senai.sc.thekidsschool.model.Turma;
import br.senai.sc.thekidsschool.rn.TurmaRN;

@ManagedBean
public class TurmaMb {
	
	private Turma turma;
	private List<Turma>listaTurma;
	private TurmaRN turmaRN;
	private Long editarId;
	

	@PostConstruct
	public void init(){
		turmaRN	= new TurmaRN();
		turma = new Turma();
}

	public List<Turma> getListaTurma() {
		if(listaTurma == null){
			listaTurma = turmaRN.listar();
		}
		
		return listaTurma;
	}

	public void setListaTurma(List<Turma> listaTurma) {
		this.listaTurma = listaTurma;
	}

	public TurmaRN getTurmaRN() {
		return turmaRN;
	}

	public void setTurmaRN(TurmaRN turmaRN) {
		this.turmaRN = turmaRN;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public void carregarTurma(ComponentSystemEvent event) {
		if (editarId == null) {
			return;
		}
		turma = turmaRN.buscarPorId(editarId);
	}

	public String excluir(String id) {
		Long idExcluir = Long.parseLong(id);
		turmaRN.excluir(idExcluir);
		listaTurma = null;
		return "";
	}

	public String salvar(){
		turmaRN.salvar(turma);
		listaTurma = null;
		return "/listaTurma";
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	
}