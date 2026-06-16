package infrastructure.structures.pilha;

import domain.exceptions.PilhaVaziaException;
import domain.structures.EstruturaDados;
import infrastructure.structures.fila.FilaDinamica;
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
        setQuantidade(getQuantidade() + 1);
    }

    @Override
    public T retirar() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        T info = getPrimeiro().getInfo();

        setPrimeiro(getPrimeiro().getProximo());

        if (getPrimeiro() == null) {
            setUltimo(null);
        }

        setQuantidade(getQuantidade() - 1);
        return info;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        return getPrimeiro().getInfo();
    }

    @Override
    public int quantidade() {
        return getQuantidade();
    }

    @Override
    public PilhaDinamica<T> clonar() {
        PilhaDinamica<T> copia = new PilhaDinamica<>();
        NoLista<T> atual = getPrimeiro();

        while (atual != null) {
            copia.inserir(atual.getInfo());
            atual = atual.getProximo();
        }

        return copia;
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