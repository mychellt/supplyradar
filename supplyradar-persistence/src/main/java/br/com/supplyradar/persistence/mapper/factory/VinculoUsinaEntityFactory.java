package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.commons.Vinculo;
import br.com.supplyradar.domain.commons.VinculoUsina;
import br.com.supplyradar.persistence.model.commons.VinculoEntity;
import br.com.supplyradar.persistence.model.commons.VinculoUsinaEntity;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VinculoUsinaEntityFactory {
    @ObjectFactory
    public VinculoEntity build(final Vinculo vinculo) {
        final VinculoEntity vinculoEntity = new VinculoUsinaEntity();
        vinculoEntity.setBloqueado(vinculo.isBloqueado());
        vinculoEntity.setEmail(vinculo.getEmail());
        return vinculoEntity;
    }
}
