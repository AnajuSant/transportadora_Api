package br.com.uniamerica.transportadoraapi.transportadoraapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Frete extends AbstractEntity{

    @Column (name = "quilometragem_Inicial", nullable = false)
    @Getter @Setter
    private int quilometragemIni;
    @Column (name = "quilometragem_Final", nullable = false)
    @Getter @Setter
    private int quilpmetragemFim;
    @Column(name = "BrutoNota", scale = 3, precision = 6)
    @Getter @Setter
    private BigDecimal totalBrutoRecebidoNota;
    @Column(name = "LiquidoNota", scale = 3, precision = 6)
    @Getter @Setter
    private BigDecimal totalLiquidoRecebido;
    @Column(name = "Peso_Incial", scale = 3, precision = 6)
    @Getter @Setter
    private BigDecimal pesoInicial;
    @Column(name = "Peso_Final", scale = 3, precision = 6)
    @Getter @Setter
    private BigDecimal pesoFinal;
    @Column(name = "Peso_IncialTransportado", scale = 3, precision = 6)
    @Getter @Setter
    private BigDecimal pesoFinalTransportado;
    @Column(name = "Peso_Tonelada", scale = 3, precision = 6)
    @Getter @Setter
    private BigDecimal precoTonelada;

    @Column(name = "obeservacao", length = 50)
    @Getter @Setter
    private String observacao;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Produto", nullable = false)
    private Produto produto;



    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Cidade", nullable = false)
    private Cidade cidadeOrigem;



    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cidadeDestino", nullable = false)
    private Cidade cidadeDestino;


    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Motorista", nullable = false)
    private Usuario motorista;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "caminhao", nullable = false)
    private Caminhao caminhao;


    @Getter @Setter
    private StatusFrete statusFrete;

}
