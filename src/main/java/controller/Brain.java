package controller;

import model.dao.PerguntaDAO;
import model.dao.RespostaDAO;
import model.domain.Pergunta;
import model.domain.Resposta;

/**
 * Classe de brain
 * @author luan
 */
public class Brain {
    
    
public String consultarPergunta(String frase){
    Pergunta pergunta;
    PerguntaDAO pergDAO = new PerguntaDAO();
    pergunta = pergDAO.consultaPergunta(frase);
    
    if (pergunta == null){
        pergunta = new Pergunta(frase);
        pergDAO.incluir(pergunta);
        return "Bem... nunca me perguntaram isso!\nnão sei responder agora,"
                + " mas vou estudar isso, me pergunte novamente em 48h ;)";
    }
    else if (pergunta.getId_pergunta()>0){
        Resposta resposta = null;
        RespostaDAO respDAO = new RespostaDAO();
        resposta = respDAO.obter(pergunta.getId_pergunta());
        
    return resposta.getTexto().toString();
    }
    return "WTF";
} 

}

