/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 *
 * @author luan
 */
@Entity
@Table(name = "respostas")
public class Resposta {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int id_resposta;
    @Column(length = 500, nullable=false)
    private String texto;
    
    //Construtores
    public Resposta(int id_resposta, String texto) {
        this.id_resposta = id_resposta;
        this.texto = texto;
    }  

    public Resposta(String texto) {
       this.texto = texto;
    }  

    public Resposta() {
    }
    
    //Get and Setters

    public int getId_resposta() {
        return id_resposta;
    }

    public void setId_resposta(int id_resposta) {
        this.id_resposta = id_resposta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
