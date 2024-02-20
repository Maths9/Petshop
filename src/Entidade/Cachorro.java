package Entidade;

public class Cachorro extends Animal {
    private String raca;
    private String porte;

    public Cachorro(String nome, String sexo, int idade, String raca, String porte){
        super(nome, sexo, idade);
        this.raca = raca;
        this.porte = porte;
    }

    public Cachorro(String nome, String sexo, String raca, String porte){
        super(nome, sexo);
        this.raca = raca;
        this.porte = porte;
    }

    public Cachorro(String nome, String sexo){
        super(nome, sexo);
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    @Override
    public String toString(){
        return super.toString() + " " + this.porte + " " + this.raca;
    }

}
