/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.dao.PerguntaDAO;
import model.domain.Pergunta;

/**
 * 
 * @author raphael
 */
public class Brain {
    
    
public boolean consultarPergunta(String frase){
    List<Pergunta> pergunta;
    PerguntaDAO pergDAO = new PerguntaDAO();
    pergunta = pergDAO.obterPergunta(frase);
    if (pergunta.isEmpty()){
        return false;
    }
 return true;
}

}

