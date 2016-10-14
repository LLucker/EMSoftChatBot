/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 *
 * @author luan
 */
@Entity
@Table(name = "tab_clientes")
public class Pergunta {
    @Id
    private int id_pergunta;
    private String frase;
    private String tema;

    public Pergunta() {
    }

    public Pergunta(int id_pergunta, String frase, String tema) {
        this.id_pergunta = id_pergunta;
        this.frase = frase;
        this.tema = tema;
    }

    public int getId_pergunta() {
        return id_pergunta;
    }

    public void setId_pergunta(int id_pergunta) {
        this.id_pergunta = id_pergunta;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
}
