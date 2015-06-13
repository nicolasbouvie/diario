package br.com.niggas.diario.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.niggas.diario.dao.AlunoDAO;
import br.com.niggas.diario.model.Aluno;

@Controller
public class AlunoController extends AbstractController<AlunoDAO> {

	@Inject
	private AlunoDAO dao;

	@Override
	protected AlunoDAO getDAO() {
		return dao;
	}

	@Override
	@Get("/aluno")
	public void index() {
		super.list();
	}

	@Post("/aluno/salvar")
	public void salvarAluno(Aluno aluno) {
		super.save(aluno);
	}

	@Get("/aluno/remover")
	public void removerAluno(Long id) {
		super.remove(id);
	}
}
