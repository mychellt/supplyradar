package br.com.supplyradar.persistence.mapper;

import br.com.supplyradar.domain.commons.Permissao;
import br.com.supplyradar.persistence.model.commons.PermissaoEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-31T18:39:05-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Eclipse Foundation)"
)
public class PermissaoEntityMapperImpl extends PermissaoEntityMapper {

    @Override
    public Permissao mapFrom(PermissaoEntity source) {
        if ( source == null ) {
            return null;
        }

        Permissao permissao = new Permissao();

        permissao.setId( source.getId() );
        permissao.setDateOfChange( source.getDateOfChange() );
        permissao.setDateOfCreate( source.getDateOfCreate() );
        permissao.setSigla( source.getSigla() );
        permissao.setNome( source.getNome() );
        permissao.setDescricao( source.getDescricao() );
        permissao.setTipo( source.getTipo() );
        permissao.setOrdem( source.getOrdem() );

        return permissao;
    }

    @Override
    public PermissaoEntity mapFrom(Permissao source) {
        if ( source == null ) {
            return null;
        }

        PermissaoEntity permissaoEntity = new PermissaoEntity();

        permissaoEntity.setDateOfCreate( source.getDateOfCreate() );
        permissaoEntity.setDateOfChange( source.getDateOfChange() );
        permissaoEntity.setId( source.getId() );
        permissaoEntity.setSigla( source.getSigla() );
        permissaoEntity.setNome( source.getNome() );
        permissaoEntity.setDescricao( source.getDescricao() );
        permissaoEntity.setTipo( source.getTipo() );
        permissaoEntity.setOrdem( source.getOrdem() );

        return permissaoEntity;
    }
}
