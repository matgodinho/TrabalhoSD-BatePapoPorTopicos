package User_Application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import twitter4j.Status;

import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class UpdateStatus {

    /**
     * @param args
     *
     */
       
    public void twittar(String mensagem) {


        
        String consumerKey = "kqnnfftTTIB0rMKLNLJTyHJIU";
        String consumerSecret = "5lUElCcG0dWROrMcpR39qanmb1CuWal9kDOVJzihmCy1kHbTBx";
        String twitterToken = "958684207131299840-ypUbt3ALCjXguoi0qMxZKU6atgXmfk6";
        String twitterTokenSecret = "Q1EmcjHbTEYCjSSwAK4FqVuOiBedn1o6vebtLEHzQxxcy";
            
        
        twitter4j.Twitter twitter = new TwitterFactory().getInstance();
      
        twitter.setOAuthConsumer(consumerKey, consumerSecret); // autenticação
        AccessToken accessToken = new AccessToken(twitterToken, twitterTokenSecret); // cria o token
        twitter.setOAuthAccessToken(accessToken); // acessa o token

        try {
            twitter.updateStatus(mensagem);
            System.out.println("Tweet enviado!");
        } catch (TwitterException e) {
            System.out.println("Erro ao enviar o tweet");
        }
    }
}