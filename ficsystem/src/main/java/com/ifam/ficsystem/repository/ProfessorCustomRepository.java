package com.ifam.ficsystem.repository;

import com.ifam.ficsystem.model.Professor;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProfessorCustomRepository {

    private final EntityManager em;

    public ProfessorCustomRepository(EntityManager em) {
        this.em = em;
    }

    public List<Professor> find(String matricula, String nome) {

        String query = "select P from Professor as P ";
        String condicao = "where";

        if(matricula != null) {
            query += condicao + " P.matricula = :matricula";
            condicao = " and ";
        }

        if(nome != null) {
            query += condicao + " P.nome = :nome";
            condicao = " and ";
        }

        var q = em.createQuery(query, Professor.class);

        if(matricula != null) {
            q.setParameter("matricula", matricula);
        }

        if(nome != null) {
            q.setParameter("nome", nome);
        }

        return q.getResultList();
    }

}