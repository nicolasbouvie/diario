package br.com.niggas.diario.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.niggas.diario.dao.AlunoDAO;
import br.com.niggas.diario.dao.DisciplinaDAO;
import br.com.niggas.diario.dao.ProfessorDAO;
import br.com.niggas.diario.dao.TurmaDAO;
import br.com.niggas.diario.model.Turma;

@Controller
public class TurmaController extends AbstractController<TurmaDAO> {

	@Inject
	private TurmaDAO dao;

	@Inject
	private DisciplinaDAO disciplinaDAO;

	@Inject
	private ProfessorDAO professorDAO;

	@Inject
	private AlunoDAO alunoDAO;

	@Override
	protected TurmaDAO getDAO() {
		return dao;
	}

	@Override
	@Get("/turma")
	public void index() {
		super.list();
		result.include("_disciplina", disciplinaDAO.getAll());
		result.include("_professor", professorDAO.getAll());
	}

	@Get("/turma/aluno")
	public void aluno(Long turma) {
		result.include("turma", dao.findById(turma));
		result.include("alunos", alunoDAO.getAll());
	}

	@Post("/turma/aluno/incluir")
	public void incluirAluno(Long turma, Long aluno) {
		Turma turmaEntity = dao.findById(turma);
		turmaEntity.addAluno(alunoDAO.findById(aluno));
		super.save(turmaEntity);
	}

	@Post("/turma/salvar")
	public void salvar(Turma turma) {
		super.save(turma);
	}

	@Get("/turma/remover")
	public void remover(Long id) {
		super.remove(id);
	}
}
