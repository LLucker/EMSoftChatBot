/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

/**
 *
 * @author raphael
 */
public enum Paths {
    
    PROPERTIES("/config/"), IMAGENS("/img/");
    
    private String caminho;

    private Paths() {
    }

    private Paths(String caminho) {
        this.caminho = caminho;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    
    
}
