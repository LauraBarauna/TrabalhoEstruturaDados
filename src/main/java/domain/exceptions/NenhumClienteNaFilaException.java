package domain.exceptions;

public class NenhumClienteNaFilaException extends RuntimeException {

    public NenhumClienteNaFilaException() {
        super("Não há clientes aguardando atendimento.");
    }

    public NenhumClienteNaFilaException(String mensagem) {
        super(mensagem);
    }
}