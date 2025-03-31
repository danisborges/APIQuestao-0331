package application.record;

import application.model.Opcao;

public record OpcaoDTO(long id, String descricao, int correto) {
    public OpcaoDTO(Opcao entidade) {
        this(
            entidade.getId(), 
            entidade.getDescricao(),
            entidade.getCorreto()
            );
    }
}
