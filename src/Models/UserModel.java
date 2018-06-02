/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * Classe com o modelo de usuário
 */

public class UserModel implements Serializable{
    private static final long serialVersionUID = 5950169519310163575L;
    private int id;
    private String nome;
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    private String IPaddres;

    public UserModel(int id, String nome, String IPaddres) {
        this.id = id;
        this.nome = nome;
        this.IPaddres = IPaddres;
    }

    public UserModel() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIPaddres() {
        return IPaddres;
    }

    @Override
    public String toString() {
        return ""+id;
    }

    public void setIPaddres(String IPaddres) {
        this.IPaddres = IPaddres;
    }
}
