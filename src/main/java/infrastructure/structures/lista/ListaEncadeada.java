package infrastructure.structures.lista;

import domain.structures.EstruturaDados;

public abstract class ListaEncadeada<T> implements EstruturaDados<T> {
    private NoLista<T> primeiro;
    private NoLista<T> ultimo;
    private int quantidade;

    public ListaEncadeada() {
        this.quantidade = 0;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public NoLista<T> getUltimo() {
        return ultimo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setPrimeiro(NoLista<T> primeiro) {
        this.primeiro = primeiro;
    }

    public void setUltimo(NoLista<T> ultimo) {
        this.ultimo = ultimo;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
