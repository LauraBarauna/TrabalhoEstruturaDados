package main.java.domain.guiches;

import main.java.domain.entities.RegistroAtendimento;
import main.java.infrastructure.structures.fila.FilaDinamica;

import java.time.LocalTime;

public class GuichePreferencial extends CalculadoraTempoEspera implements PoliticaGuiches {
    @Override
    public void chamarProximo(FilaDinamica<RegistroAtendimento> filaGeral, FilaDinamica<RegistroAtendimento> filaPreferencial) {
        RegistroAtendimento registroAtendimento;

        registroAtendimento = filaPreferencial.retirar();

        if (filaPreferencial.estaVazia()) {
            registroAtendimento = filaGeral.retirar();
        }

        registroAtendimento.setHorarioInicio(LocalTime.now());
        long tempoEsperaMin = calcularTempoEspera(registroAtendimento);

        registroAtendimento.setTempoAtendimentoMin(tempoEsperaMin);

        // TODO adiconar registro de atendimento na pilha
    }
}
