create schema if not exists supplyradar;

create table IF not exists supplyradar.permissao
(
    id uuid not null,
    sigla varchar(256) not null,
    nome varchar not null,
    descricao varchar not null,
    tipo varchar not null,
    ordem int not null default 0,
    primary key(id),
    date_of_change timestamp not null,
    date_of_create timestamp not null,
    ativo boolean default true,
    constraint un_sigla_permissao unique (sigla)
);