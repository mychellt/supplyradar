insert into supplyradar.unidade_federativa(id, sigla, nome, ativo, date_of_change, date_of_create)
values ('a2e72990-c1d9-11ec-9d64-0242ac120002', 'RN', 'Rio Grande do Norte', true, now(), now());

insert into supplyradar.cidade(id, nome, id_unidade_federativa, ativo, date_of_change, date_of_create)
 values ('dbc4d17c-c1d9-11ec-9d64-0242ac120002', 'Canguaretama', 'a2e72990-c1d9-11ec-9d64-0242ac120002', true, now(), now());