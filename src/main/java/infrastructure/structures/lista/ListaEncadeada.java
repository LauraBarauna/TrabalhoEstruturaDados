package main.java.infrastructure.structures.lista;

public abstract class ListaEncadeada<T> {
    private NoLista<T> primeiro;
    private NoLista<T> ultimo;

    public abstract void inserir(T valor);
    public abstract T retirar();
    public abstract void liberar();
    public abstract boolean estaVazia();
    public abstract T peek();

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public NoLista<T> getUltimo() {
        return ultimo;
    }

    public void setPrimeiro(NoLista<T> primeiro) {
        this.primeiro = primeiro;
    }

    public void setUltimo(NoLista<T> ultimo) {
        this.ultimo = ultimo;
    }
}
