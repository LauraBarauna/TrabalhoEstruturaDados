package guiches;

import fila.FilaNormal;
import fila.FilaPrioridade;

import java.time.Duration;
import java.time.LocalTime;

public abstract class Atendimento<T> {
    private FilaNormal<T> filaNormal;
    private FilaPrioridade<T> filaPreferencial;

    Atendimento() {
        this.filaNormal = new FilaNormal<>();
        this.filaPreferencial = new FilaPrioridade<>();
    }

    abstract void chamarProximo();

    public void calcularTempoEspera(RegistroAtendimento registro) {
        registro.setHorarioInicio(LocalTime.now());

        long minutosDiferenca = Duration.between(registro.getHorarioEntrada(), registro.getHorarioInicio())
                .toMinutes();

        registro.setTempoAtendimentoMin(minutosDiferenca);
    }

    public FilaNormal<T> getFilaNormal() {
        return filaNormal;
    }

    public FilaPrioridade<T> getFilaPreferencial() {
        return filaPreferencial;
    }

    public void setFilaNormal(FilaNormal<T> filaNormal) {
        this.filaNormal = filaNormal;
    }

    public void setFilaPreferencial(FilaPrioridade<T> filaPreferencial) {
        this.filaPreferencial = filaPreferencial;
    }
}
