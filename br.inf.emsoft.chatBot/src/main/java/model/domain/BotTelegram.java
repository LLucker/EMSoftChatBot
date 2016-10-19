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
public class BotTelegram {

    private String token;
    private String logtag;
    private String user;

    public BotTelegram() {
    }

    public BotTelegram(String token, String logtag, String user) {
        this.token = token;
        this.logtag = logtag;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLogtag() {
        return logtag;
    }

    public void setLogtag(String logtag) {
        this.logtag = logtag;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
