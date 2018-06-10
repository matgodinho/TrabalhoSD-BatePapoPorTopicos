/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CriarTabelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.print.DocFlavor;
import jdbc.ConnectionFactory;


public class InstanciarTabelas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Tabelas tabelas = new Tabelas();
        
        tabelas.criaTabelaUsuario();
        tabelas.criaTabelaAcesso();
        tabelas.criaTabelaChat();
        tabelas.criaTabelaPesquisa();
        tabelas.criaTabelaTopicos();
        tabelas.criaTabelaChatOnline();
                 
       //1 – Eleições 2018                    5 – Aposentadoria
       //2 – Segurança pública                6 – Traição
       //3 – Preço da gasolina                7 – Multas de trânsito
       //4 – Sistema nacional de saúde        8 – Educação
        ArrayList<String> list= new ArrayList<>();
        
        list.add("Eleições 2018");
        list.add("Segurança pública");
        list.add("Preço da gasolina");
        list.add("Sistema nacional de saúde");
        list.add("Aposentadoria");
        list.add("Traição");
        list.add("Multas de trânsito");
        list.add("Educação");
        int i=1;
        Connection conexao = new ConnectionFactory().getConnection();
        for (String s : list) {

            String sql = "insert into topicos (codtopico,topico)values(?,?)";

            try {
                PreparedStatement st = conexao.prepareStatement(sql);

                st.setInt(1, i);// coloca "id" no primeiro "?"
                st.setString(2, s); // coloca "nome" no segundo "?"

                st.execute();// executa Statement
                st.close();// fecha Statement
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            i++;
        }
    }
}
