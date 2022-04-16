package br.com.supplyradar.persistence.adapter;

import br.com.supplyradar.core.persistence.UnidadeFederativaRepository;
import br.com.supplyradar.domain.commons.UnidadeFederativa;
import br.com.supplyradar.persistence.adapter.jpa.UnidadeFederativaJpaRepository;
import br.com.supplyradar.persistence.mapper.UnidadeFederativaEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class UnidadeFederativaRepositoryAdapter implements UnidadeFederativaRepository {
    private final UnidadeFederativaJpaRepository jpa;
    private final UnidadeFederativaEntityMapper mapper;

    @Override
    public UnidadeFederativa save(UnidadeFederativa unidadeFederativa) {
        return mapper.mapFrom(jpa.save(mapper.mapFrom(unidadeFederativa)));
    }
}
