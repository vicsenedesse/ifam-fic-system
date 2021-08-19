package com.ifam.ficsystem.model;

import com.ifam.ficsystem.controller.dto.TurmaDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "turma_id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_inicio")
    private String dataInicio;

    @Column(name = "data_fim")
    private String dataFim;

    @Column(name = "professor")
    private String professor;

    @Column(name = "curso_fic")
    private String cursoFic;

    @ManyToMany(mappedBy = "turmas")
    @JsonIgnore
    private Set<Aluno> alunos;

    public void removeAluno(Aluno aluno) {
        this.getAlunos().remove(aluno);
        aluno.getTurmas().remove(this);
    }

    public void removeAlunos() {
        for (Aluno aluno : new HashSet<>(alunos)) {
            removeAluno(aluno);
        }
    }



    /*public static Turma from(TurmaDto turmaDto){
        Turma turma = new Turma();
        turma.setNome(turmaDto.getNome());
        turma.setDataInicio(turmaDto.getDataInicio());
        turma.setDataFim(turmaDto.getDataFim());
        turma.setProfessor(turmaDto.getProfessor());
        turma.setCursoFic(turmaDto.getCursoFic());
        return turma;
    }*/
}
