package main.java.domain.guiches;

import main.java.domain.entities.RegistroAtendimento;
import main.java.infrastructure.structures.fila.FilaDinamica;

import java.time.LocalTime;

public class GuicheGeral extends CalculadoraTempoEspera implements PoliticaGuiches {

    private boolean atendeuPrioritario;

    public GuicheGeral() {
        this.atendeuPrioritario = false;
    }


    @Override
    public void chamarProximo(FilaDinamica<RegistroAtendimento> filaGeral, FilaDinamica<RegistroAtendimento> filaPreferencial) {
        RegistroAtendimento registroAtendimento;

        registroAtendimento = filaGeral.retirar();

        if(!filaPreferencial.estaVazia() && !this.atendeuPrioritario) {
            this.atendeuPrioritario = true;

            registroAtendimento = filaPreferencial.retirar();
        }

        registroAtendimento.setHorarioInicio(LocalTime.now());
        long tempoEsperaMin = calcularTempoEspera(registroAtendimento);

        registroAtendimento.setTempoAtendimentoMin(tempoEsperaMin);

        // TODO adiconar registro de atendimento na pilha

    }
}
