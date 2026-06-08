package main.java.application.usecase;

import main.java.domain.entities.RegistroAtendimento;

public class AdicionarClienteUC {

    public void execute(RegistroAtendimento registroAtendimento) {
        registroAtendimento.adicionarCliente();
    }

}
