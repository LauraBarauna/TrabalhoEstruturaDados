package controller;


import application.usecase.AdicionarClienteUC;
import application.usecase.AtenderClienteUC;
import domain.entities.Guiche;
import domain.entities.Pessoa;
import domain.entities.RegistroAtendimento;
import domain.structures.EstruturaDados;

public class GuicheController {

    private final AtenderClienteUC atenderCliente;
    private final AdicionarClienteUC  adicionarCliente;

    private final Guiche guicheNormal;
    private final Guiche guichePreferencial;

    public GuicheController(Guiche guicheNormal, Guiche guichePreferencial) {
        this.atenderCliente = new AtenderClienteUC();
        this.adicionarCliente = new AdicionarClienteUC();
        this.guicheNormal = guicheNormal;
        this.guichePreferencial = guichePreferencial;
    }

    public void atenderClienteNormal() {
        this.atenderCliente.execute(this.guicheNormal);
    }

    public void atenderClientePreferencial() {
        this.atenderCliente.execute(this.guichePreferencial);
    }

    public void adicionarClienteNaFila(Pessoa pessoa, EstruturaDados<RegistroAtendimento> filaGeral, EstruturaDados<RegistroAtendimento> filaPreferencial) {
        try {
            this.adicionarCliente.execute(pessoa, filaGeral, filaPreferencial);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
