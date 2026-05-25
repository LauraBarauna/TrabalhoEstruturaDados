package fila;

import listaEncadeada.ListaEncadeada;
import listaEncadeada.NoLista;

public class ListaFila<T> extends ListaEncadeada<T> {
    @Override
    public void inserir(T info) {
        NoLista<T> novoNo = new NoLista<>();
        novoNo.setInfo(info);

        if (getPrimeiro() == null) {
            setPrimeiro(novoNo);
        }

        if (getUltimo() != null) {
            getUltimo().setProximo(novoNo);
        }

        setUltimo(novoNo);
    }

    @Override
    public T retirar() {
        NoLista<T> temp = peek();
        setPrimeiro(temp.getProximo());
        return temp.getInfo();
    }

    @Override
    public boolean estaVazia() {
        return getPrimeiro() == null;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            // CRIAR EXCEPTION
            throw new RuntimeException("Lista vazia");
        }

        return getPrimeiro().getInfo();
    }

    @Override
    public void liberar() {
        while (!estaVazia()) {
            retirar();
        }
    }


}
