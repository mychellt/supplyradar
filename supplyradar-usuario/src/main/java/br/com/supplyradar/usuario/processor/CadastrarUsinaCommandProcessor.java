package br.com.supplyradar.usuario.processor;

import br.com.supplyradar.core.command.Command;
import br.com.supplyradar.core.command.CommandContext;
import br.com.supplyradar.core.persistence.UsinaRepository;
import br.com.supplyradar.domain.commons.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@AllArgsConstructor
@Service
public class CadastrarUsinaCommandProcessor implements Command<Usina> {
    private final UsinaRepository usinaRepository;

    @Override
    public Usina process(CommandContext context) {

        final UsinaRequestBody usinaRequestBody = context.getData(UsinaRequestBody.class);

        final PessoaJuridica pessoaJuridica = new PessoaJuridica();
        pessoaJuridica.setCnpj(Cnpj.builder().number(usinaRequestBody.getCnpj()).build());
        pessoaJuridica.setRazaoSocial(usinaRequestBody.getRazaoSocial());
        pessoaJuridica.setInscricaoEstadual(usinaRequestBody.getInscricaoEstadual());
        pessoaJuridica.setWebsite(usinaRequestBody.getWebsite());
        pessoaJuridica.setEnderecos(new ArrayList<>());
        pessoaJuridica.getEnderecos().add(usinaRequestBody.getEndereco());
        pessoaJuridica.getEnderecos().add(usinaRequestBody.getEnderecoCorrespondencia());

        final Usina usina = new Usina();
        usina.setPessoa(pessoaJuridica);
        usina.setNome(usinaRequestBody.getNome());
        usina.setWebsite(usina.getWebsite());
        usina.setTipo(TipoUsina.valueOf(usinaRequestBody.getTipo()));

        return usinaRepository.save(usina);
    }
}
