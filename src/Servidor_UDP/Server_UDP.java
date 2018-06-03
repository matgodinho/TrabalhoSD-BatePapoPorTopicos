/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor_UDP;

import Models.UserTopicModel;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.ConnectionFactory;

public class Server_UDP {

    DatagramSocket socket = null;
    static final int porta = 1233;

    public Server_UDP() {

    }

    public void createSocket() {
        try {
            socket = new DatagramSocket(porta);
            byte[] incomingData = new byte[1024];
            Connection conexao = new ConnectionFactory().getConnection();
            boolean codUserOK = false, codTopicOK = false, key = false;
            do {
                DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
                socket.receive(incomingPacket);
                byte[] data = incomingPacket.getData();
                ByteArrayInputStream in = new ByteArrayInputStream(data);
                ObjectInputStream is = new ObjectInputStream(in);
                try {
                    UserTopicModel topic = (UserTopicModel) is.readObject();
                    System.out.println("user object received = "
                            + topic.getCodusuario() + " - "
                            + topic.getSenha() + " - "
                            + topic.getCodtopico());

                    String sql = "select * from usuario";

                    PreparedStatement st;
                    try {
                        st = conexao.prepareStatement(sql);
                        ResultSet result = st.executeQuery();

                        while (result.next()) {

                            if (result.getInt("codusuario") == topic.getCodusuario() && result.getString("senha").equals(topic.getSenha())) {
                                key = true;
                                codUserOK = true;
                                break;
                            }
                        }
                        sql = "select * from topicos";
                        st = conexao.prepareStatement(sql);
                        result = st.executeQuery();
                        while (result.next()) {
                            if (result.getInt("codtopico") == topic.getCodtopico()) {

                                codTopicOK = true;
                                break;
                            }
                        }
                        result.close();
                        st.close();
                    } catch (SQLException e) {

                        e.printStackTrace();
                    }

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                String reply = new String();

                InetAddress IPAddress = incomingPacket.getAddress();
                int port = incomingPacket.getPort();

                if (!codTopicOK) {
                    reply = "1";
                }

                if (!codUserOK) {
                    reply = "2";
                }
                if (codUserOK && codTopicOK && key) {
                    reply = "3";
                }

                System.out.println(reply);
                System.out.println(reply.getBytes());
                byte replyBytea[] = reply.getBytes();

                DatagramPacket replyPacket = new DatagramPacket(replyBytea, replyBytea.length, IPAddress, port);
                socket.send(replyPacket);

                codUserOK = false;
                codTopicOK = false;
                key = false;
            } while (true);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        Server_UDP server = new Server_UDP();
        server.createSocket();

    }
}
