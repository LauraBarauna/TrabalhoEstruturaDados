package guiches;

public class AtendimentoGeral<T> extends Atendimento<T> {

    private boolean atendeuPrioritario;

    public AtendimentoGeral() {
        this.atendeuPrioritario = false;
    }

    @Override
    void chamarProximo() {
        RegistroAtendimento registroAtendimento;

        try {
            registroAtendimento = (RegistroAtendimento) getFilaNormal().retirar();

            if(!getFilaPreferencial().estaVazia() && !this.atendeuPrioritario) {
                this.atendeuPrioritario = true;

                registroAtendimento = (RegistroAtendimento) getFilaPreferencial().retirar();
            }

            calcularTempoEspera(registroAtendimento);

            // TODO adiconar registro de atendimento na pilha
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}
