package br.com.niggas.diario.controller;

import br.com.caelum.vraptor.serialization.Serialization;
import br.com.caelum.vraptor.view.Results;

public enum Format {
	JSON(Results.json()), XML(Results.xml());
	private final Class<? extends Serialization> resultType;

	private Format(Class<? extends Serialization> resultType) {
		this.resultType = resultType;
	}
	public Class<? extends Serialization> getResultType() {
		return resultType;
	}
}
