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

        this.tabbedPane.addTab("Adicionar", telaAdicionarCliente.getPanelPrincipal());
    }

    public JPanel getPanel() {
        return panel;
    }
}
