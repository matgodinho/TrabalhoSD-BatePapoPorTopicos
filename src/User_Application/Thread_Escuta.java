/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_Application;

import Models.ModelUrl;
import WebSeviceSOAP.Interface_SOAP;
import WebSeviceSOAP.Telas.Screen_Register_User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import jdbc.ConnectionFactory;

/**
 *
 * Thread que vai ficar ouvindo quando um user quiser iniciar chat com outro
 */
class Thread_Escuta extends Thread {

    private int codusuario;

    //private int cont;
    public Thread_Escuta(int coduser) {
        this.setName("T_Escuta");
        codusuario = coduser;
    }

    public String getNomeUser() {
        Connection conexao = new ConnectionFactory().getConnection();// funcao para abrir conexao com banco
        String retorno = new String();
        String sql = "select nome from usuario where codusuario = ?";

        try {
            PreparedStatement st = conexao.prepareStatement(sql);

            String aux = "" + codusuario;
            st.setInt(1, codusuario);

            ResultSet result = st.executeQuery();
            result.next();
            retorno = result.getString("nome");
            result.close();
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //System.out.println("reto tred" + retorno);
        return retorno;
    }

    public void run() {
        Socket s;
        while (true) {

            int porta = 5678;//escuta na porta 5678
            try {
                System.out.println("Receptor exe");
                ServerSocket ss = new ServerSocket(porta);//cria um server socket para ouvir em "porta"
                System.out.println("Aguardando mensagem");

                s = ss.accept();//bloqueia ate receber algo
                ObjectInputStream objle = new ObjectInputStream(s.getInputStream());
                String mensagem = (String) objle.readObject();//le objeto
                System.out.println("Recebeu mensagem");
                System.out.println("Recebido: " + mensagem);

                if (mensagem.substring(0, 3).equals("#@!")) {
                    Screen_Cliente_Chat a = new Screen_Cliente_Chat(codusuario, getNomeUser(), mensagem.substring(3));//intancia um novo cliente(chat)
                    a.setVisible(true);//seta como visivel

                    URL url = null;
                    try {
                        ModelUrl urll = new ModelUrl();
                        url = new URL(urll.GetAux() + "?wsdl");
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(Screen_Register_User.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    QName qname = new QName("http://WebSeviceSOAP/", "Implements_SOAPService");
                    Service ws = Service.create(url, qname);
                    Interface_SOAP inter = ws.getPort(Interface_SOAP.class);
                    
                    inter.ExcluirChatOnline(codusuario);//exclui usuer disposto a conversar

                    s.close();
                    ss.close();
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }

    }
}
