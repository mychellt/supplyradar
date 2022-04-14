package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.commons.PessoaFisica;
import br.com.supplyradar.domain.commons.PessoaJuridica;
import br.com.supplyradar.persistence.mapper.factory.PessoaEntityFactory;
import br.com.supplyradar.persistence.mapper.factory.PessoaFactory;
import br.com.supplyradar.persistence.model.commons.PessoaFisicaEntity;
import br.com.supplyradar.persistence.model.commons.PessoaJuridicaEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;


@Mapper(builder = @Builder(disableBuilder = true),
        uses = {PessoaEntityFactory.class, PessoaFactory.class, EmailEntityMapper.class, CNPJEntityMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class PessoaEntityMapper {
    private static final PessoaEntityMapper instance = Mappers.getMapper(PessoaEntityMapper.class);
    public static PessoaEntityMapper getInstance() {
        return instance;
    }

    public abstract PessoaJuridica mapFrom(PessoaJuridicaEntity source);
    public abstract PessoaJuridicaEntity mapFrom(PessoaJuridica source);
    public abstract PessoaFisica mapFrom(PessoaFisicaEntity source);
    public abstract PessoaFisicaEntity mapFrom(PessoaFisica source);
}
