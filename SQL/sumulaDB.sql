USE MASTER
GO
DROP DATABASE sumula
----------Query Estrutura das Tabelas--------------
CREATE DATABASE sumula
GO
USE sumula

CREATE TABLE estadio(
nome varchar(50) not null,
uf varchar(2) not null,
capacidade int not null,
dataInauguracao varchar(10),
endereco varchar(90),
primary key(nome)
)

INSERT INTO	estadio values ('Itaquerao','sp',49205,'10/05/2014','Av. Miguel Ignácio Curi, 111 - Arthur Alvim, São Paulo - SP'),
('Morumbi','sp',79039,'02/10/1960','Praça Roberto Gomes Pedrosa, 1 - Morumbi, São Paulo - SP')

CREATE TABLE clube(
id int not null identity,
datafundacao varchar(10) not null,
nome VARCHAR(50) not null,
--fundador VARCHAR(100),
estadio varchar(50),
FOREIGN KEY (estadio) REFERENCES estadio(nome)
)

INSERT INTO clube VALUES ('01/01/2001','corinthias','Itaquerao'),
('02/02/2002','são paulo','Morumbi')


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
nome varchar(50),
apelido varchar(50),
datanasc varchar(10) not null, --date
peso float,
altura float,
naturalidade VARCHAR(50),
PRIMARY KEY(id)
)

INSERT INTO jogador VALUES ('ronaldo','ronaldinho','14/06/1994','70.5','1.80','Brasileiro'),
('joao','pele','01/01/1950','80.7','1.75','Brasileiro')

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
posto varchar(10),
posicao varchar(20),
PRIMARY KEY(idEscalacao),
FOREIGN KEY(idJogador) REFERENCES jogador(id)

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
idCampeonato int not null,
nome VARCHAR(50),
ano date,
PRIMARY KEY(idCampeonato)
)

CREATE TABLE participacao(
)

CREATE TABLE inscricao(
numero int not null,
BID int not null,
datapublicacao date
)




CREATE TABLE sumula(
idSumula int not null,
idGol int not null,
idSubstituicao int not null
)

CREATE TABLE gol(
idSumula int
idJogador int not null
)

CREATE TABLE substituicao(
)

CREATE TABLE cartao(
)

CREATE TABLE partida(
idEscalacao int not null,
idClube int not null,
idCampeonato int,
nomeEstadio varchar(50),

)


insert into jogador values ('Hury','camisa10'),('Pato','fominha'),('Ronaldo','topete')