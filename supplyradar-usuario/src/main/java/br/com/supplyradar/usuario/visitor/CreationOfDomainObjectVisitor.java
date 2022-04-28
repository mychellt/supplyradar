package br.com.supplyradar.usuario.visitor;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.visitors.Visitor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CreationOfDomainObjectVisitor implements Visitor<AbstractDomainObject<UUID>, Void> {
    @Override
    public Void visit(AbstractDomainObject<UUID> obj) {
        obj.setAtivo(Boolean.TRUE);
        obj.setDateOfChange(LocalDateTime.now());
        obj.setDateOfCreate(LocalDateTime.now());
        return null;
    }
}
