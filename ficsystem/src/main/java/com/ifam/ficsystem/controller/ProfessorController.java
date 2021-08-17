

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


import com.ifam.ficsystem.controller.dto.ProfessorRq;
import com.ifam.ficsystem.controller.dto.ProfessorRs;
import com.ifam.ficsystem.model.Professor;
import com.ifam.ficsystem.repository.ProfessorCustomRepository;
import com.ifam.ficsystem.repository.ProfessorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/professor") @CrossOrigin(origins = "http://localhost:4200")
public class ProfessorController {

    private final ProfessorRepository professorRepository;
    private final ProfessorCustomRepository professorCustomRepository;

    public ProfessorController(ProfessorRepository professorRepository, ProfessorCustomRepository professorCustomRepository) {
        this.professorRepository = professorRepository;
        this.professorCustomRepository = professorCustomRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/") 
    public List<ProfessorRs> findAll() {
        var professores = professorRepository.findAll();
        return professores
                .stream()
                .map(ProfessorRs::converter)
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{professor_id}") 
    public ProfessorRs findByProfessorId(@PathVariable("professor_id") Long professor_id) {
        var professor = professorRepository.getOne(professor_id);
        return ProfessorRs.converter(professor);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/professor")  
    public ResponseEntity<String> savePerson(@RequestBody ProfessorRq professor) {
        var t = new Professor();

        t.setNome(professor.getNome());
        t.setMatricula(professor.getMatricula());
        

        professorRepository.save(t);
        return ResponseEntity.ok("Sucesso!");
//        return Exception();

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{professor_id}") 
    public void updatePerson(@PathVariable("professor_id") Long professor_id, @RequestBody ProfessorRq professor) throws Exception {
        var t = professorRepository.findById(professor_id);

        if (t.isPresent()) {
            var professorSave = t.get();
            professorSave.setNome(professor.getNome());
            professorSave.setMatricula(professor.getMatricula());

            professorRepository.save(professorSave);
        } else {
            throw new Exception("Professor Não encontrado");
        }
    }

    @DeleteMapping(path ={"/{professor_id}"})
    public ResponseEntity <?> delete(@PathVariable long professor_id) {
       return professorRepository.findById(professor_id)
               .map(record -> {
                   professorRepository.deleteById(professor_id);
                   return ResponseEntity.ok().build();
               }).orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/filter") 
    public List<ProfessorRs> findPersonByMatricula(@RequestParam("matricula") String matricula) {
        return this.professorRepository.findByMatriculaContains(matricula)
                .stream()
                .map(ProfessorRs::converter)
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/filter/custom") 
    public List<ProfessorRs> findPersonByCustom(
            @RequestParam(value = "matricula", required = false) String matricula,
            @RequestParam(value = "nome", required = false) String nome
    ) {
        return this.professorCustomRepository.find(matricula, nome)
                .stream()
                .map(ProfessorRs::converter)
                .collect(Collectors.toList());
    }

}