package br.com.supplyradar.persistence.model.commons;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class AtuacaoEntity {
    @Column(name = "descricao_atuacao")
    private String descricao;

    @Column(name = "resumo_atuacao")
    private String resumo;
}
