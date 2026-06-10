package presentation.views;

import domain.entities.RegistroAtendimento;
import domain.structures.EstruturaDados;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public abstract class CardClientes {
    protected JPanel criarCardCliente(int id, String nome, int idade, String horaEntrada) {
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

    protected void atualizarFilaVisivel(EstruturaDados<RegistroAtendimento> filaGeral, EstruturaDados<RegistroAtendimento> filaPreferencial, JScrollPane scrollPanel) {
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

    protected void obterRegistro(EstruturaDados<RegistroAtendimento> fila, DateTimeFormatter formatter, JPanel colunaPreferencial) {
        EstruturaDados<RegistroAtendimento> copiaFila = fila.clonar();

        while (!copiaFila.estaVazia()) {
            RegistroAtendimento registro = copiaFila.retirar();
            JPanel card = criarCardCliente(registro.getCliente().getId(), registro.getCliente().getNome(), registro.getCliente().getIdade(), registro.getHorarioEntrada().format(formatter));
            colunaPreferencial.add(card);
            colunaPreferencial.add(Box.createVerticalStrut(5));
        }
    }
}
