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
PRIMARY KEY(nome)
)

INSERT INTO	estadio values ('Itaquerao','sp',49205,'10/05/2014','Av. Miguel Ignácio Curi, 111 - Arthur Alvim, São Paulo - SP'),
('Morumbi','sp',79039,'02/10/1960','Praça Roberto Gomes Pedrosa, 1 - Morumbi, São Paulo - SP')

CREATE TABLE clube(
id int not null identity,
datafundacao varchar(10) not null,
nome VARCHAR(50) not null,
--fundador VARCHAR(100),
estadio varchar(50),
PRIMARY KEY (id),
FOREIGN KEY (estadio) REFERENCES estadio(nome)
)

INSERT INTO clube VALUES ('01/01/2001','corinthias','Itaquerao'),
('02/02/2002','são paulo','Morumbi')
SELECT*from clube

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
datainicio varchar(10) not null,
datafim varchar(10),
idclube int not null,
idjogador int not null,
PRIMARY KEY(numero),
FOREIGN KEY (idclube) REFERENCES clube(id),
FOREIGN KEY (idjogador) REFERENCES jogador(id)
)

INSERT INTO contrato VALUES (111,'Emprestimo','01/01/2015','01/01/2017',1,1),
(222,'CLT','02/02/2015','02/02/2017',2,2)



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

-------------------------
Pesquisa todos os jogadores de um clube
-------------------------
CREATE VIEW v_jogadorClube
as

SELECT cb.nome as clube,
jog.nome, jog.apelido, jog.altura, jog.peso, jog.naturalidade
from clube cb
inner join contrato cont
on cont.idclube = cb.id
inner join jogador jog
on jog.id = cont.idjogador
group by cb.nome, jog.nome, jog.apelido, jog.altura, jog.peso, jog.naturalidade

-------------------------
Pesquisa Contrato e traz clube e jogador
--------------------------
create view v_ContJogClube
as

SELECT cont.numero, cont.tipo, cont.datainicio, cont.datafim,
 jog.nome, jog.apelido, jog.altura, jog.peso, jog.naturalidade,
  cb.nome as clube, cb.datafundacao, 
   esta.nome as estadio
from contrato cont
inner join jogador jog
on cont.idjogador = jog.id
inner join clube cb
on cont.idclube = cb.id
inner join estadio esta
on cb.estadio = esta.nome
group by cont.numero, cont.tipo, cont.datainicio, cont.datafim,
 jog.nome, jog.apelido, jog.altura, jog.peso, jog.naturalidade,
  cb.nome, cb.datafundacao,
   esta.nome

--
drop view v_livrocategoria
SELECT * from v_livrocategoria