package application.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import application.record.CategoriaDTO;
import application.repository.CategoriaRepository;
import application.model.Categoria;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepo;

    public Iterable<CategoriaDTO> getAll() {
        return this.categoriaRepo.findAll().stream().map(CategoriaDTO::new).toList();
    }

    public CategoriaDTO getOne(long id) {
        Optional<Categoria> resultado = categoriaRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Categoria Não Encontrada"
            );
        }

        return new CategoriaDTO(resultado.get());
    }

    public CategoriaDTO insert(CategoriaDTO categoria) {
        return new CategoriaDTO(categoriaRepo.save(new Categoria(categoria)));
    }

    public CategoriaDTO update(long id, CategoriaDTO dados) {
        Optional<Categoria> resultado = categoriaRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Categoria Não Encontrada"
            );
        }

        resultado.get().setNome(dados.nome());
        return new CategoriaDTO(categoriaRepo.save(resultado.get()));
    }

    public void delete(long id) {
        if(!categoriaRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Categoria Não Encontrada"
            );
        }

        categoriaRepo.deleteById(id);
    }
}