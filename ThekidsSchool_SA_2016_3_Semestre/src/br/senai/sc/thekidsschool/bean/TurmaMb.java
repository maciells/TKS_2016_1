package br.senai.sc.thekidsschool.bean;

import java.util.ArrayList;
import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ComponentSystemEvent;


import br.senai.sc.thekidsschool.model.Turma;
import br.senai.sc.thekidsschool.model.Usuario;
import br.senai.sc.thekidsschool.rn.TurmaRN;

@ViewScoped
@ManagedBean
public class TurmaMb {
	
	private Turma turma;
	private List<Turma>listaTurma;
	private TurmaRN turmaRN;
	private Long editarId;
	private Usuario alunoSelecionado;

	@PostConstruct
	public void init(){
		turmaRN	= new TurmaRN();
		turma = new Turma();
		turma.setAlunosTurma(new ArrayList<Usuario>());
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
	
	public Usuario getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(Usuario alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}
	
	public void carregarTurma(ComponentSystemEvent event) {
		if (editarId == null) {
			return;
		}
		turma = turmaRN.buscarPorId(editarId);
	}
	
//------
	
	public void excluirAluno(AjaxBehaviorEvent event) {
		Usuario aluno = (Usuario) event.getComponent().getAttributes()
				.get("idTurma");
		turma.getAlunosTurma().remove(aluno);
	}

	public String excluir(String id) {
		Long idExcluir = Long.parseLong(id);
		turmaRN.excluir(idExcluir);
		listaTurma = null;
		return "";
	}
	
	public void adicionarAluno(AjaxBehaviorEvent event) {
		if(turma.getAlunosTurma().contains(alunoSelecionado)){
			return;
		}
		turma.getAlunosTurma().add(alunoSelecionado);
		alunoSelecionado = null;
	}

	public String salvar() throws Throwable {
		try {
			turmaRN.salvar(turma);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo",
							"Salvo com sucesso."));
			return "/cadastroTurma";
		} catch (IllegalArgumentException exception) {
			exception.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",
							exception.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e
							.getMessage()));
		}
		return "";
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}	
	
	public void carregarEdicao() {
		if (editarId != null &&  
				!FacesContext.getCurrentInstance()
				.getPartialViewContext().isAjaxRequest()) {
			turma = turmaRN.buscarPorId(editarId);
		}
	}
}