package guiches;

import fila.FilaNormal;
import fila.FilaPrioridade;

import java.time.LocalTime;

public class RegistroAtendimento {
    private LocalTime horarioEntrada;
    private LocalTime horarioInicio;
    private long tempoAtendimentoMin;

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

    public LocalTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public long getTempoAtendimentoMin() {
        return tempoAtendimentoMin;
    }

    public void setHorarioEntrada(LocalTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public void setTempoAtendimentoMin(long tempoAtendimentoMin) {
        this.tempoAtendimentoMin = tempoAtendimentoMin;
    }
}
