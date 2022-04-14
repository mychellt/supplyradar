package br.com.supplyradar.persistence.model.commons;

import br.com.supplyradar.domain.commons.TipoEndereco;
import br.com.supplyradar.persistence.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Table(name = "endereco", schema = "supplyradar")
@Entity
public class EnderecoEntity extends AbstractEntity<UUID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

    @ManyToOne
    @JoinColumn(name="id_cidade", nullable = false)
    private CidadeEntity cidade;

    @Enumerated(EnumType.STRING)
    private TipoEndereco tipo;

    @ManyToOne
    @JoinColumn(name="id_pessoa", nullable=false)
    private PessoaEntity pessoa;
}
