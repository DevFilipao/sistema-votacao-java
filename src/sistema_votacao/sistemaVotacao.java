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
    }
}
