package com.ifam.ficsystem.controller.dto;

import com.ifam.ficsystem.model.Aluno;
import com.ifam.ficsystem.model.Turma;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class TurmaDto {

    private Long id;
    private String nome;
    private String dataInicio;
    private String dataFim;
    private String professor;
    private String cursoFic;
    Set<String> alunos = new HashSet<>();

    /*public static TurmaDto from(Turma turma){
        TurmaDto turmaDto = new TurmaDto();
        turmaDto.setId(turma.getId());
        turmaDto.setNome(turma.getNome());
        turmaDto.setDataInicio(turma.getDataInicio());
        turmaDto.setDataFim(turma.getDataFim());
        turmaDto.setProfessor(turma.getProfessor());
        turmaDto.setCursoFic(turma.getCursoFic());
        turmaDto.setAlunos(turma.getAlunos().stream().map(AlunoDto::from).collect(Collectors.toList()));
        return turmaDto;
    }*/
}
