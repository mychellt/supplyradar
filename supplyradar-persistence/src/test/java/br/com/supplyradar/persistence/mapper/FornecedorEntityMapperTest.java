package br.com.supplyradar.persistence.mapper;

import br.com.six2six.fixturefactory.Fixture;
import br.com.supplyradar.domain.commons.Fornecedor;
import br.com.supplyradar.domain.commons.PessoaJuridica;
import br.com.supplyradar.persistence.mapper.factory.*;
import br.com.supplyradar.persistence.model.commons.FornecedorEntity;
import br.com.supplyradar.persistence.model.commons.PessoaJuridicaEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {
        FornecedorEntityMapperImpl.class,
        PessoaJuricaEntityFactory.class,
        PessoaJuridicaFactory.class,
        EmailEntityMapperImpl.class,
        ContratoFornecedorFactory.class,
        ContratoFornecedorEntityFactory.class,
        AnexoContratoUsinaEntityFactory.class,
        AnexoContratoUsinaFactory.class,
        CategoriaEntityMapperImpl.class,
        ProdutoEntityMapperImpl.class,
        ContratoUsinaEntityFactory.class,
        ContratoFornecedorEntityMapperImpl.class,
        CycleAvoidingMappingJpaContext.class
})
class FornecedorEntityMapperTest extends AbstractMapperTest {
    @Autowired
    private FornecedorEntityMapper fornecedorEntityMapper;

    @DisplayName(value = "Deve ser capaz de realizar mapeamento de Domain para Entity")
    @Test
    void mapFromDomain() {
        final Fornecedor fornecedor = Fixture.from(Fornecedor.class).gimme("valido");
        final FornecedorEntity fornecedorEntity = fornecedorEntityMapper.mapFrom(fornecedor);
        assertThat(fornecedorEntity, notNullValue());
        assertThat(fornecedorEntity.getAtendimento(), notNullValue());
        assertThat(fornecedorEntity.getAtuacao(), notNullValue());
        Assertions.assertEquals(fornecedorEntity.getAtendimento().isContingencia(), fornecedor.getAtendimento().isContingencia());
        Assertions.assertEquals(fornecedorEntity.getAtendimento().isAtendimento24Horas(), fornecedor.getAtendimento().isAtendimento24Horas());
        assertThat(fornecedorEntity.getAtuacao().getDescricao(), not(emptyOrNullString()));
        assertThat(fornecedorEntity.getAtuacao().getResumo(), not(emptyOrNullString()));
        assertEquals(fornecedorEntity.isAtivo(), fornecedor.isAtivo());
        assertEquals(fornecedorEntity.getDateOfChange(), fornecedor.getDateOfChange());
        assertEquals(fornecedorEntity.getDateOfCreate(), fornecedor.getDateOfCreate());

        assertThat(fornecedorEntity.getAdministrador(), notNullValue());
        assertThat(fornecedorEntity.getAdministrador().getPessoa(), notNullValue());
        assertEquals(fornecedorEntity.getAdministrador().getLogin(), fornecedor.getAdministrador().getLogin());
        assertEquals(fornecedorEntity.getAdministrador().getSenha(), fornecedor.getAdministrador().getSenha());
        assertEquals(fornecedorEntity.getAdministrador().isAutorizado(), fornecedor.getAdministrador().isAutorizado());
        assertEquals(fornecedorEntity.getAdministrador().getTipo(), fornecedor.getAdministrador().getTipo());
        assertEquals(fornecedorEntity.getAdministrador().isAtivo(), fornecedor.getAdministrador().isAtivo());
        assertEquals(fornecedorEntity.getAdministrador().getDateOfChange(), fornecedor.getAdministrador().getDateOfChange());
        assertEquals(fornecedorEntity.getAdministrador().getDateOfCreate(), fornecedor.getAdministrador().getDateOfCreate());

        assertEquals(((PessoaJuridicaEntity) fornecedorEntity.getAdministrador().getPessoa()).getCnpj(), ((PessoaJuridica) fornecedor.getAdministrador().getPessoa()).getCnpj().getNumber());
        assertEquals(((PessoaJuridicaEntity) fornecedorEntity.getAdministrador().getPessoa()).getNomeFantasia(), ((PessoaJuridica) fornecedor.getAdministrador().getPessoa()).getNomeFantasia());
        assertEquals(((PessoaJuridicaEntity) fornecedorEntity.getAdministrador().getPessoa()).getWebsite(), ((PessoaJuridica) fornecedor.getAdministrador().getPessoa()).getWebsite());
        assertEquals(((PessoaJuridicaEntity) fornecedorEntity.getAdministrador().getPessoa()).getRazaoSocial(), ((PessoaJuridica) fornecedor.getAdministrador().getPessoa()).getRazaoSocial());
        assertEquals(((PessoaJuridicaEntity) fornecedorEntity.getAdministrador().getPessoa()).getInscricaoEstadual(), ((PessoaJuridica) fornecedor.getAdministrador().getPessoa()).getInscricaoEstadual());
        assertEquals(fornecedorEntity.getAdministrador().getPessoa().getTelefone(), fornecedor.getAdministrador().getPessoa().getTelefone());
        assertEquals(fornecedorEntity.getAdministrador().getPessoa().isAtivo(), fornecedor.getAdministrador().getPessoa().isAtivo());
        assertEquals(fornecedorEntity.getAdministrador().getPessoa().getDateOfChange(), fornecedor.getAdministrador().getPessoa().getDateOfChange());
        assertEquals(fornecedorEntity.getAdministrador().getPessoa().getDateOfCreate(), fornecedor.getAdministrador().getPessoa().getDateOfChange());
    }

    @DisplayName(value = "Deve ser capaz de realizar mapeamento de Entity para Domain")
    @Test
    void mapFromEntity() {
        final FornecedorEntity fornecedorEntity = Fixture.from(FornecedorEntity.class).gimme("valido");
        final Fornecedor fornecedor = fornecedorEntityMapper.mapFrom(fornecedorEntity);
        assertThat(fornecedor, notNullValue());
        assertThat(fornecedor.getAtendimento(), notNullValue());
        assertThat(fornecedor.getAtuacao(), notNullValue());
        Assertions.assertEquals(fornecedor.getAtendimento().isContingencia(), fornecedor.getAtendimento().isContingencia());
        Assertions.assertEquals(fornecedor.getAtendimento().isAtendimento24Horas(), fornecedor.getAtendimento().isAtendimento24Horas());
        assertThat(fornecedor.getAtuacao().getDescricao(), not(emptyOrNullString()));
        assertThat(fornecedor.getAtuacao().getResumo(), not(emptyOrNullString()));
    }

}
