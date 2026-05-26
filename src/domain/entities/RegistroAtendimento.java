package domain.entities;

import infrastructure.structures.fila.FilaDinamica;

import java.time.LocalTime;

public class RegistroAtendimento {
    private LocalTime horarioEntrada;
    private LocalTime horarioInicio;
    private long tempoAtendimentoMin;

    // TODO adicionar cliente

    FilaDinamica<RegistroAtendimento> filaGeral;
    FilaDinamica<RegistroAtendimento> filaPreferencial;

    public RegistroAtendimento(FilaDinamica<RegistroAtendimento> filaGeral, FilaDinamica<RegistroAtendimento> filaPreferencial) {
        this.filaGeral = filaGeral;
        this.filaPreferencial = filaPreferencial;
    }

    public void adicionarCliente() {
        this.horarioEntrada = LocalTime.now();

        // TODO adicionar lógica do cliente (se for maior que 60 anos adicionar na fila preferencial)
        this.filaPreferencial.inserir(this);
        this.filaGeral.inserir(this);
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
