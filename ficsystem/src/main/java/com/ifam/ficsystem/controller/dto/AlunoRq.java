package com.ifam.ficsystem.controller.dto;

import com.ifam.ficsystem.model.Aluno;
import java.util.List;


public class AlunoRq {

   private Long aluno_id;
   private String matricula;
   private String nome;

   public Long getAluno_id() { return aluno_id; }

   public void setAluno_id(Long aluno_id) { this.aluno_id = aluno_id; }


   public String getMatricula() { return matricula; }

   public void setMatricula(String matricula) { this.matricula = matricula; }


   public String getNome() { return nome; }

   public void setNome(String nome) { this.nome = nome; }

   
}