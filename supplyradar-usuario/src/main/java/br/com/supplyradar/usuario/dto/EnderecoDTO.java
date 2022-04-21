package br.com.supplyradar.usuario.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class EnderecoDTO {
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String tipo;
    private String cep;
    private UUID idCidade;
}
