package br.com.supplyradar.usuario.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CreateUsuarioDTO {
    private String login;
    private String senha;
    private String email;
    private String emailConfirmacao;
    private String senhaConfirmacao;
    private String tipo;
    private boolean aceitaTermoAdesao;
    private boolean concordaPoliticaPrivacidade;
    private String cpfPassaporte;
    private boolean estrangeiro;
    private String telefone;
    private String nome;

    public boolean isNotEstrangeiro() {
        return !estrangeiro;
    }
}
