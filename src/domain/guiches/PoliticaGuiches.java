package domain.guiches;

import domain.entities.RegistroAtendimento;
import infrastructure.structures.fila.FilaDinamica;

public interface PoliticaGuiches {
    void chamarProximo(FilaDinamica<RegistroAtendimento> filaGeral, FilaDinamica<RegistroAtendimento> filaPreferencial);
}
