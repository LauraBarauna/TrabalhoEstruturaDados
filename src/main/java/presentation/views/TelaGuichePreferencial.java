package presentation.views;

import controller.GuicheController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaGuichePreferencial {
    private JPanel panelPrincipal;
    private JButton chamarProximoButton;

    private final GuicheController guicheController;

    public TelaGuichePreferencial(GuicheController guicheController) {
        this.guicheController = guicheController;
        chamarProximo();
    }

    private void chamarProximo() {
        chamarProximoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guicheController.atenderClientePreferencial();
            }
        });
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
