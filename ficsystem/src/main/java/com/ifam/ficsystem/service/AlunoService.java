package com.ifam.ficsystem.service;

import com.ifam.ficsystem.controller.dto.AlunoDto;

import java.util.List;

public interface AlunoService {

    public AlunoDto addAluno(AlunoDto alunoDto);

    public List<AlunoDto> getAllAlunos();

    public AlunoDto updateAluno(Long aluno_id, AlunoDto aluno);

    public String deleteAluno(Long aluno_id);
}
