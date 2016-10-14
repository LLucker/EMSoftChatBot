package controller;

import javax.swing.JFrame;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;
import view.Programa;

/**
 *
 * @author luan
 */
public class ChatBot extends TelegramLongPollingBot {

    private static final String LOGTAG = "MAIN";
    public static final String BOT_USERNAME = "EMSoft_bot";
    public static final String BOT_TOKEN = "278853398:AAFedRwU6Z6Qm5n4OY43Itwh0_VDgjtreZw";

    public static void main(String[] args) {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new ChatBot());

            Programa Frame = new Programa();
            Frame.setVisible(true);
        } catch (TelegramApiException e) {
            BotLogger.error(LOGTAG, e);
        }
    }

    @Override
    public String getBotToken() {
        return ChatBot.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText()) {
                SendMessage sendMessageRequest = new SendMessage();
                sendMessageRequest.setChatId(message.getChat().getId().toString());
                String mensagem = message.getText();
                //checarPergunta(mensagem)
                if ((mensagem.contains("bom dia".toLowerCase())) ||
                    (mensagem.contains("boa tarde".toLowerCase()))||
                    (mensagem.contains("boa noite".toLowerCase()))
                   ) {
                    sendMessageRequest.setText("Olá, "+message.getChat().getFirstName()+
                                                " qual é sua duvida?");
                    enviarMensagem(sendMessageRequest);
                }
                else {
                    sendMessageRequest.setText("Não sei responder isso: " + message.getText());
                    enviarMensagem(sendMessageRequest);
                }
         
            }
        }
    }

    public void enviarMensagem(SendMessage sendMessageRequest){
        try {
            sendMessage(sendMessageRequest);
        }catch (TelegramApiException e) {
                    //do some error handling
                }
    }
    
    @Override
    public String getBotUsername() {
        return ChatBot.BOT_USERNAME;
    }
}
