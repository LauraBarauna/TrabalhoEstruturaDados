package domain.entities;



import infrastructure.structures.fila.FilaDinamica;

import java.time.LocalTime;

public class RegistroAtendimento {

    private Pessoa pessoa;
    private LocalTime horarioEntrada;
    private LocalTime horarioInicio;
    private long tempoAtendimentoMin;

    FilaDinamica<RegistroAtendimento> filaGeral;
    FilaDinamica<RegistroAtendimento> filaPreferencial;

    public RegistroAtendimento(Pessoa pessoa,FilaDinamica<RegistroAtendimento> filaGeral, FilaDinamica<RegistroAtendimento> filaPreferencial) {
        this.pessoa = pessoa;
        this.filaGeral = filaGeral;
        this.filaPreferencial = filaPreferencial;
    }

    public void adicionarCliente() {
        this.horarioEntrada = LocalTime.now();

        if (pessoa.isPrioritario()) {
            filaPreferencial.inserir(this);
        } else {
            filaGeral.inserir(this);
        }
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

    public Pessoa getPessoa() { return pessoa; }

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
