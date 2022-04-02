package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.DomainObject;
import lombok.*;

import java.util.regex.Pattern;

import static java.util.Objects.isNull;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cnpj implements DomainObject {
    private static final long serialVersionUID = -3785447707461920934L;
    public static final String PATTERN = "^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$";

    private String number;

    private boolean isValid() {
        return this.number != null && Pattern.compile(PATTERN).matcher(this.number).find();
    }

    public boolean isBlank() {
        return isNull(number) || this.number.trim().isBlank();
    }
}
