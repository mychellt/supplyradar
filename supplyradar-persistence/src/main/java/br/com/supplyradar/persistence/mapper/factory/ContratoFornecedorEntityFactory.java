package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.assinatura.Contrato;
import br.com.supplyradar.domain.assinatura.ContratoFornecedor;
import br.com.supplyradar.persistence.model.assinatura.ContratoEntity;
import br.com.supplyradar.persistence.model.assinatura.ContratoFornecedorEntity;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ContratoFornecedorEntityFactory {
    @ObjectFactory
    public ContratoEntity build(Contrato contrato) {
        final ContratoFornecedorEntity contratoEntity = new ContratoFornecedorEntity();
        contratoEntity.setAtivo(contratoEntity.isAtivo());
        contratoEntity.setDateOfChange(contratoEntity.getDateOfChange());
        contratoEntity.setDateOfCreate(contratoEntity.getDateOfCreate());
        contratoEntity.setId(contratoEntity.getId());
        contratoEntity.setVigencia(contratoEntity.getVigencia());
        contratoEntity.setPendencia(contratoEntity.getPendencia());
        return contratoEntity;
    }
}
