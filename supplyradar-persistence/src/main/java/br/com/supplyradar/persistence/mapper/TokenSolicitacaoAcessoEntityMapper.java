package br.com.supplyradar.persistence.mapper;

import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.persistence.model.commons.TokenSolicitacaoAcessoEntity;
import org.mapstruct.*;

@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {SolicitacaoAcessoEntityMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TokenSolicitacaoAcessoEntityMapper {
    TokenSolicitacaoAcesso mapFrom(final TokenSolicitacaoAcessoEntity source);
    TokenSolicitacaoAcessoEntity mapFrom(final TokenSolicitacaoAcesso source);
}
