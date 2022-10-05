package br.com.uniamerica.transportadoraapi.transportadoraapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Produto")
public class Produto extends AbstractEntity {

    @Column(name = "nome", length = 50, nullable = false)
    @Getter @Setter
    private String nome;

}
