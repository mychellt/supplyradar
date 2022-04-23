package br.com.supplyradar.persistence.mapper;

import br.com.supplyradar.domain.commons.Fornecedor;
import br.com.supplyradar.persistence.mapper.factory.ContratoUsinaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.ContratoUsinaFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaJuricaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaJuridicaFactory;
import br.com.supplyradar.persistence.model.commons.FornecedorEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = {PessoaJuricaEntityFactory.class,
                PessoaJuridicaFactory.class,
                ContratoUsinaFactory.class,
                ContratoUsinaEntityFactory.class,
                EmailEntityMapper.class,
                CategoriaEntityMapper.class,
                ProdutoEntityMapper.class,
                ContratoFornecedorEntityMapper.class,
                CycleAvoidingMappingJpaContext.class
        },
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FornecedorEntityMapper {
        FornecedorEntity mapFrom(final Fornecedor fornecedor);
        Fornecedor mapFrom(final FornecedorEntity fornecedorEntity);
}
