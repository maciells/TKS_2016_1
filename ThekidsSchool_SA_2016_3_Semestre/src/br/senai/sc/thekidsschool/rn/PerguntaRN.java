package br.senai.sc.thekidsschool.rn;

import br.senai.sc.thekidsschool.dao.PerguntaDAO;
import br.senai.sc.thekidsschool.model.Pergunta;
import br.senai.sc.thekidsschool.model.Resposta;

public class PerguntaRN {
	private PerguntaDAO perguntaDAO;
	
	public PerguntaRN(){
		perguntaDAO = new PerguntaDAO();
	}
	
	public PerguntaDAO getPerguntaDAO() {
		return perguntaDAO;
	}
	public void setPerguntaDAO(PerguntaDAO perguntaDAO) {
		this.perguntaDAO = perguntaDAO;
	}


	public void salvar(Pergunta pergunta) {
		perguntaDAO.salvar(pergunta);
		
	}

	public Object buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Pergunta buscarPergunta(Pergunta pergunta) {
		perguntaDAO.buscarPergunta(pergunta);
		return null;
	}

}
