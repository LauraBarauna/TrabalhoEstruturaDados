package presentation.views;

import controller.GuicheController;
import domain.entities.Pessoa;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static domain.entities.GeradorId.gerarId;

public class TelaAdicionarCliente {

    private GuicheController guicheController;

    private JPanel panelPrincipal;
    private JTextField nomeField;
    private JSpinner idadeField;
    private JButton adicionarNaFilaButton;

    public TelaAdicionarCliente(GuicheController guicheController) {
        this.guicheController = guicheController;
        inicializarComponentes();
        adicionarCliente();
    }

    private void inicializarComponentes() {
        panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBorder(new EmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 8, 8, 8);

        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0;
        panelPrincipal.add(new JLabel("Nome Completo:"), gbc);

        nomeField = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 1.0;
        panelPrincipal.add(nomeField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        panelPrincipal.add(new JLabel("Idade:"), gbc);

        SpinnerNumberModel modeloIdade = new SpinnerNumberModel(18, 0, 120, 1);
        idadeField = new JSpinner(modeloIdade);
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 1.0;
        panelPrincipal.add(idadeField, gbc);

        adicionarNaFilaButton = new JButton("Adicionar à Fila");
        adicionarNaFilaButton.setPreferredSize(new Dimension(150, 35));

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(adicionarNaFilaButton, gbc);
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    private void adicionarCliente() {
        adicionarNaFilaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pessoa cliente = criarPessoa();
                    guicheController.adicionarClienteNaFila(cliente);

                    nomeField.setText("");
                    idadeField.setValue(18);

                    JOptionPane.showMessageDialog(panelPrincipal, "Cliente adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(panelPrincipal, "Erro ao validar os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private Pessoa criarPessoa() {
        String nome = nomeField.getText();
        int idade = (Integer) idadeField.getValue();

        if (idade < 0) {
            // TODO CRIAR EXCEPTION
            throw new RuntimeException();
        }

        if (nome.isBlank()) {
            // TODO CRIAR EXCEPTION
            throw new RuntimeException();
        }

        return new Pessoa(gerarId(), nome, idade);
    }
}
