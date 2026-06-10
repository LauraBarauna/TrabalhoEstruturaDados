package domain.structures;

public interface EstruturaDados<T> {
    void inserir(T valor);
    T retirar();
    boolean estaVazia();
    void liberar();
    T peek();
    int quantidade();
    EstruturaDados<T> clonar();
}
