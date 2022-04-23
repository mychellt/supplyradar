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
public class AtendimentoEntity {
    @Column(name = "atendimento_contingencia")
    private boolean contingencia;

    @Column(name = "atendimento_24horas")
    private boolean atendimento24Horas;
}
