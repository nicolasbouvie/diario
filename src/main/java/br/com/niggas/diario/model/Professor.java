package br.com.niggas.diario.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("1")
public class Professor extends Pessoa {
	private static final long serialVersionUID = 8894822407832053368L;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professor")
	private Set<Turma> aulasMinistradas;

	public Set<Turma> getAulasMinistradas() {
		return aulasMinistradas;
	}

	public void setAulasMinistradas(Set<Turma> aulasMinistradas) {
		this.aulasMinistradas = aulasMinistradas;
	}
}
