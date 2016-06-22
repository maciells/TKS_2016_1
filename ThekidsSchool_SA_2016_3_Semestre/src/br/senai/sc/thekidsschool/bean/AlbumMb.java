package br.senai.sc.thekidsschool.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

import br.senai.sc.thekidsschool.commons.UploadUtil;
import br.senai.sc.thekidsschool.model.Imagem;
import br.senai.sc.thekidsschool.model.Turma;
import br.senai.sc.thekidsschool.model.Usuario;
import br.senai.sc.thekidsschool.rn.AlbumRN;
import br.senai.sc.thekidsschool.rn.TurmaRN;



@ViewScoped
@ManagedBean(name = "albumMb")
public class AlbumMb {

	private String turmaId;
	private Turma turma;
	private Imagem foto;
	
	private Part fotoUploaded;
	private List<Imagem> imagens;
	private List<Imagem> listaImagemUsuario;
	private AlbumRN albumRN;
	private TurmaRN turmaRN;
	

	@PostConstruct
	public void init() {
		turmaRN = new TurmaRN();
		albumRN = new AlbumRN();
		foto = new Imagem();
		turma = new Turma();
		
	}

	

	public List<Imagem> getImagens() {
		if (imagens == null && turma != null && turma.getId() != null) {
			imagens = albumRN.listarImagensPorTurma(turma.getId());
		}
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public List<Imagem> getListaImagemUsuario(Long usuarioLogado) {
		if(listaImagemUsuario == null){
			listaImagemUsuario = albumRN.listaImagemUsuarioRN(usuarioLogado);
		}
		return listaImagemUsuario;
	}



	public void setListaImagemUsuario(List<Imagem> listaImagemUsuario) {
		this.listaImagemUsuario = listaImagemUsuario;
	}



	public Imagem getFoto() {
		return foto;
	}

	public void setFoto(Imagem foto) {
		this.foto = foto;
	}

	public Part getFotoUploaded() {
		return fotoUploaded;
	}

	public void setFotoUploaded(Part fotoUploaded) {
		this.fotoUploaded = fotoUploaded;
	}

	public String getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(String turmaId) {
		this.turmaId = turmaId;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public AlbumRN getAlbumRN() {
		return albumRN;
	}

	public void setAlbumRN(AlbumRN albumRN) {
		this.albumRN = albumRN;
	}

	public TurmaRN getTurmaRN() {
		return turmaRN;
	}

	public void setTurmaRN(TurmaRN turmaRN) {
		this.turmaRN = turmaRN;
	}

	
	



	public List<Imagem> getListaImagemUsuario() {
		return listaImagemUsuario;
	}



	public void load(){
		if(turmaId != null){
			Long id = Long.parseLong(turmaId);
			turma = turmaRN.buscarPorId(id );
		}
	}
	
	public void excluir(String idImg){
		Long id = Long.parseLong(idImg);
		Imagem img = albumRN.buscarImagemPorId(id);
		
		UploadUtil.removerArquivo(img.getNome());
		albumRN.excluir(img);
		
		imagens = null;
	}

	public String salvar() {
		try {
			String nome = UploadUtil.moverArquivo(fotoUploaded, foto.getNome());

			foto.setNome(nome);
			foto.setTurma(turma);
			

			albumRN.adicionar(foto);

			return "/Prof/album?idTurma=" + turma.getId().toString()
					+ "&faces-redirect=true";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
