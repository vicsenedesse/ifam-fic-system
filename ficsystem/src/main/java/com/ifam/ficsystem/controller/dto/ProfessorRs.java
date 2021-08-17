
package com.controller.dto;

import com.model.Professor;
import com.model.Turma;
import java.util.List;

public class ProfessorRs {

   private Long professor_id;
   private String matricula;
   private String nome;

   private List<Turma> turmas;



   public static ProfessorRs converter(Professor t) {

       var professor = new ProfessorRs();

       professor.setProfessor_id(t.getProfessor_id());
       professor.setMatricula(t.getMatricula());
       professor.setNome(t.getNome());

       professor.setTurmas(t.getTurmas());


    
       return professor;
   }


    public List<Turma> getTurmas() { return turmas; }

    public void setTurmas(List<Turma> turmas) { this.turmas = turmas; }



    public Long getProfessor_id() { return professor_id; }

    public void setProfessor_id(Long professor_id) { this.professor_id = professor_id; }


   public String getMatricula() { return matricula; }

   public void setMatricula(String matricula) { this.matricula = matricula; }


   public String getNome() { return nome; }

   public void setNome(String nome) { this.nome = nome; }

}