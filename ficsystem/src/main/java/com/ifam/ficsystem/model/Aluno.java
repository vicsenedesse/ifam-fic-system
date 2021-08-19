package com.ifam.ficsystem.model;

import com.ifam.ficsystem.controller.dto.AlunoDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aluno_id")
    private Long aluno_id;

    @Column(name = "nome")
    private String name;

    @Column(name = "matricula")
    private String matricula;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "turma_aluno", joinColumns = { @JoinColumn(name = "aluno_id") }, inverseJoinColumns = {
            @JoinColumn(name = "turma_id") })
    private Set<Turma> turmas;

    public void addTurma(Turma turma) {
        this.turmas.add(turma);
        turma.getAlunos().add(this);
    }

    public void removeTurma(Turma turma) {
        this.getTurmas().remove(turma);
        turma.getAlunos().remove(this);
    }

    public void removeTurmas() {
        for (Turma turma : new HashSet<>(turmas)) {
            removeTurma(turma);
        }
    }

    /*public static Aluno from(AlunoDto alunoDto) {
        Aluno aluno = new Aluno();
        aluno.setName(alunoDto.getName());
        aluno.setMatricula(alunoDto.getMatricula());
        return aluno;
    }*/
}
