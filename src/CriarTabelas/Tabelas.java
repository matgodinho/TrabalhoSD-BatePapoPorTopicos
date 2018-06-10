/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CriarTabelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jdbc.ConnectionFactory;



public class Tabelas {
	Connection conexao = new ConnectionFactory().getConnection();
	public void criaTabelaUsuario(){
		String sql =    "create table usuario("
                                + "codusuario integer primary key not null,"
				+ "nome varchar(100) not null,"
                                + "senha varchar(100) not null,"
				+ "IPaddres varchar(15) not null);";
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void criaTabelaAcesso(){
		String sql =      "create table acesso("
                                + "codacesso serial,"
                                + "codusuario integer not null,"
                                + "DataHora timestamp not null,"
                                + "primary key(codacesso),"
                                + "foreign key(codusuario)references usuario);";		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        public void criaTabelaChat(){
		String sql ="create table chat("
                            +"codchat serial, codusuario1 Integer not null,"
                            +"codusuario2 Integer not null,"
                            +"DataHora Timestamp not null,"
                            +"Topico integer,"
                            +"primary key(codchat),"
                            +"foreign key(codusuario1) references usuario,"
                            +"foreign key(codusuario2) references usuario);";
        		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        public void criaTabelaPesquisa(){
		String sql =     "create table pesquisa("
                                +"idPesquisa serial,"
                                +"DataHora timestamp not null,"
                                +"Topico integer not null,"
                                +"primary key(idPesquisa));";
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        
        public void criaTabelaTopicos(){
		String sql =    "create table topicos("
                                + "codtopico integer primary key not null,"
				+ "topico varchar(100) not null);";
		
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        public void criaTabelaChatOnline(){
		String sql =  "CREATE TABLE chatonline("
                            + "idchat serial NOT NULL,"
                            + "codusuario integer NOT NULL,"
                            + "codtopico integer NOT NULL,"
                            + "PRIMARY KEY (idchat),"
                            + "FOREIGN KEY (codusuario)references usuario,"
                            + "FOREIGN KEY (codtopico)references topicos);";
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			
			st.execute();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        
}
