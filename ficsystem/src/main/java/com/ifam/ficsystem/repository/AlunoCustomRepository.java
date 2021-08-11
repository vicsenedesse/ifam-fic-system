package com.repository;

import com.model.Aluno;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AlunoCustomRepository {

    private final EntityManager em;

    public AlunoCustomRepository(EntityManager em) {
        this.em = em;
    }

    public List<Aluno> find(String matricula, String nome) {

        String query = "select A from Aluno as A ";
        String condicao = "where";

        if(matricula != null) {
            query += condicao + " A.matricula = :matricula";
            condicao = " and ";
        }

        if(nome != null) {
            query += condicao + " A.nome = :nome";
            condicao = " and ";
        }

        var q = em.createQuery(query, Aluno.class);

        if(matricula != null) {
            q.setParameter("matricula", matricula);
        }

        if(nome != null) {
            q.setParameter("nome", nome);
        }

        return q.getResultList();
    }

}