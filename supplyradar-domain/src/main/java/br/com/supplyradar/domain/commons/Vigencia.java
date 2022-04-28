package br.com.supplyradar.domain.commons;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vigencia {
    private LocalDate inicio;
    private LocalDate fim;
}
