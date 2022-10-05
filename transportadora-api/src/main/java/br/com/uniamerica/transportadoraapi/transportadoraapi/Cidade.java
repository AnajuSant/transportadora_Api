package br.com.uniamerica.transportadoraapi.transportadoraapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cidade", uniqueConstraints = {
        @UniqueConstraint(
                columnNames = {"nome" , "estado"}
        )
})

public class Cidade extends AbstractEntity{
    @Column(name= "nome", length = 50, nullable = false)
    @Getter @Setter
    private String nome;

    @JoinColumn(name = "id_estado", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Getter @Setter
    private Estado estado;


}
