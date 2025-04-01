package application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.model.Questao;
import application.record.QuestaoDTO;
import application.record.QuestaoInsertDTO;
import application.repository.QuestaoRepository;

@Service
public class QuestaoService {
    @Autowired
    private QuestaoRepository questaoRepo;

    public Iterable<QuestaoDTO> getAll() {
        return this.questaoRepo.findAll().stream().map(QuestaoDTO::new).toList();
    }

    public QuestaoDTO getOne(long id) {
        Optional<Questao> resultado = questaoRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Questão Não Encontrada"
            );
        }

        return new QuestaoDTO(resultado.get());
    }

    public QuestaoDTO insert(QuestaoInsertDTO questao) {
        return new QuestaoDTO(questaoRepo.save(new Questao(questao)));
    }

    public QuestaoDTO update(long id, QuestaoDTO dados) {
        Optional<Questao> resultado = questaoRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Questão Não Encontrada"
            );
        }

        resultado.get().setEnunciado(dados.enunciado());
        return new QuestaoDTO(questaoRepo.save(resultado.get()));
    }

    public void delete(long id) {
        if(!questaoRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Questão Não Encontrada"
            );
        }

        questaoRepo.deleteById(id);
    }
}
