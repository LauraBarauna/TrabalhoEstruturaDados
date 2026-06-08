package domain.guiches;



import domain.entities.RegistroAtendimento;
import domain.structures.EstruturaDados;

import java.time.LocalTime;

public class GuicheGeral extends CalculadoraTempoEspera implements PoliticaGuiches<RegistroAtendimento> {

    private boolean atendeuPrioritario;

    public GuicheGeral() {
        this.atendeuPrioritario = false;
    }

    @Override
    public void chamarProximo(EstruturaDados<RegistroAtendimento> filaGeral, EstruturaDados<RegistroAtendimento> filaPreferencial) {
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
