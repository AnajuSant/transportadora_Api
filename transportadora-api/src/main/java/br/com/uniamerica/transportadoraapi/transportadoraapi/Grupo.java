package br.com.uniamerica.transportadoraapi.transportadoraapi;

public enum Grupo {
    MOTORISTA,
    ADMINISTRADOR;
    private String Grupo;

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String grupo) {
        this.Grupo = grupo;
    }
}
