-- Exercicio 1 (M2S06)

CREATE TABLE Usuario (
	id BIGSERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	data_cadastro DATE NOT NULL
);

CREATE TABLE Projeto (
	id BIGSERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	responsavel_id BIGINT NOT NULL,
	FOREIGN KEY (responsavel_id) REFERENCES Usuario(id),
	data_inicio DATE NOT NULL
)

DROP TABLE Projeto;
DROP TABLE Usuario;

-- Exercicio 2 (M2S06)

INSERT INTO Usuario (nome, email, data_cadastro) VALUES
('Ana Silva', 'ana.silva@gmail.com', '2025-08-01'),
('Carlos Pereira', 'carlos.pereira@gmail.com', '2025-08-02'),
('Mariana Souza', 'mariana.souza@gmail.com', '2025-08-03');

INSERT INTO Projeto (nome, descricao, responsavel_id, data_inicio) VALUES
('Reflorestamento Urbano', 'Projeto para plantar árvores em áreas urbanas.', 1, '2025-08-10'),
('Coleta Seletiva Comunitária', 'Implantação de coleta seletiva em bairros.', 2, '2025-08-15');

SELECT * FROM Usuario;
SELECT * FROM Projeto;

-- Exercicio 3 (M2S06)

SELECT * FROM Usuario;
SELECT id, nome FROM Projeto;

-- Exercicio 4 (M2S06)

SELECT * FROM Usuario WHERE data_cadastro > '2024-01-01';

SELECT * FROM Projeto WHERE nome ILIKE '%Energia%';

SELECT * FROM Usuario ORDER BY nome ASC;

-- Exercicio 5 (M2S06)

UPDATE Usuario SET email = 'novoemail@example.com' WHERE id = 3;

UPDATE Projeto SET nome = 'Reflorestamento' WHERE id = 2;

SELECT * FROM Usuario WHERE id = 3;
SELECT * FROM Projeto WHERE id = 2;

-- Exercicio 6 (M2S06)

DELETE FROM Projeto WHERE data_inicio > '2025-06-30';

SELECT * FROM Projeto;
