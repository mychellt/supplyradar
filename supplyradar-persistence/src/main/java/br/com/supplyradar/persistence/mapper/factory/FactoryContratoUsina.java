package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.assinatura.Contrato;
import br.com.supplyradar.domain.assinatura.ContratoUsina;
import br.com.supplyradar.persistence.model.assinatura.ContratoEntity;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FactoryContratoUsina {
    @ObjectFactory
    public Contrato build(ContratoEntity contratoEntity) {
        final ContratoUsina contratoUsina = new ContratoUsina();
        contratoUsina.setAtivo(contratoEntity.isAtivo());
        contratoUsina.setDateOfChange(contratoEntity.getDateOfChange());
        contratoUsina.setDateOfCreate(contratoEntity.getDateOfCreate());
        contratoUsina.setId(contratoEntity.getId());
        contratoUsina.setDataVigencia(contratoEntity.getVigencia());
        contratoUsina.setPendencia(contratoEntity.getPendencia());
        return contratoUsina;
    }
}
