package domain.entities;


import domain.guiches.PoliticaGuiches;
import infrastructure.structures.EstruturaDados;

public class Guiche {

    EstruturaDados<RegistroAtendimento> filaGeral;
    EstruturaDados<RegistroAtendimento> filaPreferencial;
    PoliticaGuiches<RegistroAtendimento> politica;

    public Guiche(EstruturaDados<RegistroAtendimento> filaGeral, EstruturaDados<RegistroAtendimento> filaPreferencial, PoliticaGuiches<RegistroAtendimento> politica) {
        this.filaGeral = filaGeral;
        this.filaPreferencial = filaPreferencial;
        this.politica = politica;
    }

    public void chamarProximo() {
        this.politica.chamarProximo(this.filaGeral, this.filaPreferencial);
    }
}
