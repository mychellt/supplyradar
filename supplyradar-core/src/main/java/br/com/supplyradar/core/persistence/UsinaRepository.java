package br.com.supplyradar.core.persistence;

import br.com.supplyradar.domain.commons.Usina;

public interface UsinaRepository {
    Usina save(final Usina usina);
}
