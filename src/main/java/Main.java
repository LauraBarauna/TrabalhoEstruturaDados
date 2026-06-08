import main.java.controller.GuicheController;
import main.java.domain.entities.Guiche;
import main.java.domain.entities.RegistroAtendimento;
import main.java.domain.guiches.GuicheGeral;
import main.java.domain.guiches.GuichePreferencial;
import main.java.infrastructure.structures.fila.FilaDinamica;

public class Main {
    public static void main(String[] args) {
        FilaDinamica<RegistroAtendimento> filaGeral = new FilaDinamica<>();
        FilaDinamica<RegistroAtendimento> filaPreferencial = new FilaDinamica<>();


        Guiche guicheNormal = new Guiche(filaGeral, filaPreferencial, new GuicheGeral());
        Guiche guichePreferencial = new Guiche(filaGeral, filaPreferencial, new GuichePreferencial());

        GuicheController controller = new GuicheController();
        controller.atenderClienteFilaGeral(guicheNormal);
        controller.atenderClienteFilaPreferencial(guichePreferencial);
    }
}