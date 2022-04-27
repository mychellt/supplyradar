package br.com.supplyradar.usuario.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.usuario.dto.EnderecoDTO;
import br.com.supplyradar.usuario.dto.FornecedorRequestBodyDTO;

public class FornecedorRequestBodyDTOTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(FornecedorRequestBodyDTO.class).addTemplate("valido", new Rule() {
            {
                add("cnpj", "99.999.999/0001-99");
                add("razaoSocial", "razao-social");
                add("nomeFantasia", "nome-fantasia");
                add("telefone", "telefone");
                add("inscricaoEstadual", "inscricao_estadual");
                add("website", "website");
                add("experiencias", "experiencias");
                add("fornecimentos", "fornecimentos");
                add("atendimento24horas", Boolean.TRUE);
                add("endereco", one(EnderecoDTO.class,"valido"));
            }
        });
        Fixture.of(FornecedorRequestBodyDTO.class).addTemplate("invalido-sem-cnpj").inherits("valido", new Rule() {
            {
                add("cnpj", null);
            }
        });
        Fixture.of(FornecedorRequestBodyDTO.class).addTemplate("invalido-sem-razao-social").inherits("valido", new Rule() {
            {
                add("razaoSocial", null);
            }
        });
        Fixture.of(FornecedorRequestBodyDTO.class).addTemplate("invalido-sem-nome-fantasia").inherits("valido", new Rule() {
            {
                add("nomeFantasia", null);
            }
        });
        Fixture.of(FornecedorRequestBodyDTO.class).addTemplate("invalido-sem-telefone").inherits("valido", new Rule() {
            {
                add("telefone", null);
            }
        });
        Fixture.of(FornecedorRequestBodyDTO.class).addTemplate("invalido-sem-experiencias").inherits("valido", new Rule() {
            {
                add("experiencias", null);
            }
        });
        Fixture.of(FornecedorRequestBodyDTO.class).addTemplate("invalido-sem-fornecimentos").inherits("valido", new Rule() {
            {
                add("fornecimentos", null);
            }
        });
        Fixture.of(FornecedorRequestBodyDTO.class).addTemplate("invalido-sem-endereco-valido").inherits("valido", new Rule() {
            {
                add("endereco", null);
            }
        });
    }
}
