package domain.entities;

import domain.guiches.PoliticaGuiches;
import domain.structures.EstruturaDados;

public class Guiche {
    EstruturaDados<RegistroAtendimento> filaGeral;
    EstruturaDados<RegistroAtendimento> filaPreferencial;
    PoliticaGuiches<RegistroAtendimento> politica;
    EstruturaDados<RegistroAtendimento> historico;

    public Guiche(EstruturaDados<RegistroAtendimento> filaGeral, EstruturaDados<RegistroAtendimento> filaPreferencial, EstruturaDados<RegistroAtendimento> historico, PoliticaGuiches<RegistroAtendimento> politica) {
        this.filaGeral = filaGeral;
        this.filaPreferencial = filaPreferencial;
        this.historico = historico;
        this.politica = politica;
    }

    public void chamarProximo() {
        this.politica.chamarProximo(this.filaGeral, this.filaPreferencial, this.historico);
    }

    public EstruturaDados<RegistroAtendimento> getHistorico() {
        return historico;
    }

    public EstruturaDados<RegistroAtendimento> getFilaGeral() {
        return filaGeral;
    }

    public EstruturaDados<RegistroAtendimento> getFilaPreferencial() {
        return filaPreferencial;
    }
}
