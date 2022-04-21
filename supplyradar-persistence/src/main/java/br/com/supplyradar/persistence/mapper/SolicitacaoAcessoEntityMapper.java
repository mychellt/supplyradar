package br.com.supplyradar.persistence.mapper;

import br.com.supplyradar.domain.commons.SolicitacaoAcesso;
import br.com.supplyradar.persistence.mapper.factory.PessoaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaFactory;
import br.com.supplyradar.persistence.model.commons.SolicitacaoAcessoEntity;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {UsuarioEntityMapper.class, PessoaEntityFactory.class, PessoaFactory.class})
public interface SolicitacaoAcessoEntityMapper {
    SolicitacaoAcesso mapFrom(final SolicitacaoAcessoEntity source);
    SolicitacaoAcessoEntity mapFrom(final SolicitacaoAcesso source);
}
