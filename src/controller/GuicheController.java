package controller;

import application.usecase.AtenderClienteUC;
import domain.entities.Guiche;

public class GuicheController {

    private final AtenderClienteUC atenderCliente;

    public GuicheController() {
        this.atenderCliente = new AtenderClienteUC();
    }

    public void atenderClienteFilaGeral(Guiche guicheNormal) {
        try {
            this.atenderCliente.execute(guicheNormal);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void atenderClienteFilaPreferencial(Guiche guichePreferencial) {
        try {
            this.atenderCliente.execute(guichePreferencial);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
