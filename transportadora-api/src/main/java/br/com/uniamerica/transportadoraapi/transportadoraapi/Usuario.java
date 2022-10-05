package br.com.uniamerica.transportadoraapi.transportadoraapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Usuario")
public class Usuario extends AbstractEntity{
    @Column(name = "PorGanho", scale = 3, precision = 6)
    @Getter @Setter
    private BigDecimal porGanho;
   @Column(name = "Login", length = 50, nullable = false)
    @Getter @Setter
    private String login;
    @Column(name = "Senha", length = 10, nullable = false)
    @Getter @Setter
    private String senha;

  @Column(name = "Nome", length = 50, nullable = false)
    @Getter @Setter
    private String nome;
    @Column(name = "CPF", length = 9, nullable = false)
    @Getter @Setter
    private String cpf;
    @Column(name = "Telefone", length = 10, nullable = false)
    @Getter @Setter
    private String telefone;

    @Column(name = "Data_Nascimento", length = 30, nullable = false)
    @Getter @Setter
    private LocalDateTime dataNascimento;
    @Column(name = "Endereco", length = 50, nullable = false)
    @Getter @Setter
    private String enderenco;

    @Column(name = "observacao", length = 50)
    @Getter @Setter
    private String observacao;

    @Getter @Setter
    private Grupo grupo;

   @PrePersist
    public void dataDataNascimento(){
       this.setDataNascimento(LocalDateTime.now());
   }

}
