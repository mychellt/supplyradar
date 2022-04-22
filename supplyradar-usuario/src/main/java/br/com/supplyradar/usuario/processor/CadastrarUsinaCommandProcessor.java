package br.com.supplyradar.usuario.processor;

import br.com.supplyradar.core.command.Command;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.core.persistence.CidadeRepository;
import br.com.supplyradar.core.persistence.UsinaRepository;
import br.com.supplyradar.domain.commons.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;


@AllArgsConstructor
@Service
public class CadastrarUsinaCommandProcessor implements Command<Usina> {
    private final UsinaRepository usinaRepository;
    private final CidadeRepository cidadeRepository;

    @Override
    public Usina process(CommandContext context) {

        final UsinaRequestBody usinaRequestBody = context.getData(UsinaRequestBody.class);

        final PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCnpj(Cnpj.builder().number(usinaRequestBody.getCnpj()).build());
        pessoaJuridica.setRazaoSocial(usinaRequestBody.getRazaoSocial());
        pessoaJuridica.setInscricaoEstadual(usinaRequestBody.getInscricaoEstadual());
        pessoaJuridica.setWebsite(usinaRequestBody.getWebsite());
        pessoaJuridica.setTipo(TipoPessoa.PESSOA_JURIDICA);
        pessoaJuridica.setAtivo(Boolean.TRUE);
        pessoaJuridica.setDateOfChange(LocalDateTime.now());
        pessoaJuridica.setDateOfCreate(LocalDateTime.now());
        pessoaJuridica.setEnderecos(new ArrayList<>());

        final Endereco endereco = usinaRequestBody.getEndereco();
        endereco.setTipo(TipoEndereco.COMERCIAL);
        endereco.setAtivo(Boolean.TRUE);
        endereco.setDateOfChange(LocalDateTime.now());
        endereco.setDateOfCreate(LocalDateTime.now());
        endereco.setPessoa(pessoaJuridica);

        final Endereco enderecoCorrespondencia = usinaRequestBody.getEnderecoCorrespondencia();
        enderecoCorrespondencia.setTipo(TipoEndereco.CORRESPONDENCIA);
        enderecoCorrespondencia.setAtivo(Boolean.TRUE);
        enderecoCorrespondencia.setDateOfChange(LocalDateTime.now());
        enderecoCorrespondencia.setDateOfCreate(LocalDateTime.now());
        enderecoCorrespondencia.setPessoa(pessoaJuridica);

        pessoaJuridica.getEnderecos().add(endereco);
        pessoaJuridica.getEnderecos().add(usinaRequestBody.getEnderecoCorrespondencia());

        for(Endereco e : pessoaJuridica.getEnderecos()) {
            e.setCidade(cidadeRepository.findById(endereco.getCidade().getId()));
        }

        final Usina usina = new Usina();
        usina.setAtivo(Boolean.TRUE);
        usina.setDateOfChange(LocalDateTime.now());
        usina.setDateOfCreate(LocalDateTime.now());
        usina.setPessoa(pessoaJuridica);
        usina.setNome(usinaRequestBody.getNome());
        usina.setWebsite(usina.getWebsite());
        usina.setSituacao(SituacaoCadastro.AGUARDANDO_ASSINATURA_CONTRATO);
        usina.setTipo(TipoUsina.valueOf(usinaRequestBody.getTipo()));

        return usinaRepository.save(usina);
    }
}
