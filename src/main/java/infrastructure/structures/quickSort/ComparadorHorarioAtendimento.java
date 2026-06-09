package infrastructure.structures.quickSort;

import domain.entities.RegistroAtendimento;
import domain.structures.Comparador;

public class ComparadorHorarioAtendimento implements Comparador<RegistroAtendimento> {
    @Override
    public int comparar(RegistroAtendimento a, RegistroAtendimento b) {
        return a.getHorarioInicio()
                .compareTo(
                        b.getHorarioInicio()
                );
    }
}
