package infrastructure.structures.lista;

import domain.structures.EstruturaLista;

public class Lista<T> implements EstruturaLista<T> {

    private NoLista<T> primeiro;
    private int quantidade;

    public Lista() {
        this.quantidade = 0;
    }

    @Override
    public void inserir(T valor) {
        NoLista<T> no = new NoLista<>();
        no.setInfo(valor);
        no.setProximo(this.primeiro);

        this.quantidade++;
        this.primeiro = no;
    }

    @Override
    public T obterElemento(int index) {
        return null;
    }

    @Override
    public boolean estaVazia() {
        return this.primeiro == null;
    }

    @Override
    public int quantidade() {
        return this.quantidade;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }
}
