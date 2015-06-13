package br.com.niggas.diario.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.niggas.diario.dao.DisciplinaDAO;
import br.com.niggas.diario.model.Disciplina;

@Controller
public class DisciplinaController extends AbstractController<DisciplinaDAO> {

	@Inject
	private DisciplinaDAO dao;

	@Override
	protected DisciplinaDAO getDAO() {
		return dao;
	}

	@Override
	@Get("/disciplina")
	public void index() {
		super.list();
	}

	@Post("/disciplina/salvar")
	public void salvar(Disciplina disciplina) {
		super.save(disciplina);
	}

	@Get("/disciplina/remover")
	public void remover(Long id) {
		super.remove(id);
	}
}
