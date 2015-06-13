package br.com.niggas.diario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="disciplina_seq", sequenceName="disciplina_codigo")
public class Disciplina implements ModelEntity<Long> {
	private static final long serialVersionUID = -810511957583041913L;

	@Id
    @Column(name="CODIGO")
    @GeneratedValue(generator="disciplina_seq", strategy=GenerationType.SEQUENCE)
	private Long id;
	private String nome;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
