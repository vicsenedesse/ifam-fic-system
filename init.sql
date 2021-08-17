CREATE DATABASE IF NOT EXISTS db_ficsystem;
USE db_ficsystem;


CREATE TABLE user (
  id INT AUTO_INCREMENT NOT NULL,
  name VARCHAR(50) NOT NULL,
  login VARCHAR(30) NOT NULL,
  password VARCHAR(20) NOT NULL,
  email VARCHAR(40) NOT NULL,

  PRIMARY KEY (user_id)
  
);

CREATE TABLE professor (
  professor_id INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(50) NOT NULL,
  matricula VARCHAR(15) NOT NULL,

  turma_id INT NOT NULL,

  PRIMARY KEY (professor_id)
);

CREATE TABLE aluno (
  aluno_id INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(50) NOT NULL,
  matricula VARCHAR(15) NOT NULL,

  PRIMARY KEY (aluno_id)
  
);

CREATE TABLE cursoFic (
  cursoFic_id INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(50) NOT NULL,

  PRIMARY KEY (cursoFic_id)
  
);


CREATE TABLE turma (
  turma_id INT AUTO_INCREMENT NOT NULL,
  nome VARCHAR(50) NOT NULL,
  dataInicio TIME NOT NULL,
  dataFim TIME NOT NULL,

  aluno_id INT NOT NULL,
  professor_id INT NOT NULL,
  cursoFic_id INT NOT NULL,

  FOREIGN KEY (aluno_id) references aluno(aluno_id),
  FOREIGN KEY (professor_id) references professor(professor_id),
  FOREIGN KEY (cursoFic_id) references cursoFic(cursoFic_id),

  PRIMARY KEY (turma_id)
  
);
-- TO DO
-- SCRIPTS

-- INSERT INTO user(id, name, login, password, email) 
-- VALUES (1,'Raphaela Goes','rapha.goes','s3nh4','email1@email.com');

-- INSERT INTO user(id, name, login, password, email) 
-- VALUES (2,'Rodrigo Carvalho','rodrigo.carvalho','s3nh4','email2@email.com');

-- INSERT INTO user(id, name, login, password, email) 
-- VALUES (3,'Victoria Senedesse','victoria.senedesse','s3nh4','email3@email.com');
