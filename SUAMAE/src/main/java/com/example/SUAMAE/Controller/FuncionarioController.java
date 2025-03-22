package com.example.SUAMAE.Controller;

import com.example.SUAMAE.model.Funcionario;
import com.example.SUAMAE.repository.FuncionaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/Funcionario")
public class FuncionarioController {

    private FuncionaRepository funcionaRepository;

    public FuncionarioController(FuncionaRepository funcionaRepository) {
        this.funcionaRepository = funcionaRepository;
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        funcionaRepository.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body((funcionario));
    }

    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionaRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        funcionaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Funcionario> atualizar(@RequestBody Funcionario funcionario) {
        if (funcionario.getId() != null && funcionaRepository.existsById(funcionario.getId())) {
            funcionaRepository.save(funcionario);
        }
        return ResponseEntity.ok().body((funcionario));
    }
}