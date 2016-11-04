package controller;

import java.util.List;
import model.dao.PerguntaDAO;
import model.dao.RespostaDAO;
import model.domain.Pergunta;
import model.domain.Resposta;

/**
 * Principal classe de controle
 */
public class Brain {

    //Verifica se a pergunta existe no banco de dados
    //Se existir retorna a resposta
    //Se não existir cadastra a pergunta
    //Se existir mas não tiver resposta retorna que já está cadastrado
    public static String consultarPergunta(String frase) {
        Pergunta pergunta;
        PerguntaDAO pergDAO = new PerguntaDAO();
       //Consulta pergunta no BD
        pergunta = pergDAO.consultaPergunta(frase);
       //Se não existir no BD
        if (pergunta == null) {
            pergunta = new Pergunta(frase);
            //Cadastra pergunta no BD
            pergDAO.incluir(pergunta);
            return "Bem... nunca me perguntaram isso!\nnão sei responder agora,"
                    + " mas vou estudar isso, me pergunte novamente depois ;)";
        //Pergunta existe mas não tem resposta
        } else if ((pergunta.getResposta() == null)) {
            return "Já estou estudando isso!";
        //Pergunta com resposta
        } else if (pergunta.getId_pergunta() > 0) {
            RespostaDAO respDAO = new RespostaDAO();
            Resposta resposta = respDAO.obter(pergunta.getId_pergunta());

            return resposta.getTexto().toString();
        }
        return "WTF";
    }
    
    //Retorna todas as perguntas cadastradas
    public static List<Pergunta> obterTodasPerguntas(){
        PerguntaDAO pergDAO = new PerguntaDAO();
        List<Pergunta> perguntas = pergDAO.obterTodos();
    return perguntas;
    }
    //Pergunta por ID
    public static Pergunta obterPerguntaPorID(Integer id_pergunta){
        PerguntaDAO pergDAO = new PerguntaDAO();
        Pergunta pergunta = pergDAO.obterPerguntaPorID(id_pergunta);
    return pergunta;
    }
    //Retorna todas as perguntas cadastradas sem resposta
    public static List<Pergunta> obterPerguntasSemResposta(){
        PerguntaDAO pergDAO = new PerguntaDAO();
        List<Pergunta> perguntassr = pergDAO.obterPerguntasSemResposta();
    return perguntassr;
    }
  
    public static void responderPergunta(Pergunta pergunta, Resposta resposta){
        PerguntaDAO pergDAO = new PerguntaDAO();
        pergunta.setResposta(resposta);
        pergDAO.alterar(pergunta);
    }
}
