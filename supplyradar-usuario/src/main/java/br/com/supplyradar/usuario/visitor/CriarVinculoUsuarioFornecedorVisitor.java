package br.com.supplyradar.usuario.visitor;

import br.com.supplyradar.core.persistence.PermissaoRepository;
import br.com.supplyradar.domain.commons.PermissaoVinculo;
import br.com.supplyradar.domain.commons.Fornecedor;
import br.com.supplyradar.domain.commons.VinculoFornecedor;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

@RequiredArgsConstructor
@Component
public class CriarVinculoUsuarioFornecedorVisitor implements Visitor<Fornecedor, VinculoFornecedor> {
    private final CreationOfDomainObjectVisitor creationOfDomainObjectVisitor;
    private final PermissaoRepository permissaoRepository;

    @Override
    public VinculoFornecedor visit(final Fornecedor obj) {
        final VinculoFornecedor vinculoFornecedor = new VinculoFornecedor();
        creationOfDomainObjectVisitor.visit(vinculoFornecedor);
        vinculoFornecedor.setFornecedor(obj);

        final List<PermissaoVinculo> permissoes = emptyIfNull(permissaoRepository.findAllForFornecedor())
                .stream()
                .map(permissao -> PermissaoVinculo.builder()
                            .vinculo(vinculoFornecedor)
                            .atribuido(true)
                            .permissao(permissao)
                            .build())
                .collect(Collectors.toList());

        for(final PermissaoVinculo permissao : CollectionUtils.emptyIfNull(permissoes)) {
            creationOfDomainObjectVisitor.visit(permissao);
        }

        vinculoFornecedor.setPermissoes(permissoes);
        return vinculoFornecedor;
    }
}
