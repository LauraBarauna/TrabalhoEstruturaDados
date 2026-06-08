package main.java.domain.guiches;

import main.java.domain.entities.RegistroAtendimento;

import java.time.Duration;

public abstract class CalculadoraTempoEspera {

    public long calcularTempoEspera(RegistroAtendimento registroAtendimento) {
        return Duration.between(registroAtendimento.getHorarioEntrada(), registroAtendimento.getHorarioInicio())
                .toMinutes();
    }

}
