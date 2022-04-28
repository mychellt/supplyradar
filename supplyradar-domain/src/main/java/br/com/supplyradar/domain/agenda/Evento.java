package br.com.supplyradar.domain.agenda;

import br.com.supplyradar.domain.AbstractDomainObject;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Evento extends AbstractDomainObject<UUID> {
    private Agenda agenda;
    private String titulo;
    private LocalDate inicio;
    private LocalDate fim;
    private String hora;
    private String descricao;
    private boolean editavel;
    private String urlAcesso;
    private UUID objectId;
    private TipoEvento tipo;
}
