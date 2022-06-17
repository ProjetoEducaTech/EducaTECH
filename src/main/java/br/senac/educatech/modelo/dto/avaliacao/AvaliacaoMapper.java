package br.senac.educatech.modelo.dto.avaliacao;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.senac.educatech.modelo.entidade.avaliacao.Avaliacao;
import br.senac.educatech.util.foto.ConversorFoto;

public class AvaliacaoMapper {

	public AvaliacaoDTO paraDTO(Avaliacao avaliacao) {
		
		String nome = avaliacao.getAluno().getNome();
		String sobrenome = avaliacao.getAluno().getSobrenome();
		String pronome = avaliacao.getAluno().getPronome().name().replace('_', '/').toLowerCase();
		String foto = ConversorFoto.converterByteParaBase64(avaliacao.getAluno().getFoto());
		String extensao = avaliacao.getAluno().getFoto().getExtensao();
		String comentario = avaliacao.getComentario();
		int nota = avaliacao.getNota();
		String data = avaliacao.getDataAvaliacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Long id = avaliacao.getId();
		
		return new AvaliacaoDTO(nome, sobrenome, pronome, foto, extensao, comentario, nota, data, id);
	}

	public List<AvaliacaoDTO> paraDTO(List<Avaliacao> avaliacoes) {

		List<AvaliacaoDTO> avaliacoesDTO = new ArrayList<AvaliacaoDTO>();

		for (Avaliacao avaliacao : avaliacoes)
			avaliacoesDTO.add(paraDTO(avaliacao));

		return avaliacoesDTO;
	}
}