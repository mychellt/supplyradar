package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaJuridica extends Pessoa {
    private Cnpj cnpj;
    private String inscricaoEstadual;
    private String nomeFantasia;
    private String website;
    private String razaoSocial;

    @Override
    public void accept(Visitor<Pessoa, ?> visitor) {
        visitor.visit(this);
    }
}
