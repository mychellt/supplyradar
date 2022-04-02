package br.com.supplyradar.domain.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoEndereco {
    RESIDENCIAL("Residencial"),
    COMERCIAL("Comercial"),
    CORRESPONDENCIA("Correspondência");

    private final String nome;
}
