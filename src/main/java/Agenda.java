package main.java;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

    public static void main(String[] args) {
        System.out.println("Agenda");

        ArrayList<Contato> contatos = new ArrayList<>();

        //testeInicial(contatos);

        int opcao = 0;
        Scanner scan = new Scanner(System.in);


        do {
            System.out.println("\nEscolha a opcao desejada:");
            System.out.println("1 - Incluir contato");
            System.out.println("2 - Listar contatos");
            System.out.println("3 - Buscar Contato");
            System.out.println("4 - Excluir contato");
            System.out.println("0 - Sair");

            opcao = scan.nextInt();

            if (opcao == 1) {
                System.out.println("\nDigite o nome do contato");
                String nome = scan.next();
                System.out.println("Digite o telefone do contato");
                String telefone = scan.next();

                Contato contato = new Contato();
                contato.nome = nome;
                contato.numero = telefone;

                contatos.add(contato);

            } else if (opcao == 2) {
                listarContatos(contatos);

            } else if (opcao == 3) {
                System.out.println("\nDigite o nome do contato");
                String nome = scan.next();
                Contato contato = buscarContato(contatos, nome);
                if (contato == null) {
                    System.out.println("\nContato não encontrado");
                } else {
                    System.out.println("Contato encontrado " + contato.nome + " / " + contato.numero);
                }

            } else if (opcao == 4) {
                System.out.println("\nDigite o nome do contato");
                String nome = scan.next();
                excluirContato(contatos, nome);
            }


        } while (opcao != 0);


    }

    private static void salvarContato(ArrayList<Contato> contatos, Contato contato) {
        contatos.add(contato);
    }

    private static void listarContatos(ArrayList<Contato> contatos) {
        contatos.forEach(contato -> System.out.println(contato.nome + " / " + contato.numero));
    }

    private static Contato buscarContato(ArrayList<Contato> contatos, String nome) {
        for (Contato contato : contatos) {
            if (contato.nome.equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    private static void excluirContato(ArrayList<Contato> contatos, String nome) {

        Contato contato = buscarContato(contatos, nome);
        if (contato == null) {
            System.out.println(" contato não encontrado " + nome);
        } else {
            contatos.remove(contato);
            System.out.println(nome + " excluído com sucesso!");
        }
    }


    private static void testeInicial(ArrayList<Contato> contatos) {


        //salvar um contato
        Contato contato1 = new Contato();
        contato1.nome = "Thabata";
        contato1.numero = "999999999";
        salvarContato(contatos, contato1);

        Contato contato2 = new Contato();
        contato2.nome = "Karen";
        contato2.numero = "1111111111";
        salvarContato(contatos, contato2);


        //visualização dos contatos
        listarContatos(contatos);

        //busca um contato
        System.out.println("buscando contato Thabata");
        Contato contato = buscarContato(contatos, "Thabata");
        System.out.println(" contato encontrado " + contato.nome + " / " + contato.numero);


        //excluir um contato
        System.out.println("\n\n\nAntes da exclusao:");
        listarContatos(contatos);

        System.out.println("\n\n\nExcluindo contato Thabata");
        excluirContato(contatos, "Thabata");


        System.out.println("\n\n\nDepois da exclusao:");
        listarContatos(contatos);
    }
}

