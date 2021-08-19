CREATE DATABASE IF NOT EXISTS db_ficsystem;
USE db_ficsystem;


-- CREATE TABLE user (
--   user_professor_id INT AUTO_INCREMENT NOT NULL,
--   name VARCHAR(50) NOT NULL,
--   login VARCHAR(30) NOT NULL,
--   password VARCHAR(20) NOT NULL,
--   email VARCHAR(40) NOT NULL,

--   PRIMARY KEY (user_id)
  
-- );

CREATE TABLE professor (
  professor_id INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(255) NOT NULL,
  matricula VARCHAR(255) NOT NULL,

  PRIMARY KEY (professor_id)
);

CREATE TABLE aluno (
  aluno_id INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(255) NOT NULL,
  matricula VARCHAR(255) NOT NULL,

  PRIMARY KEY (aluno_id)
  
);

CREATE TABLE cursoFic (
  cursoFic_id INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(255) NOT NULL,

  PRIMARY KEY (cursoFic_id)
  
);

CREATE TABLE turma (
  turma_id INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(255) NOT NULL,
  data_inicio VARCHAR(10) NOT NULL,
  data_fim VARCHAR(10) NOT NULL,
  professor VARCHAR(255) NOT NULL,
  curso_fic VARCHAR(255) NOT NULL,

  PRIMARY KEY (turma_id)
  
);

CREATE TABLE turma_aluno(
  aluno_id INT NOT NULL,
  turma_id INT NOT NULL,

  FOREIGN KEY (aluno_id) REFERENCES aluno(aluno_id),
  FOREIGN KEY (turma_id) REFERENCES turma(turma_id)

);
-- TO DO
-- SCRIPTS

-- INSERT INTO user(user_id, name, login, password, email) 
-- VALUES (1,'Raphaela Goes','rapha.goes','s3nh4','email1@email.com');

-- INSERT INTO user(user_id, name, login, password, email) 
-- VALUES (2,'Rodrigo Carvalho','rodrigo.carvalho','s3nh4','email2@email.com');

-- INSERT INTO user(user_id, name, login, password, email) 
-- VALUES (3,'Victoria Senedesse','victoria.senedesse','s3nh4','email3@email.com');


INSERT INTO professor(professor_id, nome, matricula) 
VALUES (1,'Albert França','00963200001');

INSERT INTO professor(professor_id, nome, matricula) 
VALUES (2,'Benevaldo Pereira','00963200002');

INSERT INTO professor(professor_id, nome, matricula) 
VALUES (3,'Carlos Louzada','00963200003');

INSERT INTO professor(professor_id, nome, matricula) 
VALUES (4,'Amadeu Arlindo','00963200004');

INSERT INTO professor(professor_id, nome, matricula) 
VALUES (5,'Paulo Aguila','00963200005');

INSERT INTO professor(professor_id, nome, matricula) 
VALUES (6,'Carlos Mar','00963200006');

INSERT INTO professor(professor_id, nome, matricula) 
VALUES (7,'Andrea Baima','00963200007');



INSERT INTO aluno(aluno_id, nome, matricula) 
VALUES (1,'Raphaela Goes','2019001011');

INSERT INTO aluno(aluno_id, nome, matricula) 
VALUES (2,'Rodrigo Moura','2019001012');

INSERT INTO aluno(aluno_id, nome, matricula) 
VALUES (3,'Victoria Senedesse','2019001013');

INSERT INTO aluno(aluno_id, nome, matricula) 
VALUES (4,'Yasmin Martins','2019001014');



INSERT INTO turma(turma_id, nome, data_inicio, data_fim, professor, curso_fic) 
VALUES (1,'Fundamentos de Docker 092021','27/08/2021','15/09/2021', 'Benevaldo Pereira', 'Fundamentos de Docker');

INSERT INTO turma(turma_id, nome, data_inicio, data_fim, professor, curso_fic) 
VALUES (2,'Segurança da Informação ','24/09/2021','20/10/2021', 'Albert França', 'Segurança da Informação');

INSERT INTO turma(turma_id, nome, data_inicio, data_fim, professor, curso_fic) 
VALUES (3,'Desenvolvimento Web em Angular','14/10/2021','05/11/2021', 'Carlos Mar', 'Desenvolvimento Web em Angular');

INSERT INTO turma(turma_id, nome, data_inicio, data_fim, professor, curso_fic) 
VALUES (4,'UI/UX Design','14/10/2021','05/11/2021', 'Amadeu Arlindo', 'UI/UX Design');

INSERT INTO turma(turma_id, nome, data_inicio, data_fim, professor, curso_fic) 
VALUES (5,'Desenvolvimento de Jogos','20/10/2021','15/11/2021', 'Carlos Louzada', 'Desenvolvimento de Jogos');