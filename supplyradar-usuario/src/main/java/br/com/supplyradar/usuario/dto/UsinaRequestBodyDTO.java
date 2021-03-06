package br.com.supplyradar.usuario.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@ToString
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UsinaRequestBodyDTO {
    private String cnpj;
    private String inscricaoEstadual;
    private String razaoSocial;
    private String website;
    private String nome;
    private String tipo;
    private EnderecoDTO endereco;
    private EnderecoDTO enderecoCorrespondencia;
}
