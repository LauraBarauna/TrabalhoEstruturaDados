import controller.GuicheController;
import controller.RelatorioController;
import domain.entities.Guiche;
import domain.entities.Pessoa;
import domain.entities.RegistroAtendimento;
import domain.guiches.GuicheGeral;
import domain.guiches.GuichePreferencial;
import domain.structures.EstruturaDados;
import infrastructure.report.PdfReport;
import infrastructure.structures.fila.FilaDinamica;
import infrastructure.structures.pilha.PilhaDinamica;
import presentation.views.TelaPrincipal;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        /*
        EstruturaDados<RegistroAtendimento> filaGeral = new FilaDinamica<>();
        EstruturaDados<RegistroAtendimento> filaPreferencial = new FilaDinamica<>();

        EstruturaDados<RegistroAtendimento> pilhaGeral = new PilhaDinamica<>();
        EstruturaDados<RegistroAtendimento> pilhaPreferencial = new PilhaDinamica<>();

        abrirTela(filaGeral, filaPreferencial, pilhaGeral, pilhaPreferencial);
        */

        adicionandoDadosNasPilhasParaTeste();
    }

    public static void adicionandoDadosNasPilhasParaTeste() {
        RegistroAtendimento[] registros = {
                new RegistroAtendimento(new Pessoa(1, "Laura", 60)),
                new RegistroAtendimento(new Pessoa(2, "Yasmin", 18)),
                new RegistroAtendimento(new Pessoa(3, "Marcelo", 89)),
                new RegistroAtendimento(new Pessoa(4, "Fernanda", 25)),
                new RegistroAtendimento(new Pessoa(5, "Carlos", 32)),
                new RegistroAtendimento(new Pessoa(6, "Juliana", 76)),
        };

        LocalTime horarioEntrada = LocalTime.of(9, 0);
        LocalTime horarioAtendimento = LocalTime.of(10, 0);

        EstruturaDados<RegistroAtendimento> pilhaGeral = new PilhaDinamica<>();
        EstruturaDados<RegistroAtendimento> pilhaPreferencial = new PilhaDinamica<>();

        Random random = new Random();

        for (RegistroAtendimento r : registros) {
            long offsetEntrada = random.nextInt(1800);
            long offsetAtendimento = random.nextInt(1800);

            LocalTime entrada = horarioEntrada.plusSeconds(offsetEntrada);
            LocalTime atendimento = horarioAtendimento.plusSeconds(offsetAtendimento);

            r.setHorarioEntrada(entrada);
            r.setHorarioInicio(atendimento);

            long minutosEspera = Duration
                    .between(r.getHorarioEntrada(), r.getHorarioInicio())
                    .toMinutes();

            r.setTempoEsperaAtendimento(minutosEspera);

            if (r.getCliente().isPrioritario()) {
                pilhaPreferencial.inserir(r);
            } else {
                pilhaGeral.inserir(r);
            }
        }


        adicionandoDadosNasFilasParaTeste(pilhaGeral, pilhaPreferencial);
    }

    public static void adicionandoDadosNasFilasParaTeste(EstruturaDados<RegistroAtendimento> pilhaGeral, EstruturaDados<RegistroAtendimento> pilhaPreferencial) {
        RegistroAtendimento[] registros = {
                new RegistroAtendimento(new Pessoa(7, "Rafael", 87)),
                new RegistroAtendimento(new Pessoa(8, "Patricia", 36)),
                new RegistroAtendimento(new Pessoa(9, "Bruno", 22)),
                new RegistroAtendimento(new Pessoa(10, "Camila", 29)),
                new RegistroAtendimento(new Pessoa(11, "Eduardo", 67)),
                new RegistroAtendimento(new Pessoa(12, "Bianca", 63))
        };

        long intervalo = 100;
        LocalTime horarioBase = LocalTime.of(17, 0);

        EstruturaDados<RegistroAtendimento> filaGeral = new FilaDinamica<>();
        EstruturaDados<RegistroAtendimento> filaPreferencial = new FilaDinamica<>();

        for (RegistroAtendimento r : registros) {
            r.setHorarioEntrada(horarioBase);

            horarioBase = horarioBase.plusSeconds(intervalo);

            if (r.getCliente().isPrioritario()) {
                filaPreferencial.inserir(r);
            } else {
                filaGeral.inserir(r);
            }
        }

        abrirTela(filaGeral, filaPreferencial, pilhaGeral, pilhaPreferencial);
    }

    public static void abrirTela(EstruturaDados<RegistroAtendimento> filaGeral,
                                 EstruturaDados<RegistroAtendimento> filaPreferencial,
                                 EstruturaDados<RegistroAtendimento> pilhaGeral,
                                 EstruturaDados<RegistroAtendimento> pilhaPreferencial) {
        Guiche guicheNormal = new Guiche(filaGeral, filaPreferencial, pilhaGeral, new GuicheGeral());
        Guiche guichePreferencial = new Guiche(filaGeral, filaPreferencial, pilhaPreferencial, new GuichePreferencial());

        GuicheController guicheController = new GuicheController(guicheNormal, guichePreferencial);
        RelatorioController relatorioController = new RelatorioController(guicheNormal, guichePreferencial);

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Gerenciamento de Fila Bancário");

            TelaPrincipal tela = new TelaPrincipal(guicheController, relatorioController);

            frame.setContentPane(tela.getPanel());
            frame.setSize(500, 350);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }



}