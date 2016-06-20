package br.senai.sc.thekidsschool.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.senai.sc.thekidsschool.model.Pergunta;
import br.senai.sc.thekidsschool.model.Resposta;
import br.senai.sc.thekidsschool.rn.PerguntaRN;
import br.senai.sc.thekidsschool.rn.RespostaRN;

@ManagedBean
public class PerguntaMb {
	private Pergunta pergunta;
	private PerguntaRN perguntaRN;
	private RespostaRN respostaRN;
	private long editarId;
	private List<Resposta> respostas;
	private Resposta resposta1;
	private Resposta resposta2;
	private Resposta resposta3;
	private Resposta resposta4;
	
	
	@PostConstruct
	public void init(){
		pergunta = new Pergunta();
		perguntaRN = new PerguntaRN();
		
	}
	
	public long getEditarId() {
		return editarId;
	}

	public void setEditarId(long editarId) {
		this.editarId = editarId;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}
	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	public PerguntaRN getPerguntaRN() {
		return perguntaRN;
	}
	public void setPerguntaRN(PerguntaRN perguntaRN) {
		this.perguntaRN = perguntaRN;
	}
	
	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public RespostaRN getRespostaRN() {
		return respostaRN;
	}

	public void setRespostaRN(RespostaRN respostaRN) {
		this.respostaRN = respostaRN;
	}
	
	public Resposta getResposta1() {
		return resposta1;
	}

	public void setResposta1(Resposta resposta1) {
		this.resposta1 = resposta1;
	}

	public Resposta getResposta2() {
		return resposta2;
	}

	public void setResposta2(Resposta resposta2) {
		this.resposta2 = resposta2;
	}

	public Resposta getResposta3() {
		return resposta3;
	}

	public void setResposta3(Resposta resposta3) {
		this.resposta3 = resposta3;
	}

	public Resposta getResposta4() {
		return resposta4;
	}

	public void setResposta4(Resposta resposta4) {
		this.resposta4 = resposta4;
	}

	
	
	
	public String salvar(){
		
		perguntaRN.salvar(pergunta);
		pergunta = null;
		return "";
		
	}
	
	public void carregarEdicao(){
		
	}
}
