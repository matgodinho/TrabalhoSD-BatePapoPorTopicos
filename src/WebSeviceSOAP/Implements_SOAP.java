/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebSeviceSOAP;

import Models.UserModel;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import jdbc.ConnectionFactory;

@WebService(endpointInterface = "WebSeviceSOAP.Interface_SOAP")
public class Implements_SOAP implements Interface_SOAP, Serializable {

    private static final long serialVersionUID = 12L;
    Connection conexao = new ConnectionFactory().getConnection();// funcao para abrir conexao com banco

    @Override
    public int Incluir(int id, String nome, String Senha, String IPaddres) { // funcao para adicionar usuarios ao banco
        // string que sera enviada ao banco para realizar uma açao
        String sql = "insert into usuario (codusuario,nome,senha,IPaddres)values(?,?,?,?)";

        try {
            PreparedStatement st = conexao.prepareStatement(sql);

            st.setInt(1, id);// coloca "id" no primeiro "?"
            st.setString(2, nome); // coloca "nome" no segundo "?"
            st.setString(3, Senha);
            st.setString(4, IPaddres);// coloca "IPaddres" no terceiro "?"

            st.execute();// executa Statement
            st.close();// fecha Statement
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //System.out.println("zero");
            return 0;
        }
        //System.out.println("um");
        return 1;

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Alterar(int id, String nome,String senha, String IPaddres) {
        // string que sera enviada ao banco para realizar uma açao
        String sql = "update usuario set nome=?,IPaddres=?,senha=? where codusuario=?";

        try {
            PreparedStatement st = conexao.prepareStatement(sql);

            st.setString(1, nome);
            st.setString(2, IPaddres);
            st.setString(3, senha);
            st.setInt(4, id);

            st.execute();
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Excluir(int id) {
        // string que sera enviada ao banco para realizar uma açao
        String sql = "delete from usuario where codusuario=?";

        try {
            PreparedStatement st = conexao.prepareStatement(sql);

            st.setInt(1, id);

            st.execute();
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserModel[] Listar() {//funcao para listar usuarios cadastrados

        int TamanhoVet = 0;

        String sql = "select count(*) from usuario";// string que sera enviada ao banco para realizar uma açao
        //conta quantos usuarios tem cadastrado
        PreparedStatement st;
        try {
            st = conexao.prepareStatement(sql);// prepara conexao
            ResultSet result = st.executeQuery();// executa
            result.next();//avança ao proximo resultado da consulta
            TamanhoVet = result.getInt("count"); // guarda qts users tem cadastrados

            result.close();
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        UserModel ListaUsuarios[] = new UserModel[TamanhoVet];
        
        sql = "select * from usuario";// seleciona todos os users
        
        try {
            int i = 0;
            st = conexao.prepareStatement(sql);// 
            ResultSet result = st.executeQuery();
            while (result.next()) {
                UserModel user = new UserModel();
                user.setId(result.getInt("codusuario"));
                //System.out.println(result.getInt("codusuario"));
                user.setNome(result.getString("nome"));
                //System.out.println(result.getString("nome"));
                user.setSenha(result.getString("senha"));
                //System.out.println(result.getString("senha"));
                user.setIPaddres(result.getString("IPaddres"));
                //System.out.println(result.getString("IPaddres"));
                ListaUsuarios[i] = user;
                i++;
            }
            result.close();
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //System.out.println("saiu for");
        return ListaUsuarios;

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void RegistrarAcesso(int id) { // funçao para ragistrar acesso
        // string que sera enviada ao banco para realizar uma açao
        String sql = "insert into acesso(codacesso,codusuario,DataHora)values(nextval('acesso_codacesso_seq'),?,now())";

        try {
            PreparedStatement st = conexao.prepareStatement(sql);

            st.setInt(1, id);

            st.execute();
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void RegistrarPesquisa(int topico) {

        String sql = "insert into pesquisa (idPesquisa,DataHora,Topico)values(nextval('pesquisa_idPesquisa_seq'),now(),?)";

        try {
            PreparedStatement st = conexao.prepareStatement(sql);

            st.setInt(1, topico);

            st.execute();
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void RegistrarChat(int user1, int user2, int topico) {

        String sql = "insert into chat (codusuario1,codusuario2,DataHora,Topico)values(?,?,now(),?)";

        try {
            PreparedStatement st = conexao.prepareStatement(sql);

            st.setInt(1, user1);
            st.setInt(2, user2);
            st.setInt(3, topico);

            st.execute();
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void RegistrarChatOnline(int codusuario, int topico) {

        String sql = "insert into chatonline(idchat,codusuario,codtopico)values(nextval('chatonline_idchat_seq'),?,?)";

        try {
            PreparedStatement st = conexao.prepareStatement(sql);

            st.setInt(1, codusuario);
            st.setInt(2, topico);

            st.execute();
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ExcluirChatOnline(int codusuario) {

        String sql = "delete from chatonline where codusuario=?";

        try {
            PreparedStatement st = conexao.prepareStatement(sql);

            st.setInt(1, codusuario);

            st.execute();
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
