/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author luan
 */
@Entity
@Table(name = "perguntas")
public class Pergunta {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_pergunta;
    
    private String texto;
    
    private String tema;
    @ManyToOne
    private List<Resposta> resposta;
    
    //Construtores
    public Pergunta() {
    }
    public Pergunta(String texto) {
        this.texto=texto;
    }

    public Pergunta(int id_pergunta, String texto, String tema, List<Resposta> resposta) {
        this.id_pergunta = id_pergunta;
        this.texto = texto;
        this.tema = tema;
        this.resposta = resposta;
    }

    public int getId_pergunta() {
        return id_pergunta;
    }

    public void setId_pergunta(int id_pergunta) {
        this.id_pergunta = id_pergunta;
    }

    public String getFrase() {
        return texto;
    }

    public void setFrase(String frase) {
        this.texto = frase;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public List<Resposta> getResposta() {
        return resposta;
    }

    public void setResposta(List<Resposta> resposta) {
        this.resposta = resposta;
    }
    
}
