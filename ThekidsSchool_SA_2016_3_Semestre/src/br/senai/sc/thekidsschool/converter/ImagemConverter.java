package br.senai.sc.thekidsschool.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.thekidsschool.model.Imagem;
import br.senai.sc.thekidsschool.rn.AlbumRN;


@FacesConverter(forClass = Imagem.class)
public class ImagemConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		try {
			Long id = Long.parseLong(valor);
			AlbumRN albumRN = new AlbumRN();
			Imagem imagem = albumRN.buscarImagemPorId(id);
			return imagem;
		} catch (NumberFormatException e) {
			return new Imagem();
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) {
		Imagem imagem = (Imagem) valor;
		return imagem.getId() == null ? "" : imagem.getId().toString();
	}

}
