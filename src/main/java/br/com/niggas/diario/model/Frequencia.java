package br.com.niggas.diario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.com.niggas.diario.model.type.Presenca;

@Entity
@SequenceGenerator(name="frequencia_seq", sequenceName="frequencia_codigo")
public class Frequencia implements ModelEntity<Long> {
	private static final long serialVersionUID = -9085937527241573054L;

	@Id
    @Column(name="CODIGO")
    @GeneratedValue(generator="frequencia_seq", strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "CODIGO_ALUNO", nullable = false)
	private Aluno aluno;

	private Long aula;
	
	@ManyToOne
	@JoinColumn(name = "CODIGO_TURMA", nullable = false)
	private Turma turma;

	private Character presenca;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Long getAula() {
		return aula;
	}
	public void setAula(Long aula) {
		this.aula = aula;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public Presenca getPresenca() {
		return Presenca.getPresenca(presenca.toString());
	}
	public void setPresenca(Character presenca) {
		this.presenca = presenca;
	}
	public void setPresenca(Presenca presenca) {
		this.presenca = presenca.id;
	}
}
