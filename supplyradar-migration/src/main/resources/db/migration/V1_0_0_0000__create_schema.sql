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


create table if not exists supplyradar.pessoa
(
    id uuid not null,
    email varchar not null,
    telefone varchar not null,
    tipo varchar not null,
    date_of_change timestamp not null,
    date_of_create timestamp not null,
    ativo boolean default true,
    primary key(id)
);


create table if not exists supplyradar.usuario
(
    id uuid not null,
    login varchar not null,
    senha varchar not null,
    tipo varchar not null,
    autorizado boolean not null default false,
    date_of_change timestamp not null,
    date_of_create timestamp not null,
    ativo boolean default true,
    id_pessoa uuid not null,
    primary key(id),
    constraint fk_usuario_id_pessoa foreign key (id_pessoa) references supplyradar.pessoa (id),
    constraint un_login_usuario unique (login)
);

create table if not exists supplyradar.solicitacao_acesso
(
    id uuid not null,
    date_of_change timestamp not null,
    date_of_create timestamp not null,
    id_usuario uuid not null,
    ativo boolean default true,
    constraint fk_sol_id_usuario foreign key (id_usuario) references supplyradar.usuario (id),
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
    constraint fk_solicitacao foreign key (id_solicitacao) references supplyradar.solicitacao_acesso (id),
    primary key(id)
);

create table if not exists supplyradar.pessoa_fisica
(
    id uuid not null,
    nome varchar not null,
    cpf_passaporte varchar not null,
    passaporte boolean not null,
    primary key(id),
    constraint fk_pf_id_pessoa foreign key (id) references supplyradar.pessoa (id)
);
