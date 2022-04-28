package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.assinatura.Contrato;
import br.com.supplyradar.domain.assinatura.ContratoFornecedor;
import br.com.supplyradar.domain.commons.Vigencia;
import br.com.supplyradar.persistence.model.assinatura.ContratoEntity;
import br.com.supplyradar.persistence.model.assinatura.VigenciaEntity;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

import static java.util.Optional.ofNullable;

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
        contrato.setVigencia(Vigencia.builder()
                .fim(ofNullable(contratoEntity.getVigencia()).map(VigenciaEntity::getFim).orElse(null))
                .inicio(ofNullable(contratoEntity.getVigencia()).map(VigenciaEntity::getInicio).orElse(null))
                .build());
        return contrato;
    }
}
