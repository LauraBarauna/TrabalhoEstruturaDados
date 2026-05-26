import controller.GuicheController;
import domain.entities.Guiche;
import domain.entities.RegistroAtendimento;
import domain.guiches.GuicheGeral;
import domain.guiches.GuichePreferencial;
import infrastructure.structures.fila.FilaDinamica;
import presentation.views.TelaPrincipal;

import javax.swing.*;

public class Main {
    static void main() {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Sistema Bancário");

            TelaPrincipal tela = new TelaPrincipal();

            frame.setContentPane(tela.getPanel());

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }

}