package br.senai.sc.thekidsschool.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.thekidsschool.model.Usuario;
import br.senai.sc.thekidsschool.rn.UsuarioRN;



@FacesConverter(forClass=Usuario.class)
public class UsuarioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		UsuarioRN usuarioRN = new UsuarioRN();
		Long id = Long.parseLong(value);
		return usuarioRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		Usuario usuario = (Usuario) value;
		return usuario.getId().toString();
	}
}
