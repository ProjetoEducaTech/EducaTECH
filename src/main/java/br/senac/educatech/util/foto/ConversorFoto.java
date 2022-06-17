package br.senac.educatech.util.foto;

import org.apache.commons.codec.binary.Base64;

import br.senac.educatech.modelo.entidade.foto.Foto;

public class ConversorFoto {

	public static String converterByteParaBase64(Foto foto) {
		return new String(Base64.encodeBase64(foto.getConteudo()));
	}
}