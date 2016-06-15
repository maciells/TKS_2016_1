package br.senai.sc.thekidsschool.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.thekidsschool.model.Perfil;
import br.senai.sc.thekidsschool.model.Usuario;
import br.senai.sc.thekidsschool.rn.UsuarioRN;



@SessionScoped
@ManagedBean
public class SessaoMb {

	private String emailForm;
	private String senhaForm;
	private Usuario usuarioLogado;

	public String getSenhaForm() {
		return senhaForm;
	}

	public void setSenhaForm(String senhaForm) {
		this.senhaForm = senhaForm;
	}

	public String getEmailForm() {
		return emailForm;
	}

	public void setEmailForm(String emailForm) {
		this.emailForm = emailForm;
	}

	public boolean estaLogado(){
		return usuarioLogado != null;
	}
	
	
	
	
	public boolean ehAdmin(){
		return usuarioLogado != null && usuarioLogado.getPerfil().equals(Perfil.ADMINISTRADOR);
	}
	
	public String getNomeUsuarioLogato(){
		return usuarioLogado == null ? "" : usuarioLogado.getNome();
	}
	
	public String sair(){
		usuarioLogado = null;
		return "/index?faces-redirect=true";
	}
	
	public String entrar(){
		UsuarioRN usuarioRN = new UsuarioRN();
		Usuario usuario = usuarioRN.buscarPorEmail(emailForm);
		
		if(usuario == null ||
				!usuario.getEmail().equalsIgnoreCase(emailForm) ||
				!usuario.getSenha().equals(senhaForm)){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("E-mail ou senha não confere."));
			return "";
		}
		
		usuarioLogado = usuario;
		return "/Admin/homeAdmin?faces-redirect=true";
	}
}
