package br.com.niggas.diario.model.type;

public enum Presenca {
	PRESENTE('P'), AUSENTE('F'), JUSTIFICADO('J');
	public final Character id;

	private Presenca(Character id) {
		this.id = id;
	}

	public static Presenca getPresenca(String name) {
		for (Presenca p : values()) {
			if (p.id.toString().equals(name)) {
				return p;
			}
		}
		return null;
	}
}
