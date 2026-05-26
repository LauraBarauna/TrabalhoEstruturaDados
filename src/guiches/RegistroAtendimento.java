package guiches;

import fila.FilaNormal;
import fila.FilaPrioridade;

import java.time.LocalTime;

public class RegistroAtendimento<T> {
    private LocalTime horarioEntrada;
    private LocalTime horarioInicio;
    private int tempoAtendimentoMin;

    // TODO adicionar cliente

    private final FilaNormal<RegistroAtendimento> filaNormal;
    private final FilaPrioridade<RegistroAtendimento> filaPreferencial;

    public RegistroAtendimento() {
        this.filaNormal = new FilaNormal<>();
        this.filaPreferencial = new FilaPrioridade<>();
    }

    public void adicionarCliente() {
        this.horarioEntrada = LocalTime.now();

        // TODO adicionar lógica do cliente (se for maior que 60 anos adicionar na fila preferencial)
        this.filaPreferencial.inserir(this);
        this.filaNormal.inserir(this);
    }
}
