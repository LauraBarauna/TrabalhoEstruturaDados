package infrastructure.structures.fila;


import infrastructure.structures.lista.ListaEncadeada;
import infrastructure.structures.lista.NoLista;

public class FilaDinamica<T> extends ListaEncadeada<T> {
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

        setQuantidade(getQuantidade() + 1);
        setUltimo(novoNo);
    }

    @Override
    public T retirar() {
        T info = peek();
        setPrimeiro(getPrimeiro().getProximo());
        setQuantidade(getQuantidade() - 1);
        return info;
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
    public int quantidade() {
        return getQuantidade();
    }

    @Override
    public void liberar() {
        while (!estaVazia()) {
            retirar();
        }
    }
}
