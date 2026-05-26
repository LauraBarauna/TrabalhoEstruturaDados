package presentation.views;

import javax.swing.*;

public class TelaPrincipal extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel panel;

    public TelaPrincipal() {

        setTitle("Sistema Bancário");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        adicionarTelasAosPaineis();
    }

    private void adicionarTelasAosPaineis() {
        TelaAdicionarCliente telaAdicionarCliente = new TelaAdicionarCliente();
        TelaGuicheNormal telaGuicheNormal = new TelaGuicheNormal();
        TelaGuichePreferencial telaGuichePreferencial = new TelaGuichePreferencial();
        TelaRelatorio telaRelatorio = new TelaRelatorio();

        this.tabbedPane.addTab("Adicionar", telaAdicionarCliente.getPanelPrincipal());
        this.tabbedPane.addTab("Guichê Normal", telaGuicheNormal.getPanelPrincipal());
        this.tabbedPane.addTab("Guichê Preferencial", telaGuichePreferencial.getPanelPrincipal());
        this.tabbedPane.addTab("Relatório", telaRelatorio.getPanelPrincipal());



    }

    public JPanel getPanel() {
        return panel;
    }
}
