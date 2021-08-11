package com.controller.dto;

import com.model.Aluno;
import com.model.Turma;
import java.util.List;

public class AlunoRs {

   private Long aluno_id;
   private String matricula;
   private String nome;

   private List<Turma> turmas;



   public static AlunoRs converter(Aluno a) {

       var aluno = new AlunoRs();

       aluno.setAluno_id(t.getAluno_id());
       aluno.setMatricula(t.getMatricula());
       aluno.setNome(t.getNome());

       aluno.setTurmas(t.getTurmas());


    
       return aluno;
   }


    public List<Turma> getTurmas() { return turmas; }

    public void setTurmas(List<Turma> turmas) { this.turmas = turmas; }



    public Long getAluno_id() { return aluno_id; }

    public void setAluno_id(Long aluno_id) { this.aluno_id = aluno_id; }


   public String getMatricula() { return matricula; }

   public void setMatricula(String matricula) { this.matricula = matricula; }


   public String getNome() { return nome; }

   public void setNome(String nome) { this.nome = nome; }

}