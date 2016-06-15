package br.senai.sc.thekidsschool.rn;

import java.util.List;

import br.senai.sc.thekidsschool.dao.UsuarioDAO;
import br.senai.sc.thekidsschool.model.Usuario;



public class UsuarioRN {
	
	private UsuarioDAO dao;

	public UsuarioRN() {
		dao = new UsuarioDAO();
	}

	public void salvar(Usuario usuario) {
		dao.salvar(usuario);
	}

	public Usuario buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public List<Usuario> listarUsuarios() {
		return dao.listarUsuarios();
	}

	public void excluir(Long id) {
		dao.excluir(id);
	}

	public List<Usuario> listaProfessores() {
		return dao.listarProfessores();
	}

	public List<Usuario> listaAdministrador() {
		// TODO Auto-generated method stub
		return dao.listarAdministrador();
	}

	public List<Usuario> listaAluno() {
		// TODO Auto-generated method stub
		return dao.lisarAluno();	
	}

	public Usuario buscarPorEmail(String email) {
		return dao.buscarPorEmail(email);
	}
}
