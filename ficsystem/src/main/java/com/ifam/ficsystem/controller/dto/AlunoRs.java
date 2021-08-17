package com.ifam.ficsystem.controller.dto;

import com.ifam.ficsystem.model.Aluno;
import java.util.List;

public class AlunoRs {

   private Long aluno_id;
   private String matricula;
   private String nome;



   public static AlunoRs converter(Aluno a) {

       var aluno = new AlunoRs();

       aluno.setAlunoId(a.getAlunoId());
       aluno.setMatricula(a.getMatricula());
       aluno.setNome(a.getNome());


    
       return aluno;
   }

public Long getAlunoId() { return aluno_id; }

    public void setAlunoId(Long aluno_id) { this.aluno_id = aluno_id; }


   public String getMatricula() { return matricula; }

   public void setMatricula(String matricula) { this.matricula = matricula; }


   public String getNome() { return nome; }

   public void setNome(String nome) { this.nome = nome; }

}