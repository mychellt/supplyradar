package br.com.supplyradar.core.persistence;

import br.com.supplyradar.domain.assinatura.Oferta;

import java.util.UUID;

public interface OfertaRepository {
    Oferta save(final Oferta oferta);
    Oferta findById(final UUID id);
}
