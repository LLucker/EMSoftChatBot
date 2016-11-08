package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.domain.BotTelegram;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;
import view.Programa;

/**
 * @version 1.5
 * @author luan sena
 */
public class ChatBot extends TelegramLongPollingBot {

    private static final Logger LOG = Logger.getLogger(ChatBot.class.getName());
    private static final Programa MYFRAME = new Programa();
    private static BotTelegram bot;

    public static void main(String[] args) {
        //Pega as configurações do bot
        PropertiesController properties = new PropertiesController();
        try {
            bot = properties.retornaConfiguracao();
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "Não foi possível retornar as configurações do BOT");
        }
        //Instancia da API
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        //Abre a janela principal
        MYFRAME.setVisible(true);
        MYFRAME.setStatus("Inicializando...");
        //Coloca a bot online
        try {
            telegramBotsApi.registerBot(new ChatBot());
        } catch (TelegramApiException e) {
            BotLogger.error(bot.getLogtag(), e);
        } finally {
            MYFRAME.setStatus("Online");
        }

    }

    //Retorna o token do bot
    @Override
    public String getBotToken() {
        return ChatBot.bot.getToken();
    }

    //Executa quando o bot recebe uma mensagem de texto
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();

            //Checa se a mensagem recebida é do tipo text
            if (message.hasText()) {
                String mensagem = message.getText();
                String nome = message.getChat().getFirstName();
                //Cria nova resposta à usuario
                SendMessage sendMessageRequest = new SendMessage();
                //Seta o alvo da resposta como o usuario que invocou
                sendMessageRequest.setChatId(message.getChatId().toString());
                //Live preview no painel
                MYFRAME.setMensagem(">> " + nome + ":" + mensagem + "\n");
                //Lista de saudações possiveis
                List<String> iniciar = Arrays.asList("bom dia", "boa tarde", "boa noite", "oi",
                        "ola", "olá", "hi", "hello", "koe", "koé");

                if (iniciar.contains(mensagem.toLowerCase())) {
                    sendMessageRequest.setText("Olá, " + nome + " qual é sua duvida?");
                    enviarMensagem(sendMessageRequest);
                } else {
                    switch (mensagem) {
                        case "/info":
                            comandoInfo(sendMessageRequest, message);
                            break;
                        case "/start":
                            comandoStart(sendMessageRequest, message);
                            break;
                        default:
                            String resposta = Brain.consultarPergunta(mensagem);
                            if (!resposta.isEmpty()){
                            sendMessageRequest.setText(resposta);
                            enviarMensagem(sendMessageRequest);
                            } else resposta = "Estou confuso";
                            sendMessageRequest.setText(resposta);
                            enviarMensagem(sendMessageRequest);
                            break;
                    }
                }
            }
        }
    }

    //Comando retorna informações sobre o usuario
    public void comandoInfo(SendMessage sendMessageRequest, Message message) {
        sendMessageRequest.setText("Nome: " + message.getChat().getFirstName()
                + "\nSobrenome: " + message.getChat().getLastName()
                + "\nTitulo: " + message.getChat().getTitle()
                + "\nUser: " + message.getChat().getUserName()
                + "\nHashCode: " + message.getChat().hashCode()
                + "\nIdTelegram: " + message.getChat().getId());
        enviarMensagem(sendMessageRequest);
    }

    //Comando dado pelo usuario quando adiciona o bot
    public void comandoStart(SendMessage sendMessageRequest, Message message) {
        sendMessageRequest.setText("Olá " + message.getChat().getFirstName()
                + ",\né um prazer falar com você, diga sua dúvida ou digite"
                + " ''/'' para ver os comandos disponíveis");
        enviarMensagem(sendMessageRequest);
    }

    //Metodo de envio de mensagem bot > usuario
    public void enviarMensagem(SendMessage sendMessageRequest) {
        try {
            sendMessage(sendMessageRequest);
        } catch (TelegramApiException e) {
            /**/ }
    }

    //Retorna o User do bot
    @Override
    public String getBotUsername() {
        return ChatBot.bot.getUser();
    }
}
