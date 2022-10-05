package br.com.uniamerica.transportadoraapi.transportadoraapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Modelo")
public class Modelo extends AbstractEntity{

    @Column(name = "nome", length = 50, nullable = false)
    @Getter @Setter
    private String nome;


    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "marca", nullable = false)
    private Marca marca;

}
