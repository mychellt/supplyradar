package br.com.supplyradar.usuario.visitor;

import br.com.supplyradar.domain.commons.Fornecedor;
import br.com.supplyradar.domain.visitors.Visitor;
import org.springframework.stereotype.Component;

@Component
public class CriarAnuidadeFornecedorVisitor implements Visitor<Fornecedor, Void> {

    @Override
    public Void visit(Fornecedor obj) {
        return null;
    }
}
