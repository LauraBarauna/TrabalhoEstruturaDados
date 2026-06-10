package domain.structures;

import infrastructure.structures.lista.NoLista;

public interface EstruturaVetor<T> {

    void inserir(T valor);
    T obterElemento(int index);
    boolean estaVazia();
    int quantidade();
    void trocar(int indiceA, int indiceB);

}
