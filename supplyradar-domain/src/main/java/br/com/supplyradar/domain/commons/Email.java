package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.DomainObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

import static java.util.Objects.nonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Email implements DomainObject {
    private String address;
    public static final String PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    private boolean isValid() {
        return nonNull(address) && Pattern.compile(PATTERN).matcher(this.address).find();
    }
}
