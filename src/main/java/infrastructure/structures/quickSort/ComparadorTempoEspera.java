package infrastructure.structures.quickSort;

import domain.entities.RegistroAtendimento;
import domain.structures.Comparador;

public class ComparadorTempoEspera implements Comparador<RegistroAtendimento> {
    @Override
    public int comparar(RegistroAtendimento a, RegistroAtendimento b) {
        return Long.compare(a.getTempoEsperaAtendimento(), b.getTempoEsperaAtendimento());
    }
}
