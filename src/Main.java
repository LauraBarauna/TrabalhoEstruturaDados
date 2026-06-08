import controller.GuicheController;
import domain.entities.Guiche;
import domain.entities.RegistroAtendimento;
import domain.guiches.GuicheGeral;
import domain.guiches.GuichePreferencial;
import infrastructure.structures.fila.FilaDinamica;

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