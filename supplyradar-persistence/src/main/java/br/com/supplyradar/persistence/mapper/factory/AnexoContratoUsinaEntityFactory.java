package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.assinatura.AnexoContrato;
import br.com.supplyradar.persistence.mapper.ContratoFornecedorEntityMapper;
import br.com.supplyradar.persistence.model.assinatura.AnexoContratoEntity;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AnexoContratoUsinaEntityFactory {

    @ObjectFactory
    public AnexoContrato build(final AnexoContratoEntity anexoContratoEntity) {
        final AnexoContrato anexoContrato = new AnexoContrato();
        anexoContrato.setTipo(anexoContratoEntity.getTipo());
        anexoContrato.setDescricao(anexoContratoEntity.getDescricao());
        anexoContrato.setNome(anexoContratoEntity.getNome());
        anexoContrato.setPath(anexoContratoEntity.getPath());
        return anexoContrato;
    }
}
