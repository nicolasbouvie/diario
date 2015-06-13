package br.com.niggas.diario.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.niggas.diario.dao.ProfessorDAO;
import br.com.niggas.diario.model.Professor;

@Controller
public class ProfessorController extends AbstractController<ProfessorDAO> {

	@Inject
	private ProfessorDAO dao;

	@Override
	protected ProfessorDAO getDAO() {
		return dao;
	}

	@Override
	@Get("/professor")
	public void index() {
		super.list();
	}

	@Post("/professor/salvar")
	public void salvar(Professor professor) {
		super.save(professor);
	}

	@Get("/professor/remover")
	public void remover(Long id) {
		super.remove(id);
	}
}
