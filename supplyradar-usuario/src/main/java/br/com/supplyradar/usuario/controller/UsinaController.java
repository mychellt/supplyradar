package br.com.supplyradar.usuario.controller;

import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.domain.commons.UsinaRequestBody;
import br.com.supplyradar.domain.exceptions.MandatoryFieldException;
import br.com.supplyradar.usuario.dto.UsinaRequestBodyDTO;
import br.com.supplyradar.usuario.mapper.UsinaRequestBodyDTOMapper;
import br.com.supplyradar.usuario.processor.CadastrarUsinaCommandProcessor;
import br.com.supplyradar.usuario.validator.CadastrarUsinaValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/usinas")
public class UsinaController {

    private final CadastrarUsinaCommandProcessor cadastrarUsinaCommandProcessor;
    private final UsinaRequestBodyDTOMapper usinaRequestBodyDTOMapper;
    private final CadastrarUsinaValidator cadastrarUsinaValidator;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody final UsinaRequestBodyDTO usinaRequestBodyDTO) {

        cadastrarUsinaValidator.validate(usinaRequestBodyDTO).isInvalidThrow(MandatoryFieldException.class);

        final UsinaRequestBody usinaRequestBody = usinaRequestBodyDTOMapper.mapFrom(usinaRequestBodyDTO);
        final CommandContext commandContext = new CommandContext();
        commandContext.setData(usinaRequestBody);

        cadastrarUsinaCommandProcessor.process(commandContext);

        return ResponseEntity.ok().build();
    }

}
