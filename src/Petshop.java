import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Entidade.Cachorro;
import Entidade.Gato;

public class Petshop {

    @SuppressWarnings("finally")
    public Cachorro cadastroCachorro(Scanner scan){
        String nome, raca, sexo, porte;
        int idade;

        Cachorro cachorro = null;

        try {
            System.out.println("Cadastrando o Cachorro:");
            System.out.println("Nome:");
            nome = scan.nextLine();
            System.out.println("Raça:");
            raca = scan.nextLine();
            System.out.println("Sexo:");
            sexo = scan.nextLine();
            System.out.println("Porte:");
            porte = scan.nextLine();
            System.out.println("Idade:");
            idade = scan.nextInt();

            cachorro = new Cachorro(nome, sexo, idade, raca, porte);

        }catch (InputMismatchException exception){
            System.out.println("Por favor, digite um numero inteiro para idade...");

        }finally {
            scan.nextLine();
            return cachorro;
        }

    }

    @SuppressWarnings("finally")
    public Gato cadastroGato(Scanner scan){
        String nome, sexo, cor;
        int idade;

        Gato gato = null;

        try {
            System.out.println("Cadastrando o gato:");
            System.out.println("Nome:");
            nome = scan.nextLine();
            System.out.println("Sexo:");
            sexo = scan.nextLine();
            System.out.println("Cor:");
            cor = scan.nextLine();
            System.out.println("Idade:");
            idade = scan.nextInt();
            //scan.nextLine();

            gato = new Gato(nome, sexo, idade, cor);
        }catch (InputMismatchException exception){
            System.out.println("Por favor, digite um numero inteiro para idade...");
        }finally {
            scan.nextLine();
            return gato;
        }

    }

    public void salvar_cachorros(List<Cachorro> cachorros){

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("arquivos/banco_cachorros.txt"));

            for(Cachorro cachorro : cachorros){
                writer.write(cachorro.toString());
                writer.newLine();
            }

            writer.close();

        }catch (IOException ioException){
            System.out.println("Problema com o arquivo...");
        }

    }

    @SuppressWarnings("finally")
    public List<Cachorro> ler_cachorros(){
        List<Cachorro> cachorros = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(
                    new FileReader("arquivos/banco_cachorros.txt"));

            String linha;
            while((linha = reader.readLine())!=null){
                String[] dados = linha.split(" ");
                String nome = dados[0];
                String sexo = dados[1];
                //String idade_temp = dados[2];
                //int idade = Integer.parseInt(idade_temp);
                int idade = Integer.parseInt(dados[2]);
                String porte = dados[3];
                String raca = dados[4];
                Cachorro cachorro = new Cachorro(nome, sexo, idade, raca, porte);
                cachorros.add(cachorro);
            }

        }catch (IOException ioException){
            System.out.println("Problema com o arquivo...");
        }finally {
            return cachorros;
        }
    }

    public void menuPrincipal(){
        Scanner scan = new Scanner(System.in);
        int opcao = 0;

        List<Cachorro> cachorros = ler_cachorros();
        List<Gato> gatos = new ArrayList<>();

        System.out.println("Bem-vindo ao PetShop UPE");
        System.out.println("------------------------");

        //Menu
        while(opcao!=9) {
            System.out.println("Menu:");
            System.out.println("1- Cadastrar um cachorro");
            System.out.println("2- Cadastrar um gato");
            System.out.println("3- Listar Cachorros");
            System.out.println("4- Listar Gatos");
            System.out.println("9- Sair");
            System.out.println("Digite a opção desejada: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    Cachorro c = cadastroCachorro(scan);
                    if(c != null){
                        cachorros.add(c);
                    }
                    break;
                case 2:
                    Gato g = cadastroGato(scan);
                    if(g!=null) {
                        gatos.add(g);
                    }
                    break;
                case 3:
                    System.out.println(cachorros);
                    break;
                case 4:
                    System.out.println(gatos);
                    break;
                case 9:
                    System.out.println("Finalizando o programa...");
                    salvar_cachorros(cachorros);
                    break;
                default:
                    System.out.println("Opção invalida...");
            }
            
        }
        scan.close();
    }

}
