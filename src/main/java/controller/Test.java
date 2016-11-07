package controller;

import java.sql.Blob;
import java.util.List;
import java.util.Scanner;
import jdk.nashorn.internal.objects.NativeArray;
import model.dao.PerguntaDAO;
import model.dao.RespostaDAO;
import model.domain.Pergunta;
import model.domain.Resposta;

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
                case 3:
                    responder();
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
    public static void responder(){
        System.out.println("Insira o ID da pergunta: ");
        Scanner ler = new Scanner(System.in);
        Integer id = ler.nextInt();
        Pergunta pergunta = Brain.obterPerguntaPorID(id);
        
        System.out.println("Pergunta: "+ pergunta.getFrase()+"\nResposta: ");
        String resp = ler.nextLine();
        Resposta resposta = incResposta(resp);
        
        PerguntaDAO pergDAO = new PerguntaDAO();
        pergunta.setResposta(resposta);
        pergDAO.alterar(pergunta);
    }
    public static Resposta incResposta(String resp){ // não terminado
        System.out.println("Resposta: ");
        RespostaDAO respDAO = new RespostaDAO();
        Resposta resposta = respDAO.incluir(new Resposta(resp));
        return resposta;
    }
}
