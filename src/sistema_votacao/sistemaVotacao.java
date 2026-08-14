package sistema_votacao;

import java.util.Scanner;

public class sistemaVotacao {

    static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args){
        System.out.println("Sistema de votação iniciado.");
        scanner.close();

        final int MAX_CANDIDATOS = 5;
        final int TOTAL_TURMAS = 3;
        final int MAX_VOTANTES_POR_TURMA = 10;

        int [] numeroCandidatos = new int[MAX_CANDIDATOS];
        String[] nomesCandidatos = new String[MAX_CANDIDATOS];
        int[] votosCandidatos = new int[MAX_CANDIDATOS];

        int[][] votosPorTurma = new int[TOTAL_TURMAS][MAX_VOTANTES_POR_TURMA];

        int[] quantidadeVotosTurma = new int[TOTAL_TURMAS];
        int quantidadeCandidatos = 0;


    }
}
