package domain.entities;


import domain.guiches.PoliticaGuiches;
import infrastructure.structures.fila.FilaDinamica;

public class Guiche {

    FilaDinamica<RegistroAtendimento> filaGeral;
    FilaDinamica<RegistroAtendimento> filaPreferencial;
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
