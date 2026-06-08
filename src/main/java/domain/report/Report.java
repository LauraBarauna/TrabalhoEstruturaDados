package domain.report;

import domain.entities.RegistroAtendimento;
import domain.structures.EstruturaDados;

public interface Report {
    void gerarRelatorio(EstruturaDados<RegistroAtendimento> pilhaGeral, EstruturaDados<RegistroAtendimento> pilhaPreferencial);
}
