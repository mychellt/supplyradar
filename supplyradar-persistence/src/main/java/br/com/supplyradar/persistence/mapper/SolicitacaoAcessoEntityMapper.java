package br.com.supplyradar.persistence.mapper;

import br.com.supplyradar.domain.commons.SolicitacaoAcesso;
import br.com.supplyradar.persistence.mapper.factory.PessoaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaFactory;
import br.com.supplyradar.persistence.model.commons.SolicitacaoAcessoEntity;
import org.mapstruct.*;

@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {UsuarioEntityMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SolicitacaoAcessoEntityMapper {
    SolicitacaoAcesso mapFrom(final SolicitacaoAcessoEntity solicitacaoAcessoEntity);
    SolicitacaoAcessoEntity mapFrom(final SolicitacaoAcesso solicitacaoAcesso);
}
