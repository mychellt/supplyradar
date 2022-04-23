package br.com.supplyradar.persistence.mapper;

import br.com.supplyradar.domain.commons.Produto;
import br.com.supplyradar.persistence.mapper.factory.*;
import br.com.supplyradar.persistence.model.commons.ProdutoEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = {
                PessoaJuricaEntityFactory.class,
                PessoaJuridicaFactory.class,
                ContratoFornecedorFactory.class,
                ContratoFornecedorEntityFactory.class,
                EmailEntityMapper.class,
                CycleAvoidingMappingJpaContext.class
        },
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProdutoEntityMapper {
    Produto mapFrom(final ProdutoEntity source);
    ProdutoEntity mapFrom(final Produto source);
}
