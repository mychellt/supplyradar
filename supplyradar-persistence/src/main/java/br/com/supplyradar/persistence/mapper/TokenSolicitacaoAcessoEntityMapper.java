package br.com.supplyradar.persistence.mapper;

import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.persistence.model.commons.TokenSolicitacaoAcessoEntity;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {SolicitacaoAcessoEntityMapper.class})
public interface TokenSolicitacaoAcessoEntityMapper {
    TokenSolicitacaoAcesso mapFrom(final TokenSolicitacaoAcessoEntity source);
    TokenSolicitacaoAcessoEntity mapFrom(final TokenSolicitacaoAcesso source);
}
