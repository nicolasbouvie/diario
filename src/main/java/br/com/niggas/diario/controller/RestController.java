package br.com.niggas.diario.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.niggas.diario.service.RestService;

import com.google.gson.JsonSyntaxException;

@Controller
@Path("/rest")
public class RestController {
	@Inject
	private Result result;

	@Inject
	private RestService service;

	@Get("/{entity}/listar.{format}")
	public void list(String entity, Format format) {
		try {
			result.use(format.getResultType()).from(service.getAll(entity)).serialize();
		} catch (ClassNotFoundException e) {
			result.use(Results.status()).badRequest("Invalid entity " + entity);
		}
	}

	@Put("/{entity}/salvar.{format}")
	@Consumes({"application/json", "application/xml"})
	public void saveAluno(String entity, Format format, String obj) {
		try {
			service.save(entity, format, obj);
			result.use(Results.status()).ok();
		} catch (JsonSyntaxException | ClassNotFoundException e) {
			e.printStackTrace();
			result.use(Results.status()).badRequest(e.getMessage());
		}
	}

	@Delete("/{entity}/remover/{id}.{format}")
	@Consumes({"application/json", "application/xml"})
	public void removeAluno(String entity, Long id, Format format) throws Exception {
		service.removeById(entity, id);
		result.use(Results.status()).ok();
	}
}