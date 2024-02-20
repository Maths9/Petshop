package Entidade;

public class Gato extends Animal {
    private String cor;

    public Gato(String nome, String sexo, int idade, String cor){
        super(nome, sexo, idade);
        this.cor = cor;
    }

    public Gato(String nome, String sexo, String cor){
        super(nome, sexo);
        this.cor = cor;
    }

    public Gato(String nome, String sexo){
        super(nome, sexo);
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString(){
        return super.toString() + " " + this.cor;
    }
}
