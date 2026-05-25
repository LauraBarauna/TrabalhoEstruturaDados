package fila;

public class FilaNormal<T> implements Fila<T> {

    private ListaFila<T> fila;

    public FilaNormal() {
        this.fila = new ListaFila<>();
    }

    @Override
    public void inserir(T valor) {
        this.fila.inserir(valor);
    }

    @Override
    public T peek() {
        return this.fila.peek();
    }

    @Override
    public T retirar() {
        return this.fila.retirar();
    }

    @Override
    public void liberar() {
        this.fila.liberar();
    }

    @Override
    public boolean estaVazia() {
        return this.fila.estaVazia();
    }
}
