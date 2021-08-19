package com.ifam.ficsystem.service;

import com.ifam.ficsystem.controller.dto.TurmaDto;

import java.util.List;

public interface TurmaService {

    public TurmaDto addTurma(TurmaDto turmaDto);

    public List<TurmaDto> getAllTurmas();

    public TurmaDto updateTurma(Long id, TurmaDto turma);

    public String deleteTurma(Long id);
}
