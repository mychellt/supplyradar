package br.com.supplyradar.usuario.visitor;

import br.com.supplyradar.domain.agenda.Agenda;
import br.com.supplyradar.domain.commons.Empresa;
import br.com.supplyradar.domain.visitors.Visitor;
import org.springframework.stereotype.Component;

@Component
public class CriarAgendaVisitor implements Visitor<Empresa, Void> {
    @Override
    public Void visit(Empresa obj) {
        Agenda agenda = new Agenda();
        agenda.setEmpresa(obj);
        return null;
    }
}
