package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class PermissaoVinculo extends AbstractDomainObject<UUID> {
    private Permissao permissao;
    private Vinculo vinculo;
    private boolean atribuido;
}
