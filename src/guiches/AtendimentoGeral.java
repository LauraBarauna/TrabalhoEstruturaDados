package guiches;

public class AtendimentoGeral<T> extends Atendimento<T> {

    private boolean atendeuPrioritario;

    public AtendimentoGeral() {
        this.atendeuPrioritario = false;
    }

    @Override
    T chamarProximo() {
        T clienteAtendido;

        if(!getFilaPreferencial().estaVazia() && !this.atendeuPrioritario) {
            this.atendeuPrioritario = true;
            // TODO inserção na pilha

            clienteAtendido = getFilaPreferencial().retirar();
            return clienteAtendido;

        }


        clienteAtendido = getFilaPreferencial().retirar();
        // TODO inserção na pilha

        return clienteAtendido;
    }
}
