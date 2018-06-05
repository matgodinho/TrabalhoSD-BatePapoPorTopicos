/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_Application;

import Models.ModelUrl;
import Models.TopicModel;
import Models.UserTopicModel;
import WebSeviceSOAP.Interface_SOAP;
import WebSeviceSOAP.Telas.Screen_Register_User;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import jdbc.ConnectionFactory;

public class Screen_User extends javax.swing.JFrame {

    /**
     * Creates new form Screen_User
     */
    public Screen_User() {
        initComponents();
        Connection conexao = new ConnectionFactory().getConnection();//faz conexao com o banco
        
        ArrayList<TopicModel> ListaTopicos = new ArrayList<>(); //vetor q guarda os topicos
                // string que sera enviada ao banco para realizar uma açao
		String sql = "select * from topicos";
		PreparedStatement st;
		try {
			st = conexao.prepareStatement(sql);
			ResultSet result = st.executeQuery();//executa "sql" e guarda resultado em result
			while (result.next()){
				TopicModel topic= new TopicModel();
				topic.setCodtopico(result.getInt("codtopico"));
                                //System.out.println(result.getInt("codusuario"));
				topic.setTopico(result.getString("topico"));
                                //System.out.println(result.getString("nome"));
				ListaTopicos.add(topic);//add topico a lista
			}
			result.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        DefaultListModel lista = new DefaultListModel();//cria um modelo de lista padrao
        jList2.setModel(lista);//seta jlist2 com o modelo padrao
                       
        for (TopicModel ref : ListaTopicos) {//percorre o vetor de topicos e coloca cada topico
            //numa linha da lista
            
            lista.add(lista.getSize(), ref.getTopico());
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JButton();
        Text_codUser = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        Text_codUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_codUserActionPerformed(evt);
            }
        });

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Usuário :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tópicos:");

        jScrollPane2.setViewportView(jList2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Senha:");

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Text_codUser)
                    .addComponent(jScrollPane2)
                    .addComponent(jPasswordField1))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_codUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Text_codUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_codUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_codUserActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();//ao pressionar botao sair fecha a tela
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public int createAndListenSocket(int codUser,String senha, int codTopic) {
        //envia usuario e topicos para o server UDP validar a solicitacao
        DatagramSocket Socket;
        String response = "";
        try {
            int porta = 1233; // porta do server udp
            Socket = new DatagramSocket();//socket udp
            InetAddress IPAddress = InetAddress.getByName("LCI-9-05");//trocar por IP do server udp
            byte[] incomingData = new byte[1024];//vetor de bytes q vai armazenar o que quero enviar
            
            UserTopicModel userTopicModel = new UserTopicModel(codUser,senha,codTopic);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(outputStream);//
            os.writeObject(userTopicModel);//escreve user, senha e topico 
            
            byte[] data = outputStream.toByteArray();//
            DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, porta);//monta o pacote
            Socket.send(sendPacket);//envia
            //System.out.println("Message sent from client");
            DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);//pacote para receber a resposta
            Socket.receive(incomingPacket);//recebe a resposta
            response = new String(incomingPacket.getData());//extrai os dados da resposta
            //System.out.println("Response from server" + response + "oi"); debug
            //Thread.sleep(2000);debug
            //System.out.println("corte " + response.substring(0, 1) + " oi");debug
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int convert = Integer.parseInt(response.substring(0, 1));//converte a resposta pra inteiro
        //System.out.println("convertido " + convert);
        return convert;//retorna o inteiro
    }
    
    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
        
        int codtopico[];//vetor para guardar topicos
        int codusuario = Integer.parseInt(Text_codUser.getText());//pega o cod de usuario e converte para int
        String senha = new String(jPasswordField1.getPassword());//pega a senha do campo senha
        
        boolean loginAccept = false;//controle de validade de login
        int s[] = new int[8];
        codtopico = jList2.getSelectedIndices();//atribui os indices selecionados n lista
        
        if(jList2.getSelectedIndex()== -1){
            JOptionPane.showMessageDialog(null,"Selecione ao menos 1(um) tópico!! ");
            return;
        }
        int k =0;       
        for (int i : codtopico) {
            //System.out.println("aki");debug
            Screen_User client = new Screen_User();
            s[k]=client.createAndListenSocket(codusuario,senha,i+1); //guarda respostas do server UDP
            //System.out.println(s[k]);
            k++;
        }
        
        for(int ss: s ){
            System.out.println(ss + " ");
//            if(ss == 0)
//            {
//              JOptionPane.showMessageDialog(null,"Senha incorreta! ");
//              loginAccept = false;
//              break;
//            }
            if(ss == 1)
            {
              JOptionPane.showMessageDialog(null,"Topico não encontrado! ");
              loginAccept = false;
              break;
            }
            if(ss == 2){
              JOptionPane.showMessageDialog(null,"Usuario ou Senha inválido(s) ");
              loginAccept = false;
              break;
            }
            if(ss ==3){
             loginAccept = true;                     
            }
        }
        
        if (loginAccept) {// se CodUser e topicos validos...

            URL url = null;
            try {
                ModelUrl ss = new ModelUrl();
                url = new URL(ss.GetAux()+"?wsdl");
            } catch (MalformedURLException ex) {
                Logger.getLogger(Screen_Register_User.class.getName()).log(Level.SEVERE, null, ex);
            }
            QName qname = new QName("http://WebSeviceSOAP/", "Implements_SOAPService");
            Service ws = Service.create(url, qname);
            Interface_SOAP inter = ws.getPort(Interface_SOAP.class);
            inter.RegistrarAcesso(codusuario);// pede ao web service SOAP para registrar um acesso
            for(int j: codtopico){
            
                inter.RegistrarChatOnline(codusuario, j+1);// registra os topicos na tabela chatonline
                
            }
            
            dispose();
        Screen_SelectChat z = new Screen_SelectChat(codusuario);//instancia tela de seleçao de chat se td ok
        z.setVisible(true);//seta como visivel
        
        Thread_Escuta x = new Thread_Escuta(codusuario);//instancia thread escuta
        x.start();//inicia thread
        
        }
        
        
    }//GEN-LAST:event_LoginActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Screen_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Screen_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Screen_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Screen_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Screen_User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JTextField Text_codUser;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    //@Override
    //public void run() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
}
