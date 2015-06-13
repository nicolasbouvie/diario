package br.com.niggas.diario.dao;

import static org.hibernate.criterion.Restrictions.eq;

import java.io.Serializable;
import java.util.List;

import br.com.niggas.diario.model.ModelEntity;
public class RestDAO extends AbstractDao<ModelEntity<?>> {
	@SuppressWarnings("unchecked")
	public List<? extends ModelEntity<?>> getAll(Class<?> entity) {
		return createQuery("FROM " + entity.getSimpleName()).list();
	}

	public void removeById(Class<?> entity, Serializable id) throws Exception {
		Object object = getSession()
				.createCriteria(entity)
				.add(eq("id", id))
				.uniqueResult();
		remove(object);
		flush();
	}
}
