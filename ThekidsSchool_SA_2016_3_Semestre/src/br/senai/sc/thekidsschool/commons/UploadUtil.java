package br.senai.sc.thekidsschool.commons;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

public class UploadUtil {
	
	private static final Map<String, String> TIPOS_PERMITIDOS = new HashMap<String, String>();
	private static final String PASTA_UPLOADS = "/resources/img/uploads/";

	static{
		TIPOS_PERMITIDOS.put("image/jpeg",".jpg");
		TIPOS_PERMITIDOS.put("image/png",".png");
		TIPOS_PERMITIDOS.put("image/gif",".gif");
	}

	public static String moverArquivo(Part arquivoUploaded, String arquivoAntigo) throws IOException {
		if(arquivoUploaded == null){
			return arquivoAntigo;
		}
		
		String nome = gerarNome(arquivoUploaded);
		
		String caminhoAbsoluto = getCaminhoAbsoluto(nome);
		
		arquivoUploaded.write(caminhoAbsoluto);
		
		removerArquivo(arquivoAntigo);
		
		return nome;
	}

	private static String getCaminhoAbsoluto(String nome) {
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext();
		return servletContext.getRealPath(PASTA_UPLOADS.concat(nome));
	}

	private static String gerarNome(Part arquivoUploaded) {
		if(!TIPOS_PERMITIDOS.containsKey(arquivoUploaded.getContentType())){
			return null;
		}
		
		String novoNome = UUID.randomUUID().toString();
		return novoNome.concat(TIPOS_PERMITIDOS.get(arquivoUploaded.getContentType())) ;
	}

	public static void removerArquivo(String nome) {
		if(nome == null || nome.isEmpty()){
			return;
		}
		
		String caminhoAbsoluto = getCaminhoAbsoluto(nome);
		
		File file = new File(caminhoAbsoluto);
		if(file.exists()){
			file.delete();
		}
	}

}
