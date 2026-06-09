package application.usecase;


import domain.entities.Pessoa;
import domain.entities.RegistroAtendimento;
import domain.structures.EstruturaDados;

public class AdicionarClienteUC {

    public void execute(Pessoa pessoa, EstruturaDados<RegistroAtendimento> filaGeral, EstruturaDados<RegistroAtendimento> filaPreferencial) {
        RegistroAtendimento registroAtendimento = new RegistroAtendimento(pessoa);

        if (pessoa.isPrioritario()) {
            filaPreferencial.inserir(registroAtendimento);
        } else {
            filaGeral.inserir(registroAtendimento);
        }
    }

}
