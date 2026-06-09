package infrastructure.structures.pilha;

import infrastructure.structures.lista.ListaEncadeada;
import infrastructure.structures.lista.NoLista;

public class PilhaDinamica<T> extends ListaEncadeada<T> {

    @Override
    public void inserir(T info) {

        NoLista<T> novo = new NoLista<>();
        novo.setInfo(info);
        novo.setProximo(getPrimeiro());

        setPrimeiro(novo);

        if (getUltimo() == null) {
            setUltimo(novo);
        }
    }

    @Override
    public T retirar() {

        if (estaVazia()) {
            throw new RuntimeException("A Pilha está vazia");
        }
        T info = getPrimeiro().getInfo();

        setPrimeiro(getPrimeiro().getProximo());

        if (getPrimeiro() == null) {
            setUltimo(null);
        }
        return info;
    }

    @Override
    public T peek() {

        if (estaVazia()) {
            throw new RuntimeException("A Pilha está vazia");
        }
        return getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return getPrimeiro() == null;
    }

    @Override
    public void liberar() {

        while (!estaVazia()) {
            retirar();
        }
    }
}