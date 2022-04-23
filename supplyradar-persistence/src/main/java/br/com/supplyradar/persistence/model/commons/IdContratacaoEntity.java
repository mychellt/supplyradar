package br.com.supplyradar.persistence.model.commons;

import br.com.supplyradar.persistence.model.AbstractEntity;
import br.com.supplyradar.persistence.model.processo.ProcessoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "id_contratacao", schema = "supplyradar")
public class IdContratacaoEntity extends AbstractEntity<UUID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private FornecedorEntity fornecedor;

    @ManyToOne
    @JoinColumn(name = "id_processo", nullable = false)
    private ProcessoEntity processo;
}
