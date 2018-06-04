/ *
 * Para alterar esse cabeçalho de licença, escolha Cabeçalhos de licença em Propriedades do projeto.
* Para alterar este arquivo de modelo, escolha Ferramentas | Modelos
 * e abra o modelo no editor.
 * /
package  User_Application ;

import  Models.TopicModel ;
import  Models.UserModel ;
import  Models.ModelUrl ;
import  WebSeviceSOAP.Interface_SOAP ;
import  WebSeviceSOAP.Telas.Screen_Register_User ;
import  java.io.IOException ;
import  java.io.ObjectInputStream ;
import  java.io.ObjectOutputStream ;
import  java.net.InetAddress ;
import  java.net.MalformedURLException ;
import  java.net.ServerSocket ;
import  java.net.Socket ;
import  java.net.SocketException ;
import  java.net.URL ;
import  java.sql.Connection ;
import  java.sql.PreparedStatement ;
import  java.sql.ResultSet ;
import  java.sql.SQLException ;
import  java.util.ArrayList ;
import  java.util.logging.Level ;
import  java.util.logging.Logger ;
import  javax.swing.DefaultListModel ;
import  javax.swing.table.DefaultTableModel ;
import  javax.xml.namespace.QName ;
import  javax.xml.ws.Service ;
import  jdbc.ConnectionFactory ;


 * /
A  classe  pública Screen_SelectChat  estende  javax.swing . JFrame {
    private  int coduser;
     soquete de soquete privado =  nulo ;
    private  ObjectOutputStream outputStream =  null ;
    / **
     * Cria novo formulário Screen_SelectChat
     * /
     Screen_SelectChat público ( int  cod ) {
        initComponents (); // inicia componetes (gerado pelo netbens)
          
        coduser = cod;
        Conexão conexao =  new  ConnectionFactory () . getConnection (); // usado para estabelecer conexão com o banco
        
        ArrayList < TopicModel >  ListaTopicos  =  novo  ArrayList <> (); // vetor para guardar topicos
                // string que sera ao banco para realizar uma açao
		String sql =  " selecione * dos topicos " ;
		PreparedStatement st;
		try {
			st = conexao . prepareStatement (sql);
			Resultado ResultSet = st . executeQuery (); // sql sql no banco e guarda em resultado
			while (resultado . next ()) {
				Tópico TopicModel =  new  TopicModel ();
				tópico . setCodtopico (resultado . getInt ( " codtopico " )); // pega bacalhau do topico da coluna codtopico
                                // System.out.println (result.getInt ("codusuario"));
				tópico . setTopico (resultado . getString ( " topico " )); // pega descricao do topico da coluna topico
                                // System.out.println (result.getString ("nome"));
				ListaTopicos . adicionar (tópico); // adicionar topico na lista
			}
			resultado . fechar();
			st . fechar();
		} catch ( SQLException e) {
			// TODO Bloco catch gerado automaticamente
			e . printStackTrace ();
		}
        DefaultListModel lista =  new  DefaultListModel (); // modelo para lista
        jList1 . setModel (lista); // atribui como modelo para jlist1 "lista"
                       
        para ( TopicModel ref :  ListaTopicos ) { // Clique aqui para ver mais
            
            lista . add (lista . getSize (), ref . getTopico ());
        }
               
    }

    / **
     * Este método é chamado de dentro do construtor para inicializar o formulário.
     * AVISO: NÃO modifique este código. O conteúdo deste método é sempre
     * regenerado pelo Form Editor.
     * /
    @SuppressWarnings ( " desmarcado " )
    // <editor-fold defaultstate = "colapsado" desc = "Código gerado"> // GEN-BEGIN: initComponents
    private  void  initComponents () {

        jScrollPane1 =  new  javax.swing . JScrollPane ();
        jList1 =  new  javax.swing.JList <> ();
        jLabel1 =  novo  javax.swing . JLabel ();
        jButton1 =  novo  javax.swing . JButton ();
        jLabel2 =  new  javax.swing . JLabel ();
        jButton2 =  novo  javax.swing . JButton ();
        jScrollPane3 =  new  javax.swing . JScrollPane ();
        jTable1 =  new  javax.swing . JTable ();
        jButton3 =  new  javax.swing . JButton ();

        setDefaultCloseOperation ( javax.swing . WindowConstants . EXIT_ON_CLOSE );

        jList1 . setSelectionMode ( javax.swing . ListSelectionModel . SINGLE_SELECTION );
        jScrollPane1 . setViewportView (jList1);

        jLabel1 . setFont ( new  java.awt . Font ( " Tahoma " , 1 , 18 )); // NOI18N
        jLabel1 . setText ( " Tópicos " );

        jButton1 . setText ( " Pesquisar " );
        jButton1 . addActionListener ( new  java.awt.event . ActionListener () {
            public  void  actionPerformed ( java.awt.event . ActionEvent  evt ) {
                jButton1ActionPerformed (evt);
            }
        });

        jLabel2 . setFont ( new  java.awt . Font ( " Tahoma " , 1 , 18 )); // NOI18N
        jLabel2 . setText ( " Usuários " );

        jButton2 . setText ( " Iniciar chat " );
        jButton2 . addActionListener ( new  java.awt.event . ActionListener () {
            public  void  actionPerformed ( java.awt.event . ActionEvent  evt ) {
                jButton2ActionPerformed (evt);
            }
        });

        jTable1 . setModel ( new  javax.swing.table . DefaultTableModel (
            novo  objeto [] [] {

            }
            nova  string [] {
                " Código Usuario " , " Nome " , " IPAddres "
            }
        ));
        jScrollPane3 . setViewportView (jTable1);

        jButton3 . setText ( " Sair " );
        jButton3 . addActionListener ( new  java.awt.event . ActionListener () {
            public  void  actionPerformed ( java.awt.event . ActionEvent  evt ) {
                jButton3ActionPerformed (evt);
            }
        });

        javax.swing . Layout de GroupLayout =  novo  javax.swing . GroupLayout (getContentPane ());
        getContentPane () . setLayout (layout);
        layout . setHorizontalGroup (
            layout . createParallelGroup ( javax.swing . GroupLayout . Alinhamento . LÍDER )
            .addGroup (layout . createSequentialGroup ()
                .addGroup (layout . createParallelGroup ( javax.swing . GroupLayout . Alinhamento . LEADING )
                    .addGroup (layout . createSequentialGroup ()
                        .addGap ( 65 , 65 , 65 )
                        .addComponent (jLabel1)
                        .addGap ( 294 , 294 , 294 )
                        .addComponent (jLabel2))
                    .addGroup (layout . createSequentialGroup ()
                        .addGap ( 22 , 22 , 22 )
                        .addGroup (layout . createParallelGroup ( javax.swing . GroupLayout . Alinhamento . LEADING , false )
                            .addComponent (jButton1, javax.swing . GroupLayout . DEFAULT_SIZE , 174 , Short . MAX_VALUE )
                            .addComponent (jScrollPane1, javax.swing . GroupLayout . PREFERRED_SIZE , 0 , Short . MAX_VALUE ))
                        .addGap ( 76 , 76 , 76 )
                        .addGroup (layout . createParallelGroup ( javax.swing . GroupLayout . Alinhamento . LEADING )
                            .addComponent (jScrollPane3, javax.swing . GroupLayout . PREFERRED_SIZE , 407 , javax.swing . GroupLayout . PREFERRED_SIZE )
                            .addGroup (layout . createSequentialGroup ()
                                .addComponent (jButton2, javax.swing . GroupLayout . PREFERRED_SIZE , 198 , javax.swing . GroupLayout . PREFERRED_SIZE )
                                .addPreferredGap ( javax.swing . LayoutStyle . ComponentPlacement . NÃO RELACIONADO )
                                .addComponent (jButton3, javax.swing . GroupLayout . PREFERRED_SIZE , 199 , javax.swing . GroupLayout . PREFERRED_SIZE )))))
                .addContainerGap ( 29 , Short . MAX_VALUE ))
        );
        layout . setVerticalGroup (
            layout . createParallelGroup ( javax.swing . GroupLayout . Alinhamento . LÍDER )
            .addGroup (layout . createSequentialGroup ()
                .addContainerGap ()
                .addGroup (layout . createParallelGroup ( javax.swing . GroupLayout . Alinhamento . BASELINE )
                    .addComponent (jLabel1)
                    .addComponent (jLabel2))
                .addPreferredGap ( javax.swing . LayoutStyle . ComponentPlacement . RELATED )
                .addGroup (layout . createParallelGroup ( javax.swing . GroupLayout . Alinhamento . LEADING , false )
                    .addComponent (jScrollPane3, javax.swing . GroupLayout . PREFERRED_SIZE , 0 , Short . MAX_VALUE )
                    .addComponent (jScrollPane1, javax.swing . GroupLayout . DEFAULT_SIZE , 301 , Short . MAX_VALUE ))
                .addPreferredGap ( javax.swing . LayoutStyle . ComponentPlacement . RELATED )
                .addGroup (layout . createParallelGroup ( javax.swing . GroupLayout . Alinhamento . LEADING , false )
                    .addComponent (jButton1, javax.swing . GroupLayout . DEFAULT_SIZE , 35 , Short . MAX_VALUE )
                    .addComponent (jButton2, javax.swing . GroupLayout . DEFAULT_SIZE , javax.swing . GroupLayout . DEFAULT_SIZE , Short . MAX_VALUE )
                    .addComponent (jButton3, javax.swing . GroupLayout . DEFAULT_SIZE , javax.swing . GroupLayout . DEFAULT_SIZE , Short . MAX_VALUE ))
                .addContainerGap ( 29 , Short . MAX_VALUE ))
        );

        pacote();
    } // </ editor-fold> // GEN-END: initComponents
    
    public  class  Client { // classe que comunica com o servidor tcp

         soquete de soquete privado =  nulo ;
        private  ObjectInputStream inputStream =  null ;
        private  ObjectOutputStream outputStream =  null ;
        // private boolean isConnected = false;
        private  ServerSocket serverSocket =  nulo ;
        private  ObjectInputStream inStream =  null ;
        

        public  Client () {

        }

        public  ArrayList < UserModel >  comunicar ( int  topico ) {
            ArrayList < UserModel >  ListaUsers  =  new  ArrayList <> (); // guarda uma lista de usuários de determinado topico
            
                try {
                    int porta =  9875 ; // porta do sevidor tcp
                    socket =  new  Socket ( " localHost " , porta); // trocarte localhost por servidor IP tcp
                    // System.out.println ("Connected");
                    // isConnected = true;
                    outputStream =  new  ObjectOutputStream (soquete . getOutputStream ());
                    // Estudante estudante = novo aluno (1, "Bijoy");
                    // System.out.println ("Objeto a ser escrito =" + topico);
                    
                    // envia string com topico eo ip local para o servidor tcp
                    outputStream . writeObject ( " " + topico +  InetAddress . getLocalHost () . getHostAddress ());
                    
                                        
                    serverSocket =  new  ServerSocket ( 666 ); // espera respos do servidor tcp
                    socket = serverSocket . aceitar();
                    Sistema . fora . println ( " Conectado " );
                    inStream =  new  ObjectInputStream (soquete . getInputStream ()); // guarda o input
                    
                    ListaUsers  = ( ArrayList < UserModel > ) inStream . readObject (); // le objeto e guarda na lista
                    
                    // user = ListaUsers.get (0);
                    // System.out.println ("Objeto recebido =" + user.getNome ());
                    
                    serverSocket . fechar();
                    soquete . fechar();                
                } catch ( SocketException se) {
                    se . printStackTrace ();
// System.exit (0);
                } catch ( IOException e) {
                    e . printStackTrace ();
                } catch ( ClassNotFoundException ex) {
                    Logger . getLogger ( Screen_SelectChat . class . getName ()) . log ( Nível . GRAVE , nulo , ex);
                }
            
            retorno  ListaUsers ; // retorna a lista
        }
    }
   
    privada  vazio  jButton1ActionPerformed ( java.awt.event . ActionEvent  evt ) { // GEN-PRIMEIRO: event_jButton1ActionPerformed
        // TODO adicione seu código de manipulação aqui:
       int topico = jList1 . getSelectedIndex (); // pega o indice do topico selecionado
       
       ArrayList < UserModel >  ListaUsers  =  new  ArrayList <> (); // cria uma lista de usuarios
       Cliente cliente =  novo  cliente (); // intancia um novo cliente
       
       ListaUsers  = cliente . comunicar (topico + 1 ); // chama funcao comunicar q se comunica com
       // o servidor tcp e retorna uma lista de usuário pronto um conversar com tal assunto
       
       DefaultTableModel modelo =  new  DefaultTableModel (); // define o modelo da tabela
       
        modelo . addColumn ( " Código Usuario " ); // nomeia colunas
        modelo . addColumn ( " Nome " );
        modelo . addColumn ( " endereço IP " );
       
       para ( UserModel utilizador : ListaUsers ) {
           // escreve na tabela como informacoes de usuario
           modelo . addRow ( new  String [] { " " + usuário . getId (), usuário . getNome (), usuário . getIPaddres ()});
           
       }
       jTable1 . setModel (modelo);  // definir modelo a jTable1            
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
            inter . RegistrarPesquisa (topico + 1 ); // solicitar ao serviço web SOAP para registrar uma pesquisa
       
        
    } // GEN-LAST: event_jButton1ActionPerformed

    privada  vazio  jButton3ActionPerformed ( java.awt.event . ActionEvent  evt ) { // GEN-PRIMEIRO: event_jButton3ActionPerformed
        // TODO adicione seu código de manipulação aqui:
        
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
            inter . ExcluirChatOnline (coduser); // solicitar ao serviço web SOAP para excluir usuário disposto a conversar     
        dispor ();
    } // GEN-LAST: event_jButton3ActionPerformed
    
    public  String  getNomeUser () { / / funcao para a pesquisa de usuario
        Conexão conexao =  new  ConnectionFactory () . getConnection (); // funcao para abrir conexao com banco
        String de retorno =  new  String ();
        String sql =  " selecione o nome do usuario onde codusuario =? " ;
		
		try {
			PreparedStatement st = conexão . prepareStatement (sql);
			                 
			st . setInt ( 1 , coduser);
			
                        Resultado ResultSet = st . executeQuery ();
                        resultado . Próximo();
                        retorno = resultado . getString ( " nome " );
			resultado . fechar();
			st . fechar();
		} catch ( SQLException e) {
			// TODO Bloco catch gerado automaticamente
			e . printStackTrace ();
		}
                // System.out.println ("retorno selec");
        retorno retorno;
    }
    
    privada  vazio  jButton2ActionPerformed ( java.awt.event . ActionEvent  evt ) { // GEN-PRIMEIRO: event_jButton2ActionPerformed
        // TODO adicione seu código de manipulação aqui:
        int row = jTable1 . getSelectedRow (); // pega uma linha da tabela selecionada
        Cadeia ipDestino = jTable1 . getValueAt (linha, 2 ) . para sequenciar(); // pega ip do usuário selecionado
        
        try {
        socket =  new  Socket (ipDestino, 5678 ); // pra quem você mandar eq porta
        // System.out.println ("Connected");
        Sistema . fora . println ( " Destino é = "  + ipDestino);
               
        outputStream =  new  ObjectOutputStream (soquete . getOutputStream ());
        
        outputStream . writeObject ( " # @! " + InetAddress . getLocalHost () . getHostAddress () . toString ()); // oq vou mandar
        
        Screen_Cliente_Chat a =  new  Screen_Cliente_Chat (codificador, getNomeUser (), ipDestino); // instancio um novo chat para iniciar
        a . setVisible ( true ); // seta como visivel
                
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
            inter . RegistrarChat (coduser, Integer . ParseInt (jTable1 . GetValueAt (linha, 0 ) . ToString ()), jList1 . GetSelectedIndex () + 1 );
            inter . ExcluirChatOnline (coduser); // exclui usuer disposto a conversar
        } catch ( IOException e) {
            e . printStackTrace ();
        }
    } // GEN-LAST: event_jButton2ActionPerformed

    
    / **
     * @param args os argumentos da linha de comando
     * /


    // Declaração de variáveis ​​- não modifique // GEN-BEGIN: variáveis
    private  javax.swing . JButton jButton1;
    private  javax.swing . JButton jButton2;
    private  javax.swing . JButton jButton3;
    private  javax.swing . JLabel jLabel1;
    private  javax.swing . JLabel jLabel2;
    privado  javax.swing.JList < string > jList1;
    private  javax.swing . JScrollPane jScrollPane1;
    private  javax.swing . JScrollPane jScrollPane3;
    private  javax.swing . JTable jTable1;
    // Fim da declaração de variáveis ​​// GEN-END: variáveis
}
