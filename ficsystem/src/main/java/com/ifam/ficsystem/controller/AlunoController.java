package com.ifam.ficsystem.controller;


import com.ifam.ficsystem.controller.dto.AlunoDto;
import com.ifam.ficsystem.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") @CrossOrigin(origins = "http://localhost:4200")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/alunos")
    public ResponseEntity<List<AlunoDto>> getAllAlunos() {
        List<AlunoDto> alunos = alunoService.getAllAlunos();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @PostMapping("/aluno")
    public ResponseEntity<AlunoDto> getAllAlunos(@RequestBody AlunoDto alunoDto) {
        AlunoDto std = alunoService.addAluno(alunoDto);
        return new ResponseEntity<>(std, HttpStatus.CREATED);
    }

    @PutMapping("/aluno/{id}")
    public ResponseEntity<AlunoDto> updateAluno(@PathVariable(name = "id") Long aluno_id,
                                                    @RequestBody AlunoDto aluno) {
        AlunoDto std = alunoService.updateAluno(aluno_id, aluno);
        return new ResponseEntity<>(std, HttpStatus.CREATED);
    }

    @DeleteMapping("/aluno/{id}")
    public ResponseEntity<String> deleteAluno(@PathVariable(name = "id") Long aluno_id) {
        String message = alunoService.deleteAluno(aluno_id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
