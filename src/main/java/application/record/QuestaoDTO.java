package application.record;

import application.model.Questao;

public record QuestaoDTO(long id, String enunciado) {
    public QuestaoDTO(Questao entidade) {
        this(
            entidade.getId(),
            entidade.getEnunciado()
        );
    }
}
