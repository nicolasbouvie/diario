package br.com.niggas.diario.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.niggas.diario.dao.AbstractDao;

public abstract class AbstractController<DAO extends AbstractDao<?>> {

	@Inject
	protected Result result;

	public abstract void index();
	protected abstract DAO getDAO();

	protected void list() {
		result.include("lista", getDAO().getAll());
	}

	protected void save(Object instance) {
		getDAO().save(instance);
		result.redirectTo(getClass()).index();
	}

	protected void remove(Long id) {
		getDAO().removeById(id);
		result.redirectTo(getClass()).index();
	}
}
