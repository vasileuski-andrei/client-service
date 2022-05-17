CREATE TABLE IF NOT EXISTS users(
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(120) NOT NULL,
    creation_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS client(
    id BIGSERIAL PRIMARY KEY,
    client_name VARCHAR(50) NOT NULL UNIQUE,
    creation_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS orders(
    id BIGSERIAL PRIMARY KEY,
    client_id BIGINT,
    cost INT NOT NULL,
    creation_date DATE NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(id)
);
