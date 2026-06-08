package domain.structures;

public interface EstruturaVetor<T> {

    void inserir(T valor);
    T obterElemento(int index);
    boolean estaVazia();
    int quantidade();

}
