package main.java.domain.entities;


import main.java.domain.guiches.PoliticaGuiches;
import main.java.infrastructure.structures.fila.Fila;
import main.java.infrastructure.structures.fila.FilaDinamica;

public class Guiche {

    Fila filaGeral;
    Fila filaPreferencial;
    PoliticaGuiches politica;

    public Guiche(FilaDinamica<RegistroAtendimento>  filaGeral,  FilaDinamica<RegistroAtendimento> filaPreferencial, PoliticaGuiches politica) {
        this.filaGeral = filaGeral;
        this.filaPreferencial = filaPreferencial;
        this.politica = politica;
    }

    public void chamarProximo() {
        this.politica.chamarProximo(this.filaGeral, this.filaPreferencial);
    }
}
