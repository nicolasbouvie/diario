package br.com.niggas.diario.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.niggas.diario.controller.Format;
import br.com.niggas.diario.dao.AbstractDao;
import br.com.niggas.diario.dao.RestDAO;
import br.com.niggas.diario.model.ModelEntity;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.thoughtworks.xstream.XStream;
public class RestService extends AbstractService<ModelEntity<?>> {
	@Inject
	private RestDAO dao;

	public void save(String entity, Format format, String data) throws JsonSyntaxException, ClassNotFoundException {
		ModelEntity<?> persist = null;
		switch(format) {
		case JSON:
			Gson gson = new Gson();
			persist = gson.fromJson(data, getEntityType(entity));
			break;
		case XML:
			XStream xStream = new XStream();
			persist = (ModelEntity<?>) xStream.fromXML(data);
			break;
		}
		save(persist);
	}

	public List<? extends ModelEntity<?>> getAll(String entity) throws ClassNotFoundException {
		return dao.getAll(getEntityType(entity));
	}

	public void removeById(String entity, Serializable id) throws Exception {
		dao.removeById(getEntityType(entity), id);
	}

	@SuppressWarnings("unchecked")
	private Class<? extends ModelEntity<?>> getEntityType(String entityName) throws ClassNotFoundException {
		return (Class<? extends ModelEntity<?>>) Class.forName("br.com.niggas.diario.model." + entityName);
	}

	@Override
	protected AbstractDao<ModelEntity<?>> getDao() {
		return dao;
	}
}
