package application.controller;

import application.model.Opcao;
import application.repository.OpcaoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/opcoes")
public class OpcaoController {
    private final OpcaoRepository repository;

    public OpcaoController(OpcaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Opcao> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Opcao criar(@RequestBody Opcao opcao) {
        return repository.save(opcao);
    }
}