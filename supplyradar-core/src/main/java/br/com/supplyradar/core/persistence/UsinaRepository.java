package br.com.supplyradar.core.persistence;

import br.com.supplyradar.domain.commons.Usina;

import java.util.UUID;

public interface UsinaRepository {
    Usina save(final Usina usina);
    Usina findById(final UUID id);
}
