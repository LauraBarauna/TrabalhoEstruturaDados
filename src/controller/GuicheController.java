package controller;

import application.usecase.AtenderClienteUC;
import domain.entities.Guiche;

public class GuicheController {

    private final AtenderClienteUC atenderCliente;
    private final Guiche guicheNormal;
    private final Guiche guichePreferencial;

    public GuicheController(Guiche guicheNormal, Guiche guichePreferencial) {
        this.atenderCliente = new AtenderClienteUC();
        this.guicheNormal = guicheNormal;
        this.guichePreferencial = guichePreferencial;
    }

    public void atenderClienteNormal() {
        this.atenderCliente.execute(this.guicheNormal);
    }

    public void atenderClientePreferencial() {
        this.atenderCliente.execute(this.guichePreferencial);
    }

}
