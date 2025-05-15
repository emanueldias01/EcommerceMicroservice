CREATE TABLE pedidos (
    id SERIAL PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    modo_pagamento VARCHAR NOT NULL,
    status_pedido VARCHAR NOT NULL
);
