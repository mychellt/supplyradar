package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.assinatura.AnexoContrato;
import br.com.supplyradar.persistence.model.assinatura.AnexoContratoEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AnexoContratoEntityMapper {
    AnexoContrato mapFrom(final AnexoContrato anexoContrato);
    AnexoContratoEntity mapFrom(final AnexoContratoEntity anexoContrato);
}
