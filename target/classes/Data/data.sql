

INSERT INTO usuario (password,username) VALUES ('$2a$10$UCGyX7aXX4jugVnQNt.9pOzEhOLD1z2KVzbZK/Bi1Dy6KZiqhZOy2','admin');


INSERT INTO usuario (password,username) VALUES ('$2a$10$2Vm9AnyFTfnukmkpN5whgu1AP1itO6JWXNDRKll4TznsWEuRISm5e','estudiante');
INSERT INTO usuario (password,username) VALUES ('$2a$10$BUyqe5VknBu/H5VMqmHiG.bY8YfCo2oJzdyoN0hfDXg/7we.kzxrG','fredy');
INSERT INTO usuario (password,username) VALUES ('$2a$10$J05/DugMCz3SnxONltWYoeZDlGoOhXWfOhayOEx0tyUAOo10wCR9C','daniel');
INSERT INTO usuario (password,username) VALUES ('$2a$10$desCSzmQK.08lHOJ1ursGuq0YaeC.MfLlIsptbHbqsShXZIo.kiNS','juan');
INSERT INTO usuario (password,username) VALUES ('$2a$10$pmzgz6FAud41NNtEhOPjIu74ja31SS2tTq2a/.9G83wlNtTWCz5e2','bart');
INSERT INTO usuario (password,username) VALUES ('$2a$10$ztOmV8AZfMOF5SCc//7n6eLHgXqr8B2V9C69nceb6c36Uv2yupg3K','lisa');
INSERT INTO usuario (password,username) VALUES ('$2a$10$VBqPIUoeHLgKFlFan1orIumwCNDxRF1F5PcpksM3WQK/uZ00ZZSwm','luisa');
INSERT INTO usuario (password,username) VALUES ('$2a$10$sTHHl392Ahncc/o4wt3Jyube53nW2vl8wU0cBwKcNrXQEPsOp6W8O','terry');


INSERT INTO administrador (apellidos, nombre, id_usuario) VALUES ('Belez', 'Humberto', 1);


INSERT INTO estudiante ( fecha, dni, email, apellidos, nombre, id_usuario) VALUES ('1999-01-20', '12345678', 'pablo.marmol@gmail.com', 'Marmol', 'Pablo', 2);
INSERT INTO estudiante ( fecha, dni, email, apellidos, nombre, id_usuario) VALUES ('2000-02-15', '12345679', 'fredy@gmail.com', 'astorayme', 'fredy', 3);
INSERT INTO estudiante ( fecha, dni, email, apellidos, nombre, id_usuario) VALUES ('1998-10-02', '12346577', 'daniel@gmail.com', 'garcia', 'daniel', 4);
INSERT INTO estudiante ( fecha, dni, email, apellidos, nombre, id_usuario) VALUES ('2000-11-16', '12345699', 'juan@gmail.com', 'reyes', 'juan', 5);
INSERT INTO estudiante ( fecha, dni, email, apellidos, nombre, id_usuario) VALUES ('2000-09-07', '32165487', 'bart@gmail.com', 'simpson', 'bart', 6);
INSERT INTO estudiante ( fecha, dni, email, apellidos, nombre, id_usuario) VALUES ('2001-12-07', '12346555', 'lisa@gmail.com', 'simpson', 'lisa', 7);
INSERT INTO estudiante ( fecha, dni, email, apellidos, nombre, id_usuario) VALUES ('2000-08-21', '87564123', 'luisa.gallego@gmail.com', 'Gallego Basteri', 'Luisa', 8);
INSERT INTO estudiante ( fecha, dni, email, apellidos, nombre, id_usuario) VALUES ('2000-08-23', '87564123', 'terry.kang@gmail.com', 'Kang Luca', 'Terry', 9);


INSERT INTO docente ( fecha, dni, email, apellidos, nombre, celular) VALUES ('1985-03-20', '70365678', 'profesor1.edukate@gmail.com', 'Perez Astorayme', 'Juan', '985645852');
INSERT INTO docente ( fecha, dni, email, apellidos, nombre, celular) VALUES ('1993-12-21', '70322678', 'profesor2.edukate@gmail.com', 'Torres Choi', 'Subin', '98234552');
INSERT INTO docente ( fecha, dni, email, apellidos, nombre, celular) VALUES ('1992-02-22', '71234638', 'profesor3.edukate@gmail.com', 'Picapiedra Astetik', 'Pedro', '912045462');
INSERT INTO docente ( fecha, dni, email, apellidos, nombre, celular) VALUES ('1994-10-20', '70365678', 'profesor4.edukate@gmail.com', 'Reyes Morales', 'Oscar', '985645852');
INSERT INTO docente ( fecha, dni, email, apellidos, nombre, celular) VALUES ('1990-04-21', '70322678', 'profesor5.edukate@gmail.com', 'Mendoza Barreda', 'Armando', '98234552');
INSERT INTO docente ( fecha, dni, email, apellidos, nombre, celular) VALUES ('1989-08-22', '71234638', 'profesor6.edukate@gmail.com', 'Calderon Gutierrez', 'Mario', '912045462');


INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Con este curso de Excel avanzado, aprenderás cuáles son los aspectos y funcionalidades más complejas.', 'Excel Avanzado', 170, 1);
INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Con este curso de PowerPoint avanzado, aprenderás a realizar presetaciones avanzadas empleando nuevas herramientas.', 'PowerPoint Avanzado', 170, 2);
INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Este curso te dará las herramientas necesarias para convertirte en un experto en el tema, empezaremos com operaciones básicas.', 'MATLAB Básico', 100, 3);
INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Con este curso de Excel intermedio, aprenderás cuáles son los aspectos y funcionalidades más complejas.', 'Excel Intermedio', 120, 1);
INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Con este curso de PowerPoint intermedio, aprenderás a realizar presetaciones avanzadas empleando nuevas herramientas.', 'PowerPoint Intermedio', 120, 2);
INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Este curso te dará las herramientas necesarias para convertirte en un experto en el tema, empezaremos desde operaciones intermedias.', 'MATLAB Intermedio', 120, 3);
INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Con este curso de Excel basico, aprenderás cuáles son los aspectos y funcionalidades más complejas.', 'Excel Basico', 100, 1);
INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Con este curso de PowerPoint basico, aprenderás a realizar presetaciones avanzadas empleando nuevas herramientas.', 'PowerPoint Basico', 100, 2);
INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Este curso te dará las herramientas necesarias para convertirte en un experto en el tema, tocaremos operaciones complejas.', 'MATLAB Avanzado', 170, 3);
INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Con este curso de SQL Avanzado conoceras a profundidad manejo de bases de datos.', 'SQL Avanzado', 170, 4);
INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Con este curso de Power BI Avanzado aprenderas a hacer reportes complejos para tus negocios.', 'Power BI Avanzado', 170, 5);
INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Este curso te dará los conocimientos necesarios para que empieces a desarrollar aplicaciones.', 'Javascript Básico', 100, 6);
INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Con este curso de SQL intermedio conoceras a diversas funciones de bases de datos.', 'SQL Intermedio', 120, 4);
INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Con este curso de Power BI intermedio aprenderas a hacer reportes variados para tus negocios.', 'Power BI Intermedio', 120, 5);
INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Este curso te dará los conocimientos necesarios para que empieces a desarrollar aplicaciones y conectarlas a tus páginas web.', 'Javascript Intermedio', 120, 6);
INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Con este curso de SQL basico conoceras daras tus primeros pasos en las bases de datos.', 'SQL Basico', 100, 4);
INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Con este curso de Power BI básico aprenderas a hacer reportes básicos para tus negocios.', 'Power BI Basico', 100, 5);
INSERT INTO curso ( descripción, nombre, precio, id_teacher) VALUES ('Este curso te dará los conocimientos necesarios para que empieces a desarrollar aplicaciones desde frontend y backend.', 'Javascript Avanzado', 170, 6);


INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 1, 1);
INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 2, 1);

INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 1, 2);
INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 2, 2);
INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-05-25',true, 5, 2);

INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 5, 3);
INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-05-25',true, 4, 3);
INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 3, 3);

INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 6, 4);
INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-05-25',true, 8, 4);
INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 9, 4);

INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 13, 5);
INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 17, 5);

INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-05-25',true, 5, 6);
INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 4, 6);


INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 10, 7);
INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-05-25',true, 15, 7);
INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-03-20',true, 11, 7);


INSERT INTO matricula ( fecha_registro, enabled, id_course, id_student) VALUES ('2022-05-25',true, 10, 8);

