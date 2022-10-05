package br.com.uniamerica.transportadoraapi.transportadoraapi;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Estado")

public class Estado extends AbstractEntity{
    @Column(name = "Nome", length = 50, nullable = false)
    @Getter @Setter
    private String nome;


}
