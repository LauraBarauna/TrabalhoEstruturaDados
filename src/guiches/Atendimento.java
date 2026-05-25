package guiches;

import fila.FilaNormal;
import fila.FilaPrioridade;

public abstract class Atendimento<T> {
    private FilaNormal<T> filaNormal;
    private FilaPrioridade<T> filaPreferencial;

    Atendimento() {
        this.filaNormal = new FilaNormal<>();
        this.filaPreferencial = new FilaPrioridade<>();
    }

    abstract T chamarProximo();

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
