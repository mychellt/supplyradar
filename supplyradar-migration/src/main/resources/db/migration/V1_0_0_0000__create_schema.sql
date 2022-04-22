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
    email varchar,
    telefone varchar,
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

create table if not exists supplyradar.pessoa_juridica
(
    id uuid not null,
    cnpj varchar not null,
    razao_social varchar not null,
    website varchar,
    nome_fantasia varchar,
    inscricao_estadual varchar,
    primary key(id),
    constraint fk_pj_id_pessoa foreign key (id) references supplyradar.pessoa (id)
);

create table if not exists supplyradar.unidade_federativa (
  id uuid not null,
  nome varchar not null,
  sigla varchar not null,
  date_of_change timestamp not null,
  date_of_create timestamp not null,
  ativo boolean default true,
  primary key(id)
);

create table if not exists supplyradar.cidade (
  id uuid not null,
  nome varchar not null,
  id_unidade_federativa uuid not null,
  date_of_change timestamp not null,
  date_of_create timestamp not null,
  ativo boolean default true,
  primary key(id),
  constraint fk_cidade_id_uf foreign key (id_unidade_federativa) references supplyradar.unidade_federativa (id)
);

create table if not exists supplyradar.endereco
(
    id uuid not null,
    numero varchar,
    id_cidade uuid not null,
    bairro varchar,
    cep varchar,
    complemento varchar,
    logradouro varchar,
    tipo varchar not null default 'COMERCIAL',
    date_of_change timestamp not null,
    date_of_create timestamp not null,
    ativo boolean default true,
    id_pessoa uuid not null,
    primary key(id),
    constraint fk_end_id_cidade foreign key (id_cidade) references supplyradar.cidade (id),
    constraint fk_end_id_pessoa foreign key (id_pessoa) references supplyradar.pessoa (id)
);

create table if not exists supplyradar.arquivo
(
    id uuid not null,
    content_type varchar,
    descricao varchar,
    path varchar,
    nome varchar,
    date_of_change timestamp not null,
    date_of_create timestamp not null,
    ativo boolean default true,
    primary key(id)
);


create table if not exists supplyradar.contrato
(
    id uuid not null,
    date_of_change timestamp not null,
    date_of_create timestamp not null,
    ativo boolean default true,
    pendencia varchar,
    vigencia timestamp,
    primary key(id)
);

create table if not exists supplyradar.usina
(
    id uuid not null,
    date_of_change timestamp not null,
    date_of_create timestamp not null,
    ativo boolean default true,
    nome varchar not null,
    tipo varchar not null,
    website varchar,
    id_contrato uuid,
    id_pessoa uuid,
    situacao_cadastro varchar not null,
    primary key(id),
    constraint fk_u_id_contrato foreign key (id_contrato) references supplyradar.contrato (id),
    constraint fk_u_id_pessoa foreign key (id_pessoa) references supplyradar.pessoa (id)
);


create table if not exists supplyradar.contrato_usina
(
    id uuid not null,
    date_of_change timestamp not null,
    date_of_create timestamp not null,
    ativo boolean default true,
    id_usina uuid not null,
    primary key(id),
    constraint fk_cu_id_contrato foreign key (id) references supplyradar.contrato (id),
    constraint fk_cu_id_usina foreign key (id_usina) references supplyradar.usina (id)
);

create table if not exists supplyradar.anexo_contrato
(
    id uuid not null,
    id_contrato uuid not null ,
    date_of_change timestamp not null,
    date_of_create timestamp not null,
    ativo boolean default true,
    tipo varchar not null,
    primary key(id),
    constraint fk_ac_id_arquivo foreign key (id) references supplyradar.arquivo (id),
    constraint fk_ac_id_contrato foreign key (id_contrato) references supplyradar.contrato (id)
);

create table if not exists supplyradar.estatuto_empresa
(
    id uuid not null,
    date_of_change timestamp not null,
    date_of_create timestamp not null,
    ativo boolean default true,
    id_pessoa uuid not null,
    primary key(id),
    constraint fk_ee_id_arquivo foreign key (id) references supplyradar.arquivo (id),
    constraint fk_ee_id_pessoa foreign key (id_pessoa) references supplyradar.pessoa (id)
);

create table if not exists supplyradar.vinculo
(
    id uuid not null,
    date_of_change timestamp not null,
    date_of_create timestamp not null,
    ativo boolean default true,
    email varchar not null,
    bloqueado boolean not null default false,
    primary key(id)
);

create table if not exists supplyradar.vinculo_usina
(
    id uuid not null,
    date_of_change timestamp not null,
    date_of_create timestamp not null,
    ativo boolean default true,
    id_usina uuid not null,
    primary key(id),
    constraint fk_vu_id_vinculo foreign key (id) references supplyradar.vinculo (id),
    constraint fk_vu_id_usina foreign key (id_usina) references supplyradar.usina (id)
);
