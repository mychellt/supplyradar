package br.com.supplyradar.persistence.mapper;

import br.com.supplyradar.domain.assinatura.Contrato;
import br.com.supplyradar.persistence.mapper.factory.*;
import br.com.supplyradar.persistence.model.assinatura.ContratoEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = {
                PessoaJuricaEntityFactory.class,
                PessoaJuridicaFactory.class,
                FornecedorEntityMapper.class,
                EmailEntityMapper.class,
                AnexoContratoUsinaEntityFactory.class,
                AnexoContratoUsinaFactory.class,
                ContratoFornecedorFactory.class,
                ContratoFornecedorEntityFactory.class,
                AnexoContratoEntityMapper.class,
                CycleAvoidingMappingJpaContext.class
        },
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ContratoFornecedorEntityMapper {
        ContratoEntity mapFrom(final Contrato source);
        Contrato mapFrom(final ContratoEntity source);
}
