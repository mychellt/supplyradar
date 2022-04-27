package br.com.supplyradar.usuario.controller;

import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.domain.api.FornecedorRequestBody;
import br.com.supplyradar.domain.commons.Usina;
import br.com.supplyradar.usuario.dto.FornecedorRequestBodyDTO;
import br.com.supplyradar.usuario.mapper.FornecedorRequestBodyDTOMapper;
import br.com.supplyradar.usuario.processor.CriarFornecedorCommandProcessor;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/fornecedores")
public class FornecedorController {
    private final CriarFornecedorCommandProcessor criarFornecedorCommandProcessor;
    private final FornecedorRequestBodyDTOMapper fornecedorRequestBodyDTOMapper;

    @PostMapping
    public ResponseEntity<Usina> create(final @RequestBody FornecedorRequestBodyDTO fornecedorRequestBodyDTO) {

        final FornecedorRequestBody fornecedorRequestBody = fornecedorRequestBodyDTOMapper.mapFrom(fornecedorRequestBodyDTO);

        final CommandContext commandContext = new CommandContext();
        commandContext.setData(fornecedorRequestBody);

        criarFornecedorCommandProcessor.process(commandContext);

        return ResponseEntity.ok().build();
    }
}
