package controller;

import application.usecase.GerarRelatorioUC;
import domain.entities.Guiche;
import domain.report.Relatorio;

public class RelatorioController {

    private final GerarRelatorioUC gerarRelatorioUC;
    private final Guiche guicheNormal;
    private final Guiche guichePreferencial;
    private final Relatorio relatorio;

    public RelatorioController(Guiche guicheNormal, Guiche guichePreferencial, Relatorio relatorio) {
        this.gerarRelatorioUC = new GerarRelatorioUC();
        this.guicheNormal = guicheNormal;
        this.guichePreferencial = guichePreferencial;
        this.relatorio = relatorio;
    }

    public void gerarRelatorio() {
        try {
            this.gerarRelatorioUC.execute(this.guicheNormal, this.guichePreferencial, this.relatorio);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
