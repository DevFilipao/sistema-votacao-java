package sistema_votacao;

import java.util.Scanner;

public class sistemaVotacao {

    static Scanner scanner = new Scanner(System.in);

    static final int MAX_CANDIDATOS = 5;
    static final int TOTAL_TURMAS = 3;
    static final int MAX_VOTANTES_POR_TURMA = 10;

    static String[] nomesCandidatos = new String[MAX_CANDIDATOS];
    static int[] votosCandidatos = new int[MAX_CANDIDATOS];

    static int[][] votosPorTurma = new int[TOTAL_TURMAS][MAX_VOTANTES_POR_TURMA];
    static int[] quantidadeVotosTurma = new int[TOTAL_TURMAS];

    static int quantidadeCandidatos = 0;

    public static void main(String[] args) {
        System.out.println("Sistema de votação iniciado.");

        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE VOTAÇÃO =====");
            System.out.println("1 - Cadastrar candidatos");
            System.out.println("2 - Iniciar votação");
            System.out.println("3 - Exibir resultado");
            System.out.println("4 - Exibir matriz de votos");
            System.out.println("5 - Sair");

            opcao = lerInteiro("Opção: ");

            switch (opcao) {
                case 1:
                    cadastrarCandidatos();
                    break;
                case 2:
                    iniciarVotacao();
                    break;
                case 3:
                    exibirResultado();
                    break;
                case 4:
                    exibirMatrizVotos();
                    break;
                case 5:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);

            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            }

            System.out.println("Entrada inválida. Digite um número.");
            scanner.nextLine();
        }
    }

    static void cadastrarCandidatos() {
        if (quantidadeCandidatos > 0) {
            System.out.println("Os candidatos já foram cadastrados.");
            return;
        }

        int quantidade;

        do {
            quantidade = lerInteiro("Quantidade de candidatos entre 1 e 5: ");

            if (quantidade < 1 || quantidade > MAX_CANDIDATOS) {
                System.out.println("Quantidade inválida.");
            }
        } while (quantidade < 1 || quantidade > MAX_CANDIDATOS);

        quantidadeCandidatos = quantidade;

        for (int i = 0; i < quantidadeCandidatos; i++) {
            System.out.print("Nome do candidato " + (i + 1) + ": ");
            nomesCandidatos[i] = scanner.nextLine();
        }

        System.out.println("Candidatos cadastrados com sucesso.");
    }

    static void iniciarVotacao() {
        if (quantidadeCandidatos == 0) {
            System.out.println("Cadastre os candidatos antes de iniciar a votação.");
            return;
        }

        for (int turma = 0; turma < TOTAL_TURMAS; turma++) {
            System.out.println("\n--- Votação da turma " + (turma + 1) + " ---");

            for (int v = 0; v < MAX_VOTANTES_POR_TURMA; v++) {
                System.out.println("Candidatos:");
                for (int c = 0; c < quantidadeCandidatos; c++) {
                    System.out.println((c + 1) + " - " + nomesCandidatos[c]);
                }

                int voto = lerInteiro("Votante " + (v + 1) + ", escolha o candidato: ");

                if (voto < 1 || voto > quantidadeCandidatos) {
                    System.out.println("Candidato inválido. Voto não computado.");
                    v--;
                    continue;
                }
                break;

            }
        }

        System.out.println("Votação encerrada.");
    }

    static void exibirResultado() {
        if (quantidadeCandidatos == 0) {
            System.out.println("Nenhum candidato cadastrado.");
            return;
        }

        System.out.println("\n--- Resultado da votação ---");

        int vencedor = 0;
        for (int c = 0; c < quantidadeCandidatos; c++) {
            System.out.println(nomesCandidatos[c] + ": " + votosCandidatos[c] + " voto(s)");
            if (votosCandidatos[c] > votosCandidatos[vencedor]) {
                vencedor = c;
            }
        }

        System.out.println("Vencedor: " + nomesCandidatos[vencedor] + " com " + votosCandidatos[vencedor] + " voto(s)");
    }

    static void exibirMatrizVotos() {
        System.out.println("\n--- Matriz de votos por turma ---");

        for (int t = 0; t < TOTAL_TURMAS; t++) {
            System.out.print("Turma " + (t + 1) + ": ");
            for (int v = 0; v < MAX_VOTANTES_POR_TURMA; v++) {
                System.out.print(votosPorTurma[t][v] + " ");
            }
            System.out.println();
        }
    }
}