package infrastructure.structures;

public interface EstruturaDados<T> {
    void inserir(T valor);
    T retirar();
    boolean estaVazia();
    void liberar();
    T peek();
}
