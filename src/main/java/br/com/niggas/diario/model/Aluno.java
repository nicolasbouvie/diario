package br.com.niggas.diario.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("2")
public class Aluno extends Pessoa {
	private static final long serialVersionUID = 1067038039317537632L;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "alunos")
	private Set<Turma> aulasMatriculadas;

	public Set<Turma> getAulasMatriculadas() {
		return aulasMatriculadas;
	}

	public void setAulasMatriculadas(Set<Turma> aulasMatriculadas) {
		this.aulasMatriculadas = aulasMatriculadas;
	}
}
