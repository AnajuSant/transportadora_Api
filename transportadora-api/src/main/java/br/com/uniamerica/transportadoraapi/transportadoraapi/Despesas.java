package br.com.uniamerica.transportadoraapi.transportadoraapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity //A anotação @Entity é utilizada para informar que uma classe também é uma entidade.
@AllArgsConstructor //Gerar contrutor com 1 parametro para cada atributo
@NoArgsConstructor// Gerar contrutor sem parametros
@Table(name = "despesas", uniqueConstraints = {
        @UniqueConstraint(
                columnNames = {"usuario"}
        )
})

public class Despesas extends AbstractEntity {
    @Column (name = "Valor", scale = 3, precision = 6)// Escala sempre menor que precisão
    @Getter @Setter
    private BigDecimal valor;
    @Column(name = "data", length = 50, nullable = false)
    @Getter @Setter
    private LocalDateTime data;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "aprovador", nullable = false)
    private Usuario aprovador;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "frete", nullable = false)
    private Frete frete;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tipDespesa", nullable = false)
    private TipoDespesa tipoDespesa;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Motorista", nullable = false)
    private Usuario MOTORISTA;


     @PrePersist
    public void dataData(){
         this.setData(LocalDateTime.now());
     }

}
