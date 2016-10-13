CREATE TABLE arbitro(

id INT NOT NULL,
nome VARCHAR(50) NOT NULL,
dataNascimento DATE NOT NULL,
uf VARCHAR(2),
situacao VARCHAR(20),
PRIMARY KEY(id))

INSERT INTO arbitro VALUES(1, 'teste', '1950/01/01', 'SP', 'DISPONIVEL'),
(2, 'teste2', '1952/02/02', 'RJ', 'DISPONIVEL'),
(3, 'teste3', '1953/03/03', 'SP', 'SUSPENSO')

CREATE TABLE sentenca(

id INT NOT NULL,
idArbitro INT NOT NULL,
valorPena DECIMAL(10,2),
pontos INT,
dataSentenca DATE NOT NULL,
motivo VARCHAR(100),
descricao VARCHAR(250),
jogosPena INT NOT NULL,
jogosPagos INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(idArbitro) REFERENCES arbitro(id))

INSERT INTO sentenca VALUES(1, 1, 800.57, null, '2016/10/12', 
'Empurrou um jogador', 'Empurrou o jogador neymar durante uma partida', 5, 2),
(2, 3, 5800.58, null, '2016/10/11', 
'Caiu na vila, penalty pro santos', 'Jogador do santos caiu na vila 
e juizao nao deu penalty ', 5, 5)

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



