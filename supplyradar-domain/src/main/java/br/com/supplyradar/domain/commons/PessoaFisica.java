package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaFisica extends Pessoa {
    private Date dataNascimento;
    private String nomeMae;
    private String nomePai;
    private String nome;
    private String cpfPassaporte;
    private boolean passaporte;

    @Override
    public void accept(Visitor<Pessoa, ?> visitor) {
        visitor.visit(this);
    }
}
