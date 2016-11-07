package controller;

import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
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

            //Scanner ler = new Scanner(System.in);
            int escolha = Integer.parseInt(JOptionPane.showInputDialog(null, "Opções: \n"
                    + "1 - Perguntar\n"
                    + "2 - Listar perguntas\n"
                    + "3 - Responder\n"
                    + "4 - Listar Respostas\n"
                    + "5 - Perguntas pendentes\n"
                    + "Digite a desejada: "));
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
                case 4:
                    listarRespostas();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção não implementada");
                    break;
            }
        }
    }

    public static void perguntar() {
        String duvida = JOptionPane.showInputDialog(null, "Olá usuario, sobre oque deseja saber?");
        String resposta = Brain.consultarPergunta(duvida);
        JOptionPane.showMessageDialog(null, resposta);
    }

    public static void listarPerguntas() {
        List<Pergunta> perguntas;
        perguntas = Brain.obterTodasPerguntas();
        try {
            //for (Pergunta pergunta : perguntas) {

            StringBuilder str = new StringBuilder();
            perguntas.stream().forEach((pergunta) -> {
                str.append("ID:" + pergunta.getId_pergunta()
                        + " Pergunta:" + (pergunta.getFrase() == null ? "" : pergunta.getFrase())
                        + " Resposta:" + (pergunta.getResposta() == null ? "" : pergunta.getResposta().getTexto()) + "("+pergunta.getResposta().getId_resposta()+")\n");
            });

            JOptionPane.showMessageDialog(null, str.toString());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "\nNão existe Perguntas\n");
        }
    }

    public static void responder() {
        //Pergunta o id da pergunta e recupera ela do BD
        Integer id = Integer.parseInt(JOptionPane.showInputDialog(null, "Isira o id da pergunta"));
        Pergunta pergunta = Brain.obterPerguntaPorID(id);

        //Registra a Resposta no BD
        String resp = JOptionPane.showInputDialog(null, "Pergunta: " + pergunta.getFrase() + "\nInsira a Resposta");
        Resposta resposta = incResposta(resp);

        //Salva a resposta na pergunta
        PerguntaDAO pergDAO = new PerguntaDAO();
        pergunta.setResposta(resposta);
        pergDAO.alterar(pergunta);
    }

    public static Resposta incResposta(String resp) {
        if (!"".equals(resp)) {
            RespostaDAO respDAO = new RespostaDAO();
            Resposta resposta = respDAO.incluir(new Resposta(resp));
            return resposta;
        }
        return null;
    }

    public static void listarRespostas() {
        List<Resposta> respostas;
        respostas = Brain.obterTodasRespostas();
        try {
            //for (Pergunta pergunta : perguntas) {

            StringBuilder str = new StringBuilder();
            respostas.stream().forEach((resposta) -> {
                str.append("ID:" + resposta.getId_resposta()
                        + " Pergunta:" + (resposta.getTexto() == null ? "" : resposta.getTexto())
                        + "\n");
            });

            JOptionPane.showMessageDialog(null, str.toString());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "\nNão existe Respostas\n");
        }
    }

}
