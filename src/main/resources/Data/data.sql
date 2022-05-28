
INSERT INTO usuario (password,username) VALUES ('$2a$10$UCGyX7aXX4jugVnQNt.9pOzEhOLD1z2KVzbZK/Bi1Dy6KZiqhZOy2','admin');
INSERT INTO usuario (password,username) VALUES ('$2a$10$2Vm9AnyFTfnukmkpN5whgu1AP1itO6JWXNDRKll4TznsWEuRISm5e','estudiante');

INSERT INTO administrador (apellidos, nombre, id_usuario) VALUES ('Belez', 'Humberto', 1);
INSERT INTO estudiante ( fecha, dni, email, apellidos, nombre, id_usuario) VALUES ('2000-08-20', '12345678', 'pablo.marmol@gmail.com', 'Marmol', 'Pablo', 2);
--select * from administrador