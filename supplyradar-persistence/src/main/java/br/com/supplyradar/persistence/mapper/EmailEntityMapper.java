package br.com.supplyradar.persistence.mapper;


import br.com.supplyradar.domain.commons.Email;
import org.mapstruct.Mapper;

import static java.util.Optional.ofNullable;

@Mapper(componentModel = "spring")
public interface EmailEntityMapper {
    default String toEmailAddress(Email email){
        return ofNullable(email).map(Email::getAddress).orElse(null);
    }
    default Email toEmail(String address){
        return ofNullable(address).map(addressValue -> Email.builder().address(addressValue).build()).orElse(null);
    }

}
