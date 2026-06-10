package application.usecase;

import domain.entities.Guiche;
import domain.entities.RegistroAtendimento;
import domain.report.Relatorio;
import domain.structures.EstruturaDados;
import domain.structures.EstruturaVetor;
import infrastructure.structures.vetor.Vetor;

public class GerarRelatorioUC {

    public void execute(Guiche guicheGeral, Guiche guichePreferencial, Relatorio relatorio) {
        EstruturaVetor<RegistroAtendimento> vetorSoma = new Vetor<>(guicheGeral.getHistorico().quantidade() + guichePreferencial.getHistorico().quantidade());

        EstruturaVetor<RegistroAtendimento> vetorGeral = new Vetor<>(guicheGeral.getHistorico().quantidade());
        adicionarNoVetor(vetorGeral, guicheGeral.getHistorico(), vetorSoma);
        adicionarNaPilha(guicheGeral.getHistorico(), vetorGeral);

        EstruturaVetor<RegistroAtendimento> vetorPreferencial = new Vetor<>(guichePreferencial.getHistorico().quantidade());
        adicionarNoVetor(vetorPreferencial, guichePreferencial.getHistorico(), vetorSoma);
        adicionarNaPilha(guichePreferencial.getHistorico(), vetorPreferencial);

        relatorio.gerarRelatorio(vetorGeral, vetorPreferencial, vetorSoma);
    }

    private void adicionarNoVetor(EstruturaVetor<RegistroAtendimento> vetor, EstruturaDados<RegistroAtendimento> pilha, EstruturaVetor<RegistroAtendimento> vetor2) {
        while (!pilha.estaVazia()) {
            RegistroAtendimento r = pilha.retirar();
            vetor.inserir(r);
            vetor2.inserir(r);
        }
    }

    private void adicionarNaPilha(EstruturaDados<RegistroAtendimento> pilha, EstruturaVetor<RegistroAtendimento> vetor) {
        pilha.liberar();
        for (int i = vetor.quantidade() - 1; i >= 0; i--) {
            pilha.inserir(vetor.obterElemento(i));
        }
    }
}
