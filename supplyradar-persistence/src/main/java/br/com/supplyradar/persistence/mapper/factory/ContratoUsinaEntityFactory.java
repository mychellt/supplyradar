package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.assinatura.Contrato;
import br.com.supplyradar.domain.commons.Vigencia;
import br.com.supplyradar.persistence.model.assinatura.ContratoEntity;
import br.com.supplyradar.persistence.model.assinatura.ContratoUsinaEntity;
import br.com.supplyradar.persistence.model.assinatura.VigenciaEntity;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

@Component
@AllArgsConstructor
public class ContratoUsinaEntityFactory {

    @ObjectFactory
    public ContratoEntity build(Contrato contrato) {
        final ContratoUsinaEntity contratoEntity = new ContratoUsinaEntity();
        contratoEntity.setAtivo(contrato.isAtivo());
        contratoEntity.setDateOfChange(contrato.getDateOfChange());
        contratoEntity.setDateOfCreate(contrato.getDateOfCreate());
        contratoEntity.setId(contrato.getId());
        contratoEntity.setVigencia(VigenciaEntity.builder()
                .fim(ofNullable(contrato.getVigencia()).map(Vigencia::getFim).orElse(null))
                .inicio(ofNullable(contrato.getVigencia()).map(Vigencia::getInicio).orElse(null))
                .build());
        return contratoEntity;
    }
}
