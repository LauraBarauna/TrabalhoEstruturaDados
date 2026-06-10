package presentation.views;

import controller.GuicheController;
import domain.entities.RegistroAtendimento;
import domain.listener.FilaChangeListener;
import domain.structures.EstruturaDados;
import domain.structures.EstruturaVetor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class TelaGuicheNormal extends CardClientes implements FilaChangeListener {
    private JPanel panelPrincipal;
    private JButton chamarProximoButton;
    private JScrollPane scrollPanel;

    private GuicheController guicheController;

    public TelaGuicheNormal(GuicheController guicheController) {
        this.guicheController = guicheController;

        this.guicheController.registrarListener(this);

        atualizarFilaVisivel(guicheController.getFilaGeral(), guicheController.getFilaPreferencial(), this.scrollPanel);
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

    @Override
    public void onFilaMudou() {
        renderizarFila();
    }

    private void renderizarFila() {
        atualizarFilaVisivel(guicheController.getFilaGeral(), guicheController.getFilaPreferencial(), this.scrollPanel);
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
