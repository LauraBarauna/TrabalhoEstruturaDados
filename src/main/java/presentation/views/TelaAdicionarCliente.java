package presentation.views;

import controller.GuicheController;
import domain.entities.Pessoa;

import javax.swing.*;
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
        adicionarCliente();
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    private void adicionarCliente() {
        adicionarNaFilaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pessoa cliente = criarPessoa();
                guicheController.adicionarClienteNaFila(cliente);
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
