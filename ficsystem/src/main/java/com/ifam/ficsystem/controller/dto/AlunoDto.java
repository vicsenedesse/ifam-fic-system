package com.ifam.ficsystem.controller.dto;

import com.ifam.ficsystem.model.Aluno;
import com.ifam.ficsystem.model.Turma;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class AlunoDto {

    private Long aluno_id;
    private String name;
    private String matricula;
    private Set<String> turmas = new HashSet<>();


    /*public static AlunoDto from (Aluno aluno){
        AlunoDto alunoDto = new AlunoDto();
        alunoDto.setAluno_id(aluno.getAluno_id());
        alunoDto.setName(aluno.getName());
        alunoDto.setMatricula(aluno.getMatricula());
        alunoDto.set<Turma>(aluno.getTurmas().stream().map(TurmaDto::from).collect(Collectors.toList()));
        List<TurmaDto> turmaDtos = turmas.stream().map(TurmaDto::from).collect(Collectors.toList());
        alunoDto.setTurmas(Set<TurmaDto> turmaDtos );

        return alunoDto;
    }*/
}
