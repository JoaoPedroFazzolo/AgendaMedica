ALTER TABLE funcionario
    ADD COLUMN email VARCHAR(255);

UPDATE funcionario
SET email = 'exemplo@dominio.com';

ALTER TABLE funcionario
    ALTER COLUMN email SET NOT NULL;