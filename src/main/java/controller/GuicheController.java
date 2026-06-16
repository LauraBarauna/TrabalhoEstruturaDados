package controller;


import application.usecase.AdicionarClienteUC;
import application.usecase.AtenderClienteUC;
import domain.entities.Guiche;
import domain.entities.Pessoa;
import domain.entities.RegistroAtendimento;
import domain.listener.FilaChangeListener;
import domain.structures.EstruturaDados;
import domain.structures.EstruturaLista;
import infrastructure.structures.lista.Lista;
import infrastructure.structures.lista.NoLista;

public class GuicheController {

    private final AtenderClienteUC atenderCliente;
    private final AdicionarClienteUC  adicionarCliente;

    private final Guiche guicheNormal;
    private final Guiche guichePreferencial;

    private final EstruturaLista<FilaChangeListener> listeners;

    public GuicheController(Guiche guicheNormal, Guiche guichePreferencial) {
        this.atenderCliente = new AtenderClienteUC();
        this.adicionarCliente = new AdicionarClienteUC();
        this.guicheNormal = guicheNormal;
        this.guichePreferencial = guichePreferencial;

        this.listeners = new Lista<>();
    }

    public void registrarListener(FilaChangeListener listener) {
        this.listeners.inserir(listener);
    }

    private void notificarMudancaNaFila() {
        NoLista<FilaChangeListener> lista = this.listeners.getPrimeiro();
        while (lista != null) {
            lista.getInfo().onFilaMudou();
            lista = lista.getProximo();
        }
    }

    public void atenderClienteNormal() {
        this.atenderCliente.execute(this.guicheNormal);
        notificarMudancaNaFila();
    }

    public void atenderClientePreferencial() {
        this.atenderCliente.execute(this.guichePreferencial);
        notificarMudancaNaFila();
    }

    public void adicionarClienteNaFila(Pessoa pessoa) {
        try {
            this.adicionarCliente.execute(pessoa, this.guicheNormal.getFilaGeral(), this.guicheNormal.getFilaPreferencial());
            notificarMudancaNaFila();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public EstruturaDados<RegistroAtendimento> getFilaGeral() {
        return this.guicheNormal.getFilaGeral();
    }

    public EstruturaDados<RegistroAtendimento> getFilaPreferencial() {
        return this.guichePreferencial.getFilaPreferencial();
    }

}
