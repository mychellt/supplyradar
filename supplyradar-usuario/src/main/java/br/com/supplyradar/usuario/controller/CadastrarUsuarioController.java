package br.com.supplyradar.usuario.controller;

import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.domain.exceptions.MandatoryFieldException;
import br.com.supplyradar.usuario.dto.CreateUsuarioDTO;
import br.com.supplyradar.usuario.mapper.CreateUsuarioDTOMapper;
import br.com.supplyradar.usuario.processor.CadastrarUsuarioCommandProcessor;
import br.com.supplyradar.usuario.validator.CadastrarUsuarioValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/public/usuario")
public class CadastrarUsuarioController {
    private final CadastrarUsuarioCommandProcessor cadastrarUsuarioCommandProcessor;
    private final CadastrarUsuarioValidator cadastrarUsuarioValidator;
    private final CreateUsuarioDTOMapper usuarioDTOMapper;

    @PostMapping(path = "/cadastrar")
    public ResponseEntity<Void> create(final @RequestBody CreateUsuarioDTO createUsuarioDTO) {
        cadastrarUsuarioValidator.validate(createUsuarioDTO).isInvalidThrow(MandatoryFieldException.class);

        final CommandContext commandContext = new CommandContext();
        commandContext.setData(usuarioDTOMapper.mapFrom(createUsuarioDTO));

        cadastrarUsuarioCommandProcessor.process(commandContext);
        return ResponseEntity.ok().build();
    }
}
