CREATE TABLE IF NOT EXISTS users(
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(120) NOT NULL,
    creation_date DATE NOT NULL,
    role VARCHAR(50) NOT NULL
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

INSERT INTO users(email, password, creation_date, role)
VALUES ('test@test.com', '$2a$12$f82t/iwyRgr3hPuc6fDeFOKNW0DM9z7juxR3iU6/HVf35EoxhpzD6', '2005-04-25', 'USER');
