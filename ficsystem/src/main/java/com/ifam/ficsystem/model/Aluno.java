package com.model;

import javax.persistence.*;

@Entity
@Table(name = "aluno")

public class Aluno{
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   @Column(name = "aluno_id")
   private Long aluno_id;

   @Column(name = "nome")
   private String name;

   @Column(name = "matrícula")
   private String matricula;

   private List<Turma> turmas;


   @OneToMany(mappedBy = "aluno_id", cascade = CascadeType.ALL)
   public List<Turma> getTurmas() { return turmas; }
   
   public void setTurmas(List<Turma> turmas) { this.turmas = turmas; }



   public Long getProfessorId() { return aluno_id; }
   
   public void setProfessorId(Long aluno_id) { this.aluno_id = aluno_id; }


   public String getNome() { return nome; }
   
   public void setNome(String nome) { this.nome = nome; }


   public String getMatricula() { return matricula; }
   
   public void setMatricula(String matricula) { this.matricula = matricula; }


}


