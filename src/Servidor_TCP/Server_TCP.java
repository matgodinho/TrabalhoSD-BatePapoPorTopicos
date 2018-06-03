/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor_TCP;

import Models.UserModel;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jdbc.ConnectionFactory;

public class Server_TCP {

    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private ObjectInputStream inStream = null;
    private ObjectInputStream inputStream = null;
    private ObjectOutputStream outputStream = null;

    public Server_TCP() {

    }

    public void communicate() {
        Connection conexao = new ConnectionFactory().getConnection();
        int porta = 9875;
        try {
            serverSocket = new ServerSocket(porta);
        } catch (IOException ex) {
            ex.printStackTrace();

        }
        while (true) {
            try {
                socket = serverSocket.accept();
                System.out.println("Connected");
                inStream = new ObjectInputStream(socket.getInputStream());
                String topico = (String) inStream.readObject();

                System.out.println("Topic received = " + topico.substring(0, 1) + " ip: " + topico.substring(1));

                ArrayList<UserModel> ListaUsers = new ArrayList<>();

                int TamanhoVet = 0;

                String sql = "select count(*) from chatonline";
                PreparedStatement st;
                try {
                    st = conexao.prepareStatement(sql);
                    ResultSet result = st.executeQuery();
                    result.next();
                    TamanhoVet = result.getInt("count");

                    result.close();
                    st.close();
                } catch (SQLException e) {

                    e.printStackTrace();
                }
                int aux[] = new int[TamanhoVet];
                int i = 0;
                int topicoBanco = Integer.parseInt(topico.substring(0, 1));

                sql = "select codusuario from chatonline where codtopico=?";

                try {
                    st = conexao.prepareStatement(sql);
                    st.setInt(1, topicoBanco);

                    ResultSet result = st.executeQuery();
                    while (result.next()) {

                        aux[i] = result.getInt("codusuario");
                        i++;
                    }
                    result.close();
                    st.close();
                } catch (SQLException e) {

                    e.printStackTrace();
                }

                sql = "select nome,IPaddres from usuario where codusuario=?";
                for (int j : aux) {

                    try {
                        st = conexao.prepareStatement(sql);
                        st.setInt(1, j);

                        ResultSet result = st.executeQuery();
                        while (result.next()) {

                            UserModel user = new UserModel();

                            user.setId(j);
                            user.setNome(result.getString("nome"));
                            user.setIPaddres(result.getString("IPaddres"));

                            ListaUsers.add(user);//adiciona user a lista

                        }
                        result.close();
                        st.close();
                    } catch (SQLException e) {

                        e.printStackTrace();
                    }

                }

                socket = new Socket(topico.substring(1), 666);

                outputStream = new ObjectOutputStream(socket.getOutputStream());

                outputStream.writeObject(ListaUsers);

                socket.close();

            } catch (SocketException se) {

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException cn) {
                cn.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server_TCP server = new Server_TCP();

        server.communicate();

    }
}
