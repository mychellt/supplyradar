package br.com.supplyradar.persistence.mapper;

import br.com.supplyradar.domain.commons.SolicitacaoAcesso;
import br.com.supplyradar.persistence.model.commons.SolicitacaoAcessoEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(builder = @Builder(disableBuilder = true),
        uses = {UsuarioEntityMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SolicitacaoAcessoEntityMapper {
    SolicitacaoAcesso mapFrom(final SolicitacaoAcessoEntity source);
    SolicitacaoAcessoEntity mapFrom(final SolicitacaoAcesso source);
}
