package br.senai.sc.thekidsschool.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.thekidsschool.model.Resposta;
import br.senai.sc.thekidsschool.rn.RespostaRN;


@FacesConverter(forClass = Resposta.class)
public class RespostaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String valor) {
		Long id = Long.parseLong(valor);
		RespostaRN rn = new RespostaRN();
		return rn.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object valor) {
		Resposta resposta = (Resposta)valor;
		return resposta.getId().toString();
	}	
}
