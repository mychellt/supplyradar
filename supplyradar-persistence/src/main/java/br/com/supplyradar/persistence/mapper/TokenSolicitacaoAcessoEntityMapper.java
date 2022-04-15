package br.com.supplyradar.persistence.mapper;

import br.com.supplyradar.domain.commons.TokenSolicitacaoAcesso;
import br.com.supplyradar.persistence.model.commons.TokenSolicitacaoAcessoEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(builder = @Builder(disableBuilder = true),
        uses = {SolicitacaoAcessoEntityMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TokenSolicitacaoAcessoEntityMapper {
    TokenSolicitacaoAcesso mapFrom(final TokenSolicitacaoAcessoEntity source);
    TokenSolicitacaoAcessoEntity mapFrom(final TokenSolicitacaoAcesso source);
}
