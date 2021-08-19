package com.ifam.ficsystem.repository;

import com.ifam.ficsystem.model.Turma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    public Turma findByNome(String nome);
}
