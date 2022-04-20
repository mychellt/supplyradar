package br.com.supplyradar.usuario.controller;

import br.com.supplyradar.usuario.dto.CreateUsinaDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/usina")
public class CadastrarUsinaController {

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody final CreateUsinaDTO createUsinaDTO) {
        return ResponseEntity.ok().build();
    }

}
