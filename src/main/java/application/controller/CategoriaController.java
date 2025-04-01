package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.record.CategoriaDTO;
import application.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public Iterable<CategoriaDTO> list() {
        return categoriaService.getAll();
    }

    @GetMapping("/{id}")
    public CategoriaDTO findOne(@PathVariable long id) {
        return categoriaService.getOne(id);
    } 

    @PostMapping
    public CategoriaDTO insert(@RequestBody CategoriaDTO categoria) {
        return categoriaService.insert(categoria);
    }

    @PutMapping("/{id}")
    public CategoriaDTO update(@PathVariable long id, @RequestBody CategoriaDTO categoria) {
        return categoriaService.update(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        categoriaService.delete(id);
    }

}