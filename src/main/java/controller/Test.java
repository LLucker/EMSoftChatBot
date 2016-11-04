package controller;

import java.util.List;
import java.util.Scanner;
import jdk.nashorn.internal.objects.NativeArray;
import model.domain.Pergunta;

/**
 *
 * @author luan
 */
public class Test {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Opções: \n"
                    + "1 - Perguntar\n"
                    + "2 - Listar perguntas\n"
                    + "3 - Responder\n"
                    + "4 - Listar Respostas\n"
                    + "5 - Perguntas pendentes\n"
                    + "Digite a desejada: ");
            Scanner ler = new Scanner(System.in);
            int escolha = ler.nextInt();
            switch (escolha) {
                case 1:
                    perguntar();
                    break;
                case 2:
                    listarPerguntas();
                    break;
                default:
                    System.out.println("Opção não implementada");
                    break;
            }
        }
    }

    public static void perguntar() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite uma duvida:");
        String duvida = ler.nextLine();
        String resposta = Brain.consultarPergunta(duvida);
        System.out.println(resposta);
    }

    public static void listarPerguntas() {
        List<Pergunta> perguntas = null;
        perguntas = Brain.obterTodasPerguntas();
        try {
            for (Pergunta pergunta : perguntas) {
                System.out.println("ID:" + pergunta.getId_pergunta()
                        + " Pergunta:" + (pergunta.getFrase() == null ? "" : pergunta.getFrase())
                        + " Resposta:" + (pergunta.getResposta() == null ? "" : pergunta.getResposta().getTexto()));
            }
        } catch (NullPointerException e) {
            System.out.println("\nNão existe Perguntas\n");
        }
    }
}
