package domain.guiches;


import domain.structures.EstruturaDados;

public interface PoliticaGuiches<T> {
    void chamarProximo(EstruturaDados<T> filaGeral, EstruturaDados<T> filaPreferencial, EstruturaDados<T> historico);
}
