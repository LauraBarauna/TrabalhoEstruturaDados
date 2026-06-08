package main.java.domain.guiches;

import main.java.infrastructure.structures.fila.Fila;

public interface PoliticaGuiches {
    void chamarProximo(Fila filaGeral, Fila filaPreferencial);
}
