package br.com.supplyradar.usuario.six2six.fixture.templates;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.supplyradar.domain.commons.Endereco;
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
    }
}
