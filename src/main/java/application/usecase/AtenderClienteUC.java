package application.usecase;


import domain.entities.Guiche;

public class AtenderClienteUC {

    public void execute (Guiche guiche) {
        guiche.chamarProximo();
    }

}
