package domain.guiches;

import domain.entities.RegistroAtendimento;
import infrastructure.structures.fila.Fila;
import infrastructure.structures.fila.FilaDinamica;

public interface PoliticaGuiches {
    void chamarProximo(Fila filaGeral, Fila filaPreferencial);
}
