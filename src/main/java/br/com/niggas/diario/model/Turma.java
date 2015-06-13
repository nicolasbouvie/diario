package br.com.niggas.diario.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="turma_seq", sequenceName="turma_codigo")
public class Turma implements ModelEntity<Long> {
	private static final long serialVersionUID = 6520925150693341056L;

	@Id
	@Column(name="CODIGO")
	@GeneratedValue(generator="turma_seq", strategy=GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "CODIGO_DISCIPLINA")
	private Disciplina disciplina;

	@ManyToOne
	@JoinColumn(name = "CODIGO_PROFESSOR")
	private Professor professor;

	private Date dataInicio;
	private Date dataFim;
	private Long quantidadeAulas;

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="ALUNOTURMA",
	joinColumns={@JoinColumn(name="CODIGO_TURMA")},
	inverseJoinColumns={@JoinColumn(name="CODIGO_ALUNO")})
	private Set<Pessoa> alunos;

	@OneToMany(mappedBy="turma")
	private Set<Frequencia> frequencias;

	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public Long getQuantidadeAulas() {
		return quantidadeAulas;
	}
	public void setQuantidadeAulas(Long quantidadeAulas) {
		this.quantidadeAulas = quantidadeAulas;
	}
	public Set<Pessoa> getAlunos() {
		return alunos;
	}
	public void setAlunos(Set<Pessoa> alunos) {
		this.alunos = alunos;
	}
	public Set<Frequencia> getFrequencias() {
		return frequencias;
	}
	public void setFrequencias(Set<Frequencia> frequencias) {
		this.frequencias = frequencias;
	}

	public void addAluno(Aluno aluno) {
		if (alunos == null) {
			alunos = new HashSet<Pessoa>();
		}
		alunos.add(aluno);
	}
}
