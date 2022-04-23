package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.assinatura.Contrato;
import br.com.supplyradar.domain.assinatura.ContratoFornecedor;
import br.com.supplyradar.persistence.model.assinatura.ContratoEntity;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ContratoFornecedorFactory {
    @ObjectFactory
    public Contrato build(ContratoEntity contratoEntity) {
        final ContratoFornecedor contrato = new ContratoFornecedor();
        contrato.setAtivo(contratoEntity.isAtivo());
        contrato.setDateOfChange(contratoEntity.getDateOfChange());
        contrato.setDateOfCreate(contratoEntity.getDateOfCreate());
        contrato.setId(contratoEntity.getId());
        contrato.setVigencia(contratoEntity.getVigencia());
        contrato.setPendencia(contratoEntity.getPendencia());
        return contrato;
    }
}
