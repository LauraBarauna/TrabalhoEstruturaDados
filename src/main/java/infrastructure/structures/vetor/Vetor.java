package infrastructure.structures.vetor;

import domain.structures.EstruturaVetor;

public class Vetor<T> implements EstruturaVetor<T> {

    private T[] info;
    private int tamanho;

    public Vetor(int  tamanho) {
        this.tamanho = tamanho;
        this.info = (T[]) new Object[tamanho];
    }

    @Override
    public void inserir(T valor) {
        this.info[this.tamanho] = valor;
        this.tamanho++;
    }

    @Override
    public T obterElemento(int index) {
        return this.info[index];
    }

    @Override
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    @Override
    public int quantidade() {
        return this.tamanho;
    }
}
