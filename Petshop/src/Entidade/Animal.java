package Entidade;

public abstract class Animal {
    private String nome;
    private String sexo;
    private int idade;

    public Animal(String nome, String sexo){
        this.nome = nome;
        this.sexo = sexo;
    }

    public Animal(String nome, String sexo, int idade){
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString(){
        return this.nome + " " + this.sexo + " " + this.idade;
    }
}
