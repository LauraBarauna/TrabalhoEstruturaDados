package presentation.views;

import controller.GuicheController;
import controller.RelatorioController;
import domain.entities.Guiche;

import javax.swing.*;

public class TelaPrincipal extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel panel;

    private GuicheController guicheController;
    private RelatorioController relatorioController;


    public TelaPrincipal(GuicheController guicheController, RelatorioController relatorioController) {

        this.guicheController = guicheController;
        this.relatorioController = relatorioController;

        setTitle("Sistema Bancário");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        adicionarTelasAosPaineis();
    }

    private void adicionarTelasAosPaineis() {
        TelaAdicionarCliente telaAdicionarCliente = new TelaAdicionarCliente(this.guicheController);
        TelaGuicheNormal telaGuicheNormal = new TelaGuicheNormal(this.guicheController);
        TelaGuichePreferencial telaGuichePreferencial = new TelaGuichePreferencial(this.guicheController);
        TelaRelatorio telaRelatorio = new TelaRelatorio(this.relatorioController);

        this.tabbedPane.addTab("Adicionar", telaAdicionarCliente.getPanelPrincipal());
        this.tabbedPane.addTab("Guichê Normal", telaGuicheNormal.getPanelPrincipal());
        this.tabbedPane.addTab("Guichê Preferencial", telaGuichePreferencial.getPanelPrincipal());
        this.tabbedPane.addTab("Relatório", telaRelatorio.getPanelPrincipal());



    }

    public JPanel getPanel() {
        return panel;
    }
}
