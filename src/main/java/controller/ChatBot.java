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
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;
import view.Programa;

/**
 * @version 1.0
 * @author luan sena
 */
public class ChatBot extends TelegramLongPollingBot {

    private static final Logger LOG = Logger.getLogger(ChatBot.class.getName());
    private static final Programa MYFRAME = new Programa();
    private static BotTelegram bot;
    
    public static void main(String[] args) {
        PropertiesController properties = new PropertiesController();
        try {
            bot = properties.retornaConfiguracao();
        } catch (IOException ex) {
          LOG.log(Level.SEVERE, "Não foi possível retornar as configurações do BOT");
        }
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        MYFRAME.setVisible(true);
        MYFRAME.setStatus("Inicializando...");
        try {
            telegramBotsApi.registerBot(new ChatBot());
        } catch (TelegramApiException e) {
            BotLogger.error(bot.getLogtag(), e);
        } finally {
            MYFRAME.setStatus("Online");
        }

    }

    @Override
    public String getBotToken() {
        return ChatBot.bot.getToken();
    }

    /**
     * Trata Notificação recebida pela API
     *
     * @param update
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();

            //Checa se a mensagem recebida é do tipo text
            if (message.hasText()) {
                String mensagem = message.getText();
                String nome = message.getChat().getFirstName();
                SendMessage sendMessageRequest = new SendMessage();
                sendMessageRequest.setChatId(message.getChatId().toString());
                //checarPergunta(mensagem)
                MYFRAME.setMensagem(">> "+nome+":"+mensagem + "\n");
                List<String> iniciar = Arrays.asList("bom dia", "boa tarde", "boa noite", "oi", "ola", "olá", "hi", "hello");
                //Inicio comandos
                if (mensagem.equals("/info")) {
                    comandoInfo(sendMessageRequest, message);
                }
                else if (mensagem.equals("/start")) {
                    comandoStart(sendMessageRequest, message);
                }//Fim comandos
                //Mensagem inicial
                else if (iniciar.contains(mensagem.toLowerCase())) {
                    sendMessageRequest.setText("Olá, "+nome+" qual é sua duvida?");
                    enviarMensagem(sendMessageRequest);
                } else {
                    //Resposta padrão
                    sendMessageRequest.setText("Não sei responder isso :("/* + mensagem*/);
                    enviarMensagem(sendMessageRequest);
                }

            }
        }
    }
    public void comandoInfo(SendMessage sendMessageRequest, Message message){
        sendMessageRequest.setText("Nome: " + message.getChat().getFirstName()
                            + "\nSobrenome: " + message.getChat().getLastName()
                            + "\nTitulo: " + message.getChat().getTitle()
                            + "\nUser: " + message.getChat().getUserName()
                            + "\nHashCode: " + message.getChat().hashCode()
                            + "\nIdTelegram: " + message.getChat().getId());
        enviarMensagem(sendMessageRequest);
    }
    public void comandoStart(SendMessage sendMessageRequest, Message message){
        sendMessageRequest.setText("Olá " + message.getChat().getFirstName()
                            + ",\né um prazer falar com você, diga sua dúvida ou digite"
                            + " ''/'' para ver os comandos disponíveis");
        
        
        enviarMensagem(sendMessageRequest);
    }
    
    public void enviarMensagem(SendMessage sendMessageRequest) {
        try {
            sendMessage(sendMessageRequest);
        } catch (TelegramApiException e) {
            //

        }
    }

    @Override
    public String getBotUsername() {
        return ChatBot.bot.getUser();
    }
}
