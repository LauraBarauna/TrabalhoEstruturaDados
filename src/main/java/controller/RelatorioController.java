package controller;

import application.usecase.GerarRelatorioUC;
import domain.entities.Guiche;
import domain.report.Relatorio;
import infrastructure.report.PdfReport;

public class RelatorioController {

    private final GerarRelatorioUC gerarRelatorioUC;
    private final Guiche guicheNormal;
    private final Guiche guichePreferencial;

    public RelatorioController(Guiche guicheNormal, Guiche guichePreferencial) {
        this.gerarRelatorioUC = new GerarRelatorioUC();
        this.guicheNormal = guicheNormal;
        this.guichePreferencial = guichePreferencial;

    }

    public void gerarRelatorio() {
        try {
            this.gerarRelatorioUC.execute(this.guicheNormal, this.guichePreferencial, new PdfReport());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
