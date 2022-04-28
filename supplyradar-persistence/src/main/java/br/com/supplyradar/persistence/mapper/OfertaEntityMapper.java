package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.assinatura.Oferta;
import br.com.supplyradar.persistence.model.assinatura.OfertaEntity;
import org.mapstruct.Builder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OfertaEntityMapper {
    Oferta mapFrom(OfertaEntity source);
    OfertaEntity mapFrom(Oferta source);
}
