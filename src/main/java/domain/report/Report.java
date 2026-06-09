package domain.report;

import domain.entities.RegistroAtendimento;
import domain.structures.EstruturaDados;
import domain.structures.EstruturaVetor;

public interface Report {
    void gerarRelatorio(EstruturaVetor<RegistroAtendimento> pilhaGeral, EstruturaVetor<RegistroAtendimento> pilhaPreferencial);
}
