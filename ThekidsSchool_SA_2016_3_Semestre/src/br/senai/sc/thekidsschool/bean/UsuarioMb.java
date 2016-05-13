package br.senai.sc.thekidsschool.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ComponentSystemEvent;

import br.senai.sc.thekidsschool.model.Perfil;
import br.senai.sc.thekidsschool.model.Usuario;
import br.senai.sc.thekidsschool.rn.UsuarioRN;

@ManagedBean
public class UsuarioMb {
	private Usuario usuario;
	private UsuarioRN usuarioRN;
	private Long editarId;
	private List<Usuario> listaUsuarios;
	private List<Usuario> listaProfessores;
	private List<Usuario> listaAdministrador;
	private List<Usuario> listaAluno;

	@PostConstruct
	public void depoisDeConstruir() {
		usuario = new Usuario();
		usuarioRN = new UsuarioRN();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public List<Usuario> getListaUsuarios() {
		if (listaUsuarios == null) {
			listaUsuarios = usuarioRN.listarUsuarios();
		}
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public void carregarUsuario(ComponentSystemEvent event) {
		if (editarId == null) {
			return;
		}

		usuario = usuarioRN.buscarPorId(editarId);
	}

	public String excluir(String id) {
		Long idExcluir = Long.parseLong(id);
		usuarioRN.excluir(idExcluir);
		listaUsuarios = null;
		listaProfessores = null;
		listaAdministrador = null;
		
		return "";
	}

	public String salvar() {
		usuarioRN.salvar(usuario);
		if (usuario.getPerfil().equals(Perfil.ADMINISTRADOR)) {
			listaUsuarios = null;
			if (usuario.getPerfil().equals(Perfil.ALUNO)) {
				listaUsuarios = null;
				if (usuario.getPerfil().equals(Perfil.PROFESSOR)) {
					listaUsuarios = null;
				}
			}
		}
		return "/listarUsuario";
	}

	public List<Usuario> getListaProfessores() {
		if (listaProfessores == null) {
			listaProfessores = usuarioRN.listaProfessores();
		}
		return listaProfessores;
	}
	
	public List<Usuario> getListaAdministrador() {
		if (listaAdministrador == null) {
			listaAdministrador = usuarioRN.listaAdministrador();
		}
		return listaAdministrador;
	}
	
	public List<Usuario> getListaAluno() {
		if (listaAluno == null) {
			listaAluno = usuarioRN.listaAluno();
		}
		return listaAluno;
	}

}
