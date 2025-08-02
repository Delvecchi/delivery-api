-- Inserir restaurantes
INSERT INTO restaurantes (nome, categoria, endereco, telefone, taxa_entrega, avaliacao, ativo)
VALUES ('Pizzaria Bella', 'Italiana', 'Av. Paulista, 1000 - São Paulo/SP', '(11) 3333-1111', 5.00, 4.5, true);
INSERT INTO restaurantes (nome, categoria, endereco, telefone, taxa_entrega, avaliacao, ativo)
VALUES ('Burger House', 'Hamburgueria', 'Rua Augusta, 500 - São Paulo/SP', '(11) 3333-2222', 3.50, 4.2, true);
INSERT INTO restaurantes (nome, categoria, endereco, telefone, taxa_entrega, avaliacao, ativo)
VALUES ('Sushi Master', 'Japonesa', 'Rua Liberdade, 200 - São Paulo/SP', '(11) 3333-3333', 8.00, 4.8, true);

-- Inserir restaurante com ID explícito
INSERT INTO restaurante (id, nome, endereco, telefone, categoria, ativo)
VALUES (1, 'Pizza Palace', 'Rua das Pizzas, 123', '(11) 1234-5678', 'Italiana', true);
INSERT INTO restaurante (id, nome, endereco, telefone, categoria, ativo)
VALUES (2, 'Burger King', 'Av. dos Hambúrgueres, 456', '(11) 8765-4321', 'Fast Food', true);

-- Inserir usuários de teste
INSERT INTO usuario (id, nome, email, senha, role, ativo, data_criacao, restaurante_id)
VALUES (1, 'Admin Sistema', 'admin@delivery.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iKXulpZR8J4OY6Nd4EMCFyZw4ufC', 'ADMIN', true, NOW(), null);
INSERT INTO usuario (id, nome, email, senha, role, ativo, data_criacao, restaurante_id)
VALUES (2, 'João Cliente', 'joao@email.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iKXulpZR8J4OY6Nd4EMCFyZw4ufC', 'CLIENTE', true, NOW(), null);
INSERT INTO usuario (id, nome, email, senha, role, ativo, data_criacao, restaurante_id)
VALUES (3, 'Maria Cliente', 'maria@email.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iKXulpZR8J4OY6Nd4EMCFyZw4ufC', 'CLIENTE', true, NOW(), null);
INSERT INTO usuario (id, nome, email, senha, role, ativo, data_criacao, restaurante_id)
VALUES (4, 'Pizza Palace', 'pizza@palace.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iKXulpZR8J4OY6Nd4EMCFyZw4ufC', 'RESTAURANTE', true, NOW(), 1);
INSERT INTO usuario (id, nome, email, senha, role, ativo, data_criacao, restaurante_id)
VALUES (5, 'Burger King', 'burger@king.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iKXulpZR8J4OY6Nd4EMCFyZw4ufC', 'RESTAURANTE', true, NOW(), 2);
INSERT INTO usuario (id, nome, email, senha, role, ativo, data_criacao, restaurante_id)
VALUES (6, 'Carlos Entregador', 'carlos@entrega.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iKXulpZR8J4OY6Nd4EMCFyZw4ufC', 'ENTREGADOR', true, NOW(), null);

-- Senha para todos os usuários: "123456"

-- Inserir produtos
INSERT INTO produto (id, nome, descricao, preco, categoria, disponivel, restaurante_id)
VALUES (1, 'Pizza Margherita', 'Pizza com molho de tomate, mussarela e manjericão', 35.90, 'Pizza', true, 1);
INSERT INTO produto (id, nome, descricao, preco, categoria, disponivel, restaurante_id)
VALUES (2, 'Pizza Pepperoni', 'Pizza com molho de tomate, mussarela e pepperoni', 42.90, 'Pizza', true, 1);
INSERT INTO produto (id, nome, descricao, preco, categoria, disponivel, restaurante_id)
VALUES (3, 'Whopper', 'Hambúrguer com carne grelhada, alface, tomate, cebola', 28.90, 'Hambúrguer', true, 2);
INSERT INTO produto (id, nome, descricao, preco, categoria, disponivel, restaurante_id)
VALUES (4, 'Big King', 'Dois hambúrgueres, alface, queijo, molho especial', 32.90, 'Hambúrguer', true, 2);

