package controller;

import application.usecase.GerarRelatorioUC;
import domain.entities.Guiche;
import domain.report.Relatorio;

public class RelatorioController {

    private final GerarRelatorioUC gerarRelatorioUC;

    public RelatorioController() {
        this.gerarRelatorioUC = new GerarRelatorioUC();
    }

    public void gerarRelatorio(Guiche guicheGeral, Guiche guichePreferencial, Relatorio relatorio) {
        try {
            this.gerarRelatorioUC.execute(guicheGeral, guichePreferencial, relatorio);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
