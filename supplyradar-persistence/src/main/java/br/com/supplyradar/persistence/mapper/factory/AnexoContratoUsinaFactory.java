package br.com.supplyradar.persistence.mapper.factory;

import br.com.supplyradar.domain.assinatura.AnexoContrato;
import br.com.supplyradar.persistence.model.assinatura.AnexoContratoEntity;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AnexoContratoUsinaFactory {
    @ObjectFactory
    public AnexoContratoEntity build(final AnexoContrato anexoContrato) {
        final AnexoContratoEntity anexoContratoEntity = new AnexoContratoEntity();
        anexoContratoEntity.setTipo(anexoContrato.getTipo());
        anexoContratoEntity.setDescricao(anexoContrato.getDescricao());
        anexoContratoEntity.setNome(anexoContrato.getNome());
        anexoContratoEntity.setPath(anexoContrato.getPath());
        return anexoContratoEntity;
    }
}
