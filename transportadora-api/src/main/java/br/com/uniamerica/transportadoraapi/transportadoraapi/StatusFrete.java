package br.com.uniamerica.transportadoraapi.transportadoraapi;

public enum StatusFrete {
    CARGA,
    EM_TRANSPORTE,
    INTERROMPIDO,
    DESCARGA,
    FATURADO,
    CANCELADO;
    private String StatusFrete;

    public String getStatusFrete() {
        return StatusFrete;
    }

    public void setStatusFrete(String statusFrete) {
        StatusFrete = statusFrete;
    }
}
