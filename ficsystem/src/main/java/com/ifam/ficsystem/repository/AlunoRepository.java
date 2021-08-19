package com.ifam.ficsystem.repository;

import com.ifam.ficsystem.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Aluno findByName(String name);
    Aluno findByMatricula(String matricula);
}
