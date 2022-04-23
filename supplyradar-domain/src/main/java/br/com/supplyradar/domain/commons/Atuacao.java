package br.com.supplyradar.domain.commons;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Atuacao {
    private String descricao;
    private String resumo;
}
