CREATE TABLE pedido_itens_do_pedido (
    pedido_id BIGINT NOT NULL,
    nome_produto VARCHAR,
    quantidade INTEGER,
    preco_unitario DOUBLE PRECISION,
    CONSTRAINT fk_pedido FOREIGN KEY (pedido_id) REFERENCES pedidos(id)
);
