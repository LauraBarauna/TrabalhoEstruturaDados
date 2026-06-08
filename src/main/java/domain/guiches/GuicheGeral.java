package domain.guiches;



import domain.entities.RegistroAtendimento;
import infrastructure.structures.fila.Fila;
import infrastructure.structures.fila.FilaDinamica;

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
