
package com.ifam.ficsystem.controller.dto;

import com.ifam.ficsystem.model.Professor;
import java.util.List;

public class ProfessorRs {

   private Long professor_id;
   private String matricula;
   private String nome;

   //private List<Turma> turmas;



   public static ProfessorRs converter(Professor t) {

       var professor = new ProfessorRs();

       professor.setProfessorId(t.getProfessorId());
       professor.setMatricula(t.getMatricula());
       professor.setNome(t.getNome());

       //professor.setTurmas(t.getTurmas());


    
       return professor;
   }


    //public List<Turma> getTurmas() { return turmas; }

   // public void setTurmas(List<Turma> turmas) { this.turmas = turmas; }



    public Long getProfessorId() { return professor_id; }

    public void setProfessorId(Long professor_id) { this.professor_id = professor_id; }


   public String getMatricula() { return matricula; }

   public void setMatricula(String matricula) { this.matricula = matricula; }


   public String getNome() { return nome; }

   public void setNome(String nome) { this.nome = nome; }

}