package com.nelioalves.cursomc.domain.enums;
/*
 * Esta é uma implementação sofisticada para termos controle do código
 */
public enum TipoCliente {
	PESSOAFISICA  (1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	// tipo enumerado nao muda, é so getter
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	// static pode utilizar a variável mesmo sem instancia-la
	public static TipoCliente toEnum(Integer cod) {
		// recebe cod e devolve x que é um dos enum correspondente ao cod.
		if(cod==null) {
			return null;
		}
		// percorre todo o enum
		for (TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}	
		// se nao encontrar
		throw new IllegalArgumentException("Id inválido: " + cod);
	}	
}
