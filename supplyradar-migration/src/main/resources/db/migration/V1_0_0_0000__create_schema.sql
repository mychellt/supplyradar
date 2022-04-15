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

create table if not exists supplyradar.usuario
(
    id uuid not null,
    login varchar not null,
    date_of_change timestamp not null,
    date_of_create timestamp not null,
    ativo boolean default true,
    primary key(id),
    constraint un_login_usuario unique (login)
);

create table if not exists supplyradar.solicitacao_acesso
(
    id uuid not null,
    date_of_change timestamp not null,
    date_of_create timestamp not null,
    ativo boolean default true,
    primary key(id)
);

create table if not exists supplyradar.pessoa
(
    id uuid not null,
    date_of_change timestamp not null,
    date_of_create timestamp not null,
    ativo boolean default true,
    primary key(id)
);

create table if not exists supplyradar.token_solicitacao_acesso
(
    id uuid not null,
    key varchar not null,
    expirado boolean not null default false,
    date_of_change timestamp not null,
    date_of_create timestamp not null,
    id_solicitacao uuid not null,
    ativo boolean default true,
    constraint fk_solicitcao foreign key (id_solicitacao) references supplyradar.solicitacao_acesso (id),
    primary key(id)
);