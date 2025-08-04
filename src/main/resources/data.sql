--- Apaga registros anteriores para evitar duplicidade (na ordem para respeitar FK)
DELETE FROM produtos;
DELETE FROM usuarios;
DELETE FROM restaurantes;

-- Inserir restaurantes com ids fixos (sem duplicar)
INSERT INTO restaurantes (id, nome, endereco, telefone, categoria, ativo, data_criacao)
VALUES
  (1, 'Pizza Palace', 'Rua das Pizzas, 123', '(11) 1234-5678', 'Italiana', true, CURRENT_TIMESTAMP),
  (2, 'Burger King', 'Av. dos Hambúrgueres, 456', '(11) 8765-4321', 'Fast Food', true, CURRENT_TIMESTAMP),
  (3, 'Pizzaria Bella', 'Av. Paulista, 1000 - São Paulo/SP', '(11) 3333-1111', 'Italiana', true, CURRENT_TIMESTAMP),
  (4, 'Burger House', 'Rua Augusta, 500 - São Paulo/SP', '(11) 3333-2222', 'Hamburgueria', true, CURRENT_TIMESTAMP),
  (5, 'Sushi Master', 'Rua Liberdade, 200 - São Paulo/SP', '(11) 3333-3333', 'Japonesa', true, CURRENT_TIMESTAMP);

-- Inserir usuários de teste
INSERT INTO usuarios (id, nome, email, senha, role, ativo, data_criacao, restaurante_id)
VALUES 
  (1, 'Admin Sistema', 'admin@delivery.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iKXulpZR8J4OY6Nd4EMCFyZw4ufC', 'ADMIN', true, CURRENT_TIMESTAMP, null),
  (2, 'João Cliente', 'joao@email.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iKXulpZR8J4OY6Nd4EMCFyZw4ufC', 'CLIENTE', true, CURRENT_TIMESTAMP, null),
  (3, 'Maria Cliente', 'maria@email.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iKXulpZR8J4OY6Nd4EMCFyZw4ufC', 'CLIENTE', true, CURRENT_TIMESTAMP, null),
  (4, 'Pizza Palace', 'pizza@palace.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iKXulpZR8J4OY6Nd4EMCFyZw4ufC', 'RESTAURANTE', true, CURRENT_TIMESTAMP, 1),
  (5, 'Burger King', 'burger@king.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iKXulpZR8J4OY6Nd4EMCFyZw4ufC', 'RESTAURANTE', true, CURRENT_TIMESTAMP, 2),
  (6, 'Carlos Entregador', 'carlos@entrega.com', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iKXulpZR8J4OY6Nd4EMCFyZw4ufC', 'ENTREGADOR', true, CURRENT_TIMESTAMP, null);

-- Senha para todos os usuários: "123456"

-- Inserir produtos
INSERT INTO produtos (id, nome, descricao, preco, categoria, disponivel, restaurante_id)
VALUES 
  (1, 'Pizza Margherita', 'Pizza com molho de tomate, mussarela e manjericão', 35.90, 'Pizza', true, 1),
  (2, 'Pizza Pepperoni', 'Pizza com molho de tomate, mussarela e pepperoni', 42.90, 'Pizza', true, 1),
  (3, 'Whopper', 'Hambúrguer com carne grelhada, alface, tomate, cebola', 28.90, 'Hambúrguer', true, 2),
  (4, 'Big King', 'Dois hambúrgueres, alface, queijo, molho especial', 32.90, 'Hambúrguer', true, 2);



