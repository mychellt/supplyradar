package br.com.supplyradar.usuario.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CreateUsinaDTO {
    private String cnpj;
    private String inscricaoEstadual;
    private String razaoSocial;
    private String website;
    private EnderecoDTO endereco;
}
