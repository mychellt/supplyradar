package br.com.supplyradar.domain.agenda;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.commons.Empresa;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Agenda extends AbstractDomainObject<UUID> {
    private Empresa empresa;
    private List<Evento> eventos;
}
