package application.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import application.record.QuestaoDTO;
import application.record.QuestaoInsertDTO;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "questoes")
@Getter
@Setter
@NoArgsConstructor
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String enunciado;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    public Questao(QuestaoDTO record) {
        this.id = record.id();
        this.enunciado = record.enunciado();
        this.categoria = new Categoria(record.categoria());
    }

    public Questao(QuestaoInsertDTO record) {
        this.enunciado = record.enunciado();
        Categoria cat = new Categoria();
        cat.setId(record.id_categoria());
        this.categoria = cat;
    }
}
