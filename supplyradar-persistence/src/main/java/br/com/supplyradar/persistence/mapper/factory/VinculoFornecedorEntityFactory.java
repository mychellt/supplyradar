package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.commons.Vinculo;
import br.com.supplyradar.persistence.model.commons.VinculoEntity;
import br.com.supplyradar.persistence.model.commons.VinculoFornecedorEntity;
import br.com.supplyradar.persistence.model.commons.VinculoUsinaEntity;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VinculoFornecedorEntityFactory {
    @ObjectFactory
    public VinculoEntity build(final Vinculo vinculo) {
        final VinculoEntity vinculoEntity = new VinculoFornecedorEntity();
        vinculoEntity.setBloqueado(vinculo.isBloqueado());
        vinculoEntity.setEmail(vinculo.getEmail());
        return vinculoEntity;
    }
}
