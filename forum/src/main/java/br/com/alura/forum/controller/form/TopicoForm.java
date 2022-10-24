package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;

public class TopicoForm {
	
	public String getTitulo() {
		return titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	@NotNull @NotEmpty @Length(min = 5)
	private String titulo;
	@NotNull @NotEmpty @Length(min = 5)
	private String mensagem;
	@NotNull @NotEmpty
	private String nomeCurso;
	
	public Topico converter(CursoRepository cursoRepository) {
		
		var curso = cursoRepository.findByNome(nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}

}
