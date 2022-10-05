package br.com.uniamerica.transportadoraapi.transportadoraapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Caminhao", uniqueConstraints = {
        @UniqueConstraint(
                columnNames = {"placa"}
        )
})
public class Caminhao extends AbstractEntity{

    @Column (name = "placa", length = 50, nullable = false)
    @Getter @Setter
    private String placa;
    @Column (name = "ano", nullable = false)
    @Getter @Setter
    private int ano;
    @Column (name = "Cor", length = 50, nullable = false)
    @Getter @Setter
    private Cor cor;

    @Column (name = "observacao", length = 300, nullable = false)
    @Getter @Setter
    private String observacao;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "modelo", nullable = false)
    private Modelo modelo;

    @Getter @Setter
    @ManyToOne (fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Motorista", nullable = false)
    private Usuario Motorista;
}
