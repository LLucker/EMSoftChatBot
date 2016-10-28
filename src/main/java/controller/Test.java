package controller;

import java.util.Scanner;

/**
 *
 * @author luan
 */
public class TesteMain {
    public static void main(String[] args) {
        Brain brain = new Brain();
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite uma duvida:");
        String duvida = ler.nextLine();
        String resposta = brain.consultarPergunta(duvida);
        System.out.println(resposta);
    }
}
