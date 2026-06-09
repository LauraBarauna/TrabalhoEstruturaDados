package domain.entities;

public class Pessoa {
    private final int id;
    private final String nome;
    private final int idade;

    public Pessoa(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public boolean isPrioritario() {
        return idade >= 60;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}
