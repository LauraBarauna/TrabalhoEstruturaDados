package presentation.views;

import controller.GuicheController;
import domain.entities.RegistroAtendimento;
import domain.structures.EstruturaDados;
import domain.structures.EstruturaVetor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class TelaGuicheNormal {
    private JPanel panelPrincipal;
    private JButton chamarProximoButton;
    private JScrollPane scrollPanel;

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
                atualizarFilaVisivel(guicheController.getGuicheNormal().getVetorFila(), guicheController.getGuichePreferencial().getVetorFila());
            }
        });
    }

    private JPanel criarCardCliente(int id, String nome, int idade, String horaEntrada) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)
        ));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));


        card.add(new JLabel("ID: " + id));
        card.add(new JLabel("Nome: " + nome));
        card.add(new JLabel("Idade: " + idade));
        card.add(new JLabel("Entrada: " + horaEntrada));

        return card;
    }

    public void atualizarFilaVisivel(EstruturaVetor<RegistroAtendimento> filaGeral, EstruturaVetor<RegistroAtendimento> filaPreferencial) {
        JPanel painelColunas = new JPanel(new GridLayout(1, 2, 10, 0));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        JPanel colunaGeral = new JPanel();
        colunaGeral.setLayout(new BoxLayout(colunaGeral, BoxLayout.Y_AXIS));
        colunaGeral.setBorder(BorderFactory.createTitledBorder("Fila Geral"));

        obterRegistro(filaGeral, formatter, colunaGeral);

        JPanel colunaPreferencial = new JPanel();
        colunaPreferencial.setLayout(new BoxLayout(colunaPreferencial, BoxLayout.Y_AXIS));
        colunaPreferencial.setBorder(BorderFactory.createTitledBorder("Fila Preferencial"));

        obterRegistro(filaPreferencial, formatter, colunaPreferencial);

        painelColunas.add(colunaGeral);
        painelColunas.add(colunaPreferencial);

        scrollPanel.setViewportView(painelColunas);
        scrollPanel.revalidate();
        scrollPanel.repaint();
    }

    private void obterRegistro(EstruturaVetor<RegistroAtendimento> filaPreferencial, DateTimeFormatter formatter, JPanel colunaPreferencial) {
        for (int i = 0; i < filaPreferencial.quantidade(); i++) {
            RegistroAtendimento registro = filaPreferencial.obterElemento(i);
            JPanel card = criarCardCliente(registro.getCliente().getId(), registro.getCliente().getNome(), registro.getCliente().getIdade(), registro.getHorarioEntrada().format(formatter));
            colunaPreferencial.add(card);
            colunaPreferencial.add(Box.createVerticalStrut(5));
        }
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setGuicheController(GuicheController guicheController) {
        this.guicheController = guicheController;
    }
}
