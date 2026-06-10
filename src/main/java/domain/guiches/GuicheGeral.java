package domain.guiches;



import domain.entities.RegistroAtendimento;
import domain.structures.EstruturaDados;

import java.time.LocalTime;

public class GuicheGeral extends CalculadoraTempoEspera implements PoliticaGuiches<RegistroAtendimento> {

    private boolean atendeuPrioritario;

    public GuicheGeral() {
        this.atendeuPrioritario = false;
    }

    @Override
    public void chamarProximo(EstruturaDados<RegistroAtendimento> filaGeral, EstruturaDados<RegistroAtendimento> filaPreferencial, EstruturaDados<RegistroAtendimento> historico) {
        if (filaPreferencial.estaVazia() && filaGeral.estaVazia()) {
            //TODO ADICIONAR EXCEPTION
            throw new RuntimeException("Nenhum cliente para antender, pois as filas estão vazias.");
        }

        if(!filaPreferencial.estaVazia() && !this.atendeuPrioritario) {
            this.atendeuPrioritario = true;
            RegistroAtendimento registroAtendimento = filaPreferencial.retirar();
            adicionarInfosRegistros(registroAtendimento, historico);
        }

        if (!filaGeral.estaVazia()) {
            RegistroAtendimento registroAtendimento = filaGeral.retirar();
            adicionarInfosRegistros(registroAtendimento, historico);
        }
    }

    private void adicionarInfosRegistros(RegistroAtendimento registroAtendimento, EstruturaDados<RegistroAtendimento> historico) {
        registroAtendimento.setHorarioInicio(LocalTime.now());
        long tempoEsperaMin = calcularTempoEspera(registroAtendimento);

        registroAtendimento.setTempoEsperaAtendimento(tempoEsperaMin);

        historico.inserir(registroAtendimento);
    }
}
