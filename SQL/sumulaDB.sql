use master
go
drop database sumula
----------Query Estrutura das Tabelas--------------
create database sumula
go
use sumula


CREATE TABLE clube(
id int not null identity,
datafundacao date not null,
nome varchar(50),
fundador varchar(100),

)

CREATE TABLE titulo(
id int not null identity,
nome varchar(50),
PRIMARY KEY(id)
)

CREATE TABLE clubetitulos(
idtitulo int not null,
idclube int not null,
data date not null,
foreign key (idclube) references clube(id),
foreign key (idtitulo) references titulo(id),
)


CREATE TABLE jogador(
id int not null identity,
datanasc date not null,
posicao varchar(100) not null,
peso float,
altura float,
naturalidade varchar(50),
PRIMARY KEY(id)
)

CREATE TABLE contrato(
numero int not null,
tipo varchar(30),
datainicio date not null,
datafim date,
PRIMARY KEY(numero),
foreign key (idclube) references clube(id),
foreign key (idjogador) references jogador(id)
)

CREATE TABLE campeonato(
nome varchar(50),
ano date
)

CREATE TABLE inscricao(
numero int not null,
BID int not null,
datapublicacao date
)



insert into jogador values ('Hury','camisa10'),('Pato','fominha'),('Ronaldo','topete')