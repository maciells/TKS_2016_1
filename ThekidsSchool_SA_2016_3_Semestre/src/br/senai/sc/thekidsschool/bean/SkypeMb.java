package br.senai.sc.thekidsschool.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ComponentSystemEvent;


import br.senai.sc.thekidsschool.model.Skype;
import br.senai.sc.thekidsschool.rn.SkypeRN;


@ManagedBean
public class SkypeMb {

	private Skype skype;
	private SkypeRN skypeRN;
	private Long editarId;
	private List<Skype> listaSkype;
	
	
	@PostConstruct
	public void depoisDeConstruir() {
		skype = new Skype();
		skypeRN = new SkypeRN();
	}


	
	
	
	public Skype getSkype() {
		return skype;
	}


	public void setSkype(Skype skype) {
		this.skype = skype;
	}


	public SkypeRN getSkypeRN() {
		return skypeRN;
	}


	public void setSkypeRN(SkypeRN skypeRN) {
		this.skypeRN = skypeRN;
	}


	public Long getEditarId() {
		return editarId;
	}


	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}


	public List<Skype> getListaSkype() {
		if (listaSkype == null) {
			listaSkype = skypeRN.listarSkype();
		}
		return listaSkype;
	}


	public void setListaSkype(List<Skype> listaSkype) {
		this.listaSkype = listaSkype;
	}
	
	
	public void carregarSkype(ComponentSystemEvent event) {
		if (editarId == null) {
			return;
		}
		skype = skypeRN.buscarPorId(editarId);
	}
	
	
	public String excluir(String id) {
		Long idExcluir = Long.parseLong(id);
		skypeRN.excluir(idExcluir);
		listaSkype = null;
		return "";
	}
	
	public String salvar() {
		skypeRN.salvar(skype);
		listaSkype = null;
		skype = null;
		return "";
	}
	
}
