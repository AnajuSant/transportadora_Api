package br.com.uniamerica.transportadoraapi.transportadoraapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor

public abstract class AbstractEntity {
    @Id
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private LocalDateTime cadastro;
    @Getter @Setter
    private LocalDateTime atualizado;
    @Getter @Setter
    private boolean ativo;

    @PrePersist
    public void dataCadastro(){
        this.setCadastro(LocalDateTime.now());
    }

    @PreUpdate
    public void dataAtualizado(){
        this.setAtualizado(LocalDateTime.now());
    }
}
