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

        FilaDinamica<RegistroAtendimento> filaGeral = new FilaDinamica<>();
        FilaDinamica<RegistroAtendimento> filaPreferencial = new FilaDinamica<>();

        Guiche guicheNormal = new Guiche(filaGeral, filaPreferencial, new GuicheGeral());
        Guiche guichePreferencial = new Guiche(filaGeral, filaPreferencial, new GuichePreferencial());

        GuicheController guicheController = new GuicheController(guicheNormal, guichePreferencial);

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Gerenciamento de Fila Bancário");

            TelaPrincipal tela = new TelaPrincipal(guicheController);

            frame.setContentPane(tela.getPanel());

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }

}