package guiches;

import java.time.Duration;
import java.time.LocalTime;

public class AtendimentoGeral<T> extends Atendimento<T> {

    private boolean atendeuPrioritario;

    public AtendimentoGeral() {
        this.atendeuPrioritario = false;
    }

    @Override
    void chamarProximo() {
        RegistroAtendimento registroAtendimento;

        registroAtendimento = (RegistroAtendimento) getFilaNormal().retirar();

        if(!getFilaPreferencial().estaVazia() && !this.atendeuPrioritario) {
            this.atendeuPrioritario = true;

            registroAtendimento = (RegistroAtendimento) getFilaPreferencial().retirar();
        }

        registroAtendimento.setHorarioInicio(LocalTime.now());

        long minutosDiferenca = Duration.between(registroAtendimento.getHorarioEntrada(), registroAtendimento.getHorarioInicio())
                        .toMinutes();

        registroAtendimento.setTempoAtendimentoMin(minutosDiferenca);


        // TODO inserção na pilha
    }
}
