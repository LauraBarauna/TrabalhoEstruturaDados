package domain.entities;

public class GeradorId {
    private static int id = 1;

    public static int gerarId() {
        return id++;
    }
}
