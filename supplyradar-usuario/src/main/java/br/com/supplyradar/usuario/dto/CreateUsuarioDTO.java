package br.com.supplyradar.usuario.dto;

import lombok.*;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUsuarioDTO {
    private String login;
    private String senha;
    private String email;
    private String emailConfirmacao;
    private String senhaConfirmacao;
    private String tipo;
    private boolean aceitaTermoAdesao;
    private boolean concordaPoliticaPrivacidade;
    private String cpf;
    private String passaporte;
    private boolean estrangeiro;
    private String telefone;
    private String nome;

    public boolean isNotEstrangeiro() {
        return !estrangeiro;
    }
}
