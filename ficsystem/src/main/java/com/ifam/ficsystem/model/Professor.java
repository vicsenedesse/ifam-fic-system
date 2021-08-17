//package com.veterinary_clinic_adm.register.model;
package com.model;

import javax.persistence.*;

@Entity
@Table(name = "professor")

public class Professor{
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   @Column(name = "professor_id")
   private Long professor_id;

   @Column(name = "nome")
   private String name;

   @Column(name = "matricula")
   private String matricula;

   private List<Turma> turmas;


   @OneToMany(mappedBy = "professor_id", cascade = CascadeType.ALL)
   public List<Turma> getTurmas() { return turmas; }
   
   public void setTurmas(List<Turma> turmas) { this.turmas = turmas; }



   public Long getProfessorId() { return professor_id; }
   
   public void setProfessorId(Long professor_id) { this.professor_id = professor_id; }


   public String getNome() { return nome; }
   
   public void setNome(String nome) { this.nome = nome; }


   public String getMatricula() { return matricula; }
   
   public void setMatricula(String matricula) { this.matricula = matricula; }


}


