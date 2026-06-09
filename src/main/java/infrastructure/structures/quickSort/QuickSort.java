package infrastructure.structures.quickSort;

import domain.structures.Comparador;
import domain.structures.EstruturaVetor;

public class QuickSort<T> {
    public void ordenar(EstruturaVetor<T> vetor, Comparador<T> comparador) {

    }

    private void quickSort(
            EstruturaVetor<T> vetor,
            int inicio,
            int fim,
            Comparador<T> comparador) {

        if (inicio < fim) {

            int indicePivo = particionar(
                    vetor,
                    inicio,
                    fim,
                    comparador
            );

            quickSort(
                    vetor,
                    inicio,
                    indicePivo - 1,
                    comparador
            );

            quickSort(
                    vetor,
                    indicePivo + 1,
                    fim,
                    comparador
            );
        }
    }

    private int particionar(
            EstruturaVetor<T> vetor,
            int inicio,
            int fim,
            Comparador<T> comparador) {

        T pivo = vetor.obterElemento(fim);

        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {

            if (comparador.comparar(
                    vetor.obterElemento(j),
                    pivo) <= 0) {

                i++;

                vetor.trocar(i, j);
            }
        }

        vetor.trocar(i + 1, fim);

        return i + 1;
    }
}
