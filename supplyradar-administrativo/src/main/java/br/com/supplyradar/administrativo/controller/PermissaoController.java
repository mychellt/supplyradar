package br.com.supplyradar.administrativo.controller;

import br.com.supplyradar.administrativo.processor.permissao.*;
import br.com.supplyradar.administrativo.validator.PermissaoMandatoryFieldValidator;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.domain.commons.Permissao;
import br.com.supplyradar.domain.exceptions.MandatoryFieldException;
import br.com.supplyradar.administrativo.dto.PermissaoDTO;
import br.com.supplyradar.administrativo.mapper.PermissaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/administrativo")
public class PermissaoController {

    private final CreatePermissaoCommandProcessor createPermissaoCommandProcessor;
    private final UpdatePermissaoCommandProcessor updatePermissaoCommandProcessor;
    private final PermissaoMandatoryFieldValidator permissaoMandatoryFieldValidator;
    private final FetchPermissaoCommandProcessor fetchPermissaoCommandProcessor;
    private final ListPermissaoCommandProcessor listPermissaoCommandProcessor;
    private final DeletePermissaoCommandProcessor deletePermissaoCommandProcessor;
    private final PermissaoMapper mapper;

    @PostMapping(value = "/permissao")
    public ResponseEntity<PermissaoDTO> create(@RequestBody final PermissaoDTO permissaoDTO) {

        permissaoMandatoryFieldValidator.validate(permissaoDTO).isInvalidThrow(MandatoryFieldException.class);

        final CommandContext commandContext = new CommandContext();
        commandContext.setData(mapper.mapFrom(permissaoDTO));

        final Permissao permissao = createPermissaoCommandProcessor.process(commandContext);

        return ResponseEntity.ok(mapper.mapFrom(permissao));
    }

    @PutMapping(path = "/permissao/{id}")
    public ResponseEntity<PermissaoDTO> update(@RequestBody final PermissaoDTO permissaoDTO, @PathVariable final UUID id) {

        permissaoMandatoryFieldValidator.validate(permissaoDTO).isInvalidThrow(MandatoryFieldException.class);

        final CommandContext commandContext = new CommandContext();
        commandContext.setData(mapper.mapFrom(permissaoDTO));
        commandContext.put("id", id);

        Permissao permissao = updatePermissaoCommandProcessor.process(commandContext);

        return ResponseEntity.accepted().body(mapper.mapFrom(permissao));
    }

    @DeleteMapping(path = "/permissao/{id}")
    public ResponseEntity<PermissaoDTO> delete(@PathVariable final UUID id) {
        final CommandContext commandContext = new CommandContext();
        commandContext.put("id", id);

        deletePermissaoCommandProcessor.process(commandContext);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/permissao/{id}")
    public ResponseEntity<PermissaoDTO> findOne(@PathVariable final UUID id) {
        final CommandContext commandContext = new CommandContext();
        commandContext.put("id", id);

        Permissao permissao = fetchPermissaoCommandProcessor.process(commandContext);

        return ResponseEntity.ok(mapper.mapFrom(permissao));
    }


    @GetMapping(path = "/permissao/")
    public ResponseEntity<List<PermissaoDTO>> findAll() {
        final CommandContext commandContext = new CommandContext();
        final List<Permissao> permissoes = listPermissaoCommandProcessor.process(commandContext);
        final List<PermissaoDTO> permissoesDTOS = permissoes.stream().map(mapper::mapFrom).collect(Collectors.toList());
        return ResponseEntity.ok(permissoesDTOS);
    }
}
