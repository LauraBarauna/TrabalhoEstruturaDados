import controller.GuicheController;
import domain.entities.Guiche;
import domain.entities.RegistroAtendimento;
import domain.guiches.GuicheGeral;
import domain.guiches.GuichePreferencial;
import domain.structures.EstruturaDados;
import infrastructure.structures.fila.FilaDinamica;
import infrastructure.structures.pilha.PilhaDinamica;

public class Main {
    public static void main(String[] args) {
        EstruturaDados<RegistroAtendimento> filaGeral = new FilaDinamica<>();
        EstruturaDados<RegistroAtendimento> filaPreferencial = new FilaDinamica<>();

        EstruturaDados<RegistroAtendimento> historicoGuicheGeral = new PilhaDinamica<>();
        EstruturaDados<RegistroAtendimento> historicoGuichePreferencial = new PilhaDinamica<>();

        Guiche guicheNormal = new Guiche(filaGeral, filaPreferencial, historicoGuicheGeral, new GuicheGeral());
        Guiche guichePreferencial = new Guiche(filaGeral, filaPreferencial, historicoGuichePreferencial, new GuichePreferencial());

        GuicheController controller = new GuicheController();
        controller.atenderClienteFilaGeral(guicheNormal);
        controller.atenderClienteFilaPreferencial(guichePreferencial);
    }
}