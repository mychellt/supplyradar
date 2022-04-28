package br.com.supplyradar.domain.assinatura;

import br.com.supplyradar.domain.commons.Fornecedor;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssinaturaFornecedor extends Assinatura {
    private Fornecedor fornecedor;
}
