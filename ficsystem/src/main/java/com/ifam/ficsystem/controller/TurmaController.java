package com.ifam.ficsystem.controller;

import com.ifam.ficsystem.controller.dto.TurmaDto;
import com.ifam.ficsystem.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")  @CrossOrigin(origins = "http://localhost:4200")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping("/turmas")
    public ResponseEntity<List<TurmaDto>> getAllAlunos() {
        List<TurmaDto> alunos = turmaService.getAllTurmas();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @PostMapping("/turma")
    public ResponseEntity<TurmaDto> getAllAlunos(@RequestBody TurmaDto turmaDto) {
        TurmaDto std = turmaService.addTurma(turmaDto);
        return new ResponseEntity<>(std, HttpStatus.CREATED);
    }

    @PutMapping("/turma/{id}")
    public ResponseEntity<TurmaDto> updateTurma(@PathVariable(name = "id") Long id,
                                                  @RequestBody TurmaDto turma) {
        TurmaDto crs = turmaService.updateTurma(id, turma);
        return new ResponseEntity<>(crs, HttpStatus.CREATED);
    }

    @DeleteMapping("/turma/{id}")
    public ResponseEntity<String> deleteTurma(@PathVariable(name = "id") Long id) {
        String message = turmaService.deleteTurma(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
