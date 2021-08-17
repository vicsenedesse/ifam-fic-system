package com.ifam.ficsystem.model;

import javax.persistence.*;

@Entity
@Table(name = "aluno")

public class Aluno{
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   @Column(name = "aluno_id")
   private Long aluno_id;

   @Column(name = "nome")
   private String nome;

   @Column(name = "matrícula")
   private String matricula;


   public Long getAlunoId() { return aluno_id; }
   
   public void setAlunoId(Long aluno_id) { this.aluno_id = aluno_id; }


   public String getNome() { return nome; }
   
   public void setNome(String nome) { this.nome = nome; }


   public String getMatricula() { return matricula; }
   
   public void setMatricula(String matricula) { this.matricula = matricula; }


}


