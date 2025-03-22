package com.example.SUAMAE.Controller;

import com.example.SUAMAE.model.Usuario;
import com.example.SUAMAE.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository){
    this.usuarioRepository = usuarioRepository;
}

    @PostMapping
    public ResponseEntity <Usuario> salvar(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body((usuario));
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
        if (usuario.getId() != null && usuarioRepository.existsById(usuario.getId())){
            usuarioRepository.save(usuario);
        }
        return ResponseEntity.ok().body((usuario));
    }
}
