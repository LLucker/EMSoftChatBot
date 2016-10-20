/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.domain.BotTelegram;

/**
 * Classe de controle e gerenciamento do arquivo de properties do sistema
 * @see Properties
 * @since 1.0
 * @version 1.0
 * @author raphael
 */
public class PropertiesController {

    private static final Logger LOG = Logger.getLogger(PropertiesController.class.getName());

    public Properties getProp() throws IOException {

        Properties props = new Properties();
        String propFileName = "configBot.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            props.load(inputStream);
        } else {
            LOG.log(Level.SEVERE, "Não foi possível encontrar o arquivo de configuração do Bottelegram.");
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }

        return props;

    }

    /**
     * Retorna BotTelegram do arquivo de configuração
     *
     * @return BotTelegram
     * @throws IOException
     */
    public BotTelegram retornaConfiguracao() throws IOException {
        BotTelegram retorno = null;

        String token; //Variavel que guardará o token
        String logtag; //Variável que guardará o logtag
        String user;//Variavel que guardará o user
        Properties prop = getProp();

        token = prop.getProperty("chatBot_TOKEN");
        logtag = prop.getProperty("chatBot_LOGTAG");
        user = prop.getProperty("chatBot_USER");

        if ((token != null && !token.isEmpty())
                && (logtag != null && !logtag.isEmpty())
                && (user != null && !user.isEmpty())) {
            retorno = new BotTelegram(token, logtag, user);
        }

        return retorno;
    }
}
