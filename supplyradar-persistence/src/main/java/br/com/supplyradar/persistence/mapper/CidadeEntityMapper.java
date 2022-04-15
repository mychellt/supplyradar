package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.commons.Cidade;
import br.com.supplyradar.persistence.model.commons.CidadeEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;


@Mapper(builder = @Builder(disableBuilder = true))
public interface CidadeEntityMapper {
    Cidade mapFrom(CidadeEntity source);
    CidadeEntity mapFrom(Cidade source);
}
