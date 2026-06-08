package domain.guiches;


import infrastructure.structures.EstruturaDados;

public interface PoliticaGuiches<T> {
    void chamarProximo(EstruturaDados<T> filaGeral, EstruturaDados<T> filaPreferencial);
}
