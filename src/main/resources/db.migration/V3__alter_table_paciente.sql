ALTER TABLE paciente
    ADD COLUMN email VARCHAR(255);

UPDATE paciente
SET email = 'exemplo@dominio.com';

ALTER TABLE paciente
    ALTER COLUMN email SET NOT NULL;