package domain.exceptions;


public class VetorCheioException extends RuntimeException {

    public VetorCheioException() {
        super("O vetor está cheio.");
    }
}
