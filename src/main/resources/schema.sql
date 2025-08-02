CREATE TABLE restaurantes (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100),
  categoria VARCHAR(50),
  endereco VARCHAR(150),
  telefone VARCHAR(20),
  taxa_entrega DECIMAL(5,2),
  avaliacao DECIMAL(2,1),
  ativo BOOLEAN
);
