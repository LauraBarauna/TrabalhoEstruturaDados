package domain.structures;

import infrastructure.structures.lista.NoLista;

public interface EstruturaLista<T> {
    void inserir(T valor);
    T obterElemento(int index);
    boolean estaVazia();
    int quantidade();
    NoLista<T> getPrimeiro();
}
