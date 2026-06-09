package presentation.views;

import controller.GuicheController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaGuicheNormal {
    private JPanel panelPrincipal;
    private JButton chamarProximoButton;

    private GuicheController guicheController;

    public TelaGuicheNormal(GuicheController guicheController) {
        this.guicheController = guicheController;
        chamarProximo();
    }

    private void chamarProximo() {
        assert chamarProximoButton != null;
        chamarProximoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guicheController.atenderClienteNormal();
            }
        });
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
