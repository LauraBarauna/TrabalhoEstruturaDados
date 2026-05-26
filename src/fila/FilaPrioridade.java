package fila;

public class FilaPrioridade<T> implements Fila<T> {
    private ListaFila<T> lista;

    public FilaPrioridade() {
        this.lista = new ListaFila<>();
    }

    @Override
    public void inserir(T valor) {
        this.lista.inserir(valor);
    }

    @Override
    public T peek() {
        return this.lista.peek();
    }

    @Override
    public T retirar() {
        return this.lista.retirar();
    }

    @Override
    public void liberar() {
        this.lista.liberar();
    }

    @Override
    public boolean estaVazia() {
        return this.lista.estaVazia();
    }
}
