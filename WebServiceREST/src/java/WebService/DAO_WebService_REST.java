/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Diego
 */
public class DAO_WebService_REST implements Interface_REST{
    
    public int getAcessos(String dataInicial,String dataFinal)
    {
        //2018/05/03 02:30:00.000
        
        //20180503023000000
                                             //2018                             05                              03 02                           30                              00
        String inicial = dataInicial.substring(0, 4)+"/"+dataInicial.substring(4, 6)+"/"+dataInicial.substring(6, 8)+" "+dataInicial.substring(8,10)+":"+dataInicial.substring(10, 12)+":"+dataInicial.substring(12, 14)+"."+dataInicial.substring(14,17);
        String fim = dataFinal.substring(0, 4)+"/"+dataFinal.substring(4, 6)+"/"+dataFinal.substring(6, 8)+" "+dataFinal.substring(8,10)+":"+dataFinal.substring(10, 12)+":"+dataFinal.substring(12, 14)+"."+dataFinal.substring(14,17);
        
        int retorno = 0;
        try {
            Connection conexao = new ConnectionFactory().getConnection();
            
            String sql = "select count(*)from acesso where datahora between '"+inicial+"' and '"+fim+"'";
            PreparedStatement st = conexao.prepareStatement(sql);
            
            ResultSet result = st.executeQuery();// executa
            result.next();//avança ao proximo resultado da consulta
            retorno = result.getInt("count");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_WebService_REST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public int[] getTopicos_Acessados(String dataInicial, String dataFinal) {
        
        String inicial = dataInicial.substring(0, 4)+"/"+dataInicial.substring(4, 6)+"/"+dataInicial.substring(6, 8)+" "+dataInicial.substring(8,10)+":"+dataInicial.substring(10, 12)+":"+dataInicial.substring(12, 14)+"."+dataInicial.substring(14,17);
        String fim = dataFinal.substring(0, 4)+"/"+dataFinal.substring(4, 6)+"/"+dataFinal.substring(6, 8)+" "+dataFinal.substring(8,10)+":"+dataFinal.substring(10, 12)+":"+dataFinal.substring(12, 14)+"."+dataFinal.substring(14,17);
        
        
        int retorno[] = new int[8];
        try {
            Connection conexao = new ConnectionFactory().getConnection();
            
            for(int i=1 ;i<=8;i++){
            String sql = "select count(*)from pesquisa where topico =" +i+"  and datahora between '"+inicial+"' and '"+fim+"'";
            PreparedStatement st = conexao.prepareStatement(sql);
            
            ResultSet result = st.executeQuery();// executa
            result.next();//avança ao proximo resultado da consulta
            retorno[i-1] = result.getInt("count");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_WebService_REST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getChats_Realizados(String dataInicial, String dataFinal) {
        
        String inicial = dataInicial.substring(0, 4)+"/"+dataInicial.substring(4, 6)+"/"+dataInicial.substring(6, 8)+" "+dataInicial.substring(8,10)+":"+dataInicial.substring(10, 12)+":"+dataInicial.substring(12, 14)+"."+dataInicial.substring(14,17);
        String fim = dataFinal.substring(0, 4)+"/"+dataFinal.substring(4, 6)+"/"+dataFinal.substring(6, 8)+" "+dataFinal.substring(8,10)+":"+dataFinal.substring(10, 12)+":"+dataFinal.substring(12, 14)+"."+dataFinal.substring(14,17);
        
        
        int retorno = 0;
        try {
            Connection conexao = new ConnectionFactory().getConnection();
            
            String sql = "select count(*)from chat where datahora between '"+inicial+"' and '"+fim+"'";
            PreparedStatement st = conexao.prepareStatement(sql);
            
            ResultSet result = st.executeQuery();// executa
            result.next();//avança ao proximo resultado da consulta
            retorno = result.getInt("count");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_WebService_REST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getChats_User(String dataInicial, String dataFinal,int coduser) {
        
        String inicial = dataInicial.substring(0, 4)+"/"+dataInicial.substring(4, 6)+"/"+dataInicial.substring(6, 8)+" "+dataInicial.substring(8,10)+":"+dataInicial.substring(10, 12)+":"+dataInicial.substring(12, 14)+"."+dataInicial.substring(14,17);
        String fim = dataFinal.substring(0, 4)+"/"+dataFinal.substring(4, 6)+"/"+dataFinal.substring(6, 8)+" "+dataFinal.substring(8,10)+":"+dataFinal.substring(10, 12)+":"+dataFinal.substring(12, 14)+"."+dataFinal.substring(14,17);
        
        
        int retorno = 0;
        int user1 = 0,user2 = 0;
        try {
            Connection conexao = new ConnectionFactory().getConnection();
            
            String sql = "select count(*)from chat where codusuario1="+coduser+" and datahora between '"+inicial+"' and '"+fim+"'";
            PreparedStatement st = conexao.prepareStatement(sql);
            
            ResultSet result = st.executeQuery();// executa
            result.next();//avança ao proximo resultado da consulta
            user1 = result.getInt("count");
            
            sql = "select count(*)from chat where codusuario2="+coduser+" and datahora between '"+inicial+"' and '"+fim+"'";
            st = conexao.prepareStatement(sql);
            result = st.executeQuery();// executa
            result.next();//avança ao proximo resultado da consulta
            user2 = result.getInt("count");
            
            if(user1>0)retorno = user1;
            if(user2>0)retorno = user2;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_WebService_REST.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
