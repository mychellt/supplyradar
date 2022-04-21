package br.com.supplyradar.persistence.adapter;

import br.com.supplyradar.core.persistence.UsinaRepository;
import br.com.supplyradar.domain.commons.Usina;
import br.com.supplyradar.persistence.adapter.jpa.UsinaJpaRepository;
import br.com.supplyradar.persistence.mapper.UsinaEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class UsinaRepositoryAdapter implements UsinaRepository {
    private final UsinaJpaRepository jpa;
    private final UsinaEntityMapper usinaEntityMapper;

    @Override
    public Usina save(Usina usina) {
        return usinaEntityMapper.mapFrom(jpa.save(usinaEntityMapper.mapFrom(usina)));
    }
}
