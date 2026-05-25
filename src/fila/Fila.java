package fila;

public interface Fila<T> {
    void inserir(T valor);
    T peek();
    T retirar();
    void liberar();
    boolean estaVazia();
}
