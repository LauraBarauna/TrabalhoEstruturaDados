package presentation.views;

import controller.RelatorioController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaRelatorio {
    private JPanel panelPrincipal;
    private JButton gerarRelatorioButton;
    private RelatorioController relatorioController;

    public TelaRelatorio(RelatorioController relatorioController) {
        this.relatorioController = relatorioController;

        gerarRelatorio();
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    private void gerarRelatorio() {
        gerarRelatorioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                relatorioController.gerarRelatorio();
            }
        });
    }
}
