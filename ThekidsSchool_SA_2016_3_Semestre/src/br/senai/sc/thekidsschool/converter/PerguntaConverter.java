package br.senai.sc.thekidsschool.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.thekidsschool.model.Pergunta;
import br.senai.sc.thekidsschool.rn.PerguntaRN;

@FacesConverter(forClass = Pergunta.class)
public class PerguntaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String valor) {
		Long id = Long.parseLong(valor);
		PerguntaRN rn = new PerguntaRN();
		return rn.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object valor) {
		Pergunta pergunta = (Pergunta)valor;
		return pergunta.getId().toString();
	}

	
}
