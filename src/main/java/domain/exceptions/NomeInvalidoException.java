package domain.exceptions;

public class NomeInvalidoException extends RuntimeException {

    public NomeInvalidoException() {
        super("O nome não pode estar vazio.");
    }

    public NomeInvalidoException(String mensagem) {
        super(mensagem);
    }
}