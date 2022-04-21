package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.commons.Cnpj;
import br.com.supplyradar.domain.commons.Email;
import org.mapstruct.Mapper;

import static java.util.Optional.ofNullable;

@Mapper(componentModel = "spring")
public interface CNPJEntityMapper {
    default String toEmailAddress(Cnpj number){
        return ofNullable(number).map(Cnpj::getNumber).orElse(null);
    }
    default Cnpj toEmail(String number){
        return ofNullable(number).map(addressValue -> Cnpj.builder().number(addressValue).build()).orElse(null);
    }

}
