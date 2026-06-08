package domain.guiches;

import infrastructure.structures.fila.Fila;

public interface PoliticaGuiches {
    void chamarProximo(Fila filaGeral, Fila filaPreferencial);
}
