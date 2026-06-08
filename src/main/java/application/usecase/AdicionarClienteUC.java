package application.usecase;


import domain.entities.RegistroAtendimento;

public class AdicionarClienteUC {

    public void execute(RegistroAtendimento registroAtendimento) {
        registroAtendimento.adicionarCliente();
    }

}
