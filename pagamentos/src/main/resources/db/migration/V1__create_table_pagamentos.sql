CREATE TABLE pagamentos(
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER NOT NULL,
    pedido_id INTEGER NOT NULL,
    valor NUMERIC(10,2) NOT NULL,
    forma_pagamento VARCHAR(20)
);