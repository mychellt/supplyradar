package br.com.supplyradar.domain.api;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.commons.Endereco;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorRequestBody extends AbstractDomainObject<UUID> {
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String telefone;
    private String inscricaoEstadual;
    private String website;
    private Endereco endereco;
    private String experiencias;
    private String fornecimentos;
    private boolean atendimento24horas;
}
