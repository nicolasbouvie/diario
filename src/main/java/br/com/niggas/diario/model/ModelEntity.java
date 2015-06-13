package br.com.niggas.diario.model;

import java.io.Serializable;

public interface ModelEntity<T> extends Serializable {
	T getId();
	void setId(T id);
}
