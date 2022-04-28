package br.com.supplyradar.persistence.model.assinatura;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class VigenciaEntity {
    @Column(name="inicio_vigencia")
    private LocalDate inicio;

    @Column(name="fim_vigencia")
    private LocalDate fim;
}
