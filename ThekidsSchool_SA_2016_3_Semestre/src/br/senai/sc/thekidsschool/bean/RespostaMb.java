package br.senai.sc.thekidsschool.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.thekidsschool.model.Resposta;
import br.senai.sc.thekidsschool.rn.RespostaRN;


@ManagedBean
public class RespostaMb {
	private Resposta resposta;
	private RespostaRN respostaRN;
	
	@PostConstruct
	public void init(){
		resposta = new Resposta();
		respostaRN = new RespostaRN();
	}

	public Resposta getResposta() {
		return resposta;
	}

	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}

	public RespostaRN getRespostaRN() {
		return respostaRN;
	}

	public void setRespostaRN(RespostaRN respostaRN) {
		this.respostaRN = respostaRN;
	}
	
	public String salvar(){
		respostaRN.salvar(resposta);
		
		return"";
	}
}
