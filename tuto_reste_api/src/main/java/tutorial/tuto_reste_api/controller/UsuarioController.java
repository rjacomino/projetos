package tutorial.tuto_reste_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tutorial.tuto_reste_api.model.UsuarioModel;
import tutorial.tuto_reste_api.repository.UsuarioRepository;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping(path = "/api/usuario/{codigo}")
    public ResponseEntity<UsuarioModel> consultar(@PathVariable("codigo") Integer codigo){
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping (path = "/api/usuario/salvar")
    public UsuarioModel salvar(@RequestBody UsuarioModel usuario){
        return repository.save(usuario);
    }

    @DeleteMapping(path = "/api/usuario/deletar/{codigo}")
    public ResponseEntity<?> deletar(@PathVariable("codigo") Integer codigo){
        return repository.findById(codigo)
                .map(record -> {
                    repository.deleteById(codigo);
                    return ResponseEntity.ok().build();
                }).orElse( ResponseEntity.notFound().build());
    }

}

