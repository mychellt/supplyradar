package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.assinatura.Contrato;
import br.com.supplyradar.persistence.model.assinatura.ContratoEntity;
import br.com.supplyradar.persistence.model.assinatura.ContratoUsinaEntity;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FactoryContratoEntityUsina {

    @ObjectFactory
    public ContratoEntity build(Contrato contrato) {
        final ContratoUsinaEntity contratoUsinaEntity = new ContratoUsinaEntity();
        contratoUsinaEntity.setAtivo(contrato.isAtivo());
        contratoUsinaEntity.setDateOfChange(contrato.getDateOfChange());
        contratoUsinaEntity.setDateOfCreate(contrato.getDateOfCreate());
        contratoUsinaEntity.setId(contrato.getId());
        contratoUsinaEntity.setVigencia(contrato.getDataVigencia());
        contratoUsinaEntity.setPendencia(contrato.getPendencia());
        return contratoUsinaEntity;
    }
}
