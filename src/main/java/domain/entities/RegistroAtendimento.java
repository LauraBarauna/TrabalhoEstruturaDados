package domain.entities;



import infrastructure.structures.fila.FilaDinamica;

import java.time.LocalTime;

public class RegistroAtendimento {
    private LocalTime horarioEntrada;
    private LocalTime horarioInicio;
    private long tempoEsperaAtendimento;
    private Pessoa cliente;

    public RegistroAtendimento(Pessoa cliente) {
        this.cliente = cliente;
    }

    public LocalTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public long getTempoEsperaAtendimento() {
        return tempoEsperaAtendimento;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setHorarioEntrada(LocalTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public void setTempoEsperaAtendimento(long tempoEsperaAtendimento) {
        this.tempoEsperaAtendimento = tempoEsperaAtendimento;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }
}
