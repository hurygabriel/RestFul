USE MASTER
GO
DROP DATABASE sumula
----------Query Estrutura das Tabelas--------------
CREATE DATABASE sumula
GO
USE sumula


CREATE TABLE clube(
id int not null identity,
datafundacao date not null,
nome VARCHAR(50),
fundador VARCHAR(100),
)

CREATE TABLE titulo(
id int not null identity,
nome VARCHAR(50),
PRIMARY KEY(id)
)

CREATE TABLE clubetitulos(
idtitulo int not null,
idclube int not null,
data date not null,
FOREIGN KEY (idclube) REFERENCES clube(id),
FOREIGN KEY (idtitulo) REFERENCES titulo(id),
)


CREATE TABLE jogador(
id int not null identity,
datanasc date not null,
posicao VARCHAR(100) not null,
peso float,
altura float,
naturalidade VARCHAR(50),
PRIMARY KEY(id)
)


CREATE TABLE situacao(
idSituacao int not null,
idJogador int not null,
situacao VARCHAR(20),
primary key(idSituacao),
FOREIGN KEY(idJogador) REFERENCES jogador(id)

)

CREATE TABLE escalacao(
idEscalacao int not null,
idJogador int not null,
idSituacao int not null,

)

CREATE TABLE contrato(
numero int not null,
tipo VARCHAR(30),
datainicio date not null,
datafim date,
PRIMARY KEY(numero),
FOREIGN KEY (idclube) REFERENCES clube(id),
FOREIGN KEY (idjogador) REFERENCES jogador(id)
)

CREATE TABLE campeonato(
nome VARCHAR(50),
ano date
)

CREATE TABLE inscricao(
numero int not null,
BID int not null,
datapublicacao date
)



insert into jogador values ('Hury','camisa10'),('Pato','fominha'),('Ronaldo','topete')