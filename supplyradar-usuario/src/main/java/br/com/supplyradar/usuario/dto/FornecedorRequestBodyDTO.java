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
public class FornecedorRequestBodyDTO {
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String telefone;
    private String inscricaoEstadual;
    private String website;
    private EnderecoDTO endereco;
    private String experiencias;
    private String fornecimentos;
    private boolean atendimento24horas;
}
