package br.com.supplyradar.usuario.processor;

import br.com.supplyradar.core.command.Command;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.core.persistence.FornecedorRepository;
import br.com.supplyradar.domain.api.FornecedorRequestBody;
import br.com.supplyradar.domain.commons.Fornecedor;
import br.com.supplyradar.usuario.visitor.CreationOfDomainObjectVisitor;
import br.com.supplyradar.usuario.visitor.CriarAgendaVisitor;
import br.com.supplyradar.usuario.visitor.CriarAnuidadeFornecedorVisitor;
import br.com.supplyradar.usuario.visitor.CriarVinculoUsuarioFornecedorVisitor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CriarFornecedorCommandProcessor implements Command<Fornecedor> {
    private final FornecedorRepository fornecedorRepository;
    private final CreationOfDomainObjectVisitor creationOfDomainObjectVisitor;
    private final CriarVinculoUsuarioFornecedorVisitor criarVinculoUsuarioFornecedorVisitor;
    private final CriarAgendaVisitor criarAgendaVisitor;
    private final CriarAnuidadeFornecedorVisitor criarAnuidadeFornecedorVisitor;

    @Override
    public Fornecedor process(CommandContext context) {
        final FornecedorRequestBody fornecedorRequestBody = context.getData(FornecedorRequestBody.class);

        Fornecedor fornecedor = new Fornecedor();

        creationOfDomainObjectVisitor.visit(fornecedor);
        criarVinculoUsuarioFornecedorVisitor.visit(fornecedor);
        criarAgendaVisitor.visit(fornecedor);
        criarAnuidadeFornecedorVisitor.visit(fornecedor);
        fornecedorRepository.save(fornecedor);

        return fornecedor;
    }
}
