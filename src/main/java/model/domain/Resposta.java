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
public class Resposta {
    @Id
     private int id_resposta;
    
    private String texto;

    public Resposta(int id_resposta, String texto) {
        this.id_resposta = id_resposta;
        this.texto = texto;
    }

    public Resposta() {
    }

    public int getId_resposta() {
        return id_resposta;
    }

    public void setId_resposta(int id_resposta) {
        this.id_resposta = id_resposta;
    }

}
