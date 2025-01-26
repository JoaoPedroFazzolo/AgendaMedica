ALTER TABLE medico
ADD COLUMN email VARCHAR(255);

UPDATE medico
SET email = 'exemplo@dominio.com';

ALTER TABLE medico
    ALTER COLUMN email SET NOT NULL;
