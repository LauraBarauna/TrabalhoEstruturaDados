package guiches;

public class AtendimentoPreferencial<T> extends Atendimento<T> {
    @Override
    void chamarProximo() {
        RegistroAtendimento registroAtendimento;

        try {
            if (getFilaPreferencial().estaVazia()) {
                registroAtendimento = (RegistroAtendimento) getFilaNormal().retirar();
            } else {
                registroAtendimento = (RegistroAtendimento) getFilaPreferencial().retirar();
            }

            calcularTempoEspera(registroAtendimento);

            // TODO adiconar registro de atendimento na pilha
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
