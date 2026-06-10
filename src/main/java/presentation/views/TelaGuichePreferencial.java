package presentation.views;

import controller.GuicheController;
import domain.listener.FilaChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaGuichePreferencial extends CardClientes implements FilaChangeListener {
    private JPanel panelPrincipal;
    private JButton chamarProximoButton;
    private JScrollPane scrollPanel;

    private final GuicheController guicheController;

    public TelaGuichePreferencial(GuicheController guicheController) {
        this.guicheController = guicheController;
        this.guicheController.registrarListener(this);
        chamarProximo();
        atualizarFilaVisivel(this.guicheController.getFilaGeral(),  this.guicheController.getFilaPreferencial(), this.scrollPanel);
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

    @Override
    public void onFilaMudou() {
        atualizarFilaVisivel(this.guicheController.getFilaGeral(),  this.guicheController.getFilaPreferencial(), this.scrollPanel);
    }
}
