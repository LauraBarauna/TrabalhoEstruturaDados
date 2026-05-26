package presentation.views;

import javax.swing.*;

public class TelaPrincipal extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panel;

    public TelaPrincipal() {

        setTitle("Sistema Bancário");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
    }

    public JPanel getPanel() {
        return panel;
    }
}
