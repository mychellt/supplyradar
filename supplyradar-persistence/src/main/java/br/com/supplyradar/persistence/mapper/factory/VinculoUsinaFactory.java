package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.commons.Vinculo;
import br.com.supplyradar.domain.commons.VinculoFornecedor;
import br.com.supplyradar.domain.commons.VinculoUsina;
import br.com.supplyradar.persistence.model.commons.VinculoEntity;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VinculoUsinaFactory {
    @ObjectFactory
    public Vinculo build(final VinculoEntity vinculoEntity) {
        final Vinculo vinculo = new VinculoUsina();
        vinculo.setBloqueado(vinculoEntity.isBloqueado());
        vinculo.setEmail(vinculoEntity.getEmail());
        return vinculo;
    }
}
