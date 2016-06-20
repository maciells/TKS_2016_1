package br.senai.sc.thekidsschool.rn;

import br.senai.sc.thekidsschool.dao.RespostaDAO;
import br.senai.sc.thekidsschool.model.Resposta;

public class RespostaRN {
	
	private RespostaDAO respostaDAO;
	
	public RespostaRN(){
		respostaDAO = new RespostaDAO();
	}
	
	public RespostaDAO getRespostaDAO() {
		return respostaDAO;
	}
	public void setRespostaDAO(RespostaDAO respostaDAO) {
		this.respostaDAO = respostaDAO;
	}
	public void salvar(Resposta resposta) {
		respostaDAO.salvar(resposta);
	}

	public Object buscarPorId(Long id) {
		
		return null;
	}
}
