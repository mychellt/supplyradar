package br.com.supplyradar.domain.commons;

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Atendimento {
    private boolean contingencia;
    private boolean atendimento24Horas;
}
