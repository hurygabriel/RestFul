USE MASTER
GO
DROP DATABASE sumula

----------Query Estrutura das Tabelas--------------

CREATE DATABASE sumula
COLLATE Latin1_General_100_CS_AS_SC;  
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

INSERT INTO	estadio values ('Itaquerao','SP',49205,'10/05/2014','Av. Miguel Ign�cio Curi, 111 - Arthur Alvim, S�o Paulo - SP'),
('Morumbi','SP',79039,'02/10/1960','Pra�a Roberto Gomes Pedrosa, 1 - Morumbi, S�o Paulo - SP')

CREATE TABLE tecnico(
id int not null identity,
nome varchar(50),
PRIMARY KEY (id)
)

INSERT INTO tecnico values('Oswaldo de Oliveira'),('Ricardo Gomes'),('Tite'),('Dunga')

CREATE TABLE clube(
id int not null identity,
datafundacao varchar(10) not null,
nome VARCHAR(50) not null,
estadio varchar(50) not null,
uf varchar(2),
tecnico int not null,
caminhoimg varchar(60),
PRIMARY KEY (id),
FOREIGN KEY (estadio) REFERENCES estadio(nome),
FOREIGN KEY (tecnico) REFERENCES tecnico(id)
)

INSERT INTO clube VALUES ('01/01/2001','corinthias','Itaquerao','SP',1,'corinthians_bra.png'),
('02/02/2002','s�o paulo','Morumbi','SP',2,'saopaulo_bra.png')
--
CREATE TABLE jogador(
id int not null identity,
nome varchar(50),
apelido varchar(50),
datanasc varchar(10) not null, --date
peso float,
altura float,
naturalidade VARCHAR(50),
uf varchar(2),
posicao varchar(30),
caminhoimg varchar(60),
PRIMARY KEY(id)
)

INSERT INTO jogador VALUES 
('Ronaldo','Ronaldinho','14/06/1994','70.5','1.80','Brasileiro','SP','ATACANTE','zidade.jpg'),
('Joao','Pele','01/01/1950','80.7','1.75','Brasileiro','RJ','ATACANTE','zidade.jpg'),
('Hury','Iuri','01/01/1994','70','1.80','Brasileiro','SP','GOLEIRO','zidade.jpg'),
('Pedro','ZUZI','01/01/1993','75','1.90','Brasileiro','RJ','GOLEIRO','zidade.jpg'),

--TIME A
('Nome1','Apelido1','01/01/1994','70','1.80','Brasileiro','SP','GOLEIRO','zidade.jpg'),
('Nome2','Apelido2','02/01/1994','70','1.80','Brasileiro','MA','GOLEIRO','zidade.jpg'),

('Nome3','Apelido3','03/01/1994','70','1.80','Brasileiro','RJ','ATACANTE','zidade.jpg'),
('Nome4','Apelido4','04/01/1994','70','1.80','Brasileiro','MT','ATACANTE','zidade.jpg'),

('Nome5','Apelido5','05/01/1994','70','1.80','Brasileiro','AC','ATACANTE','zidade.jpg'),
('Nome6','Apelido6','06/01/1994','70','1.80','Brasileiro','MS','ATACANTE','zidade.jpg'),

('Nome7','Apelido7','07/01/1994','70','1.80','Brasileiro','AL','LATERALE','zidade.jpg'),
('Nome8','Apelido8','08/01/1994','70','1.80','Brasileiro','MG','LATERALE','zidade.jpg'),

('Nome9','Apelido9','09/01/1994','70','1.80','Brasileiro','AP','LATERALD','zidade.jpg'),
('Nome10','Apelido10','10/01/1994','70','1.80','Brasileiro','PA','LATERALD','zidade.jpg'),

('Nome11','Apelido11','11/01/1994','70','1.80','Brasileiro','AM','MEIA','zidade.jpg'),
('Nome12','Apelido12','12/01/1994','70','1.80','Brasileiro','PB','MEIA','zidade.jpg'),

('Nome13','Apelido13','13/01/1994','70','1.80','Brasileiro','BA','MEIA','zidade.jpg'),
('Nome14','Apelido14','14/01/1994','70','1.80','Brasileiro','PR','MEIA','zidade.jpg'),

('Nome15','Apelido15','15/01/1994','70','1.80','Brasileiro','CE','ZAGUEIRO','zidade.jpg'),
('Nome16','Apelido16','16/01/1994','70','1.80','Brasileiro','PE','ZAGUEIRO','zidade.jpg'),

('Nome17','Apelido17','17/01/1994','70','1.80','Brasileiro','DF','ZAGUEIRO','zidade.jpg'),
('Nome18','Apelido18','18/01/1994','70','1.80','Brasileiro','PI','ZAGUEIRO','zidade.jpg'),

('Nome19','Apelido19','19/01/1994','70','1.80','Brasileiro','ES','VOLANTE','zidade.jpg'),
('Nome20','Apelido20','20/01/1994','70','1.80','Brasileiro','RN','VOLANTE','zidade.jpg'),

('Nome21','Apelido21','21/01/1994','70','1.80','Brasileiro','GO','VOLANTE','zidade.jpg'),
('Nome22','Apelido22','22/01/1994','70','1.80','Brasileiro','RS','VOLANTE','zidade.jpg'),

-------- TIME B
('Nome23','Apelido23','01/02/1994','70','1.80','Brasileiro','SP','GOLEIRO','zidade.jpg'),
('Nome24','Apelido24','02/02/1994','70','1.80','Brasileiro','MA','GOLEIRO','zidade.jpg'),

('Nome25','Apelido25','03/02/1994','70','1.80','Brasileiro','RJ','ATACANTE','zidade.jpg'),
('Nome26','Apelido26','04/02/1994','70','1.80','Brasileiro','MT','ATACANTE','zidade.jpg'),

('Nome27','Apelido27','05/02/1994','70','1.80','Brasileiro','AC','ATACANTE','zidade.jpg'),
('Nome28','Apelido28','06/02/1994','70','1.80','Brasileiro','MS','ATACANTE','zidade.jpg'),

('Nome29','Apelido29','07/02/1994','70','1.80','Brasileiro','AL','LATERALE','zidade.jpg'),
('Nome30','Apelido30','08/02/1994','70','1.80','Brasileiro','MG','LATERALE','zidade.jpg'),

('Nome31','Apelido31','09/02/1994','70','1.80','Brasileiro','AP','LATERALD','zidade.jpg'),
('Nome32','Apelido32','10/02/1994','70','1.80','Brasileiro','PA','LATERALD','zidade.jpg'),

('Nome33','Apelido33','11/02/1994','70','1.80','Brasileiro','AM','MEIA','zidade.jpg'),
('Nome34','Apelido34','12/02/1994','70','1.80','Brasileiro','PB','MEIA','zidade.jpg'),

('Nome35','Apelido35','13/02/1994','70','1.80','Brasileiro','BA','MEIA','zidade.jpg'),
('Nome36','Apelido36','14/02/1994','70','1.80','Brasileiro','PR','MEIA','zidade.jpg'),

('Nome37','Apelido37','15/02/1994','70','1.80','Brasileiro','CE','ZAGUEIRO','zidade.jpg'),
('Nome38','Apelido38','16/02/1994','70','1.80','Brasileiro','PE','ZAGUEIRO','zidade.jpg'),

('Nome39','Apelido39','17/02/1994','70','1.80','Brasileiro','DF','ZAGUEIRO','zidade.jpg'),
('Nome40','Apelido40','18/02/1994','70','1.80','Brasileiro','PI','ZAGUEIRO','zidade.jpg'),

('Nome41','Apelido41','19/02/1994','70','1.80','Brasileiro','ES','VOLANTE','zidade.jpg'),
('Nome42','Apelido42','20/02/1994','70','1.80','Brasileiro','RN','VOLANTE','zidade.jpg'),

('Nome43','Apelido43','21/02/1994','70','1.80','Brasileiro','GO','VOLANTE','zidade.jpg'),
('Nome44','Apelido44','22/02/1994','70','1.80','Brasileiro','RS','VOLANTE','zidade.jpg')

CREATE TABLE situacao(
nome VARCHAR(30),
primary key(nome)
)

INSERT INTO situacao VALUES ('DISPONIVEL'), ('OK'), ('MACHUCADO'), ('SERVINDOSELECAO'), ('SUSPENSO'), ('PUNICAO'), ('NAOINSCRITO'), ('INDISPONIVEL')

CREATE TABLE situacaojogador(
data varchar(10),
idjogador int not null,
situacao varchar(30) not null,
FOREIGN KEY (idjogador) references jogador(id),
FOREIGN KEY (situacao) references situacao(nome)
)

INSERT INTO	situacaojogador VALUES ('01/01/2015', 1, 'MACHUCADO'),('01/01/2015', 2, 'SUSPENSO'),('01/01/2015', 3, 'PUNICAO'),('01/01/2015', 4, 'OK'),
('01/01/2015', 5, 'OK')


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

INSERT INTO contrato VALUES (111,'DEFINITIVO','01/01/2015','01/01/2017',1,1),
(222,'RENOVACAO','02/02/2015','02/02/2017',2,2),
(333,'EMPRESTIMO','01/01/2015','01/01/2017',1,3),
(444,'RESCISAO','01/01/2015','01/01/2017',2,4),
--time a
(5, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 5),
(6, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 6),
(7, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 7),
(8, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 8),
(9, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 9),
(10, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 10),
(11, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 11),
(12, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 12),
(13, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 13),
(14, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 14),
(15, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 15),
(16, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 16),
(17, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 17),
(18, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 18),
(19, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 19),
(20, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 20),
(21, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 21),
(22, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 22),
(23, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 23),
(24, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 24),
(25, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 25),
(26, 'DEFINITIVO', '01/01/2015', '01/01/2017', 1, 26),
--time b
(27, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 27),
(28, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 28),
(29, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 29),
(30, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 30),
(31, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 31),
(32, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 32),
(33, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 33),
(34, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 34),
(35, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 35),
(36, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 36),
(37, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 37),
(38, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 38),
(39, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 39),
(40, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 40),
(41, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 41),
(42, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 42),
(43, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 43),
(44, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 43),
(45, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 45),
(46, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 46),
(47, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 47),
(48, 'DEFINITIVO', '01/01/2015', '01/01/2017', 2, 48)

CREATE TABLE escalacao(
id INT NOT NULL identity,
idclube INT NOT NULL,
data varchar(10) NOT NULL,

PRIMARY KEY(id),
FOREIGN KEY(idclube) REFERENCES clube(id)
)

INSERT INTO escalacao VALUES
(1,'27/10/2016'),(2,'27/10/2016')

CREATE TABLE listajog(
idescalacao int not null,
idjogador int not null,
posto varchar(8) not null check (posto='TITULAR' or posto='RESERVA'),
camisa varchar(3),

FOREIGN KEY(idescalacao) REFERENCES escalacao(id),
FOREIGN KEY(idjogador) REFERENCES jogador(id)
)


INSERT INTO listajog VALUES
--time a
(1, 5, 'TITULAR','01'),
(1, 6, 'RESERVA','02'),
(1, 7, 'TITULAR','03'),
(1, 8, 'RESERVA','04'),
(1, 9, 'TITULAR','05'),
(1, 10, 'RESERVA','06'),
(1, 11, 'TITULAR','07'),
(1, 12, 'RESERVA','08'),
(1, 13, 'TITULAR','09'),
(1, 14, 'RESERVA','10'),
(1, 15, 'TITULAR','11'),
(1, 16, 'RESERVA','12'),
(1, 17, 'TITULAR','13'),
(1, 18, 'RESERVA','14'),
(1, 19, 'TITULAR','15'),
(1, 20, 'RESERVA','16'),
(1, 21, 'TITULAR','17'),
(1, 22, 'RESERVA','18'),
(1, 23, 'TITULAR','19'),
(1, 24, 'RESERVA','20'),
(1, 25, 'TITULAR','21'),
(1, 26, 'RESERVA','22'),
--time b
(2, 27, 'TITULAR','01'),
(2, 28, 'RESERVA','02'),
(2, 29, 'TITULAR','03'),
(2, 30, 'RESERVA','04'),
(2, 31, 'TITULAR','05'),
(2, 32, 'RESERVA','06'),
(2, 33, 'TITULAR','07'),
(2, 34, 'RESERVA','08'),
(2, 35, 'TITULAR','09'),
(2, 36, 'RESERVA','10'),
(2, 37, 'TITULAR','11'),
(2, 38, 'RESERVA','12'),
(2, 39, 'TITULAR','13'),
(2, 40, 'RESERVA','14'),
(2, 41, 'TITULAR','15'),
(2, 42, 'RESERVA','16'),
(2, 43, 'TITULAR','17'),
(2, 44, 'RESERVA','18'),
(2, 45, 'TITULAR','19'),
(2, 46, 'RESERVA','20'),
(2, 47, 'TITULAR','21'),
(2, 48, 'RESERVA','22')

CREATE TABLE arbitro(

id INT NOT NULL IDENTITY,
nome VARCHAR(50) NOT NULL,
dataNascimento DATE NOT NULL,
uf VARCHAR(2),
situacao VARCHAR(20),
caminhoimg VARCHAR(60),
PRIMARY KEY(id)
)

INSERT INTO arbitro (nome, dataNascimento, uf, situacao, caminhoimg) VALUES
('teste', '1950/01/01', 'SP', 'DISPONIVEL','ab3.jpg'),
('teste2', '1952/02/02', 'RJ', 'DISPONIVEL','ab1.jpg'),
('teste3', '1953/03/03', 'SP', 'SUSPENSO','ab2.jpg')

CREATE TABLE sentenca(
id INT NOT NULL,
idArbitro INT NOT NULL,
idPartida int not null,
idJogador int not null,
idClube int not null,
idCartao int not null,
valorPena DECIMAL(10,2),
pontos INT,
dataSentenca DATE NOT NULL,
motivo VARCHAR(100),
descricao VARCHAR(250),
jogosPena INT NOT NULL,
jogosPagos INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(idArbitro) REFERENCES arbitro(id),
foreign key(idPartida) references partida(id),
foreign key(idJogador) references jogador(id),
foreign key(idClube) references Clube(id),
foreign key(idCartao) references Cartao(id)
)

INSERT INTO sentenca VALUES(1, 1, 800.57, null, '2016/10/12', 
'Empurrou um jogador', 'Empurrou o jogador neymar durante uma partida', 5, 2),
(2, 3, 5800.58, null, '2016/10/11', 
'Caiu na vila, penalty pro santos', 'Jogador do santos caiu na vila 
e juizao nao deu penalty ', 5, 5)


------------------------------------------------------------
--Lembre-se de executar as views no final
------------AT� AQUI OK -------------------------------------

select * from clube

Select arb.id, arb.nome, arb.dataNascimento, arb.uf, arb.situacao,
sent.valorPena, sent.pontos, sent.dataSentenca, sent.motivo, sent.descricao,
sent.jogosPena, sent.jogosPagos from arbitro arb
inner join sentenca sent
on arb.id = sent.idArbitro
ORDER BY arb.nome

Select * from arbitro arb
left join sentenca sent
on arb.id = sent.idArbitro
WHERE arb.uf = 'SP'
ORDER BY arb.nome

Select * from arbitro arb left join sentenca sent 
on arb.id = sent.idArbitro WHERE nome LIKE '%teste%' ORDER BY arb.nome;

-------




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

CREATE TABLE campeonato(
id int not null,
idPartida int not null,
nome VARCHAR(50),
ano date,
PRIMARY KEY(id),
foreign key (idPartida) references Partida(id)
)

CREATE TABLE participacao(
idCampeonato int not null,
idClube int not null,
posicao varchar(50),
pontos int,
golsMarcaods int,
golsSofridos int,
saldoGols int,
jogos int,
vitorias int,
derrotas int,
empates int,
aproveitamento decimal(10,2),
foreign key (idCampeonato) references Campeonato(id),
foreign key (idClube) references clube(id)
)

CREATE TABLE inscricao(
idcampeonato int not null,
idjogador int not null,
numero int not null,
BID int not null,
datapublicacao date
foreign key (idCampeonato) references Campeonato(id),
foreign key (idJogador) references Joagdor(id)
)

CREATE TABLE sumula(
id int not null,
idGol int not null,
idSubstituicao int not null,
primeiroTempoInicio datetime,
primeiroTempoTermino datetime,
tempoIntervalo Datetime,
segundoTempoInicio datetime,
segundoTempoTermino datetime,
primeiroTempoAcrescimos datetime,
segundoTempoAcrescimos datetime,
descricao varchar(200),
observacoes varchar(200),
foreign key (idGol) references Gol(id),
foreign key (idSubstituicao) references substituicao(id)
)

CREATE TABLE gol(
id int primary key identity,
idJogador int not null,
qtd int,
tempo int,
foreign key (idJogador) references Jogador(id)
)

CREATE TABLE substituicao(
id int primary key identity,
tempo int, 
idJogadorEntrada int,
idJogadorSaida int,
foreign key (idJogadorEntrada) references Jogador(id),
foreign key (idJogadorSaida) references Jogador(id)
)

CREATE TABLE cartao(
id int primary key identity,
idJogador int not null,
idArbitro int not null,
tipo varchar(50),
qtd int,
tempo int,
foreign key (idJogador) references jogador(id),
foreign key (idArbitro) references arbitro(id)
)

CREATE TABLE partida(
id int primary key identity,
idEscalacao int not null,
idClube int not null,
idEstadio varchar(50),
data datetime not null,
hora datetime not null,
foreign key (idEscalacao) references escalacao(id),
foreign key (idClube) references clube(id),
foreign key (idEstadio) references estadio(id),
)

create table usuario(
id int not null identity,
usuario varchar(100) not null,
senha varchar(100) not null,
chave varchar(100) not null,
dataCriacao datetime not null,
validadeChave datetime not null
primary key(id)
)

CREATE TABLE cadastro (
id int identity not null primary key,
idUsuario int not null,
nome varchar(100) not null,
cpf varchar(11) not null,
tipo varchar(50) not null,
registro varchar(50)
FOREIGN KEY (idUsuario) REFERENCES usuario(id)
)

-------------------------
Pesquisa todos os jogadores de um clube
-------------------------
CREATE VIEW v_jogadorClube
as

SELECT cb.nome as clube, cb.id as idclube,
jog.nome, jog.apelido, jog.altura, jog.peso, jog.naturalidade, jog.id, jog.datanasc,jog.uf,jog.posicao
from clube cb
inner join contrato cont
on cont.idclube = cb.id
inner join jogador jog
on jog.id = cont.idjogador
group by cb.nome, cb.id, jog.nome, jog.apelido, jog.altura, jog.peso, jog.naturalidade, jog.id, jog.datanasc,jog.uf,jog.posicao
-------------------------
drop view v_jogadorClube
select * from v_jogadorClube where idclube = 1

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

--------------------------
drop view v_livrocategoria
SELECT * from v_livrocategoria

select * from clube