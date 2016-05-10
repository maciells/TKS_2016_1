package br.senai.sc.thekidsschool.bean;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import br.senai.sc.thekidsschool.model.Turma;
import br.senai.sc.thekidsschool.rn.TurmaRN;

@ManagedBean
public class TurmaMb {
	
	private List<Turma>listaTurma;
	private TurmaRN turmaRN;
	private Long editarId;
	private Turma turma;

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
}