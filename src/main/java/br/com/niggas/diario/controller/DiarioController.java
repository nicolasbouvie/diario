package br.com.niggas.diario.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.niggas.diario.dao.FrequenciaDAO;
import br.com.niggas.diario.dao.TurmaDAO;
import br.com.niggas.diario.model.Frequencia;

@Controller
public class DiarioController extends AbstractController<FrequenciaDAO> {

	@Inject
	private FrequenciaDAO dao;

	@Inject
	private TurmaDAO turmaDAO;

	@Override
	protected FrequenciaDAO getDAO() {
		return dao;
	}

	@Override
	@Get("/diario")
	public void index() {
		super.list();
		result.include("turmas", turmaDAO.getAll());
	}

	@Post("/diario/salvar")
	public void salvar(Frequencia diario) {
		super.save(diario);
	}

	@Get("/diario/remover")
	public void remover(Long id) {
		super.remove(id);
	}
}
