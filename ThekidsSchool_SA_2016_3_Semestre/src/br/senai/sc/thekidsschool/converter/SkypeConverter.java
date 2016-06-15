package br.senai.sc.thekidsschool.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.thekidsschool.model.Skype;
import br.senai.sc.thekidsschool.rn.SkypeRN;





@FacesConverter(forClass=Skype.class)
public class SkypeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		SkypeRN skypeRN = new SkypeRN();
		Long id = Long.parseLong(value);
		return skypeRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Skype skype = (Skype) value;
		return skype.getId().toString();
	}
}
