/ *
 * Para alterar esse cabeçalho de licença, escolha Cabeçalhos de licença em Propriedades do projeto.
* Para alterar este arquivo de modelo, escolha Ferramentas | Modelos
 * e abra o modelo no editor.
 * /
package  User_Application ;

import  Models.ModelUrl ;
import  WebSeviceSOAP.Interface_SOAP ;
import  WebSeviceSOAP.Telas.Screen_Register_User ;
import  java.io.ObjectInputStream ;
import  java.io.ObjectOutputStream ;
import  java.net.MalformedURLException ;
import  java.net.ServerSocket ;
import  java.net.Socket ;
import  java.net.URL ;
import  java.util.logging.Level ;
import  java.util.logging.Logger ;
import  javax.xml.namespace.QName ;
import  javax.xml.ws.Service ;

/ **
 *
 * Classe para gerenciamento de chat.
 * /
A  classe  pública Screen_Cliente_Chat  estende  javax.swing . JFrame {

    private  String nomeUser, ipAddresEnviar;
    private  int coduser;

    / **
     * Cria novo formulário
     * /
    pública  Screen_Cliente_Chat ( int  usercode , Cordas  Nome , Cordas  IP ) {
        isso . coduser = usercode;
        isso . nomeUser = nome;
        isso . ipAddresEnviar =  IP ;

        Recebe r =  novo  Recebe (); //
        r . começar();

        initComponents ();
    }

    / **
     * Este método é chamado de dentro do construtor para inicializar o formulário.
     * AVISO: NÃO modifique este código. O conteúdo deste método é sempre
     * regenerado pelo Form Editor.
     * /
    @SuppressWarnings ( " desmarcado " )
    // <editor-fold defaultstate = "colapsado" desc = "Código gerado"> // GEN-BEGIN: initComponents
    private  void  initComponents () {

        jScrollPane2 =  new  javax.swing . JScrollPane ();
        textoChat =  new  javax.swing . JTextArea ();
        textoEnviar =  new  javax.swing . JTextField ();
        enviar =  new  javax.swing . JButton ();
        Sair  =  new  javax.swing . JButton ();

        setDefaultCloseOperation ( javax.swing . WindowConstants . EXIT_ON_CLOSE );

        textoChat . setEditable ( false );
        textoChat . setColumns ( 20 );
        textoChat . setRows ( 5 );
        jScrollPane2 . setViewportView (textoChat);

        textoEnviar . addActionListener ( new  java.awt.event . ActionListener () {
            public  void  actionPerformed ( java.awt.event . ActionEvent  evt ) {
                textoEnviarActionPerformed (evt);
            }
        });

        enviar . setText ( " Enviar " );
        enviar . addActionListener ( new  java.awt.event . ActionListener () {
            public  void  actionPerformed ( java.awt.event . ActionEvent  evt ) {
                enviarActionPerformed (evt);
            }
        });

        Sair . setText ( " Sair " );
        Sair . addActionListener ( new  java.awt.event . ActionListener () {
            public  void  actionPerformed ( java.awt.event . ActionEvent  evt ) {
                SairActionPerformed (evt);
            }
        });

        javax.swing . Layout de GroupLayout =  novo  javax.swing . GroupLayout (getContentPane ());
        getContentPane () . setLayout (layout);
        layout . setHorizontalGroup (
            layout . createParallelGroup ( javax.swing . GroupLayout . Alinhamento . LÍDER )
            .addGroup (layout . createSequentialGroup ()
                .addGap ( 19 , 19 , 19 )
                .addGroup (layout . createParallelGroup ( javax.swing . GroupLayout . Alinhamento . LEADING )
                    .addComponent (jScrollPane2)
                    .addGroup (layout . createSequentialGroup ()
                        .addComponent (textoEnviar, javax.swing . GroupLayout . PREFERRED_SIZE , 564 , javax.swing . GroupLayout . PREFERRED_SIZE )
                        .addPreferredGap ( javax.swing . LayoutStyle . ComponentPlacement . RELATED )
                        .addComponent (enviar, javax.swing . GroupLayout . PREFERRED_SIZE , 64 , javax.swing . GroupLayout . PREFERRED_SIZE )
                        .addPreferredGap ( javax.swing . LayoutStyle . ComponentPlacement . RELACIONADO , javax.swing . GroupLayout . DEFAULT_SIZE , Short . MAX_VALUE )
                        .addComponent ( Sair , javax.swing . GroupLayout . PREFERRED_SIZE , 63 , javax.swing . GroupLayout . PREFERRED_SIZE )))
                .addContainerGap ())
        );
        layout . setVerticalGroup (
            layout . createParallelGroup ( javax.swing . GroupLayout . Alinhamento . LÍDER )
            .addGroup (layout . createSequentialGroup ()
                .addContainerGap ()
                .addComponent (jScrollPane2, javax.swing . GroupLayout . DEFAULT_SIZE , 237 , Curta . MAX_VALUE )
                .addPreferredGap ( javax.swing . LayoutStyle . ComponentPlacement . NÃO RELACIONADO )
                .addGroup (layout . createParallelGroup ( javax.swing . GroupLayout . Alinhamento . LEADING )
                    .addComponent ( Sair , javax.swing . GroupLayout . Alinhamento . TRAILING , javax.swing . GroupLayout . DEFAULT_SIZE , javax.swing . GroupLayout . DEFAULT_SIZE , Short . MAX_VALUE )
                    .addGroup (layout . createSequentialGroup ()
                        .addComponent (enviar, javax.swing . GroupLayout . PREFERRED_SIZE , 30 , javax.swing . GroupLayout . PREFERRED_SIZE )
                        .addGap ( 0 , 0 , Short . MAX_VALUE ))
                    .addComponent (textoEnviar))
                .addContainerGap ())
        );

        pacote();
    } // </ editor-fold> // GEN-END: initComponents

    public  class  Recebe  extends  Thread {

        public  Recebe () {
            isso . setName ( " T_Recebe " );
        }

        public  void  run () {

            try {

                Servidor ServerSocket =  novo  ServerSocket ( 56789 );
                Sistema . fora . println ( " Servidor ouvindo a porta 56789 " );
                while ( true ) {

                    Soquete cliente = servidor . aceitar();
                    ObjectInputStream entrada =  new  ObjectInputStream (cliente . GetInputStream ());
                    String aux = ( string ) de entrada . readObject ();

                    Sistema . fora . println (textoChat . getText ());

                    textoChat . setText (textoChat . getText () + aux +  " \ n " );
                    // System.out.println ("Screen_Cliente_Chaticado:" + cliente.getInetAddress (). GetHostAddress ());

                    cliente . fechar();

                }
            } catch ( exceção e) {
                Sistema . fora . println ( " Erro: "  + e . getMessage ());
            }

        }
    }

    privada  vazio  SairActionPerformed ( java.awt.event . ActionEvent  evt ) { // GEN-PRIMEIRO: event_SairActionPerformed
        URL url =  null ;
        try {
            ModelUrl s =  new  ModelUrl ();
            url =  novo  URL ( s . GetAux () +  " ? wsdl " );
        } catch ( MalformedURLException ex) {
            Logger . getLogger ( Screen_Register_User . class . getName ()) . log ( Nível . GRAVE , nulo , ex);
        }
        QName qname =  novo  QName ( " http: // WebSeviceSOAP / " , " Implements_SOAPService " );
        Serviço ws =  serviço . create (url, qname);
        Interface_SOAP inter = ws . getPort ( Interface_SOAP . classe);
        inter . ExcluirChatOnline (coduser);
        dispor ();
    } // GEN-LAST: event_SairActionPerformed

    private  void  enviarActionPerformed ( java.awt.event . ActionEvent  evt ) { // GEN-PRIMEIRO: event_enviarActionPerformed

        String enviado =  new  String (textoEnviar . GetText ());
        if (enviar . length () ==  0 ) {
            retorno ;
        }

        textoChat . setText (textoChat . getText () + nomeUser +  " -> "  + enviar +  " \ n " );

        try {
            Soquete cliente =  novo  soquete (ipAddresEnviar, 56789 );
            ObjectOutputStream saida =  novo  ObjectOutputStream (cliente . GetOutputStream ());
            saida . rubor();
            saida . writeObject (nomeUser +  " -> "  + enviar);

            Sistema . fora . println ( " Enviou " );
        } catch ( exceção e) {
            Sistema . fora . println ( " Erro: "  + e . getMessage ());
        }

    } // GEN-LAST: event_enviarActionPerformed

    private  void  textoEnviarActionPerformed ( java.awt.event . ActionEvent  evt ) { // GEN-PRIMEIRO: event_textoEnviarActionPerformed
        // TODO adicione seu código de manipulação aqui:
    } // GEN-LAST: event_textoEnviarActionPerformed

    / **
     * @param args os argumentos da linha de comando
     * /
    public  static  void  main ( args de seqüência de caracteres  []) {
        / * Defina o visual e a sensação do Nimbus * /
        // <editor-fold defaultstate = "collapsed" desc = "Aparência e configuração do código (opcional)">
        / * Se o Nimbus (introduzido no Java SE 6) não estiver disponível, mantenha a aparência padrão.
         * Para detalhes, consulte http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         * /
        try {
            para ( javax.swing . UIManager . LookAndFeelInfo info :  javax.swing . UIManager . getInstalledLookAndFeels ()) {
                if ( " Nimbus " . é igual a (info . getName ())) {
                    javax.swing . UIManager . setLookAndFeel (info . getClassName ());
                    pausa ;
                }
            }
        } catch ( ClassNotFoundException ex) {
            java.util.logging . Logger . getLogger ( Screen_Cliente_Chat . classe . getName ()) . log ( java.util.logging . Level . SEVERE , nulo , ex);
        } catch ( InstantiationException ex) {
            java.util.logging . Logger . getLogger ( Screen_Cliente_Chat . classe . getName ()) . log ( java.util.logging . Level . SEVERE , nulo , ex);
        } catch ( IllegalAccessException ex) {
            java.util.logging . Logger . getLogger ( Screen_Cliente_Chat . classe . getName ()) . log ( java.util.logging . Level . SEVERE , nulo , ex);
        } catch ( javax.swing . UnsupportedLookAndFeelException ex) {
            java.util.logging . Logger . getLogger ( Screen_Cliente_Chat . classe . getName ()) . log ( java.util.logging . Level . SEVERE , nulo , ex);
        }
        // </ editor-fold>
        // </ editor-fold>
        // </ editor-fold>
        // </ editor-fold>

        / * Crie e exiba o formulário * /
        java.awt . EventQueue . invokeLater ( new  Runnable () {
            public  void  run () {
                novo  Screen_Cliente_Chat ( 123 , " Diego " , " 192.168.2.144 " ) . setVisible ( true );
            }
        });
    }

    // Declaração de variáveis ​​- não modifique // GEN-BEGIN: variáveis
    private  javax.swing . JButton  Sair ;
    private  javax.swing . JButton enviar;
    private  javax.swing . JScrollPane jScrollPane2;
    private  javax.swing . JTextArea textoChat;
    private  javax.swing . JTextField textoEnviar;
    // Fim da declaração de variáveis ​​// GEN-END: variáveis
}
