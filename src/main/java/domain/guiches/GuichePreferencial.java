package domain.guiches;

import domain.entities.RegistroAtendimento;
import domain.structures.EstruturaDados;

import java.time.LocalTime;

public class GuichePreferencial extends CalculadoraTempoEspera implements PoliticaGuiches<RegistroAtendimento> {
    @Override
    public void chamarProximo(EstruturaDados<RegistroAtendimento> filaGeral, EstruturaDados<RegistroAtendimento> filaPreferencial, EstruturaDados<RegistroAtendimento> historico) {
        RegistroAtendimento registroAtendimento;

        registroAtendimento = filaPreferencial.retirar();

        if (filaPreferencial.estaVazia()) {
            registroAtendimento = filaGeral.retirar();
        }

        registroAtendimento.setHorarioInicio(LocalTime.now());
        long tempoEsperaMin = calcularTempoEspera(registroAtendimento);

        registroAtendimento.setTempoEsperaAtendimento(tempoEsperaMin);

        historico.inserir(registroAtendimento);
    }
}
