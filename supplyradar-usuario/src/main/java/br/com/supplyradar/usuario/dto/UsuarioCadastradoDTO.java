package br.com.supplyradar.usuario.dto;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCadastradoDTO {
    private UUID id;
    private UUID idPessoa;
    private boolean autorizado;
}
