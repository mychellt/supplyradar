package br.com.supplyradar.persistence.adapter;

import br.com.supplyradar.core.persistence.OfertaRepository;
import br.com.supplyradar.domain.assinatura.Oferta;
import br.com.supplyradar.persistence.adapter.jpa.OfertaJpaRepository;
import br.com.supplyradar.persistence.mapper.OfertaEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@RequiredArgsConstructor
@Repository
public class OfertaRepositoryAdapter implements OfertaRepository {
    private final OfertaJpaRepository jpa;
    private final OfertaEntityMapper mapper;
    @Override
    public Oferta save(Oferta oferta) {
        return mapper.mapFrom(jpa.save(mapper.mapFrom(oferta)));
    }

    @Override
    public Oferta findById(UUID id) {
        return jpa.findById(id).map(mapper::mapFrom).orElse(null);
    }
}
