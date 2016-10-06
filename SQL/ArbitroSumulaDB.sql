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
