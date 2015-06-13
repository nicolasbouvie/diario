package br.com.niggas.diario.service;

import javax.enterprise.context.RequestScoped;

import br.com.niggas.diario.dao.AbstractDao;

@RequestScoped
public abstract class AbstractService<T> {

	public T findById(Long id) {
		return getDao().findById(id);
	}

	@SuppressWarnings("unchecked")
	public T save(T instance) {
		setDefaultValues(instance);
		return (T) getDao().save(instance);
	}

	protected void setDefaultValues(T instance) {
		// Must be implemented on Concrete Service
	}

	protected abstract AbstractDao<T> getDao();


}
