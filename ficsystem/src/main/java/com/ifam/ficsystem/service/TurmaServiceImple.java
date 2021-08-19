package com.ifam.ficsystem.service;

import com.ifam.ficsystem.controller.dto.AlunoDto;
import com.ifam.ficsystem.controller.dto.TurmaDto;

import com.ifam.ficsystem.model.Aluno;
import com.ifam.ficsystem.model.Turma;

import com.ifam.ficsystem.repository.AlunoRepository;
import com.ifam.ficsystem.repository.TurmaRepository;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TurmaServiceImple implements TurmaService{

    @Resource
    private AlunoRepository alunoRepository;
    @Resource
    private TurmaRepository turmaRepository;

    @Transactional
    @Override
    public TurmaDto addTurma(TurmaDto turmaDto) {
        Turma turma = new Turma();
        mapDtoToEntity(turmaDto, turma);
        Turma savedTurma = turmaRepository.save(turma);
        return mapEntityToDto(savedTurma);
    }

    @Override
    public List<TurmaDto> getAllTurmas() {
        List<TurmaDto> turmaDtos = new ArrayList<>();
        List<Turma> turmas = turmaRepository.findAll();
        turmas.stream().forEach(turma -> {
            TurmaDto turmaDto = mapEntityToDto(turma);
            turmaDtos.add(turmaDto);
        });
        return turmaDtos;
    }

    @Transactional
    @Override
    public TurmaDto updateTurma(Long id, TurmaDto turmaDto) {
        Turma crs = turmaRepository.getById(id);
        //crs.getAlunos().clear();
        mapDtoToEntity(turmaDto, crs);
        Turma turma = turmaRepository.save(crs);
        return mapEntityToDto(turma);
    }

    @Transactional
    @Override
    public String deleteTurma(Long id) {
        Optional<Turma> turma = turmaRepository.findById(id);
        // Remove the related students from course entity.
        if(turma.isPresent()) {
            turma.get().removeAlunos();
            turmaRepository.deleteById(turma.get().getId());
            return "Course with id: " + id + " deleted successfully!";
        }
        return null;
    }

    private void mapDtoToEntity(TurmaDto turmaDto, Turma turma) {
        turma.setNome(turmaDto.getNome());
        turma.setDataInicio(turmaDto.getDataInicio());
        turma.setDataFim(turmaDto.getDataFim());
        turma.setProfessor(turmaDto.getProfessor());
        turma.setCursoFic(turmaDto.getCursoFic());
        if (null == turma.getAlunos()) {
            turma.setAlunos(new HashSet<>());
        }
        turmaDto.getAlunos().stream().forEach(alunoName -> {
            Aluno aluno = alunoRepository.findByName(alunoName);
            if (null == aluno) {
                aluno = new Aluno();
                aluno.setTurmas(new HashSet<>());
            }
            aluno.setName(alunoName);
            aluno.setMatricula(aluno.getMatricula());
            aluno.addTurma(turma);
        });
    }

    private TurmaDto mapEntityToDto(Turma turma) {
        TurmaDto responseDto = new TurmaDto();
        responseDto.setId(turma.getId());
        responseDto.setNome(turma.getNome());
        responseDto.setDataInicio(turma.getDataInicio());
        responseDto.setDataFim(turma.getDataFim());
        responseDto.setProfessor(turma.getProfessor());
        responseDto.setCursoFic(turma.getCursoFic());
        responseDto.setAlunos(turma.getAlunos().stream().map(Aluno::getName).collect(Collectors.toSet()));
        /*responseDto.setAlunos(turma.getAlunos().stream().map(AlunoDto::from).collect(Collectors.toSet()));*/
        return responseDto;
    }

    /*List<TurmaDto> turmaDtos = turmas.stream().map(TurmaDto::from).collect(Collectors.toList());*/

}
