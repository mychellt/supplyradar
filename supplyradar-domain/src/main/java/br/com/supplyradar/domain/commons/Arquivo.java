package br.com.supplyradar.domain.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Arquivo{
	private String nome;
	private String descricao;
	private String path;
	protected byte[] conteudoArquivo;
	private File file;
}
