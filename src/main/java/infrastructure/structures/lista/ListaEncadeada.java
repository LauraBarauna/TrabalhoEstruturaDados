package infrastructure.structures.lista;

import domain.structures.EstruturaDados;

public abstract class ListaEncadeada<T> implements EstruturaDados<T> {
    private NoLista<T> primeiro;
    private NoLista<T> ultimo;

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
