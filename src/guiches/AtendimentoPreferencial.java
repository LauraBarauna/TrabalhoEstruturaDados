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
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
