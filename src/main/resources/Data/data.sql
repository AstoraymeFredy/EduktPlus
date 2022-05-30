
INSERT INTO usuario (password,username) VALUES ('$2a$10$UCGyX7aXX4jugVnQNt.9pOzEhOLD1z2KVzbZK/Bi1Dy6KZiqhZOy2','admin');
INSERT INTO usuario (password,username) VALUES ('$2a$10$2Vm9AnyFTfnukmkpN5whgu1AP1itO6JWXNDRKll4TznsWEuRISm5e','estudiante');


INSERT INTO administrador (apellidos, nombre, id_usuario) VALUES ('Belez', 'Humberto', 1);
INSERT INTO estudiante ( fecha, dni, email, apellidos, nombre, id_usuario) VALUES ('2000-08-20', '12345678', 'pablo.marmol@gmail.com', 'Marmol', 'Pablo', 2);
INSERT INTO estudiante ( fecha, dni, email, apellidos, nombre, id_usuario) VALUES ('2000-08-21', '87564123', 'luisa.gallego@gmail.com', 'Gallego Basteri', 'Luisa', 2);
INSERT INTO estudiante ( fecha, dni, email, apellidos, nombre, id_usuario) VALUES ('2000-08-23', '87564123', 'terry.kang@gmail.com', 'Kang Luca', 'Terry', 2);


INSERT INTO docente ( fecha, dni, email, enabled, apellidos, nombre, celular) VALUES ('2000-08-20', '70365678', 'profesor1.edukate@gmail.com', true, 'Perez Astorayme', 'Juan', '985645852');
INSERT INTO docente ( fecha, dni, email, enabled, apellidos, nombre, celular) VALUES ('2000-08-21', '70322678', 'profesor2.edukate@gmail.com', true, 'Torres Choi', 'Subin', '98234552');
INSERT INTO docente ( fecha, dni, email, enabled, apellidos, nombre, celular) VALUES ('2000-08-22', '71234638', 'profesor3.edukate@gmail.com', true, 'Picapiedra Astetik', 'Pedro', '912045462');


INSERT INTO curso ( descripción, enabled, nombre, precio, id_teacher) VALUES ('Con este curso de Excel de básico a avanzado, aprenderás cuáles son los aspectos y funcionalidades más complejas.', true, 'Excel Avanzado', 50, 1);
INSERT INTO curso ( descripción, enabled, nombre, precio, id_teacher) VALUES ('Con este curso de PowerPoint de básico a avanzado, aprenderás a realizar presetaciones avanzadas empleando nuevas herramientas.', true, 'PowerPoint Avanzado', 100, 1);


INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 1, 1);
INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 1, 2);
INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 2, 1);
INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 2, 2);
INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 2, 3);

