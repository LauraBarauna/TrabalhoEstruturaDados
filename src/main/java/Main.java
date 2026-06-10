import controller.GuicheController;
import controller.RelatorioController;
import domain.entities.Guiche;
import domain.entities.RegistroAtendimento;
import domain.guiches.GuicheGeral;
import domain.guiches.GuichePreferencial;
import domain.structures.EstruturaDados;
import infrastructure.report.PdfReport;
import infrastructure.structures.fila.FilaDinamica;
import infrastructure.structures.pilha.PilhaDinamica;
import presentation.views.TelaPrincipal;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        EstruturaDados<RegistroAtendimento> filaGeral = new FilaDinamica<>();
        EstruturaDados<RegistroAtendimento> filaPreferencial = new FilaDinamica<>();

        EstruturaDados<RegistroAtendimento> pilhaGeral = new PilhaDinamica<>();
        EstruturaDados<RegistroAtendimento> pilhaPreferencial = new PilhaDinamica<>();

        Guiche guicheNormal = new Guiche(filaGeral, filaPreferencial, pilhaGeral, new GuicheGeral());
        Guiche guichePreferencial = new Guiche(filaGeral, filaPreferencial, pilhaPreferencial, new GuichePreferencial());

        GuicheController guicheController = new GuicheController(guicheNormal, guichePreferencial);
        RelatorioController relatorioController = new RelatorioController(guicheNormal, guichePreferencial, new PdfReport());

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Gerenciamento de Fila Bancário");

            TelaPrincipal tela = new TelaPrincipal(guicheController, relatorioController);

            frame.setContentPane(tela.getPanel());

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }

}