package domain.report;

import domain.entities.RegistroAtendimento;
import domain.structures.EstruturaVetor;

public interface Relatorio {
    void gerarRelatorio(EstruturaVetor<RegistroAtendimento> vetorGeral, EstruturaVetor<RegistroAtendimento> vetorPreferencial, EstruturaVetor<RegistroAtendimento> vetorSoma);
}
