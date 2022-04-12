package br.com.supplyradar.domain.processo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Numeracao implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer numero;
	private Integer ano;

	public String getNumeracaoFormatada() {
		if (!Objects.isNull(this.numero) && !Objects.isNull(this.ano)) {
			return completarComZeros(this.numero, 6) + "/" + this.ano;
		} else {
			return "S/N";
		}
	}
	
	public static String completarComZeros(Integer numero, Integer quantidadeDigitos) {
		if (!Objects.isNull(numero)) {
			String numeroStr = numero.toString();
			return "0".repeat(Math.max(0, quantidadeDigitos - numeroStr.length())) +
					numero;
		}
		return "";
	}
}
