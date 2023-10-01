package io.github.lucianodacunha.screenmatch.main;

import java.util.Random;
import java.util.Scanner;

public class Teste2 {
    public static void main(String[] args) {

        solucao3();
    }

    private static void solucao1() {
        Scanner adivinhacao = new Scanner(System.in);
        int numeroAleatorio = new Random().nextInt(100);
        int chances = 5;
        boolean acertou = false;

        while (chances > 0) {
            System.out.printf("Digite um número de 0 a 100, " +
                    "vc ainda tem %d tentativas: ", chances);
            int numero = adivinhacao.nextInt();
            chances--;


            if (numero == numeroAleatorio) {
                System.out.printf("\nParabens, vc acertou o número em " +
                        "%d tentativas.", (5 - chances));
                acertou = true;
                break;
            } else {
                System.out.println("\nNão é esse. ");

                if (chances == 0) {
                    break;
                } else if (numero > numeroAleatorio) {
                    System.out.print(
                            "O número digitado é maior que o número gerado.\n");
                } else {
                    System.out.print(
                            "O número digitado é menor que o número gerado\n");

                }
            }
        }

        if (acertou == false && chances == 0) {
            System.out.printf("\nQue pena, vc não conseguiu acertar o número, " +
                            "tente jogar novamente.\nO número gerado foi %d.",
                    numeroAleatorio);
        }

    }

    static void solucao2() {
        Scanner adivinhacao = new Scanner(System.in);
        int numeroAleatorio = new Random().nextInt(100);
        int chances = 5;
        boolean acertou = false;

        do {
            System.out.printf("Digite um número de 0 a 100, " +
                    "vc ainda tem %d tentativas: ", chances);
            int numero = adivinhacao.nextInt();
            chances--;

            if (numero == numeroAleatorio) {
                System.out.printf("\nParabens, vc acertou o número em " +
                        "%d tentativas.", (5 - chances));
                acertou = true;
                break;
            } else {
                System.out.println("\nNão é esse. ");

                if (chances == 0) {
                    break;
                } else if (numero > numeroAleatorio) {
                    System.out.print(
                            "O número digitado é maior que o número gerado.\n");
                } else {
                    System.out.print(
                            "O número digitado é menor que o número gerado\n");

                }
            }
        } while (true);

        if (acertou == false) {
            System.out.printf("\nQue pena, vc não conseguiu acertar o número, " +
                            "tente jogar novamente.\nO número gerado foi %d.",
                    numeroAleatorio);
        }

    }

    static void solucao3() {

        String nome = "Marcio Freire";
        String tipoDaConta = "Corrente";
        double saldo = 125.99;

        System.out.println("##############################");
        System.out.println("\nNome do cliente: " + nome);
        System.out.println("Tipo da conta: " + tipoDaConta);
        System.out.println("Saldo atual: " + saldo);
        System.out.println("\n############################");

        // criando menu de opções
        int opcao = 0;
        String menu;
        menu = """
                **Escolhas as opções abaixo **
                1 - Consultar seu saldo
                2 - Transferir valor
                3 - Depositar valor
                4 - Sair
                """;
        Scanner leitura = new Scanner(System.in);

        while (opcao != 4) {
            System.out.println(menu);
            opcao = leitura.nextInt();
        }

        if (opcao == 1) {
            System.out.println("o saldo atual é de " + saldo);
        } else if (opcao == 2) {
            System.out.println("Qual é o valor que deseja transferir?");
            double valor = leitura.nextDouble();
            if (valor > saldo) {
                System.out.println("não há saldo suficiente");
            } else {
                saldo -= valor;
                System.out.println("Saldo atual " + saldo);
            }

        } else if (opcao == 3) {
            System.out.println("valor recebido: ");
            double valor = leitura.nextDouble();
            saldo += valor;
            System.out.println("Novo saldo é de " + saldo);
        } else if (opcao != 4) {
            System.out.println("Opção inválida!");
        }
    }
}
