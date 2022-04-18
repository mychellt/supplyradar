package br.com.supplyradar.usuario.controller;

import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.domain.exceptions.MandatoryFieldException;
import br.com.supplyradar.usuario.validator.ValidTokenSolicitacaoAcessoValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.supplyradar.usuario.processor.ValidTokenSolicitacaoAcessoCommandProcessor;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/public")
public class ValidTokenSolicitacaoAcessoController {
    private final ValidTokenSolicitacaoAcessoValidator validTokenSolicitacaoAcessoValidator;
    private final ValidTokenSolicitacaoAcessoCommandProcessor processor;

    @GetMapping(path = "/token/{key}")
    public ResponseEntity<Void> execute(@PathVariable(value = "key") UUID key) {
        validTokenSolicitacaoAcessoValidator.validate(key).isInvalidThrow(MandatoryFieldException.class);

        CommandContext commandContext = new CommandContext();
        commandContext.setData(key);

        processor.process(commandContext);

        return ResponseEntity.ok().build();
    }
}
