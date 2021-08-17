package com.ifam.ficsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ifam.ficsystem.controller.dto.AlunoRq;
import com.ifam.ficsystem.controller.dto.AlunoRs;
import com.ifam.ficsystem.model.Aluno;
import com.ifam.ficsystem.repository.AlunoCustomRepository;
import com.ifam.ficsystem.repository.AlunoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/aluno") @CrossOrigin(origins = "http://localhost:4200")
public class AlunoController {

    private final AlunoRepository alunoRepository;
    private final AlunoCustomRepository alunoCustomRepository;

    public AlunoController(AlunoRepository alunoRepository, AlunoCustomRepository alunoCustomRepository) {
        this.alunoRepository = alunoRepository;
        this.alunoCustomRepository = alunoCustomRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/") 
    public List<AlunoRs> findAll() {
        var alunos = alunoRepository.findAll();
        return alunos
        .stream()
        .map(AlunoRs::converter)
        .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{aluno_id}") 
    public AlunoRs findByAlunoId(@PathVariable("aluno_id") Long aluno_id) {
        var aluno = alunoRepository.getOne(aluno_id);
        return AlunoRs.converter(aluno);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/aluno")  
    public ResponseEntity<String> savePerson(@RequestBody AlunoRq aluno) {
        var Na = new Aluno();

        Na.setNome(aluno.getNome());
        Na.setMatricula(aluno.getMatricula());
        

        alunoRepository.save(Na);
        return ResponseEntity.ok("Sucesso!");

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{aluno_id}") 
    public void updatePerson(@PathVariable("aluno_id") Long aluno_id, @RequestBody AlunoRq aluno) throws Exception {
        var A = alunoRepository.findById(aluno_id);

        if (A.isPresent()){
            var alunoSave = A.get();
            alunoSave.setNome(aluno.getNome());
            alunoSave.setMatricula(aluno.getMatricula());

            alunoRepository.save(alunoSave);
        }else{
            throw new Exception("Aluno não matriculado");
        }
    }

    @DeleteMapping(path ={"/{aluno_id}"})
    public ResponseEntity <?> delete(@PathVariable long aluno_id) {
       return alunoRepository.findById(aluno_id).map(record -> {
           alunoRepository.deleteById(aluno_id);
           return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/filter") 
    public List<AlunoRs> findPersonByMatricula(@RequestParam("matricula") String matricula) {
        return this.alunoRepository.findByMatriculaContains(matricula)
        .stream()
        .map(AlunoRs::converter)
        .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/filter/custom") 
    public List<AlunoRs> findPersonByCustom(
    
        @RequestParam(value = "matricula", required = false) String matricula,
        @RequestParam(value = "nome", required = false) String nome
    )
    {return this.alunoCustomRepository.find(matricula, nome)
        .stream()
        .map(AlunoRs::converter)
        .collect(Collectors.toList());
    }

}