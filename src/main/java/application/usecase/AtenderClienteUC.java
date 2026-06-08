package main.java.application.usecase;

import main.java.domain.entities.Guiche;

public class AtenderClienteUC {

    public void execute (Guiche guiche) {
        guiche.chamarProximo();
    }

}
