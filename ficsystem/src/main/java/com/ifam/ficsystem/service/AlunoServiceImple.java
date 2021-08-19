package com.ifam.ficsystem.service;

import com.ifam.ficsystem.controller.dto.AlunoDto;
import com.ifam.ficsystem.controller.dto.TurmaDto;

import com.ifam.ficsystem.model.Aluno;
import com.ifam.ficsystem.model.Turma;

import com.ifam.ficsystem.repository.AlunoRepository;
import com.ifam.ficsystem.repository.TurmaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoServiceImple implements AlunoService {

    @Resource
    private AlunoRepository alunoRepository;

    @Resource
    private TurmaRepository turmaRepository;

    @Transactional
    @Override
    public AlunoDto addAluno(AlunoDto alunoDto) {
        Aluno aluno = new Aluno();
        mapDtoToEntity(alunoDto, aluno);
        Aluno savedAluno = alunoRepository.save(aluno);
        return mapEntityToDto(savedAluno);
    }

    @Override
    public List<AlunoDto> getAllAlunos() {
        List<AlunoDto> alunoDtos = new ArrayList<>();
        List<Aluno> alunos = alunoRepository.findAll();
        alunos.stream().forEach(aluno -> {
            AlunoDto alunoDto = mapEntityToDto(aluno);
            alunoDtos.add(alunoDto);
        });
        return alunoDtos;
    }

    @Override
    public AlunoDto updateAluno(Long aluno_id, AlunoDto alunoDto) {
        Aluno std = alunoRepository.getById(aluno_id);
        //std.getTurmas().clear();
        mapDtoToEntity(alunoDto, std);
        Aluno aluno = alunoRepository.save(std);
        return mapEntityToDto(aluno);
    }

    @Override
    public String deleteAluno(Long aluno_id) {
        Optional<Aluno> aluno = alunoRepository.findById(aluno_id);
        //Remove the related courses from student entity.
        if(aluno.isPresent()) {
            aluno.get().removeTurmas();
            alunoRepository.deleteById(aluno.get().getAluno_id());
            return "Student with id: " + aluno_id + " deleted successfully!";
        }
        return null;
    }


    private void mapDtoToEntity(AlunoDto alunoDto, Aluno aluno) {

        aluno.setName(alunoDto.getName());
        aluno.setMatricula(alunoDto.getMatricula());
        if (null == aluno.getTurmas()) {
            aluno.setTurmas(new HashSet<>());
        }
        alunoDto.getTurmas().stream().forEach(turmaNome -> {
            Turma turma = turmaRepository.findByNome(turmaNome);
            if (null == turma) {
                turma = new Turma();
                turma.setAlunos(new HashSet<>());
            }
            turma.setNome(turmaNome);
            //turma.setDataInicio(turma.getDataInicio()).findByNome(turmaNome);
            turma.setDataInicio(turma.getDataInicio());
            turma.setDataFim(turma.getDataFim());
            turma.setProfessor(turma.getProfessor());
            turma.setCursoFic(turma.getCursoFic());
            aluno.addTurma(turma);
        });
    }


    private AlunoDto mapEntityToDto(Aluno aluno) {
        AlunoDto responseDto = new AlunoDto();
        responseDto.setAluno_id(aluno.getAluno_id());
        responseDto.setName(aluno.getName());
        responseDto.setMatricula(aluno.getMatricula());
        responseDto.setTurmas(aluno.getTurmas().stream().map(Turma::getNome).collect(Collectors.toSet()));
        return responseDto;
    }
}
