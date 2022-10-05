package br.com.uniamerica.transportadoraapi.transportadoraapi;

import lombok.Getter;
import lombok.Setter;

public enum Cor {
    BRANCO,
    PRETO,
    CINZA,
    VERMELHO,
    AZUL,
    AMARELO;

    @Getter @Setter
    private String cor;


}
